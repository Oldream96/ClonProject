package pe.com.hatunsol.hatunsolmovil.modules.encuestas.data.source.remoto;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

import java.util.ArrayList;
import java.util.List;

import pe.com.hatunsol.hatunsolmovil.api.service.ApiUtils;
import pe.com.hatunsol.hatunsolmovil.api.service.Services;
import pe.com.hatunsol.hatunsolmovil.lib.AppDatabase;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.EncuestaUi;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.PreguntaUi;
import pe.com.hatunsol.hatunsolmovil.services.entities.Encuesta;
import pe.com.hatunsol.hatunsolmovil.services.entities.Persona;
import pe.com.hatunsol.hatunsolmovil.services.entities.Pregunta;
import pe.com.hatunsol.hatunsolmovil.util.UtilTransaccion;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EncuestaRemoteDataSource implements IEncuestaRemotoDataSource {

    private Services services;


    @Override
    public void getListEncuestas(int userid, int cargoid, String nombrecomercial, int mes, int anio, Callback<List<EncuestaUi>> callback) {
        services = ApiUtils.getService();
        Call<List<Encuesta>> call = services.obtenerEncuesta(userid, cargoid, nombrecomercial, mes, anio);
        call.enqueue(new retrofit2.Callback<List<Encuesta>>() {
            @Override
            public void onResponse(Call<List<Encuesta>> call, Response<List<Encuesta>> response) {
                if (response != null) {
                    List<EncuestaUi> personaUis = new ArrayList<>();
                    List<Encuesta> personaList = response.body();
                    //setListEncuestas(personaList);
                    for (Encuesta persona : personaList) {
                        EncuestaUi personaUi = new EncuestaUi();
                        personaUi.setIdEncuesta(persona.getIdEncuesta());
                        personaUi.setIdEncuestaUsuario(persona.getIdEncuestaUsuario());
                        personaUi.setVerif_Sup(persona.getVerif_Sup());
                        personaUi.setDescripcion(persona.getDescripcion());
                        personaUi.setNombre_Encuesta(persona.getNombre_Encuesta());
                        personaUi.setFechaCrea(persona.getFechaCrea());
                        personaUi.setVerificacion(persona.getVerificacion());
                        personaUis.add(personaUi);
                    }

                    callback.load(true, personaUis);
                } else {
                    callback.load(false, null);

                }
            }

            @Override
            public void onFailure(Call<List<Encuesta>> call, Throwable t) {

            }
        });
    }

    @Override
    public void getEncuesta(int idencuesta, int idencuestausuario, Callback<Encuesta> callback) {
        services = ApiUtils.getService();
        Call<Encuesta> call = services.obtenerPreguntas(idencuesta, idencuestausuario);
        call.enqueue(new retrofit2.Callback<Encuesta>() {
            @Override
            public void onResponse(Call<Encuesta> call, Response<Encuesta> response) {
                if (response != null) {
                    Encuesta encuesta = response.body();
                    setEncuesta(encuesta);
                    callback.load(true, encuesta);
                } else {
                    callback.load(false, null);

                }
            }

            @Override
            public void onFailure(Call<Encuesta> call, Throwable t) {

            }
        });
    }

    @Override
    public void Actualizar(Encuesta encuesta, Callback<Encuesta> callback) {
        services = ApiUtils.getService();
        Call<Encuesta> call = services.Actualizar(encuesta);
        call.enqueue(new retrofit2.Callback<Encuesta>() {
            @Override
            public void onResponse(Call<Encuesta> call, Response<Encuesta> response) {
                if (response != null) {
                    Encuesta encuesta = response.body();
                    callback.load(true, encuesta);
                } else {
                    callback.load(false, null);

                }
            }

            @Override
            public void onFailure(Call<Encuesta> call, Throwable t) {
                callback.load(false, null);
            }
        });
    }


    /*public void setListEncuestas(List<Encuesta> personas) {
        DatabaseDefinition appDatabase = FlowManager.getDatabase(AppDatabase.class);
        DatabaseWrapper databaseWrapper = appDatabase.getWritableDatabase();
        try {
            databaseWrapper.beginTransaction();
            UtilTransaccion.fastStoreListSave(Encuesta.class, personas, databaseWrapper);
            databaseWrapper.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseWrapper.endTransaction();
        }
    }*/

    public void setEncuesta(Encuesta encuesta) {
       /* DatabaseDefinition appDatabase = FlowManager.getDatabase(AppDatabase.class);
        DatabaseWrapper databaseWrapper = appDatabase.getWritableDatabase();
        try {
            databaseWrapper.beginTransaction();
            UtilTransaccion.fastStoreListSave(Encuesta.class, encuesta, databaseWrapper);
            databaseWrapper.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseWrapper.endTransaction();
        }*/
    }


}
