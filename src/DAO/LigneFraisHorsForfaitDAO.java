package DAO;

import java.sql.Connection;
import java.util.List;

import BDD.Connexion;
import POJO.LigneFraisHorsForfait;

public class LigneFraisHorsForfaitDAO extends DAO<LigneFraisHorsForfait>  {

	// Se connecter à la BDD
	static Connection conn = Connexion.getInstance();
	
	// Constructeur
	public LigneFraisHorsForfaitDAO(Connection conn) {
		super(conn);
	}

	public boolean create(LigneFraisHorsForfait obj) {
		return false;
	}

	public boolean delete(LigneFraisHorsForfait obj) {
		return false;
	}

	public boolean update(LigneFraisHorsForfait obj) {
		return false;
	}

	public LigneFraisHorsForfait find(int id) {
		return null;
	}

	public List<LigneFraisHorsForfait> findAll() {
		return null;
	}

}
