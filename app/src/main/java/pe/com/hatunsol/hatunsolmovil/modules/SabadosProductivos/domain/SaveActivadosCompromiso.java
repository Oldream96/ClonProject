package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.domain;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.base.UseCase;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.SabadoProductivoRepository;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.remoto.SPRemotoDataSourceInterface;
import pe.com.hatunsol.hatunsolmovil.services.entities.Persona;

public class SaveActivadosCompromiso extends UseCase<SaveActivadosCompromiso.RequestValues,SaveActivadosCompromiso.ResponseValues> {

    private SabadoProductivoRepository repository;

    public SaveActivadosCompromiso(SabadoProductivoRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void executeUseCase(SaveActivadosCompromiso.RequestValues requestValues) {

        repository.onSaveActivadosCompromiso(requestValues.personaList, new SPRemotoDataSourceInterface.Callback<Integer>() {
            @Override
            public void load(boolean state, Integer item) {
                getUseCaseCallback().onSuccess(new SaveActivadosCompromiso.ResponseValues(item));
            }
        });

    }

    public static class RequestValues implements UseCase.RequestValues{
        private List<Persona> personaList;

        public RequestValues(List<Persona> personaList) {
            this.personaList = personaList;
        }

        public List<Persona> getPersonaList() {
            return personaList;
        }

        public void setPersonaList(List<Persona> personaList) {
            this.personaList = personaList;
        }
    }
    public static class ResponseValues implements UseCase.ResponseValue{
        private Integer persona;

        public ResponseValues(Integer persona) {
            this.persona = persona;
        }

        public Integer getPersona() {
            return persona;
        }

        public void setPersona(Integer persona) {
            this.persona = persona;
        }
    }
}