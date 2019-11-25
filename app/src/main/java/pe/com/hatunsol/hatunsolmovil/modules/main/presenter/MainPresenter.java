package pe.com.hatunsol.hatunsolmovil.modules.main.presenter;

import pe.com.hatunsol.hatunsolmovil.base.activity.BasePresenter;
import pe.com.hatunsol.hatunsolmovil.modules.main.ui.MainView;

public interface MainPresenter extends BasePresenter<MainView> {
    void onFragmentCreditos();

    void onFragmentCompromisos();

    void onFragmentRegistrarAsistencia();

    void onFragmentEncuestas();

    void onPhoneCall();

    void onDeteleUsuario();

    void onActivityAfiliacion();

}
