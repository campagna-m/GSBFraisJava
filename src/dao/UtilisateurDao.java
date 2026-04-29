package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bdd.Connexion;
import pojo.Role;
import pojo.Utilisateur;

/**
 * DAO pour la table utilisateur.
 * Implémente les opérations CRUD (créer, lire, modifier, supprimer).
 * 
 * @author Matthieu CAMPAGNA
 */
public class UtilisateurDao extends Dao<Utilisateur> {

	static Connection conn = Connexion.getInstance();

	public UtilisateurDao(Connection conn) {
		super(conn);
	}

	/**
	 * Insère un nouvel utilisateur en base.
	 * 
	 * @param obj l'utilisateur à créer
	 * @return true si l'insertion a réussi
	 */
	public boolean create(Utilisateur obj) {
		String sql = "INSERT INTO utilisateur (idutilisateur, idRole, nom, prenom, login, mdp, dateCreationMdp, adresse, cp, ville, region, telephoneFixe, telephonePortable, mail, dateEmbauche) VALUES ('"
				+ obj.getIdUtilisateur() + "', '" + obj.getIdRole().getId() + "', '" + obj.getNom() + "', '"
				+ obj.getPrenom() + "', '" + obj.getLogin() + "', '" + obj.getMdp() + "', '" + obj.getDateCreationMdp()
				+ "', '" + obj.getAdresse() + "', '" + obj.getCp() + "', '" + obj.getVille() + "', '" + obj.getRegion()
				+ "', '" + obj.getTelephoneFixe() + "', '" + obj.getTelephonePortable() + "', '" + obj.getMail()
				+ "', '" + obj.getDateEmbauche() + "')";
		try {
			conn.createStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Supprime un utilisateur et ses fiches de frais associées.
	 * La suppression est bloquée si des fiches ne sont pas à l'état "Remboursée" (RB).
	 * 
	 * @param obj l'utilisateur à supprimer
	 * @return true si la suppression a réussi
	 */
	public boolean delete(Utilisateur obj) {
		boolean suppressionReussie = false;

		try {
			String id = obj.getIdUtilisateur();

			String sqlVerif = "SELECT COUNT(*) FROM fichefrais WHERE idVisiteur = '" + id + "' AND idEtat != 'RB'";
			java.sql.ResultSet resultat = conn.createStatement().executeQuery(sqlVerif);

			resultat.next();
			int fichesBloquantes = resultat.getInt(1);

			if (fichesBloquantes == 0) {

				String sqlFiches = "DELETE FROM fichefrais WHERE idVisiteur = '" + id + "'";
				conn.createStatement().executeUpdate(sqlFiches);

				String sqlUser = "DELETE FROM utilisateur WHERE idutilisateur = '" + id + "'";
				int lignesModifiees = conn.createStatement().executeUpdate(sqlUser);

				if (lignesModifiees > 0) {
					suppressionReussie = true;
				}
			}

		} catch (java.sql.SQLException e) {
			System.out.println("Erreur SQL lors de la suppression : " + e.getMessage());
			e.printStackTrace();
		}

		return suppressionReussie;
	}

	/**
	 * Met à jour les coordonnées d'un utilisateur (adresse, téléphone, mail).
	 * 
	 * @param obj l'utilisateur avec les nouvelles valeurs
	 * @return true si la mise à jour a réussi
	 */
	public boolean update(Utilisateur obj) {
		String sql = "UPDATE utilisateur SET adresse = '" + obj.getAdresse() + "', cp = '" + obj.getCp()
				+ "', ville = '" + obj.getVille() + "', region = '" + obj.getRegion() + "', telephoneFixe = '"
				+ obj.getTelephoneFixe() + "', telephonePortable = '" + obj.getTelephonePortable() + "', mail = '"
				+ obj.getMail() + "' WHERE idutilisateur = '" + obj.getIdUtilisateur() + "'";
		try {
			conn.createStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Recherche un utilisateur par son identifiant.
	 * 
	 * @param id identifiant de l'utilisateur
	 * @return l'utilisateur trouvé ou null
	 */
	public Utilisateur find(String id) {
		String sql = "SELECT * FROM utilisateur WHERE idutilisateur = '" + id + "'";
		try {
			ResultSet resultat = conn.createStatement().executeQuery(sql);

			if (resultat.next()) {
				Role role = new Role(resultat.getString("idRole"), "");

				Utilisateur utilisateurRenvoi = new Utilisateur(resultat.getString("idutilisateur"), role,
						resultat.getString("nom"), resultat.getString("prenom"), resultat.getString("login"),
						resultat.getString("mdp"), resultat.getDate("dateCreationMdp"), resultat.getString("adresse"),
						resultat.getString("cp"), resultat.getString("ville"), resultat.getString("region"),
						resultat.getString("telephoneFixe"), resultat.getString("telephonePortable"),
						resultat.getString("mail"), resultat.getDate("dateEmbauche"));
				return utilisateurRenvoi;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Retourne la liste de tous les utilisateurs.
	 * 
	 * @return liste des utilisateurs
	 */
	public List<Utilisateur> findAll() {
		List<Utilisateur> listeUtilisateurs = new ArrayList<>();
		String sql = "SELECT * FROM utilisateur";
		try {
			ResultSet resultat = conn.createStatement().executeQuery(sql);

			while (resultat.next()) {
				Role role = new Role(resultat.getString("idRole"), "");

				Utilisateur utilisateur = new Utilisateur(resultat.getString("idutilisateur"), role,
						resultat.getString("nom"), resultat.getString("prenom"), resultat.getString("login"),
						resultat.getString("mdp"), resultat.getDate("dateCreationMdp"), resultat.getString("adresse"),
						resultat.getString("cp"), resultat.getString("ville"), resultat.getString("region"),
						resultat.getString("telephoneFixe"), resultat.getString("telephonePortable"),
						resultat.getString("mail"), resultat.getDate("dateEmbauche"));

				listeUtilisateurs.add(utilisateur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeUtilisateurs;
	}

}
