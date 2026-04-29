package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Gère la connexion à la base de données MySQL (singleton).
 * 
 * @author Matthieu CAMPAGNA
 */
public class Connexion {

	private static final String URL = "jdbc:mysql://localhost:3306/gsbfrais-2025";
	private static final String UTILISATEUR = "myroot";
	private static final String MOT_DE_PASSE = "root123*";

	private static Connection conn = null;

	/**
	 * Retourne l'instance unique de la connexion. La crée si elle n'existe pas encore.
	 * 
	 * @return la connexion à la base de données
	 */
	public static Connection getInstance() {
		try {
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
				System.out.println("Connexion à la base de données réussie");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connexion impossible");
		}
		return conn;
	}

	/**
	 * Ferme la connexion à la base de données si elle est ouverte.
	 */
	public static void close() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
				System.out.println("Connexion fermée avec succès");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problème lors de la fermeture");
		}
	}
}
