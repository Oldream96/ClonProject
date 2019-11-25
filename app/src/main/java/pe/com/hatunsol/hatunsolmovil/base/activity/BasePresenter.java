package pe.com.hatunsol.hatunsolmovil.base.activity;

import android.os.Bundle;


public interface BasePresenter<T extends BaseView> extends pe.com.hatunsol.hatunsolmovil.base.BasePresenter<T> {
    void setExtras(Bundle extras);
}
