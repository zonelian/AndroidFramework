package com.zonelian.framework.base.okhttp;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

/**
 * Created by kernel on 16/6/20.
 * Email: 372786297@qq.com
 */
public class RequestBodyProgress {
    private ProgressCallback mProgressCallback;

    /** Returns a new request body that transmits the content of {@code file}. */
    public  RequestBody create(final MediaType contentType, final File file) {
        if (file == null) throw new NullPointerException("content == null");

        return new RequestBody() {
            @Override public MediaType contentType() {
                return contentType;
            }

            @Override public long contentLength() {
                return file.length();
            }

            @Override public void writeTo(BufferedSink sink) throws IOException {
                Source source = null;
                try {
                    source = Okio.source(file);
                    if (source == null) throw new IllegalArgumentException("source == null");
                    long totalBytesRead = 0;
                    for (long readCount; (readCount = source.read(sink.buffer(), 8192)) != -1; ) {
                        totalBytesRead += readCount;
                        if(mProgressCallback != null) {
                            mProgressCallback.onProgress(100, (int)(totalBytesRead * 100 / contentLength()));
                        }
                    }
                } finally {
                    Util.closeQuietly(source);
                }
            }
        };
    }

    public void setProgressCallback(ProgressCallback progressCallback) {
        this.mProgressCallback = progressCallback;
    }

    public interface ProgressCallback {
        public void onProgress(int max, int progress);
    }

}
