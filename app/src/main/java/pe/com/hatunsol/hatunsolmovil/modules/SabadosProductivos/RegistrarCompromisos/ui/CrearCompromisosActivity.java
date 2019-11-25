package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.RegistrarCompromisos.ui;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pe.com.hatunsol.hatunsolmovil.R;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseHandler;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseThreadPoolScheduler;
import pe.com.hatunsol.hatunsolmovil.base.activity.BaseActivity;
import pe.com.hatunsol.hatunsolmovil.base.fragment.BaseFragmentListener;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.RegistrarCompromisos.FerreteriaFragment.FerreteriaCompromisoListener;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.RegistrarCompromisos.adapter.FerreteriaCompromisoAdapter;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.RegistrarCompromisos.presenter.CrearCompromisoImpl;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.RegistrarCompromisos.presenter.CrearCompromisoPresenter;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.SabadoProductivoRepository;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.local.SPLocalDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.remoto.SPRemotoDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.domain.GetFerreteriasCompromiso;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.domain.SaveDetalleCompromiso;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.entities.ProveedorLocalUi;
import pe.com.hatunsol.hatunsolmovil.services.entities.Persona;
import pe.com.hatunsol.hatunsolmovil.services.entities.SessionUser;

public class CrearCompromisosActivity extends BaseActivity<CrearCompromisoView, CrearCompromisoPresenter> implements CrearCompromisoView, BaseFragmentListener, FerreteriaCompromisoListener {


    @BindView(R.id.rvCompromisos)
    RecyclerView rvFerreterias;
    @BindView(R.id.pbDetalleCompromiso)
    ProgressBar progressBar;

    @BindView(R.id.btguardar_ferrcompromiso)
    Button botonguardar;

    @BindView(R.id.toolbarCompromisos)
    Toolbar toolbar;

    private FerreteriaCompromisoAdapter adapter;
    private FerreteriaCompromisoListener listener;
    private Date fecha;
    private String fechaconsulta;
    private List<ProveedorLocalUi> proveedorLocalUiList;
    private List<Persona> personaList = new ArrayList<>();
    private Integer tipoCompromiso;

    @Override
    protected String getTag() {
        return CrearCompromisosActivity.class.getSimpleName();
    }

    @Override
    protected AppCompatActivity getActivity() {
        return this;
    }

    @Override
    protected CrearCompromisoPresenter getPresenter() {
        SabadoProductivoRepository repository = new SabadoProductivoRepository(new SPRemotoDataSource(), new SPLocalDataSource());
        presenter = new CrearCompromisoImpl(new UseCaseHandler(new UseCaseThreadPoolScheduler()), getResources()
                , new GetFerreteriasCompromiso(repository)
                , new SaveDetalleCompromiso(repository));
        return presenter;
    }

    @Override
    protected CrearCompromisoView getBaseView() {
        return this;
    }

    @Override
    protected Bundle getExtrasInf() {
        return getIntent().getExtras();
    }

    @Override
    protected void setContentView() {
        setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.activity_regferreteria_compromiso);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setupAdapter();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setupAdapter() {
        //adapter = new FerreteriaCompromisoAdapter(getActivity(), 0, proveedorLocalUiList);
        adapter = new FerreteriaCompromisoAdapter(new ArrayList<>(), this);
        rvFerreterias.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvFerreterias.setAdapter(adapter);

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
    public void showFerreterias(List<ProveedorLocalUi> proveedorLocalUiList) {
//        adapter = new FerreteriaCompromisoAdapter(getActivity(), 0, proveedorLocalUiList);
        rvFerreterias.setAdapter(adapter);
        adapter.setProveedorLocalUiList(proveedorLocalUiList);
//        validafechaHoy();
    }

    private void validafechaHoy(String fechaconsulta) {
        String date = fechaconsulta;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        fecha = null;
        Date hoy = new Date();
        String output = dateFormat.format(hoy);
        try {
            hoy = dateFormat.parse(output);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (!date.equals("nuevo")) {
            try {
                fecha = dateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (fecha.toString().equals(hoy.toString())) {
                fecha = hoy;
                botonguardar.setText("Actualizar");
            } else {
                botonguardar.setText("Actualizar");
                boolean antes = fecha.before(hoy);
                if (antes) {
                    botonguardar.setVisibility(View.GONE);
                }
            }
        } else {
            fecha = hoy;
            botonguardar.setText("Guardar");
        }
    }

    @Override
    public void showProgressbar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        progressBar.setVisibility(View.INVISIBLE);

    }

    @Override
    public void TraerFechaConsulta(String fechaConsulta) {
        this.fechaconsulta = fechaConsulta;
        validafechaHoy(fechaConsulta);

    }

    @Override
    public void Regresar(String mensaje) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater layoutInflater = this.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_aceptar, null);
        builder.setView(view);
        Button btConfirmacion = view.findViewById(R.id.btConfirmacion);
        TextView Mensaje = view.findViewById(R.id.tvMensaje);
        Mensaje.setText(mensaje);
        btConfirmacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                finish();
            }
        });
        //if(!botonguardar.isEnabled()) botonguardar.setEnabled(true);
        builder.create();
        builder.show();
    }

    @Override
    public void OnErrorRegresar(String mensaje) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater layoutInflater = this.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_error, null);
        builder.setView(view);
        Button btConfirmacion = view.findViewById(R.id.btConfirmacion);
        TextView Mensaje = view.findViewById(R.id.tvMensaje);
        Mensaje.setText(mensaje);
        btConfirmacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                finish();
            }
        });
        //if(!botonguardar.isEnabled()) botonguardar.setEnabled(true);
        builder.create();
        builder.show();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            //Log.i("MainActivity", "popping backstack");
            hideKeyboard(null,this);
            fm.popBackStack();
        } else {
            //Log.i("MainActivity", "nothing on backstack, calling super");
            fm.popBackStack();
            hideKeyboard(null,this);
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.btguardar_ferrcompromiso})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.btguardar_ferrcompromiso:
                if (!(adapter.proveedorLocalUiList == null || adapter.proveedorLocalUiList.size() == 0))
                    setCompromisoFerreteria();
                break;
        }
    }

    private void setCompromisoFerreteria() {
        proveedorLocalUiList = adapter.proveedorLocalUiList;
        if (proveedorLocalUiList == null || proveedorLocalUiList.size() == 0) return;
        botonguardar.setEnabled(false);
        try {
            if (ValidarDatosBasicos()) {
                for (int i = 0; i < proveedorLocalUiList.size(); i++) {
                    if (proveedorLocalUiList.get(i).getStatus() == 2) {
                        Persona persona = new Persona();
                        persona.setAccion(proveedorLocalUiList.get(i).getAccion());
                        persona.setRazon(proveedorLocalUiList.get(i).getRazon());
                        persona.setTipoPersonaId(proveedorLocalUiList.get(i).getTipo());
                        persona.setIdSupervisor(SessionUser.getCurrentUser().getPersonaId());
                        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                        persona.setFechaCreacion(df.format(fecha));
                        persona.setProveedorLocalId(proveedorLocalUiList.get(i).getProveedorLocalId());
                        persona.setCodigoUsuarioCreacion(SessionUser.getCurrentUser().getUsuarioId());
                        personaList.add(persona);
                    }
                }
                if (personaList.size() != 0) {
                    presenter.onSaveDetalleCompromiso(personaList, this.tipoCompromiso);
                } else {
                    Toast.makeText(getActivity(), "Ningún campo llenado para guardar", Toast.LENGTH_SHORT).show();
                    if (!botonguardar.isEnabled()) botonguardar.setEnabled(true);
                }
            } else {
                Toast.makeText(getActivity(), "Complete todos los campos", Toast.LENGTH_SHORT).show();
                if (!botonguardar.isEnabled()) botonguardar.setEnabled(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean ValidarDatosBasicos() {
        boolean correcto = true;
        for (int i = 0; i < proveedorLocalUiList.size(); i++) {
            //Persona
            this.tipoCompromiso = proveedorLocalUiList.get(i).getTipo();
            if (proveedorLocalUiList.get(i).getTipo() != 1) {
                if ((proveedorLocalUiList.get(i).getAccion() == null ||
                        proveedorLocalUiList.get(i).getAccion().equals(""))
                        && proveedorLocalUiList.get(i).getStatus() == 2) {
                    correcto = false;
                }
            } else {
                //Ferretería tiene que tener ambos obligatorio
                if ((proveedorLocalUiList.get(i).getAccion() == null ||
                        proveedorLocalUiList.get(i).getAccion().equals("") ||
                        proveedorLocalUiList.get(i).getAccion() == null ||
                        proveedorLocalUiList.get(i).getRazon().equals("")
                )) {
                    correcto = false;
                }
            }
        }

        return correcto;

    }

    @Override
    public void OnclickCheckDetalleCOmpromiso(ProveedorLocalUi proveedorLocalUi) {
        adapter.updateItem(proveedorLocalUi);
    }

    @Override
    public void onChangeTextAccion(ProveedorLocalUi proveedorLocalUi) {
        adapter.updateAccionItem(proveedorLocalUi);
    }

    @Override
    public void onChangeTextMotivo(ProveedorLocalUi proveedorLocalUi) {
        adapter.updateMotivoItem(proveedorLocalUi);
    }

    public static void showKeyboard(Activity pActivity, View pView) {
        if (pView == null) {
            pView = pActivity.getWindow().getCurrentFocus();
        } else {
            /**
             * For {@link EditText}, a call to {@link View#requestFocus()} will
             * open the keyboard as per inputType set for {@link EditText}
             */
            pView.requestFocus();
        }
        if (pView != null) {
            InputMethodManager imm = (InputMethodManager) pActivity
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.showSoftInput(pView, InputMethodManager.SHOW_FORCED);
            }
        }
    }


    public static void hideKeyboard(View pView, Activity pActivity) {
        if (pView == null) {
            pView = pActivity.getWindow().getCurrentFocus();
        }
        if (pView != null) {
            InputMethodManager imm = (InputMethodManager) pActivity
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(pView.getWindowToken(), 0);
            }
        }
    }
}
