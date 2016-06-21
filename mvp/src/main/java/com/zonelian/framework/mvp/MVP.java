package com.zonelian.framework.mvp;

/**
 * Model-View-Presenter模型的架构
 * Created by kernel on 16/6/13.
 * Email: 372786297@qq.com
 */
public interface MVP {

    /**
     * 处理业务逻辑以及数据相关
     * @param <V>
     */
    public static interface MVPPresenter<V extends MVPView> {
        public void setView(V view);
        public V getView();
    }

    /**
     * 处理UI相关
     */
    public static interface MVPView {

    }

    /**
     * 持有数据
     */
    public static interface MVPRepository<K, V> {

        public void put(K key, V data);
        public V get(K key);
    }
}
