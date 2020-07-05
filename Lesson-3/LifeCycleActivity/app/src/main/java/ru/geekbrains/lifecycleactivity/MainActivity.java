package ru.geekbrains.lifecycleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "[LifeCycleActivity]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String instanceState;
        if (savedInstanceState == null){
            instanceState = "Первый запуск!";
        }
        else{
            instanceState = "Повторный запуск!";
        }
        makeToast(instanceState + " - onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        makeToast("onStart()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);
        makeToast("Повторный запуск!! - onRestoreInstanceState()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        makeToast("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        makeToast("onPause()");
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        makeToast("onSaveInstanceState()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        makeToast("onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        makeToast("onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        makeToast("onDestroy()");
    }

    private void makeToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        Log.d(TAG, message);
    }
}