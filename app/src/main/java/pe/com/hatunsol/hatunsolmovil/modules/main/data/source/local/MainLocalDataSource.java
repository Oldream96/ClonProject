package pe.com.hatunsol.hatunsolmovil.modules.main.data.source.local;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import pe.com.hatunsol.hatunsolmovil.services.entities.Persona;
import pe.com.hatunsol.hatunsolmovil.services.entities.Persona_Table;
import pe.com.hatunsol.hatunsolmovil.services.entities.ProveedorLocal;
import pe.com.hatunsol.hatunsolmovil.services.entities.ProveedorLocal_Table;
import pe.com.hatunsol.hatunsolmovil.services.entities.SessionUser;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario_Table;


public class MainLocalDataSource implements IMainLocalDataSource{


    public MainLocalDataSource() {
    }

    @Override
    public Usuario getUser() {
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
    public Boolean DeleteUser() {
        try {
            SessionUser sessionUser = SessionUser.getCurrentUser();
            //se cambia el estado del usuario a 0//cuando se registra otro usuario state = 1
            sessionUser.setState(false);
            //registrar cambio
            sessionUser.save();
            //delete elimina todas las filas de una tabla
            SQLite.delete()
                    .from(Usuario.class)
                    .query();
            SQLite.delete()
                    .from(ProveedorLocal.class)
                    .query();
            SQLite.delete()
                    .from(Persona.class)
                    .query();
            SQLite.delete()
                    .from(SessionUser.class)
                    .query();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return  false;
        }


    }
}
