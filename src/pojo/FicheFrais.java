package pojo;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Représente une fiche de frais d'un visiteur pour un mois donné.
 * 
 * @author Matthieu CAMPAGNA
 */
public class FicheFrais {

	private Long idFiche;
	private Utilisateur idVisiteur;
	private BigDecimal annee;
	private BigDecimal mois;
	private int nbJustificatis;
	private BigDecimal montantValide;
	private Date dateModif;
	private String idEtat;

	/**
	 * Constructeur de FicheFrais.
	 * 
	 * @param idFiche        identifiant de la fiche
	 * @param idVisiteur     visiteur propriétaire de la fiche
	 * @param annee          année de la fiche
	 * @param mois           mois de la fiche
	 * @param nbJustificatis nombre de justificatifs reçus
	 * @param montantValide  montant validé de la fiche
	 * @param dateModif      date de dernière modification
	 * @param idEtat         code de l'état (CR, CL, VA, RB)
	 */
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

	public String toString() {
	    return idFiche + idVisiteur.toString() + annee + mois + nbJustificatis + montantValide + dateModif + idEtat;
	}

}
