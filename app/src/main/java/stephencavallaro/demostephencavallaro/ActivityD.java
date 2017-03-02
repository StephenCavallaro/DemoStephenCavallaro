package stephencavallaro.demostephencavallaro;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;



public class ActivityD extends BaseActivity{

    private Button btt1;
    private Button btt2;
    private Button btt3;
    private Button btt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
        initialView();
        initialListener();
    }

    private void initialView(){
        btt1 = (Button) findViewById(R.id.btt1);
        btt2 = (Button) findViewById(R.id.btt2);
        btt3 = (Button) findViewById(R.id.btt3);
        btt4 = (Button) findViewById(R.id.btt4);
    }

    private void initialListener(){
        btt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(ActivityA.class);
            }
        });

        btt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(ActivityB.class);
            }
        });

        btt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(ActivityC.class);
            }
        });

        btt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(ActivityD.class);
            }
        });
    }
}