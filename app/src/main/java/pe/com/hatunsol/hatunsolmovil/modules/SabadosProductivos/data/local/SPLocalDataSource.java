package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.local;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import pe.com.hatunsol.hatunsolmovil.services.entities.SessionUser;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario_Table;


public class SPLocalDataSource implements SPLocalDataSourceInterface {
    @Override
    public Usuario getUsuario() {
        Usuario usuario=null;
        try{
            SessionUser sessionUser = SessionUser.getCurrentUser();
            usuario = SQLite.select()
                    .from(Usuario.class)
                    .where(Usuario_Table.CodigoUsuario.eq(sessionUser.getUsuarioId()))
                    .querySingle();
        }catch (Exception e){
            e.printStackTrace();
        }
        return usuario;
    }
}
