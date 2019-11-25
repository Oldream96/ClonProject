package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.domain;

import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.SabadoProductivoRepository;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public class GetUsuario {

    private SabadoProductivoRepository repository;

    public GetUsuario(SabadoProductivoRepository repository) {
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