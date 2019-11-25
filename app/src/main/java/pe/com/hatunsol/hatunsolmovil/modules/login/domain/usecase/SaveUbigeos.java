package pe.com.hatunsol.hatunsolmovil.modules.login.domain.usecase;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.base.UseCase;
import pe.com.hatunsol.hatunsolmovil.modules.login.data.source.LoginRepository;
import pe.com.hatunsol.hatunsolmovil.services.entities.Ubigeo;

public class SaveUbigeos  {

    private LoginRepository repository;

    public SaveUbigeos(LoginRepository repository) {
        this.repository = repository;
    }

    public ResponseValues execute(RequestValues requestValues){
        return new ResponseValues(repository.saveUbigeo(requestValues.ubigeoList));
    }


    public static class RequestValues implements UseCase.RequestValues{
        private List<Ubigeo> ubigeoList;

        public RequestValues(List<Ubigeo> ubigeoList) {
            this.ubigeoList = ubigeoList;
        }

        public List<Ubigeo> getUbigeoList() {
            return ubigeoList;
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
