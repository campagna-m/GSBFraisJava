package POJO;

public class LigneFraisForfait {

	// Déclaration
	private FicheFrais idFiche;
	private String idFraisForfait;
	private int quantite;

	// Constructeur
	public LigneFraisForfait(FicheFrais idFiche, String idFraisForfait, int quantite) {
		this.idFiche = idFiche;
		this.idFraisForfait = idFraisForfait;
		this.quantite = quantite;
	}

	// Getters & Setters
	public FicheFrais getIdFiche() {
		return idFiche;
	}

	public void setIdFiche(FicheFrais idFiche) {
		this.idFiche = idFiche;
	}

	public String getIdFraisForfait() {
		return idFraisForfait;
	}

	public void setIdFraisForfait(String idFraisForfait) {
		this.idFraisForfait = idFraisForfait;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	// toString
	public String toString() {
		return idFiche + idFraisForfait + quantite;
	}

}
