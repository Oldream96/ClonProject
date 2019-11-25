package pe.com.hatunsol.hatunsolmovil.modules.login.entities;

public class SincronizacionEstado {

    private boolean sincronizacionUbigeo=false;
    private boolean sincronizacionParametros=false;
    private boolean sincronizarProveedorLocal=false;
    private boolean sincronizarPersonas=false;

    public SincronizacionEstado() {
    }

    public boolean isSincronizacionUbigeo() {
        return sincronizacionUbigeo;
    }

    public void setSincronizacionUbigeo(boolean sincronizacionUbigeo) {
        this.sincronizacionUbigeo = sincronizacionUbigeo;
    }

    public boolean isSincronizacionParametros() {
        return sincronizacionParametros;
    }

    public void setSincronizacionParametros(boolean sincronizacionParametros) {
        this.sincronizacionParametros = sincronizacionParametros;
    }

    public boolean isSincronizarProveedorLocal() {
        return sincronizarProveedorLocal;
    }

    public void setSincronizarProveedorLocal(boolean sincronizarProveedorLocal) {
        this.sincronizarProveedorLocal = sincronizarProveedorLocal;
    }

    public boolean isSincronizarPersonas() {
        return sincronizarPersonas;
    }

    public void setSincronizarPersonas(boolean sincronizarPersonas) {
        this.sincronizarPersonas = sincronizarPersonas;
    }

    @Override
    public String toString() {
        return "SincronizacionEstado{" +
                "sincronizacionUbigeo=" + sincronizacionUbigeo +
                ", sincronizacionParametros=" + sincronizacionParametros +
                ", sincronizarProveedorLocal=" + sincronizarProveedorLocal +
                ", sincronizarPersonas=" + sincronizarPersonas +
                '}';
    }
}
