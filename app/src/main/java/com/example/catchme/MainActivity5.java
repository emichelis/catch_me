package com.example.catchme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity5 extends AppCompatActivity {
    EditText Name;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Name = findViewById(R.id.Name);
        button2 = findViewById(R.id.button2);
    }

    //saveData is onClick method for the confirm button
    //saveData is also a responce for the Activity Result Launcher on MainActivity to return the name that was given by the user
    public void saveData(View view) {
        EditText msg = findViewById(R.id.Name);
        String inputText = msg.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("inputText", inputText);
        setResult(RESULT_OK, intent);
        finish();
    }
}