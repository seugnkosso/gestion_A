package com.kosso.repositories.bd;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kosso.entities.ArticleConfection;
import com.kosso.entities.Categorie;
import com.kosso.repositories.ITables;

public class CategorieBd extends Conn implements ITables<Categorie> {
    private ArrayList<Categorie> list = new ArrayList<>();

    private Categorie categorie;

    @Override
    public int insert(Categorie data) {
        connexion();
        // étape 3: créer l'objet statement
        try {
            stmt1 = conn.prepareStatement("insert into categorie values(Null,?)");
            stmt1.setString(1, data.getLibelle());
            int res = stmt1.executeUpdate();
            conn.close();
            return res;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int update(Categorie data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ArrayList<Categorie> findAll() {
        connexion();
        // étape 3: créer l'objet statement
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("SELECT * FROM categorie");
            // étape 4: exécuter la requête
            list.clear();
            while (res.next()) {
                categorie = new Categorie(res.getString("libelle"));
                categorie.setId(res.getInt("id"));
                list.add(categorie);
            }
            // étape 5: fermez l'objet de connexion
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Categorie findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public int delete(int id) {
        connexion();
        // étape 3: créer l'objet statement
        try {
            stmt1 = conn.prepareStatement("delete from Categorie where id = ?");
            stmt1.setInt(1, id);
            int res = stmt1.executeUpdate();
            conn.close();
            return res;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int indexOf(int id) {
        connexion();
        // étape 3: créer l'objet statement
        try {
            stmt1 = conn.prepareStatement("SELECT * FROM Categorie where id = ?");
            stmt1.setInt(1, id);
            res = stmt1.executeQuery();
            // étape 4: exécuter la requête

            int idCat = -1;
            if (res.next()) {
                idCat = res.getInt("id");
            }
            // étape 5: fermez l'objet de connexion
            conn.close();
            return idCat;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1;
    }

}
