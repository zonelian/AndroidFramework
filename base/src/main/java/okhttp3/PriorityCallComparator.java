package okhttp3;

import android.util.Log;

import java.util.Comparator;

/**
 * Created by kernel on 16/9/18.
 * Email: 372786297@qq.com
 */
@Deprecated
public class PriorityCallComparator <T> implements Comparator<T> {

    @Override
    public int compare(T lhs, T rhs) {
        if(lhs instanceof RealCall.AsyncCall && rhs instanceof RealCall.AsyncCall) {
            int lp = (Integer) ((RealCall.AsyncCall)lhs).request().tag();
            int rp = (Integer) ((RealCall.AsyncCall)rhs).request().tag();
            Log.d("wuzhimu", "left priority:" + lp);
            Log.d("wuzhimu", "right priority:" + rp);
            return rp - lp;
        }
        return 0;
    }
}
