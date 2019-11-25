package pe.com.hatunsol.hatunsolmovil.modules.encuestas.data.source.remoto;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.EncuestaUi;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.PreguntaUi;
import pe.com.hatunsol.hatunsolmovil.services.entities.Encuesta;

public interface IEncuestaRemotoDataSource {

    interface Callback<T> {
        void load(boolean state, T item);
    }


    void getListEncuestas(int userid, int cargoid, String nombrecomercial,int mes,int anio, Callback<List<EncuestaUi>> callback);
    void getEncuesta(int idencuesta,int idencuestausuario, Callback<Encuesta> callback);
    void Actualizar(Encuesta encuesta, Callback<Encuesta> callback);


}
