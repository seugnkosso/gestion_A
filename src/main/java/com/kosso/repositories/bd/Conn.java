package com.kosso.repositories.bd;

import java.sql.*;

public class Conn {
    protected Connection conn;
    protected Statement stmt;
    protected PreparedStatement stmt1;
    protected ResultSet res;

    public void connexion() {
        try {
            // étape 1: charger la classe de driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // étape 2: créer l'objet de connexion
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/gestion_atelier", "root", "");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
