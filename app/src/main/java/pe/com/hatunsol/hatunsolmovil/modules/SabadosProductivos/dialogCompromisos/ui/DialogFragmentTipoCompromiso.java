package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.dialogCompromisos.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;

import java.io.ObjectOutput;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import pe.com.hatunsol.hatunsolmovil.R;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseHandler;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseThreadPoolScheduler;
import pe.com.hatunsol.hatunsolmovil.base.dialogFragment.BaseDialogFragment;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.RegistrarCompromisos.ui.CrearCompromisosActivity;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.SabadoProductivoRepository;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.local.SPLocalDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.remoto.SPRemotoDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.dialogCompromisos.presenter.TipoCompromisoPresenter;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.dialogCompromisos.presenter.TipoCompromisoPresenterImpl;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.domain.GetCompromisos;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.domain.GetUsuario;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.entities.ProveedorLocalUi;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public class DialogFragmentTipoCompromiso extends BaseDialogFragment<TipoCompromisoView, TipoCompromisoPresenter, TipoCompromisoListener> implements TipoCompromisoView, TipoCompromisoListener, View.OnClickListener {


    private static List<ProveedorLocalUi> proveedorLocalUiList;
    ConstraintLayout clActivos;
    ConstraintLayout clFerreterias;
    ConstraintLayout clDerivados;
    ConstraintLayout clClose;

    private int codigousuario;

    public static DialogFragmentTipoCompromiso newInstance(List<ProveedorLocalUi> proveedorLocalUiList2) {
        proveedorLocalUiList = proveedorLocalUiList2;
        DialogFragmentTipoCompromiso fragmentEstado = new DialogFragmentTipoCompromiso();
        fragmentEstado.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        return fragmentEstado;
    }

    @Override
    protected String getLogTag() {
        return DialogFragmentTipoCompromiso.class.getSimpleName();
    }

    @Override
    protected TipoCompromisoPresenter getPresenter() {
        SabadoProductivoRepository repository = new SabadoProductivoRepository(new SPRemotoDataSource(), new SPLocalDataSource());
        presenter = new TipoCompromisoPresenterImpl(new UseCaseHandler(new UseCaseThreadPoolScheduler()), getResources()
                , new GetUsuario(repository));
        return presenter;
    }


    @Override
    protected TipoCompromisoView getBaseView() {
        return this;
    }

    @Override
    protected View inflateView(LayoutInflater inflater, ViewGroup container) {
        View v = inflater.inflate(R.layout.dialog_tipo_compromiso, container, false);
        setUpComponents(v);
        return v;
    }

    private void setUpComponents(View view) {

        clFerreterias = view.findViewById(R.id.clferreteria);
        clActivos = view.findViewById(R.id.clactivos);
        clDerivados = view.findViewById(R.id.clderivaciones);
        clClose = view.findViewById(R.id.clclose);

        clClose.setOnClickListener(this);
        clFerreterias.setOnClickListener(this);
        clActivos.setOnClickListener(this);
        clDerivados.setOnClickListener(this);


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
    public void onStart() {
        super.onStart();
        this.getDialog().getWindow()
                .setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        this.getDialog().getWindow().
                setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        this.getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Window window = this.getDialog().getWindow();
        WindowManager.LayoutParams param = window.getAttributes();
        // set the layout at right bottom
        param.gravity = Gravity.BOTTOM | Gravity.RIGHT;
        // it dismiss the pdialog when click outside the pdialog frame
        this.getDialog().setCanceledOnTouchOutside(true);
        // initialize the item of the pdialog box, whose id is demo1

    }

    @Override
    public void onClick(View v) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Date date = new Date();
        String fecha = dateFormat.format(date);
        switch (v.getId()) {
            case R.id.clclose:
                dismiss();
                break;
            case R.id.clferreteria:
                if(validateCompromisoCreado("COMPROMISO DE FERRETERÍAS"))
                onInitDetalleCompromisosActivity("COMPROMISO DE FERRETERÍAS", fecha, codigousuario);
                else Toast.makeText(getActivity(), "Ya existe un compromiso de ese tipo para esta semana", Toast.LENGTH_SHORT).show();
                dismiss();
                break;
            case R.id.clderivaciones:
                if(validateCompromisoCreado("COMPROMISO DE DERIVADOS"))
                onInitDetalleCompromisosActivity("COMPROMISO DE DERIVADOS", fecha, codigousuario);
                else Toast.makeText(getActivity(), "Ya existe un compromiso de ese tipo para esta semana", Toast.LENGTH_SHORT).show();
                dismiss();
                break;
            case R.id.clactivos:
                if(validateCompromisoCreado("COMPROMISO DE ACTIVADOS"))
                onInitDetalleCompromisosActivity("COMPROMISO DE ACTIVADOS", fecha, codigousuario);
                else Toast.makeText(getActivity(), "Ya existe un compromiso de ese tipo para esta semana", Toast.LENGTH_SHORT).show();
                dismiss();
                break;
        }
    }

    private boolean validateCompromisoCreado(String nombrecompromiso) {
        for (ProveedorLocalUi proveedorLocalUi : proveedorLocalUiList) {
            if ( proveedorLocalUi.getNombreProveedor().equals(nombrecompromiso)) {
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
                    return  false;
                }

            }
        }
        return true;
    }

    private void onInitDetalleCompromisosActivity(String nombre, String fecha, int codigoSupervisor) {
        Intent intent = new Intent(getActivity(), CrearCompromisosActivity.class);
        intent.putExtra("nombreCompromiso", nombre);
        intent.putExtra("fechaCompromiso", fecha);
        intent.putExtra("codigoSupervisor", codigoSupervisor);
        startActivity(intent);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.getDialog().getWindow()
                .setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        this.getDialog().getWindow().
                setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        this.getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Window window = this.getDialog().getWindow();
        WindowManager.LayoutParams param = window.getAttributes();
        // set the layout at right bottom
        param.gravity = Gravity.BOTTOM | Gravity.RIGHT;
        // it dismiss the pdialog when click outside the pdialog frame
        this.getDialog().setCanceledOnTouchOutside(true);
        // initialize the item of the pdialog box, whose id is demo1
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        codigousuario = getArguments().getInt("codigousuario");
        return super.onCreateView(inflater, container, savedInstanceState);


    }
}
