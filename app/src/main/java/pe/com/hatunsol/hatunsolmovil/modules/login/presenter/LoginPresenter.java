package pe.com.hatunsol.hatunsolmovil.modules.login.presenter;

import pe.com.hatunsol.hatunsolmovil.base.activity.BasePresenter;
import pe.com.hatunsol.hatunsolmovil.modules.login.ui.LoginView;

public interface LoginPresenter extends BasePresenter<LoginView> {
    void onClickButtonLogin(String user, String password);
}
