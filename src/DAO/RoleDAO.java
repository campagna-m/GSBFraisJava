package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BDD.Connexion;
import POJO.Role;
import POJO.Utilisateur;

public class RoleDAO extends DAO<Role> {

	// Se connecter à la BDD
	static Connection conn = Connexion.getInstance();

	// Constructeur
	public RoleDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Role obj) {
		return false;
	}

	public boolean delete(Role obj) {
		return false;
	}

	public boolean update(Role obj) {
		return false;
	}

	public Role find(int id) {
		try {
			Statement requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery("SELECT * FROM role Where id = '" + id + "'");

			if (resultat.next()) {

				Role roleRenvoi = new Role(resultat.getString("id"), resultat.getString("libelle"));

				return roleRenvoi;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Role> findAll() {
		List<Role> listeRole = new ArrayList<>();
		try {
			Statement requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery("SELECT * FROM role");

			while (resultat.next()) {

				Role r = new Role(resultat.getString("id"), resultat.getString("libelle"));

				listeRole.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeRole;
	}

}
