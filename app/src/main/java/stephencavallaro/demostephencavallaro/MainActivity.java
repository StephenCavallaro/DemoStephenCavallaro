package stephencavallaro.demostephencavallaro;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import stephencavallaro.demostephencavallaro.util.UtilLog;


public class MainActivity extends BaseActivity {

    private ImageButton bt1;
    private ImageButton bt3;
    private ImageButton bt5;

    @OnClick(R.id.main_timer_bt)
    public void toTimer(){
        toActivity(TimerActivity.class);
    }


    @OnClick(R.id.bt2)
    public void button2Click() {
        Intent intent = new Intent(this, DialogActivity.class);
        startActivityForResult(intent, 2);
    }



    @OnClick(R.id.bt5)
    public void button5Click() {
        Intent intent = new Intent(this, ActivityA.class);
        startActivityForResult(intent, 4);
    }

//    @OnClick(R.id.b5x)
//    public void button5Click() {
//        Intent intent = new Intent(this, LaunchActivity.class);
//        startActivityForResult(intent, 4);
//    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialListener();
        ButterKnife.bind(this);
    }


    private void initialView(){
        bt1 = (ImageButton) findViewById(R.id.bt1);
        bt3 = (ImageButton) findViewById(R.id.bt3);
        bt5 = (ImageButton) findViewById(R.id.bt5);
    }

    private void initialListener() {
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Button1 Was Clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(v.getContext(), ViewPagerActivity.class);
                intent.putExtra("key", "value");
                Bundle bundle = new Bundle();
                bundle.putInt("Integer", 12345);
                Book book = new Book();
                book.setName("android");
                book.setAuthor("stephen");
                bundle.putSerializable("book", book);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);

            }
            });

//        @Override
//                protected void onStart(){
//            toastShort("On Start");
//        }

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ListViewActivity.class);
                startActivityForResult(intent, 3);
                //Intent intent = new Intent(v.getContext(),ListViewActivity.class);
                //startActivity(intent);
            }
        });
    }

//    bt5.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Intent intent = new Intent(v.getContext(),ActivityA.class);
//            startActivity(intent);
//
//        }
//    });
//}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode, data);
        switch (requestCode){
            case 1:
                String message = data.getStringExtra("message");
                toastShort(message);
                break;
            case 2:
                toastShort("Dialog");
                break;
            case 3:
                toastShort("ListView");
                break;
            case 4:
                toastShort("LaunchExample");
                break;
            default:
        }
    }

    public void onClick(View v) {
        //Toast.makeText(this,"Button2 was clicked",Toast.LENGTH_LONG).show();
        //Log.d("testD","Toast");
        toastLong("Button2 was clicked");
        UtilLog.logD("testD", "Toast");
        //build additional logs for debugs: verbose, info, warn, error, insert
        //final project: base class and utilLog - can just copy these classes to new project


    }
}
