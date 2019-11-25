package pe.com.hatunsol.hatunsolmovil.modules.encuestas.presenter;

import pe.com.hatunsol.hatunsolmovil.base.fragment.BaseFragmentPresenter;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.ui.EncuestaView;

public interface EncuestaPresenter extends BaseFragmentPresenter<EncuestaView> {
    void listarEncuesta(String texto);

    void setFecha(int mes, int anio, String texto);
}
