package com.semisoftnicolas.travail1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        TextView edNom = findViewById(R.id.tvNom);
        TextView edPrenom = findViewById(R.id.tvPrenom);
        TextView edNumTel = findViewById(R.id.tvNumTel);
        TextView edCourriel = findViewById(R.id.tvCourriel);
        Button btnAdd = findViewById(R.id.btnAdd);

        String text = intent.getStringExtra("text");
        intent.putExtra("nom", edNom.getText().toString());
        intent.putExtra("prenom", edPrenom.getText().toString());
        intent.putExtra("numTel", edNumTel.getText().toString());
        intent.putExtra("courriel", edCourriel.getText().toString());

        btnAdd.setOnClickListener(view -> {

            if (edNom.getText().toString().isEmpty() || edPrenom.getText().toString().isEmpty() || edNumTel.getText().toString().isEmpty() || edCourriel.getText().toString().isEmpty()) {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                if (edNom.getText().toString().isEmpty()) {
                    edNom.setError("Champ obligatoire");
                    Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                    if (edPrenom.getText().toString().isEmpty()) {
                        edPrenom.setError("Champ obligatoire");
                        Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                        if (edNumTel.getText().toString().isEmpty()) {
                            edNumTel.setError("Champ obligatoire");
                            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                            if (edCourriel.getText().toString().isEmpty()) {
                                edCourriel.setError("Champ obligatoire");
                                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
                return;
            }

            Intent intentRetour = new Intent();
            intentRetour.putExtra("nom", edNom.getText().toString());
            intentRetour.putExtra("prenom", edPrenom.getText().toString());
            intentRetour.putExtra("numTel", edNumTel.getText().toString());
            intentRetour.putExtra("courriel", edCourriel.getText().toString());
            setResult(RESULT_OK, intentRetour);
            finish();
        });
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