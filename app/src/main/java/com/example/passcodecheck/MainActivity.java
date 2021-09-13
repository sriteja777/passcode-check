package com.example.passcodecheck;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.KeyguardManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button keyButton;
    Button deviceButton;
    TextView keyText;
    TextView deviceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        keyButton = (Button) findViewById(R.id.button);
        deviceButton = (Button) findViewById(R.id.button2);

        keyText = (TextView) findViewById(R.id.textView);
        deviceText = (TextView) findViewById(R.id.textView2);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void checkDeviceSecure(View view) {
        KeyguardManager keyguardManager = (KeyguardManager) this.getSystemService(KEYGUARD_SERVICE);
        deviceText.setText(String.valueOf(keyguardManager.isDeviceSecure()));
    }

    public void checkKeyguardSecure(View view) {
        KeyguardManager keyguardManager = (KeyguardManager) this.getSystemService(KEYGUARD_SERVICE);
        keyText.setText(String.valueOf(keyguardManager.isKeyguardSecure()));
    }
}