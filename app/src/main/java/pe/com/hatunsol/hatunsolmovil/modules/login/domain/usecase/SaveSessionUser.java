package pe.com.hatunsol.hatunsolmovil.modules.login.domain.usecase;

import pe.com.hatunsol.hatunsolmovil.base.UseCase;
import pe.com.hatunsol.hatunsolmovil.modules.login.data.source.LoginRepository;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public class SaveSessionUser  {

    public LoginRepository repository;

    public SaveSessionUser(LoginRepository repository) {
        this.repository = repository;
    }

    public ResponseValues execute(RequestValues requestValues){
        return new ResponseValues(repository.saveUserSession(requestValues.getUsuario()));
    }

    public static class RequestValues implements UseCase.RequestValues{
        public Usuario usuario;

        public RequestValues(Usuario usuario) {
            this.usuario = usuario;
        }

        public Usuario getUsuario() {
            return usuario;
        }
    }

    public static class ResponseValues implements UseCase.ResponseValue{
        public boolean state;

        public ResponseValues(boolean state) {
            this.state = state;
        }

        public boolean isState() {
            return state;
        }
    }

}
