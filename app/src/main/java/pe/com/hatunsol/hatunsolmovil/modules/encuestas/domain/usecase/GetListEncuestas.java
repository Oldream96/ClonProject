package pe.com.hatunsol.hatunsolmovil.modules.encuestas.domain.usecase;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.base.UseCase;
import pe.com.hatunsol.hatunsolmovil.modules.creditos.domain.usecase.GetCreditos;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.data.source.EncuestasRepository;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.data.source.remoto.IEncuestaRemotoDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.EncuestaUi;

public class GetListEncuestas extends UseCase<GetListEncuestas.RequestValues, GetListEncuestas.Response> {

    EncuestasRepository repository;


    public GetListEncuestas(EncuestasRepository repository) {
        this.repository = repository;
    }

//Sincrono
/*
    public GetCreditos.ResponseValues execute(GetListEncuestas.RequestValues requestValues){
        return new GetListEncuestas(repository.getListEncuestas(requestValues.getUserid(),requestValues.getCargoid(),requestValues.getNombrecomercial()));
    }*/


    //Asincrono
    @Override
    protected void executeUseCase(RequestValues requestValues) {
        repository.getListEncuestas(requestValues.userid, requestValues.cargoid, requestValues.nombrecomercial, requestValues.mes, requestValues.anio, new IEncuestaRemotoDataSource.Callback<List<EncuestaUi>>() {
            @Override
            public void load(boolean state, List<EncuestaUi> item) {
                getUseCaseCallback().onSuccess(new Response(item));
            }
        });
    }

    public static class RequestValues implements UseCase.RequestValues {
        private int userid;
        private int cargoid;
        private String nombrecomercial;
        private int mes;
        private int anio;

        public int getMes() {
            return mes;
        }

        public int getAnio() {
            return anio;
        }

        public int getUserid() {
            return userid;
        }

        public int getCargoid() {
            return cargoid;
        }

        public String getNombrecomercial() {
            return nombrecomercial;
        }


        public RequestValues(int userid, int cargoid, String nombrecomercial, int mes, int anio) {
            this.userid = userid;
            this.cargoid = cargoid;
            this.nombrecomercial = nombrecomercial;
            this.mes = mes;
            this.anio = anio;
        }
    }

    public static class Response implements UseCase.ResponseValue {
        private List<EncuestaUi> encuestaUiList;

        public Response(List<EncuestaUi> encuestaUiList) {
            this.encuestaUiList = encuestaUiList;
        }

        public List<EncuestaUi> getEncuestaUiList() {
            return encuestaUiList;
        }
    }


}
