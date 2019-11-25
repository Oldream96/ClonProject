package pe.com.hatunsol.hatunsolmovil.modules.login.domain.usecase;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.base.UseCase;
import pe.com.hatunsol.hatunsolmovil.modules.login.data.source.LoginRepository;
import pe.com.hatunsol.hatunsolmovil.modules.login.data.source.remoto.RemotoDataSourceInterface;
import pe.com.hatunsol.hatunsolmovil.services.entities.Ubigeo;

public class GetUbigeos extends UseCase<GetUbigeos.RequestValues, GetUbigeos.ResponseValues> {

    private LoginRepository repository;

    public GetUbigeos(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        repository.sincronizeDataUbigeo(new RemotoDataSourceInterface.Callback<List<Ubigeo>>() {
            @Override
            public void load(boolean state, List<Ubigeo> item) {
                getUseCaseCallback().onSuccess(new ResponseValues(item));
            }
        });
    }

    public static class RequestValues implements UseCase.RequestValues{
        public RequestValues() {
        }
    }

    public static class ResponseValues implements UseCase.ResponseValue{
        private List<Ubigeo> ubigeoList;

        public ResponseValues(List<Ubigeo> ubigeoList) {
            this.ubigeoList = ubigeoList;
        }

        public List<Ubigeo> getUbigeoList() {
            return ubigeoList;
        }
    }
}
