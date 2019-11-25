package pe.com.hatunsol.hatunsolmovil.modules.main.data.source.remoto;

public interface IMainRemotoDataSource {

    interface Callback<T>{
        void onLoad(T item);
    }

    void sincronizarEstablecimientos(int cargoId, int empleadoId, int localId, int filtro, int offset, Callback<Boolean> callback);
}
