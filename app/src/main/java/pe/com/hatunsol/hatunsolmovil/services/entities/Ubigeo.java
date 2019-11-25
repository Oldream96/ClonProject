package pe.com.hatunsol.hatunsolmovil.services.entities;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import pe.com.hatunsol.hatunsolmovil.lib.AppDatabase;

@Table(database = AppDatabase.class)
public class Ubigeo extends BaseModel {

    @Column
    private String CodDist;
    @Column
    private String CodDpto;
    @Column
    private String CodProv;
    @PrimaryKey
    @Column
    private String CodUbigeo;
    @Column
    private int IdSupervisor;
    @Column
    private int LocalId;
    @Column
    private int ZonaId;
    @Column
    private String Nombre;

    public Ubigeo() {
    }

    public String getCodDist() {
        return CodDist;
    }

    public void setCodDist(String codDist) {
        CodDist = codDist;
    }

    public String getCodDpto() {
        return CodDpto;
    }

    public void setCodDpto(String codDpto) {
        CodDpto = codDpto;
    }

    public String getCodProv() {
        return CodProv;
    }

    public void setCodProv(String codProv) {
        CodProv = codProv;
    }

    public String getCodUbigeo() {
        return CodUbigeo;
    }

    public void setCodUbigeo(String codUbigeo) {
        CodUbigeo = codUbigeo;
    }

    public int getIdSupervisor() {
        return IdSupervisor;
    }

    public void setIdSupervisor(int idSupervisor) {
        IdSupervisor = idSupervisor;
    }

    public int getLocalId() {
        return LocalId;
    }

    public void setLocalId(int localId) {
        LocalId = localId;
    }

    public int getZonaId() {
        return ZonaId;
    }

    public void setZonaId(int zonaId) {
        ZonaId = zonaId;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
