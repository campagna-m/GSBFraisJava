package dao;

import java.sql.Connection;
import java.util.List;

/**
 * Classe abstraite définissant les opérations CRUD communes à tous les DAO.
 * 
 * @param <T> type de l'objet métier (pojo)
 * @author Matthieu CAMPAGNA
 */
public abstract class Dao<T> {

	/** Connexion à la base de données. */
	protected Connection connect = null;

	/**
	 * Constructeur du DAO.
	 * 
	 * @param conn connexion à la base de données
	 */
	public Dao(Connection conn) {
		this.connect = conn;
	}

	/**
	 * Crée un objet en base.
	 * 
	 * @param obj objet à créer
	 * @return true si la création a réussi
	 */
	public abstract boolean create(T obj);

	/**
	 * Supprime un objet de la base.
	 * 
	 * @param obj objet à supprimer
	 * @return true si la suppression a réussi
	 */
	public abstract boolean delete(T obj);

	/**
	 * Met à jour un objet en base.
	 * 
	 * @param obj objet à modifier
	 * @return true si la mise à jour a réussi
	 */
	public abstract boolean update(T obj);

	/**
	 * Recherche un objet par son identifiant.
	 * 
	 * @param id identifiant de l'objet
	 * @return l'objet trouvé ou null
	 */
	public abstract T find(String id);

	/**
	 * Retourne tous les objets de la table.
	 * 
	 * @return liste de tous les objets
	 */
	public abstract List<T> findAll();

}
