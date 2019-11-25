package pe.com.hatunsol.hatunsolmovil.modules.login.data.source.local;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.lib.AppDatabase;
import pe.com.hatunsol.hatunsolmovil.services.entities.Parametro;
import pe.com.hatunsol.hatunsolmovil.services.entities.Persona;
import pe.com.hatunsol.hatunsolmovil.services.entities.ProveedorLocal;
import pe.com.hatunsol.hatunsolmovil.services.entities.SessionUser;
import pe.com.hatunsol.hatunsolmovil.services.entities.Ubigeo;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;
import pe.com.hatunsol.hatunsolmovil.util.UtilTransaccion;

public class LoginLocalDataSource implements LocalDataSourceInterface {

    public LoginLocalDataSource() {
    }

    @Override
    public boolean saveUserSession(Usuario usuario) {

        SessionUser sessionUser = new SessionUser();
        sessionUser.setNombrePersona(usuario.getEmpleadoNombre());
        sessionUser.setPersonaId(usuario.getEmpleadoId());
        sessionUser.setUsuarioId(usuario.getCodigoUsuario());
        sessionUser.setState(true);
        sessionUser.setCargoId(usuario.getCargoId());
        sessionUser.setLocalId(usuario.getLocalId());
        sessionUser.setZonaId(usuario.getZonaId());
        sessionUser.setFoto(usuario.getFoto());
        sessionUser.setEmpleadoId(usuario.getEmpleadoId());
        sessionUser.save();
        usuario.save();
        return true;
    }

    @Override
    public boolean saveParametros(List<Parametro> parametroList) {
        DatabaseDefinition appDatabase = FlowManager.getDatabase(AppDatabase.class);
        DatabaseWrapper databaseWrapper = appDatabase.getWritableDatabase();
        try{
            Parametro parametro = new Parametro();
            parametro.setDominioId(38);
            parametro.setNombreCorto("Observacion");
            parametro.setNombreLargo("Observacion");
            parametro.setParametroId(15);
            parametro.save();
            databaseWrapper.beginTransaction();
            UtilTransaccion.fastStoreListSave(Parametro.class, parametroList, databaseWrapper);
            databaseWrapper.setTransactionSuccessful();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            databaseWrapper.endTransaction();
        }
    }

    @Override
    public boolean saveUbigeo(List<Ubigeo> ubigeoList) {
        DatabaseDefinition appDatabase = FlowManager.getDatabase(AppDatabase.class);
        DatabaseWrapper databaseWrapper = appDatabase.getWritableDatabase();
        try{
            databaseWrapper.beginTransaction();
            UtilTransaccion.fastStoreListSave(Ubigeo.class, ubigeoList, databaseWrapper);
            databaseWrapper.setTransactionSuccessful();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            databaseWrapper.endTransaction();
        }
    }

    @Override
    public boolean saveProveedorLocal(List<ProveedorLocal> proveedorLocalList) {
        DatabaseDefinition appDataBase = FlowManager.getDatabase(AppDatabase.class);
        DatabaseWrapper databaseWrapper = appDataBase.getWritableDatabase();
        try{
            databaseWrapper.beginTransaction();
            UtilTransaccion.fastStoreListSave(ProveedorLocal.class, proveedorLocalList, databaseWrapper);
            databaseWrapper.setTransactionSuccessful();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            databaseWrapper.endTransaction();
        }
    }

    @Override
    public boolean savePersona(List<Persona> personaList) {
        DatabaseDefinition appDataBase = FlowManager.getDatabase(AppDatabase.class);
        DatabaseWrapper databaseWrapper = appDataBase.getWritableDatabase();
        try{
            databaseWrapper.beginTransaction();
            UtilTransaccion.fastStoreListSave(Persona.class, personaList, databaseWrapper);
            databaseWrapper.setTransactionSuccessful();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            databaseWrapper.endTransaction();
        }
    }
}
