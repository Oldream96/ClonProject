package pe.com.hatunsol.hatunsolmovil.api.service;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.modules.afiliacion.entities.ResponseAfiliacion;
import pe.com.hatunsol.hatunsolmovil.modules.afiliacion.entities.ResponseAgencia;
import pe.com.hatunsol.hatunsolmovil.modules.afiliacion.entities.ResponseDeleteDocuProveedor;
import pe.com.hatunsol.hatunsolmovil.modules.afiliacion.entities.ResponseDeletePerfil;
import pe.com.hatunsol.hatunsolmovil.modules.afiliacion.entities.ResponseLocal;
import pe.com.hatunsol.hatunsolmovil.modules.afiliacion.entities.ResponseObservacion;
import pe.com.hatunsol.hatunsolmovil.modules.afiliacion.entities.ResponseSaveDocuProveedor;
import pe.com.hatunsol.hatunsolmovil.modules.afiliacion.entities.ResponseSavePhotoAgencia;
import pe.com.hatunsol.hatunsolmovil.modules.afiliacion.entities.ResponseSavePhotoLocal;
import pe.com.hatunsol.hatunsolmovil.modules.afiliacion.entities.ResponseSavePhotoProvLocal;
import pe.com.hatunsol.hatunsolmovil.modules.afiliacion.entities.ResponseSupervisor;
import pe.com.hatunsol.hatunsolmovil.modules.asistencia.entities.RequestActualizar;
import pe.com.hatunsol.hatunsolmovil.modules.asistencia.entities.RequestActualizarSV;
import pe.com.hatunsol.hatunsolmovil.modules.asistencia.entities.RequestFinalizar;
import pe.com.hatunsol.hatunsolmovil.modules.asistencia.entities.ResponseAsistencia;
import pe.com.hatunsol.hatunsolmovil.modules.asistencia.reporteasistencia.entities.ResponsePlanTrabajo;
import pe.com.hatunsol.hatunsolmovil.modules.asistencia.reporteasistencia.entities.Responsereportesupervisor;
import pe.com.hatunsol.hatunsolmovil.modules.creditos.entities.ResponseDeleteDocuCreditos;
import pe.com.hatunsol.hatunsolmovil.modules.creditos.entities.ResponseSavePhotoCreditos;
import pe.com.hatunsol.hatunsolmovil.modules.main.entities.ResponseEstablecimiento;
import pe.com.hatunsol.hatunsolmovil.modules.creditos.entities.ResponseParameter;
import pe.com.hatunsol.hatunsolmovil.services.entities.CheckListProveedor;
import pe.com.hatunsol.hatunsolmovil.services.entities.Documento;
import pe.com.hatunsol.hatunsolmovil.services.entities.Encuesta;
import pe.com.hatunsol.hatunsolmovil.services.entities.AsesorBanco;
import pe.com.hatunsol.hatunsolmovil.services.entities.ExpedienteCreditoDetalle;
import pe.com.hatunsol.hatunsolmovil.services.entities.Local;
import pe.com.hatunsol.hatunsolmovil.services.entities.Oficina;
import pe.com.hatunsol.hatunsolmovil.services.entities.Parametro;
import pe.com.hatunsol.hatunsolmovil.services.entities.Persona;
import pe.com.hatunsol.hatunsolmovil.services.entities.ProveedorLocal;
import pe.com.hatunsol.hatunsolmovil.services.entities.ResponseExpedienteDetalle;
import pe.com.hatunsol.hatunsolmovil.services.entities.ResponseResult;
import pe.com.hatunsol.hatunsolmovil.services.entities.Ubigeo;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Services {

    //Creditos
    @GET("usuario.svc/usuario/{username}")
    Call<Usuario> obtenerUsuario(@Path("username") String usuario);

    @GET("ubigeo.svc/ubigeos")
    Call<List<Ubigeo>> obtenerUbigeo();

    @GET("parametro.svc/parametro/{number}")
    Call<List<Parametro>> obtenerParametro(@Path("number")int number);

    @GET("parametro.svc/Listar/{number}")
    Call<List<Parametro>> obtenerParametro(@Path("number") String number);

    //Lista de Locales, Agencias y Ferreterias
    @GET("ProveedorLocal.svc/Locales")
    Call<ResponseAsistencia> obtenerProveedorLocal(@Query("cargoid") int cargoId, @Query("userid") int usuarioId, @Query("latitud")double latitud,@Query("longitud")double longitud);

    @GET("Persona.svc/BuscarPersonas")
    Call<List<Persona>> obtenerPersona(@Query("idsupervisor") int idsupervisor, @Query("DocumentoNum") String DocumentoNum, @Query("cargoid") int cargoid, @Query("codigousuario") int codigousuario,
                                              @Query("TipoBusqueda") String TipoBusqueda, @Query("offset") int offset, @Query("EnObservacion") boolean EnObservacion, @Query("FechaActua") String FechaActua,
                                              @Query("zonaid") int zonaid, @Query("localid") int localid);
    @GET("Persona.svc/Persona/{dni}")
    Call<ResponseParameter> onValidateDocumento(@Path("dni") String dni);

    @GET("Persona.svc/Persona/{dni}")
    Call<ResponseParameter> getConyugePerson(@Path("dni") String dni);

    @GET("ProveedorLocal.svc/ProveedorLocal")
    Call<List<ProveedorLocal>> obtenerEstablecimientos(@Query("cargoid") int cargoId, @Query("empleadoid") int empleadoId, @Query("localid") int localId,
                                                          @Query("nombreproveedor")String nombreProveedor, @Query("Filtro")int filtro, @Query("OFFSET") int offset);

    @POST("Persona.svc/Persona")
    Call<List<Persona>> onSavePersonCredito(@Body List<Persona> personaList);

    @GET("Persona.svc/ListarInvolucrados")
    Call<List<Persona>> getListInvolucrados(@Query("ExpedienteCreditoId") int expedienteCredito);

    @GET("Persona.svc/Persona")
    Call<ResponseExpedienteDetalle> getListExpedienteCreditoDetalle(@Query("ExpedienteCreditoId") int expedienteCredito);

    @POST("Persona.svc/CambiarEstado")
    Call<Boolean> onChangeStatus(@Body Persona persona);


    @POST("ExpedienteCreditoDetalle.svc/ExpedienteCreditoDetalle")
    Call<Integer> onAgendar(@Body ExpedienteCreditoDetalle expedienteCreditoDetalle);

    @GET("Persona.svc/ObtenerMonitor")
    Call<List<Persona>> getMonitor(@Query("MonitorId") int monitorId);
    @GET("Oficina.svc/Oficina")
    Call<ResponseResult<Oficina>> getAgencia(@Query("Nombre") String nombre);
    @GET("Oficina.svc/ObtenerOficina")
    Call<Oficina> getAgenciaId(@Query("oficinaid") int oficinaid);
    @GET("AsesorBanco.svc/Asesor")
    Call<ResponseResult<AsesorBanco>> getBanco();


    //compromisos
    @GET("pendiente.svc/Listar")
    Call<List<Persona>> obtenerCompromisos(@Query("idsupervisor") int idsupervisor, @Query("mes") int mes, @Query("anio") int anio);
                                       /*@Query("TipoBusqueda") String TipoBusqueda, @Query("offset") int offset, @Query("EnObservacion") boolean EnObservacion, @Query("FechaActua") String FechaActua,
                                       @Query("zonaid") int zonaid, @Query("localid") int localid);
*/
    //GET
    @GET("pendiente.svc/Obtener")
    Call<List<Persona>> obtenerFerreteriaCompromisos(@Query("idsupervisor") int idsupervisor, @Query("fecha") String fecha, @Query("nombre") String nombre);

    @GET("pendiente.svc/ObtenerDerivados")
    Call<List<Persona>> obtenerDerivadosCompromisos(@Query("idsupervisor") int idsupervisor,@Query("fecha") String fecha,@Query("nombre") String nombre);

    @GET("pendiente.svc/ObtenerActivados")
    Call<List<Persona>> obtenerActivadosCompromisos(@Query("idsupervisor") int idsupervisor,@Query("fecha") String fecha,@Query("nombre") String nombre);
    //POST
    @POST("pendiente.svc/Contactos")
    Call<Integer> onSaveFerreteriaCompromiso(@Body List<Persona> listaCompromisos);

    @POST("pendiente.svc/Derivados")
    Call<Integer> onSaveDerivadosCompromiso(@Body List<Persona> personaList);

    @POST("pendiente.svc/Activados")
    Call<Integer> onSaveActivadosCompromiso(@Body List<Persona> personaList);

    //Encuestas
    @GET("encuesta.svc/ListarEncuestas")
    Call<List<Encuesta>> obtenerEncuesta(@Query("userid") int userid, @Query("cargoid") int cargoid, @Query("nombrecomercial") String nombrecomercial, @Query("mes") int mes, @Query("anio") int anio);

    //ReportePlanTrabajo
    @GET("PlanTrabajo.svc/Listar")
    Call<ResponsePlanTrabajo> obtenerPlanTrabajoDetalle(@Query("userid") int userid, @Query("mes") int mes, @Query("anio") int anio, @Query("localid") int localid);
    @GET("encuesta.svc/Preguntas")
    Call<Encuesta> obtenerPreguntas(@Query("idencuesta") int idencuesta, @Query("idencuestausuario") int idencuestausuario);
        //
    @POST("encuesta.svc/Actualizar")
    Call<Encuesta> Actualizar(@Body Encuesta encuesta);

    //ActualizarPlanTrabajo
    @POST("PlanTrabajo.svc/Actualizar")
    Call<RequestActualizar> ActualizarPlanTrabajo(@Body RequestActualizar planTrabajoDetalle);

    //FinalizarPlanTrabajo
    @POST("PlanTrabajo.svc/ActualizarTermino")
    Call<Integer> FinalizarPlanTrabajo(@Body RequestFinalizar requestActualizarfinalizar);

    //ActualizarPlanTrabajoSegundaVez
    @POST("PlanTrabajo.svc/ActualizarSegundaVez")
    Call<RequestActualizarSV> ActualizarPlanTrabajoSegundavez(@Body RequestActualizarSV requestActualizarsegundavez);

    //Supervisor
    @GET("Supervisor.svc/ListarEmpleadosLocal")
    Call<Responsereportesupervisor> ObtenerSupervisores(@Query("LocalId") String LocalId, @Query("Nombre") String Nombre, @Query("ZonaId") int ZonaId);

    /* ====================
       MODULO AFILIACIÓN
       ================= */

    /*===== BUSQUEDA =====*/

    @GET("Proveedor.svc/Proveedor")
    Call<ResponseAfiliacion> obtenerProveedores(@Query("cargoid") int cargoId, @Query("empleadoid") int empleadoId, @Query("zonaid") int zonaId , @Query("localid") int localId,
                                                @Query("nombreproveedor") String nombreProveedor, @Query("Filtro") int filtro, @Query("OFFSET") int offset);

    @GET("Local.svc/Local")
    Call<ResponseLocal> obtenerLocales(@Query("Nombre") String nombre);

    @GET("Oficina.svc/Oficina")
    Call<ResponseAgencia> obtenerAgencias(@Query("Nombre") String nombre);

    @POST("DocumentoAdjunto.svc/UploadPhotoLocal")
    Call<ResponseSavePhotoLocal> onSavePhotoLocal(@Body Documento documento);

    @POST("DocumentoAdjunto.svc/UploadPhotoOficina")
    Call<ResponseSavePhotoAgencia> onSavePhotoAgencia(@Body Documento documento);

    @GET("Local.svc/EliminarPerfil")
    Call<ResponseDeletePerfil> onEliminarPhotoLocal(@Query("IdLocal") int localId);

    @GET("Oficina.svc/EliminarPerfil")
    Call<ResponseDeletePerfil> onEliminarPhotoAgencia(@Query("IdOficina") int oficinaId);

    /*===== AFILIACION PROVEEDOR =====*/

    @GET("ProveedorLocal.svc/ProveedorLocal")
    Call<List<ProveedorLocal>> obtenerProveedoresLocales(@Query("cargoid") int cargoId, @Query("empleadoid") int empleadoId, @Query("localid") int localId,
                                                       @Query("nombreproveedor") String nombreProveedor, @Query("Filtro") int filtro, @Query("OFFSET") int offset);

    @GET("Proveedor.svc/ObtenerProveedor")
    Call<ProveedorLocal> obtenerProveedor(@Query("proveedorid") int proveedorid);

    @GET("Proveedor.svc/ObtenerHistorial")
    Call<List<CheckListProveedor>> obtenerHistorial(@Query("proveedorid") int proveedorid);

    @GET("DocumentoAdjuntoProveedor.svc/Documento")
    Call<List<Documento>> obtenerDocumentosProveedor(@Query("ProveedorId") int proveedorId);

    @POST("ProveedorLocal.svc/ActualizarProveedor")
    Call<ProveedorLocal> onSaveProveedor(@Body ProveedorLocal proveedorLocal);

    @POST("DocumentoAdjuntoProveedor.svc/UploadArchivo")
    Call<ResponseSaveDocuProveedor> onSaveDocumentoProveedor(@Body Documento documento);

    @GET("DocumentoAdjuntoProveedor.svc/Eliminar")
    Call<ResponseDeleteDocuProveedor> onEliminarDocumentoProveedor(@Query("AdjuntoId") int adjuntoId);

    @POST("DocumentoAdjuntoProveedor.svc/UploadPhoto")
    Call<ResponseSavePhotoProvLocal> onSavePhotoProveedorLocal(@Body Documento documento);

    @GET("DocumentoAdjuntoProveedor.svc/EliminarPerfil")
    Call<ResponseDeletePerfil> onEliminarPhotoProveedorLocal(@Query("ProveedorLocalId") int proveedorLocalId);

    /*===== AFILIACION PROVEEDOR LOCAL =====*/

    @GET("ProveedorLocal.svc/Obtener")
    Call<ProveedorLocal> obtenerProveedorLocal(@Query("proveedorlocalid") int proveedorlocalid);

    @GET("Supervisor.svc/Supervisor")
    Call<ResponseSupervisor> obtenerSupervisores(@Query("LocalId") int localid);

    @POST("ProveedorLocal.svc/ActualizarProveedorLocal")
    Call<ProveedorLocal> onSaveProveedorLocal(@Body ProveedorLocal proveedorLocal);

    @GET("ProveedorLocal.svc/ObtenerDetalle")
    Call<ProveedorLocal> obtenerDetalleProveedorLocal(@Query("proveedorlocalid") int proveedorLocalId);

    @GET("ProveedorLocal.svc/ValidarPlanTrabajo")
    Call<ProveedorLocal> isValidPlanTrabajo(@Query("proveedorlocalid") int proveedorLocalId);

    /*===== AFILIACION LOCALES =====*/

    @GET("Local.svc/ObtenerLocal")
    Call<Local> obtenerLocal(@Query("localid") int localId);
    @POST("Local.svc/Actualizar")
    Call<Local> onSaveLocal(@Body Local local);

    /*===== AFILIACION AGENCIAS =====*/

    @GET("Oficina.svc/ObtenerOficina")
    Call<Oficina> obtenerAgencia(@Query("oficinaid") int oficinaId);

    @POST("Oficina.svc/Actualizar")
    Call<Oficina> onSaveAgencia(@Body Oficina oficina);

    /*===== DOCUMENTO CREDITOS =====*/
    @GET("DocumentoAdjunto.svc/Documento")
    Call<List<Documento>> obtenerDocumentosCredito(@Query("ExpedienteCreditoId") int ExpedienteCreditoId);

    @GET("DocumentoAdjunto.svc/Eliminar")
    Call<ResponseDeleteDocuCreditos> onEliminarDocumentoCreditos(@Query("AdjuntoId") int adjuntoId);

    @POST("DocumentoAdjunto.svc/FileUpload")
    Call<ResponseSavePhotoCreditos> onSavePhotoCreditos(@Body Documento documento);
}
