package pe.com.hatunsol.hatunsolmovil.modules.login.ui;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.navigation.NavigationView;
import com.raizlabs.android.dbflow.config.FlowManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pe.com.hatunsol.hatunsolmovil.R;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseHandler;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseThreadPoolScheduler;
import pe.com.hatunsol.hatunsolmovil.base.activity.BaseActivity;
import pe.com.hatunsol.hatunsolmovil.modules.login.data.source.LoginRepository;
import pe.com.hatunsol.hatunsolmovil.modules.login.data.source.local.LoginLocalDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.login.data.source.remoto.LoginRemotoDataSource;
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
import pe.com.hatunsol.hatunsolmovil.modules.login.presenter.LoginPresenter;
import pe.com.hatunsol.hatunsolmovil.modules.login.presenter.LoginPresenterImpl;
import pe.com.hatunsol.hatunsolmovil.modules.main.ui.MainActivity;
import pe.com.hatunsol.hatunsolmovil.services.entities.BE_Constantes;
import pe.com.hatunsol.hatunsolmovil.services.entities.ProveedorLocal;
import pe.com.hatunsol.hatunsolmovil.services.entities.SessionUser;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public class LoginActivity extends BaseActivity<LoginView, LoginPresenter> implements LoginView {

    @BindView(R.id.button_login)
    CardView btn_login;
    @BindView(R.id.txt_password)
    EditText edt_password;
    @BindView(R.id.txt_user)
    EditText edt_user;
    @BindView(R.id.progressBar_l)
    ProgressBar progressBar;
    NavigationView navigationView;



    @Override
    protected String getTag() {
        return LoginActivity.class.getSimpleName();
    }

    @Override
    protected AppCompatActivity getActivity() {
        return this;
    }

    @Override
    protected LoginPresenter getPresenter() {
        LoginRepository repository = new LoginRepository(new LoginRemotoDataSource(), new LoginLocalDataSource());
        presenter = new LoginPresenterImpl(new UseCaseHandler(new UseCaseThreadPoolScheduler()), getResources(),
                new GetUser(repository),
                new SaveSessionUser(repository),
                new GetUbigeos(repository),
                new GetParametro(repository),
                new SaveParametros(repository),
                new SaveUbigeos(repository),
                new GetPlanTrabajoDetalle(repository),
                new SaveProvedorLocal(repository),
                new SavePersonas(repository),
                new GetPersonas(repository));
        return presenter;
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    @Override
    protected LoginView getBaseView() {
        return this;
    }

    @Override
    protected Bundle getExtrasInf() {
        return null;
    }

    @Override
    protected void setContentView() {
        FlowManager.init(this);
        setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }

    @Override
    protected ViewGroup getRootLayout() {
        return null;
    }

    @Override
    protected ProgressBar getProgressBar() {
        return null;
    }

    @OnClick({R.id.button_login})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.button_login:
                setDataLogin();

                break;
        }
    }


    private void setDataLogin() {

        presenter.onClickButtonLogin(edt_user.getText().toString(), edt_password.getText().toString());

    }

    @Override
    public void onShowUserFail() {
        Toast.makeText(this, "Usuario Incorrecto", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onShowPasswordFail() {
        Toast.makeText(this, "Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void initActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void showPlatrabajo(List<ProveedorLocal> proveedorLocalList) {

    }

    @Override
    public void connectyServer() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Oh parece que no tiene conexion con el servidor, porfavor comuniquese con Ayuda al Cliente");
        builder1.setCancelable(true);
        builder1.setPositiveButton(
                "Aceptar",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    @Override
    public void ValidarDatos() {

        AceptarDialog("POR FAVOR COMPLETAR SUS DATOS PERSONALES.").show();
    }

    private AlertDialog AceptarDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View vista = inflater.inflate(R.layout.aceptar_dialogfragment, null);
        builder.setView(vista);
        final AlertDialog sh = builder.create();
        TextView tvMessage = ((TextView) vista.findViewById(R.id.tvMensaje));
        Button tvAceptar = ((Button) vista.findViewById(R.id.tvConfirmacionOK));
        tvMessage.setText(message);

        tvAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.hatunsol.com.pe/Hatunsol_Testing/RRHH/frmPersonal.aspx";
                try {
                    Intent i = new Intent("android.intent.action.MAIN");
                    i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                    i.addCategory("android.intent.category.LAUNCHER");
                    i.setData(Uri.parse(url));
                    startActivity(i);
                } catch (ActivityNotFoundException e) {
                    // Chrome is not installed System.exit(0);
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(i);
                    System.exit(1);

                }
                sh.dismiss();
            }
        });
        return sh;
    }

}
