package pe.com.hatunsol.hatunsolmovil.services.entities;

import java.util.List;

public class ResponseProveedor {

    private List<ProveedorLocal> LocalesResult;

    public ResponseProveedor() {
    }

    public List<ProveedorLocal> getLocalesResult() {
        return LocalesResult;
    }

    public void setLocalesResult(List<ProveedorLocal> localesResult) {
        LocalesResult = localesResult;
    }
}


