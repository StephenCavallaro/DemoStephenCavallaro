package stephencavallaro.demostephencavallaro.Adapter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import stephencavallaro.demostephencavallaro.R;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragmentList;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setContent(ArrayList<Fragment> fragmentList) {
        this.fragmentList = fragmentList;
    }
    @Override
    public Fragment getItem(int position){
        return fragmentList.get(position);
}
    @Override
    public int getCount() {
        return fragmentList.size();
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        super.destroyItem(container,position,object);}

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        return super.instantiateItem(container, position);
    }
    @Override
            public CharSequence getPageTitle(int position) {
        return fragmentList.get(position).getClass().getName();
    }


}