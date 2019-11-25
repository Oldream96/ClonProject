package pe.com.hatunsol.hatunsolmovil.modules.main.data.source.local;

import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public interface IMainLocalDataSource {

    Usuario getUser();
    Boolean DeleteUser();
}
