package pe.com.hatunsol.hatunsolmovil.modules.main.ui;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.se.omapi.Session;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.navigation.NavigationView;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pe.com.hatunsol.hatunsolmovil.R;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseHandler;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseThreadPoolScheduler;
import pe.com.hatunsol.hatunsolmovil.base.activity.BaseActivity;
import pe.com.hatunsol.hatunsolmovil.base.fragment.BaseFragmentListener;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.ui.SabadoProductivoFragment;

import pe.com.hatunsol.hatunsolmovil.modules.encuestas.RevisarEncuesta.ui.RevisarEncuestaActivity;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.ui.EncuestaFragment;
import pe.com.hatunsol.hatunsolmovil.modules.login.presenter.LoginPresenter;
import pe.com.hatunsol.hatunsolmovil.modules.login.ui.LoginActivity;
import pe.com.hatunsol.hatunsolmovil.modules.login.ui.LoginView;
import pe.com.hatunsol.hatunsolmovil.modules.main.data.source.MainRepository;
import pe.com.hatunsol.hatunsolmovil.modules.main.data.source.local.MainLocalDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.main.data.source.remoto.MainRemotoDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.main.domain.DeleteUser;
import pe.com.hatunsol.hatunsolmovil.modules.main.domain.GetUser;
import pe.com.hatunsol.hatunsolmovil.modules.main.domain.SincronizeEstablecimientos;
import pe.com.hatunsol.hatunsolmovil.modules.main.presenter.MainPresenter;
import pe.com.hatunsol.hatunsolmovil.modules.main.presenter.MainPresenterImpl;
import pe.com.hatunsol.hatunsolmovil.services.entities.BE_Constantes;
import pe.com.hatunsol.hatunsolmovil.services.entities.Persona;
import pe.com.hatunsol.hatunsolmovil.services.entities.ProveedorLocal;
import pe.com.hatunsol.hatunsolmovil.services.entities.SessionUser;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public class MainActivity extends BaseActivity<MainView, MainPresenter> implements MainView, BaseFragmentListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.nvView)
    NavigationView navigationView;

    private MainActivity myContext;

    TextView tvCargoNombre, tvNombre;
    ImageView imageUsuario;

    int REQUEST_PHONE_CALL = 1;
    private AppBarConfiguration mAppBarConfiguration;
    int permission_GPS, permission_STORAGE, permission_CAMERA, permission_CALL;

    public static final int ASISTENCIA = 4;
    int ACCESS_FINE_LOCATION = 1;
    int CAMERA = 2;
    int WRITE_EXTERNAL = 3;
    int CALL = 4;
    private long backPressedTime = 0;

    private int Opcion = 0;
    //private TextView tvNombre, tvCargoNombre, tvEstablecimiento;
    private Persona persona;
    List<Persona> personaList = new ArrayList<>();

    @Override
    protected String getTag() {
        return MainActivity.class.getSimpleName();
    }

    @Override
    protected AppCompatActivity getActivity() {
        return this;
    }

    @Override
    protected MainPresenter getPresenter() {
        MainRepository repository = new MainRepository(new MainRemotoDataSource(), new MainLocalDataSource());
        presenter = new MainPresenterImpl(new UseCaseHandler(new UseCaseThreadPoolScheduler()), getResources(),
                new SincronizeEstablecimientos(repository),
                new GetUser(repository),
                new DeleteUser(repository));
        return presenter;
    }

    @Override
    protected MainView getBaseView() {
        return this;
    }

    @Override
    protected Bundle getExtrasInf() {
        return getIntent().getExtras();
    }

    @Override
    protected void setContentView() {
        FlowManager.init(this);
        setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.activity_main_clone);

        VerificarPermisos();
        ButterKnife.bind(this);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                selectDrawerItem(menuItem);
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }


    public void selectDrawerItem(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nv_creditos:
                presenter.onFragmentCreditos();
                break;
            case R.id.nv_registrar_asistencia:
                presenter.onFragmentRegistrarAsistencia();
                break;
            case R.id.nav_encuestas:
                presenter.onFragmentEncuestas();
                break;
            case R.id.nav_compromisos_fragment:
                presenter.onFragmentCompromisos();
                break;
            case R.id.nav_afiliacion:
                presenter.onActivityAfiliacion();
                break;
            case R.id.item_soporte:
                presenter.onPhoneCall();
                break;
            case R.id.item_salir:
                presenter.onDeteleUsuario();
                break;
            default:
                break;
        }

    }


    @Override
    protected ViewGroup getRootLayout() {
        return null;
    }

    @Override
    protected ProgressBar getProgressBar() {
        return null;
    }

    @Override
    public void starLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtras(new Bundle());
        startActivity(intent);
    }

    @Override
    public void close() {
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onFragmentInitCreditos() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

//        CreditosFragment fragment = new CreditosFragment();
//        fragmentTransaction.replace(R.id.frameLayout, fragment);
//        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInitRegistrarAsistencia() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

//        AsistenciaFragment fragment = new AsistenciaFragment();
//        fragmentTransaction.replace(R.id.frameLayout, fragment);
//        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInitEncuestas() {
        Fragment fragmentregistroasistencia = EncuestaFragment.newInstance();
        fragmentregistroasistencia.setArguments(getIntent().getExtras());
        getSupportFragmentManager()
                .beginTransaction()
                //R.id.frameLayout //Fragment Padre
                .replace(R.id.frameLayout, fragmentregistroasistencia, "tag-encuestas")
                .commitNow();
    }

    @Override
    public void showUser(Usuario usuario) {
        Usuario usuario1 = usuario;
    }

    @Override
    public void showInitCreditosFragment() {
        Fragment fragment = SabadoProductivoFragment.newInstance();
        fragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, fragment, "tag-compromisos")
                .commitNow();
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void showUserInformation(Usuario usuario) {
        try {
            View headerLayout = navigationView.getHeaderView(0); // 0-index header
            tvNombre = headerLayout.findViewById(R.id.tvNombreCurrentUsuario);
            tvNombre.setText(usuario.getEmpleadoNombre());
            tvCargoNombre = headerLayout.findViewById(R.id.tvCargoCurrentUsuario);
            tvCargoNombre.setText(usuario.getCargoNombre());
            imageUsuario = headerLayout.findViewById(R.id.imageview);
//            if (!SessionUser.getCurrentUser().getFoto().equals("")) {
//
//                Picasso.with(getActivity())
//                        .load(SessionUser.getCurrentUser().getFoto())
//                        .transform(new CircleTransform())
//                        .placeholder(R.drawable.hatun_logo_light)
//                        .into(imageUsuario);
//
//            } else
            Picasso.with(getActivity())
                    .load(R.drawable.hatun_logo_light)
                    .transform(new CircleTransform())
                    .placeholder(R.drawable.hatun_logo_light)
                    .into(imageUsuario);
            ValidarAccesos();

        } catch (Exception e) {

        }

    }

    @Override
    public void onFragmentInitCrompromisos() {
        Fragment fragment = SabadoProductivoFragment.newInstance();
        fragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, fragment, "tag-compromisos")
                .commitNow();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private <T extends Fragment> T getFragment(Class<T> tClass) {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        for (Fragment fragment :
                fragments) {
            if (tClass.isInstance(fragment)) {
                return (T) fragment;
            }
        }
        return null;
    }


    private void onInitActivityCrearCredito() {
//        Intent intent = new Intent(getActivity(), CrearCreditosActivity.class);
//        intent.putExtra("EditarActivity", 0);
//        startActivity(intent);
    }

    private void onInitActivityRevisarEncuesta() {
        Intent intent = new Intent(getActivity(), RevisarEncuestaActivity.class);
        //intent.putExtras();
        startActivity(intent);
    }


    public void VerificarPermisos() {
        permission_GPS = ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION);
        permission_CAMERA = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA);
        permission_STORAGE = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission_GPS != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, ACCESS_FINE_LOCATION);
        } else if (permission_CAMERA != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, CAMERA);
        } else if (permission_STORAGE != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL);
        }
    }

    private boolean Negado;

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        permission_GPS = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);
        permission_STORAGE = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        permission_CAMERA = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA);
        permission_CALL = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE);
        Negado = false;

        if (requestCode == ACCESS_FINE_LOCATION && permission_GPS != PackageManager.PERMISSION_GRANTED) {
            Negado = true;
        } else if (requestCode == WRITE_EXTERNAL && permission_STORAGE != PackageManager.PERMISSION_GRANTED) {
            Negado = true;
        } else if (requestCode == CAMERA && permission_CAMERA != PackageManager.PERMISSION_GRANTED) {
            Negado = true;
        } else if (requestCode == CALL && permission_CALL != PackageManager.PERMISSION_GRANTED) {
            Negado = true;
        }
        if (permission_GPS == PackageManager.PERMISSION_GRANTED
                && permission_CAMERA == PackageManager.PERMISSION_GRANTED
                && permission_STORAGE == PackageManager.PERMISSION_GRANTED
                && permission_CALL == PackageManager.PERMISSION_GRANTED) {
            Intent intent;


        } else if (Negado == false) {
            VerificarPermisos();
        }

    }

    @Override
    public void onPhoneCall() {
        String number = "988702085";
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PHONE_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        } else {
            Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        List<Fragment> list = getSupportFragmentManager().getFragments();
//        for (Fragment fragment : list) {
//            if (fragment instanceof CreditosFragment) {
//                if (!onComprobateFragment())
//                else onBackPresedCreditos();
//            } else {
//                onFragmentInitCreditos();
//            }
//        }

    }

    public void onBackPresedCreditos() {
//        CreditosFragment creditosFragment = getFragment(CreditosFragment.class);
//        creditosFragment.onBackPresed();
    }


    @Override
    public void onActivityInitAfiliacion() {
//        Intent intent = new Intent(getActivity(), AfiliacionActivity.class);
//        startActivity(intent);
    }

    public void ValidarAccesos() {
        Menu nav_Menu = navigationView.getMenu();
        MenuItem item_creditos = nav_Menu.findItem(R.id.nv_creditos);//modulo creditos
        MenuItem item_asistencia = nav_Menu.findItem(R.id.nv_registrar_asistencia);//modulo asistencia
        MenuItem item_establecimientos = nav_Menu.findItem(R.id.nav_afiliacion);//modulo afilicación
        MenuItem item_sabados = nav_Menu.findItem(R.id.nav_compromisos_fragment);//modulo sabados productivos
        MenuItem item_encuestas = nav_Menu.findItem(R.id.nav_encuestas);//modulo encuestas

        if (SessionUser.getCurrentUser().getCargoId() == BE_Constantes.TipoUsuarios.JefeZonal) {
            //mostrara botones
            item_creditos.setVisible(true);
            item_asistencia.setVisible(true);
            item_establecimientos.setVisible(true);
            item_sabados.setVisible(true);
            item_encuestas.setVisible(false);
        } else if (SessionUser.getCurrentUser().getCargoId() == BE_Constantes.TipoUsuarios.JefedeMarca) {
            //mostrara botones
            item_asistencia.setVisible(true);
            item_establecimientos.setVisible(true);
            item_encuestas.setVisible(true);
            item_creditos.setVisible(false);
            item_sabados.setVisible(false);
        } else if (SessionUser.getCurrentUser().getCargoId() == BE_Constantes.TipoUsuarios.Supervisor) {
            item_creditos.setVisible(true);
            item_asistencia.setVisible(true);
            item_sabados.setVisible(true);
            item_encuestas.setVisible(true);
            item_establecimientos.setVisible(true);
        } else if (SessionUser.getCurrentUser().getCargoId() == BE_Constantes.TipoUsuarios.ADO) {
            //mostrara botones
            item_creditos.setVisible(true);
            item_asistencia.setVisible(true);
            item_establecimientos.setVisible(false);
            item_sabados.setVisible(false);
            item_encuestas.setVisible(false);
        } else {
        }
    }
}