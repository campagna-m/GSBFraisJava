package POJO;

public class Role {

	// Déclaration
	private String id;
	private String libelle;

	// Constructeur
	public Role(String id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	// Getters & Setters
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

	// toString
	public String toString() {
		return id + libelle;
	}

}
