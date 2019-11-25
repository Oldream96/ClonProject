package pe.com.hatunsol.hatunsolmovil.modules.encuestas.RevisarEncuesta.listener;

import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.EncuestaUi;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.PreguntaUi;
import pe.com.hatunsol.hatunsolmovil.services.entities.Pregunta;

public interface PreguntaListener {
    //void onClickSi(Pregunta o);
    //void onClickNo(Pregunta o);
    void onClick(Pregunta pregunta);

}
