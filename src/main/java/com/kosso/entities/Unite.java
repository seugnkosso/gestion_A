package com.kosso.entities;

public class Unite {
    // Attributs Instances
    private int id;
    private String libelle;

    public Unite(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    // Contructeur Par Defaut
    public Unite() {
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
        return "Unite [id=" + id + ", libelle=" + libelle + "]";
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
        Unite other = (Unite) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
