package pe.com.hatunsol.hatunsolmovil.modules.encuestas.data.source.local;

import java.util.List;


import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.ProveedorLocalUi;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public interface IEncuestasLocalDataSource {
    interface Callback<T>{
        void load(boolean state, T item);
    }

    Usuario getUsuario();

    List<ProveedorLocalUi> getEstablecimientos();
}
