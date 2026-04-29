package dao;

import java.sql.Connection;
import java.util.List;
import bdd.Connexion;
import pojo.FicheFrais;

/**
 * DAO pour la table fichefrais (non implémenté).
 * 
 * @author Matthieu CAMPAGNA
 */
public class FicheFraisDao extends Dao<FicheFrais> {

	static Connection conn = Connexion.getInstance();

	public FicheFraisDao(Connection conn) {
		super(conn);
	}

	public boolean create(FicheFrais obj) {
		return false;
	}

	public boolean delete(FicheFrais obj) {
		return false;
	}

	public boolean update(FicheFrais obj) {
		return false;
	}

	public FicheFrais find(String id) {
		return null;
	}

	public List<FicheFrais> findAll() {
		return null;
	}

}
