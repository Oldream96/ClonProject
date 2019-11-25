package pe.com.hatunsol.hatunsolmovil.modules.login.domain.usecase;

import pe.com.hatunsol.hatunsolmovil.base.UseCase;
import pe.com.hatunsol.hatunsolmovil.modules.login.data.source.LoginRepository;

public class SincronizeData  extends UseCase<SincronizeData.RequestValues, SincronizeData.ResponseValues>{

    public LoginRepository repository;

    public SincronizeData(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {

    }

    public static class RequestValues implements UseCase.RequestValues{

    }

    public static class ResponseValues implements UseCase.ResponseValue{

    }
}
