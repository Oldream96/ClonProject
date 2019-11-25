package pe.com.hatunsol.hatunsolmovil.modules.encuestas.RevisarEncuesta.adapter;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.R;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.RevisarEncuesta.listener.PreguntaListener;
import pe.com.hatunsol.hatunsolmovil.services.entities.Pregunta;

public class RevisarEncuestaAdapter extends RecyclerView.Adapter {
    private List<Pregunta> preguntaUiList;
    private PreguntaListener listener;

    public RevisarEncuestaAdapter(List<Pregunta> encuestaUiList, PreguntaListener listener) {
        this.preguntaUiList = encuestaUiList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pregunta
                , parent, false);
        return new RevisarEncuestaHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Pregunta encuestaUi = preguntaUiList.get(position);
        RevisarEncuestaHolder creditosHolder = (RevisarEncuestaHolder) holder;
        creditosHolder.bind(encuestaUi, listener);
    }


    @Override
    public int getItemCount() {
        return preguntaUiList.size();
    }

    public void setEncuestaUiList(List<Pregunta> encuestaUiList){
        this.preguntaUiList.clear();
        this.preguntaUiList.addAll(encuestaUiList);
        notifyDataSetChanged();
    }
}
