package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.R;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.entities.ProveedorLocalUi;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.listener.SabadoProductivoListener;
import pe.com.hatunsol.hatunsolmovil.services.entities.ProveedorLocal;

public class CompromisoAdapter extends RecyclerView.Adapter {

    private List<ProveedorLocalUi> proveedorLocalUiList;
    private SabadoProductivoListener listener;


    public CompromisoAdapter(List<ProveedorLocalUi> proveedorLocalUiList, SabadoProductivoListener listener) {
        this.proveedorLocalUiList = proveedorLocalUiList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_compromisos,
                parent,false);
        return new CompromisosHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProveedorLocalUi proveedorLocalUi = proveedorLocalUiList.get(position);
        CompromisosHolder compromisosHolder = (CompromisosHolder) holder;
        compromisosHolder.bind(proveedorLocalUi, listener);


    }

    @Override
    public int getItemCount() {
        return proveedorLocalUiList.size();
    }

    public void setProveedorLocalUiList(List<ProveedorLocalUi> proveedorLocalUiList) {
        this.proveedorLocalUiList.clear();
        this.proveedorLocalUiList.addAll(proveedorLocalUiList);
        notifyDataSetChanged();
    }
}
