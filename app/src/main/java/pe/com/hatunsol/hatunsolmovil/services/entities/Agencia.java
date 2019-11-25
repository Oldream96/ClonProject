package pe.com.hatunsol.hatunsolmovil.services.entities;

public class Agencia {
    private int IdOficina;
    private int AgenciaId;
    private String Nombre;
    private String Direccion;
    private String Telefono;
    private String CorreoA;
    private int TipoLugar;
    private String Latitud;
    private String Longitud;

    public Agencia() {
    }

    public int getIdOficina() {
        return IdOficina;
    }

    public void setIdOficina(int idOficina) {
        IdOficina = idOficina;
    }

    public int getAgenciaId() {
        return AgenciaId;
    }

    public void setAgenciaId(int agenciaId) {
        AgenciaId = agenciaId;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCorreoA() {
        return CorreoA;
    }

    public void setCorreoA(String correoA) {
        CorreoA = correoA;
    }

    public int getTipoLugar() {
        return TipoLugar;
    }

    public void setTipoLugar(int tipoLugar) {
        TipoLugar = tipoLugar;
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

    public Agencia(int idOficina, int agenciaid,
                   String nombre, String direccion,
                   String telefono, String correoa,
                   String latitud, String longitud) {
        IdOficina = idOficina;
        AgenciaId = agenciaid;
        Nombre  = nombre;
        Direccion = direccion;
        Telefono = telefono;
        CorreoA = correoa;
        Latitud = latitud;
        Longitud = longitud;
    }

    @Override
    public  String toString(){
        return Nombre;
    }
}
