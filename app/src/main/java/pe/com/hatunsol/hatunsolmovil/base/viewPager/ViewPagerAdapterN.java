package pe.com.hatunsol.hatunsolmovil.base.viewPager;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapterN extends PagerAdapter {

    private final List<View> views = new ArrayList<View>();

    @Override
    public int getItemPosition(Object object) {
        int index = views.indexOf(object);
        if(index == -1)
            return POSITION_NONE;
        else
            return index;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = views.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    @Override
    public int getCount() {
        return views.size();
    }

    public int addView(View view){
        return addView(view, views.size());
    }


    public int addView(View view, int position){
        views.add(position, view);
        return position;
    }

    public int removeView(ViewPager pager, View view){
        return removeView(pager, views.indexOf(view));
    }

    public int removeView(ViewPager pager, int position){
        pager.setAdapter(null);
        views.remove(position);
        pager.setAdapter(this);
        return position;
    }

    public View getView(int position){
        return views.get(position);
    }
}
