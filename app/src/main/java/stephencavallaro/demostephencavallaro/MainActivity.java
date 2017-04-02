package stephencavallaro.demostephencavallaro;

import butterknife.OnClick;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import stephencavallaro.demostephencavallaro.Book;
import stephencavallaro.demostephencavallaro.util.UtilLog;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import stephencavallaro.demostephencavallaro.dialog.FinalQuiz;



public class MainActivity extends BaseActivity implements View.OnTouchListener{
    private ImageButton bt1;
    private ImageButton bt3;
    private ImageButton bt4;
    private GestureDetector mGestureDetector;
    int count = 0;

    @BindView(R.id.frame)
    FrameLayout frame;

    @BindView(R.id.MyActivities)
    LinearLayout linear;

    @OnClick(R.id.bt2)
    public void button2Click(){
Intent intent = new Intent(this, DialogActivity.class);
startActivityForResult(intent, 2);
//toActivity(DialogActivity.class);
    }

    @OnClick(R.id.main_timer_bt)
    public void buttonTimerClick(){
Intent intent = new Intent(this, TimerActivity.class);
startActivity(intent);
//toActivity(DialogActivity.class);
    }

    @OnClick(R.id.main_animation_bt)
    public void buttonAnimationClick(){
Intent intent = new Intent(this, AnimationActivity.class);
startActivity(intent);
//toActivity(DialogActivity.class);
    }

    @OnClick(R.id.viewPagerActivity)
    public void viewPagerActivity(){
Intent intent = new Intent(this,ViewPagerActivity.class);
intent.putExtra("key","value");
Bundle bundle = new Bundle();
bundle.putInt("Integer", 12345);
Book book = new Book();
book.setName("Android");
book.setAuthor("Stephen");
bundle.putSerializable("book", book);
intent.putExtras(bundle);
startActivityForResult(intent, 1);
    }

    @OnClick(R.id.dialogActivity)
    public void dialogActivity(){
toActivity(DialogActivity.class);
    }

    @OnClick(R.id.listViewActivity)
    public void listViewActivity(){
toActivity(ListViewActivity.class);
    }

    @OnClick(R.id.animationActivity)
    public void animationActivity(){
toActivity(AnimationActivity.class);
    }

    @OnClick(R.id.animatorActivity)
    public void animatorActivity(){
toActivity(AnimatorActivity.class);
    }

    @OnClick(R.id.timerActivity)
    public void timerActivity(){
toActivity(TimerActivity.class);
    }

    @OnClick(R.id.ActA_Btt)
    public void aActivity(){
toActivity(ActivityA.class);
    }

    @OnClick(R.id.ActB_Btt)
    public void bActivity(){
toActivity(ActivityB.class);
    }

    @OnClick(R.id.ActC_Btt)
    public void cActivity(){
toActivity(ActivityC.class);
    }
    @OnClick(R.id.ActD_Btt)
    public void dActivity(){
toActivity(ActivityD.class);
    }


    @OnClick(R.id.toggle_anim)
    public void move(){
if(count==0){
    ObjectAnimator animator = ObjectAnimator.ofFloat(linear, "translationX", 0, 950, 950,950,950); //translationY
    animator.setDuration(1000);
    animator.start();
    count ++;
}
else{
    ObjectAnimator animator = ObjectAnimator.ofFloat(linear, "translationX", 950, 0, 0,0,0); //translationY
    animator.setDuration(1000);
    animator.start();
    count = 0;
}
    }

    @OnClick(R.id.FinalQuiz)
    public void FinalQuiz(){
final FinalQuiz dialog = new FinalQuiz(this, new FinalQuiz.ICustomDialogEventListener() {
    @Override
    public void onClickListener() {
Intent intent = new Intent(MainActivity.this, DialogActivity.class);
startActivity(intent);
    }

    @Override
    public void onClick2Listener() {
Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
startActivity(intent);
    }

    @Override
    public void onClickCancel() {
Intent intent = new Intent(MainActivity.this,ViewPagerActivity.class);
intent.putExtra("key","value");
Bundle bundle = new Bundle();
bundle.putInt("Integer", 12345);
Book book = new Book();
book.setName("App Name");
book.setAuthor("Stephen");
bundle.putSerializable("book", book);
intent.putExtras(bundle);
startActivityForResult(intent, 1);
    }
});
dialog.show();
    }

    @OnClick(R.id.animator_bt)
    public void buttonAnimatorClick(){
Intent intent = new Intent(this, AnimatorActivity.class);
startActivity(intent);
//toActivity(DialogActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
initialView();
initialListener();
ButterKnife.bind(this);
mGestureDetector=new GestureDetector(this,new SimpleGestureListener());
frame.setOnTouchListener(this);
    }

    private void initialView(){
bt1 = (ImageButton) findViewById(R.id.bt1);
bt3 = (ImageButton) findViewById(R.id.bt3);
bt4 = (ImageButton) findViewById(R.id.bt4);

    }
    private void initialListener(){
bt1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
Toast.makeText(v.getContext(), "Button1 was clicked", Toast.LENGTH_LONG).show();
Intent intent = new Intent(v.getContext(),ViewPagerActivity.class);
intent.putExtra("key","value");
Bundle bundle = new Bundle();
bundle.putInt("Integer", 12345);
Book book = new Book();
book.setName("BOOKNAME");
book.setAuthor("Stephen");
bundle.putSerializable("book", book);
intent.putExtras(bundle);
startActivityForResult(intent, 1);
    }
});

bt3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

Intent intent = new Intent(v.getContext(),ListViewActivity.class);
startActivityForResult(intent, 3);
    }
});
bt4.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

Intent intent = new Intent(v.getContext(),ActivityA.class);
startActivity(intent);
    }
});

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
super.onActivityResult(requestCode, resultCode, data);
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
    default:
}
    }


    public void onClick(View v){
toastLong("Button2 was clicked");
UtilLog.logD("testD","Toast");
    }

    @Override
    protected void onStart() {
toastShort("onStart");
super.onStart();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
return mGestureDetector.onTouchEvent(event);
    }


    private class SimpleGestureListener extends GestureDetector.SimpleOnGestureListener{
public boolean onDown(MotionEvent e){
    UtilLog.logD("MyGesture","onDown");
//    toastShort("onDown");
    return true;
}
public void onShowPress(MotionEvent e){
    UtilLog.logD("MyGesture","onShowPress");
    //toastShort("onShowPress");
}
public void onLongPress(MotionEvent e){
    UtilLog.logD("MyGesture","onLongPress");
    //toastShort("onLongPress");
}
public boolean onSingleTapUp(MotionEvent e){
    UtilLog.logD("MyGesture","onSingleTapUp");
    //toastShort("onSingleTapUp");
    return true;
}
public boolean onSingleTapConfirmed(MotionEvent e)
{
    UtilLog.logD("MyGesture","onSingleTapConfirmed");
//    toastShort("onSingleTapConfirmed");
    if(count == 1){
ObjectAnimator animator = ObjectAnimator.ofFloat(linear, "translationX", 950, 0, 0,0,0); //translationY
animator.setDuration(1000);
animator.start();
count = 0;
    }
    return true;
}
public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,float distanceY){
    UtilLog.logD("MyGesture","onScroll:"+(e2.getX()-e1.getX())+" "+distanceX);
    //toastShort("onScroll");
    return true;
}
public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
//    toastShort("onFling");

    if(count == 0){
ObjectAnimator animator = ObjectAnimator.ofFloat(linear, "translationX", 0, 950, 950,950,950); //translationY
animator.setDuration(1000);
animator.start();

count ++;
    }
    else{
ObjectAnimator animator = ObjectAnimator.ofFloat(linear, "translationX", 950, 0, 0,0,0); //translationY
animator.setDuration(1000);
animator.start();
count = 0;
    }
    return true;
}
public boolean onDoubleTap(MotionEvent e){
    //toastShort("onDoubleTap");
    return true;
}
public boolean onDoubleTapEvent(MotionEvent e){
    //toastShort("onDoubleTapEvent");
    return true;
}

    }
}