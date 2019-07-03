package com.example.demo;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private EditText eWeb, eLoc, eShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("project", "Main Activity - onCreate()");
        eWeb=(EditText)findViewById(R.id.website);
        eLoc=(EditText)findViewById(R.id.location);
        eShare=(EditText)findViewById(R.id.share_text);
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("project","Main Activity - onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("project","Main Activity - onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("project","Main Activity - onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("project","Main Activity - onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("project","Main Activity - onDestroy()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("project","Main Activity - onStop()");
    }

    public void showContent(View view) {

        switch (view.getId()){
            case R.id.go_web:
                Intent webIntent=new Intent(Intent.ACTION_VIEW, Uri.parse(eWeb.getText().toString()));
                if(webIntent.resolveActivity(getPackageManager())!=null){
                    startActivity(webIntent);
                }else{
                    Toast.makeText(getApplicationContext(),"Can't proceed to website",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.go_location:
                Intent locIntent=new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q=" + eLoc.getText().toString()));
                if(locIntent.resolveActivity(getPackageManager())!=null){
                    startActivity(locIntent);
                }else{
                    Toast.makeText(getApplicationContext(),"Can't open your location",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.go_text:
                ShareCompat.IntentBuilder.from(this)
                        .setType("text/plain")
                        .setChooserTitle("Share using : ")
                        .setText(eShare.getText().toString())
                        .startChooser();
                break;

        }
    }
}
