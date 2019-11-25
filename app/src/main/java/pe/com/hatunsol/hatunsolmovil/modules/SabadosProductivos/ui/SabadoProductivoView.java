package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.ui;

import java.util.List;

import pe.com.hatunsol.hatunsolmovil.base.activity.BaseView;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.entities.ProveedorLocalUi;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.presenter.SabadoProductivoPresenter;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;

public interface SabadoProductivoView extends BaseView<SabadoProductivoPresenter> {

    void ShowCompromisos (List<ProveedorLocalUi> proveedorLocalUiList);

    void hideProgresbar();

    void showProgressbar();

    void showUsuario(Usuario usuario);

    void swiftCharge();

    void onSwiftFinish();

    void setFocusMenu();

}
