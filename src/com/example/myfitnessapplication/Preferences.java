package com.example.myfitnessapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences("myprefs", 0);
    }


    public static int getPeso(Context context) {
        return getPrefs(context).getInt("peso", 50);
    }
    
    public static int getAltura(Context context) {
        return getPrefs(context).getInt("altura", 500);
    }

    public static void setPeso(Context context, int value) {
        getPrefs(context).edit().putInt("peso", value).commit();
    }

    public static void setAltura(Context context, int value) {
        getPrefs(context).edit().putInt("altura", value).commit();
    }
}
