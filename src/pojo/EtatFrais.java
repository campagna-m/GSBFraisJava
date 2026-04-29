package pojo;

/**
 * Représente un état de fiche de frais (CR, CL, VA, RB).
 * 
 * @author Matthieu CAMPAGNA
 */
public class EtatFrais {

	private FicheFrais idEtat;
	private String libelle;

	/**
	 * Constructeur de EtatFrais.
	 * 
	 * @param idEtat  fiche de frais associée
	 * @param libelle libellé de l'état
	 */
	public EtatFrais(FicheFrais idEtat, String libelle) {
		this.idEtat = idEtat;
		this.libelle = libelle;
	}

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

	public String toString() {
		return idEtat + libelle;
	}

}
