package stephencavallaro.demostephencavallaro;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.os.Handler;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import stephencavallaro.demostephencavallaro.Adapter.ViewPagerAdapter;
import stephencavallaro.demostephencavallaro.dialog.CustomDialog;
import stephencavallaro.demostephencavallaro.fragment.ContentFragment;
import stephencavallaro.demostephencavallaro.fragment.HistoryFragment;
import stephencavallaro.demostephencavallaro.fragment.LoginFragment;
import stephencavallaro.demostephencavallaro.util.UtilLog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.common.api.GoogleApiClient;

public class dialog2Activity extends BaseActivity {
//
//    public static String RESULT_CONTRYCODE = "countrycode";
//    public String[] countrynames, countrycodes;
//    private TypedArray imgs;
//    private List<Country> countryList;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        ArrayAdapter<Country> adapter = new CountryListArrayAdapter(this, countryList);
//        setListAdapter(adapter);
//        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Country c = countryList.get(position);
//                Intent returnIntent = new Intent();
//                returnIntent.putExtra(RESULT_CONTRYCODE, c.getCode());
//                setResult(RESULT_OK, returnIntent);
//                finish();
//            }
//        });
//    }

//    public class Country {
//        private String name;
//        private String code;
//        private Drawable flag;
//        public Country(String name, String code, Drawable flag){
//            this.name = name;
//            this.code = code;
//            this.flag = flag;
//        }
//        public String getName() {
//            return name;
//        }
//        public Drawable getFlag() {
//            return flag;
//        }
//        public String getCode() {
//            return code;
//        }
//    }

}