package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.RegistrarCompromisos.adapter;

import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TooManyListenersException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnTextChanged;
import pe.com.hatunsol.hatunsolmovil.R;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.RegistrarCompromisos.FerreteriaFragment.FerreteriaCompromisoListener;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.entities.ProveedorLocalUi;

public class FerreteriaCompromisoHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tvferrenombre)
    TextView tv_ferreterianombre;

    @BindView(R.id.tvferreruc)
    TextView ruc;

    @BindView(R.id.chkFerreteriaCompromiso)
    CheckBox chkferreteria;

    @BindView(R.id.edtmotivoferre)
    EditText edt_motivoferre;

    @BindView(R.id.edtaccionferre)
    EditText edt_accionferre;

    @BindView(R.id.tvMotivoRefiere)
    TextView tvMotivoRefiere;

    @BindView(R.id.tv_accionDetalle)
    TextView tvAccionDetalle;

    @BindView(R.id.clItemDetalleCompromiso)
    ConstraintLayout clitem;


    private ProveedorLocalUi proveedorLocalUi;

    private FerreteriaCompromisoListener listener;
    private Date fecha;
    private String date;
    public EditText mtextView1;
    public EditText mtextView2;
    //public FerreteriaCompromisoAdapter.MyCustomEditTextListener myCustomEditTextListener;



    public FerreteriaCompromisoHolder(@NonNull View itemview, FerreteriaCompromisoListener listener) {
        super(itemview);
        ButterKnife.bind(this, itemview);
        mtextView1 = itemView.findViewById(R.id.edtaccionferre);
        mtextView2 = itemView.findViewById(R.id.edtmotivoferre);
        //this.myCustomEditTextListener = myCustomEditTextListener;
        //edt_accionferre.addTextChangedListener(myCustomEditTextListener);
//        itemview.setOnClickListener(this);
//        chkferreteria.setOnCheckedChangeListener(this);
//        clitem.setOnClickListener(this);

        mtextView1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                proveedorLocalUi.setAccion(mtextView1.getText().toString());
                listener.onChangeTextAccion(proveedorLocalUi);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mtextView2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                proveedorLocalUi.setRazon(mtextView2.getText().toString());
                listener.onChangeTextMotivo(proveedorLocalUi);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }


//    public FerreteriaCompromisoHolder(FerreteriaCompromisoListener listener) {
//        this.listener = listener;
//    }

    public void bind(ProveedorLocalUi proveedorLocalUi, FerreteriaCompromisoListener listener, int position) {
        this.proveedorLocalUi = proveedorLocalUi;
        this.listener = listener;
        tv_ferreterianombre.setText(proveedorLocalUi.getNombreComercial().trim());
        edt_accionferre.setFilters(new InputFilter[] {new InputFilter.AllCaps(),new InputFilter.LengthFilter(200)});
        edt_motivoferre.setFilters(new InputFilter[] {new InputFilter.AllCaps(),new InputFilter.LengthFilter(200)});
        if (proveedorLocalUi.getTipo() == 1) {
            ruc.setText(Html.fromHtml("<b>RUC: </b>" + proveedorLocalUi.getRUC()));
            chkferreteria.setChecked(true);
            chkferreteria.setEnabled(false);
        } else {
            ruc.setText(Html.fromHtml("<b>DNI: </b>" + proveedorLocalUi.getRUC() + "&ensp;&ensp;<b>Estado: </b>" + proveedorLocalUi.getEstado()));
            edt_motivoferre.setVisibility(View.GONE);
            tvMotivoRefiere.setVisibility(View.GONE);
            chkferreteria.setChecked(proveedorLocalUi.getStatus()==2);
            if (proveedorLocalUi.getStatus()==2){
                tvAccionDetalle.setVisibility(View.VISIBLE);
                edt_accionferre.setVisibility(View.VISIBLE);
            } else {
                tvAccionDetalle.setVisibility(View.GONE);
                edt_accionferre.setVisibility(View.GONE);
            }

        }

//        edt_accionferre.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                //proveedorLocalUi.setAccion(edt_accionferre.getText().toString());
//                //notify();
//
//            }
//        });

        edt_motivoferre.setText(proveedorLocalUi.getRazon());
        edt_accionferre.setText(proveedorLocalUi.getAccion());

    }

    @OnClick(R.id.chkFerreteriaCompromiso)
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.chkFerreteriaCompromiso:
                listener.OnclickCheckDetalleCOmpromiso(proveedorLocalUi);
                AbrirAccion();
                break;
        }
    }


    private void AbrirAccion() {
        if (!tvAccionDetalle.isShown()) {
            //chkferreteria.setChecked(true);
            tvAccionDetalle.setVisibility(View.VISIBLE);
            edt_accionferre.setVisibility(View.VISIBLE);
            edt_accionferre.setHint("Acción");
        } else {
            tvAccionDetalle.setVisibility(View.GONE);
            edt_accionferre.setVisibility(View.GONE);
        }
    }

    private void OnclickCheckDetalleCOmpromis() {
        if (proveedorLocalUi.getAccion().isEmpty()) {
            tvAccionDetalle.setVisibility(View.VISIBLE);
            tvAccionDetalle.setAlpha(0.0f);
            tvAccionDetalle.animate()
                    .alpha(1.0f)
                    .setDuration(500)
                    .setListener(null);
            edt_accionferre.setVisibility(View.VISIBLE);
            edt_accionferre.setAlpha(0.0f);
            edt_accionferre.animate()
                    .alpha(1.0f)
                    .setDuration(500)
                    .setListener(null);
        } else {
            tvAccionDetalle.setVisibility(View.GONE);
            edt_accionferre.setVisibility(View.GONE);
        }

    }
}
