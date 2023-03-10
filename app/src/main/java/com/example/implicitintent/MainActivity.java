package com.example.implicitintent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.PermissionRequest;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
    private Boolean CALL_PERMISSION = false;

    String[] permission= { "android.permission.CALL_PHONE" };

    private Button phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone = (Button) findViewById(R.id.btnPhone);



        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    requestPermissions(permission, 80);
                }

                Intent myIntent = new Intent(Intent.ACTION_CALL_BUTTON);


                    startActivity(myIntent);



            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 80 ){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            }
        }
    }
}