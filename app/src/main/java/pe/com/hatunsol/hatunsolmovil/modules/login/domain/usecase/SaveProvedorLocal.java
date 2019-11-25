package pe.com.hatunsol.hatunsolmovil.modules.login.domain.usecase;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.modules.login.data.source.LoginRepository;
import pe.com.hatunsol.hatunsolmovil.services.entities.ProveedorLocal;

public class SaveProvedorLocal {

    private LoginRepository repository;

    public SaveProvedorLocal(LoginRepository repository) {
        this.repository = repository;
    }

    public  Response execute(Request request){
        return new Response(repository.saveProveedorLocal(request.proveedorLocals));
    }

    public static class Response{
        private boolean state;

        public Response(boolean state) {
            this.state = state;
        }

        public boolean isState() {
            return state;
        }
    }

    public static class Request{
        private List<ProveedorLocal> proveedorLocals;

        public Request(List<ProveedorLocal> proveedorLocals) {
            this.proveedorLocals = proveedorLocals;
        }

        public List<ProveedorLocal> getProveedorLocals() {
            return proveedorLocals;
        }
    }
}
