package pe.com.hatunsol.hatunsolmovil.services.entities;

import java.util.List;

public class ResponseResult<T> {

    private List<T> ListarResult;

    public ResponseResult() {
    }

    public List<T> getListarResult() {
        return ListarResult;
    }

    public void setListarResult(List<T> listarResult) {
        ListarResult = listarResult;
    }
}
