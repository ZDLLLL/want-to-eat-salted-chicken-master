package zjc.healthmanage;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

public class MyApplication extends Application {

    private static Context context;//上下文环境变量，用于多个活动之间的变量共享
    @Override
    public void onCreate() {
        super.onCreate();
       // AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        context=getApplicationContext();
    }
    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        MyApplication.context = context;
    }
}
