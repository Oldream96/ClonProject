package pe.com.hatunsol.hatunsolmovil.base.activity;

import androidx.annotation.ColorRes;


public interface View extends BaseView<Presenter> {
    void changeBackground(@ColorRes int color);
}
