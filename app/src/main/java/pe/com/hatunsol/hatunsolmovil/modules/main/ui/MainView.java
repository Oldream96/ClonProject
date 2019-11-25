package pe.com.hatunsol.hatunsolmovil.modules.main.ui;

import pe.com.hatunsol.hatunsolmovil.base.activity.BaseView;
import pe.com.hatunsol.hatunsolmovil.modules.main.presenter.MainPresenter;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public interface MainView extends BaseView<MainPresenter> {
    void starLoginActivity();

    void close();

    void onFragmentInitCreditos();

    void onFragmentInitCrompromisos();

    void onFragmentInitRegistrarAsistencia();
    void onFragmentInitEncuestas();

    void showUser(Usuario usuario);

    void showInitCreditosFragment();

    void showUserInformation(Usuario usuario);

    void onPhoneCall();

    void onActivityInitAfiliacion();


}
