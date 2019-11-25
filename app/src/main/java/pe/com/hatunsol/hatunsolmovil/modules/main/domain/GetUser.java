package pe.com.hatunsol.hatunsolmovil.modules.main.domain;

import pe.com.hatunsol.hatunsolmovil.modules.main.data.source.MainRepository;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public class GetUser {

    private MainRepository repository;

    public GetUser(MainRepository repository) {
        this.repository = repository;
    }

    public Response execute(){
        return new Response(repository.getUser());
    }

    public static class Response{
        private Usuario usuario;

        public Response(Usuario usuario) {
            this.usuario = usuario;
        }

        public Usuario getUsuario() {
            return usuario;
        }

    }
}
