package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.RegistrarCompromisos.presenter;

import android.content.res.Resources;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import pe.com.hatunsol.hatunsolmovil.base.UseCase;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseHandler;
import pe.com.hatunsol.hatunsolmovil.base.activity.BasePresenterImpl;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.RegistrarCompromisos.ui.CrearCompromisoView;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.domain.GetFerreteriasCompromiso;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.domain.SaveDetalleCompromiso;
import pe.com.hatunsol.hatunsolmovil.services.entities.Persona;

public class CrearCompromisoImpl extends BasePresenterImpl<CrearCompromisoView> implements CrearCompromisoPresenter {

    private GetFerreteriasCompromiso getFerreteriasCompromiso;
    private String nombreCompromiso;
    private String fechaCompromiso;
    private int codigoUsuario;
    private SaveDetalleCompromiso saveDetalleCompromiso;

    public CrearCompromisoImpl(UseCaseHandler handler, Resources res, GetFerreteriasCompromiso getFerreteriasCompromiso, SaveDetalleCompromiso saveDetalleCompromiso) {
        super(handler, res);
        this.getFerreteriasCompromiso = getFerreteriasCompromiso;
        this.saveDetalleCompromiso = saveDetalleCompromiso;
    }

    @Override
    protected String getTag() {
        return CrearCompromisoImpl.class.getSimpleName();
    }


    @Override
    public void onCreate() {
        super.onCreate();
        SetFechaCompromiso();
        setGetListFerreteriasCompromiso();
    }

    private void SetFechaCompromiso() {
        if (view != null) view.TraerFechaConsulta(fechaCompromiso);

    }

    @Override
    public void setExtras(Bundle extras) {
        super.setExtras(extras);
        this.nombreCompromiso = extras.getString("nombreCompromiso");
        this.fechaCompromiso = extras.getString("fechaCompromiso");
        this.codigoUsuario = extras.getInt("codigoSupervisor");
    }

    public void setGetListFerreteriasCompromiso() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Date date = new Date();
        String fecha = dateFormat.format(date);
        if (view != null) view.showProgressbar();
        handler.execute(getFerreteriasCompromiso, new GetFerreteriasCompromiso.Request(codigoUsuario, fechaCompromiso.equals("nuevo")? fecha :fechaCompromiso, nombreCompromiso), new UseCase.UseCaseCallback<GetFerreteriasCompromiso.Response>() {
            @Override
            public void onSuccess(GetFerreteriasCompromiso.Response response) {
                if (view != null) view.showFerreterias(response.getProveedorLocalUiList());
                if (view != null) view.hideProgressbar();
            }

            @Override
            public void onError() {
                if (view != null) view.hideProgressbar();
                view.OnErrorRegresar("Error al obtener Datos");
            }
        });
    }


    @Override
    public void onClickButtonGuardar() {

    }

    @Override
    public String traerFechaConsulta() {
        return fechaCompromiso;
    }

    @Override
    public void onSaveDetalleCompromiso(List<Persona> personaList, Integer tipoCompromiso) {
        if (view != null) view.showProgressbar();
        handler.execute(saveDetalleCompromiso, new SaveDetalleCompromiso.RequestValues(personaList, tipoCompromiso), new UseCase.UseCaseCallback<SaveDetalleCompromiso.ResponseValues>() {
            @Override
            public void onSuccess(SaveDetalleCompromiso.ResponseValues response) {
                if (view != null) {
                    view.hideProgressbar();
                    if ( response.getRespuesta() != 0) {
                        view.Regresar("Pedido Registrado Correctamente!");
                    }else{
                        view.Regresar("Pedido Registrado Correctamente!");
                    }
                }
            }

            @Override
            public void onError() {
                if (view != null) view.hideProgressbar();
                if (view != null) view.OnErrorRegresar("No se pudo registrar Pedido");

            }
        });

    }
}
