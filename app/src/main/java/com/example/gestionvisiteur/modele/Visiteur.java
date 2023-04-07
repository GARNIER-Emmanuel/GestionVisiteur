package com.example.gestionvisiteur.modele;

public class Visiteur {
        String idVisiteur, nom, prenom, login, mdp, adresse, cp, ville, dateEmbauche;

        public Visiteur(String id, String nom, String prenom, String login, String mdp, String adresse, String cp, String ville, String dateEmbauche) {
            this.idVisiteur = id;
            this.nom = nom;
            this.prenom = prenom;
            this.login = login;
            this.mdp = mdp;
            this.adresse = adresse;
            this.cp = cp;
            this.ville = ville;
            this.dateEmbauche = dateEmbauche;
        }

    public Visiteur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getIdVisiteur() {
        return idVisiteur;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getLogin() {
        return login;
    }

    public String getMdp() {
        return mdp;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getCp() {
        return cp;
    }

    public String getVille() {
        return ville;
    }

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    public void setIdVisiteur(String idVisiteur) {
        this.idVisiteur = idVisiteur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }


    @Override
    public String toString() {
        return
                 nom + ' ' +
                 prenom
                ;
    }
}
