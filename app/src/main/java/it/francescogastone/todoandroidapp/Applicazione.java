package it.francescogastone.todoandroidapp;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.francescogastone.todoandroidapp.controllo.ControlloPrincipale;
import it.francescogastone.todoandroidapp.modello.Modello;

public class Applicazione extends Application {

    public static final String TAG = Applicazione.class.getSimpleName();

    private static Applicazione singleton = new Applicazione();

    public static Applicazione getInstance() {
        return singleton;
    }

    public void onCreate(){
        super.onCreate();
        singleton = (Applicazione) getApplicationContext();
        singleton.registerActivityLifecycleCallbacks(new GestoreAttivita());
    }

    Activity currentActivity = null;
    Modello modello = new Modello();
    ControlloPrincipale controlloPrincipale = new ControlloPrincipale();

    public Activity getCurrentActivity() {
        return currentActivity;
    }

    public Modello getModello() {
        return modello;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    private class GestoreAttivita implements ActivityLifecycleCallbacks {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            Log.i(TAG, "onActivityCreated: " + activity);

            List<String> listaToDo = getArray();
            Applicazione.getInstance().getModello().putBean("LISTA", listaToDo);
        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            //Log.i(TAG, "onActivityDestroyed: " + activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {
            //Log.d(TAG, "onActivityStarted: " + activity);
        }

        @Override
        public void onActivityResumed(Activity activity) {
            Log.d(TAG, "currentActivity initialized: " + activity);
            currentActivity = activity;
        }

        @Override
        public void onActivityPaused(Activity activity) {
            //Log.d(TAG, "onActivityPaused: " + activity);
        }

        @Override
        public void onActivityStopped(Activity activity) {
            if (currentActivity == activity) {
                Log.d(TAG, "currentActivity stopped: " + activity);
                currentActivity = null;
                saveArray((List<String>)Applicazione.getInstance().getModello().getBean("LISTA"));
            }
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            //Log.d(TAG, "onActivitySaveInstanceState: " + activity);
        }
    }

    public boolean saveArray(List<String> lista){
        SharedPreferences sp = Applicazione.getInstance().getSharedPreferences("Pref Lista", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        Set<String> set = new HashSet<>();
        set.addAll(lista);
        editor.putStringSet("list", set);
        return editor.commit();
    }

    public ArrayList<String> getArray() {
        SharedPreferences sp = this.getSharedPreferences("Pref Lista", Activity.MODE_PRIVATE);

        Set<String> set = sp.getStringSet("list", new HashSet<String>());

        return new ArrayList<String>(set);
    }
}
