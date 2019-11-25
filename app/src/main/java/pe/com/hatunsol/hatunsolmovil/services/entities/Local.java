package pe.com.hatunsol.hatunsolmovil.services.entities;

public class Local {

    private int LocalId;
    private String LocalNombre;
    private String ZonaNombre;
    private String Descripcion;
    private String Foto;
    private String Telefono;
    private String NombreComercial;
    private String Contacto;
    private String Latitud;
    private String Longitud;
    private int ZonaId;
    private String Direccion;

    public Local() {
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

    public String getZonaNombre() {
        return ZonaNombre;
    }

    public void setZonaNombre(String zonaNombre) {
        ZonaNombre = zonaNombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getNombreComercial() {
        return NombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        NombreComercial = nombreComercial;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String contacto) {
        Contacto = contacto;
    }

    public int getZonaId() {
        return ZonaId;
    }

    public void setZonaId(int zonaId) {
        ZonaId = zonaId;
    }

    public String getLatitud() {
        return Latitud;
    }

    public void setLatitud(String latitud) {
        Latitud = latitud;
    }

    public String getLongitud() {
        return Longitud;
    }

    public void setLongitud(String longitud) {
        Longitud = longitud;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    @Override
    public String toString() {
        return Descripcion;
    }

    public Local(int localId, String descripcion, String latitud, String longitud) {
        LocalId = localId;
        Descripcion = descripcion;
        Latitud = latitud;
        Longitud = longitud;
    }
}
