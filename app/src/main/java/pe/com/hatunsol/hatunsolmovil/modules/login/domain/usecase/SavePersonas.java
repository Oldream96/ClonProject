package pe.com.hatunsol.hatunsolmovil.modules.login.domain.usecase;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.modules.login.data.source.LoginRepository;
import pe.com.hatunsol.hatunsolmovil.services.entities.Persona;

public class SavePersonas {

    private LoginRepository repository;

    public SavePersonas(LoginRepository repository) {
        this.repository = repository;
    }

    public Response execute(Request request){
        return new Response(repository.savePersona(request.getPersonaList()));
    }

    public static class Request{
        private List<Persona> personaList;

        public Request(List<Persona> personaList) {
            this.personaList = personaList;
        }

        public List<Persona> getPersonaList() {
            return personaList;
        }
    }
    public static class Response {
        private boolean state;

        public Response(boolean state) {
            this.state = state;
        }

        public boolean isState() {
            return state;
        }
    }
}
