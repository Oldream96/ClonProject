package pe.com.hatunsol.hatunsolmovil.modules.encuestas.ui;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.se.omapi.Session;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.dewinjm.monthyearpicker.MonthYearPickerDialog;
import com.github.dewinjm.monthyearpicker.MonthYearPickerDialogFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import pe.com.hatunsol.hatunsolmovil.R;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseHandler;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseThreadPoolScheduler;
import pe.com.hatunsol.hatunsolmovil.base.fragment.BaseFragment;

import pe.com.hatunsol.hatunsolmovil.modules.encuestas.RevisarEncuesta.ui.RevisarEncuestaActivity;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.adapter.EncuestaAdapter;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.data.source.EncuestasRepository;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.data.source.local.EncuestasLocalDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.data.source.remoto.EncuestaRemoteDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.domain.usecase.GetListEncuestas;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.domain.usecase.GetUsuario;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.EncuestaUi;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.listener.EncuestaListener;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.presenter.EncuestaPrenserImpl;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.presenter.EncuestaPresenter;
import pe.com.hatunsol.hatunsolmovil.services.entities.BE_Constantes;
import pe.com.hatunsol.hatunsolmovil.services.entities.SessionUser;

import static android.app.Activity.RESULT_OK;

public class EncuestaFragment extends BaseFragment<EncuestaView, EncuestaPresenter, EncuestaListener> implements EncuestaView, EncuestaListener {


    @BindView(R.id.rvEncuestas)
    RecyclerView rvEncuestas;
    @BindView(R.id.edt_buscar)
    EditText edt_buscar;
    @BindView(R.id.progressbar)
    ProgressBar progressbar;
    EncuestaAdapter adapter;
    DrawerLayout drawerLayout;

    NavigationView navigationView;
    int Anio, Mes;
    private boolean buttonFilter = true;

    /*DatePickerDialog.OnDateSetListener onDateListener = new DatePickerDialog.OnDateSetListener() {


        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            Mes = i1 + 1;
            Anio = i;
            presenter.setFecha(Mes, Anio, edt_buscar.getText().toString());
        }
    };*/


    @Override
    protected String getLogTag() {
        return EncuestaFragment.class.getSimpleName();
    }

    public static EncuestaFragment newInstance() {
        EncuestaFragment fragmentregistroasistencia = new EncuestaFragment();
        return fragmentregistroasistencia;
    }

    @Override
    protected EncuestaPresenter getPresenter() {
        EncuestasRepository repository = new EncuestasRepository(new EncuestaRemoteDataSource(), new
                EncuestasLocalDataSource());

        presenter = new EncuestaPrenserImpl(new UseCaseHandler(new UseCaseThreadPoolScheduler()), getResources(),
                new GetListEncuestas(repository), new GetUsuario(repository));
        return presenter;
    }

    @Override
    protected EncuestaView getBaseView() {
        return this;
    }

    @Override
    protected View inflateView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_encuestas, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().findViewById(R.id.fab).setVisibility(View.VISIBLE);
        setupAdapter();
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        navigationView = (NavigationView) getActivity().findViewById(R.id.nvView);
        if(SessionUser.getCurrentUser().getCargoId()==BE_Constantes.TipoUsuarios.JefeZonal ||
                SessionUser.getCurrentUser().getCargoId()==BE_Constantes.TipoUsuarios.ADO ||
                SessionUser.getCurrentUser().getCargoId()==BE_Constantes.TipoUsuarios.Supervisor){
            fab.hide();
        }
    }


    private void setupAdapter() {
        adapter = new EncuestaAdapter(new ArrayList<>(), this);
        rvEncuestas.setLayoutManager(new LinearLayoutManager(getContext()));
        rvEncuestas.setAdapter(adapter);
    }


    @Override
    protected ViewGroup getRootLayout() {
        return null;
    }

    @Override
    protected ProgressBar getProgressBar() {
        return null;
    }

    /*@Override
    public void showText(String respuesta) {
        editText.setText(respuesta);
    }*/

    @Override
    public void showText(String respuesta) {

    }

    @Override
    public void showEncuestaList(List<EncuestaUi> encuestaUiList) {
        adapter.setEncuestaUiList(encuestaUiList);
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mes = new Date().getMonth();
        Anio = new Date().getYear() + 1900;
    }

/*@OnClick({R.id.fab})
    @Override
    public void OnClickEncuesta(View v) {
        switch (v.getId()){
            case R.id.fab:
                onInitActivityRevisarEncuesta();
                break;
        }
    }*/


    static final int REGISTRAR_ENCUESTA = 1;

    @Override
    public void onClickItem(EncuestaUi o) {
        Intent intent = new Intent(getActivity(), RevisarEncuestaActivity.class);
        intent.putExtra("IdEncuesta", o.getIdEncuesta());
        intent.putExtra("IdEncuestaUsuario", o.getIdEncuestaUsuario());
        if (SessionUser.getCurrentUser().getCargoId() == BE_Constantes.TipoUsuarios.JefedeMarca) {
            intent.putExtra("Operacion", BE_Constantes.Operacion.Modificar);
        } else if (SessionUser.getCurrentUser().getCargoId() == BE_Constantes.TipoUsuarios.Supervisor) {
            intent.putExtra("Operacion", BE_Constantes.Operacion.Revizar);
        }
        startActivityForResult(intent, REGISTRAR_ENCUESTA);
    }

    @OnClick({R.id.ic_search, R.id.ic_menu})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.ic_search:
                Buscar();
                break;
            case R.id.ic_menu:
                onShowMenu();
                break;
        }
    }

    private void onShowMenu() {
        this.drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        drawerLayout.openDrawer(Gravity.LEFT);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REGISTRAR_ENCUESTA) {
            if (resultCode == RESULT_OK) {
                Buscar();
            }
        }
    }

    private void Buscar() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edt_buscar.getWindowToken(), 2);
        presenter.listarEncuesta(edt_buscar.getText().toString());
    }


    private void onInitActivityRevisarEncuesta() {
        Intent intent = new Intent(getActivity(), RevisarEncuestaActivity.class);
        startActivityForResult(intent, REGISTRAR_ENCUESTA);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @OnClick({R.id.fabCalendar, R.id.fab})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.fabCalendar:
                createDialogWithoutDateField(v);
                break;
            case R.id.fab:
                onInitActivityRevisarEncuesta();
                break;
        }
    }


    /*private DatePickerDialog createDialogWithoutDateField() {
        DatePickerDialog dpd = new DatePickerDialog(getActivity(), onDateListener, Anio, Mes - 1, 1);
        dpd.getDatePicker().setMaxDate(new Date().getTime());
        dpd.setButton(DialogInterface.BUTTON_POSITIVE, "Aceptar", dpd);
        try {
            Field[] datePickerDialogFields = dpd.getClass().getDeclaredFields();
            for (Field datePickerDialogField : datePickerDialogFields) {
                if (datePickerDialogField.getName().equals("mDatePicker")) {
                    datePickerDialogField.setAccessible(true);
                    DatePicker datePicker = (DatePicker) datePickerDialogField.get(dpd);

                    Field[] datePickerFields = datePickerDialogField.getType().getDeclaredFields();
                    for (Field datePickerField : datePickerFields) {
                        Log.i("test", datePickerField.getName());
                        if ("mDaySpinner".equals(datePickerField.getName())) {
                            datePickerField.setAccessible(true);
                            Object dayPicker = datePickerField.get(datePicker);
                            ((View) dayPicker).setVisibility(View.GONE);
                        }
                    }
                }
            }
        } catch (Exception ex) {
        }
        return dpd;
    }*/


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void createDialogWithoutDateField(View v) {
        switch (v.getId()) {
            case R.id.fabCalendar:
                int MesScroll = new Date().getMonth();
                int AnioScroll = new Date().getYear() + 1900;
                Calendar calendar = Calendar.getInstance();
                calendar.clear();
                calendar.set(2010, 0, 1); // Set minimum date to show in dialog
                long minDate = calendar.getTimeInMillis();
                calendar.clear();
                calendar.set(AnioScroll, MesScroll, 31); // Set maximum date to show in dialog
                long maxDate = calendar.getTimeInMillis();
                MonthYearPickerDialogFragment dialogFragment = MonthYearPickerDialogFragment
                        .getInstance(Mes, Anio, minDate, maxDate);

                dialogFragment.setOnDateSetListener(new MonthYearPickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(int year, int monthOfYear) {
                        Mes = monthOfYear;
                        Anio = year;

                        presenter.setFecha(Mes + 1, year, edt_buscar.getText().toString());
                    }
                });

                dialogFragment.show(getFragmentManager(), null);
                break;
        }
    }

    @Override
    public void setFocusMenu() {
        navigationView.getMenu().getItem(2).setChecked(true);
    }


}
