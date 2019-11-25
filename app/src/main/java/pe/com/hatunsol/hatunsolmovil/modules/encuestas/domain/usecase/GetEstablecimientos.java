package pe.com.hatunsol.hatunsolmovil.modules.encuestas.domain.usecase;

import java.util.List;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.data.source.EncuestasRepository;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.ProveedorLocalUi;

public class GetEstablecimientos {

    private EncuestasRepository repository;

    public GetEstablecimientos(EncuestasRepository repository) {
        this.repository = repository;
    }

    public Response execute(){
        return new Response(repository.getEstablecimientos());
    }

    public static class Response{
        private List<ProveedorLocalUi> proveedorLocalUiList;

        public Response(List<ProveedorLocalUi> proveedorLocalUiList) {
            this.proveedorLocalUiList = proveedorLocalUiList;
        }

        public List<ProveedorLocalUi> getProveedorLocalUiList() {
            return proveedorLocalUiList;
        }
    }
}
