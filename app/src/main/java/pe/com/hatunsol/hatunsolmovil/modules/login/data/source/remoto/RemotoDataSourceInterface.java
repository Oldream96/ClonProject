package pe.com.hatunsol.hatunsolmovil.modules.login.data.source.remoto;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.modules.login.domain.usecase.SavePersonas;
import pe.com.hatunsol.hatunsolmovil.services.entities.Parametro;
import pe.com.hatunsol.hatunsolmovil.services.entities.Persona;
import pe.com.hatunsol.hatunsolmovil.services.entities.ProveedorLocal;
import pe.com.hatunsol.hatunsolmovil.services.entities.Ubigeo;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public interface RemotoDataSourceInterface {

    interface  Callback<T>{
        void load(boolean state, T item);
    }

    void loginUser(String user, String password, Callback<Usuario> callback);

    void sincronizeDataUbigeo(Callback<List<Ubigeo>> listCallback);

    void sincronizarDataParametro(Callback<List<Parametro>> listCallback);

//    void sincronizarDataProvedorLocal(int cargoId, int usuarioId, Callback<List<ProveedorLocal>> callback);

    void sincronizarDataPersonas(Usuario usuario, Callback<List<Persona>> callback);

}
