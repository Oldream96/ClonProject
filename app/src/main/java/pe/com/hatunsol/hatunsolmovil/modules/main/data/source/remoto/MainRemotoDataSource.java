package pe.com.hatunsol.hatunsolmovil.modules.main.data.source.remoto;

import android.util.Log;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.api.service.ApiUtils;
import pe.com.hatunsol.hatunsolmovil.api.service.Services;
import pe.com.hatunsol.hatunsolmovil.lib.AppDatabase;
import pe.com.hatunsol.hatunsolmovil.modules.main.entities.ResponseEstablecimiento;
import pe.com.hatunsol.hatunsolmovil.services.entities.ProveedorLocal;
import pe.com.hatunsol.hatunsolmovil.util.UtilTransaccion;
import retrofit2.Call;
import retrofit2.Response;

public class MainRemotoDataSource implements IMainRemotoDataSource{

    private Services services;

    public MainRemotoDataSource() {
    }


    @Override
    public void sincronizarEstablecimientos(int cargoId, int empleadoId, int localId, int filtro, int offset, Callback<Boolean> callback) {
        services = ApiUtils.getService();
        Call<List<ProveedorLocal>> call = services.obtenerEstablecimientos(cargoId, empleadoId, localId, "", filtro, offset);
        String s = call.request().toString();
        Log.d("sincronizarEstablecimi", s);
        call.enqueue(new retrofit2.Callback<List<ProveedorLocal>>() {
            @Override
            public void onResponse(Call<List<ProveedorLocal>> call, Response<List<ProveedorLocal>> response) {

                if (response!=null){
                    List<ProveedorLocal> proveedorLocal = response.body();
                    if (proveedorLocal!=null){
                        DatabaseDefinition appDatabase = FlowManager.getDatabase(AppDatabase.class);
                        DatabaseWrapper databaseWrapper = appDatabase.getWritableDatabase();
                        try{
                            databaseWrapper.beginTransaction();
                            UtilTransaccion.fastStoreListSave(ProveedorLocal.class, proveedorLocal, databaseWrapper);
                            databaseWrapper.setTransactionSuccessful();
                            callback.onLoad(true);
                        }catch (Exception e){
                            e.printStackTrace();
                            callback.onLoad(false);
                        }finally {
                            databaseWrapper.endTransaction();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ProveedorLocal>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
