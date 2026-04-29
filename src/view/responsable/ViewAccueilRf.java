package view.responsable;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Écran d'accueil du responsable. Donne accès aux statistiques des frais.
 *
 * @author Matthieu CAMPAGNA
 */
public class ViewAccueilRf extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTitre;
	private JButton btnNbFicheHorsForfait;
	private JButton btnMontantHorsForfait;
	private JButton btnMontantForfait;
	private JButton btnMoyenneForfait;
	private JButton btnMoyenneHorsForfait;
	private JButton btnDeconnexion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAccueilRf frame = new ViewAccueilRf();
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
	public ViewAccueilRf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.add(getLblTitre());
		contentPane.add(getBtnNbFicheHorsForfait());
		contentPane.add(getBtnMontantHorsForfait());
		contentPane.add(getBtnMontantForfait());
		contentPane.add(getBtnMoyenneForfait());
		contentPane.add(getBtnMoyenneHorsForfait());
		contentPane.add(getBtnDeconnexion());
	}

	private JLabel getLblTitre() {
		if (lblTitre == null) {
			lblTitre = new JLabel("Gérer les statistiques");
			lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 36));
			lblTitre.setBounds(325, 50, 350, 40);
		}
		return lblTitre;
	}

	private JButton getBtnNbFicheHorsForfait() {
		if (btnNbFicheHorsForfait == null) {
			btnNbFicheHorsForfait = new JButton("Nombre Fiche Frais Hors Forfait Region Mois Visiteur");
			btnNbFicheHorsForfait.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewFicheHorsForfait frame = new ViewFicheHorsForfait();
					frame.setVisible(true);
					dispose();
				}
			});
			btnNbFicheHorsForfait.setBounds(275, 120, 450, 30);
		}
		return btnNbFicheHorsForfait;
	}

	private JButton getBtnMontantHorsForfait() {
		if (btnMontantHorsForfait == null) {
			btnMontantHorsForfait = new JButton("Montant Frais Hors Forfait Region Mois Visiteur");
			btnMontantHorsForfait.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewMontantHorsForfait frame = new ViewMontantHorsForfait();
					frame.setVisible(true);
					dispose();
				}
			});
			btnMontantHorsForfait.setBounds(275, 180, 450, 30);
		}
		return btnMontantHorsForfait;
	}

	private JButton getBtnMontantForfait() {
		if (btnMontantForfait == null) {
			btnMontantForfait = new JButton("Montant Frais Forfait Region Mois Visiteur");
			btnMontantForfait.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewMontantForfait frame = new ViewMontantForfait();
					frame.setVisible(true);
					dispose();
				}
			});
			btnMontantForfait.setBounds(275, 240, 450, 30);
		}
		return btnMontantForfait;
	}

	private JButton getBtnMoyenneForfait() {
		if (btnMoyenneForfait == null) {
			btnMoyenneForfait = new JButton("Moyenne Montant Frais Forfait Mois Region");
			btnMoyenneForfait.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewMoyenneForfait frame = new ViewMoyenneForfait();
					frame.setVisible(true);
					dispose();
				}
			});
			btnMoyenneForfait.setBounds(275, 300, 450, 30);
		}
		return btnMoyenneForfait;
	}

	private JButton getBtnMoyenneHorsForfait() {
		if (btnMoyenneHorsForfait == null) {
			btnMoyenneHorsForfait = new JButton("Moyenne Montant Frais Hors Forfait Mois Region");
			btnMoyenneHorsForfait.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewMoyenneHorsForfait frame = new ViewMoyenneHorsForfait();
					frame.setVisible(true);
					dispose();
				}
			});
			btnMoyenneHorsForfait.setBounds(275, 360, 450, 30);
		}
		return btnMoyenneHorsForfait;
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