package pe.com.hatunsol.hatunsolmovil.services.entities;

public class ExpedienteCreditoDetalle {

    public int ExpedienteCreditoId;

    public String ProcesoNombre;
    public String Fecha;
    public String Observacion;
    public int CodigoUsuarioCreacion;
    public int ProcesoId;
    public String DiaAgenda;
    public String strDiaAgenda;
    public String strFecha;
    public int ItemId;



    public ExpedienteCreditoDetalle() {
    }

    public int getExpedienteCreditoId() {
        return ExpedienteCreditoId;
    }

    public void setExpedienteCreditoId(int expedienteCreditoId) {
        ExpedienteCreditoId = expedienteCreditoId;
    }


    public String getProcesoNombre() {
        return ProcesoNombre;
    }

    public void setProcesoNombre(String procesoNombre) {
        ProcesoNombre = procesoNombre;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String observacion) {
        Observacion = observacion;
    }

    public int getCodigoUsuarioCreacion() {
        return CodigoUsuarioCreacion;
    }

    public void setCodigoUsuarioCreacion(int codigoUsuarioCreacion) {
        CodigoUsuarioCreacion = codigoUsuarioCreacion;
    }

    public int getProcesoId() {
        return ProcesoId;
    }

    public void setProcesoId(int procesoId) {
        ProcesoId = procesoId;
    }

    public String getDiaAgenda() {
        return DiaAgenda;
    }

    public void setDiaAgenda(String diaAgenda) {
        DiaAgenda = diaAgenda;
    }

    public String getStrDiaAgenda() {
        return strDiaAgenda;
    }

    public void setStrDiaAgenda(String strDiaAgenda) {
        this.strDiaAgenda = strDiaAgenda;
    }

    public String getStrFecha() {
        return strFecha;
    }

    public void setStrFecha(String strFecha) {
        this.strFecha = strFecha;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        ItemId = itemId;
    }
}
