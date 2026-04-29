package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import bdd.Connexion;
import pojo.LigneFraisHorsForfait;

/**
 * DAO pour la table lignefraishorsforfait.
 * Gère les requêtes liées aux frais hors forfait (nombre, montant, moyenne par région).
 * 
 * @author Matthieu CAMPAGNA
 */
public class LigneFraisHorsForfaitDao extends Dao<LigneFraisHorsForfait> {

	static Connection conn = Connexion.getInstance();

	public LigneFraisHorsForfaitDao(Connection conn) {
		super(conn);
	}

	public boolean create(LigneFraisHorsForfait obj) {
		return false;
	}

	public boolean delete(LigneFraisHorsForfait obj) {
		return false;
	}

	public boolean update(LigneFraisHorsForfait obj) {
		return false;
	}

	public LigneFraisHorsForfait find(String id) {
		return null;
	}

	public List<LigneFraisHorsForfait> findAll() {
		return null;
	}

	/**
	 * Compte le nombre de frais hors forfait pour un visiteur et un mois donné.
	 * 
	 * @param idVisiteur identifiant du visiteur
	 * @param moisFiltre numéro du mois
	 * @return nombre de frais hors forfait
	 */
	public int nbFicheHorsForfaitParMois(String idVisiteur, int moisFiltre) {
		int totalFrais = 0;

		String sql = "SELECT COUNT(*) FROM lignefraishorsforfait "
				+ "WHERE idFiche = (SELECT idFiche FROM fichefrais WHERE idVisiteur = ? AND mois = ? "
				+ "ORDER BY annee DESC LIMIT 1)";
		try {
			PreparedStatement requetePreparee = this.connect.prepareStatement(sql);
			requetePreparee.setString(1, idVisiteur);
			requetePreparee.setInt(2, moisFiltre);

			ResultSet resultatRequete = requetePreparee.executeQuery();
			if (resultatRequete.next()) {
				totalFrais = resultatRequete.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalFrais;
	}

	/**
	 * Calcule le montant total des frais hors forfait pour un visiteur et un mois donné.
	 * 
	 * @param idVisiteur identifiant du visiteur
	 * @param moisFiltre numéro du mois
	 * @return montant total des frais hors forfait
	 */
	public double getMontantFraisHorsForfaitParMois(String idVisiteur, int moisFiltre) {
		double montantTotal = 0;

		String sql = "SELECT SUM(montant) FROM lignefraishorsforfait "
				+ "WHERE idFiche = (SELECT idFiche FROM fichefrais " + "WHERE idVisiteur = ? AND mois = ? "
				+ "ORDER BY annee DESC LIMIT 1)";
		try {
			PreparedStatement requetePreparee = this.connect.prepareStatement(sql);
			requetePreparee.setString(1, idVisiteur);
			requetePreparee.setInt(2, moisFiltre);

			ResultSet resultatRequete = requetePreparee.executeQuery();
			if (resultatRequete.next()) {
				montantTotal = resultatRequete.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return montantTotal;
	}

	/**
	 * Calcule la moyenne des frais hors forfait par région pour un mois donné.
	 * 
	 * @param moisFiltre numéro du mois
	 * @return liste de tableaux [région, nombre de visiteurs, moyenne]
	 */
	public List<Object[]> getMoyenneFraisHorsForfaitParRegion(int moisFiltre) {
		List<Object[]> listeMoyenne = new java.util.ArrayList<>();

		String sql = "SELECT region, COUNT(DISTINCT fichefrais.idVisiteur), " + "AVG(lignefraishorsforfait.montant) "
				+ "FROM lignefraishorsforfait "
				+ "INNER JOIN fichefrais ON lignefraishorsforfait.idFiche = fichefrais.idFiche "
				+ "INNER JOIN utilisateur ON fichefrais.idVisiteur = utilisateur.idutilisateur "
				+ "WHERE fichefrais.mois = ? " + "GROUP BY region";

		try {
			PreparedStatement requetePreparee = this.connect.prepareStatement(sql);
			requetePreparee.setInt(1, moisFiltre);

			ResultSet resultatRequete = requetePreparee.executeQuery();
			while (resultatRequete.next()) {
				String region = resultatRequete.getString(1);
				int nbVisiteurs = resultatRequete.getInt(2);
				double moyenne = resultatRequete.getDouble(3);

				listeMoyenne.add(new Object[] { region, nbVisiteurs, moyenne });
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listeMoyenne;
	}

}
