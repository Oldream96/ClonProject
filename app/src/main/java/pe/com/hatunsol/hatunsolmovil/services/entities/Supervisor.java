package pe.com.hatunsol.hatunsolmovil.services.entities;

import androidx.annotation.NonNull;

public class Supervisor  {
    private String ApeMaterno;
    private String ApePaterno;
    private String Celular;
    private String Correo;
    private int DivisionUnacem;
    private String FechaActua;
    private String FechaCrea;
    private String Foto;
    private int IdSupervisor;
    private int IdSupervisorRetail;
    private int LocalId;
    private String LocalNombre;
    private String Nombre;
    private int UserId;
    private int UserIdActua;
    private int UserIdCrea;
    private int ZonaId;
    private String ZonaNombre;
    private boolean esActivo;

    public String getApeMaterno() {
        return ApeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        ApeMaterno = apeMaterno;
    }

    public String getApePaterno() {
        return ApePaterno;
    }

    public void setApePaterno(String apePaterno) {
        ApePaterno = apePaterno;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public int getDivisionUnacem() {
        return DivisionUnacem;
    }

    public void setDivisionUnacem(int divisionUnacem) {
        DivisionUnacem = divisionUnacem;
    }

    public String getFechaActua() {
        return FechaActua;
    }

    public void setFechaActua(String fechaActua) {
        FechaActua = fechaActua;
    }

    public String getFechaCrea() {
        return FechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        FechaCrea = fechaCrea;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public int getIdSupervisor() {
        return IdSupervisor;
    }

    public void setIdSupervisor(int idSupervisor) {
        IdSupervisor = idSupervisor;
    }

    public int getIdSupervisorRetail() {
        return IdSupervisorRetail;
    }

    public void setIdSupervisorRetail(int idSupervisorRetail) {
        IdSupervisorRetail = idSupervisorRetail;
    }

    public int getLocalId() {
        return LocalId;
    }

    public void setLocalId(int localId) {
        LocalId = localId;
    }

    public String getLocalNombre() {
        return LocalNombre;
    }

    public void setLocalNombre(String localNombre) {
        LocalNombre = localNombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getUserIdActua() {
        return UserIdActua;
    }

    public void setUserIdActua(int userIdActua) {
        UserIdActua = userIdActua;
    }

    public int getUserIdCrea() {
        return UserIdCrea;
    }

    public void setUserIdCrea(int userIdCrea) {
        UserIdCrea = userIdCrea;
    }

    public int getZonaId() {
        return ZonaId;
    }

    public void setZonaId(int zonaId) {
        ZonaId = zonaId;
    }

    public String getZonaNombre() {
        return ZonaNombre;
    }

    public void setZonaNombre(String zonaNombre) {
        ZonaNombre = zonaNombre;
    }

    public boolean isEsActivo() {
        return esActivo;
    }

    public void setEsActivo(boolean esActivo) {
        this.esActivo = esActivo;
    }

    public Supervisor() {
    }

    public Supervisor(String apeMaterno, String apePaterno, String celular, String correo, int divisionUnacem, String fechaActua, String fechaCrea, String foto, int idSupervisor, int idSupervisorRetail, int localId, String localNombre, String nombre, int userId, int userIdActua, int userIdCrea, int zonaId, String zonaNombre, boolean esActivo) {
        ApeMaterno = apeMaterno;
        ApePaterno = apePaterno;
        Celular = celular;
        Correo = correo;
        DivisionUnacem = divisionUnacem;
        FechaActua = fechaActua;
        FechaCrea = fechaCrea;
        Foto = foto;
        IdSupervisor = idSupervisor;
        IdSupervisorRetail = idSupervisorRetail;
        LocalId = localId;
        LocalNombre = localNombre;
        Nombre = nombre;
        UserId = userId;
        UserIdActua = userIdActua;
        UserIdCrea = userIdCrea;
        ZonaId = zonaId;
        ZonaNombre = zonaNombre;
        this.esActivo = esActivo;
    }

    public Supervisor(int idSupervisor, String nombre,int userid) {
        IdSupervisor = idSupervisor;
        Nombre = nombre;
        UserId=userid;
    }

    public Supervisor(int idSupervisor, String nombre) {
        IdSupervisor = idSupervisor;
        Nombre = nombre;
    }

    @NonNull
    @Override
    public String toString() {
        return Nombre;
    }
}
