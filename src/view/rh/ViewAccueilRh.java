package view.rh;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Écran d'accueil du service RH. Permet de consulter, modifier, créer et supprimer des visiteurs.
 *
 * @author Matthieu CAMPAGNA
 */
public class ViewAccueilRh extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnDeconnexion;
	private JButton btnConsulterFiche;
	private JButton btnModifier;
	private JButton btnEnregistrer;
	private JButton btnSupprimer;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAccueilRh frame = new ViewAccueilRh();
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
	public ViewAccueilRh() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnDeconnexion());
		contentPane.add(getBtnConsulterFiche());
		contentPane.add(getBtnModifier());
		contentPane.add(getBtnEnregistrer());
		contentPane.add(getBtnSupprimer());
		contentPane.add(getLblNewLabel());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Gestion des visiteurs");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
			lblNewLabel.setBounds(300, 50, 340, 40);
		}
		return lblNewLabel;
	}

	private JButton getBtnConsulterFiche() {
		if (btnConsulterFiche == null) {
			btnConsulterFiche = new JButton("Consulter fiche");
			btnConsulterFiche.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewRechercheFicheRh frame = new ViewRechercheFicheRh();
					frame.setVisible(true);
					dispose();
				}
			});
			btnConsulterFiche.setBounds(400, 200, 121, 30);
		}
		return btnConsulterFiche;
	}

	private JButton getBtnModifier() {
		if (btnModifier == null) {
			btnModifier = new JButton("Modifier");
			btnModifier.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewRechercheModifierRh frame = new ViewRechercheModifierRh();
					frame.setVisible(true);
					dispose();
				}
			});
			btnModifier.setBounds(400, 260, 120, 30);
		}
		return btnModifier;
	}

	private JButton getBtnEnregistrer() {
		if (btnEnregistrer == null) {
			btnEnregistrer = new JButton("Enregistrer");
			btnEnregistrer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewEnregistrerRh frame = new ViewEnregistrerRh();
					frame.setVisible(true);
					dispose();
				}
			});
			btnEnregistrer.setBounds(400, 320, 120, 30);
		}
		return btnEnregistrer;
	}

	private JButton getBtnSupprimer() {
		if (btnSupprimer == null) {
			btnSupprimer = new JButton("Supprimer");
			btnSupprimer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewRechercheSupprimerRh frame = new ViewRechercheSupprimerRh();
					frame.setVisible(true);
					dispose();
				}
			});
			btnSupprimer.setBounds(400, 380, 120, 30);
		}
		return btnSupprimer;
	}

	private JButton getBtnDeconnexion() {
		if (btnDeconnexion == null) {
			btnDeconnexion = new JButton("Déconnexion");
			btnDeconnexion.addActionListener(e -> System.exit(0));
			btnDeconnexion.setBounds(800, 600, 120, 30);
		}
		return btnDeconnexion;
	}
}
