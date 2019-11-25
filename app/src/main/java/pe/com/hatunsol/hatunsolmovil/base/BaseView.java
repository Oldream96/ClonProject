package pe.com.hatunsol.hatunsolmovil.base;


public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
