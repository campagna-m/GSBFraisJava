package DAO;

import java.sql.Connection;
import java.util.List;

import BDD.Connexion;
import POJO.EtatFrais;

public class EtatFraisDAO extends DAO<EtatFrais> {

	// Se connecter à la BDD
	static Connection conn = Connexion.getInstance();

	// Constructeur
	public EtatFraisDAO(Connection conn) {
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

	public EtatFrais find(int id) {
		return null;
	}

	public List<EtatFrais> findAll() {
		return null;
	}

}
