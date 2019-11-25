package pe.com.hatunsol.hatunsolmovil.services.entities;

public class CheckListProveedor {
    private String Comentario;
    private String FechaActua;
    private String NombreCargo;
    private String NombreProceso;
    private String NombreUsuario;

    public CheckListProveedor() {
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String comentario) {
        Comentario = comentario;
    }

    public String getFechaActua() {
        return FechaActua;
    }

    public void setFechaActua(String fechaActua) {
        FechaActua = fechaActua;
    }

    public String getNombreCargo() {
        return NombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        NombreCargo = nombreCargo;
    }

    public String getNombreProceso() {
        return NombreProceso;
    }

    public void setNombreProceso(String nombreProceso) {
        NombreProceso = nombreProceso;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }
}
