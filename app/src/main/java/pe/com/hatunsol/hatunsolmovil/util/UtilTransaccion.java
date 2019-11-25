package pe.com.hatunsol.hatunsolmovil.util;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.FastStoreModelTransaction;

import java.util.List;

public class UtilTransaccion {

    public static  <P extends BaseModel> void fastStoreListSave(final Class<P> clazz, List<P> list, DatabaseWrapper database) {
        FastStoreModelTransaction
                .saveBuilder(FlowManager.getModelAdapter(clazz))
                .addAll(list)
                .build()
                .execute(database);
    }
}
