package com.semisoftnicolas.travail1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();

        TextView tvNom = findViewById(R.id.tvNom);
        TextView tvPrenom = findViewById(R.id.tvPrenom);
        TextView tvNumTel = findViewById(R.id.tvNumTel);
        TextView tvCourriel = findViewById(R.id.tvCourriel);
        TextView tvPresence = findViewById(R.id.tvPresence);

        tvNom.setText(intent.getStringExtra("nom"));
        tvPrenom.setText(intent.getStringExtra("prenom"));
        tvNumTel.setText(intent.getStringExtra("numTel"));
        tvCourriel.setText(intent.getStringExtra("courriel"));
        tvPresence.setText(intent.getBooleanExtra("presence", false) ? "Présent" : "Absent");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home)
        {
            setResult(RESULT_CANCELED);
            finish();
        }

        return true;
    }
}