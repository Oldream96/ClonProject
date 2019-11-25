package pe.com.hatunsol.hatunsolmovil.services.entities;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import androidx.annotation.NonNull;
import pe.com.hatunsol.hatunsolmovil.lib.AppDatabase;

@Table(database = AppDatabase.class)
public class Parametro extends BaseModel {
    @PrimaryKey
    @Column
    private int DominioId;
    @Column
    private String NombreCorto;
    @Column
    private String NombreLargo;
    @PrimaryKey
    @Column
    private int ParametroId;

    public Parametro() {
    }

    public int getDominioId() {
        return DominioId;
    }

    public void setDominioId(int dominioId) {
        DominioId = dominioId;
    }

    public String getNombreCorto() {
        return NombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        NombreCorto = nombreCorto;
    }

    public String getNombreLargo() {
        return NombreLargo;
    }

    public void setNombreLargo(String nombreLargo) {
        NombreLargo = nombreLargo;
    }

    public int getParametroId() {
        return ParametroId;
    }

    public void setParametroId(int parametroId) {
        ParametroId = parametroId;
    }

    public Parametro(int parametroId, String nombreLargo) {
        ParametroId = parametroId;
        NombreCorto = nombreLargo;
    }

    @NonNull
    @Override
    public String toString() {
        return NombreCorto;
    }
}
