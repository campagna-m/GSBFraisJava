package pojo;

import java.math.BigDecimal;

/**
 * Représente un type de frais forfait (ex: étape, kilométrage, nuitée, repas).
 * 
 * @author Matthieu CAMPAGNA
 */
public class FraisForfait {

	private LigneFraisForfait idFraisFortfait;
	private String libelle;
	private BigDecimal montant;

	/**
	 * Constructeur de FraisForfait.
	 * 
	 * @param idFraisFortfait ligne de frais forfait associée
	 * @param libelle         libellé du frais forfait
	 * @param montant         montant unitaire du frais
	 */
	public FraisForfait(LigneFraisForfait idFraisFortfait, String libelle, BigDecimal montant) {
		this.idFraisFortfait = idFraisFortfait;
		this.libelle = libelle;
		this.montant = montant;
	}

	public LigneFraisForfait getIdFraisFortfait() {
		return idFraisFortfait;
	}

	public void setIdFraisFortfait(LigneFraisForfait idFraisFortfait) {
		this.idFraisFortfait = idFraisFortfait;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public String toString() {
		return idFraisFortfait + libelle + montant;
	}

}
