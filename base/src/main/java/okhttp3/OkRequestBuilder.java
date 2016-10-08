package okhttp3;

/**
 * Created by kernel on 16/9/18.
 * Email: 372786297@qq.com
 */
public class OkRequestBuilder extends Request.Builder{
    public static final int PRIORITY_FOREGROUND = 12345;
    public static final int PRIORITY_BACKGROUND = 12346;

    public Request.Builder setPriority(int priority) {
        super.get().tag(priority);
        return get();
    }

    @Deprecated
    @Override
    public Request.Builder tag(Object tag) {
        return super.tag(tag);
    }
}
