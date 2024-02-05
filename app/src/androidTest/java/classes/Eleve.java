package classes;

public class Eleve {

    String nom, prenom, numTel, courriel, presence;

    public Eleve(String nom, String prenom, String numTel, String courriel, String presence) {
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
        this.courriel = courriel;
        this.presence = presence;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getPresence() {
        return presence;
    }

    public void setPresence(String presence) {
        this.presence = presence;
    }
}
