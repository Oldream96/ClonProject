package pe.com.hatunsol.hatunsolmovil.modules.encuestas.RevisarEncuesta.adapter;



import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.common.api.Api;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pe.com.hatunsol.hatunsolmovil.R;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.RevisarEncuesta.listener.PreguntaListener;
import pe.com.hatunsol.hatunsolmovil.services.entities.BE_Constantes;
import pe.com.hatunsol.hatunsolmovil.services.entities.Pregunta;
import pe.com.hatunsol.hatunsolmovil.services.entities.SessionUser;

import static android.graphics.Color.rgb;

public class RevisarEncuestaHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.tvGrupo)
    TextView tvGrupo;
    @BindView(R.id.tvDescripcion)
    TextView tvDescripcion;
    @BindView(R.id.btSi)
    Button btSi;
    @BindView(R.id.btNo)
    Button btNo;

    private Pregunta encuestaUi;
    private PreguntaListener listener;

    public RevisarEncuestaHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void bind(Pregunta encuestaUi, PreguntaListener listener) {

        btSi.setBackgroundTintList(itemView.getContext().getResources().getColorStateList(R.color.md_black_1000));
        btNo.setBackgroundTintList(itemView.getContext().getResources().getColorStateList(R.color.md_black_1000));

        this.encuestaUi = encuestaUi;
        this.listener = listener;

        tvGrupo.setText(encuestaUi.getGrupoPregunta());
        tvDescripcion.setText(encuestaUi.getDescripcion());


        if (encuestaUi.getOpciones().get(0).isChecked()) {
            if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ) {
                btSi.setBackgroundTintList(itemView.getContext().getResources().getColorStateList(R.color.md_yellow_600));
                btNo.setBackgroundTintList(itemView.getContext().getResources().getColorStateList(R.color.md_black_1000));
            } else{
                btSi.setBackgroundColor(rgb(250, 216, 24));
                btNo.setBackgroundColor(rgb(56, 56, 56));
            }
        } else if (encuestaUi.getOpciones().get(1).isChecked()) {
            if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ) {
                btNo.setBackgroundTintList(itemView.getContext().getResources().getColorStateList(R.color.md_yellow_600));
                btSi.setBackgroundTintList(itemView.getContext().getResources().getColorStateList(R.color.md_black_1000));
            } else {
                btNo.setBackgroundColor(rgb(250, 216, 24));
                btSi.setBackgroundColor(rgb(56, 56, 56));
            }
        }

        //Si es Jefe Marca y ya fue Revisado o Aprobado bloquear
        if (SessionUser.getCurrentUser().getCargoId() == BE_Constantes.TipoUsuarios.JefedeMarca
                && (encuestaUi.getVerif_Sup() == BE_Constantes.EstadoEncuesta.Aprobado || encuestaUi.getVerif_Sup() == BE_Constantes.EstadoEncuesta.Revisado)) {
            btSi.setEnabled(false);
            btNo.setEnabled(false);
        }
        //Si es Supervisor no debe permitir cambiar respuestas
        else if (SessionUser.getCurrentUser().getCargoId() == BE_Constantes.TipoUsuarios.Supervisor) {
            btSi.setEnabled(false);
            btNo.setEnabled(false);
        }

    }

    //@SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick({R.id.btSi, R.id.btNo})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.btSi:
                encuestaUi.getOpciones().get(0).setChecked(true);
                encuestaUi.getOpciones().get(1).setChecked(false);

                /*btSi.setBackground(itemView.getContext().getResources().getDrawable(R.color.md_yellow_600));
                btNo.setBackground(itemView.getContext().getResources().getDrawable(R.color.md_black_1000));
*/

                if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ) {
                    btSi.setBackgroundTintList(itemView.getContext().getResources().getColorStateList(R.color.md_yellow_600));
                    btNo.setBackgroundTintList(itemView.getContext().getResources().getColorStateList(R.color.md_black_1000));
                } else{
                    btSi.setBackgroundColor(rgb(250, 216, 24));
                    btNo.setBackgroundColor(rgb(56, 56, 56));
                }
                listener.onClick(encuestaUi);
                break;
            case R.id.btNo:
                encuestaUi.getOpciones().get(0).setChecked(false);
                encuestaUi.getOpciones().get(1).setChecked(true);

                if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ) {
                    btNo.setBackgroundTintList(itemView.getContext().getResources().getColorStateList(R.color.md_yellow_600));
                    btSi.setBackgroundTintList(itemView.getContext().getResources().getColorStateList(R.color.md_black_1000));
                } else {
                    btNo.setBackgroundColor(rgb(250, 216, 24));
                    btSi.setBackgroundColor(rgb(56, 56, 56));
                }
                listener.onClick(encuestaUi);
                break;
        }
    }


    /*@OnClick({R.id.btSi})
    public void OnClickSi(View view) {
        listener.onClickSi(encuestaUi);

        btSi.setBackground(itemView.getContext().getResources().getDrawable(R.drawable.btn_blue));
        btNo.setBackground(itemView.getContext().getResources().getDrawable(R.drawable.btn_green));
    }

    @OnClick({R.id.btNo})
    public void OnClickNo(View view) {
        listener.onClickNo(encuestaUi);

        btNo.setBackground(itemView.getContext().getResources().getDrawable(R.drawable.btn_blue));
        btSi.setBackground(itemView.getContext().getResources().getDrawable(R.drawable.btn_green));
    }*/


}