package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BDD.Connexion;
import POJO.Role;
import POJO.Utilisateur;

public class UtilisateurDAO extends DAO<Utilisateur> {

	// Se connecter à la BDD
	static Connection conn = Connexion.getInstance();

	// Constructeur
	public UtilisateurDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Utilisateur obj) {
		return false;
	}

	public boolean delete(Utilisateur obj) {
		return false;
	}

	public boolean update(Utilisateur obj) {
		return false;
	}

	public Utilisateur find(int id) {
		return null;
	}

	public List<Utilisateur> findAll() {
		return null;
	}

}
