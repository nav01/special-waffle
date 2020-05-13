package com.example.kusdinventoryscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int LOGIN_REQUEST = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (false) { //logged in?
            Intent loginIntent = new Intent(this, SignInActivity.class);
            startActivityForResult(loginIntent, LOGIN_REQUEST);
        }

        FirebaseApp.initializeApp(this);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LOGIN_REQUEST) {
            if (resultCode == RESULT_OK) {
                TextView textView = (TextView) findViewById(R.id.placeholderText);
                String loginString = data.getExtras().getString(SignInActivity.LOGIN_EXTRA);
                textView.setText(loginString);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.scanBarcode) {
            Intent scanIntent = new Intent(this, ScannerActivity.class);
            startActivity(scanIntent);
        }
    }
}
