package com.islamyilmaz.example001;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int programCounter=0;
    Button button;
    Button button2;
    Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickHandler());
    }


    class OnClickHandler implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if(v.equals(button))    Log.i("islam","Button1");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("programCounter", programCounter);
        Log.i("islam","Saved");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        programCounter = savedInstanceState.getInt("programCounter", 0);
        Log.i("islam", programCounter +" restored");
    }

    @Override
    protected void onResume() {
        super.onResume();
        programCounter++;
        Log.i("islam","Programcounter increased");
    }
}
