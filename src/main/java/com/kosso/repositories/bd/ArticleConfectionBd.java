package com.kosso.repositories.bd;

import java.sql.*;
import java.util.ArrayList;

import com.kosso.entities.ArticleConfection;
import com.kosso.repositories.ITables;

public class ArticleConfectionBd extends Conn implements ITables<ArticleConfection> {
    private ArrayList<ArticleConfection> list = new ArrayList<>();

    private ArticleConfection artConf;

    public ArticleConfectionBd() {
        super();
    }

    @Override
    public int insert(ArticleConfection data) {
        connexion();
        // étape 3: créer l'objet statement
        try {
            stmt1 = conn.prepareStatement("insert into articleConfection values(Null,?,?,?,Null)");
            stmt1.setString(1, data.getLibelle());
            stmt1.setDouble(2, data.getPrix());
            stmt1.setInt(3, (int) data.getQte());
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
    public int update(ArticleConfection data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ArrayList<ArticleConfection> findAll() {
        connexion();
        // étape 3: créer l'objet statement
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("SELECT * FROM articleConfection");
            // étape 4: exécuter la requête
            list.clear();
            while (res.next()) {
                artConf = new ArticleConfection(res.getString("libelle"), res.getDouble("prix"), res.getInt("qte"));
                artConf.setId(res.getInt("id"));
                list.add(artConf);
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
    public ArticleConfection findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public int delete(int id) {
        connexion();
        // étape 3: créer l'objet statement
        try {
            stmt1 = conn.prepareStatement("delete from articleConfection where id = ?");
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
            stmt1 = conn.prepareStatement("SELECT * FROM articleConfection where id = ?");
            stmt1.setInt(1, id);
            res = stmt1.executeQuery();
            // étape 4: exécuter la requête

            int idarticle = -1;
            if (res.next()) {
                idarticle = res.getInt("id");
            }
            // étape 5: fermez l'objet de connexion
            conn.close();
            return idarticle;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1;
    }

}
