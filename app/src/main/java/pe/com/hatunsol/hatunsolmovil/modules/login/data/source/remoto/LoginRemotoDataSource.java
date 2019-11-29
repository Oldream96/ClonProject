package pe.com.hatunsol.hatunsolmovil.modules.login.data.source.remoto;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import pe.com.hatunsol.hatunsolmovil.api.service.ApiUtils;
import pe.com.hatunsol.hatunsolmovil.api.service.Services;
import pe.com.hatunsol.hatunsolmovil.modules.login.entities.UsuarioUi;
import pe.com.hatunsol.hatunsolmovil.services.entities.BE_Constantes;
import pe.com.hatunsol.hatunsolmovil.services.entities.Parametro;
import pe.com.hatunsol.hatunsolmovil.services.entities.Persona;
import pe.com.hatunsol.hatunsolmovil.services.entities.ProveedorLocal;
import pe.com.hatunsol.hatunsolmovil.services.entities.ResponseProveedor;
import pe.com.hatunsol.hatunsolmovil.services.entities.Ubigeo;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;
import pe.com.hatunsol.hatunsolmovil.util.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRemotoDataSource implements RemotoDataSourceInterface {

    private Services services;
    public LoginRemotoDataSource() {
    }

    @Override
    public void loginUser(String user,final String password, Callback<Usuario> callback) {
        services= ApiUtils.getService();
        Call<Usuario> call = services.obtenerUsuario(user);
        call.enqueue(new retrofit2.Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response==null){
                    callback.load(false, null);
                }else {
                    Usuario usuario = response.body();
                    if (usuario==null){
                        callback.load(false, null);
                    }else {
                        if (usuario.getCodigoUsuario()!=0){
                            try {
                                if(usuario.getCargoId() == BE_Constantes.TipoUsuarios.ADO ||
                                        usuario.getCargoId() == BE_Constantes.TipoUsuarios.JefeZonal ||
                                        usuario.getCargoId() == BE_Constantes.TipoUsuarios.JefedeMarca ||
                                        usuario.getCargoId() == BE_Constantes.TipoUsuarios.Supervisor){
                                    if(usuario.getDNI().isEmpty()){
                                        usuario.setTipoId(Usuario.DNI_NULL);
                                        callback.load(true,usuario);
                                    }else {
                                    if (usuario.getPassword().equals(Utils.EncriptarPassword(password))){
                                        usuario.setTipoId(Usuario.ACCESS);
                                        callback.load(true, usuario);
                                    }else {
                                        usuario.setTipoId(Usuario.PASSWORD_FAIL);
                                        callback.load(true, usuario);
                                    }
                                }
                                }else {
                                    if (usuario.getPassword().equals(Utils.EncriptarPassword(password))){
                                        usuario.setTipoId(Usuario.ACCESS);
                                        callback.load(true, usuario);
                                    }else {
                                        usuario.setTipoId(Usuario.PASSWORD_FAIL);
                                        callback.load(true, usuario);
                                    }
                                }

                            } catch (NoSuchAlgorithmException e) {
                                e.printStackTrace();
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }else {
                            usuario.setTipoId(Usuario.USER_FAIL);
                            callback.load(true, usuario);
                        }


                    }
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {

            }
        });
    }

    @Override
    public void sincronizeDataUbigeo(Callback<List<Ubigeo>> listCallback) {
        services= ApiUtils.getService();
        Call<List<Ubigeo>> call = services.obtenerUbigeo();
        call.enqueue(new retrofit2.Callback<List<Ubigeo>>() {
            @Override
            public void onResponse(Call<List<Ubigeo>> call, Response<List<Ubigeo>> response) {
                if (response!=null) {
                    listCallback.load(true, response.body());
                }else {
                    listCallback.load(false, null);
                }
            }

            @Override
            public void onFailure(Call<List<Ubigeo>> call, Throwable t) {

            }
        });
    }

    @Override
    public void sincronizarDataParametro(Callback<List<Parametro>> listCallback) {
        services= ApiUtils.getService();
        Call<List<Parametro>> callPersona = services.obtenerParametro("37,38,77,84,85");
        callPersona.enqueue(new retrofit2.Callback<List<Parametro>>() {
            @Override
            public void onResponse(Call<List<Parametro>> call, Response<List<Parametro>> response) {
                if (response!=null){
                    listCallback.load(true, response.body());
                }else {
                    listCallback.load(false, null);
                }
            }

            @Override
            public void onFailure(Call<List<Parametro>> call, Throwable t) {

            }
        });
    }

//    @Override
//    public void sincronizarDataProvedorLocal(int cargoId, int usuarioId, Callback<List<ProveedorLocal>> callback) {
//        services=ApiUtils.getService();
//
//        Call<ResponseProveedor> call = services.obtenerProveedorLocal( cargoId, usuarioId);
//        call.enqueue(new retrofit2.Callback<ResponseProveedor>() {
//            @Override
//            public void onResponse(Call<ResponseProveedor> call, Response<ResponseProveedor> response) {
//                if (response!=null){
//                    ResponseProveedor responseProveedor = response.body();
//                    callback.load(true, responseProveedor.getLocalesResult());
//                }else{
//                    callback.load(false, null);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseProveedor> call, Throwable t) {
//
//            }
//        });
//    }

    @Override
    public void sincronizarDataPersonas(Usuario usuario, Callback<List<Persona>> callback) {
//        services = ApiUtils.getService();
//        Call<List<Persona>> call = services.obtenerPersona(usuario.getIdSupervisor(), "",usuario.getCargoId(),
//                usuario.getCodigoUsuario(), String.valueOf(2), 0, true, "", usuario.getZonaId(), usuario.getLocalId());
//        call.enqueue(new retrofit2.Callback<List<Persona>>() {
//            @Override
//            public void onResponse(Call<List<Persona>> call, Response<List<Persona>> response) {
//                if (response!=null){
//                    List<Persona> personaList = response.body();
//                    callback.load(true, personaList);
//                }else{
//                    callback.load(false, null);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Persona>> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });
    }


}
