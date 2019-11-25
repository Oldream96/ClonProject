package pe.com.hatunsol.hatunsolmovil.services.entities;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import pe.com.hatunsol.hatunsolmovil.lib.AppDatabase;

@Table(database = AppDatabase.class)
public class SessionUser extends BaseModel {

    @Column
    @PrimaryKey
    private int usuarioId;
    @Column
    private int personaId;
    @Column
    private String nombrePersona;
    @Column
    private boolean state;
    @Column
    private int localId;
    @Column
    private int zonaId;
    @Column
    private int cargoId;
    @Column int empleadoId;

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Column
    private String foto;

    public SessionUser() {
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }



    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }



    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }

    public int getZonaId() {
        return zonaId;
    }

    public void setZonaId(int zonaId) {
        this.zonaId = zonaId;
    }

    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    public static SessionUser getCurrentUser() {
        SessionUser sessionUser = null;
        try {
            sessionUser = SQLite.select()
                    .from(SessionUser.class)
                    .where(SessionUser_Table.state.is(true))
                    .querySingle();
        }catch (Exception e){
            e.printStackTrace();
        }
        return sessionUser;
    }
}
