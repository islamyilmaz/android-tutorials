package com.islamyilmaz.example003_intentsgooglemap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Intent intent = null , chooser = null ;
    public void buttonPressed(View v){
        if(v.getId() == R.id.buttonGotoLocation){
            Log.i("islam","Location button pressed");
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:39.925002, 32.836840"));
            chooser = Intent.createChooser(intent, "Launch Maps");
            startActivity(chooser);
        }

        if(v.getId() == R.id.buttonApp){
            Log.i("islam","App button pressed");
            intent= new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=tr.gov.saglik.hayatevesigar"));
            chooser = Intent.createChooser(intent,"Launch App");
            startActivity(chooser);
        }

        if(v.getId() == R.id.buttonSocialMedia){
            Log.i("islam","Socialmedia button pressed");
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://twitter.com/csnaber"));
            chooser = Intent.createChooser(intent,"Launch Twitter");
            startActivity(chooser);
        }
    }
}
