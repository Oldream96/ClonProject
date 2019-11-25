package pe.com.hatunsol.hatunsolmovil.modules.encuestas.data.source.local;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;


import pe.com.hatunsol.hatunsolmovil.modules.encuestas.entities.ProveedorLocalUi;
import pe.com.hatunsol.hatunsolmovil.services.entities.ProveedorLocal;
import pe.com.hatunsol.hatunsolmovil.services.entities.SessionUser;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario_Table;


public class EncuestasLocalDataSource implements IEncuestasLocalDataSource {


    @Override
    public Usuario getUsuario() {
        Usuario usuario = null;
        try {
            SessionUser sessionUser = SessionUser.getCurrentUser();
            usuario = SQLite.select()
                    .from(Usuario.class)
                    .where(Usuario_Table.CodigoUsuario.eq(sessionUser.getUsuarioId()))
                    .querySingle();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }


    @Override
    public List<ProveedorLocalUi> getEstablecimientos() {
        List<ProveedorLocalUi> proveedorLocalUis = new ArrayList<>();

        List<ProveedorLocal> proveedorLocals = SQLite.select()
                .from(ProveedorLocal.class)
                //.where(ProveedorLocal_Table.ProveedorNombre.notEq(""))
                .queryList();
        for (ProveedorLocal proveedorLocal: proveedorLocals){
            ProveedorLocalUi proveedorLocalUi = new ProveedorLocalUi();
            proveedorLocalUi.setNombre(proveedorLocal.getProveedorLocalId()+" "+proveedorLocal.getNombreComercial()+" / "+proveedorLocal.getRUC());
            proveedorLocalUi.setProveedorLocalId(proveedorLocal.getProveedorLocalId());
            proveedorLocalUis.add(proveedorLocalUi);
        }
        return proveedorLocalUis;
    }



}
