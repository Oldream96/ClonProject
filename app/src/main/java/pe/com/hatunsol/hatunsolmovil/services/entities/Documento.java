package pe.com.hatunsol.hatunsolmovil.services.entities;

public class Documento {
    private int AdjuntoId;
    private String TipoDocumentoAdjuntoNombre;
    private String Ruta;
    private String Tamanio;
    private String Formato;
    private String Nombre;
    private int EstadoAfiliacionId;
    private int TipoDocumentoAdjuntoId;
    private int ProveedorId;
    private int ProveedorLocalId;
    private String image;
    private int ExpedienteCreditoId;
    private int CodigoUsuarioModificacion;

    public Documento() {
    }

    public int getExpedienteCreditoId() {
        return ExpedienteCreditoId;
    }

    public void setExpedienteCreditoId(int expedienteCreditoId) {
        ExpedienteCreditoId = expedienteCreditoId;
    }

    public int getAdjuntoId() {
        return AdjuntoId;
    }

    public void setAdjuntoId(int adjuntoId) {
        AdjuntoId = adjuntoId;
    }

    public String getTipoDocumentoAdjuntoNombre() {
        return TipoDocumentoAdjuntoNombre;
    }

    public void setTipoDocumentoAdjuntoNombre(String tipoDocumentoAdjuntoNombre) {
        TipoDocumentoAdjuntoNombre = tipoDocumentoAdjuntoNombre;
    }

    public String getRuta() {
        return Ruta;
    }

    public void setRuta(String ruta) {
        Ruta = ruta;
    }

    public String getTamanio() {
        return Tamanio;
    }

    public void setTamanio(String tamanio) {
        Tamanio = tamanio;
    }

    public String getFormato() {
        return Formato;
    }

    public void setFormato(String formato) {
        Formato = formato;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getEstadoAfiliacionId() {
        return EstadoAfiliacionId;
    }

    public void setEstadoAfiliacionId(int estadoAfiliacionId) {
        EstadoAfiliacionId = estadoAfiliacionId;
    }

    public int getProveedorId() {
        return ProveedorId;
    }

    public void setProveedorId(int proveedorId) {
        ProveedorId = proveedorId;
    }

    public int getTipoDocumentoAdjuntoId() {
        return TipoDocumentoAdjuntoId;
    }

    public void setTipoDocumentoAdjuntoId(int tipoDocumentoAdjuntoId) {
        TipoDocumentoAdjuntoId = tipoDocumentoAdjuntoId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    @Override
    public String toString() {
        return Nombre;
    }
}
