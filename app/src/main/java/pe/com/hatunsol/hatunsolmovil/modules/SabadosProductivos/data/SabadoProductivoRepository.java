package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.local.SPLocalDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.local.SPLocalDataSourceInterface;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.remoto.SPRemotoDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.remoto.SPRemotoDataSourceInterface;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.entities.ProveedorLocalUi;
import pe.com.hatunsol.hatunsolmovil.services.entities.Persona;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public class SabadoProductivoRepository implements SPRemotoDataSourceInterface, SPLocalDataSourceInterface {

    private SPRemotoDataSource spRemotoDataSource;
    private SPLocalDataSource spLocalDataSource;

    public SabadoProductivoRepository(SPRemotoDataSource spRemotoDataSource, SPLocalDataSource spLocalDataSource){
        this.spRemotoDataSource = spRemotoDataSource;
        this.spLocalDataSource = spLocalDataSource;
    }

    @Override
    public void getCompromisos(int idsupervisor, String nombreusuario, SPRemotoDataSourceInterface.Callback<List<ProveedorLocalUi>> callback) {
        spRemotoDataSource.getCompromisos(idsupervisor,nombreusuario,callback);
    }

    @Override
    public void GetFerreteriasCompromiso(int idsupervisor, String fecha, String nombre, SPRemotoDataSourceInterface.Callback<List<ProveedorLocalUi>> callback) {
        spRemotoDataSource.GetFerreteriasCompromiso(idsupervisor,fecha,nombre,callback);
    }

    @Override
    public void GetDerivadosCompromiso(int idsupervisor, String fecha, String nombre, SPRemotoDataSourceInterface.Callback<List<ProveedorLocalUi>> callback) {
        spRemotoDataSource.GetDerivadosCompromiso(idsupervisor,fecha,nombre,callback);
    }

    @Override
    public void GetActivadosCompromiso(int idsupervisor, String fecha, String nombre, SPRemotoDataSourceInterface.Callback<List<ProveedorLocalUi>> callback) {
        spRemotoDataSource.GetActivadosCompromiso(idsupervisor,fecha,nombre,callback);
    }

    @Override
    public void onSaveDetalleCompromiso(List<Persona> detallecompromisoList,Integer tipoCompromiso, SPRemotoDataSourceInterface.Callback<Integer> callback) {
        spRemotoDataSource.onSaveDetalleCompromiso(detallecompromisoList,tipoCompromiso,callback);
    }

    @Override
    public void onSaveDerivadosCompromiso(List<Persona> ferreteriaList, SPRemotoDataSourceInterface.Callback<Integer> callback) {
        spRemotoDataSource.onSaveDerivadosCompromiso(ferreteriaList,callback);
    }

    @Override
    public void onSaveActivadosCompromiso(List<Persona> ferreteriaList, SPRemotoDataSourceInterface.Callback<Integer> callback) {
        spRemotoDataSource.onSaveActivadosCompromiso(ferreteriaList,callback);
    }

    @Override
    public Usuario getUsuario() {
        return spLocalDataSource.getUsuario();
    }
}
