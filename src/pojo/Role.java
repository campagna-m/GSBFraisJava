package pojo;

/**
 * Représente un rôle utilisateur (ex: VM, CO, RH, DR).
 * 
 * @author Matthieu CAMPAGNA
 */
public class Role {

	private String id;
	private String libelle;

	/**
	 * Constructeur de Role.
	 * 
	 * @param id      identifiant du rôle
	 * @param libelle libellé du rôle
	 */
	public Role(String id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String toString() {
		return id + libelle;
	}

}
