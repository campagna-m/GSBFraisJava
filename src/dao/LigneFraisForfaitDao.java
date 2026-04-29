package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import bdd.Connexion;
import pojo.LigneFraisForfait;

/**
 * DAO pour la table lignefraisforfait.
 * Gère les requêtes liées aux frais forfait (montant par mois, moyenne par région).
 * 
 * @author Matthieu CAMPAGNA
 */
public class LigneFraisForfaitDao extends Dao<LigneFraisForfait> {

	static Connection conn = Connexion.getInstance();

	public LigneFraisForfaitDao(Connection conn) {
		super(conn);
	}

	public boolean create(LigneFraisForfait obj) {
		return false;
	}

	public boolean delete(LigneFraisForfait obj) {
		return false;
	}

	public boolean update(LigneFraisForfait obj) {
		return false;
	}

	public LigneFraisForfait find(String id) {
		return null;
	}

	public List<LigneFraisForfait> findAll() {
		return null;
	}

	/**
	 * Calcule le montant total des frais forfait pour un visiteur et un mois donné.
	 * 
	 * @param idVisiteur identifiant du visiteur
	 * @param moisFiltre numéro du mois
	 * @return montant total des frais forfait
	 */
	public double getMontantFraisForfaitParMois(String idVisiteur, int moisFiltre) {
		double montantTotal = 0;

		String sql = "SELECT SUM(lignefraisforfait.quantite * fraisforfait.montant) " + "FROM lignefraisforfait "
				+ "INNER JOIN fraisforfait ON lignefraisforfait.idFraisForfait = fraisforfait.idfraisforfait "
				+ "WHERE lignefraisforfait.idFiche = (SELECT idFiche FROM fichefrais "
				+ "WHERE idVisiteur = ? AND mois = ? " + "ORDER BY annee DESC LIMIT 1)";
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
	 * Calcule la moyenne des frais forfait par région pour un mois donné.
	 * 
	 * @param moisFiltre numéro du mois
	 * @return liste de tableaux [région, nombre de visiteurs, moyenne]
	 */
	public List<Object[]> getMoyenneFraisForfaitParRegion(int moisFiltre) {
		List<Object[]> listeMoyenne = new java.util.ArrayList<>();

		String sql = "SELECT region, COUNT(DISTINCT fichefrais.idVisiteur), "
				+ "AVG(lignefraisforfait.quantite * fraisforfait.montant) " + "FROM lignefraisforfait "
				+ "INNER JOIN fraisforfait ON lignefraisforfait.idFraisForfait = fraisforfait.idfraisforfait "
				+ "INNER JOIN fichefrais ON lignefraisforfait.idFiche = fichefrais.idFiche "
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
