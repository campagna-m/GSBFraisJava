package bdd;

import java.util.List;

import dao.LigneFraisForfaitDao;
import dao.LigneFraisHorsForfaitDao;
import dao.UtilisateurDao;
import pojo.Utilisateur;

/**
 * Classe d'accès aux données. Fait le lien entre l'application et les DAO.
 * 
 * @author Matthieu CAMPAGNA
 */
public class AccesData {

	// --- Utilisateur ---

	/**
	 * Retourne la liste de tous les utilisateurs.
	 * 
	 * @return liste des utilisateurs
	 */
	public static List<Utilisateur> getTousLesUtilisateurs() {
		UtilisateurDao dao = new UtilisateurDao(Connexion.getInstance());
		return dao.findAll();
	}

	/**
	 * Retourne un utilisateur à partir de son identifiant.
	 * 
	 * @param id identifiant de l'utilisateur
	 * @return l'utilisateur trouvé ou null
	 */
	public static Utilisateur getUtilisateurParId(String id) {
		UtilisateurDao dao = new UtilisateurDao(Connexion.getInstance());
		return dao.find(id);
	}

	/**
	 * Met à jour un utilisateur en base.
	 * 
	 * @param u l'utilisateur à modifier
	 * @return true si la mise à jour a réussi
	 */
	public static boolean updateUtilisateur(Utilisateur u) {
		UtilisateurDao dao = new UtilisateurDao(Connexion.getInstance());
		return dao.update(u);
	}

	/**
	 * Crée un nouvel utilisateur en base.
	 * 
	 * @param u l'utilisateur à créer
	 * @return true si la création a réussi
	 */
	public static boolean createUtilisateur(Utilisateur u) {
		UtilisateurDao dao = new UtilisateurDao(Connexion.getInstance());
		return dao.create(u);
	}

	/**
	 * Supprime un utilisateur de la base.
	 * 
	 * @param u l'utilisateur à supprimer
	 * @return true si la suppression a réussi
	 */
	public static boolean deleteUtilisateur(Utilisateur u) {
		UtilisateurDao dao = new UtilisateurDao(Connexion.getInstance());
		return dao.delete(u);
	}

	// --- Frais hors forfait ---

	/**
	 * Retourne le nombre de fiches hors forfait pour un visiteur et un mois donné.
	 * 
	 * @param idVisiteur identifiant du visiteur
	 * @param moisFiltre numéro du mois
	 * @return nombre de fiches hors forfait
	 */
	public static int getNbFicheHorsForfaitParMois(String idVisiteur, int moisFiltre) {
		LigneFraisHorsForfaitDao dao = new LigneFraisHorsForfaitDao(Connexion.getInstance());
		return dao.nbFicheHorsForfaitParMois(idVisiteur, moisFiltre);
	}

	/**
	 * Retourne le montant total des frais hors forfait pour un visiteur et un mois donné.
	 * 
	 * @param idVisiteur identifiant du visiteur
	 * @param moisFiltre numéro du mois
	 * @return montant total des frais hors forfait
	 */
	public static double getMontantFraisHorsForfaitParMois(String idVisiteur, int moisFiltre) {
		LigneFraisHorsForfaitDao dao = new LigneFraisHorsForfaitDao(Connexion.getInstance());
		return dao.getMontantFraisHorsForfaitParMois(idVisiteur, moisFiltre);
	}

	/**
	 * Retourne la moyenne des frais hors forfait par région pour un mois donné.
	 * 
	 * @param moisFiltre numéro du mois
	 * @return liste de tableaux [région, moyenne]
	 */
	public static List<Object[]> getMoyenneFraisHorsForfaitParRegion(int moisFiltre) {
		LigneFraisHorsForfaitDao dao = new LigneFraisHorsForfaitDao(Connexion.getInstance());
		return dao.getMoyenneFraisHorsForfaitParRegion(moisFiltre);
	}

	// --- Frais forfait ---

	/**
	 * Retourne le montant total des frais forfait pour un visiteur et un mois donné.
	 * 
	 * @param idVisiteur identifiant du visiteur
	 * @param moisFiltre numéro du mois
	 * @return montant total des frais forfait
	 */
	public static double getMontantFraisForfaitParMois(String idVisiteur, int moisFiltre) {
		LigneFraisForfaitDao dao = new LigneFraisForfaitDao(Connexion.getInstance());
		return dao.getMontantFraisForfaitParMois(idVisiteur, moisFiltre);
	}

	/**
	 * Retourne la moyenne des frais forfait par région pour un mois donné.
	 * 
	 * @param moisFiltre numéro du mois
	 * @return liste de tableaux [région, moyenne]
	 */
	public static List<Object[]> getMoyenneFraisForfaitParRegion(int moisFiltre) {
		LigneFraisForfaitDao dao = new LigneFraisForfaitDao(Connexion.getInstance());
		return dao.getMoyenneFraisForfaitParRegion(moisFiltre);
	}

}
