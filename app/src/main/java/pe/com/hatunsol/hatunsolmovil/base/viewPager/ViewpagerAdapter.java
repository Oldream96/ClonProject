package pe.com.hatunsol.hatunsolmovil.base.viewPager;


import android.util.Log;
import android.util.SparseArray;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewpagerAdapter extends FragmentStatePagerAdapter {
    private static final String TAG = ViewpagerAdapter.class.getSimpleName();
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    private SparseArray<Fragment> registeredFragments = new SparseArray<>();
    public ViewpagerAdapter(FragmentManager fm, int countInitfragment, LifecycleImpl.LifecycleListener lifecycleListener) {
        super(fm);
        if(lifecycleListener != null)fm.registerFragmentLifecycleCallbacks(new LifecycleImpl(countInitfragment,lifecycleListener),true);
    }

    @Override
    public Fragment getItem(int position) {
        Log.d(TAG, "getItem position: " + position);
        // Check if the fragment at this position has been retained by the PagerAdapter
        if (registeredFragments.indexOfKey(position) >= 0) {
            Log.d(TAG, "registeredFragments.indexOfKey(position) >= 0");
            return registeredFragments.get(position);
        }

        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        Log.d(TAG, "addFragment" + title);
        int position = mFragmentList.indexOf(fragment);
        if(position==-1){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
            notifyDataSetChanged();
        }
    }

    public void removeFragment(Fragment fragment, String title) {
        Log.d(TAG, "addFragment" + title);

        if(mFragmentList.remove(fragment)){
            mFragmentTitleList.remove(title);
            notifyDataSetChanged();
        }

    }

    public void removeFragment(Fragment fragment) {
        Log.d(TAG, "addFragment" + fragment.getClass().getSimpleName());
        int position = mFragmentList.indexOf(fragment);
        int positionT = mFragmentTitleList.indexOf("Conyuge");
        Log.d(TAG, "addFragment" + +positionT+" " +mFragmentTitleList.toString());
        if (position!=-1){
            mFragmentList.remove(position);
        }
        if (positionT!=-1){
            mFragmentTitleList.remove(positionT);
            registeredFragments.removeAt(position);
        }
        notifyDataSetChanged();
       // if(mFragmentList.remove(fragment)){

  //      }
        Log.d(TAG, "addFragment" + mFragmentTitleList.toString());

    }


    @Override
    public CharSequence getPageTitle(int position) {
        Log.d(TAG, "getPageTitle position: " + position);
        return mFragmentTitleList.get(position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.d(TAG, "instantiateItem position: " + position);
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Log.d(TAG, "destroyItem position: " + position + ", ResponseParameter: " + object);
        // Check if the fragment at this position has been retained by the PagerAdapter
        if (registeredFragments.indexOfKey(position) >= 0) {
            Log.d(TAG, "destroyItem registeredFragments.indexOfKey");
            registeredFragments.remove(position);
        }

        super.destroyItem(container, position, object);
    }

}
