package dao;

import java.sql.Connection;
import java.util.List;
import bdd.Connexion;
import pojo.Role;

/**
 * DAO pour la table role (non implémenté).
 * 
 * @author Matthieu CAMPAGNA
 */
public class RoleDao extends Dao<Role> {

	static Connection conn = Connexion.getInstance();

	public RoleDao(Connection conn) {
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

	public Role find(String id) {
		return null;
	}

	public List<Role> findAll() {
		return null;
	}

}
