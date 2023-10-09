package com.kosso.entities;

public class Categorie {
    // Attributs Instances
    private static int nbrCat;
    private int id;
    private String libelle;

    public Categorie(String libelle) {
        this.id = nbrCat++;
        this.libelle = libelle;
    }

    // Contructeur Par Defaut
    public Categorie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "categorie [id=" + id + ", libelle=" + libelle + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Categorie other = (Categorie) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
