package pojo;

/**
 * Représente une ligne de frais forfait associée à une fiche de frais.
 * 
 * @author Matthieu CAMPAGNA
 */
public class LigneFraisForfait {

	private FicheFrais idFiche;
	private String idFraisForfait;
	private int quantite;

	/**
	 * Constructeur de LigneFraisForfait.
	 * 
	 * @param idFiche        fiche de frais associée
	 * @param idFraisForfait identifiant du type de frais forfait
	 * @param quantite       quantité saisie
	 */
	public LigneFraisForfait(FicheFrais idFiche, String idFraisForfait, int quantite) {
		this.idFiche = idFiche;
		this.idFraisForfait = idFraisForfait;
		this.quantite = quantite;
	}

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

	public String toString() {
		return idFiche + idFraisForfait + quantite;
	}

}
