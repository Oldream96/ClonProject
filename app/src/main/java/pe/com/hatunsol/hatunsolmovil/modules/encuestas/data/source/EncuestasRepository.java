package pe.com.hatunsol.hatunsolmovil.modules.encuestas.data.source;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.modules.encuestas.data.source.local.EncuestasLocalDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.data.source.local.IEncuestasLocalDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.data.source.remoto.EncuestaRemoteDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.data.source.remoto.IEncuestaRemotoDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.EncuestaUi;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.ProveedorLocalUi;
import pe.com.hatunsol.hatunsolmovil.services.entities.Encuesta;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public class EncuestasRepository implements IEncuestaRemotoDataSource, IEncuestasLocalDataSource {
    private EncuestasLocalDataSource localDataSource;
    private EncuestaRemoteDataSource remoteDataSource;

    public EncuestasRepository(EncuestaRemoteDataSource remoteDataSource, EncuestasLocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }


    @Override
    public void getListEncuestas(int userid, int cargoid, String nombrecomercial, int mes, int anio, IEncuestaRemotoDataSource.Callback<List<EncuestaUi>> callback) {
        remoteDataSource.getListEncuestas(userid, cargoid, nombrecomercial, mes, anio, callback);
    }

    @Override
    public void getEncuesta(int idencuesta, int idencuestausuario, IEncuestaRemotoDataSource.Callback<Encuesta> callback) {
        remoteDataSource.getEncuesta(idencuesta, idencuestausuario, callback);
    }

    @Override
    public void Actualizar(Encuesta encuesta, IEncuestaRemotoDataSource.Callback<Encuesta> callback) {
        remoteDataSource.Actualizar(encuesta, callback);
    }


    @Override
    public Usuario getUsuario() {
        return localDataSource.getUsuario();
    }

    @Override
    public List<ProveedorLocalUi> getEstablecimientos() {
        return localDataSource.getEstablecimientos();
    }


}
