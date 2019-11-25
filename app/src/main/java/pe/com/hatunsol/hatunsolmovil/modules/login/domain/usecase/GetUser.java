package pe.com.hatunsol.hatunsolmovil.modules.login.domain.usecase;

import pe.com.hatunsol.hatunsolmovil.base.UseCase;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseSincrono;
import pe.com.hatunsol.hatunsolmovil.modules.login.data.source.LoginRepository;
import pe.com.hatunsol.hatunsolmovil.modules.login.data.source.remoto.RemotoDataSourceInterface;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public class GetUser extends UseCaseSincrono<GetUser.RequestValues, GetUser.ResponseValues> {

    private LoginRepository repository;

    public GetUser(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(RequestValues request, Callback<ResponseValues> callback) {
        repository.loginUser(request.getUsuario(), request.getPassword(), new RemotoDataSourceInterface.Callback<Usuario>() {
            @Override
            public void load(boolean state, Usuario item) {
                callback.onResponse(state, new ResponseValues(item));
            }
        });
    }

    public static class RequestValues implements UseCase.RequestValues{
        private String usuario;
        private String password;

        public RequestValues(String usuario, String password) {
            this.usuario = usuario;
            this.password = password;
        }

        public String getUsuario() {
            return usuario;
        }

        public String getPassword() {
            return password;
        }
    }

    public static class ResponseValues implements UseCase.ResponseValue{
        private Usuario usuario;

        public ResponseValues(Usuario usuario) {
            this.usuario = usuario;
        }

        public Usuario getUsuario() {
            return usuario;
        }
    }
}
