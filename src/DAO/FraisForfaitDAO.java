package DAO;

import java.sql.Connection;
import java.util.List;

import BDD.Connexion;
import POJO.FraisForfait;

public class FraisForfaitDAO extends DAO<FraisForfait> {

	// Se connecter à la BDD
	static Connection conn = Connexion.getInstance();

	public FraisForfaitDAO(Connection conn) {
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

	public FraisForfait find(int id) {
		return null;
	}

	public List<FraisForfait> findAll() {
		return null;
	}

}
