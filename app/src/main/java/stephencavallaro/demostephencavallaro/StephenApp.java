package stephencavallaro.demostephencavallaro;

import android.app.Application;

import stephencavallaro.demostephencavallaro.util.UtilLog;

/**
 * Created by Stephen on 2/6/2017.
 */

public class StephenApp extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        UtilLog.setDebug(true);

    }


}
