package pe.com.hatunsol.hatunsolmovil.modules.encuestas.RevisarEncuesta.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pe.com.hatunsol.hatunsolmovil.R;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseHandler;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseThreadPoolScheduler;
import pe.com.hatunsol.hatunsolmovil.base.activity.BaseActivity;
import pe.com.hatunsol.hatunsolmovil.base.fragment.BaseFragmentListener;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.RevisarEncuesta.adapter.ListaFerreteriasAdapter;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.RevisarEncuesta.adapter.RevisarEncuestaAdapter;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.RevisarEncuesta.listener.PreguntaListener;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.RevisarEncuesta.presenter.RevisarEncuestaPresenter;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.RevisarEncuesta.presenter.RevisarEncuestaPresenterImpl;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.data.source.EncuestasRepository;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.data.source.local.EncuestasLocalDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.data.source.remoto.EncuestaRemoteDataSource;

import pe.com.hatunsol.hatunsolmovil.modules.encuestas.domain.usecase.Actualizar;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.domain.usecase.GetEncuesta;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.domain.usecase.GetEstablecimientos;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.EncuestaUi;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.PreguntaUi;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.ProveedorLocalUi;
import pe.com.hatunsol.hatunsolmovil.services.entities.BE_Constantes;
import pe.com.hatunsol.hatunsolmovil.services.entities.Encuesta;
import pe.com.hatunsol.hatunsolmovil.services.entities.Pregunta;
import pe.com.hatunsol.hatunsolmovil.services.entities.SessionUser;
import pe.com.hatunsol.hatunsolmovil.util.FilterWithSpaceAdapter;


public class RevisarEncuestaActivity extends BaseActivity<RevisarEncuestaView, RevisarEncuestaPresenter> implements RevisarEncuestaView, BaseFragmentListener, PreguntaListener, TextWatcher {
    RevisarEncuestaAdapter adapter;

    @BindView(R.id.rvPreguntas)
    RecyclerView rvPreguntas;

    @BindView(R.id.btAprobado)
    Button btAprobado;

    @BindView(R.id.btRevisado)
    Button btRevisado;

    @BindView(R.id.progressbar)
    ProgressBar progressbar;

    @BindView(R.id.atEstablecimiento)
    AutoCompleteTextView atEstablecimiento;
    private List<Pregunta> preguntaUiList = new ArrayList<>();

    @Override
    protected String getTag() {
        return RevisarEncuestaActivity.class.getSimpleName();
    }

    @Override
    protected AppCompatActivity getActivity() {
        return this;
    }

    @Override
    protected RevisarEncuestaPresenter getPresenter() {
        EncuestasRepository repository = new EncuestasRepository(new EncuestaRemoteDataSource(), new EncuestasLocalDataSource());
        presenter = new RevisarEncuestaPresenterImpl(new UseCaseHandler(new UseCaseThreadPoolScheduler()), getResources(), new GetEncuesta(repository), new GetEstablecimientos(repository), new Actualizar(repository));
        return presenter;
    }

    @Override
    protected RevisarEncuestaView getBaseView() {
        return this;
    }

    @Override
    protected Bundle getExtrasInf() {
        return getIntent().getExtras();


    }


    @Override
    protected void setContentView() {
        setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.activity_revisar_encuesta);
        ButterKnife.bind(this);
        setupAdapter();
    }


    private void setupAdapter() {
        adapter = new RevisarEncuestaAdapter(new ArrayList<>(), this);
        rvPreguntas.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvPreguntas.setAdapter(adapter);
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
    public void CargarEncuesta(Encuesta encuesta) {
        adapter.setEncuestaUiList(encuesta.getPreguntas());
        //Si es Jefe de Marca y esta Aprobado o Revisado
        if (SessionUser.getCurrentUser().getCargoId() == BE_Constantes.TipoUsuarios.JefedeMarca) {


            if (encuesta.getVerif_Sup() == BE_Constantes.EstadoEncuesta.Revisado ||
                    encuesta.getVerif_Sup() == BE_Constantes.EstadoEncuesta.Aprobado) {
                atEstablecimiento.setEnabled(false);
                if (encuesta.getIdEncuestaUsuario() != 0) {
                    btAprobado.setText("Actualizar");
                } else {
                    btAprobado.setText("Registrar");
                }
                btAprobado.setVisibility(View.GONE);
                btRevisado.setVisibility(View.GONE);

            } else {
                if (encuesta.getIdEncuestaUsuario() != 0) {
                    btAprobado.setText("Actualizar");
                } else {
                    btAprobado.setText("Registrar");
                }
                btAprobado.setVisibility(View.VISIBLE);
                btRevisado.setVisibility(View.GONE);
            }


        } else if (SessionUser.getCurrentUser().getCargoId() == BE_Constantes.TipoUsuarios.Supervisor) {
            atEstablecimiento.setEnabled(false);
            btAprobado.setText("Aprobado");
            btAprobado.setVisibility(View.VISIBLE);
            btRevisado.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void showEstablecimientos(List<ProveedorLocalUi> proveedorLocalUiList) {
        // this.proveedorLocalUiList = proveedorLocalUiList;


        List<String> stringList = new ArrayList<>();
        for (ProveedorLocalUi proveedorLocalUi : proveedorLocalUiList)
            stringList.add(proveedorLocalUi.getNombre());

        /*ListaFerreteriasAdapter namesAdapter = new ListaFerreteriasAdapter(
                RevisarEncuestaActivity.this,
                R.layout.autocomplete_item,
                R.id.lbl_name,
                stringList
        );*/
        //set adapter into listStudent


        FilterWithSpaceAdapter<String> adapter1 = new FilterWithSpaceAdapter<String>(RevisarEncuestaActivity.this,
                R.layout.custom_spinner, stringList);

        atEstablecimiento.setThreshold(1);
        atEstablecimiento.setAdapter(adapter1);
    }


    @OnClick(R.id.btAprobado)
    public void OnClickAprobado(View v) {
        btRevisado.setEnabled(false);
        btAprobado.setEnabled(false);
        if (v.getId() == R.id.btAprobado) {
            ProveedorLocalUi proveedorLocalUi = presenter.ObtenerEstablecimiento(atEstablecimiento.getText().toString());
            if (proveedorLocalUi == null) {
                Error("Complete todos los Campos");
                return;
            }

            EncuestaUi encuestaUi = new EncuestaUi();
            encuestaUi.setProveedorLocalId(proveedorLocalUi.getProveedorLocalId());
            if (SessionUser.getCurrentUser().getCargoId() == BE_Constantes.TipoUsuarios.JefedeMarca) {
                encuestaUi.setVerif_Sup(BE_Constantes.EstadoEncuesta.Creado);
            } else {
                encuestaUi.setVerif_Sup(BE_Constantes.EstadoEncuesta.Aprobado);
            }
            presenter.OnClickGuardar(encuestaUi);

        }
    }


    @Override
    public void OnClickAprobado(Encuesta encuesta) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_aceptar, null);
        builder.setView(view);
        Button btConfirmacion = view.findViewById(R.id.btConfirmacion);

        TextView tvMensaje = view.findViewById(R.id.tvMensaje);
        if (encuesta.getOperacion() == BE_Constantes.EstadoEncuesta.Creado) {
            tvMensaje.setText("Encuesta Registrada Correctamente");
            btAprobado.setText("Actualizar");
        } else {
            tvMensaje.setText("Encuesta Actualizada Correctamente");
        }

        btConfirmacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });
        builder.create();
        builder.show();

        Bundle extras = new Bundle();
        extras.putInt("IdEncuesta", encuesta.getIdEncuesta());
        extras.putInt("IdEncuestaUsuario", encuesta.getIdEncuestaUsuario());
        extras.putInt("Operacion", BE_Constantes.Operacion.Modificar);
        presenter.setExtras(extras);
        btAprobado.setEnabled(true);
        btRevisado.setEnabled(true);

    }

    @Override
    public void Error(String Mensaje) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_error, null);
        builder.setView(view);
        Button btConfirmacion = view.findViewById(R.id.btConfirmacion);
        TextView tvMensaje = view.findViewById(R.id.tvMensaje);
        tvMensaje.setText(Mensaje);

        builder.create();

        AlertDialog alert = builder.show();
        btConfirmacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.dismiss();
            }
        });
        btAprobado.setEnabled(true);

    }


    @Override
    public void setProveedorLocal(String nombre) {
        atEstablecimiento.setText(nombre);
        atEstablecimiento.clearFocus();
    }

    @Override
    public void hideProgresbar() {
        progressbar.setVisibility(View.GONE);
    }

    @Override
    public void showProgressbar() {
        progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void OnResumeList(List<Pregunta> preguntaList) {
        adapter.setEncuestaUiList(preguntaList);
    }


    @OnClick(R.id.btRevisado)
    @Override
    public void OnClickRevisado(View v) {
        if (v.getId() == R.id.btRevisado) {
            ProveedorLocalUi proveedorLocalUi = presenter.ObtenerEstablecimiento(atEstablecimiento.getText().toString());
            if (proveedorLocalUi == null) {
                Error("Complete todos los Campos");
                return;
            }
            EncuestaUi encuestaUi = new EncuestaUi();
            encuestaUi.setProveedorLocalId(proveedorLocalUi.getProveedorLocalId());
            encuestaUi.setVerif_Sup(BE_Constantes.EstadoEncuesta.Revisado);
            btRevisado.setEnabled(false);
            btAprobado.setEnabled(false);
            presenter.OnClickGuardar(encuestaUi);
        }
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Log.d("TitularFragment", "beforeTextChanged: " + charSequence.toString());
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Log.d("TitularFragment", "onTextChanged: " + charSequence.toString());
    }

    @Override
    public void afterTextChanged(Editable editable) {
        /*if (presenter != null) {
            switch (editable) {
                case 0:
                    if (s.length() == 8) presenter.onValidateDocumento(editable.toString());
                    else edt_documento_identidad.setError("Minimo 8 dígitos");
                    break;
                case 1:
                    if (s.length() == 11) presenter.onValidateDocumento(editable.toString());
                    else edt_documento_identidad.setError("Minimo 11 dígitos");
                    break;
                case 2:
                    if (s.length() == 12) presenter.onValidateDocumento(editable.toString());
                    else edt_documento_identidad.setError("Minimo 12 dígitos");
                    break;
            }
        }*/
    }


    /*@Override
    public void onClickSi(Pregunta o) {
        o.getOpciones().get(0).setChecked(true);
        o.getOpciones().get(1).setChecked(false);
    }

    @Override
    public void onClickNo(Pregunta o) {
        o.getOpciones().get(1).setChecked(true);
        o.getOpciones().get(0).setChecked(false);
    }*/


    @Override
    public void onClick(Pregunta pregunta) {
        presenter.onClickList(pregunta);
    }




}
