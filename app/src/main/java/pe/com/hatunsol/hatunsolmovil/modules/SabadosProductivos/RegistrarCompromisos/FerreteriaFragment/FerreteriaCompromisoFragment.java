package pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.RegistrarCompromisos.FerreteriaFragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import pe.com.hatunsol.hatunsolmovil.R;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseHandler;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseThreadPoolScheduler;
import pe.com.hatunsol.hatunsolmovil.base.fragment.BaseFragment;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.adapter.CompromisoAdapter;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.SabadoProductivoRepository;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.local.SPLocalDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.data.remoto.SPRemotoDataSource;
import pe.com.hatunsol.hatunsolmovil.modules.SabadosProductivos.domain.GetFerreteriasCompromiso;

public class FerreteriaCompromisoFragment extends BaseFragment<FerreteriaCompromisoView,FerreteriaCompromisoPresenter,FerreteriaCompromisoListener> implements FerreteriaCompromisoView {

    @BindView(R.id.rvFerreteriasCompromiso)
    RecyclerView rvferreterias;

    public Dialog dialog;
    CompromisoAdapter adapter;


    public static FerreteriaCompromisoFragment NewInstance () {
        FerreteriaCompromisoFragment ferreteriaCompromisoFragment = new FerreteriaCompromisoFragment();
        return  ferreteriaCompromisoFragment;
    }

    @Override
    protected String getLogTag() {
        return FerreteriaCompromisoFragment.class.getSimpleName();
    }

    @Override
    protected FerreteriaCompromisoPresenter getPresenter() {
        SabadoProductivoRepository sabadoProductivoRepository = new SabadoProductivoRepository(new SPRemotoDataSource(), new SPLocalDataSource());
        presenter = new FerreteriaCompromisoPresenterImpl(
                new UseCaseHandler(new UseCaseThreadPoolScheduler()),getResources(),
                new GetFerreteriasCompromiso(sabadoProductivoRepository)
        );

        return null;
    }

    @Override
    protected FerreteriaCompromisoView getBaseView() {
        return this;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupAdapter();
    }

    private void setupAdapter() {

    }

    @Override
    protected View inflateView(LayoutInflater inflater, ViewGroup container) {
        return null;
    }

    @Override
    protected ViewGroup getRootLayout() {
        return null;
    }

    @Override
    protected ProgressBar getProgressBar() {
        return null;
    }
}
