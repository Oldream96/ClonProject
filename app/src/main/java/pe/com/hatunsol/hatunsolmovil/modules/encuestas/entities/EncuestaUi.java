package pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities;

import java.util.List;

public class EncuestaUi {
    private int IdEncuesta;

    private int IdEncuestaUsuario;

    private String Verificacion;

    private String FechaCrea;

    private String Nombre_Encuesta;

    private String Descripcion;

    private String Operacion;

    private int Verif_Sup;

    private List<PreguntaUi> Preguntas;
    private int proveedorLocalId;


    public int getIdEncuesta() {
        return IdEncuesta;
    }

    public void setIdEncuesta(int idEncuesta) {
        IdEncuesta = idEncuesta;
    }

    public int getIdEncuestaUsuario() {
        return IdEncuestaUsuario;
    }

    public void setIdEncuestaUsuario(int idEncuestaUsuario) {
        IdEncuestaUsuario = idEncuestaUsuario;
    }

    public List<PreguntaUi> getPreguntas() {
        return Preguntas;
    }

    public void setPreguntas(List<PreguntaUi> preguntas) {
        Preguntas = preguntas;
    }

    public String getVerificacion() {
        return Verificacion;
    }

    public void setVerificacion(String verificacion) {
        Verificacion = verificacion;
    }

    public String getFechaCrea() {
        return FechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        FechaCrea = fechaCrea;
    }

    public String getNombre_Encuesta() {
        return Nombre_Encuesta;
    }

    public void setNombre_Encuesta(String nombre_Encuesta) {
        Nombre_Encuesta = nombre_Encuesta;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getOperacion() {
        return Operacion;
    }

    public void setOperacion(String operacion) {
        Operacion = operacion;
    }

    public int getVerif_Sup() {
        return Verif_Sup;
    }

    public void setVerif_Sup(int verif_Sup) {
        Verif_Sup = verif_Sup;
    }

    public int getProveedorLocalId() {
        return proveedorLocalId;
    }

    public void setProveedorLocalId(int proveedorLocalId) {
        this.proveedorLocalId = proveedorLocalId;
    }
}
