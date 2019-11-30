package pe.com.hatunsol.hatunsolmovil.lib;

import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION, insertConflict = ConflictAction.REPLACE)
public class AppDatabase {
    public static  final String NAME = "Hatunsol";
    public static  final int VERSION = 6;
}
