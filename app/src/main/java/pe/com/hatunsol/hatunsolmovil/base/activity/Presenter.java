package pe.com.hatunsol.hatunsolmovil.base.activity;

import android.content.res.Resources;


import pe.com.hatunsol.hatunsolmovil.R;
import pe.com.hatunsol.hatunsolmovil.base.UseCaseHandler;


public class Presenter extends BasePresenterImpl<View> {

    public Presenter(UseCaseHandler handler, Resources res) {
        super(handler, res);
    }

    @Override
    public void attachView(View view) {
        super.attachView(view);
    }

    @Override
    protected String getTag() {
        return Presenter.class.getSimpleName();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (view != null) {
            view.changeBackground(R.color.colorPrimary);
        }

    }


}
