package stephencavallaro.demostephencavallaro;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import stephencavallaro.demostephencavallaro.dialog.CustomDialog;

public class LaunchActivity extends BaseActivity {

    private ImageButton bt1;
    private ImageButton bt3;
    private ImageButton b5x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

       // ButterKnife.bind(this);
    }

    @OnClick(R.id.b1x)
    public void button1xClick() {
        //Intent intent = new Intent(this, DialogActivity.class);
        //startActivityForResult(intent, 2);
    }

    @OnClick(R.id.b2x)
    public void button2xClick() {
        //Intent intent = new Intent(this, LaunchActivity.class);
        //startActivityForResult(intent, 4);
    }

    @OnClick(R.id.b3x)
    public void button3xClick() {
        //Intent intent = new Intent(this, DialogActivity.class);
        //startActivityForResult(intent, 2);
    }

    @OnClick(R.id.b4x)
    public void button4xClick() {
        //Intent intent = new Intent(this, LaunchActivity.class);
        //startActivityForResult(intent, 4);
    }

    }



