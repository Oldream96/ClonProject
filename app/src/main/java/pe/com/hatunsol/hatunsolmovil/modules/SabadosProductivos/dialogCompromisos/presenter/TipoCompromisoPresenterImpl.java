package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.dialogCompromisos.presenter;

import android.content.res.Resources;

import pe.com.hatunsol.hatunsolmovil.base.UseCaseHandler;
import pe.com.hatunsol.hatunsolmovil.base.fragment.BaseFragmentPresenterImpl;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.dialogCompromisos.ui.TipoCompromisoView;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.domain.GetUsuario;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public class TipoCompromisoPresenterImpl extends BaseFragmentPresenterImpl<TipoCompromisoView> implements TipoCompromisoPresenter {

    private GetUsuario getUsuario;
    private  Usuario usuario;
    public TipoCompromisoPresenterImpl(UseCaseHandler handler, Resources res, GetUsuario getUsuario) {
        super(handler, res);
        this.getUsuario = getUsuario;
    }

    @Override
    protected String getTag() {
        return null;
    }

    @Override
    public void OnClickTipoCompromiso() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        setUser();
    }

    private void setUser() {
        GetUsuario.Response response = getUsuario.execute();
        usuario = response.getUsuario();
    }
}
