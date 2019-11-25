package pe.com.hatunsol.hatunsolmovil.modules.login.domain.usecase;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.modules.login.data.source.LoginRepository;
import pe.com.hatunsol.hatunsolmovil.services.entities.Parametro;

public class SaveParametros {

    private LoginRepository repository;

    public SaveParametros(LoginRepository repository) {
        this.repository = repository;
    }

    public ResponseValues execute(RequestValues requestValues){
        return new ResponseValues(repository.saveParametros(requestValues.parametroList));
    }


    public static class RequestValues{
        public List<Parametro> parametroList;

        public RequestValues(List<Parametro> parametroList) {
            this.parametroList = parametroList;
        }

        public List<Parametro> getParametroList() {
            return parametroList;
        }
    }

    public static class ResponseValues{
        public boolean state;

        public ResponseValues(boolean state) {
            this.state = state;
        }

        public boolean isState() {
            return state;
        }
    }
}
