package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.entities;

import java.util.Date;
import java.util.Objects;

public class ProveedorLocalUi {
    private String nombreProveedor;
    private String fecha;
    private String Usuario;
    private int proveedorLocalId;
    private String nombreComercial;
    private String RUC;
    private String Razon;
    private String accion;
    private int tipo;
    private String estado;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getProveedorLocalId() {
        return proveedorLocalId;
    }

    public void setProveedorLocalId(int proveedorLocalId) {
        this.proveedorLocalId = proveedorLocalId;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getRazon() {
        return Razon;
    }

    public void setRazon(String razon) {
        Razon = razon;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProveedorLocalUi that = (ProveedorLocalUi) o;
        return RUC.equals(that.RUC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(RUC);
    }
}
