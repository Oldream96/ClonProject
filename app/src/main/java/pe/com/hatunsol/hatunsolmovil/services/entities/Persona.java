package pe.com.hatunsol.hatunsolmovil.services.entities;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import pe.com.hatunsol.hatunsolmovil.lib.AppDatabase;

@Table(database = AppDatabase.class)
public class Persona extends BaseModel implements Serializable, Comparable<Persona>{




    public enum ESTADO{PROPIO, PERSONA, SUPERVISOR, NUEVO, ZONAL}
    @PrimaryKey
    @Column
    private String DocumentoNum;
    @Column
    private String Accion;
    @Column
    private String ApeMaterno;
    @Column
    private String ApePaterno;
    @Column
    private String AsesorNombre;
    @Column
    private String Banco;
    @Column
    private int BancoId;
    @Column
    private int Canal;
    @Column
    private String Cargo;
    @Column
    private int CargoId;
    @Column
    private int CasaPropia;
    @Column
    private String Celular;
    @Column
    private String Celular2;
    @Column
    private String CentroTrabajo;
    @Column
    private int CodExpedienteCredito;
    @Column
    private int CodPersona;
    @Column
    private int CodigoUsuarioCreacion;
    @Column
    private String Correo;
    @Column
    private int CuotaNumero;
    @Column
    private int DatosDireccionId=0;
    @Column
    private int DatosLaboralesId;
    @Column
    private String Direccion;
    @Column
    private String Distrito;
    @Column
    private boolean EnObservacion;
    @Column
    private int EstadoCivilId;
    @Column
    private int EstadoProcesoId;
    @Column
    private String EstadoProcesoNombre;
    @Column
    private int EstadoUrgencia;
    @Column
    private int ExpedienteCreditoId;
    @Column
    private String FechaActua;
    @Column
    private String FechaCreacion;
    @Column
    private String FechaIngresoLaboral;
    @Column
    private String FechaNacimiento;
    @Column
    private int FormalidadTrabajoId;
    @Column
    private String Horario;
    @Column
    private int IdAgencia;
    @Column
    private int IdAsesorBanco;
    @Column
    private int IdOficina;
    @Column
    private int IdProveedorLocalJusti;
    @Column
    private int IdSupervisor;
    @Column
    private int IdVendedor;
    @Column
    private int IdVentaEstablecimiento;
    @Column
    private String IngresoNeto;
    @Column
    private int LocalId;
    @Column
    private int MonitorId;
    @Column
    private int MontoEfectivoPro=0;
    @Column
    private int MontoMaterialPro=0;
    @Column
    private int MotivoRechazoId;
    @Column
    private String Nombre;
    @Column
    private String NombreCompleto;
    @Column
    private Integer NumeroHijos;
    @Column
    private String Obra;
    @Column
    private String Observacion;
    @Column
    private String Oficina;
    @Column
    private int PersonaId;
    @Column
    private String Proceso;
    @Column
    private int ProveedorLocalId;
    @Column
    private String Razon;
    @Column
    private String Referencia;
    @Column
    private String Ruc;
    @Column
    private int SexoId;
    @Column
    private int SolicitudId;
    @Column
    private String Supervisor;
    @Column
    private int SustentoIngresoId;
    @Column
    private String Telefonos;
    @Column
    private String TipoEstablecimientoNombre;
    @Column
    private int TipoPersonaId;
    @Column
    private int TipoPuestoId;
    @Column
    private int TipoRechazoId;
    @Column
    private int TipoTrabajoId;
    @Column
    private int TitularId;
    @Column
    private String Ubigeo;
    @Column
    private String UserPassword;
    @Column
    private int ZonaId;
    @Column
    private int sync_status;
    @Column
    private String nombreFerreteria;
    @Column
    private String GiroNegocio;
    @Column
    private int EstadoExpediente;
    @Column
    private int GradoInstruccionId;
    private int ResultadoId;

    private List<ProveedorLocal> ListaFerreterias;
    private List<ExpedienteCreditoDetalle> ListaExpedienteCreditoDetalle;
    private int DerivadoAntes;
    private boolean EsActivoProveedorLocal;


    public int getResultadoId() {
        return ResultadoId;
    }

    public void setResultadoId(int resultadoId) {
        ResultadoId = resultadoId;
    }

    public ESTADO getEstado() {
        return estado;
    }

    public void setEstado(ESTADO estado) {
        this.estado = estado;
    }

    private ESTADO estado;

    public Persona() {
    }

    public String getGiroNegocio() {
        return GiroNegocio;
    }

    public int getEstadoExpediente() {
        return EstadoExpediente;
    }

    public void setEstadoExpediente(int estadoExpediente) {
        EstadoExpediente = estadoExpediente;
    }

    public boolean isEsActivoProveedorLocal() {
        return EsActivoProveedorLocal;
    }

    public void setGiroNegocio(String GiroNegocio) {
        this.GiroNegocio = GiroNegocio;
    }

    public String getDocumentoNum() {
        return DocumentoNum;
    }

    public void setDocumentoNum(String documentoNum) {
        DocumentoNum = documentoNum;
    }

    public String getAccion() {
        return Accion;
    }

    public void setAccion(String accion) {
        Accion = accion;
    }

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

    public String getAsesorNombre() {
        return AsesorNombre;
    }

    public void setAsesorNombre(String asesorNombre) {
        AsesorNombre = asesorNombre;
    }

    public String getBanco() {
        return Banco;
    }

    public void setBanco(String banco) {
        Banco = banco;
    }

    public int getBancoId() {
        return BancoId;
    }

    public void setBancoId(int bancoId) {
        BancoId = bancoId;
    }

    public int getCanal() {
        return Canal;
    }

    public void setCanal(int canal) {
        Canal = canal;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public int getCargoId() {
        return CargoId;
    }

    public void setCargoId(int cargoId) {
        CargoId = cargoId;
    }

    public int getCasaPropia() {
        return CasaPropia;
    }

    public void setCasaPropia(int casaPropia) {
        CasaPropia = casaPropia;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }

    public String getCelular2() {
        return Celular2;
    }

    public void setCelular2(String celular2) {
        Celular2 = celular2;
    }

    public String getCentroTrabajo() {
        return CentroTrabajo;
    }

    public void setCentroTrabajo(String centroTrabajo) {
        CentroTrabajo = centroTrabajo;
    }

    public int getCodExpedienteCredito() {
        return CodExpedienteCredito;
    }

    public void setCodExpedienteCredito(int codExpedienteCredito) {
        CodExpedienteCredito = codExpedienteCredito;
    }

    public int getCodPersona() {
        return CodPersona;
    }

    public void setCodPersona(int codPersona) {
        CodPersona = codPersona;
    }

    public int getCodigoUsuarioCreacion() {
        return CodigoUsuarioCreacion;
    }

    public void setCodigoUsuarioCreacion(int codigoUsuarioCreacion) {
        CodigoUsuarioCreacion = codigoUsuarioCreacion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public int getCuotaNumero() {
        return CuotaNumero;
    }

    public void setCuotaNumero(int cuotaNumero) {
        CuotaNumero = cuotaNumero;
    }

    public int getDatosDireccionId() {
        return DatosDireccionId;
    }

    public void setDatosDireccionId(int datosDireccionId) {
        DatosDireccionId = datosDireccionId;
    }

    public int getDatosLaboralesId() {
        return DatosLaboralesId;
    }

    public void setDatosLaboralesId(int datosLaboralesId) {
        DatosLaboralesId = datosLaboralesId;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getDistrito() {
        return Distrito;
    }

    public void setDistrito(String distrito) {
        Distrito = distrito;
    }

    public boolean isEnObservacion() {
        return EnObservacion;
    }

    public void setEnObservacion(boolean enObservacion) {
        EnObservacion = enObservacion;
    }

    public int getEstadoCivilId() {
        return EstadoCivilId;
    }

    public void setEstadoCivilId(int estadoCivilId) {
        EstadoCivilId = estadoCivilId;
    }

    public int getEstadoProcesoId() {
        return EstadoProcesoId;
    }

    public void setEstadoProcesoId(int estadoProcesoId) {
        EstadoProcesoId = estadoProcesoId;
    }

    public String getEstadoProcesoNombre() {
        return EstadoProcesoNombre;
    }

    public void setEstadoProcesoNombre(String estadoProcesoNombre) {
        EstadoProcesoNombre = estadoProcesoNombre;
    }

    public int getEstadoUrgencia() {
        return EstadoUrgencia;
    }

    public void setEstadoUrgencia(int estadoUrgencia) {
        EstadoUrgencia = estadoUrgencia;
    }

    public int getExpedienteCreditoId() {
        return ExpedienteCreditoId;
    }

    public void setExpedienteCreditoId(int expedienteCreditoId) {
        ExpedienteCreditoId = expedienteCreditoId;
    }

    public String getFechaActua() {
        return FechaActua;
    }

    public void setFechaActua(String fechaActua) {
        FechaActua = fechaActua;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public String getFechaIngresoLaboral() {
        return FechaIngresoLaboral;
    }

    public void setFechaIngresoLaboral(String fechaIngresoLaboral) {
        FechaIngresoLaboral = fechaIngresoLaboral;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public int getFormalidadTrabajoId() {
        return FormalidadTrabajoId;
    }

    public void setFormalidadTrabajoId(int formalidadTrabajoId) {
        FormalidadTrabajoId = formalidadTrabajoId;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String horario) {
        Horario = horario;
    }

    public int getIdAgencia() {
        return IdAgencia;
    }

    public void setIdAgencia(int idAgencia) {
        IdAgencia = idAgencia;
    }

    public int getIdAsesorBanco() {
        return IdAsesorBanco;
    }

    public void setIdAsesorBanco(int idAsesorBanco) {
        IdAsesorBanco = idAsesorBanco;
    }

    public int getIdOficina() {
        return IdOficina;
    }

    public void setIdOficina(int idOficina) {
        IdOficina = idOficina;
    }

    public int getIdProveedorLocalJusti() {
        return IdProveedorLocalJusti;
    }

    public void setIdProveedorLocalJusti(int idProveedorLocalJusti) {
        IdProveedorLocalJusti = idProveedorLocalJusti;
    }

    public int getIdSupervisor() {
        return IdSupervisor;
    }

    public void setIdSupervisor(int idSupervisor) {
        IdSupervisor = idSupervisor;
    }

    public int getIdVendedor() {
        return IdVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        IdVendedor = idVendedor;
    }

    public int getIdVentaEstablecimiento() {
        return IdVentaEstablecimiento;
    }

    public void setIdVentaEstablecimiento(int idVentaEstablecimiento) {
        IdVentaEstablecimiento = idVentaEstablecimiento;
    }

    public String getIngresoNeto() {
        return IngresoNeto;
    }

    public void setIngresoNeto(String ingresoNeto) {
        IngresoNeto = ingresoNeto;
    }

    public int getLocalId() {
        return LocalId;
    }

    public void setLocalId(int localId) {
        LocalId = localId;
    }

    public int getMonitorId() {
        return MonitorId;
    }

    public void setMonitorId(int monitorId) {
        MonitorId = monitorId;
    }

    public int getMontoEfectivoPro() {
        return MontoEfectivoPro;
    }

    public void setMontoEfectivoPro(int montoEfectivoPro) {
        MontoEfectivoPro = montoEfectivoPro;
    }

    public int getMontoMaterialPro() {
        return MontoMaterialPro;
    }

    public void setMontoMaterialPro(int montoMaterialPro) {
        MontoMaterialPro = montoMaterialPro;
    }

    public int getMotivoRechazoId() {
        return MotivoRechazoId;
    }

    public void setMotivoRechazoId(int motivoRechazoId) {
        MotivoRechazoId = motivoRechazoId;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        NombreCompleto = nombreCompleto;
    }

    public Integer getNumeroHijos() {
        return NumeroHijos;
    }

    public void setNumeroHijos(Integer numeroHijos) {
        NumeroHijos = numeroHijos;
    }

    public String getObra() {
        return Obra;
    }

    public void setObra(String obra) {
        Obra = obra;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String observacion) {
        Observacion = observacion;
    }

    public String getOficina() {
        return Oficina;
    }

    public void setOficina(String oficina) {
        Oficina = oficina;
    }

    public int getPersonaId() {
        return PersonaId;
    }

    public void setPersonaId(int personaId) {
        PersonaId = personaId;
    }

    public String getProceso() {
        return Proceso;
    }

    public void setProceso(String proceso) {
        Proceso = proceso;
    }

    public int getProveedorLocalId() {
        return ProveedorLocalId;
    }

    public void setProveedorLocalId(int proveedorLocalId) {
        ProveedorLocalId = proveedorLocalId;
    }

    public String getRazon() {
        return Razon;
    }

    public void setRazon(String razon) {
        Razon = razon;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String referencia) {
        Referencia = referencia;
    }

    public String getRuc() {
        return Ruc;
    }

    public void setRuc(String ruc) {
        Ruc = ruc;
    }

    public int getSexoId() {
        return SexoId;
    }

    public void setSexoId(int sexoId) {
        SexoId = sexoId;
    }

    public int getSolicitudId() {
        return SolicitudId;
    }

    public void setSolicitudId(int solicitudId) {
        SolicitudId = solicitudId;
    }

    public String getSupervisor() {
        return Supervisor;
    }

    public void setSupervisor(String supervisor) {
        Supervisor = supervisor;
    }

    public int getSustentoIngresoId() {
        return SustentoIngresoId;
    }

    public void setSustentoIngresoId(int sustentoIngresoId) {
        SustentoIngresoId = sustentoIngresoId;
    }

    public String getTelefonos() {
        return Telefonos;
    }

    public void setTelefonos(String telefonos) {
        Telefonos = telefonos;
    }

    public String getTipoEstablecimientoNombre() {
        return TipoEstablecimientoNombre;
    }

    public void setTipoEstablecimientoNombre(String tipoEstablecimientoNombre) {
        TipoEstablecimientoNombre = tipoEstablecimientoNombre;
    }

    public int getTipoPersonaId() {
        return TipoPersonaId;
    }

    public void setTipoPersonaId(int tipoPersonaId) {
        TipoPersonaId = tipoPersonaId;
    }

    public int getTipoPuestoId() {
        return TipoPuestoId;
    }

    public void setTipoPuestoId(int tipoPuestoId) {
        TipoPuestoId = tipoPuestoId;
    }

    public int getTipoRechazoId() {
        return TipoRechazoId;
    }

    public void setTipoRechazoId(int tipoRechazoId) {
        TipoRechazoId = tipoRechazoId;
    }

    public int getTipoTrabajoId() {
        return TipoTrabajoId;
    }

    public void setTipoTrabajoId(int tipoTrabajoId) {
        TipoTrabajoId = tipoTrabajoId;
    }

    public int getTitularId() {
        return TitularId;
    }

    public void setTitularId(int titularId) {
        TitularId = titularId;
    }

    public String getUbigeo() {
        return Ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        Ubigeo = ubigeo;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
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


    public String getNombreFerreteria() {
        return nombreFerreteria;
    }

    public void setNombreFerreteria(String nombreFerreteria) {
        this.nombreFerreteria = nombreFerreteria;
    }

    public int getGradoInstruccionId() {
        return GradoInstruccionId;
    }

    public void setGradoInstruccionId(int gradoInstruccionId) {
        GradoInstruccionId = gradoInstruccionId;
    }

    public List<ProveedorLocal> getListaFerreterias() {
        return ListaFerreterias;
    }

    public void setListaFerreterias(List<ProveedorLocal> listaFerreterias) {
        ListaFerreterias = listaFerreterias;
    }


    public List<ExpedienteCreditoDetalle> getListaExpedienteCreditoDetalle() {
        return ListaExpedienteCreditoDetalle;
    }

    public void setListaExpedienteCreditoDetalle(List<ExpedienteCreditoDetalle> listaExpedienteCreditoDetalle) {
        ListaExpedienteCreditoDetalle = listaExpedienteCreditoDetalle;
    }

    public int getDerivadoAntes() {
        return DerivadoAntes;
    }

    public void setDerivadoAntes(int derivadoAntes) {
        DerivadoAntes = derivadoAntes;
    }

    public boolean isActivoProveedorLocal() {
        return EsActivoProveedorLocal;
    }

    public void setEsActivoProveedorLocal(boolean esActivoProveedorLocal) {
        EsActivoProveedorLocal = esActivoProveedorLocal;
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Persona persona = (Persona) o;
//        return TipoPersonaId == persona.TipoPersonaId;
//    }

    @Override
    public int compareTo(Persona o) {
        return this.EstadoProcesoId=o.getEstadoProcesoId();
    }

    @Override
    public String toString() {
        return "Persona{" +
                "DocumentoNum='" + DocumentoNum + '\'' +
                ", Accion='" + Accion + '\'' +
                ", ApeMaterno='" + ApeMaterno + '\'' +
                ", ApePaterno='" + ApePaterno + '\'' +
                ", AsesorNombre='" + AsesorNombre + '\'' +
                ", Banco='" + Banco + '\'' +
                ", BancoId=" + BancoId +
                ", Canal=" + Canal +
                ", Cargo='" + Cargo + '\'' +
                ", CargoId=" + CargoId +
                ", CasaPropia=" + CasaPropia +
                ", Celular='" + Celular + '\'' +
                ", Celular2='" + Celular2 + '\'' +
                ", CentroTrabajo='" + CentroTrabajo + '\'' +
                ", CodExpedienteCredito=" + CodExpedienteCredito +
                ", CodPersona=" + CodPersona +
                ", CodigoUsuarioCreacion=" + CodigoUsuarioCreacion +
                ", Correo='" + Correo + '\'' +
                ", CuotaNumero=" + CuotaNumero +
                ", DatosDireccionId=" + DatosDireccionId +
                ", DatosLaboralesId=" + DatosLaboralesId +
                ", Direccion='" + Direccion + '\'' +
                ", Distrito='" + Distrito + '\'' +
                ", EnObservacion=" + EnObservacion +
                ", EstadoCivilId=" + EstadoCivilId +
                ", EstadoProcesoId=" + EstadoProcesoId +
                ", EstadoProcesoNombre='" + EstadoProcesoNombre + '\'' +
                ", EstadoUrgencia=" + EstadoUrgencia +
                ", ExpedienteCreditoId=" + ExpedienteCreditoId +
                ", FechaActua='" + FechaActua + '\'' +
                ", FechaCreacion='" + FechaCreacion + '\'' +
                ", FechaIngresoLaboral='" + FechaIngresoLaboral + '\'' +
                ", FechaNacimiento='" + FechaNacimiento + '\'' +
                ", FormalidadTrabajoId=" + FormalidadTrabajoId +
                ", Horario='" + Horario + '\'' +
                ", IdAgencia=" + IdAgencia +
                ", IdAsesorBanco=" + IdAsesorBanco +
                ", IdOficina=" + IdOficina +
                ", IdProveedorLocalJusti=" + IdProveedorLocalJusti +
                ", IdSupervisor=" + IdSupervisor +
                ", IdVendedor=" + IdVendedor +
                ", IdVentaEstablecimiento=" + IdVentaEstablecimiento +
                ", IngresoNeto='" + IngresoNeto + '\'' +
                ", LocalId=" + LocalId +
                ", MonitorId=" + MonitorId +
                ", MontoEfectivoPro=" + MontoEfectivoPro +
                ", MontoMaterialPro=" + MontoMaterialPro +
                ", MotivoRechazoId=" + MotivoRechazoId +
                ", Nombre='" + Nombre + '\'' +
                ", NombreCompleto='" + NombreCompleto + '\'' +
                ", NumeroHijos=" + NumeroHijos +
                ", Obra='" + Obra + '\'' +
                ", Observacion='" + Observacion + '\'' +
                ", Oficina='" + Oficina + '\'' +
                ", PersonaId=" + PersonaId +
                ", Proceso='" + Proceso + '\'' +
                ", ProveedorLocalId=" + ProveedorLocalId +
                ", Razon='" + Razon + '\'' +
                ", Referencia='" + Referencia + '\'' +
                ", Ruc='" + Ruc + '\'' +
                ", SexoId=" + SexoId +
                ", SolicitudId=" + SolicitudId +
                ", Supervisor='" + Supervisor + '\'' +
                ", SustentoIngresoId=" + SustentoIngresoId +
                ", Telefonos='" + Telefonos + '\'' +
                ", TipoEstablecimientoNombre='" + TipoEstablecimientoNombre + '\'' +
                ", TipoPersonaId=" + TipoPersonaId +
                ", TipoPuestoId=" + TipoPuestoId +
                ", TipoRechazoId=" + TipoRechazoId +
                ", TipoTrabajoId=" + TipoTrabajoId +
                ", TitularId=" + TitularId +
                ", Ubigeo='" + Ubigeo + '\'' +
                ", UserPassword='" + UserPassword + '\'' +
                ", ZonaId=" + ZonaId +
                ", sync_status=" + sync_status +
                ", nombreFerreteria='" + nombreFerreteria + '\'' +
                ", ListaFerreterias=" + ListaFerreterias +
                ", ListaExpedienteCreditoDetalle=" + ListaExpedienteCreditoDetalle +
                ", estado=" + estado +
                '}';
    }
}
