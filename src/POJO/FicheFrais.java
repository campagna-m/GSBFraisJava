package POJO;

import java.math.BigDecimal;
import java.sql.Date;

public class FicheFrais {

	// Déclaration
	private Long idFiche; // Long = "bigint"
	private Utilisateur idVisiteur;
	private BigDecimal annee; // BigDecimal = "decimal"
	private BigDecimal mois;
	private int nbJustificatis;
	private BigDecimal montantValide;
	private Date dateModif;
	private String idEtat;

	// Constructeur
	public FicheFrais(Long idFiche, Utilisateur idVisiteur, BigDecimal annee, BigDecimal mois, int nbJustificatis,
			BigDecimal montantValide, Date dateModif, String idEtat) {
		this.idFiche = idFiche;
		this.idVisiteur = idVisiteur;
		this.annee = annee;
		this.mois = mois;
		this.nbJustificatis = nbJustificatis;
		this.montantValide = montantValide;
		this.dateModif = dateModif;
		this.idEtat = idEtat;
	}

	// Getters & Setters
	public Long getIdFiche() {
		return idFiche;
	}

	public void setIdFiche(Long idFiche) {
		this.idFiche = idFiche;
	}

	public Utilisateur getIdVisiteur() {
		return idVisiteur;
	}

	public void setIdVisiteur(Utilisateur idVisiteur) {
		this.idVisiteur = idVisiteur;
	}

	public BigDecimal getAnnee() {
		return annee;
	}

	public void setAnnee(BigDecimal annee) {
		this.annee = annee;
	}

	public BigDecimal getMois() {
		return mois;
	}

	public void setMois(BigDecimal mois) {
		this.mois = mois;
	}

	public int getNbJustificatis() {
		return nbJustificatis;
	}

	public void setNbJustificatis(int nbJustificatis) {
		this.nbJustificatis = nbJustificatis;
	}

	public BigDecimal getMontantValide() {
		return montantValide;
	}

	public void setMontantValide(BigDecimal montantValide) {
		this.montantValide = montantValide;
	}

	public Date getDateModif() {
		return dateModif;
	}

	public void setDateModif(Date dateModif) {
		this.dateModif = dateModif;
	}

	public String getIdEtat() {
		return idEtat;
	}

	public void setIdEtat(String idEtat) {
		this.idEtat = idEtat;
	}

	// toString
	public String toString() {
	    return idFiche + idVisiteur.toString() + annee + mois + nbJustificatis + montantValide + dateModif + idEtat;
	}

}
