package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.ui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorLong;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.security.PublicKey;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;
import pe.com.hatunsol.hatunsolmovil.R;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseHandler;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseThreadPoolScheduler;
import pe.com.hatunsol.hatunsolmovil.base.fragment.BaseFragment;
import pe.com.hatunsol.hatunsolmovil.base.fragment.BaseFragmentListener;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.RegistrarCompromisos.ui.CrearCompromisosActivity;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.adapter.CompromisoAdapter;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.SabadoProductivoRepository;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.local.SPLocalDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.remoto.SPRemotoDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.dialogCompromisos.ui.DialogFragmentTipoCompromiso;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.domain.GetCompromisos;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.domain.GetUsuario;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.entities.ProveedorLocalUi;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.listener.SabadoProductivoListener;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.presenter.SabadoProductivoPresenter;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.presenter.SabadoProductivoPresenterImpl;
import pe.com.hatunsol.hatunsolmovil.services.entities.BE_Constantes;
import pe.com.hatunsol.hatunsolmovil.services.entities.SessionUser;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.GRAY;
import static android.graphics.Color.LTGRAY;
import static android.graphics.Color.TRANSPARENT;
import static android.graphics.Color.rgb;

public class SabadoProductivoFragment extends BaseFragment<SabadoProductivoView, SabadoProductivoPresenter, SabadoProductivoListener> implements SabadoProductivoView, BaseFragmentListener, SabadoProductivoListener, SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.rvCompromisos)
    RecyclerView rvCompromisos;
    @BindView(R.id.progressbar)
    ProgressBar progressBar;
    @BindView(R.id.ic_menu_Compromiso)
    ImageView menuCompromiso;
    //    @BindView(R.id.fab)
//    FloatingActionButton fab;
    @BindView(R.id.fabAbrirTiposComp)
    FloatingActionButton fabAbrirTiposComp;

    @BindView(R.id.multiple_actions)
    FloatingActionsMenu multiple;

    @BindView(R.id.background_dimmer)
    View bckgroundDimmer;

    @BindView(R.id.action_Ferreteria)
    View opcionferreteria;
    @BindView(R.id.action_derivados)
    View opcionderivados;
    @BindView(R.id.action_activados)
    View opcionactivados;

    @BindView(R.id.swipe_layout_compromisos)
    SwipeRefreshLayout activityMainSwipeRefreshLayout;

    DrawerLayout drawerLayout;
    public Dialog dialog;
    CompromisoAdapter adapter;
    Usuario usuario;
    ProveedorLocalUi proveedorLocalUi;
    private List<ProveedorLocalUi> proveedorLocalUiList;
    FloatingActionButton botonprincipal;

    NavigationView navigationView;

    @Override
    protected String getLogTag() {
        return SabadoProductivoFragment.class.getSimpleName();
    }

    @Override
    protected SabadoProductivoPresenter getPresenter() {
        SabadoProductivoRepository repository = new SabadoProductivoRepository(new SPRemotoDataSource(), new SPLocalDataSource());
        presenter = new SabadoProductivoPresenterImpl(
                new UseCaseHandler(new UseCaseThreadPoolScheduler()), getResources(),
                new GetCompromisos(repository),
                new GetUsuario(repository)
        );
        new GetCompromisos(repository);
        return presenter;
    }

    public static SabadoProductivoFragment newInstance() {
        SabadoProductivoFragment fragment = new SabadoProductivoFragment();
        return fragment;
    }


    @Override
    protected SabadoProductivoFragment getBaseView() {
        return this;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activityMainSwipeRefreshLayout.setOnRefreshListener(this);
        activityMainSwipeRefreshLayout.setColorSchemeResources(R.color.green);
        navigationView = (NavigationView) getActivity().findViewById(R.id.nvView);

        setupAdapter();
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
//        if(SessionUser.getCurrentUser().getCargoId()== BE_Constantes.TipoUsuarios.JefeZonal ||
//                SessionUser.getCurrentUser().getCargoId()==BE_Constantes.TipoUsuarios.ADO){
//            fab.hide();
//        }
    }



    private void setupAdapter() {
        adapter = new CompromisoAdapter(new ArrayList<>(), this);
        rvCompromisos.setLayoutManager(new LinearLayoutManager(getContext()));
        rvCompromisos.setAdapter(adapter);
        multiple.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @Override
            public void onMenuExpanded() {
                bckgroundDimmer.setVisibility(View.VISIBLE);
            }

            @Override
            public void onMenuCollapsed() {
                bckgroundDimmer.setVisibility(View.GONE);
            }
        });
        opcionferreteria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                Date date = new Date();
                String fecha = dateFormat.format(date);
                fecha = "nuevo";
                if (validateCompromisoCreado("COMPROMISO DE FERRETERÍAS"))
                    onInitDetalleCompromisosActivity("COMPROMISO DE FERRETERÍAS", fecha, SessionUser.getCurrentUser().getPersonaId());
                else
                    Toast.makeText(getActivity(), "Ya existe un compromiso de ese tipo para esta semana", Toast.LENGTH_SHORT).show();
            }
        });
        opcionderivados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                Date date = new Date();
                String fecha = dateFormat.format(date);
                fecha = "nuevo";
                if (validateCompromisoCreado("COMPROMISO DE DERIVADOS"))
                    onInitDetalleCompromisosActivity("COMPROMISO DE DERIVADOS", fecha, SessionUser.getCurrentUser().getPersonaId());
                else
                    Toast.makeText(getActivity(), "Ya existe un compromiso de ese tipo para esta semana", Toast.LENGTH_SHORT).show();
            }
        });
        opcionactivados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                Date date = new Date();
                String fecha = dateFormat.format(date);
                fecha = "nuevo";
                if (validateCompromisoCreado("COMPROMISO DE ACTIVADOS"))
                    onInitDetalleCompromisosActivity("COMPROMISO DE ACTIVADOS", fecha, SessionUser.getCurrentUser().getPersonaId());
                else
                    Toast.makeText(getActivity(), "Ya existe un compromiso de ese tipo para esta semana", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void onInitDetalleCompromisosActivity(String nombre, String fecha, int codigoSupervisor) {
        Intent intent = new Intent(getActivity(), CrearCompromisosActivity.class);
        intent.putExtra("nombreCompromiso", nombre);
        intent.putExtra("fechaCompromiso", fecha);
        intent.putExtra("codigoSupervisor", codigoSupervisor);
        startActivity(intent);
        if (multiple.isExpanded()) multiple.collapse();
    }


    @Override
    protected View inflateView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_compromisos, container, false);
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
    public void ShowCompromisos(List<ProveedorLocalUi> proveedorLocalUiList) {
        this.proveedorLocalUiList = proveedorLocalUiList;
        adapter.setProveedorLocalUiList(proveedorLocalUiList);

    }

    @Override
    public void hideProgresbar() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void showProgressbar() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void showUsuario(Usuario usuario) {
        this.usuario = usuario;

    }

    @Override
    public void swiftCharge() {
        activityMainSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void onSwiftFinish() {
        activityMainSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onClickListenerCompromiso(String nombre, String fecha, int codigoSupervisor) {
        Intent intent = new Intent(getActivity(), CrearCompromisosActivity.class);
        intent.putExtra("nombreCompromiso", nombre);
        intent.putExtra("fechaCompromiso", fecha);
        intent.putExtra("codigoSupervisor", codigoSupervisor);
        startActivity(intent);
        Log.d("punto", "Clicked");
    }

    @OnClick({R.id.fabAbrirTiposComp})
    public void Onclick(View v) {
        switch (v.getId()) {
            case R.id.fabAbrirTiposComp:
                initDialogFragmentTipoCompromiso();
                break;
        }

    }

    @OnClick({R.id.ic_menu_Compromiso, R.id.background_dimmer})
    public void OnclickCompromiso(View v) {
        switch (v.getId()) {
            case R.id.ic_menu_Compromiso:
                this.drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.background_dimmer:
                if (multiple.isExpanded()) {
                    bckgroundDimmer.setVisibility(View.GONE);
                    multiple.collapse();
                }
                break;

        }

    }

    private void initDialogFragmentTipoCompromiso() {
        DialogFragmentTipoCompromiso fragment = DialogFragmentTipoCompromiso.newInstance(this.proveedorLocalUiList);
        fragment.setTargetFragment(SabadoProductivoFragment.this, 0);
        Bundle arg = new Bundle();
        arg.putInt("codigousuario", usuario.getEmpleadoId());
        fragment.setArguments(arg);
        fragment.show(getFragmentManager(), DialogFragmentTipoCompromiso.class.getSimpleName());
    }

    private boolean validateCompromisoCreado(String nombrecompromiso) {
        for (ProveedorLocalUi proveedorLocalUi : proveedorLocalUiList) {
            if (proveedorLocalUi.getNombreProveedor().equals(nombrecompromiso)) {
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date fecha = null;
                String fe = proveedorLocalUi.getFecha();
                try {
                    fecha = dateFormat.parse(fe);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Calendar cal = Calendar.getInstance();
                cal.setTime(fecha);
                int semana = cal.get(Calendar.WEEK_OF_MONTH);
                Date hoy = new Date();
                cal.setTime(hoy);
                int semanahoy = cal.get(Calendar.WEEK_OF_MONTH);
                if (semana == semanahoy) {
                    return false;
                }

            }
        }
        return true;
    }

    @Override
    public void onRefresh() {
        presenter.setGetCompromisos();
    }

    @Override
    public void setFocusMenu() {
        navigationView.getMenu().getItem(4).setChecked(true);
    }
}
