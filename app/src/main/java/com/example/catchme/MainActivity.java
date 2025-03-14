package com.example.catchme;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SensorManager sensorManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //The next 3 lines are for declaring the use of the accelerometer sensor
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    ActivityResultLauncher<Intent> ActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                Button register = findViewById(R.id.REGISTER);
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null) {
                        TextView text = findViewById(R.id.textView4);
                        text.setText("Hello " + data.getStringExtra("inputText"));      //Here we take the name from Activity5 and write "Hello ___"
                        register.setVisibility(View.INVISIBLE);
                    }
                }
            });

    public void register(View view) {
        Intent intent = new Intent(this, MainActivity5.class);      //This intent takes the user to Activity5 to put his name
        ActivityResultLauncher.launch(intent);
    }

    public void fall(View view) {
        Intent intent = new Intent(this, MainActivity2.class);  //This intent takes the user to Activity2
        ActivityResultLauncher.launch(intent);
    }

    private SensorEventListener listener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent event) {
            TextView text = findViewById(R.id.textView5);
            Button fall = findViewById(R.id.FALL);

// The acceleration may be negative, so take their absolute value
            float xValue = Math.abs(event.values[0]);
            float yValue = Math.abs(event.values[1]);
            float zValue = Math.abs(event.values[2]);       //x,y,z are the 3D dimensions, the floor is 39 after many trials
            if (xValue > 39 || yValue > 39 || zValue > 39) {
                text.setVisibility(View.VISIBLE);       //It makes visible the text and the button that asks the user if the fall detection is correct
                fall.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }   //That one just has to be there. Otherwise the compiler shows errors

    };

}