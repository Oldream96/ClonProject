package pe.com.hatunsol.hatunsolmovil.modules.encuestas.domain.usecase;

import pe.com.hatunsol.hatunsolmovil.modules.encuestas.data.source.EncuestasRepository;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public class GetUsuario {
    private EncuestasRepository repository;

    public GetUsuario(EncuestasRepository repository) {
        this.repository = repository;
    }

    public GetUsuario.Response execute(){
        return new GetUsuario.Response(repository.getUsuario());
    }

    public class Response{
        private Usuario usuario;
        public Response(Usuario usuario) {
            this.usuario = usuario;
        }
        public Usuario getUsuario() {
            return usuario;
        }
    }

}
