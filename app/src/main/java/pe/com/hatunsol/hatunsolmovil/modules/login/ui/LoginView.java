package pe.com.hatunsol.hatunsolmovil.modules.login.ui;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.base.activity.BaseView;
import pe.com.hatunsol.hatunsolmovil.modules.login.presenter.LoginPresenter;
import pe.com.hatunsol.hatunsolmovil.services.entities.ProveedorLocal;

public interface LoginView extends BaseView<LoginPresenter> {
    void onShowUserFail();

    void onShowPasswordFail();

    void showProgressBar();

    void hideProgressBar();

    void initActivity();

    void showPlatrabajo(List<ProveedorLocal> proveedorLocalList);

    void connectyServer();

    void ValidarDatos();

}
