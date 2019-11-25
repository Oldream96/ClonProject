package pe.com.hatunsol.hatunsolmovil.services.entities;

import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

public class Encuesta {

    private int UserIdCrea;

    private String Verificacion;

    private int IdEncuesta;

    private int IdEncuestaUsuario;

    private String FechaCrea;

    private String UserId;

    private String Nombre_Encuesta;

    private int ProveedorLocalId;

    private String Descripcion;

    private int Operacion;

    private int Verif_Sup;

    private List<Pregunta> Preguntas;

    public List<Pregunta> getPreguntas() {
        return Preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        Preguntas = preguntas;
    }

    public String getVerificacion ()
    {
        return Verificacion;
    }

    public void setVerificacion (String Verificacion)
    {
        this.Verificacion = Verificacion;
    }


    public int getOperacion() {
        return Operacion;
    }

    public void setOperacion(int operacion) {
        Operacion = operacion;
    }

    public String getFechaCrea ()
    {
        return FechaCrea;
    }

    public void setFechaCrea (String FechaCrea)
    {
        this.FechaCrea = FechaCrea;
    }

    public String getUserId ()
    {
        return UserId;
    }

    public void setUserId (String UserId)
    {
        this.UserId = UserId;
    }

    public String getNombre_Encuesta ()
    {
        return Nombre_Encuesta;
    }

    public void setNombre_Encuesta (String Nombre_Encuesta)
    {
        this.Nombre_Encuesta = Nombre_Encuesta;
    }

    public String getDescripcion ()
    {
        return Descripcion;
    }

    public void setDescripcion (String Descripcion)
    {
        this.Descripcion = Descripcion;
    }



    public int getUserIdCrea() {
        return UserIdCrea;
    }

    public void setUserIdCrea(int userIdCrea) {
        UserIdCrea = userIdCrea;
    }

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

    public int getProveedorLocalId() {
        return ProveedorLocalId;
    }

    public void setProveedorLocalId(int proveedorLocalId) {
        ProveedorLocalId = proveedorLocalId;
    }

    public int getVerif_Sup() {
        return Verif_Sup;
    }

    public void setVerif_Sup(int verif_Sup) {
        Verif_Sup = verif_Sup;
    }
}
