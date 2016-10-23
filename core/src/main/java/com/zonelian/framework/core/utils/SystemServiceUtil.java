package com.zonelian.framework.core.utils;

import android.accounts.AccountManager;
import android.app.AlarmManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.Service;
import android.app.WallpaperManager;
import android.app.usage.NetworkStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.session.MediaSessionManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.BatteryManager;
import android.os.PowerManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by kernel on 2016/10/12.
 * Email: 372786297@qq.com
 */

public class SystemServiceUtil {

    public static WifiManager getWiFiManager(Context context) {
        return (WifiManager)context.getSystemService(Service.WIFI_SERVICE);
    }

    public static ConnectivityManager getConnectivityManager(Context context) {
        return (ConnectivityManager)context.getSystemService(Service.CONNECTIVITY_SERVICE);
    }

    public static ClipboardManager getClipboardManager(Context context) {
        return (ClipboardManager)context.getSystemService(Service.CLIPBOARD_SERVICE);
    }

    public static NotificationManager getNotificationManager(Context context) {
        return (NotificationManager)context.getSystemService(Service.NOTIFICATION_SERVICE);
    }

    public static AlarmManager getAlarmManager(Context context) {
        return (AlarmManager)context.getSystemService(Service.ALARM_SERVICE);
    }

    public static SensorManager getSensorManager(Context context) {
        return (SensorManager)context.getSystemService(Service.SENSOR_SERVICE);
    }

    public static StorageManager getStorageManager(Context context) {
        return (StorageManager)context.getSystemService(Service.STORAGE_SERVICE);
    }

    public static WallpaperManager getWallpagerManager(Context context) {
        return WallpaperManager.getInstance(context);
    }

    public static Vibrator getVibrator(Context context) {
        return (Vibrator)context.getSystemService(Service.VIBRATOR_SERVICE);
    }

    public static PowerManager getPowerManager(Context context) {
        return (PowerManager)context.getSystemService(Service.POWER_SERVICE);
    }

    public static WindowManager getWindowManager(Context context) {
        return (WindowManager)context.getSystemService(Service.WINDOW_SERVICE);
    }

    public static LayoutInflater getLayoutInflater(Context context) {
        return (LayoutInflater)context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
    }

    public static AccountManager getAccountManager(Context context) {
        return (AccountManager)context.getSystemService(Service.ACCOUNT_SERVICE);
    }

    public static AccessibilityManager getAccessibilityManager(Context context) {
        return (AccessibilityManager)context.getSystemService(Service.ACCESSIBILITY_SERVICE);
    }

    public static CaptioningManager getCaptioningManager(Context context) {
        return (CaptioningManager)context.getSystemService(Service.CAPTIONING_SERVICE);
    }

    public static KeyguardManager getKeyguardManager(Context context) {
        return (KeyguardManager)context.getSystemService(Service.KEYGUARD_SERVICE);
    }

    public static LocationManager getLocationManager(Context context) {
        return (LocationManager)context.getSystemService(Service.LOCATION_SERVICE);
    }

    public static SearchManager getSearchManager(Context context) {
        return (SearchManager)context.getSystemService(Service.SEARCH_SERVICE);
    }

    public static NetworkStatsManager getNetworkStatsManager(Context context) {
        return (NetworkStatsManager)context.getSystemService(Service.NETWORK_STATS_SERVICE);
    }

    public static WifiP2pManager getWiFiP2pManager(Context context) {
        return (WifiP2pManager)context.getSystemService(Service.WIFI_P2P_SERVICE);
    }

    public static AudioManager getAudioManager(Context context) {
        return (AudioManager)context.getSystemService(Service.AUDIO_SERVICE);
    }

    public static FingerprintManager getFingerprintManager(Context context) {
        return (FingerprintManager)context.getSystemService(Service.FINGERPRINT_SERVICE);
    }

    public static MediaRouter getMediaRouter(Context context) {
        return (MediaRouter)context.getSystemService(Service.MEDIA_ROUTER_SERVICE);
    }

    public static MediaSessionManager getMediaSessionManager(Context context) {
        return (MediaSessionManager)context.getSystemService(Service.MEDIA_SESSION_SERVICE);
    }

    public static TelephonyManager getTelephonyManager(Context context) {
        return (TelephonyManager)context.getSystemService(Service.TELEPHONY_SERVICE);
    }

    public static SubscriptionManager getSubscriptionManager(Context context) {
        return (SubscriptionManager)context.getSystemService(Service.TELEPHONY_SUBSCRIPTION_SERVICE);
    }

    public static TelecomManager getTelecomManager(Context context) {
        return (TelecomManager)context.getSystemService(Service.TELECOM_SERVICE);
    }

    public static InputMethodManager getInputMethodManager(Context context) {
        return (InputMethodManager)context.getSystemService(Service.INPUT_METHOD_SERVICE);
    }

    public static AppWidgetManager getAppWidgetManager(Context context) {
        return (AppWidgetManager)context.getSystemService(Service.APPWIDGET_SERVICE);
    }

    public static DownloadManager getDownloadManager(Context context) {
        return (DownloadManager)context.getSystemService(Service.DOWNLOAD_SERVICE);
    }

    public static BatteryManager getBatteryManager(Context context) {
        return (BatteryManager)context.getSystemService(Service.BATTERY_SERVICE);
    }

    public static BluetoothManager getBluetoothManager(Context context) {
        return (BluetoothManager)context.getSystemService(Service.BLUETOOTH_SERVICE);
    }

    public static UsbManager getUsbManager(Context context) {
        return (UsbManager)context.getSystemService(Service.USB_SERVICE);
    }

    public static DisplayManager getDisplayManager(Context context) {
        return (DisplayManager)context.getSystemService(Service.DISPLAY_SERVICE);
    }

    public static CameraManager getCameraManager(Context context) {
        return (CameraManager)context.getSystemService(Service.CAMERA_SERVICE);
    }
}

