package pe.com.hatunsol.hatunsolmovil.modules.encuestas.ui;

import android.view.View;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.base.activity.BaseView;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.EncuestaUi;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.presenter.EncuestaPresenter;

public interface EncuestaView extends BaseView<EncuestaPresenter> {
    void showText(String respuesta);

    void showEncuestaList(List<EncuestaUi> encuestaUiList);
    void hideProgresbar();

    void showProgressbar();

    void setFocusMenu();


}
