package pe.com.hatunsol.hatunsolmovil.modules.encuestas.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pe.com.hatunsol.hatunsolmovil.R;
import pe.com.hatunsol.hatunsolmovil.modules.creditos.entities.PersonaUi;
import pe.com.hatunsol.hatunsolmovil.modules.creditos.listener.CreditosListener;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.EncuestaUi;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.listener.EncuestaListener;
import pe.com.hatunsol.hatunsolmovil.services.entities.Encuesta;

public class EncuestaHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_estado)
    TextView estado;
    @BindView(R.id.txt_descripcion)
    TextView txt_descripcion;
    @BindView(R.id.nombre)
    TextView nombre;
    @BindView(R.id.fecha)
    TextView fecha;

    private EncuestaUi encuestaUi;
    private EncuestaListener listener;

    public EncuestaHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(EncuestaUi encuestaUi, EncuestaListener listener){
        this.encuestaUi = encuestaUi;
        this.listener = listener;

        nombre.setText(encuestaUi.getNombre_Encuesta());
        txt_descripcion.setText(encuestaUi.getDescripcion());
        estado.setText(encuestaUi.getVerificacion());
        fecha.setText(encuestaUi.getFechaCrea());

    }

    @OnClick({R.id.encuesta})
    public void OnClick(View view){
        switch (view.getId())
        {
            case R.id.encuesta:
                listener.onClickItem(encuestaUi);
                break;

        }
    }
}
