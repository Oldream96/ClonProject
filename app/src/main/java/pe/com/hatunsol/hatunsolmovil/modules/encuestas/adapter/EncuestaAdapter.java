package pe.com.hatunsol.hatunsolmovil.modules.encuestas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.R;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.EncuestaUi;
import pe.com.hatunsol.hatunsolmovil.modules.encuestas.listener.EncuestaListener;
import pe.com.hatunsol.hatunsolmovil.services.entities.Encuesta;

public class EncuestaAdapter extends RecyclerView.Adapter {

    private List<EncuestaUi> encuestaUiList;
    private EncuestaListener listener;

    public EncuestaAdapter(List<EncuestaUi> encuestaUiList, EncuestaListener listener) {
        this.encuestaUiList = encuestaUiList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_encuestas
                , parent, false);
        return new EncuestaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        EncuestaUi encuestaUi = encuestaUiList.get(position);
        EncuestaHolder creditosHolder = (EncuestaHolder) holder;
        creditosHolder.bind(encuestaUi, listener);
    }

    @Override
    public int getItemCount() {
        return encuestaUiList.size();
    }

    public void setEncuestaUiList(List<EncuestaUi> encuestaUiList){
        this.encuestaUiList.clear();
        this.encuestaUiList.addAll(encuestaUiList);
        notifyDataSetChanged();
    }



}
