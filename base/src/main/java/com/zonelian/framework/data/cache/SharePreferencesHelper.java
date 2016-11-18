package com.zonelian.framework.data.cache;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.support.annotation.Nullable;

import java.util.Map;
import java.util.Set;

/**
 * Created by kernel on 16/9/5.
 * Email: 372786297@qq.com
 */
public class SharePreferencesHelper {
    private SharedPreferences mPreferences;

    public SharePreferencesHelper(Context context) {
        mPreferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    }

    public SharePreferencesHelper(Context context, String fileName) {
        mPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }

    public SharePreferencesHelper(Context context, String fileName, int mode) {
        mPreferences = context.getSharedPreferences(fileName, mode);
    }

    public Editor putString(String key, @Nullable String value) {
        return mPreferences.edit().putString(key, value);
    }

    @TargetApi(11)
    public Editor putStringSet(String key, @Nullable Set<String> values) {
        return mPreferences.edit().putStringSet(key, values);
    }

    public Editor putInt(String key, int value) {
        return mPreferences.edit().putInt(key, value);
    }

    public Editor putLong(String key, long value) {
        return mPreferences.edit().putLong(key, value);
    }

    public Editor putFloat(String key, float value) {
        return mPreferences.edit().putFloat(key, value);
    }

    public Editor putBoolean(String key, boolean value) {
        return mPreferences.edit().putBoolean(key, value);
    }

    public Editor remove(String key) {
        return mPreferences.edit().remove(key);
    }

    public Editor clear() {
        return mPreferences.edit().clear();
    }

    public boolean putStringAndSaveSync(String key, @Nullable String value) {
        return mPreferences.edit().putString(key, value).commit();
    }

    @TargetApi(11)
    public boolean putStringSetAndSaveSync(String key, @Nullable Set<String> values) {
        return mPreferences.edit().putStringSet(key, values).commit();
    }

    public boolean putIntAndSaveSync(String key, int value) {
        return mPreferences.edit().putInt(key, value).commit();
    }

    public boolean putLongAndSaveSync(String key, long value) {
        return mPreferences.edit().putLong(key, value).commit();
    }

    public boolean putFloatAndSaveSync(String key, float value) {
        return mPreferences.edit().putFloat(key, value).commit();
    }

    public boolean putBooleanAndSaveSync(String key, boolean value) {
        return mPreferences.edit().putBoolean(key, value).commit();
    }

    public boolean removeAndSaveSync(String key) {
        return mPreferences.edit().remove(key).commit();
    }

    public boolean clearAndSaveSync() {
        return mPreferences.edit().clear().commit();
    }

    public void putStringAndSaveAsync(String key, @Nullable String value) {
        mPreferences.edit().putString(key, value).apply();
    }

    @TargetApi(11)
    public void putStringSetAndSaveAsync(String key, @Nullable Set<String> values) {
        mPreferences.edit().putStringSet(key, values).apply();
    }

    public void putIntAndSaveAsync(String key, int value) {
        mPreferences.edit().putInt(key, value).apply();
    }

    public void putLongAndSaveAsync(String key, long value) {
        mPreferences.edit().putLong(key, value).apply();
    }

    public void putFloatAndSaveAsync(String key, float value) {
        mPreferences.edit().putFloat(key, value).apply();
    }

    public void putBooleanAndSaveAsync(String key, boolean value) {
        mPreferences.edit().putBoolean(key, value).apply();
    }

    public void removeAndSaveAsync(String key) {
        mPreferences.edit().remove(key).apply();
    }

    public void clearAndSaveAsync() {
        mPreferences.edit().clear().apply();
    }


    Map<String, ?> getAll() {
        return mPreferences.getAll();
    }

    @Nullable
    String getString(String key, @Nullable String defValue) {
        return mPreferences.getString(key, defValue);
    }

    @TargetApi(11)
    @Nullable
    Set<String> getStringSet(String key, @Nullable Set<String> defValues) {
        return mPreferences.getStringSet(key, defValues);
    }

    int getInt(String key, int defValue) {
        return mPreferences.getInt(key, defValue);
    }

    long getLong(String key, long defValue) {
        return mPreferences.getLong(key, defValue);
    }

    float getFloat(String key, float defValue) {
        return mPreferences.getFloat(key, defValue);
    }

    boolean getBoolean(String key, boolean defValue) {
        return mPreferences.getBoolean(key, defValue);
    }

    boolean contains(String key) {
        return mPreferences.contains(key);
    }

    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        mPreferences.registerOnSharedPreferenceChangeListener(listener);
    }
    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        mPreferences.unregisterOnSharedPreferenceChangeListener(listener);
    }
}
