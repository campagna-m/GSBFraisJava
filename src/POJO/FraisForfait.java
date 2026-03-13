package POJO;

import java.math.BigDecimal;

public class FraisForfait {

	// Déclaration
	private LigneFraisForfait idFraisFortfait;
	private String libelle;
	private BigDecimal montant; // BigDecimal = "decimal"

	// Constructeur
	public FraisForfait(LigneFraisForfait idFraisFortfait, String libelle, BigDecimal montant) {
		this.idFraisFortfait = idFraisFortfait;
		this.libelle = libelle;
		this.montant = montant;
	}

	// Getters & Setters
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

	// toString
	public String toString() {
		return idFraisFortfait + libelle + montant;
	}

}
