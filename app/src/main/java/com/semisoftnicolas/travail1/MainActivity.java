package com.semisoftnicolas.travail1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.semisoftnicolas.travail1.classes.AdapterListe;
import com.semisoftnicolas.travail1.classes.Eleve;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Eleve> liste = new ArrayList<>();

        RecyclerView rv;

        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        liste.add(new Eleve("Tremblay", "Jean", "514-555-5555", "tremblay.jean@email.com"));
        liste.add(new Eleve("Lavoie", "Marie", "514-555-5555", "lavoie.marie@email.com"));
        liste.add(new Eleve("Gagnon", "Pierre", "514-555-5555", "gagnon.pierre@email.com"));

        rv.setAdapter(new AdapterListe(liste));
    }
}