package view.rh;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Date;
import java.time.LocalDate;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import bdd.AccesData;
import pojo.Role;
import pojo.Utilisateur;

/**
 * Écran de création d'un nouveau visiteur (RH).
 *
 * @author Matthieu CAMPAGNA
 */
public class ViewEnregistrerRh extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnValider;
	private JButton btnRetour;
	private JLabel lblTitre;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtLogin;
	private JTextField txtMdp;
	private JTextField txtDateEmbauche;
	private JTextField txtAdresse;
	private JTextField txtCp;
	private JTextField txtVille;
	private JComboBox<String> comboBoxRegion;
	private JTextField txtTelFixe;
	private JTextField txtTelPortable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEnregistrerRh frame = new ViewEnregistrerRh();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewEnregistrerRh() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNom = new JLabel("Nom *");
		lblNom.setBounds(40, 100, 200, 20);
		contentPane.add(lblNom);
		txtNom = new JTextField();
		txtNom.setBounds(40, 125, 200, 30);
		contentPane.add(txtNom);

		JLabel lblPrenom = new JLabel("Prénom *");
		lblPrenom.setBounds(280, 100, 200, 20);
		contentPane.add(lblPrenom);
		txtPrenom = new JTextField();
		txtPrenom.setBounds(280, 125, 200, 30);
		contentPane.add(txtPrenom);

		JLabel lblLogin = new JLabel("Login *");
		lblLogin.setBounds(520, 100, 200, 20);
		contentPane.add(lblLogin);
		txtLogin = new JTextField();
		txtLogin.setBounds(520, 125, 200, 30);
		contentPane.add(txtLogin);

		JLabel lblMdp = new JLabel("Mot de passe *");
		lblMdp.setBounds(760, 100, 200, 20);
		contentPane.add(lblMdp);
		txtMdp = new JTextField();
		txtMdp.setBounds(760, 125, 200, 30);
		contentPane.add(txtMdp);

		JLabel lblDateEmbauche = new JLabel("Date embauche (AAAA-MM-JJ) *");
		lblDateEmbauche.setBounds(40, 180, 200, 20);
		contentPane.add(lblDateEmbauche);
		txtDateEmbauche = new JTextField();
		txtDateEmbauche.setBounds(40, 205, 200, 30);
		contentPane.add(txtDateEmbauche);

		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(280, 180, 200, 20);
		contentPane.add(lblAdresse);
		txtAdresse = new JTextField();
		txtAdresse.setBounds(280, 205, 200, 30);
		contentPane.add(txtAdresse);

		JLabel lblCp = new JLabel("CP");
		lblCp.setBounds(520, 180, 200, 20);
		contentPane.add(lblCp);
		txtCp = new JTextField();
		txtCp.setBounds(520, 205, 200, 30);
		contentPane.add(txtCp);

		JLabel lblVille = new JLabel("Ville");
		lblVille.setBounds(760, 180, 200, 20);
		contentPane.add(lblVille);
		txtVille = new JTextField();
		txtVille.setBounds(760, 205, 200, 30);
		contentPane.add(txtVille);

		JLabel lblRegion = new JLabel("Région");
		lblRegion.setBounds(40, 260, 200, 20);
		contentPane.add(lblRegion);
		String[] regions = { "Sélectionner une région", "Bretagne", "Pays de la Loire", "Normandie", "Hauts-de-France",
				"Grand Est", "Île-de-France", "Centre-Val de Loire", "Bourgogne-Franche-Comté", "Nouvelle Aquitaine",
				"Auvergne Rhône-Alpes", "Occitanie", "Paca", "Corse" };
		comboBoxRegion = new JComboBox<>(regions);
		comboBoxRegion.setBounds(40, 285, 200, 30);
		contentPane.add(comboBoxRegion);

		JLabel lblTelF = new JLabel("Tél fixe");
		lblTelF.setBounds(280, 260, 200, 20);
		contentPane.add(lblTelF);
		txtTelFixe = new JTextField();
		txtTelFixe.setBounds(280, 285, 200, 30);
		contentPane.add(txtTelFixe);

		JLabel lblTelP = new JLabel("Tél portable");
		lblTelP.setBounds(520, 260, 200, 20);
		contentPane.add(lblTelP);
		txtTelPortable = new JTextField();
		txtTelPortable.setBounds(520, 285, 200, 30);
		contentPane.add(txtTelPortable);

		contentPane.add(getBtnValider());
		contentPane.add(getBtnRetour());
		contentPane.add(getLblTitre());
	}

	private JLabel getLblTitre() {
		if (lblTitre == null) {
			lblTitre = new JLabel("Enregistrer un nouveau visiteur");
			lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblTitre.setBounds(250, 30, 500, 40);
		}
		return lblTitre;
	}

	private JButton getBtnValider() {
		if (btnValider == null) {
			btnValider = new JButton("Enregistrer");
			btnValider.setBounds(450, 450, 120, 30);
			btnValider.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String nom = txtNom.getText();
					String prenom = txtPrenom.getText();
					String login = txtLogin.getText();
					String mdp = txtMdp.getText();
					String dateEmbaucheString = txtDateEmbauche.getText();

					boolean vide = false;
					if (nom.isEmpty())
						vide = true;
					if (prenom.isEmpty())
						vide = true;
					if (login.isEmpty())
						vide = true;
					if (mdp.isEmpty())
						vide = true;
					if (dateEmbaucheString.isEmpty())
						vide = true;

					if (vide == true) {
						JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs obligatoires (avec *).");
					} else {

						Date dateEmbaucheSql = null;
						boolean dateOk = true;

						try {
							dateEmbaucheSql = Date.valueOf(dateEmbaucheString);
						} catch (Exception ex) {
							dateOk = false;
						}

						if (dateOk == false) {
							JOptionPane.showMessageDialog(null,
									"Format de date invalide ! Merci d'utiliser le format AAAA-MM-JJ.");
						} else {

							String regionSelectionnee = "";
							int indexCombo = comboBoxRegion.getSelectedIndex();
							if (indexCombo > 0) {
								Object selection = comboBoxRegion.getSelectedItem();
								regionSelectionnee = selection.toString();
							}

							List<Utilisateur> tousLesUtilisateurs = AccesData.getTousLesUtilisateurs();

							String idAuto = "";
							boolean idExiste = true;

							while (idExiste == true) {

								String premiereLettre = nom.substring(0, 1);
								String lettreMinuscule = premiereLettre.toLowerCase();

								double nombreAleatoire = Math.random() * 1000;
								int nombreEntier = (int) nombreAleatoire;

								idAuto = lettreMinuscule + nombreEntier;

								idExiste = false;

								for (Utilisateur u : tousLesUtilisateurs) {
									String idExistant = u.getIdUtilisateur();
									if (idExistant.equals(idAuto)) {
										idExiste = true;
										break;
									}
								}
							}

							LocalDate dateJour = LocalDate.now();
							Date dateCreation = Date.valueOf(dateJour);

							String nomSansEspace = nom.replace(" ", "");
							String prenomSansEspace = prenom.replace(" ", "");

							String mailBrut = nomSansEspace + "." + prenomSansEspace + "@gsb.fr";
							String mailAuto = mailBrut.toLowerCase();

							Role roleSelectionne = new Role("VM", "Visiteur Médical");

							String adresse = txtAdresse.getText();
							String cp = txtCp.getText();
							String ville = txtVille.getText();
							String telF = txtTelFixe.getText();
							String telP = txtTelPortable.getText();

							Utilisateur nouveauUtilisateur = new Utilisateur(idAuto, roleSelectionne, nom, prenom,
									login, mdp, dateEmbaucheSql, adresse, cp, ville, regionSelectionnee, telF, telP,
									mailAuto, dateCreation);

							boolean creationOk = AccesData.createUtilisateur(nouveauUtilisateur);

							if (creationOk == true) {
								JOptionPane.showMessageDialog(null, "Visiteur créé avec succès !");
								viderChamps();
							} else {
								JOptionPane.showMessageDialog(null, "Erreur lors de la création.");
							}
						}
					}
				}
			});
		}
		return btnValider;
	}

	private void viderChamps() {
		txtNom.setText("");
		txtPrenom.setText("");
		txtLogin.setText("");
		txtMdp.setText("");
		txtDateEmbauche.setText("");
		txtAdresse.setText("");
		txtCp.setText("");
		txtVille.setText("");
		txtTelFixe.setText("");
		txtTelPortable.setText("");
		comboBoxRegion.setSelectedIndex(0);
	}

	private JButton getBtnRetour() {
		if (btnRetour == null) {
			btnRetour = new JButton("Retour");
			btnRetour.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewAccueilRh frame = new ViewAccueilRh();
					frame.setVisible(true);
					dispose();
				}
			});
			btnRetour.setBounds(800, 600, 120, 30);
		}
		return btnRetour;
	}
}