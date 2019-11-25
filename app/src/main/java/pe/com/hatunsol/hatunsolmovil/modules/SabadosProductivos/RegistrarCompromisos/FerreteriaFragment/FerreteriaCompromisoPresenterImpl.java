package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.RegistrarCompromisos.FerreteriaFragment;

import android.content.res.Resources;

import pe.com.hatunsol.hatunsolmovil.base.UseCaseHandler;
import pe.com.hatunsol.hatunsolmovil.base.fragment.BaseFragmentPresenterImpl;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.domain.GetFerreteriasCompromiso;

public class FerreteriaCompromisoPresenterImpl extends BaseFragmentPresenterImpl<FerreteriaCompromisoView> implements FerreteriaCompromisoPresenter {

    private GetFerreteriasCompromiso getFerreteriasCompromiso;

    public FerreteriaCompromisoPresenterImpl(UseCaseHandler handler, Resources res, GetFerreteriasCompromiso getFerreteriasCompromiso) {
        super(handler, res);
        this.getFerreteriasCompromiso =  getFerreteriasCompromiso;
    }

    @Override
    protected String getTag() {
        return FerreteriaCompromisoPresenterImpl.class.getSimpleName();
    }
}
