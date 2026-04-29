package view.directeur;

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
 * Écran d'accueil du directeur. Permet de consulter les fiches visiteurs.
 *
 * @author Matthieu CAMPAGNA
 */
public class ViewAccueilDr extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnDeconnexion;
	private JButton btnConsulterFiche;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAccueilDr frame = new ViewAccueilDr();
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
	public ViewAccueilDr() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnDeconnexion());
		contentPane.add(getBtnConsulterFiche());
		contentPane.add(getLblNewLabel());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Gestion des visiteurs");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
			lblNewLabel.setBounds(140, 50, 340, 50);
		}
		return lblNewLabel;
	}

	private JButton getBtnConsulterFiche() {
		if (btnConsulterFiche == null) {
			btnConsulterFiche = new JButton("Consulter fiche");
			btnConsulterFiche.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewRechercheFicheDr frame = new ViewRechercheFicheDr();
					frame.setVisible(true);
					dispose();
				}
			});
			btnConsulterFiche.setBounds(200, 180, 200, 40);
		}
		return btnConsulterFiche;
	}

	private JButton getBtnDeconnexion() {
		if (btnDeconnexion == null) {
			btnDeconnexion = new JButton("Déconnexion");
			btnDeconnexion.addActionListener(e -> System.exit(0));
			btnDeconnexion.setBounds(430, 310, 130, 30);
		}
		return btnDeconnexion;
	}
}
