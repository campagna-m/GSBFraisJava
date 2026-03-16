package DAO;

import java.sql.Connection;
import java.util.List;

import BDD.Connexion;
import POJO.LigneFraisForfait;

public class LigneFraisForfaitDAO extends DAO<LigneFraisForfait> {

	// Se connecter à la BDD
	static Connection conn = Connexion.getInstance();

	public LigneFraisForfaitDAO(Connection conn) {
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

	public LigneFraisForfait find(int id) {
		return null;
	}

	public List<LigneFraisForfait> findAll() {
		return null;
	}

}
