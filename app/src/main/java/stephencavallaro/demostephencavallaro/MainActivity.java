package stephencavallaro.demostephencavallaro;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import stephencavallaro.demostephencavallaro.Book;
import stephencavallaro.demostephencavallaro.util.UtilLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements View.OnTouchListener, View.OnClickListener {

    //resources: stores stuff like layout file, etc.


    private ImageButton bt1;
    private ImageButton bt3;
    private ImageButton bt4;
    private GestureDetector mGestureDetector;

    @BindView(R.id.main_fl)
    FrameLayout fl;

//    @OnClick (R.id.custom_bt)
//    public void toCustomDialog() {
//
//        Bundle bundle = new Bundle();
//        //Intent intent = new Intent(this, CustomDialog.class);
//       /* intent.putExtra("Message","Double");
//        intent.putExtras(bundle);*/
//        //startActivityForResult(intent, 2);
//
//    }

    @OnClick(R.id.animator_bt)
    public void toAnimator() { toActivity(AnimatorActivity.class);}

    @OnClick(R.id.main_anim_bt)
    public void toAnimation() {
        toActivity(AnimationActivity.class);
    }

    @OnClick(R.id.bt4)
    public void toActivityA() {
        toActivity(ActivityA.class);
    }

    @OnClick(R.id.main_timer_bt)
    public void toTimer(){
        toActivity(TimerActivity.class);
    }

    @OnClick(R.id.bt2)
    public void button2Click() {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, DialogActivity.class);
        intent.putExtra("Message","Double");
        intent.putExtras(bundle);
        startActivityForResult(intent, 2);
    }
//onCreate will be invoked by a system when the acitivty wants to show on the screen. Everytime activity is shown, the method will be
    //the first one called by the system

    //In the onCreate() method, you perform basic application startup logic that should happen only once for the entire life of the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialListener();
        ButterKnife.bind(this);
        mGestureDetector = new GestureDetector(this, new simpleGestureListener());
        fl.setOnClickListener(this);
    }

    //The onStart call makes the activity visible to the user, as the app prepares for the activity to enter the foregroud and become interactive
    //the onStart method completely very quickly and, as with the Created state, the activity does not stay resident in the Started state


    @Override
    protected void onStart() {
        super.onStart();
        toastShort("onStart");
    }


    private void initialView() {

        bt1 = (ImageButton) findViewById(R.id.bt1);
        bt3 = (ImageButton) findViewById(R.id.bt3);
        bt4 = (ImageButton) findViewById(R.id.bt4);

    }



    private void initialListener()  {
//bt1.setOnClickListener(new View.OnClickListener() {
        //@Override
        //public void onClick (View v) {

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Toast.makeText(view.getContext(), "Button2 was clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(view.getContext(),ViewPagerActivity.class);
                intent.putExtra("key", "value");
                Bundle bundle = new Bundle();
                bundle.putInt("Integer", 12345);
                Book book = new Book();
                book.setName("Android");
                book.setAuthor("Viral");
                bundle.putSerializable("book", book);
                intent.putExtras(bundle);
                startActivityForResult(intent,1); //can pass infomration through intent

            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ListViewActivity.class);
                startActivityForResult(intent, 3);
/*
                Intent intent = new Intent(view.getContext(), ListViewActivity.class);
                startActivity(intent);
*/
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //toActivity(ListViewActivity.class);
                Intent intent = new Intent(v.getContext(),ActivityA.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                String message = data.getStringExtra("message");
                toastShort(message);
                break;
            case 2:
                toastShort("Dialog");
                break;
            case 3:
                toastShort("Custom");
                break;
            default:
        }
    }

    public void onClick(View view) {
        //Toast.makeText(this,"listView was clicked at position: ",Toast.LENGTH_LONG).show();
        toastLong("Button2 was clicked");
        //key = your class name
        UtilLog.logD("testD", "Toast");
        //Log.e("testE", "Toast");
        //Log.i("testI", "Toast");
        //Log.v("testI", "Toast");
        //Log.w("testI", "Toast");

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    private class simpleGestureListener extends
            GestureDetector.SimpleOnGestureListener {


        /* onDown->onShowPress->onLongPress*/
        public boolean onDown(MotionEvent e) {
            UtilLog.logD("MyGesture", "onDown");
            toastShort("onDown");
            return true;
        }

        public void onShowPress(MotionEvent e) {
            UtilLog.logD("MyGesture", "onShowPress");
            toastShort("onShowPress");
        }

        public void onLongPress(MotionEvent e) {
            UtilLog.logD("MyGesture", "onLongPress");
            toastShort("onLongPress");
        }

        public boolean onSingleTapUp(MotionEvent e) {
            UtilLog.logD("MyGesture", "onSingleTapUp");
            toastShort("onSingleTapUp");
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent e) {
            UtilLog.logD("MyGesture", "onSingleTapConfirmed");
            toastShort("onSingleTapConfirmed");
            return true;
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            UtilLog.logD("MyGesture", "onScroll: " + (e2.getX() - e1.getX()) + " " + distanceX);
            toastShort("onScroll");
            return true;
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            UtilLog.logD("MyGesture", "onFling");
            toastShort("onFling");
            return true;
        }

        public boolean onDoubleTap(MotionEvent e) {
            UtilLog.logD("MyGesture", "onDoubleTap");
            toastShort("onDoubleTap");
            return true;
        }
    }
}
