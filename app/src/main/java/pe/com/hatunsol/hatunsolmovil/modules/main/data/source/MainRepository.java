package pe.com.hatunsol.hatunsolmovil.modules.main.data.source;

import pe.com.hatunsol.hatunsolmovil.modules.main.data.source.local.IMainLocalDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.main.data.source.local.MainLocalDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.main.data.source.remoto.IMainRemotoDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.main.data.source.remoto.MainRemotoDataSource;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public class MainRepository implements IMainRemotoDataSource, IMainLocalDataSource {

    private MainRemotoDataSource remotoDataSource;
    private MainLocalDataSource localDataSource;

    public MainRepository(MainRemotoDataSource remotoDataSource, MainLocalDataSource localDataSource) {
        this.remotoDataSource = remotoDataSource;
        this.localDataSource = localDataSource;
    }


    @Override
    public void sincronizarEstablecimientos(int cargoId, int empleadoId, int localId, int filtro, int offset, Callback<Boolean> callback) {
        remotoDataSource.sincronizarEstablecimientos(cargoId, empleadoId, localId, filtro, offset, callback);
    }

    @Override
    public Usuario getUser() {
        return localDataSource.getUser();
    }

    @Override
    public Boolean DeleteUser() {
        return localDataSource.DeleteUser();
    }
}
