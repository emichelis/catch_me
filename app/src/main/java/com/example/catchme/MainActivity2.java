package com.example.catchme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void Help(View view) {
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent); //Radiobutton if the user decides that he needs help
    }

    public void Home(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent); //Button that takes the user back to the Activity1
    }

    public void OK(View view) {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent); //Radiobutton if the user is ok
    }
}