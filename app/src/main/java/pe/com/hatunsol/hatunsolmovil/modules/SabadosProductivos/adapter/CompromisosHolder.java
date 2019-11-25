package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pe.com.hatunsol.hatunsolmovil.R;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.entities.ProveedorLocalUi;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.listener.SabadoProductivoListener;
import pe.com.hatunsol.hatunsolmovil.services.entities.SessionUser;

public class CompromisosHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.tvnombreCompromiso)
    TextView tvnombreCompromiso;
    @BindView(R.id.tvfechaCompromiso)
    TextView fechaCompromiso;
    @BindView(R.id.tvnombreUsuarioCompromiso)
    TextView usuarioCompromiso;
    @BindView(R.id.container)
    ConstraintLayout container;

    private ProveedorLocalUi proveedorLocalUi;
    private SabadoProductivoListener listener;

    public CompromisosHolder(@NonNull View itemView, SabadoProductivoListener listener) {
        super(itemView);
        this.listener = listener;
        ButterKnife.bind(this, itemView);
        container.setOnClickListener(this);

    }




    public void bind(ProveedorLocalUi proveedorLocalUi, SabadoProductivoListener listener){
        this.proveedorLocalUi = proveedorLocalUi;
        this.listener = listener;

        tvnombreCompromiso.setText(proveedorLocalUi.getNombreProveedor());
        fechaCompromiso.setText(proveedorLocalUi.getFecha());
        usuarioCompromiso.setText(proveedorLocalUi.getUsuario());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.container:
                listener.onClickListenerCompromiso(proveedorLocalUi.getNombreProveedor(),proveedorLocalUi.getFecha(), SessionUser.getCurrentUser().getPersonaId());
                break;
        }
    }
}
