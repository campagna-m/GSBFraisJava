package POJO;

import java.sql.Date;

public class Utilisateur {

	// Déclaration
	private String idUtilisateur;
	private Role idRole;
	private String nom;
	private String prenom;
	private String login;
	private String mdp;
	private Date dateCreationMdp;
	private String adresse;
	private String cp;
	private String ville;
	private String region;
	private String telephoneFixe;
	private String telephonePortable;
	private String mail;
	private Date dateEmbauche;
	
	// Constructeur
	public Utilisateur(String idUtilisateur, Role idRole, String nom, String prenom, String login, String mdp,
			Date dateCreationMdp, String adresse, String cp, String ville, String region, String telephoneFixe,
			String telephonePortable, String mail, Date dateEmbauche) {
		this.idUtilisateur = idUtilisateur;
		this.idRole = idRole;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
		this.dateCreationMdp = dateCreationMdp;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.region = region;
		this.telephoneFixe = telephoneFixe;
		this.telephonePortable = telephonePortable;
		this.mail = mail;
		this.dateEmbauche = dateEmbauche;
	}

	// Getters & Setters
	public String getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(String idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Role getIdRole() {
		return idRole;
	}

	public void setIdRole(Role idRole) {
		this.idRole = idRole;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Date getDateCreationMdp() {
		return dateCreationMdp;
	}

	public void setDateCreationMdp(Date dateCreationMdp) {
		this.dateCreationMdp = dateCreationMdp;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTelephoneFixe() {
		return telephoneFixe;
	}

	public void setTelephoneFixe(String telephoneFixe) {
		this.telephoneFixe = telephoneFixe;
	}

	public String getTelephonePortable() {
		return telephonePortable;
	}

	public void setTelephonePortable(String telephonePortable) {
		this.telephonePortable = telephonePortable;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	// toString
	public String toString() {
		return idUtilisateur + idRole + nom 
				+ prenom + login + mdp + dateCreationMdp + 
				adresse + cp + ville + region 
				+ telephoneFixe + telephonePortable + mail
				+ dateEmbauche;
	}

}
