package pe.com.hatunsol.hatunsolmovil.modules.encuestas.domain.usecase;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.base.UseCase;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.data.source.EncuestasRepository;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.data.source.remoto.IEncuestaRemotoDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.PreguntaUi;
import pe.com.hatunsol.hatunsolmovil.services.entities.Encuesta;

public class GetEncuesta extends UseCase<GetEncuesta.RequestValues, GetEncuesta.Response> {


    EncuestasRepository repository;

    public GetEncuesta(EncuestasRepository repository) {
        this.repository = repository;
    }
    @Override
    protected void executeUseCase(RequestValues requestValues) {
        repository.getEncuesta(requestValues.idencuesta, requestValues.idencuestausuario, new IEncuestaRemotoDataSource.Callback<Encuesta>() {
            @Override
            public void load(boolean state, Encuesta item) {
                getUseCaseCallback().onSuccess(new GetEncuesta.Response(item));
            }
        });
    }


    public static class RequestValues implements UseCase.RequestValues {
        private int idencuesta;
        private int idencuestausuario;

        public int getIdencuesta() {
            return idencuesta;
        }

        public int getIdencuestausuario() {
            return idencuestausuario;
        }

        public RequestValues(int idencuesta, int idencuestausuario) {
            this.idencuestausuario = idencuestausuario;
            this.idencuesta = idencuesta;
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
