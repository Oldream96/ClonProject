package pe.com.hatunsol.hatunsolmovil.modules.login.domain.usecase;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.base.UseCase;
import pe.com.hatunsol.hatunsolmovil.modules.login.data.source.LoginRepository;
import pe.com.hatunsol.hatunsolmovil.modules.login.data.source.remoto.RemotoDataSourceInterface;
import pe.com.hatunsol.hatunsolmovil.services.entities.Persona;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public class GetPersonas extends UseCase<GetPersonas.Request, GetPersonas.Response>  {

    private LoginRepository repository;

    public GetPersonas(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void executeUseCase(Request requestValues) {
        repository.sincronizarDataPersonas(requestValues.getUsuario(), new RemotoDataSourceInterface.Callback<List<Persona>>() {
            @Override
            public void load(boolean state, List<Persona> item) {
                getUseCaseCallback().onSuccess(new Response(item));
            }
        });
    }

    public static class Response implements UseCase.ResponseValue{
        private List<Persona> personaList;

        public Response(List<Persona> personaList) {
            this.personaList = personaList;
        }

        public List<Persona> getPersonaList() {
            return personaList;
        }

        public void setPersonaList(List<Persona> personaList) {
            this.personaList = personaList;
        }
    }

    public static class Request implements UseCase.RequestValues{
        private Usuario usuario;

        public Request(Usuario usuario) {
            this.usuario = usuario;
        }

        public Usuario getUsuario() {
            return usuario;
        }
    }
}
