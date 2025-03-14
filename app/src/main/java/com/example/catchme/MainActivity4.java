package com.example.catchme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public void Call(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);         //OnClick goes to phone
        startActivity(intent);
    }

    public void Call166(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0016600"));       //onClick goes to phone and dials 166
        startActivity(intent);
    }

    public void Search(View view) {
        String url = "https://www.google.com/search?q=%CF%80%CE%B1%CE%B8%CE%BF%CE%BB%CE%BF%CE%B3%CE%BF%CF%82&sxsrf=APwXEdeBU6MHi-PhZXo5st-j1igrFUXZDQ%3A1680964463360&ei=b3sxZIrNFYuD9u8PxL2muAs&ved=0ahUKEwjKwN_NwJr-AhWLgf0HHcSeCbcQ4dUDCA8&uact=5&oq=%CF%80%CE%B1%CE%B8%CE%BF%CE%BB%CE%BF%CE%B3%CE%BF%CF%82&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAzIECCMQJzIECCMQJzICCCYyAggmMgIIJjoHCCMQsAMQJzoKCAAQRxDWBBCwAzoICAAQFhAeEAo6BggAEBYQHjoHCCMQ6gIQJzoFCC4QgAQ6CwgAEIoFELEDEIMBOg4ILhCABBCxAxCDARDUAjoFCAAQgAQ6CwguEIAEELEDEIMBOhEILhCABBCxAxCDARDHARDRAzoHCAAQigUQQzoKCC4QigUQ1AIQQzoLCAAQgAQQsQMQgwE6CwguEIAEEMcBEK8BOggIABCABBCxAzoLCC4QrwEQxwEQgARKBAhBGABQ-gtY2S5g3zRoAnABeASAAZ4BiAG5E5IBBDAuMTmYAQCgAQGwAQrIAQnAAQE&sclient=gws-wiz-serp";
        Uri webpage = Uri.parse(url);
        Intent webIntent = new Intent(Intent.ACTION_VIEW);     //onclick goes to browser and searches for doctors
        webIntent.setData(webpage);
        if (webIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(webIntent);
        }
    }

    public void Back(View view){
        Intent intent=new Intent(this,MainActivity2.class); //onClick goes back to Activity2
        startActivity(intent);
    }
}