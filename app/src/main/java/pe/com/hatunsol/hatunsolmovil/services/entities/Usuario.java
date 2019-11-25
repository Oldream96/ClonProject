package pe.com.hatunsol.hatunsolmovil.services.entities;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import pe.com.hatunsol.hatunsolmovil.lib.AppDatabase;

@Table(database = AppDatabase.class)
public class Usuario extends BaseModel {

    public static final int ACCESS=0, PASSWORD_FAIL=1, USER_FAIL=2, SERVICE_FAIL=3, DNI_NULL=4;
    @Column
    @PrimaryKey
    private int CodigoUsuario;
    @Column
    private int CargoId;
    @Column
    private String CargoNombre;
    @Column
    private String DNI;
    @Column
    private int EmpleadoId;
    @Column
    private String EmpleadoNombre;
    @Column
    private String FechaInicio;
    @Column
    private int IdPlanTrabajoDetalle;
    @Column
    private int IdSupervisor;
    @Column
    private boolean IndicadorActivo;
    @Column
    private boolean IsEmpleado;
    @Column
    private int LocalId;
    @Column
    private String Login;
    @Column
    private String NombreComercial;
    @Column
    private String Password;
    @Column
    private int ProveedorLocalId;
    @Column
    private int ZonaId;
    @Column
    private int tipoId;
    @Column
    private String Foto;


    public Usuario() {
    }

    public int getCargoId() {
        return CargoId;
    }

    public void setCargoId(int cargoId) {
        CargoId = cargoId;
    }

    public int getTipoId() {
        return tipoId;
    }

    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
    }



    public String getCargoNombre() {
        return CargoNombre;
    }

    public int getCodigoUsuario() {
        return CodigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        CodigoUsuario = codigoUsuario;
    }

    public void setCargoNombre(String cargoNombre) {
        CargoNombre = cargoNombre;
    }



    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getEmpleadoId() {
        return EmpleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        EmpleadoId = empleadoId;
    }

    public String getEmpleadoNombre() {
        return EmpleadoNombre;
    }

    public void setEmpleadoNombre(String empleadoNombre) {
        EmpleadoNombre = empleadoNombre;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public int getIdPlanTrabajoDetalle() {
        return IdPlanTrabajoDetalle;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        this.Foto = foto;
    }

    public void setIdPlanTrabajoDetalle(int idPlanTrabajoDetalle) {
        IdPlanTrabajoDetalle = idPlanTrabajoDetalle;
    }

    public int getIdSupervisor() {
        return IdSupervisor;
    }

    public void setIdSupervisor(int idSupervisor) {
        IdSupervisor = idSupervisor;
    }

    public boolean isIndicadorActivo() {
        return IndicadorActivo;
    }

    public void setIndicadorActivo(boolean indicadorActivo) {
        IndicadorActivo = indicadorActivo;
    }

    public boolean isEmpleado() {
        return IsEmpleado;
    }

    public void setEmpleado(boolean empleado) {
        IsEmpleado = empleado;
    }

    public int getLocalId() {
        return LocalId;
    }

    public void setLocalId(int localId) {
        LocalId = localId;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getNombreComercial() {
        return NombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        NombreComercial = nombreComercial;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getProveedorLocalId() {
        return ProveedorLocalId;
    }

    public void setProveedorLocalId(int proveedorLocalId) {
        ProveedorLocalId = proveedorLocalId;
    }

    public int getZonaId() {
        return ZonaId;
    }

    public void setZonaId(int zonaId) {
        ZonaId = zonaId;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "CodigoUsuario=" + CodigoUsuario +
                ", CargoId=" + CargoId +
                ", CargoNombre='" + CargoNombre + '\'' +
                ", DNI=" + DNI +
                ", EmpleadoId=" + EmpleadoId +
                ", EmpleadoNombre='" + EmpleadoNombre + '\'' +
                ", FechaInicio='" + FechaInicio + '\'' +
                ", IdPlanTrabajoDetalle=" + IdPlanTrabajoDetalle +
                ", IdSupervisor=" + IdSupervisor +
                ", Foto=" + Foto +
                '}';
    }
}
