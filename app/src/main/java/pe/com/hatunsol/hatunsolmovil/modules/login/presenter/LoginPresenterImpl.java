package pe.com.hatunsol.hatunsolmovil.modules.login.presenter;

import android.content.res.Resources;
import android.os.Bundle;

import pe.com.hatunsol.hatunsolmovil.base.UseCase;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseHandler;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseSincrono;
import pe.com.hatunsol.hatunsolmovil.base.activity.BasePresenterImpl;
import pe.com.hatunsol.hatunsolmovil.modules.login.domain.usecase.GetParametro;
import pe.com.hatunsol.hatunsolmovil.modules.login.domain.usecase.GetPersonas;
import pe.com.hatunsol.hatunsolmovil.modules.login.domain.usecase.GetPlanTrabajoDetalle;
import pe.com.hatunsol.hatunsolmovil.modules.login.domain.usecase.GetUbigeos;
import pe.com.hatunsol.hatunsolmovil.modules.login.domain.usecase.GetUser;
import pe.com.hatunsol.hatunsolmovil.modules.login.domain.usecase.SaveParametros;
import pe.com.hatunsol.hatunsolmovil.modules.login.domain.usecase.SavePersonas;
import pe.com.hatunsol.hatunsolmovil.modules.login.domain.usecase.SaveProvedorLocal;
import pe.com.hatunsol.hatunsolmovil.modules.login.domain.usecase.SaveSessionUser;
import pe.com.hatunsol.hatunsolmovil.modules.login.domain.usecase.SaveUbigeos;
import pe.com.hatunsol.hatunsolmovil.modules.login.entities.SincronizacionEstado;
import pe.com.hatunsol.hatunsolmovil.modules.login.ui.LoginView;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public class LoginPresenterImpl extends BasePresenterImpl<LoginView> implements LoginPresenter{

    private GetUser getUser;
    private SaveSessionUser saveSessionUser;
    private GetUbigeos getUbigeos;
    private GetParametro getParametro;
    private SaveParametros saveParametros;
    private SaveUbigeos saveUbigeos;
    private GetPlanTrabajoDetalle getPlanTrabajoDetalle;
    private SincronizacionEstado sincronizacionEstado =  new SincronizacionEstado();
    private SaveProvedorLocal saveProvedorLocal;
    private Usuario usuario;
    private GetPersonas getPersonas;
    private SavePersonas savePersonas;

    public LoginPresenterImpl(UseCaseHandler handler, Resources res, GetUser getUser, SaveSessionUser saveSessionUser, GetUbigeos getUbigeos, GetParametro getParametro, SaveParametros saveParametros, SaveUbigeos saveUbigeos,
                              GetPlanTrabajoDetalle getPlanTrabajoDetalle, SaveProvedorLocal saveProvedorLocal, SavePersonas savePersonas, GetPersonas getPersonas) {
        super(handler, res);
        this.getUser = getUser;
        this.saveSessionUser = saveSessionUser;
        this.getUbigeos = getUbigeos;
        this.getParametro = getParametro;
        this.saveParametros = saveParametros;
        this.saveUbigeos = saveUbigeos;
        this.getPlanTrabajoDetalle = getPlanTrabajoDetalle;
        this.saveProvedorLocal = saveProvedorLocal;
        this.getPersonas = getPersonas;
        this.savePersonas = savePersonas;
    }

    @Override
    protected String getTag() {
        return LoginPresenterImpl.class.getSimpleName();
    }


    @Override
    public void setExtras(Bundle extras) {
        super.setExtras(extras);
    }

    @Override
    public void onClickButtonLogin(String user, String password) {
        getUser.execute(new GetUser.RequestValues(user, password), new UseCaseSincrono.Callback<GetUser.ResponseValues>() {
            @Override
            public void onResponse(boolean success, GetUser.ResponseValues value) {
                if (success==false){
                    if (view!=null)view.connectyServer();
                }else {
                    switch (value.getUsuario().getTipoId()){
                        case Usuario.ACCESS:
                            usuario = value.getUsuario();
                            onSaveSessionUser(value.getUsuario());
                            sincronizeData();
                            break;
                        case Usuario.PASSWORD_FAIL:
                            onShowPasswordFail();
                            break;
                        case Usuario.USER_FAIL:
                            onShowUserFail();
                            break;
                        case Usuario.DNI_NULL:
                                ValidarDatos();
                            break;
                    }
                }
            }
        });
    }

        private void ValidarDatos(){
            if(view!=null)view.ValidarDatos();

        }

    private void onShowUserFail() {
        if (view!=null)view.onShowUserFail();
    }

    private void onShowPasswordFail() {
        if (view!=null)view.onShowPasswordFail();
    }

    private void sincronizeData(){
        if (view!=null)view.showProgressBar();
        if (sincronizacionEstado.isSincronizacionParametros() && sincronizacionEstado.isSincronizacionUbigeo()
//                && sincronizacionEstado.isSincronizarProveedorLocal()
                //&& sincronizacionEstado.isSincronizarPersonas()
        ){
            if (view!=null){
                view.hideProgressBar();
                view.initActivity();
            }
        }else if (!sincronizacionEstado.isSincronizacionParametros()) {
            sincronizeParametro();
        }else if (!sincronizacionEstado.isSincronizacionUbigeo()) {
            sincronizeDataUbigeo();
        }
//        else if (!sincronizacionEstado.isSincronizarProveedorLocal()) {
//            sincronizePlanTrabajoDetalle();
//        }
//        else if (!sincronizacionEstado.isSincronizarPersonas()) {
//            sincronizarPersonas();
//        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    private void sincronizePlanTrabajoDetalle() {
        handler.execute(getPlanTrabajoDetalle, new GetPlanTrabajoDetalle.Request(usuario.getCargoId(), usuario.getCodigoUsuario()), new UseCase.UseCaseCallback<GetPlanTrabajoDetalle.Response>() {
            @Override
            public void onSuccess(GetPlanTrabajoDetalle.Response response) {
                SaveProvedorLocal.Response responseV = saveProvedorLocal.execute(new SaveProvedorLocal.Request(response.getProveedorLocalList()));
                sincronizacionEstado.setSincronizarProveedorLocal(responseV.isState());
                sincronizeData();
            }

            @Override
            public void onError() {
                //if (view!=null)view.showDialogChargeAgain("Plan TRABAJO DETALLE")
            }
        });
    }

    private void onSaveSessionUser(Usuario usuario) {
        SaveSessionUser.ResponseValues responseValues = saveSessionUser.execute(new SaveSessionUser.RequestValues(usuario));
    }

    public void sincronizeDataUbigeo(){
        handler.execute(getUbigeos, new GetUbigeos.RequestValues(), new UseCase.UseCaseCallback<GetUbigeos.ResponseValues>() {
            @Override
            public void onSuccess(GetUbigeos.ResponseValues response) {
                SaveUbigeos.ResponseValues responseValues =  saveUbigeos.execute(new SaveUbigeos.RequestValues(response.getUbigeoList()));
                sincronizacionEstado.setSincronizacionUbigeo(responseValues.isState());
                sincronizeData();
            }

            @Override
            public void onError() {

            }
        });
    }

    public void sincronizeParametro(){
        handler.execute(getParametro, new GetParametro.RequestValues(), new UseCase.UseCaseCallback<GetParametro.ResponseValues>() {
            @Override
            public void onSuccess(GetParametro.ResponseValues response) {
                SaveParametros.ResponseValues responseValues = saveParametros.execute(new SaveParametros.RequestValues(response.getParametroList()));
                sincronizacionEstado.setSincronizacionParametros(responseValues.isState());
                sincronizeData();
            }

            @Override
            public void onError() {

            }
        });
    }

    public void sincronizarPersonas(){
        handler.execute(getPersonas, new GetPersonas.Request(usuario), new UseCase.UseCaseCallback<GetPersonas.Response>() {
            @Override
            public void onSuccess(GetPersonas.Response response) {
                SavePersonas.Response responseSave = savePersonas.execute(new SavePersonas.Request(response.getPersonaList()));
                sincronizacionEstado.setSincronizarPersonas(responseSave.isState());
                sincronizeData();
            }

            @Override
            public void onError() {

            }
        });
    }

}
