package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.RegistrarCompromisos.presenter;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.base.activity.BasePresenter;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.RegistrarCompromisos.ui.CrearCompromisoView;
import pe.com.hatunsol.hatunsolmovil.services.entities.Persona;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public interface CrearCompromisoPresenter extends BasePresenter<CrearCompromisoView> {
    void onClickButtonGuardar();
    String traerFechaConsulta();
    void onSaveDetalleCompromiso(List<Persona> personaList, Integer tipoCompromiso);
}
