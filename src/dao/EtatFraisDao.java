package dao;

import java.sql.Connection;
import java.util.List;
import bdd.Connexion;
import pojo.EtatFrais;

/**
 * DAO pour la table etatfrais (non implémenté).
 * 
 * @author Matthieu CAMPAGNA
 */
public class EtatFraisDao extends Dao<EtatFrais> {

	static Connection conn = Connexion.getInstance();

	public EtatFraisDao(Connection conn) {
		super(conn);
	}

	public boolean create(EtatFrais obj) {
		return false;
	}

	public boolean delete(EtatFrais obj) {
		return false;
	}

	public boolean update(EtatFrais obj) {
		return false;
	}

	public EtatFrais find(String id) {
		return null;
	}

	public List<EtatFrais> findAll() {
		return null;
	}

}
