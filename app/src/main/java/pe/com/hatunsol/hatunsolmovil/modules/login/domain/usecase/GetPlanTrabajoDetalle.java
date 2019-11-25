package pe.com.hatunsol.hatunsolmovil.modules.login.domain.usecase;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.base.UseCase;
import pe.com.hatunsol.hatunsolmovil.modules.login.data.source.LoginRepository;
import pe.com.hatunsol.hatunsolmovil.modules.login.data.source.remoto.RemotoDataSourceInterface;
import pe.com.hatunsol.hatunsolmovil.services.entities.ProveedorLocal;

public class GetPlanTrabajoDetalle extends UseCase<GetPlanTrabajoDetalle.Request, GetPlanTrabajoDetalle.Response>{

    private LoginRepository repository;

    public GetPlanTrabajoDetalle(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void executeUseCase(Request requestValues) {
//        repository.sincronizarDataProvedorLocal(requestValues.cargoId, requestValues.usuarioId, new RemotoDataSourceInterface.Callback<List<ProveedorLocal>>() {
//            @Override
//            public void load(boolean state, List<ProveedorLocal> item) {
//                getUseCaseCallback().onSuccess(new Response(item));
//            }
//        });
    }

    //UseCase clase abstracta creado por Sol
    public static class Request implements UseCase.RequestValues{
        private int cargoId;
        private int usuarioId;

        public Request(int cargoId, int usuarioId) {
            this.cargoId = cargoId;
            this.usuarioId = usuarioId;
        }

        public int getCargoId() {
            return cargoId;
        }

        public int getUsuarioId() {
            return usuarioId;
        }
    }

    public static  class Response implements UseCase.ResponseValue{
        private List<ProveedorLocal> proveedorLocalList;

        public Response(List<ProveedorLocal> proveedorLocalList) {
            this.proveedorLocalList = proveedorLocalList;
        }

        public List<ProveedorLocal> getProveedorLocalList() {
            return proveedorLocalList;
        }
    }

}
