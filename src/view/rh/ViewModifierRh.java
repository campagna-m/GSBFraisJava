package view.rh;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bdd.AccesData;
import pojo.Utilisateur;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

/**
 * Écran de modification des coordonnées d'un visiteur (RH).
 *
 * @author Matthieu CAMPAGNA
 */
public class ViewModifierRh extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnValider;
	private JButton btnRetour;
	private JLabel lblTitre;

	private JLabel lblAdresse;
	private JTextField txtAdresse;
	private JLabel lblCp;
	private JTextField txtCp;
	private JLabel lblVille;
	private JTextField txtVille;
	private JLabel lblRegion;
	private JComboBox<String> comboBoxRegion;
	private JLabel lblTelFixe;
	private JTextField txtTelFixe;
	private JLabel lblTelPortable;
	private JTextField txtTelPortable;

	private String idUtilisateurSelectionne = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewModifierRh frame = new ViewModifierRh();
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
	public ViewModifierRh() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.add(getBtnValider());
		contentPane.add(getBtnRetour());
		contentPane.add(getLblTitre());
		contentPane.add(getLblAdresse());
		contentPane.add(getTxtAdresse());
		contentPane.add(getLblCp());
		contentPane.add(getTxtCp());
		contentPane.add(getLblVille());
		contentPane.add(getTxtVille());
		contentPane.add(getLblRegion());
		contentPane.add(getComboBoxRegion());
		contentPane.add(getLblTelFixe());
		contentPane.add(getTxtTelFixe());
		contentPane.add(getLblTelPortable());
		contentPane.add(getTxtTelPortable());
	}

	public void remplir(String idUtilisateur) {
		idUtilisateurSelectionne = idUtilisateur;

		Utilisateur u = AccesData.getUtilisateurParId(idUtilisateurSelectionne);

		if (u != null) {
			txtAdresse.setText(u.getAdresse());
			txtCp.setText(u.getCp());
			txtVille.setText(u.getVille());
			comboBoxRegion.setSelectedItem(u.getRegion());
			txtTelFixe.setText(u.getTelephoneFixe());
			txtTelPortable.setText(u.getTelephonePortable());
		}
	}

	private JLabel getLblTitre() {
		if (lblTitre == null) {
			lblTitre = new JLabel("Modifier le visiteur");
			lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblTitre.setBounds(350, 15, 250, 40);
		}
		return lblTitre;
	}

	private JLabel getLblAdresse() {
		if (lblAdresse == null) {
			lblAdresse = new JLabel("Adresse");
			lblAdresse.setBounds(40, 180, 200, 20);
		}
		return lblAdresse;
	}

	private JTextField getTxtAdresse() {
		if (txtAdresse == null) {
			txtAdresse = new JTextField();
			txtAdresse.setBounds(40, 205, 200, 30);
		}
		return txtAdresse;
	}

	private JLabel getLblCp() {
		if (lblCp == null) {
			lblCp = new JLabel("CP");
			lblCp.setBounds(280, 180, 200, 20);
		}
		return lblCp;
	}

	private JTextField getTxtCp() {
		if (txtCp == null) {
			txtCp = new JTextField();
			txtCp.setBounds(280, 205, 200, 30);
		}
		return txtCp;
	}

	private JLabel getLblVille() {
		if (lblVille == null) {
			lblVille = new JLabel("Ville");
			lblVille.setBounds(520, 180, 200, 20);
		}
		return lblVille;
	}

	private JTextField getTxtVille() {
		if (txtVille == null) {
			txtVille = new JTextField();
			txtVille.setBounds(520, 205, 200, 30);
		}
		return txtVille;
	}

	private JLabel getLblRegion() {
		if (lblRegion == null) {
			lblRegion = new JLabel("Région");
			lblRegion.setBounds(760, 180, 200, 20);
		}
		return lblRegion;
	}

	private JComboBox<String> getComboBoxRegion() {
		if (comboBoxRegion == null) {
			String[] regions = { "Sélectionner une région", "Bretagne", "Pays de la Loire", "Normandie",
					"Hauts-de-France", "Grand Est", "Île-de-France", "Centre-Val de Loire", "Bourgogne-Franche-Comté",
					"Nouvelle Aquitaine", "Auvergne Rhône-Alpes", "Occitanie", "Paca", "Corse" };
			comboBoxRegion = new JComboBox<>(regions);
			comboBoxRegion.setBounds(760, 205, 200, 30);
		}
		return comboBoxRegion;
	}

	private JLabel getLblTelFixe() {
		if (lblTelFixe == null) {
			lblTelFixe = new JLabel("Tél fixe");
			lblTelFixe.setBounds(40, 260, 200, 20);
		}
		return lblTelFixe;
	}

	private JTextField getTxtTelFixe() {
		if (txtTelFixe == null) {
			txtTelFixe = new JTextField();
			txtTelFixe.setBounds(40, 285, 200, 30);
		}
		return txtTelFixe;
	}

	private JLabel getLblTelPortable() {
		if (lblTelPortable == null) {
			lblTelPortable = new JLabel("Tél portable");
			lblTelPortable.setBounds(280, 260, 200, 20);
		}
		return lblTelPortable;
	}

	private JTextField getTxtTelPortable() {
		if (txtTelPortable == null) {
			txtTelPortable = new JTextField();
			txtTelPortable.setBounds(280, 285, 200, 30);
		}
		return txtTelPortable;
	}

	private JButton getBtnValider() {
		if (btnValider == null) {
			btnValider = new JButton("Valider les modifications");
			btnValider.setBounds(400, 350, 200, 30);
			btnValider.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					boolean vide = idUtilisateurSelectionne.isEmpty();
					
					if (vide == true) {
						JOptionPane.showMessageDialog(null, "Erreur : Aucun visiteur chargé.");
					} else {
						Utilisateur u = AccesData.getUtilisateurParId(idUtilisateurSelectionne);

						String adresse = txtAdresse.getText();
						u.setAdresse(adresse);

						String cp = txtCp.getText();
						u.setCp(cp);

						String ville = txtVille.getText();
						u.setVille(ville);

						Object selection = comboBoxRegion.getSelectedItem();
						String region = selection.toString();
						u.setRegion(region);

						String telFixe = txtTelFixe.getText();
						u.setTelephoneFixe(telFixe);

						String telPortable = txtTelPortable.getText();
						u.setTelephonePortable(telPortable);

						boolean ok = AccesData.updateUtilisateur(u);

						if (ok == true) {
							JOptionPane.showMessageDialog(null, "Modifications enregistrées avec succès !");
						} else {
							JOptionPane.showMessageDialog(null, "Erreur lors de la mise à jour.");
						}
					}
				}
			});
		}
		return btnValider;
	}

	private JButton getBtnRetour() {
		if (btnRetour == null) {
			btnRetour = new JButton("Retour");
			btnRetour.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewRechercheModifierRh frame = new ViewRechercheModifierRh();
					frame.setVisible(true);
					dispose();
				}
			});
			btnRetour.setBounds(800, 600, 120, 30);
		}
		return btnRetour;
	}
}