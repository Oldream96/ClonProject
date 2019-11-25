package pe.com.hatunsol.hatunsolmovil.services.entities;


import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import pe.com.hatunsol.hatunsolmovil.lib.AppDatabase;

@Table(database = AppDatabase.class)
public class ProveedorLocal extends BaseModel {

    @PrimaryKey
    @Column
    private int ProveedorLocalId;
    @Column
    private int CodigoUsuarioModificacion;
    @Column
    private String Contacto;
    @Column
    private String Correo;
    @Column
    private String DNIRepresentante;
    @Column
    private String Direccion;
    @Column
    private String FechaActua;
    @Column
    private String FechaCrea;
    @Column
    private String FechaInicio;
    @Column
    private String FechaTermino;
    @Column
    private String Foto;
    @Column
    private int IdPlan;
    @Column
    private int IdPlanTrabajoDetalle;
    @Column
    private int IdSupervisor;
    @Column
    private boolean IndicadorActivo;
    @Column
    private int ItemId;
    @Column
    private String Latitud;
    @Column
    private int LocalId;
    @Column
    private String Longitud;


    private int EstAsistencia;

    @Column
    private boolean Marco;
    private double DistanciaInicio;
    private String Resultado;



    private String Fecha;
    @Column
    private String NombreComercial;
    @Column
    private String NombreLocal;
    @Column
    private String Observacion;
    @Column
    private int PlanTrabajo;
    @Column
    private int ProveedorId;
    @Column
    private String ProveedorNombre;
    @Column
    private String RUC;
    @Column
    private String RazonSocial;
    @Column
    private String Referencia;
    @Column
    private String Representante;
    @Column
    private String Supervisor;
    @Column
    private String Telefono;
    @Column
    private String TelefonoGeneral;
    @Column
    private int TipoLugar;
    @Column
    private int TipoOrigenId;
    @Column
    private int TipoProveedorId;
    @Column
    private String Ubigeo;
    @Column
    private int UserIdActua;
    @Column
    private int ZonaId;
    @Column
    private int sync_status;
    @Column
    private int EstadoAfiliacionId;
    @Column
    private String EstadoAfiliacionNombre;
    @Column
    private int TotalLocales;
    @Column
    private String Celular;
    @Column
    private boolean IsValid;

    @Column
    private int Totales;

    public ProveedorLocal() {
    }

    public int getTotales() {
        return Totales;
    }

    public void setTotales(int totales) {
        Totales = totales;
    }

    public int getEstAsistencia() {
        return EstAsistencia;
    }

    public void setEstAsistencia(int estAsistencia) {
        EstAsistencia = estAsistencia;
    }

    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String resultado) {
        Resultado = resultado;
    }
    public double getDistanciaInicio() {
        return DistanciaInicio;
    }

    public void setDistanciaInicio(double distanciaInicio) {
        DistanciaInicio = distanciaInicio;
    }
    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }
    public int getProveedorLocalId() {
        return ProveedorLocalId;
    }

    public void setProveedorLocalId(int proveedorLocalId) {
        ProveedorLocalId = proveedorLocalId;
    }

    public int getCodigoUsuarioModificacion() {
        return CodigoUsuarioModificacion;
    }

    public void setCodigoUsuarioModificacion(int codigoUsuarioModificacion) {
        CodigoUsuarioModificacion = codigoUsuarioModificacion;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String contacto) {
        Contacto = contacto;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getDNIRepresentante() {
        return DNIRepresentante;
    }

    public void setDNIRepresentante(String DNIRepresentante) {
        this.DNIRepresentante = DNIRepresentante;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
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

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public String getFechaTermino() {
        return FechaTermino;
    }

    public void setFechaTermino(String fechaTermino) {
        FechaTermino = fechaTermino;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public int getIdPlan() {
        return IdPlan;
    }

    public void setIdPlan(int idPlan) {
        IdPlan = idPlan;
    }

    public int getIdPlanTrabajoDetalle() {
        return IdPlanTrabajoDetalle;
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

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        ItemId = itemId;
    }

    public String getLatitud() {
        return Latitud;
    }

    public void setLatitud(String latitud) {
        Latitud = latitud;
    }

    public int getLocalId() {
        return LocalId;
    }

    public void setLocalId(int localId) {
        LocalId = localId;
    }

    public String getLongitud() {
        return Longitud;
    }

    public void setLongitud(String longitud) {
        Longitud = longitud;
    }

    public boolean isMarco() {
        return Marco;
    }

    public void setMarco(boolean marco) {
        Marco = marco;
    }

    public String getNombreComercial() {
        return NombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        NombreComercial = nombreComercial;
    }

    public String getNombreLocal() {
        return NombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        NombreLocal = nombreLocal;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String observacion) {
        Observacion = observacion;
    }

    public int getPlanTrabajo() {
        return PlanTrabajo;
    }

    public void setPlanTrabajo(int planTrabajo) {
        PlanTrabajo = planTrabajo;
    }

    public int getProveedorId() {
        return ProveedorId;
    }

    public void setProveedorId(int proveedorId) {
        ProveedorId = proveedorId;
    }

    public String getProveedorNombre() {
        return ProveedorNombre;
    }

    public void setProveedorNombre(String proveedorNombre) {
        ProveedorNombre = proveedorNombre;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        RazonSocial = razonSocial;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String referencia) {
        Referencia = referencia;
    }

    public String getRepresentante() {
        return Representante;
    }

    public void setRepresentante(String representante) {
        Representante = representante;
    }

    public String getSupervisor() {
        return Supervisor;
    }

    public void setSupervisor(String supervisor) {
        Supervisor = supervisor;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getTelefonoGeneral() {
        return TelefonoGeneral;
    }

    public void setTelefonoGeneral(String telefonoGeneral) {
        TelefonoGeneral = telefonoGeneral;
    }

    public int getTipoLugar() {
        return TipoLugar;
    }

    public void setTipoLugar(int tipoLugar) {
        TipoLugar = tipoLugar;
    }

    public int getTipoOrigenId() {
        return TipoOrigenId;
    }

    public void setTipoOrigenId(int tipoOrigenId) {
        TipoOrigenId = tipoOrigenId;
    }

    public int getTipoProveedorId() {
        return TipoProveedorId;
    }

    public void setTipoProveedorId(int tipoProveedorId) {
        TipoProveedorId = tipoProveedorId;
    }

    public String getUbigeo() {
        return Ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        Ubigeo = ubigeo;
    }

    public int getUserIdActua() {
        return UserIdActua;
    }

    public void setUserIdActua(int userIdActua) {
        UserIdActua = userIdActua;
    }

    public int getZonaId() {
        return ZonaId;
    }

    public void setZonaId(int zonaId) {
        ZonaId = zonaId;
    }

    public int getSync_status() {
        return sync_status;
    }

    public void setSync_status(int sync_status) {
        this.sync_status = sync_status;
    }

    public int getEstadoAfiliacionId() {
        return EstadoAfiliacionId;
    }

    public void setEstadoAfiliacionId(int estadoAfiliacionId) {
        EstadoAfiliacionId = estadoAfiliacionId;
    }

    public String getEstadoAfiliacionNombre() {
        return EstadoAfiliacionNombre;
    }

    public void setEstadoAfiliacionNombre(String estadoAfiliacionNombre) {
        EstadoAfiliacionNombre = estadoAfiliacionNombre;
    }

    public int getTotalLocales() {
        return TotalLocales;
    }

    public void setTotalLocales(int totalLocales) {
        TotalLocales = totalLocales;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }

    public boolean isValid() {
        return IsValid;
    }

    public void setValid(boolean valid) {
        IsValid = valid;
    }
}
