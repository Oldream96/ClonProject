package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.local;

import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public interface SPLocalDataSourceInterface {
    interface Callback<T>{
        void load(boolean state, T item);
    }

    Usuario getUsuario();
}
