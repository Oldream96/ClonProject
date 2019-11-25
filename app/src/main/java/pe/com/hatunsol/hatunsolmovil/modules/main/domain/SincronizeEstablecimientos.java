package pe.com.hatunsol.hatunsolmovil.modules.main.domain;

import pe.com.hatunsol.hatunsolmovil.base.UseCase;
import pe.com.hatunsol.hatunsolmovil.modules.main.data.source.MainRepository;
import pe.com.hatunsol.hatunsolmovil.modules.main.data.source.remoto.IMainRemotoDataSource;

public class SincronizeEstablecimientos extends UseCase<SincronizeEstablecimientos.RequestValues, SincronizeEstablecimientos.ResponseValues> {

    private MainRepository repository;

    public SincronizeEstablecimientos(MainRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        repository.sincronizarEstablecimientos(requestValues.getCargoId(), requestValues.getEmpleadoId(), requestValues.getLocalId(), requestValues.getFiltroId(), requestValues.getOffset(), new IMainRemotoDataSource.Callback<Boolean>() {
            @Override
            public void onLoad(Boolean item) {
                getUseCaseCallback().onSuccess(new ResponseValues(item));
            }
        });
    }

    public static class RequestValues implements UseCase.RequestValues{
        private int cargoId;
        private int empleadoId;
        private int localId;
        private int filtroId;
        private int offset;

        public RequestValues(int cargoId, int empleadoId, int localId, int filtroId, int offset) {
            this.cargoId = cargoId;
            this.empleadoId = empleadoId;
            this.localId = localId;
            this.filtroId = filtroId;
            this.offset = offset;
        }

        public int getCargoId() {
            return cargoId;
        }

        public int getEmpleadoId() {
            return empleadoId;
        }

        public int getLocalId() {
            return localId;
        }

        public int getFiltroId() {
            return filtroId;
        }

        public int getOffset() {
            return offset;
        }
    }

    public static class ResponseValues implements UseCase.ResponseValue{
        private Boolean state;

        public ResponseValues(Boolean state) {
            this.state = state;
        }

        public Boolean getState() {
            return state;
        }
    }
}
