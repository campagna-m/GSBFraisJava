package view.directeur;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import bdd.AccesData;
import pojo.Utilisateur;

/**
 * Écran d'affichage de la fiche d'un visiteur en lecture seule (directeur).
 *
 * @author Matthieu CAMPAGNA
 */
public class ViewFicheDr extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnRetour;
	private JLabel lblTitre;
	private JLabel lblIdUtilisateur;
	private JTextField txtIdUtilisateur;
	private JLabel lblIdRole;
	private JTextField txtIdRole;
	private JLabel lblNom;
	private JTextField txtNom;
	private JLabel lblPrenom;
	private JTextField txtPrenom;
	private JLabel lblLogin;
	private JTextField txtLogin;
	private JLabel lblMdp;
	private JTextField txtMdp;
	private JLabel lblDateCreaMdp;
	private JTextField txtDateCreaMdp;
	private JLabel lblAdresse;
	private JTextField txtAdresse;
	private JLabel lblCp;
	private JTextField txtCp;
	private JLabel lblVille;
	private JTextField txtVille;
	private JLabel lblRegion;
	private JTextField txtRegion;
	private JLabel lblTelFixe;
	private JTextField txtTelFixe;
	private JLabel lblTelPortable;
	private JTextField txtTelPortable;
	private JLabel lblMail;
	private JTextField txtMail;
	private JLabel lblDateEmbauche;
	private JTextField txtDateEmbauche;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFicheDr frame = new ViewFicheDr();
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
	public ViewFicheDr() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnRetour());
		contentPane.add(getLblTitre());
		contentPane.add(getLblIdUtilisateur());
		contentPane.add(getTxtIdUtilisateur());
		contentPane.add(getLblIdRole());
		contentPane.add(getTxtIdRole());
		contentPane.add(getLblNom());
		contentPane.add(getTxtNom());
		contentPane.add(getLblPrenom());
		contentPane.add(getTxtPrenom());
		contentPane.add(getLblLogin());
		contentPane.add(getTxtLogin());
		contentPane.add(getLblMdp());
		contentPane.add(getTxtMdp());
		contentPane.add(getLblDateCreaMdp());
		contentPane.add(getTxtDateCreaMdp());
		contentPane.add(getLblAdresse());
		contentPane.add(getTxtAdresse());
		contentPane.add(getLblCp());
		contentPane.add(getTxtCp());
		contentPane.add(getLblVille());
		contentPane.add(getTxtVille());
		contentPane.add(getLblRegionField());
		contentPane.add(getTxtRegionField());
		contentPane.add(getLblTelFixe());
		contentPane.add(getTxtTelFixe());
		contentPane.add(getLblTelPortable());
		contentPane.add(getTxtTelPortable());
		contentPane.add(getLblMail());
		contentPane.add(getTxtMail());
		contentPane.add(getLblDateEmbauche());
		contentPane.add(getTxtDateEmbauche());
	}

	public void remplir(String idUtilisateur) {

		Utilisateur u = AccesData.getUtilisateurParId(idUtilisateur);

		if (u == null) {
			javax.swing.JOptionPane.showMessageDialog(this, "Utilisateur introuvable.");
			return;
		}

		txtIdUtilisateur.setText(u.getIdUtilisateur());

		if (u.getIdRole() != null) {
			txtIdRole.setText(u.getIdRole().getId());
		} else {
			txtIdRole.setText("");
		}

		txtNom.setText(u.getNom());
		txtPrenom.setText(u.getPrenom());
		txtLogin.setText(u.getLogin());
		txtMdp.setText(u.getMdp());

		if (u.getDateCreationMdp() != null) {
			txtDateCreaMdp.setText(u.getDateCreationMdp().toString());
		} else {
			txtDateCreaMdp.setText("");
		}

		txtAdresse.setText(u.getAdresse());
		txtCp.setText(u.getCp());
		txtVille.setText(u.getVille());
		txtRegion.setText(u.getRegion());
		txtTelFixe.setText(u.getTelephoneFixe());
		txtTelPortable.setText(u.getTelephonePortable());
		txtMail.setText(u.getMail());

		if (u.getDateEmbauche() != null) {
			txtDateEmbauche.setText(u.getDateEmbauche().toString());
		} else {
			txtDateEmbauche.setText("");
		}
	}

	private JLabel getLblTitre() {
		if (lblTitre == null) {
			lblTitre = new JLabel("Fiche du visiteur");
			lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblTitre.setBounds(350, 10, 250, 40);
		}
		return lblTitre;
	}

	private JLabel getLblIdUtilisateur() {
		if (lblIdUtilisateur == null) {
			lblIdUtilisateur = new JLabel("ID Utilisateur");
			lblIdUtilisateur.setBounds(40, 130, 200, 20);
		}
		return lblIdUtilisateur;
	}

	private JTextField getTxtIdUtilisateur() {
		if (txtIdUtilisateur == null) {
			txtIdUtilisateur = new JTextField();
			txtIdUtilisateur.setBounds(40, 155, 200, 30);
			txtIdUtilisateur.setEditable(false);
		}
		return txtIdUtilisateur;
	}

	private JLabel getLblIdRole() {
		if (lblIdRole == null) {
			lblIdRole = new JLabel("ID Rôle");
			lblIdRole.setBounds(280, 130, 200, 20);
		}
		return lblIdRole;
	}

	private JTextField getTxtIdRole() {
		if (txtIdRole == null) {
			txtIdRole = new JTextField();
			txtIdRole.setBounds(280, 155, 200, 30);
			txtIdRole.setEditable(false);
		}
		return txtIdRole;
	}

	private JLabel getLblNom() {
		if (lblNom == null) {
			lblNom = new JLabel("Nom");
			lblNom.setBounds(520, 130, 200, 20);
		}
		return lblNom;
	}

	private JTextField getTxtNom() {
		if (txtNom == null) {
			txtNom = new JTextField();
			txtNom.setBounds(520, 155, 200, 30);
			txtNom.setEditable(false);
		}
		return txtNom;
	}

	private JLabel getLblPrenom() {
		if (lblPrenom == null) {
			lblPrenom = new JLabel("Prénom");
			lblPrenom.setBounds(760, 130, 200, 20);
		}
		return lblPrenom;
	}

	private JTextField getTxtPrenom() {
		if (txtPrenom == null) {
			txtPrenom = new JTextField();
			txtPrenom.setBounds(760, 155, 200, 30);
			txtPrenom.setEditable(false);
		}
		return txtPrenom;
	}

	private JLabel getLblLogin() {
		if (lblLogin == null) {
			lblLogin = new JLabel("Login");
			lblLogin.setBounds(40, 210, 200, 20);
		}
		return lblLogin;
	}

	private JTextField getTxtLogin() {
		if (txtLogin == null) {
			txtLogin = new JTextField();
			txtLogin.setBounds(40, 235, 200, 30);
			txtLogin.setEditable(false);
		}
		return txtLogin;
	}

	private JLabel getLblMdp() {
		if (lblMdp == null) {
			lblMdp = new JLabel("Mot de passe");
			lblMdp.setBounds(280, 210, 200, 20);
		}
		return lblMdp;
	}

	private JTextField getTxtMdp() {
		if (txtMdp == null) {
			txtMdp = new JTextField();
			txtMdp.setBounds(280, 235, 200, 30);
			txtMdp.setEditable(false);
		}
		return txtMdp;
	}

	private JLabel getLblDateCreaMdp() {
		if (lblDateCreaMdp == null) {
			lblDateCreaMdp = new JLabel("Date de création mdp");
			lblDateCreaMdp.setBounds(520, 210, 200, 20);
		}
		return lblDateCreaMdp;
	}

	private JTextField getTxtDateCreaMdp() {
		if (txtDateCreaMdp == null) {
			txtDateCreaMdp = new JTextField();
			txtDateCreaMdp.setBounds(520, 235, 200, 30);
			txtDateCreaMdp.setEditable(false);
		}
		return txtDateCreaMdp;
	}

	private JLabel getLblAdresse() {
		if (lblAdresse == null) {
			lblAdresse = new JLabel("Adresse");
			lblAdresse.setBounds(760, 210, 200, 20);
		}
		return lblAdresse;
	}

	private JTextField getTxtAdresse() {
		if (txtAdresse == null) {
			txtAdresse = new JTextField();
			txtAdresse.setBounds(760, 235, 200, 30);
			txtAdresse.setEditable(false);
		}
		return txtAdresse;
	}

	private JLabel getLblCp() {
		if (lblCp == null) {
			lblCp = new JLabel("CP");
			lblCp.setBounds(40, 290, 200, 20);
		}
		return lblCp;
	}

	private JTextField getTxtCp() {
		if (txtCp == null) {
			txtCp = new JTextField();
			txtCp.setBounds(40, 315, 200, 30);
			txtCp.setEditable(false);
		}
		return txtCp;
	}

	private JLabel getLblVille() {
		if (lblVille == null) {
			lblVille = new JLabel("Ville");
			lblVille.setBounds(280, 290, 200, 20);
		}
		return lblVille;
	}

	private JTextField getTxtVille() {
		if (txtVille == null) {
			txtVille = new JTextField();
			txtVille.setBounds(280, 315, 200, 30);
			txtVille.setEditable(false);
		}
		return txtVille;
	}

	private JLabel getLblRegionField() {
		if (lblRegion == null) {
			lblRegion = new JLabel("Région");
			lblRegion.setBounds(520, 290, 200, 20);
		}
		return lblRegion;
	}

	private JTextField getTxtRegionField() {
		if (txtRegion == null) {
			txtRegion = new JTextField();
			txtRegion.setBounds(520, 315, 200, 30);
			txtRegion.setEditable(false);
		}
		return txtRegion;
	}

	private JLabel getLblTelFixe() {
		if (lblTelFixe == null) {
			lblTelFixe = new JLabel("Tél fixe");
			lblTelFixe.setBounds(760, 290, 200, 20);
		}
		return lblTelFixe;
	}

	private JTextField getTxtTelFixe() {
		if (txtTelFixe == null) {
			txtTelFixe = new JTextField();
			txtTelFixe.setBounds(760, 315, 200, 30);
			txtTelFixe.setEditable(false);
		}
		return txtTelFixe;
	}

	private JLabel getLblTelPortable() {
		if (lblTelPortable == null) {
			lblTelPortable = new JLabel("Tél portable");
			lblTelPortable.setBounds(40, 370, 200, 20);
		}
		return lblTelPortable;
	}

	private JTextField getTxtTelPortable() {
		if (txtTelPortable == null) {
			txtTelPortable = new JTextField();
			txtTelPortable.setBounds(40, 395, 200, 30);
			txtTelPortable.setEditable(false);
		}
		return txtTelPortable;
	}

	private JLabel getLblMail() {
		if (lblMail == null) {
			lblMail = new JLabel("Mail");
			lblMail.setBounds(280, 370, 200, 20);
		}
		return lblMail;
	}

	private JTextField getTxtMail() {
		if (txtMail == null) {
			txtMail = new JTextField();
			txtMail.setBounds(280, 395, 200, 30);
			txtMail.setEditable(false);
		}
		return txtMail;
	}

	private JLabel getLblDateEmbauche() {
		if (lblDateEmbauche == null) {
			lblDateEmbauche = new JLabel("Date d'embauche");
			lblDateEmbauche.setBounds(520, 370, 200, 20);
		}
		return lblDateEmbauche;
	}

	private JTextField getTxtDateEmbauche() {
		if (txtDateEmbauche == null) {
			txtDateEmbauche = new JTextField();
			txtDateEmbauche.setBounds(520, 395, 200, 30);
			txtDateEmbauche.setEditable(false);
		}
		return txtDateEmbauche;
	}

	private JButton getBtnRetour() {
		if (btnRetour == null) {
			btnRetour = new JButton("Retour");
			btnRetour.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewRechercheFicheDr frame = new ViewRechercheFicheDr();
					frame.setVisible(true);
					dispose();
				}
			});
			btnRetour.setBounds(800, 600, 120, 30);
		}
		return btnRetour;
	}
}