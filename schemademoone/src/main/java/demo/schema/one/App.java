package demo.schema.one;

import android.app.Application;
import android.util.Log;

/**
 * Created by kernel on 2017/9/2.
 * Email: 372786297@qq.com
 */

public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("SchemeDemoOne", "Application onCreate");
    }
}
