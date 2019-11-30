package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.presenter;

import android.content.res.Resources;

import java.util.Calendar;
import java.util.Date;

import pe.com.hatunsol.hatunsolmovil.base.UseCase;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseHandler;
import pe.com.hatunsol.hatunsolmovil.base.fragment.BaseFragmentPresenterImpl;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.adapter.CompromisoAdapter;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.domain.GetCompromisos;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.ui.SabadoProductivoView;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.domain.GetUsuario;
import pe.com.hatunsol.hatunsolmovil.services.entities.SessionUser;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public class SabadoProductivoPresenterImpl extends BaseFragmentPresenterImpl<SabadoProductivoView> implements SabadoProductivoPresenter {

    private GetCompromisos getCompromisos;
    private GetUsuario getUsuario;
    private Usuario usuario2;


    public SabadoProductivoPresenterImpl(UseCaseHandler handler, Resources res, GetCompromisos getCompromisos, GetUsuario getUsuario) {
        super(handler, res);
        this.getCompromisos = getCompromisos;
        this.getUsuario = getUsuario;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setUser();
    }

    @Override
    public void onCreateView() {
        super.onCreateView();
        setGetCompromisos();
    }

    private void setUser() {
        GetUsuario.Response response = getUsuario.execute();
        usuario2 = response.getUsuario();
    }

    @Override
    protected String getTag() {
        return SabadoProductivoPresenterImpl.class.getSimpleName();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (view!=null)view.setFocusMenu();
        setGetCompromisos();

    }

    @Override
    public void setGetCompromisos() {
        //if (view != null) view.showProgressbar();
        if (view!=null)view.swiftCharge();
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        cal.setTime(date);
        handler.execute(getCompromisos, new GetCompromisos.Request(SessionUser.getCurrentUser().getEmpleadoId(), 1,1,SessionUser.getCurrentUser().getNombrePersona()), new UseCase.UseCaseCallback<GetCompromisos.Response>() {
            @Override
            public void onSuccess(GetCompromisos.Response response) {
                if (view != null) view.ShowCompromisos(response.getProveedorLocalUiList());
                if (view != null) view.showUsuario(usuario2);
                //if (view != null) view.hideProgresbar();
                if (view!=null)view.onSwiftFinish();

            }

            @Override
            public void onError() {

            }
        });
    }
}
