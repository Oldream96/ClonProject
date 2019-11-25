package pe.com.hatunsol.hatunsolmovil.services.entities;

import androidx.annotation.NonNull;

public class Oficina {
    
    public boolean Activo;
    public int AgenciaId;
    public int BancoId;
    public String CodTopaz;
    public String CorreoA;
    public String CorreoCC;
    public String Direccion;
    public String FechaActua;
    public String FechaCrea;
    public String Foto;
    public int IdOficina;
    public String Latitud;
    public String Longitud;
    public String Nombre;
    public String NombreAgencia;
    public String NombreBanco;
    public String Telefono;
    public int UserIdActua;
    public int UserIdCrea;

    public Oficina() {
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean activo) {
        Activo = activo;
    }

    public int getAgenciaId() {
        return AgenciaId;
    }

    public void setAgenciaId(int agenciaId) {
        AgenciaId = agenciaId;
    }

    public int getBancoId() {
        return BancoId;
    }

    public void setBancoId(int bancoId) {
        BancoId = bancoId;
    }

    public String getCodTopaz() {
        return CodTopaz;
    }

    public void setCodTopaz(String codTopaz) {
        CodTopaz = codTopaz;
    }

    public String getCorreoA() {
        return CorreoA;
    }

    public void setCorreoA(String correoA) {
        CorreoA = correoA;
    }

    public String getCorreoCC() {
        return CorreoCC;
    }

    public void setCorreoCC(String correoCC) {
        CorreoCC = correoCC;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getFechaActua() {
        return FechaActua;
    }

    public void setFechaActua(String fechaActua) {
        FechaActua = fechaActua;
    }

    public String getFechaCrea() {
        return FechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        FechaCrea = fechaCrea;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public int getIdOficina() {
        return IdOficina;
    }

    public void setIdOficina(int idOficina) {
        IdOficina = idOficina;
    }

    public String getLatitud() {
        return Latitud;
    }

    public void setLatitud(String latitud) {
        Latitud = latitud;
    }

    public String getLongitud() {
        return Longitud;
    }

    public void setLongitud(String longitud) {
        Longitud = longitud;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNombreAgencia() {
        return NombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        NombreAgencia = nombreAgencia;
    }

    public String getNombreBanco() {
        return NombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        NombreBanco = nombreBanco;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public int getUserIdActua() {
        return UserIdActua;
    }

    public void setUserIdActua(int userIdActua) {
        UserIdActua = userIdActua;
    }

    public int getUserIdCrea() {
        return UserIdCrea;
    }

    public void setUserIdCrea(int userIdCrea) {
        UserIdCrea = userIdCrea;
    }

    @NonNull
    @Override
    public String toString() {
        return Nombre;
    }
}
