package com.semisoftnicolas.travail1.classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.semisoftnicolas.travail1.R;

import java.util.List;

public class AdapterListe extends RecyclerView.Adapter {

    public interface InterfaceEleve {
        public void detailEleveClick(Eleve eleve);
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
        monViewHolder.tvPresence.setTextColor(eleve.isPresence() ? 0xFF00FF00 : 0xFFFF0000);

    }

    @Override
    public int getItemCount() {
        return liste.size();
    }

    public void ajouterEleve(Eleve eleve) {
        liste.add(eleve);
        notifyItemInserted(liste.size() - 1);
    }

    public void supprimerEleve(int position) {
        liste.remove(position);
        notifyItemRemoved(position);
    }

    public class MonViewHolder extends RecyclerView.ViewHolder {

        TextView tvNom, tvPrenom, tvNumTel, tvCourriel, tvPresence;

        Button btnDetails;

        public MonViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNom = itemView.findViewById(R.id.tvNom);
            tvPrenom = itemView.findViewById(R.id.tvPrenom);
            tvNumTel = itemView.findViewById(R.id.tvNumTel);
            tvCourriel = itemView.findViewById(R.id.tvCourriel);
            tvPresence = itemView.findViewById(R.id.tvPresence);
            btnDetails = itemView.findViewById(R.id.btnDetails);

            btnDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    interfaceEleve.detailEleveClick(liste.get(getLayoutPosition()));
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Eleve eleve = liste.get(getLayoutPosition());
                    eleve.setPresence(!eleve.isPresence());
                    notifyItemChanged(getLayoutPosition());
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    supprimerEleve(getLayoutPosition());
                    return true;
                }
            });
        }
    }
}
