package com.mrasif.apps.supernotes.utils;

import java.util.prefs.Preferences;

/**
 * @author Asif Mohammad Mollah
 * @version 1.0
 */
public class SharedPreferences {
    private static Preferences prefs = Preferences.userNodeForPackage(SharedPreferences.class);

    /**
     * @param key property
     * @param value value
     */
    public static void putString(String key, String value){
        prefs.put(key,value);
    }

    /**
     * @param key property
     * @param value value
     */
    public static void putBoolean(String key, boolean value){
        prefs.putBoolean(key,value);
    }

    /**
     * @param key property
     * @param value value
     */
    public static void putInteger(String key, Integer value){
        prefs.putInt(key,value);
    }

    /**
     * @param key property
     * @param value value
     */
    public static void putDouble(String key, Double value){
        prefs.putDouble(key,value);
    }

    /**
     * @param key property
     * @param value value
     */
    public static void putByteArray(String key, byte[] value){
        prefs.putByteArray(key,value);
    }

    /**
     * @param key property
     * @param value value
     */
    public static void putFloat(String key, float value){
        prefs.putFloat(key,value);
    }

    /**
     * @param key property
     * @param value value
     */
    public static void putLong(String key, long value){
        prefs.putLong(key,value);
    }

    /**
     * @param key property
     * @return String
     */
    public static String getString(String key){
        return prefs.get(key,null);
    }

    /**
     * @param key property
     * @return boolean
     */
    public static boolean getBoolean(String key){
        return prefs.getBoolean(key,false);
    }

    /**
     * @param key property
     * @return Integer
     */
    public static Integer getInteger(String key){
        return prefs.getInt(key,0);
    }

    /**
     * @param key property
     * @return double
     */
    public static double getDouble(String key){
        return prefs.getDouble(key,0.0);
    }

    /**
     * @param key property
     * @return byte[]
     */
    public static byte[] getByteArray(String key){
        return prefs.getByteArray(key,new byte[]{});
    }

    /**
     * @param key property
     * @return float
     */
    public static float getFloat(String key){
        return prefs.getFloat(key,0.0f);
    }

    /**
     * @param key property
     * @return long
     */
    public static long getLong(String key){
        return prefs.getLong(key,0);
    }

    /**
     * @param key property
     */
    public static void remove(String key){
        prefs.remove(key);
    }

}
