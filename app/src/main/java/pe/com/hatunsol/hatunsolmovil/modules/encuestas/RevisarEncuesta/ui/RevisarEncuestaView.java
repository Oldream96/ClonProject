package pe.com.hatunsol.hatunsolmovil.modules.encuestas.RevisarEncuesta.ui;

import android.view.View;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.base.activity.BaseView;

import pe.com.hatunsol.hatunsolmovil.modules.encuestas.RevisarEncuesta.presenter.RevisarEncuestaPresenter;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.EncuestaUi;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.ProveedorLocalUi;
import pe.com.hatunsol.hatunsolmovil.services.entities.Encuesta;
import pe.com.hatunsol.hatunsolmovil.services.entities.Pregunta;

public interface RevisarEncuestaView extends BaseView<RevisarEncuestaPresenter> {

    void CargarEncuesta(Encuesta encuesta);
    void showEstablecimientos(List<ProveedorLocalUi> proveedorLocalUiList);
    void OnClickAprobado(Encuesta encuesta);
    void OnClickRevisado(View v);
    void Error(String Mensaje);
    void setProveedorLocal(String nombre);

    void hideProgresbar();
    void showProgressbar();


    void OnResumeList(List<Pregunta> preguntaList);
}
