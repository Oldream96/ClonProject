package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.RegistrarCompromisos.adapter;

import android.animation.Animator;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.R;

import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.RegistrarCompromisos.FerreteriaFragment.FerreteriaCompromisoListener;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.entities.ProveedorLocalUi;
import pe.com.hatunsol.hatunsolmovil.services.entities.ProveedorLocal;

public class FerreteriaCompromisoAdapter extends RecyclerView.Adapter {


    public List<ProveedorLocalUi> proveedorLocalUiList;
    private FerreteriaCompromisoListener listener;

    public FerreteriaCompromisoAdapter(List<ProveedorLocalUi> proveedorLocalUiList, FerreteriaCompromisoListener listener) {
        this.proveedorLocalUiList = proveedorLocalUiList;
        this.listener = listener;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_regferreteria_compromiso
                , parent, false);
        FerreteriaCompromisoHolder ferreteriaCompromisoHolder = new FerreteriaCompromisoHolder(view,listener);
        return ferreteriaCompromisoHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ProveedorLocalUi proveedorLocalUi = proveedorLocalUiList.get(position);
        FerreteriaCompromisoHolder ferreteriaCompromisoHolder = (FerreteriaCompromisoHolder) holder;
        ferreteriaCompromisoHolder.bind(proveedorLocalUi, listener, position);
//        ((FerreteriaCompromisoHolder) holder).myCustomEditTextListener.updatePosition(holder.getAdapterPosition());
//        ((FerreteriaCompromisoHolder) holder).edt_accionferre.setText( proveedorLocalUiList.get(holder.getAdapterPosition()).getAccion() );

    }

    @Override
    public int getItemCount() {
        return proveedorLocalUiList.size();
    }

    public void setProveedorLocalUiList(List<ProveedorLocalUi> proveedorLocalUiList) {
        if (proveedorLocalUiList!=null) this.proveedorLocalUiList.clear();
        this.proveedorLocalUiList.addAll(proveedorLocalUiList);
        notifyDataSetChanged();
    }

    public void updateItem(ProveedorLocalUi proveedorLocalUi) {
        int position = proveedorLocalUiList.indexOf(proveedorLocalUi);
        if (position != -1) {
            if(proveedorLocalUiList.get(position).getStatus()==2)
                proveedorLocalUiList.get(position).setStatus(1);
            else
                proveedorLocalUiList.get(position).setStatus(2);
            notifyItemChanged(position);
        }
    }

    public void updateAccionItem(ProveedorLocalUi proveedorLocalUi) {
        int position = proveedorLocalUiList.indexOf(proveedorLocalUi);
        if (position != -1) {
            proveedorLocalUiList.get(position).setAccion(proveedorLocalUi.getAccion());
            //notifyItemChanged(position);
        }
    }

    public void updateMotivoItem(ProveedorLocalUi proveedorLocalUi) {
        int position = proveedorLocalUiList.indexOf(proveedorLocalUi);
        if (position != -1) {
            proveedorLocalUiList.get(position).setRazon(proveedorLocalUi.getRazon());
        }
    }
}
