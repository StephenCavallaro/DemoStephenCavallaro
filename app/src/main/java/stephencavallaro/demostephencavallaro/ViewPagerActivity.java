package stephencavallaro.demostephencavallaro;

import android.content.Intent;
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
import stephencavallaro.demostephencavallaro.util.UtilLog;

public class ViewPagerActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    private TabLayout tabLayout;

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        Intent intent =getIntent();
        Bundle bundle = intent.getExtras();
        String message = intent.getStringExtra("key");
        int fakeNumber = bundle.getInt("fake",0);
        int Number = bundle.getInt("Integer",0);
        Book book = (Book) bundle.getSerializable("book");

        UtilLog.logD("ViewPagerActivity, value is: ", message);
        UtilLog.logD("ViewPagerActivity, number is: ", "" +Number);
        UtilLog.logD("ViewPagerActivity, fake number is: ", String.valueOf(fakeNumber));

        UtilLog.logD("ViewPagerActivity, book author is: ",book.getAuthor());
        UtilLog.logD("ViewPagerActivity, book name is: ",book.getName());

        initial();

        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("message","ViePager");
        setResult(RESULT_OK, intent);
        super.onBackPressed();

    }
}