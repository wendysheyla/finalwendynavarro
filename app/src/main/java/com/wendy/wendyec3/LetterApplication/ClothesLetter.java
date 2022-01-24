package com.wendy.wendyec3.LetterApplication;

import android.app.Application;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

public class ClothesLetter extends Application {

    private static ClothesLetter instance;
    private static Context appContext;

    public static  ClothesLetter getInstance(){
        return instance;
    }

    public static Context getAppContext(){
        return appContext;
    }

    public void setAppContext(Context mAppContext){
        this.appContext= mAppContext;
    }
    @Override
    public void onCreate(){
        super.onCreate();
        instance=this;
        this.setAppContext(getApplicationContext());
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }


}
