package dao;

import java.sql.Connection;
import java.util.List;
import bdd.Connexion;
import pojo.FraisForfait;

/**
 * DAO pour la table fraisforfait (non implémenté).
 * 
 * @author Matthieu CAMPAGNA
 */
public class FraisForfaitDao extends Dao<FraisForfait> {

	static Connection conn = Connexion.getInstance();

	public FraisForfaitDao(Connection conn) {
		super(conn);
	}

	public boolean create(FraisForfait obj) {
		return false;
	}

	public boolean delete(FraisForfait obj) {
		return false;
	}

	public boolean update(FraisForfait obj) {
		return false;
	}

	public FraisForfait find(String id) {
		return null;
	}

	public List<FraisForfait> findAll() {
		return null;
	}

}
