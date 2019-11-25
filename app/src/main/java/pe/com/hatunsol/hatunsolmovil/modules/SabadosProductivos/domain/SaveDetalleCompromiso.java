package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.domain;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.base.UseCase;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.SabadoProductivoRepository;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.remoto.SPRemotoDataSourceInterface;
import pe.com.hatunsol.hatunsolmovil.services.entities.Persona;

public class SaveDetalleCompromiso extends UseCase<SaveDetalleCompromiso.RequestValues, SaveDetalleCompromiso.ResponseValues> {

    private SabadoProductivoRepository repository;

    public SaveDetalleCompromiso(SabadoProductivoRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {

        repository.onSaveDetalleCompromiso(requestValues.personaList,requestValues.tipoCompromiso, new SPRemotoDataSourceInterface.Callback<Integer>() {
            @Override
            public void load(boolean state, Integer item) {
                if(state){
                    getUseCaseCallback().onSuccess(new SaveDetalleCompromiso.ResponseValues(item));
                } else {
                    getUseCaseCallback().onError();
                }

            }
        });

    }

    public static class RequestValues implements UseCase.RequestValues{
        private List<Persona> personaList;
        private Integer tipoCompromiso;

        public Integer getTipoCompromiso() {
            return tipoCompromiso;
        }

        public void setTipoCompromiso(Integer tipoCompromiso) {
            this.tipoCompromiso = tipoCompromiso;
        }

        public RequestValues(List<Persona> personaList,Integer tipoCompromiso) {
            this.personaList = personaList;
            this.tipoCompromiso= tipoCompromiso;
        }

        public List<Persona> getPersonaList() {
            return personaList;
        }

        public void setPersonaList(List<Persona> personaList) {
            this.personaList = personaList;
        }
    }
    public static class ResponseValues implements UseCase.ResponseValue{
        private Integer respuesta;

        public ResponseValues(Integer integer) {
            this.respuesta = integer;
        }

        public Integer getRespuesta() {
            return respuesta;
        }

        public void setRespuesta(Integer integer) {
            this.respuesta = integer;
        }
    }
}
