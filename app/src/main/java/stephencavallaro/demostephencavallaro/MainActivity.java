package stephencavallaro.demostephencavallaro;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.OnClick;
import stephencavallaro.demostephencavallaro.util.UtilLog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.database.Cursor;
import android.provider.ContactsContract;


public class MainActivity extends BaseActivity implements View.OnTouchListener{
//impliments as many times as you want
    private ImageButton bt1;
    private ImageButton bt3;
    private ImageButton bt5;
    private Button da2;
    private GestureDetector mGestureDetector;
    AlertDialog actions;
    private static final int DIALOG_YES_NO_MESSAGE = 1;
    private static final int DIALOG_YES_NO_LONG_MESSAGE = 2;
    private static final int DIALOG_LIST = 3;
    private static final int DIALOG_PROGRESS = 4;
    private static final int DIALOG_SINGLE_CHOICE = 5;
    private static final int DIALOG_MULTIPLE_CHOICE = 6;
    private static final int DIALOG_TEXT_ENTRY = 7;
    private static final int DIALOG_MULTIPLE_CHOICE_CURSOR = 8;
    private static final int DIALOG_YES_NO_ULTRA_LONG_MESSAGE = 9;
    private static final int DIALOG_YES_NO_OLD_SCHOOL_MESSAGE = 10;
    private static final int DIALOG_YES_NO_HOLO_LIGHT_MESSAGE = 11;

    private static final int MAX_PROGRESS = 100;

    private ProgressDialog mProgressDialog;
    private int mProgress;
    private Handler mProgressHandler;


    @OnClick(R.id.main_timer_bt)
    public void toTimer(){
        toActivity(TimerActivity.class);
    }



    @OnClick(R.id.main_animator_bt)
    public void toAnimator(){
        toActivity(AnimatorActivity.class);
    }


    @OnClick(R.id.bt2)
    public void button2Click() {
        Intent intent = new Intent(this, DialogActivity.class);
        startActivityForResult(intent, 2);


    }



//    @OnClick(R.id.b5x)
//    public void button5Click() {
//        Intent intent = new Intent(this, LaunchActivity.class);
//        startActivityForResult(intent, 4);
//    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        setTitle("Activity");
//        Button button = new Button(this);
//        button.setText("Click for Options");
//        button.setOnClickListener(buttonListener);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialListener();
       // dialog2View();
        ButterKnife.bind(this);

            showDialog(DIALOG_SINGLE_CHOICE);
            mProgressHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    if (mProgress >= MAX_PROGRESS) {
                        mProgressDialog.dismiss();
                    } else {
                        mProgress++;
                        mProgressDialog.incrementProgressBy(1);
                        mProgressHandler.sendEmptyMessageDelayed(0, 100);
                    }
                }
            };

//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Choose an Option");
//        String[] options = { "A", "B", "C" };
//        builder.setItems(options, actionListener);
//
//        builder.setNegativeButton("Cancel", null);
//        actions = builder.create();
//
//        setContentView(button);
//
//
//
   }
//
//    DialogInterface.OnClickListener actionListener = new DialogInterface.OnClickListener() {
//        @Override
//        public void onClick(DialogInterface dialog, int which) {
//            switch (which) {
//                case 0: // Delete
//
//                    break;
//                case 1: // Copy
//                    break;
//                case 2: // Edit
//                    break;
//                default:
//                    break;
//            }
//        }
//    };
//
//    View.OnClickListener buttonListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            actions.show();
//        }
//    };


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

    @Override
    public boolean onTouch(View v, MotionEvent event){

        return mGestureDetector.onTouchEvent(event);
    }
    private class simpleGestureListener {

        public boolean onDown(MotionEvent e){

            UtilLog.logD("mygesture", "ondown");
            toastShort("ondown");
            return false;
        }
        public boolean onShowPress(MotionEvent e){

            UtilLog.logD("mygesture", "onshowpress");
            toastShort("onshowpress");
            return false;
        }
        public boolean onLongPress(MotionEvent e){

            UtilLog.logD("mygesture", "onlongpress");
            toastShort("onlongpress");
            return false;
        }
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
            toastShort("onfling");
            return false;
        }
        public boolean onDoubleTap(MotionEvent e){
            toastShort("ondoubletap");
            return false;
        }
        public boolean onDoubleTapEvent(MotionEvent e){
            toastShort("ondoubletapevent");
            return false;
        }
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


    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOG_SINGLE_CHOICE:
                return new AlertDialog.Builder(MainActivity.this)
                        .setIconAttribute(android.R.attr.alertDialogIcon)
                        .setTitle("R.string.alert_dialog_single_choice")
                        .setSingleChoiceItems(new String[]{""}, 0, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                            }
                        })
                        .setPositiveButton("R.string.alert_dialog_ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                            }
                        })
                        .setNegativeButton("R.string.alert_dialog_cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                            }
                        })
                        .create();
        }
        return null;
    }


}
