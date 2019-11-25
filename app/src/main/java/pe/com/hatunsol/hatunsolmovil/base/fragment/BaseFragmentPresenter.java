package pe.com.hatunsol.hatunsolmovil.base.fragment;


import pe.com.hatunsol.hatunsolmovil.base.activity.BasePresenter;
import pe.com.hatunsol.hatunsolmovil.base.activity.BaseView;

public interface BaseFragmentPresenter<T extends BaseView> extends BasePresenter<T> {
    void onAttach();
    void onCreateView();
    void onViewCreated();
    void onActivityCreated();
    void onDestroyView();
    void onDetach();
}
