package pe.com.hatunsol.hatunsolmovil.modules.encuestas.presenter;

import android.content.res.Resources;

import java.util.Date;

import pe.com.hatunsol.hatunsolmovil.base.UseCase;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseHandler;
import pe.com.hatunsol.hatunsolmovil.base.fragment.BaseFragmentPresenterImpl;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.domain.usecase.GetListEncuestas;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.domain.usecase.GetUsuario;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.ui.EncuestaView;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public class EncuestaPrenserImpl extends BaseFragmentPresenterImpl<EncuestaView> implements EncuestaPresenter {

    private GetListEncuestas getListEncuesta;
    private Usuario usuario;
    private GetUsuario getUsuario;
    int Anio = new Date().getYear() + 1900;
    int Mes = new Date().getMonth()+1;

    public EncuestaPrenserImpl(UseCaseHandler handler, Resources res, GetListEncuestas getListEncuesta, GetUsuario getUsuario) {
        super(handler, res);
        this.getListEncuesta = getListEncuesta;
        this.getUsuario = getUsuario;
    }

    private void setUser() {
        GetUsuario.Response response = getUsuario.execute();
        usuario = response.getUsuario();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setUser();
    }

    @Override
    public void onCreateView() {
        super.onCreateView();
        listarEncuesta("");
    }

    @Override
    public void onResume() {
        super.onResume();
        if (view!=null)view.setFocusMenu();
    }

    @Override
    protected String getTag() {
        return EncuestaPrenserImpl.class.getSimpleName();
    }


    @Override
    public void listarEncuesta(String texto) {
        if (view != null) view.showProgressbar();
        handler.execute(getListEncuesta, new GetListEncuestas.RequestValues(usuario.getCodigoUsuario(), usuario.getCargoId(), texto, Mes, Anio), new UseCase.UseCaseCallback<GetListEncuestas.Response>() {
            @Override
            public void onSuccess(GetListEncuestas.Response response) {
                if (view != null) view.showEncuestaList(response.getEncuestaUiList());
                if (view != null) view.hideProgresbar();
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void setFecha(int mes, int anio, String texto) {
        this.Anio = anio;
        this.Mes = mes;
        listarEncuesta(texto);
    }


}
