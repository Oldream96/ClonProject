package pe.com.hatunsol.hatunsolmovil.modules.login.data.source;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.modules.login.data.source.local.LocalDataSourceInterface;
import pe.com.hatunsol.hatunsolmovil.modules.login.data.source.local.LoginLocalDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.login.data.source.remoto.LoginRemotoDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.login.data.source.remoto.RemotoDataSourceInterface;
import pe.com.hatunsol.hatunsolmovil.services.entities.Parametro;
import pe.com.hatunsol.hatunsolmovil.services.entities.Persona;
import pe.com.hatunsol.hatunsolmovil.services.entities.ProveedorLocal;
import pe.com.hatunsol.hatunsolmovil.services.entities.SessionUser;
import pe.com.hatunsol.hatunsolmovil.services.entities.Ubigeo;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public class LoginRepository implements RemotoDataSourceInterface, LocalDataSourceInterface {

    private LoginRemotoDataSource remotoDataSource;
    private LoginLocalDataSource localDataSource;

    public LoginRepository(LoginRemotoDataSource remotoDataSource, LoginLocalDataSource localDataSource) {
        this.remotoDataSource = remotoDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public void loginUser(String user, String password, RemotoDataSourceInterface.Callback<Usuario> callback) {
        remotoDataSource.loginUser(user, password, callback);
    }

    @Override
    public void sincronizeDataUbigeo(RemotoDataSourceInterface.Callback<List<Ubigeo>> listCallback) {
        remotoDataSource.sincronizeDataUbigeo(listCallback);
    }

    @Override
    public void sincronizarDataParametro(RemotoDataSourceInterface.Callback<List<Parametro>> listCallback) {
        remotoDataSource.sincronizarDataParametro(listCallback);
    }

//    @Override
//    public void sincronizarDataProvedorLocal(int cargoId, int usuarioId, RemotoDataSourceInterface.Callback<List<ProveedorLocal>> callback) {
//        remotoDataSource.sincronizarDataProvedorLocal(cargoId, usuarioId, callback);
//    }

    @Override
    public void sincronizarDataPersonas(Usuario usuario, RemotoDataSourceInterface.Callback<List<Persona>> callback) {
        remotoDataSource.sincronizarDataPersonas(usuario, callback);
    }

    @Override
    public boolean saveUserSession(Usuario usuario) {
       return localDataSource.saveUserSession(usuario);
    }

    @Override
    public boolean saveParametros(List<Parametro> parametroList) {
        return localDataSource.saveParametros(parametroList);
    }

    @Override
    public boolean saveUbigeo(List<Ubigeo> ubigeoList) {
        return localDataSource.saveUbigeo(ubigeoList);
    }

    @Override
    public boolean saveProveedorLocal(List<ProveedorLocal> proveedorLocalList) {
        return localDataSource.saveProveedorLocal(proveedorLocalList);
    }

    @Override
    public boolean savePersona(List<Persona> personaList) {
        return localDataSource.savePersona(personaList);
    }
}
