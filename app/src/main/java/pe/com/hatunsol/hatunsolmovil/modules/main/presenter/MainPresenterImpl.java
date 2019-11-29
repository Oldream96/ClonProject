package pe.com.hatunsol.hatunsolmovil.modules.main.presenter;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.core.app.NotificationCompatSideChannelService;

import com.raizlabs.android.dbflow.list.IFlowCursorIterator;

import pe.com.hatunsol.hatunsolmovil.base.UseCase;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseHandler;
import pe.com.hatunsol.hatunsolmovil.base.activity.BasePresenterImpl;

import pe.com.hatunsol.hatunsolmovil.modules.main.domain.DeleteUser;
import pe.com.hatunsol.hatunsolmovil.modules.main.domain.GetUser;
import pe.com.hatunsol.hatunsolmovil.modules.main.domain.SincronizeEstablecimientos;
import pe.com.hatunsol.hatunsolmovil.modules.main.ui.MainView;
import pe.com.hatunsol.hatunsolmovil.services.entities.BE_Constantes;
import pe.com.hatunsol.hatunsolmovil.services.entities.SessionUser;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public class MainPresenterImpl extends BasePresenterImpl<MainView> implements MainPresenter {

    private SincronizeEstablecimientos sincronizeEstablecimientos;
    private GetUser getUser;
    private Usuario usuario;
    private Usuario usuario2;
    private DeleteUser deleteUser;
    private String nombre;
    private String correo;
    private String tipousuario;

    @Override
    public void setExtras(Bundle extras) {
        super.setExtras(extras);
        this.nombre = extras.getString("nombre");
        this.correo = extras.getString("correo");
        this.tipousuario = extras.getString("tipousuario");
        usuario2 = new Usuario();
        usuario2.setCargoNombre("Cliente");
        usuario2.setEmpleadoNombre("administrador");
        usuario2.setLogin("administrador");
    }

    @Override
    public Bundle getExtras() {
        return super.getExtras();

    }

    //Casos de uso a usar en la actividad o fragment
    public MainPresenterImpl(UseCaseHandler handler, Resources res, SincronizeEstablecimientos sincronizeEstablecimientos, GetUser getUser, DeleteUser deleteUser) {
        super(handler, res);
        this.sincronizeEstablecimientos = sincronizeEstablecimientos;
        this.getUser = getUser;
        this.deleteUser = deleteUser;
    }


    @Override
    protected String getTag() {
        return MainPresenterImpl.class.getSimpleName();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SessionUser sessionUser = SessionUser.getCurrentUser();
        if (sessionUser == null) {
            if (view != null) view.starLoginActivity();
            if (view != null) view.close();
            return;
        }
        view.showUserInformation(usuario2);
        //setUser();
        //sincronizeEstablecimientos();

//        if (view != null) {
//            if (sessionUser.getCargoId() != BE_Constantes.TipoUsuarios.JefedeMarca)
//                view.showInitCreditosFragment();
//            else {
//                view.onFragmentInitEncuestas();
//                view.onActivityInitAfiliacion();
//            }
//        }
    }

    @Override
    public void onFragmentCreditos() {
        if (view != null) view.onFragmentInitCreditos();
    }

    @Override
    public void onFragmentRegistrarAsistencia() {
        if (view != null) view.onFragmentInitRegistrarAsistencia();
    }

    @Override
    public void onFragmentEncuestas() {
        if (view != null) view.onFragmentInitEncuestas();
    }

    @Override
    public void onPhoneCall() {
        if (view != null) view.onPhoneCall();
    }

    @Override
    public void onDeteleUsuario() {


        DeleteUser.Response response = deleteUser.execute();
        if (response.deleteUsuario())
            //muestra el login//revisar starLoginActivity() en la actividad o fragmento
            if (view != null) view.starLoginActivity();

    }

    @Override
    public void onActivityAfiliacion() {
        if (view != null) view.onActivityInitAfiliacion();
        if (SessionUser.getCurrentUser().getCargoId() == BE_Constantes.TipoUsuarios.JefeZonal) {

        }
    }

    public void OcultarBotonFab() {

    }

    @Override
    public void onFragmentCompromisos() {
        if (view != null) view.onFragmentInitCrompromisos();
    }

    public void sincronizeEstablecimientos() {
        //Trae todo sin OFFSET
        handler.execute(sincronizeEstablecimientos, new SincronizeEstablecimientos.RequestValues(usuario.getCargoId(), usuario.getEmpleadoId(), usuario.getLocalId(), 3, 0), new UseCase.UseCaseCallback<SincronizeEstablecimientos.ResponseValues>() {
            @Override
            public void onSuccess(SincronizeEstablecimientos.ResponseValues response) {

            }

            @Override
            public void onError() {

            }
        });
    }

    public void setUser() {
        GetUser.Response response = getUser.execute();
        usuario = response.getUsuario();
        if (view != null) view.showUserInformation(usuario);
    }


}
