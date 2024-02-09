package com.semisoftnicolas.travail1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.semisoftnicolas.travail1.classes.AdapterListe;
import com.semisoftnicolas.travail1.classes.Eleve;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterListe.InterfaceEleve {

    FloatingActionButton btn_add;

    ActivityResultLauncher<Intent> launcher;
    AdapterListe adapterListe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Eleve> liste = new ArrayList<>();

        RecyclerView rv;
        Context context;

        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        liste.add(new Eleve("Tremblay", "Jean", "514-555-5555", "tremblay.jean@email.com"));
        liste.add(new Eleve("Lavoie", "Marie", "514-555-5555", "lavoie.marie@email.com"));
        liste.add(new Eleve("Gagnon", "Pierre", "514-555-5555", "gagnon.pierre@email.com"));
        liste.add(new Eleve("Lemieux", "Sophie", "514-555-5555", "lemieux.sophie@email.com"));

        adapterListe = new AdapterListe(liste, this);
        rv.setAdapter(adapterListe);

        btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(v -> btnAjouterEleveClick());

        context = this;

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent intentRetour = result.getData();

                            String nom = intentRetour.getStringExtra("nom");

                            String prenom = intentRetour.getStringExtra("prenom");

                            String numTel = intentRetour.getStringExtra("numTel");

                            String courriel = intentRetour.getStringExtra("courriel");

                            adapterListe.ajouterEleve(new Eleve(nom, prenom, numTel, courriel));

                            Toast.makeText(context, "Élève ajouté", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );
    }

    public void btnAjouterEleveClick()
    {
        Intent intent = new Intent(this, SecondActivity.class);
        launcher.launch(intent);
    }

    public void detailEleveClick(Eleve eleve)
    {
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra("nom",eleve.getNom());
        intent.putExtra("prenom",eleve.getPrenom());
        intent.putExtra("numTel",eleve.getNumTel());
        intent.putExtra("courriel",eleve.getCourriel());
        intent.putExtra("presence",eleve.isPresence());
        launcher.launch(intent);
    }


}