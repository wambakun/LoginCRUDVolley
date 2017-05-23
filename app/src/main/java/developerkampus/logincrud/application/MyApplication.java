package developerkampus.logincrud.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by Wamba on 23/05/2017.
 */

public class MyApplication extends Application {
    private static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }

    public static MyApplication getInstance() {
        return myApplication;
    }

    public static Context getContext() {
        return myApplication.getApplicationContext();
    }
}
