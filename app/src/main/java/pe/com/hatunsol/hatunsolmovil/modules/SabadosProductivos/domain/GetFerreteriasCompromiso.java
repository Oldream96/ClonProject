package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.domain;

import java.util.Date;
import java.util.List;

import pe.com.hatunsol.hatunsolmovil.base.UseCase;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.SabadoProductivoRepository;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.remoto.SPRemotoDataSourceInterface;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.entities.ProveedorLocalUi;

public class GetFerreteriasCompromiso extends UseCase<GetFerreteriasCompromiso.Request, GetFerreteriasCompromiso.Response> {

    private SabadoProductivoRepository repository;

    public GetFerreteriasCompromiso(SabadoProductivoRepository repository) {
        this.repository = repository;
    }


    @Override
    protected void executeUseCase(Request requestValues) {
        String compromisotipo = requestValues.getNombreCompromiso();
        if (compromisotipo.equals("COMPROMISO DE FERRETERÍAS")) {
            repository.GetFerreteriasCompromiso(requestValues.getUsuarioId(), requestValues.getFecha(), requestValues.getNombreCompromiso(), new SPRemotoDataSourceInterface.Callback<List<ProveedorLocalUi>>() {
                @Override
                public void load(boolean state, List<ProveedorLocalUi> item) {
                    if (state) getUseCaseCallback().onSuccess(new Response(item));
                    else getUseCaseCallback().onError();
                }
            });
        } else if (compromisotipo.equals("COMPROMISO DE DERIVADOS")) {
            repository.GetDerivadosCompromiso(requestValues.getUsuarioId(), requestValues.getFecha(), requestValues.getNombreCompromiso(), new SPRemotoDataSourceInterface.Callback<List<ProveedorLocalUi>>() {
                @Override
                public void load(boolean state, List<ProveedorLocalUi> item) {
                    if (state) getUseCaseCallback().onSuccess(new Response(item));
                    else getUseCaseCallback().onError();
                }
            });
        } else if (compromisotipo.equals("COMPROMISO DE ACTIVADOS")) {
            repository.GetActivadosCompromiso(requestValues.getUsuarioId(), requestValues.getFecha(), requestValues.getNombreCompromiso(), new SPRemotoDataSourceInterface.Callback<List<ProveedorLocalUi>>() {
                @Override
                public void load(boolean state, List<ProveedorLocalUi> item) {
                    if (state) getUseCaseCallback().onSuccess(new Response(item));
                    else getUseCaseCallback().onError();
                }
            });
        }
    }


    public static class Request implements UseCase.RequestValues {
        private int usuarioId;
        private String fecha;
        private String nombreCompromiso;

        public Request(int usuarioId, String fecha, String nombreCompromiso) {
            this.usuarioId = usuarioId;
            this.fecha = fecha;
            this.nombreCompromiso = nombreCompromiso;
        }

        public int getUsuarioId() {
            return usuarioId;
        }

        public String getFecha() {
            return fecha;
        }

        public String getNombreCompromiso() {
            return nombreCompromiso;
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
