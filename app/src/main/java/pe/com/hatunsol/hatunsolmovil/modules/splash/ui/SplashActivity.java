package pe.com.hatunsol.hatunsolmovil.modules.splash.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

import pe.com.hatunsol.hatunsolmovil.R;
import pe.com.hatunsol.hatunsolmovil.base.activity.BaseActivity;
import pe.com.hatunsol.hatunsolmovil.modules.login.ui.LoginActivity;
import pe.com.hatunsol.hatunsolmovil.modules.main.ui.MainActivity;
import pe.com.hatunsol.hatunsolmovil.modules.splash.presenter.SplashPresenter;

public class SplashActivity extends Activity {


    // Set the duration of the splash screen
    private static final long SPLASH_SCREEN_DELAY = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        //try {

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Start the next activity
                Intent mainIntent = new Intent().setClass(SplashActivity.this, MainActivity.class);
                //Intent mainIntent = new Intent().setClass(SplashScreenActivity.this, MainActivity3.class);
                startActivity(mainIntent);
                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                finish();
            }
        };
        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);


    }


}
