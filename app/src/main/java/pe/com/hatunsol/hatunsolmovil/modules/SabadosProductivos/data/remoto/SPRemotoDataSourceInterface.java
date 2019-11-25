package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.remoto;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.entities.ProveedorLocalUi;
import pe.com.hatunsol.hatunsolmovil.services.entities.Persona;
import pe.com.hatunsol.hatunsolmovil.services.entities.ProveedorLocal;

public interface SPRemotoDataSourceInterface {
    interface Callback<T>{
        void load(boolean state, T item);
    }

    void getCompromisos(int idsupervisor, int mes ,int anio, Callback<List<ProveedorLocalUi>> callback);
    void GetFerreteriasCompromiso(int idsupervisor,String fecha, String nombre,Callback<List<ProveedorLocalUi>> callback);
    void GetDerivadosCompromiso(int idsupervisor,String fecha, String nombre,Callback<List<ProveedorLocalUi>> callback);
    void GetActivadosCompromiso(int idsupervisor,String fecha, String nombre,Callback<List<ProveedorLocalUi>> callback);
    void onSaveDetalleCompromiso(List<Persona> detallecompromisoList,Integer tipoCompromiso,Callback<Integer> callback);
    void onSaveDerivadosCompromiso(List<Persona> ferreteriaList,Callback<Integer> callback);
    void onSaveActivadosCompromiso(List<Persona> ferreteriaList,Callback<Integer> callback);
}
