package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.domain;

import java.util.Date;
import java.util.List;

import pe.com.hatunsol.hatunsolmovil.base.UseCase;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.SabadoProductivoRepository;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.remoto.SPRemotoDataSourceInterface;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.entities.ProveedorLocalUi;

public class GetCompromisos extends UseCase<GetCompromisos.Request, GetCompromisos.Response> {
    private SabadoProductivoRepository repository;

    public GetCompromisos(SabadoProductivoRepository repository) {
        this.repository = repository;
    }


    @Override
    protected void executeUseCase(Request requestValues) {
        repository.getCompromisos(requestValues.usuarioId, requestValues.mes, requestValues.anio, new SPRemotoDataSourceInterface.Callback<List<ProveedorLocalUi>>() {
            @Override
            public void load(boolean state, List<ProveedorLocalUi> item) {
                getUseCaseCallback().onSuccess(new Response(item));
            }
        });

    }

    public static class Request implements UseCase.RequestValues {
        private int usuarioId;
        private int mes;
        private int anio;

        public Request(int usuarioId, int mes, int anio) {
            this.usuarioId = usuarioId;
            this.mes = mes;
            this.anio = anio;
        }

        public int getUsuarioId() {
            return usuarioId;
        }
    }

    public static class Response implements UseCase.ResponseValue {
        private List<ProveedorLocalUi> proveedorLocalUiList;

        public Response(List<ProveedorLocalUi> proveedorLocalUiList) {
            this.proveedorLocalUiList = proveedorLocalUiList;
        }

        public List<ProveedorLocalUi> getProveedorLocalUiList() {
            return proveedorLocalUiList;
        }
    }
}
