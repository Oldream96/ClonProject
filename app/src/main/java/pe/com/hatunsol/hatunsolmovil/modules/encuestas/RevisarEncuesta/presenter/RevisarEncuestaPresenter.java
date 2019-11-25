package pe.com.hatunsol.hatunsolmovil.modules.encuestas.RevisarEncuesta.presenter;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.base.activity.BasePresenter;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.EncuestaUi;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.ProveedorLocalUi;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.RevisarEncuesta.ui.RevisarEncuestaView;
import pe.com.hatunsol.hatunsolmovil.services.entities.Pregunta;

public interface RevisarEncuestaPresenter extends BasePresenter<RevisarEncuestaView> {
    void listarPreguntas(int idencuesta, int idencuestausuario);
    void OnClickGuardar(EncuestaUi encuestaUi);
    void onClickList(Pregunta pregunta);
    ProveedorLocalUi ObtenerEstablecimiento(String texto);


}
