package POJO;

public class EtatFrais {

	// Déclaration
	private FicheFrais idEtat;
	private String libelle;
	
	// Constructeur
	public EtatFrais(FicheFrais idEtat, String libelle) {
		this.idEtat = idEtat;
		this.libelle = libelle;
	}

	// Getters & Setters
	public FicheFrais getIdEtat() {
		return idEtat;
	}

	public void setIdEtat(FicheFrais idEtat) {
		this.idEtat = idEtat;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	// toString
	public String toString() {
		return idEtat + libelle;
	}
	
}
