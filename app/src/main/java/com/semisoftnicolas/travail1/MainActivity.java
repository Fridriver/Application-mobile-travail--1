package com.semisoftnicolas.travail1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.semisoftnicolas.travail1.classes.AdapterListe;
import com.semisoftnicolas.travail1.classes.Eleve;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton btn_add;
    AdapterListe adapterListe;

    ActivityResultLauncher<Intent> launcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent intentRetour = result.getData();

                    String textRetour = intentRetour.getStringExtra("textRetour");
                    Toast.makeText(this, "Valeur retour : " + textRetour, Toast.LENGTH_SHORT).show();
                }
            }
        );

        List<Eleve> liste = new ArrayList<>();

        RecyclerView rv;

        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        liste.add(new Eleve("Tremblay", "Jean", "514-555-5555", "tremblay.jean@email.com"));
        liste.add(new Eleve("Lavoie", "Marie", "514-555-5555", "lavoie.marie@email.com"));
        liste.add(new Eleve("Gagnon", "Pierre", "514-555-5555", "gagnon.pierre@email.com"));
        liste.add(new Eleve("Lemieux", "Sophie", "514-555-5555", "lemieux.sophie@email.com"));

        adapterListe = new AdapterListe(liste);
        rv.setAdapter(adapterListe);

        btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(v -> btnAjouterEleveClick());
    }

    public void btnAjouterEleveClick()
    {
        Intent intent = new Intent(this, SecondActivity.class);
        launcher.launch(intent);
    }

    public void detailEleveClick(int position)
    {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }
}