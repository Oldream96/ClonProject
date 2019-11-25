package pe.com.hatunsol.hatunsolmovil.modules.encuestas.RevisarEncuesta.presenter;

import android.content.res.Resources;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import pe.com.hatunsol.hatunsolmovil.base.UseCase;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseHandler;
import pe.com.hatunsol.hatunsolmovil.base.activity.BasePresenterImpl;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.RevisarEncuesta.ui.RevisarEncuestaView;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.domain.usecase.Actualizar;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.domain.usecase.GetEncuesta;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.domain.usecase.GetEstablecimientos;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.EncuestaUi;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.ProveedorLocalUi;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.presenter.EncuestaPrenserImpl;
import pe.com.hatunsol.hatunsolmovil.services.entities.BE_Constantes;
import pe.com.hatunsol.hatunsolmovil.services.entities.Encuesta;
import pe.com.hatunsol.hatunsolmovil.services.entities.Pregunta;
import pe.com.hatunsol.hatunsolmovil.services.entities.SessionUser;

public class RevisarEncuestaPresenterImpl extends BasePresenterImpl<RevisarEncuestaView> implements RevisarEncuestaPresenter {


    private GetEncuesta getListPreguntas;
    private List<ProveedorLocalUi> proveedorLocalUiList = new ArrayList<>();
    private GetEstablecimientos getEstablecimientos;
    private Actualizar actualizar;
    private List<Pregunta> preguntaList = new ArrayList<>();
    public int Operacion = BE_Constantes.Operacion.Insertar;
    public int IdEncuesta = 1;
    public int IdEncuestaUsuario = 0;
    /*private Usuario usuario;
    private GetUsuario getUsuario;*/

    public RevisarEncuestaPresenterImpl(UseCaseHandler handler, Resources res, GetEncuesta getListPreguntas, GetEstablecimientos getEstablecimientos, Actualizar actualizar) {
        super(handler, res);
        this.getListPreguntas = getListPreguntas;
        this.getEstablecimientos = getEstablecimientos;
        this.actualizar = actualizar;
        //this.getUsuario=getUsuario;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        listarPreguntas(IdEncuesta, IdEncuestaUsuario);
        setGetEstablecimientos();
    }


    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();
        if (view != null) view.OnResumeList(preguntaList);

    }

    @Override
    protected String getTag() {
        return RevisarEncuestaPresenterImpl.class.getSimpleName();
    }


    @Override
    public Bundle getExtras() {
        return super.getExtras();
    }

    @Override
    public void setExtras(Bundle extras) {
        super.setExtras(extras);

        if (extras != null) {
            this.IdEncuesta = extras.getInt("IdEncuesta", 1);
            this.IdEncuestaUsuario = extras.getInt("IdEncuestaUsuario", 0);
            this.Operacion = extras.getInt("Operacion", BE_Constantes.Operacion.Insertar);
        }


    }

    @Override
    public void listarPreguntas(int idencuesta, int idencuestausuario) {
        if (view != null) view.showProgressbar();
        handler.execute(getListPreguntas, new GetEncuesta.RequestValues(idencuesta, idencuestausuario), new UseCase.UseCaseCallback<GetEncuesta.Response>() {
            @Override
            public void onSuccess(GetEncuesta.Response response) {
                preguntaList = response.getEncuesta().getPreguntas();
                if (view != null) view.CargarEncuesta(response.getEncuesta());
                if (view != null) if (response.getEncuesta().getProveedorLocalId() != 0) {
                    for (int i = 0; i < proveedorLocalUiList.size(); i++) {
                        if (proveedorLocalUiList.get(i).getProveedorLocalId() == response.getEncuesta().getProveedorLocalId()) {
                            view.setProveedorLocal(proveedorLocalUiList.get(i).getNombre());
                        }
                    }
                }
                if (view != null) view.hideProgresbar();
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void OnClickGuardar(EncuestaUi encuestaUi) {
        boolean ok = verificar();
        if (!ok || encuestaUi.getProveedorLocalId() == 0) {
            view.Error("Complete todos los Campos");
            return;
        }

        Encuesta encuesta = new Encuesta();
        encuesta.setIdEncuesta(IdEncuesta);
        encuesta.setIdEncuestaUsuario(IdEncuestaUsuario);
        encuesta.setUserIdCrea(SessionUser.getCurrentUser().getUsuarioId());
        encuesta.setProveedorLocalId(encuestaUi.getProveedorLocalId());
        encuesta.setPreguntas(preguntaList);
        encuesta.setVerif_Sup(encuestaUi.getVerif_Sup());
        encuesta.setOperacion(Operacion);
        handler.execute(actualizar, new Actualizar.RequestValues(encuesta), new UseCase.UseCaseCallback<Actualizar.Response>() {
            @Override
            public void onSuccess(Actualizar.Response response) {
                if (view != null && response.getEncuesta()!=null) {

                    view.OnClickAprobado(response.getEncuesta());
                }
            }

            @Override
            public void onError() {
                view.Error("Error en la Transacción");
            }
        });
    }


    private boolean verificar() {
        int cont = 0;
        for (int i = 0; i < preguntaList.size(); i++) {
            for (int j = 0; j < preguntaList.get(i).getOpciones().size(); j++)
                if (preguntaList.get(i).getOpciones().get(j).isChecked())
                    cont++;
        }

        if (preguntaList.size() == cont) {
            return true;
        } else {
            return false;
        }


    }


    @Override
    public void onClickList(Pregunta pregunta) {
        int position = preguntaList.indexOf(pregunta);
        if (position != -1) {
            Pregunta preg = preguntaList.get(position);
            preg.setOpciones(pregunta.getOpciones());
            preguntaList.set(position, preg);
        }
    }


    @Override
    public ProveedorLocalUi ObtenerEstablecimiento(String texto) {
        for (int i = 0; i < proveedorLocalUiList.size(); i++) {
            if (proveedorLocalUiList.get(i).getNombre().equals(texto)) {
                return proveedorLocalUiList.get(i);
            }
        }

        return null;
    }


    public void setGetEstablecimientos() {
        this.proveedorLocalUiList = getEstablecimientos.execute().getProveedorLocalUiList();
        if (view != null) view.showEstablecimientos(proveedorLocalUiList);
    }


}
