package pe.com.hatunsol.hatunsolmovil.services.entities;

import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

public class Pregunta extends BaseModel {
    private int IdEncuestaUsuario;
    private String Descripcion;
    private String GrupoPregunta;
    private int IdPregunta;
    private int IdGrupoPregunta;
    private int ItemId;
    private List<Opcion> Opciones;
    private int Verif_Sup;








    public int getVerif_Sup() {
        return Verif_Sup;
    }

    public void setVerif_Sup(int verif_Sup) {
        Verif_Sup = verif_Sup;
    }



    public List<Opcion> getOpciones() {
        return Opciones;
    }

    public void setOpciones(List<Opcion> opciones) {
        Opciones = opciones;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        ItemId = itemId;
    }

    public int getIdGrupoPregunta() {
        return IdGrupoPregunta;
    }

    public void setIdGrupoPregunta(int idGrupoPregunta) {
        IdGrupoPregunta = idGrupoPregunta;
    }

    public int getIdPregunta() {
        return IdPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        IdPregunta = idPregunta;
    }

    public int getIdEncuestaUsuario() {
        return IdEncuestaUsuario;
    }

    public void setIdEncuestaUsuario(int idEncuestaUsuario) {
        IdEncuestaUsuario = idEncuestaUsuario;
    }




    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getGrupoPregunta() {
        return GrupoPregunta;
    }

    public void setGrupoPregunta(String grupoPregunta) {
        GrupoPregunta = grupoPregunta;
    }
}