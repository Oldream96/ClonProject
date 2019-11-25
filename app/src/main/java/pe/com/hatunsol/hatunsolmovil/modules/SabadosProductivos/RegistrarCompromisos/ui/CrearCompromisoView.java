package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.RegistrarCompromisos.ui;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.base.activity.BaseView;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.RegistrarCompromisos.presenter.CrearCompromisoPresenter;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.entities.ProveedorLocalUi;

public interface CrearCompromisoView extends BaseView<CrearCompromisoPresenter> {

    void showFerreterias (List<ProveedorLocalUi> proveedorLocalUiList);

    void showProgressbar();
    void hideProgressbar();
    void TraerFechaConsulta(String fechaconsulta);

    void Regresar(String Mensaje);

    void OnErrorRegresar(String Mensaje);
}
