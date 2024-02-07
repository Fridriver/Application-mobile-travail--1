package com.semisoftnicolas.travail1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        String text = intent.getStringExtra("text");

        setResult(RESULT_OK, new Intent().putExtra("textRetour", "Retour de la seconde activité"));
        //finish();
    }
}