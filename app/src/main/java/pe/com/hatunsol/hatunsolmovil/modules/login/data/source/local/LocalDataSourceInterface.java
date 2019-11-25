package pe.com.hatunsol.hatunsolmovil.modules.login.data.source.local;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.services.entities.Parametro;
import pe.com.hatunsol.hatunsolmovil.services.entities.Persona;
import pe.com.hatunsol.hatunsolmovil.services.entities.ProveedorLocal;
import pe.com.hatunsol.hatunsolmovil.services.entities.SessionUser;
import pe.com.hatunsol.hatunsolmovil.services.entities.Ubigeo;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public interface LocalDataSourceInterface {

    interface  Callback<T>{
        void load(boolean state, T item);
    }

    interface  SuccessCallback{
        void load(boolean state);
    }

    boolean saveUserSession(Usuario usuario);

    boolean saveParametros(List<Parametro> parametroList);

    boolean saveUbigeo(List<Ubigeo> ubigeoList);

    boolean saveProveedorLocal(List<ProveedorLocal> proveedorLocalList);

    boolean savePersona(List<Persona> personaList);
}
