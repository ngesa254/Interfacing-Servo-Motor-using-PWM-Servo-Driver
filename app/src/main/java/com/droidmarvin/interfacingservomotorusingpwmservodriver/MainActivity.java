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

    // close the servo when finished to release resources
    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyServo();
    }

    // access the servo
    private void setupServo(){
        try {
           mServo = new Servo(PWM_BUS);
            mServo.setPulseDurationRange(.5, 2.5); // according to your servo's specifications
            mServo.setAngleRange(0, 180);       // according to your servo's specifications
            mServo.setEnabled(true);
        }catch (IOException e){
            Log.e(TAG, "Error creating Servo", e);
        }
    }

    // close servo method
    private void destroyServo() {
        if (mServo != null) {
            try {
                mServo.close();
            } catch (IOException e) {
                Log.e(TAG, "Error closing Servo");
            } finally {
                mServo = null;
            }
        }
    }
}
