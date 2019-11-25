package pe.com.hatunsol.hatunsolmovil.modules.main.entities;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.services.entities.ProveedorLocal;

public class ResponseEstablecimiento {

    private List<ProveedorLocal> ListarResult;

    public ResponseEstablecimiento() {
    }

    public List<ProveedorLocal> getListarResult() {
        return ListarResult;
    }

    public void setListarResult(List<ProveedorLocal> listarResult) {
        ListarResult = listarResult;
    }



}
