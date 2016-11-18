package com.zonelian.framework.core.utils;

import java.util.LinkedList;

/**
 * Created by kernel on 2016/11/17.
 * Email: 372786297@qq.com
 */

public class ByteArrayPool {
    private static final int INCRE = 10;

    private LinkedList<byte[]> mBytesBuffer;

    public ByteArrayPool() {
        mBytesBuffer = new LinkedList<>();
    }

    public byte[] get(int size) {
        for(int i = 0, len = mBytesBuffer.size(); i < len; i ++) {
            if(mBytesBuffer.get(i).length >= size) {
                return mBytesBuffer.remove(i);
            }
        }
        int allowSize = INCRE * ((size / INCRE) + (size % INCRE != 0 ? 1 : 0));
        byte[] bytes = new byte[allowSize];
        return bytes;
    }

    public void trunback(byte[] bytes) {
        recycle(bytes);
    }

    private void recycle(byte[] bytes) {
        int size = bytes.length;
        int pos = size / INCRE;
        if(pos > mBytesBuffer.size() / 2) {
            for(int i = mBytesBuffer.size() - 1; i >= 0; i --) {
                if(mBytesBuffer.get(i).length < size) {
                    mBytesBuffer.add(i + 1, bytes);
                    return;
                }
            }
        }else {
            for(int i = 0, len = mBytesBuffer.size(); i < len; i ++) {
                if(mBytesBuffer.get(i).length > size) {
                    mBytesBuffer.add(i, bytes);
                    break;
                }
            }
        }
    }

    public void destory() {
        if(mBytesBuffer != null) {
            mBytesBuffer.clear();
        }
    }
}
