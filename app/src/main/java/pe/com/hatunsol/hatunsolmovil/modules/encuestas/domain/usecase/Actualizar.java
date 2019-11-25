package pe.com.hatunsol.hatunsolmovil.modules.encuestas.domain.usecase;

import pe.com.hatunsol.hatunsolmovil.base.UseCase;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.data.source.EncuestasRepository;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.data.source.remoto.IEncuestaRemotoDataSource;
import pe.com.hatunsol.hatunsolmovil.services.entities.Encuesta;

public class Actualizar extends UseCase<Actualizar.RequestValues, Actualizar.Response> {


    EncuestasRepository repository;

    public Actualizar(EncuestasRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        repository.Actualizar(requestValues.getEncuesta(),  new IEncuestaRemotoDataSource.Callback<Encuesta>() {
            @Override
            public void load(boolean state, Encuesta item) {
                getUseCaseCallback().onSuccess(new Response(item));
            }
        });
    }

    public static class RequestValues implements UseCase.RequestValues {
        private Encuesta encuesta;

        public Encuesta getEncuesta() {
            return encuesta;
        }

        public RequestValues(Encuesta encuesta) {
            this.encuesta = encuesta;
        }

        public void setEncuesta(Encuesta encuesta) {
            this.encuesta = encuesta;
        }
    }




    public static class Response implements UseCase.ResponseValue {
        private Encuesta encuesta;
        public Response(Encuesta encuesta) {
            this.encuesta = encuesta;
        }

        public Encuesta getEncuesta() {
            return encuesta;
        }
    }



}
