package com.area51.clase01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("clase01", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("clase01", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    private static final String TAG = "clase01";

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("clase01", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("clase01", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("clase01", "onDestroy");
    }
}
