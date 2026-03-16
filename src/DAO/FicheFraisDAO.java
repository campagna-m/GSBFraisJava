package DAO;

import java.sql.Connection;
import java.util.List;

import BDD.Connexion;
import POJO.FicheFrais;

public class FicheFraisDAO extends DAO<FicheFrais> {

	// Se connecter à la BDD
	static Connection conn = Connexion.getInstance();

	public FicheFraisDAO(Connection conn) {
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

	public FicheFrais find(int id) {
		return null;
	}

	public List<FicheFrais> findAll() {
		return null;
	}
}
