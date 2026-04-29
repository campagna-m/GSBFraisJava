package pojo;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Représente une ligne de frais hors forfait associée à une fiche de frais.
 * 
 * @author Matthieu CAMPAGNA
 */
public class LigneFraisHorsForfait {

	private int idLigneFHF;
	private FicheFrais idFiche;
	private String libelle;
	private Date dateFrais;
	private BigDecimal montant;

	/**
	 * Constructeur de LigneFraisHorsForfait.
	 * 
	 * @param idLigneFHF identifiant de la ligne hors forfait
	 * @param idFiche    fiche de frais associée
	 * @param libelle    libellé du frais
	 * @param dateFrais  date du frais
	 * @param montant    montant du frais
	 */
	public LigneFraisHorsForfait(int idLigneFHF, FicheFrais idFiche, String libelle, Date dateFrais,
			BigDecimal montant) {
		this.idLigneFHF = idLigneFHF;
		this.idFiche = idFiche;
		this.libelle = libelle;
		this.dateFrais = dateFrais;
		this.montant = montant;
	}

	public int getIdLigneFHF() {
		return idLigneFHF;
	}

	public void setIdLigneFHF(int idLigneFHF) {
		this.idLigneFHF = idLigneFHF;
	}

	public FicheFrais getIdFiche() {
		return idFiche;
	}

	public void setIdFiche(FicheFrais idFiche) {
		this.idFiche = idFiche;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Date getDateFrais() {
		return dateFrais;
	}

	public void setDateFrais(Date dateFrais) {
		this.dateFrais = dateFrais;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public String toString() {
		return idLigneFHF + idFiche.toString() + libelle + dateFrais + montant;
	}

}
