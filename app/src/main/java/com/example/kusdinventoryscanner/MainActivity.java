package com.example.kusdinventoryscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int LOGIN_REQUEST = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (true) { //logged in?
            Intent loginIntent = new Intent(this, SignIn.class);
            startActivityForResult(loginIntent, LOGIN_REQUEST);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LOGIN_REQUEST) {
            if (resultCode == RESULT_OK) {
                TextView textView = (TextView) findViewById(R.id.placeholderText);
                String loginString = data.getExtras().getString(SignIn.LOGIN_EXTRA);
                textView.setText(loginString);
            }
        }
    }
}
