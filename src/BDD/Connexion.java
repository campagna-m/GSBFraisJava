package BDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

    // Mettez vos informations de base de données ici
    private static final String URL = "jdbc:mysql://localhost:3306/gsbfrais-2025";
    private static final String UTILISATEUR = "myroot";
    private static final String MOT_DE_PASSE = "root123*";

    private static Connection conn = null;

    public static Connection getInstance() {
        try {
            // Établir la connexion
        	conn = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
            System.out.println("connexion à la base de données réussie");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("connexion impossible");
        }
        return conn;
    }

    public static void close() {
        try {
        	conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("problème lors de la fermeture");
        }
    }
	
}
