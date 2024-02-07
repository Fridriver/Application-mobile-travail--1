package com.semisoftnicolas.travail1.classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.semisoftnicolas.travail1.R;

import java.util.List;

public class AdapterListe extends RecyclerView.Adapter {

    public interface InterfaceEleve {
        public void detailEleveClick(int position, Eleve eleve);
    }

    InterfaceEleve interfaceEleve;

    List<Eleve> liste;

    public AdapterListe(List<Eleve> liste, InterfaceEleve interfaceEleve) {
        this.liste = liste;
        this.interfaceEleve = interfaceEleve;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_carte,parent,false);
        return new MonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MonViewHolder monViewHolder = (MonViewHolder) holder;
        Eleve eleve = liste.get(position);
        monViewHolder.tvNom.setText(eleve.getNom());
        monViewHolder.tvPrenom.setText(eleve.getPrenom());
        monViewHolder.tvNumTel.setText(eleve.getNumTel());
        monViewHolder.tvCourriel.setText(eleve.getCourriel());
        monViewHolder.tvPresence.setText(eleve.isPresence() ? "Présent" : "Absent");

    }

    @Override
    public int getItemCount() {
        return liste.size();
    }

    public class MonViewHolder extends RecyclerView.ViewHolder {

        TextView tvNom, tvPrenom, tvNumTel, tvCourriel, tvPresence;

        public MonViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNom = itemView.findViewById(R.id.tvNom);
            tvPrenom = itemView.findViewById(R.id.tvPrenom);
            tvNumTel = itemView.findViewById(R.id.tvNumTel);
            tvCourriel = itemView.findViewById(R.id.tvCourriel);
            tvPresence = itemView.findViewById(R.id.tvPresence);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    interfaceEleve.detailEleveClick(getLayoutPosition(), liste.get(getLayoutPosition()));
                }
            });
        }
    }
}
