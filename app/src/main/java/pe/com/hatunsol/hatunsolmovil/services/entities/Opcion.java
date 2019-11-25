package pe.com.hatunsol.hatunsolmovil.services.entities;

public class Opcion {
    private String Nombre;
    private String Descripcion;
    private int IdOpcion;
    private int TipoValor;
    private Double Numero;
    private String Cadena;
    private boolean Checked;

    public String getCadena() {
        return Cadena;
    }

    public void setCadena(String cadena) {
        Cadena = cadena;
    }

    public boolean isChecked() {
        return Checked;
    }

    public void setChecked(boolean checked) {
        Checked = checked;
    }

    public Double getNumero() {
        return Numero;
    }

    public void setNumero(Double numero) {
        Numero = numero;
    }

    public int getTipoValor() {
        return TipoValor;
    }

    public void setTipoValor(int tipoValor) {
        TipoValor = tipoValor;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getIdOpcion() {
        return IdOpcion;
    }

    public void setIdOpcion(int idOpcion) {
        IdOpcion = idOpcion;
    }

    public Opcion(String nombre) {
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }


    public Opcion(int idOpcion,String descripcion, int tipoValor,boolean checked,Double numero,String cadena) {
        Descripcion = descripcion;
        IdOpcion = idOpcion;
        TipoValor = tipoValor;
        Checked=checked;
        Numero=numero;
        Cadena=cadena;
    }
}
