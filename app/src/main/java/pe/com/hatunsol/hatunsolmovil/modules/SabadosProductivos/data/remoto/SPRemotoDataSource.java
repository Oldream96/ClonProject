package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.remoto;

import android.util.Log;

import androidx.lifecycle.ProcessLifecycleOwner;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import pe.com.hatunsol.hatunsolmovil.api.service.ApiUtils;
import pe.com.hatunsol.hatunsolmovil.api.service.Services;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.entities.ProveedorLocalUi;
import pe.com.hatunsol.hatunsolmovil.services.entities.Persona;
import pe.com.hatunsol.hatunsolmovil.services.entities.ProveedorLocal;

import retrofit2.Call;
import retrofit2.Response;

public class SPRemotoDataSource implements SPRemotoDataSourceInterface {

    private Services services;


    @Override
    public void getCompromisos(int idsupervisor, int mes, int anio, Callback<List<ProveedorLocalUi>> listCallback) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();

        String fecha = dateFormat.format(date);
        services = ApiUtils.getService();

        Call<List<Persona>> call = services.obtenerCompromisos(idsupervisor, mes, anio);
        call.enqueue(new retrofit2.Callback<List<Persona>>() {
                         @Override
                         public void onResponse(Call<List<Persona>> call, Response<List<Persona>> response) {
                             if (response.body() != null) {
                                 List<ProveedorLocalUi> proveedorLocalUiList = new ArrayList<>();
                                 List<Persona> proveedorLocals = response.body();

                                 for (Persona proveedorLocal : proveedorLocals) {
                                     ProveedorLocalUi proveedorLocalUi = new ProveedorLocalUi();
                                     proveedorLocalUi.setNombreProveedor(proveedorLocal.getNombre());
                                     proveedorLocalUi.setFecha(proveedorLocal.getFechaCreacion());
                                     proveedorLocalUi.setUsuario(proveedorLocal.getSupervisor());
                                     proveedorLocalUiList.add(proveedorLocalUi);

                                 }

                                 listCallback.load(true, proveedorLocalUiList);
                             } else {
                                 listCallback.load(false, null);
                             }
                         }

                         @Override
                         public void onFailure(Call<List<Persona>> call, Throwable t) {

                         }
                     }


        );

    }

    @Override
    public void GetFerreteriasCompromiso(int idsupervisor, String fecha, String nombre, Callback<List<ProveedorLocalUi>> lista) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();

        String fecha2 = dateFormat.format(date);

        services = ApiUtils.getService();

        Call<List<Persona>> call = services.obtenerFerreteriaCompromisos(idsupervisor, fecha, nombre);
        call.enqueue(new retrofit2.Callback<List<Persona>>() {


            @Override
            public void onResponse(Call<List<Persona>> call, Response<List<Persona>> response) {
                if (response != null) {
                    List<ProveedorLocalUi> proveedorLocalUiList = new ArrayList<>();
                    List<Persona> personaList = response.body();
                    for (Persona persona : personaList) {
                        ProveedorLocalUi proveedorLocalUi = new ProveedorLocalUi();
                        proveedorLocalUi.setProveedorLocalId(persona.getExpedienteCreditoId());
                        proveedorLocalUi.setNombreComercial(persona.getNombre());
                        proveedorLocalUi.setFecha(persona.getFechaCreacion());
                        proveedorLocalUi.setRUC(persona.getDocumentoNum());
                        proveedorLocalUi.setRazon(persona.getRazon());
                        proveedorLocalUi.setAccion(persona.getAccion());
                        proveedorLocalUi.setTipo(1);
                        proveedorLocalUi.setStatus(persona.getSync_status());
                        proveedorLocalUiList.add(proveedorLocalUi);

                    }

                    lista.load(true, proveedorLocalUiList);

                } else {
                    lista.load(false, null);

                }

            }

            @Override
            public void onFailure(Call<List<Persona>> call, Throwable t) {
                lista.load(false, null);
            }
        });

    }

    @Override
    public void GetDerivadosCompromiso(int idsupervisor, String fecha, String nombre, Callback<List<ProveedorLocalUi>> lista) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();

        String fecha2 = dateFormat.format(date);

        services = ApiUtils.getService();

        Call<List<Persona>> call = services.obtenerDerivadosCompromisos(idsupervisor, fecha, nombre);
        call.enqueue(new retrofit2.Callback<List<Persona>>() {


            @Override
            public void onResponse(Call<List<Persona>> call, Response<List<Persona>> response) {
                if (response != null) {
                    List<ProveedorLocalUi> proveedorLocalUiList = new ArrayList<>();
                    List<Persona> personaList = response.body();
                    for (Persona persona : personaList) {
                        ProveedorLocalUi proveedorLocalUi = new ProveedorLocalUi();
                        proveedorLocalUi.setProveedorLocalId(persona.getExpedienteCreditoId());
                        proveedorLocalUi.setNombreComercial(persona.getNombre());
                        proveedorLocalUi.setFecha(persona.getFechaCreacion());
                        proveedorLocalUi.setRUC(persona.getDocumentoNum());
                        proveedorLocalUi.setRazon(persona.getRazon());
                        proveedorLocalUi.setAccion(persona.getAccion());
                        proveedorLocalUi.setEstado(persona.getEstadoProcesoNombre());
                        proveedorLocalUi.setTipo(2);
                        proveedorLocalUi.setStatus(persona.getSync_status());
                        proveedorLocalUiList.add(proveedorLocalUi);

                    }

                    lista.load(true, proveedorLocalUiList);

                } else {
                    lista.load(false, null);

                }

            }

            @Override
            public void onFailure(Call<List<Persona>> call, Throwable t) {
                lista.load(false, null);
            }
        });

    }

    @Override
    public void GetActivadosCompromiso(int idsupervisor, String fecha, String nombre, Callback<List<ProveedorLocalUi>> lista) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();

        String fecha2 = dateFormat.format(date);

        services = ApiUtils.getService();

        Call<List<Persona>> call = services.obtenerActivadosCompromisos(idsupervisor, fecha, nombre);
        call.enqueue(new retrofit2.Callback<List<Persona>>() {


            @Override
            public void onResponse(Call<List<Persona>> call, Response<List<Persona>> response) {
                if (response != null) {
                    List<ProveedorLocalUi> proveedorLocalUiList = new ArrayList<>();
                    List<Persona> personaList = response.body();
                    for (Persona persona : personaList) {
                        ProveedorLocalUi proveedorLocalUi = new ProveedorLocalUi();
                        proveedorLocalUi.setProveedorLocalId(persona.getExpedienteCreditoId());
                        proveedorLocalUi.setNombreComercial(persona.getNombre());
                        proveedorLocalUi.setFecha(persona.getFechaCreacion());
                        proveedorLocalUi.setRUC(persona.getDocumentoNum());
                        proveedorLocalUi.setRazon(persona.getRazon());
                        proveedorLocalUi.setAccion(persona.getAccion());
                        proveedorLocalUi.setEstado(persona.getEstadoProcesoNombre());
                        proveedorLocalUi.setTipo(3);
                        proveedorLocalUi.setStatus(persona.getSync_status());
                        proveedorLocalUiList.add(proveedorLocalUi);

                    }

                    lista.load(true, proveedorLocalUiList);

                } else {
                    lista.load(false, null);

                }

            }

            @Override
            public void onFailure(Call<List<Persona>> call, Throwable t) {
                lista.load(false, null);
            }
        });

    }

    @Override
    public void onSaveDetalleCompromiso(List<Persona> DetalleCompromiso, Integer tipoCompromiso, Callback<Integer> callback) {
        Gson gson = new Gson();
        String listaFerreteria = gson.toJson(DetalleCompromiso);
        services = ApiUtils.getService();
        Call<Integer> call = null;
        if (tipoCompromiso == 1) {
            call = services.onSaveFerreteriaCompromiso(DetalleCompromiso);
        } else if (tipoCompromiso == 2){
            call = services.onSaveDerivadosCompromiso(DetalleCompromiso);
        } else if(tipoCompromiso == 3){
            call = services.onSaveActivadosCompromiso(DetalleCompromiso);
        }
            String calls = call.request().toString();
        Log.d("call", calls);
        call.enqueue(new retrofit2.Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response != null) {
                    Integer personaList = response.body();
                    callback.load(true, personaList);
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                callback.load(false, null);

            }
        });
    }

    @Override
    public void onSaveDerivadosCompromiso(List<Persona> DerivadosList, Callback<Integer> callback) {
        Gson gson = new Gson();
        String listaderivados = gson.toJson(DerivadosList);
        services = ApiUtils.getService();
        Call<Integer> call = services.onSaveDerivadosCompromiso(DerivadosList);
        call.enqueue(new retrofit2.Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response != null) {
                    response.body();
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {

            }
        });
    }

    @Override
    public void onSaveActivadosCompromiso(List<Persona> ActivadosList, Callback<Integer> callback) {
        Gson gson = new Gson();
        String listaactivados = gson.toJson(ActivadosList);
        services = ApiUtils.getService();
        Call<Integer> call = services.onSaveActivadosCompromiso(ActivadosList);
        call.enqueue(new retrofit2.Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response != null) {
                    response.body();
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {

            }
        });

    }
}
