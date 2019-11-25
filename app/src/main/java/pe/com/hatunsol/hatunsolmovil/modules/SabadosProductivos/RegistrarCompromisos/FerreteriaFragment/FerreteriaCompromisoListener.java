package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.RegistrarCompromisos.FerreteriaFragment;

import android.view.View;

import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.entities.ProveedorLocalUi;

public interface FerreteriaCompromisoListener {
    void OnclickCheckDetalleCOmpromiso(ProveedorLocalUi proveedorLocalUi);

    void onChangeTextAccion(ProveedorLocalUi proveedorLocalUi);

    void onChangeTextMotivo(ProveedorLocalUi proveedorLocalUi);
}
