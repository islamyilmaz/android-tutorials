package com.islamyilmaz.example003_intentsgooglemap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

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

        if(v.getId() == R.id.buttonSendEmail){
            Log.i("islam","Send email button pressed");
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String [] to = {"islamyilmaz@yahoo.com"};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT,"Mail konu bölümü");
            intent.putExtra(Intent.EXTRA_TEXT,"Mail mesaj bölümü.");
            intent.setType("message/rfc822");
            chooser = Intent.createChooser(intent,"Send Email");
            startActivity(chooser);
        }

        if(v.getId() == R.id.buttonSendImage){
            Uri imageUri = Uri.parse("android.resources://"+ getPackageName() +"/drawable/" + R.drawable.logo);
            intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_STREAM, imageUri);
            startActivity(Intent.createChooser(intent, "Send Image"));
        }

    }
}
