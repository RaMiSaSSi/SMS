package com.example.recep_sms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.RECEIVE_SMS},1000);
        }
    }
   public void onRequestPermessionResult(int requestCode, @NonNull String[] permessions,@NonNull int[] grandResults){
        if (requestCode == 1000){
            if(grandResults[0] == PackageManager.PERMISSION_DENIED){
                Toast.makeText(this, "Permession granted", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Permession not granted", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
   }
}