package com.oji.weq.logshower;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.oji.weq.loglib.LogShower;
import com.oji.weq.loglib.Lolly;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button mShowWindowBtn = findViewById(R.id.show_window);
        Button mHideWindowBtn = findViewById(R.id.hide_window);
        Button mSaveLog = findViewById(R.id.save_log);
        LogShower.INSTANCE.init(this,new String[]{"dadadad"});
        mShowWindowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    if (Settings.canDrawOverlays(MainActivity.this)) {
//                        Lolly.Companion.showLolly(MainActivity.this, new String[]{"dadadad"});
//                    }
//                } else {
//                    Lolly.Companion.showLolly(MainActivity.this, new String[]{"dadadad"});
//                }

            }
        });

        mHideWindowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lolly.Companion.hideLolly(MainActivity.this);
            }
        });

        mSaveLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Lolly.Companion.saveLog(MainActivity.this);
            }
        });

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i("dadadad","this is Lolly");
                Log.d("dadadad","this is Lolly");
                Log.v("dadadad","this is Lolly");
                Log.e("dadadad","this is Lolly");
                Log.w("dadadad","this is Lolly");
                handler.postDelayed(this, 2000);
            }
        }, 2000);

    }
}
