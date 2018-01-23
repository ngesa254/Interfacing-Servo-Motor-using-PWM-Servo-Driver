package com.droidmarvin.interfacingservomotorusingpwmservodriver;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.things.contrib.driver.pwmservo.Servo;

import java.io.IOException;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    private static final String PWM_BUS = "PWM1";

    private Servo mServo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setupServo(){
        try {
           mServo = new Servo(PWM_BUS);
        }catch (IOException e){
            Log.e(TAG, "Error creating Servo", e);
        }
    }
}
