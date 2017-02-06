package stephencavallaro.demostephencavallaro;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import stephencavallaro.demostephencavallaro.Adapter.ViewPagerAdapter;
import stephencavallaro.demostephencavallaro.fragment.ContentFragment;
import stephencavallaro.demostephencavallaro.fragment.HistoryFragment;
import stephencavallaro.demostephencavallaro.fragment.LoginFragment;

public class ViewPagerActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    private TabLayout tabLayout;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    //public ViewPagerActivity(TabLayout tabLayout) {
    //    this.tabLayout = tabLayout;
    //}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        initial();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void initial() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        fragmentList.add(new LoginFragment());
        fragmentList.add(new ContentFragment());
        fragmentList.add(new HistoryFragment());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);
        viewPager.setAdapter(viewPagerAdapter);

       tabLayout =(TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}