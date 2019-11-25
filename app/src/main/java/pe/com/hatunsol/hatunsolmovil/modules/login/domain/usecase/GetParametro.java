package pe.com.hatunsol.hatunsolmovil.modules.login.domain.usecase;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.base.UseCase;
import pe.com.hatunsol.hatunsolmovil.modules.login.data.source.LoginRepository;
import pe.com.hatunsol.hatunsolmovil.modules.login.data.source.remoto.RemotoDataSourceInterface;
import pe.com.hatunsol.hatunsolmovil.services.entities.Parametro;

public class GetParametro extends UseCase<GetParametro.RequestValues, GetParametro.ResponseValues> {

    public LoginRepository repository;

    public GetParametro(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        repository.sincronizarDataParametro(new RemotoDataSourceInterface.Callback<List<Parametro>>() {
            @Override
            public void load(boolean state, List<Parametro> item) {
                getUseCaseCallback().onSuccess(new ResponseValues(item));
            }
        });
    }

    public static class RequestValues implements UseCase.RequestValues{

    }
    public static class ResponseValues implements UseCase.ResponseValue{
        private List<Parametro> parametroList;

        public ResponseValues(List<Parametro> parametroList) {
            this.parametroList = parametroList;
        }

        public List<Parametro> getParametroList() {
            return parametroList;
        }
    }
}
