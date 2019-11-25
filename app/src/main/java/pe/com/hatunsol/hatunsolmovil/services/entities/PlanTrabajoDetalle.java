package pe.com.hatunsol.hatunsolmovil.services.entities;

import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import pe.com.hatunsol.hatunsolmovil.lib.AppDatabase;


public class PlanTrabajoDetalle  {

    private int CargoId;
    private double DistanciaInicio;
    private String DocumentoNum;
    private int EstAsistencia;
    private String FechaInicio;
    private String FechaTermino = null;
    private String FechaVisita;
    private int FlagZonal;
    private int IdPlan;
    private int IdPlanTrabajoDetalle;
    private int IdSupervisor;
    private int ItemId;
    private String Justificacion = null;
    private String Latitud;
    private String Longitud;
    private int ProveedorLocalId;
    private String RazonSocial;
    private String Resultado;
    private int TipoLugar;
    private int UserId;
    private int UserIdCrea;
    private boolean Visita;
    private String strFecha;
    private String strFechaInicio;
    private String strFechaTermino;


    // Getter Methods

    public int getCargoId() {
        return CargoId;
    }

    public double getDistanciaInicio() {
        return DistanciaInicio;
    }

    public String getDocumentoNum() {
        return DocumentoNum;
    }

    public int getEstAsistencia() {
        return EstAsistencia;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public String getFechaTermino() {
        return FechaTermino;
    }

    public String getFechaVisita() {
        return FechaVisita;
    }

    public int getFlagZonal() {
        return FlagZonal;
    }

    public int getIdPlan() {
        return IdPlan;
    }

    public int getIdPlanTrabajoDetalle() {
        return IdPlanTrabajoDetalle;
    }

    public int getIdSupervisor() {
        return IdSupervisor;
    }

    public int getItemId() {
        return ItemId;
    }

    public String getJustificacion() {
        return Justificacion;
    }

    public String getLatitud() {
        return Latitud;
    }

    public String getLongitud() {
        return Longitud;
    }

    public int getProveedorLocalId() {
        return ProveedorLocalId;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public String getResultado() {
        return Resultado;
    }

    public int getTipoLugar() {
        return TipoLugar;
    }

    public int getUserId() {
        return UserId;
    }

    public int getUserIdCrea() {
        return UserIdCrea;
    }

    public boolean getVisita() {
        return Visita;
    }

    public String getStrFecha() {
        return strFecha;
    }

    public String getStrFechaInicio() {
        return strFechaInicio;
    }

    public String getStrFechaTermino() {
        return strFechaTermino;
    }

    // Setter Methods

    public void setCargoId(int CargoId) {
        this.CargoId = CargoId;
    }

    public void setDistanciaInicio(int DistanciaInicio) {
        this.DistanciaInicio = DistanciaInicio;
    }

    public void setDocumentoNum(String DocumentoNum) {
        this.DocumentoNum = DocumentoNum;
    }

    public void setEstAsistencia(int EstAsistencia) {
        this.EstAsistencia = EstAsistencia;
    }

    public void setFechaInicio(String FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public void setFechaTermino(String FechaTermino) {
        this.FechaTermino = FechaTermino;
    }

    public void setFechaVisita(String FechaVisita) {
        this.FechaVisita = FechaVisita;
    }

    public void setFlagZonal(int FlagZonal) {
        this.FlagZonal = FlagZonal;
    }

    public void setIdPlan(int IdPlan) {
        this.IdPlan = IdPlan;
    }

    public void setIdPlanTrabajoDetalle(int IdPlanTrabajoDetalle) {
        this.IdPlanTrabajoDetalle = IdPlanTrabajoDetalle;
    }

    public void setIdSupervisor(int IdSupervisor) {
        this.IdSupervisor = IdSupervisor;
    }

    public void setItemId(int ItemId) {
        this.ItemId = ItemId;
    }

    public void setJustificacion(String Justificacion) {
        this.Justificacion = Justificacion;
    }

    public void setLatitud(String Latitud) {
        this.Latitud = Latitud;
    }

    public void setLongitud(String Longitud) {
        this.Longitud = Longitud;
    }

    public void setProveedorLocalId(int ProveedorLocalId) {
        this.ProveedorLocalId = ProveedorLocalId;
    }

    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    public void setResultado(String Resultado) {
        this.Resultado = Resultado;
    }

    public void setTipoLugar(int TipoLugar) {
        this.TipoLugar = TipoLugar;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public void setUserIdCrea(int UserIdCrea) {
        this.UserIdCrea = UserIdCrea;
    }

    public void setVisita(boolean Visita) {
        this.Visita = Visita;
    }

    public void setStrFecha(String strFecha) {
        this.strFecha = strFecha;
    }

    public void setStrFechaInicio(String strFechaInicio) {
        this.strFechaInicio = strFechaInicio;
    }

    public void setStrFechaTermino(String strFechaTermino) {
        this.strFechaTermino = strFechaTermino;
    }

}
