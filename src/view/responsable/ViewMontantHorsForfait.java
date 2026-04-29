package view.responsable;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bdd.AccesData;
import pojo.Utilisateur;

/**
 * Écran du montant total des frais hors forfait par région et mois.
 *
 * @author Matthieu CAMPAGNA
 */
public class ViewMontantHorsForfait extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTitre;
	private JComboBox<String> comboBoxRegion;
	private JComboBox<String> comboBoxMois;
	private JScrollPane scrollPane;
	private JTable tableFrais;
	private JButton btnRetour;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMontantHorsForfait frame = new ViewMontantHorsForfait();
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
	public ViewMontantHorsForfait() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.add(getLblTitre());
		contentPane.add(getComboBoxRegion());
		contentPane.add(getComboBoxMois());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnRetour());
	}

	private JLabel getLblTitre() {
		if (lblTitre == null) {
			lblTitre = new JLabel("Montant total des frais hors forfait par région et mois");
			lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblTitre.setBounds(150, 40, 700, 40);
			lblTitre.setForeground(new Color(0, 0, 0));
		}
		return lblTitre;
	}

	private JComboBox<String> getComboBoxRegion() {
		if (comboBoxRegion == null) {
			String[] regions = { "Région", "Bretagne", "Pays de la Loire", "Normandie", "Hauts-de-France", "Grand Est",
					"Île-de-France", "Centre-Val de Loire", "Bourgogne-Franche-Comté", "Nouvelle Aquitaine",
					"Auvergne Rhône-Alpes", "Occitanie", "Paca", "Corse" };
			comboBoxRegion = new JComboBox<>(regions);
			comboBoxRegion.setBounds(150, 150, 300, 30);
			comboBoxRegion.setBackground(Color.WHITE);

			comboBoxRegion.addActionListener(e -> mettreAJourTableau());
		}
		return comboBoxRegion;
	}

	private JComboBox<String> getComboBoxMois() {
		if (comboBoxMois == null) {
			comboBoxMois = new JComboBox<>();
			comboBoxMois.addItem("Mois");

			String[] tousLesMois = { "Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août",
					"Septembre", "Octobre", "Novembre", "Décembre" };

			int moisActuel = java.time.LocalDate.now().getMonthValue();

			for (int i = 0; i < tousLesMois.length; i++) {
				int numeroDuMois = i + 1;

				if (numeroDuMois != moisActuel) {
					comboBoxMois.addItem(tousLesMois[i]);
				}
			}

			comboBoxMois.setBounds(550, 150, 300, 30);
			comboBoxMois.setBackground(Color.WHITE);

			comboBoxMois.addActionListener(e -> mettreAJourTableau());
		}
		return comboBoxMois;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(150, 300, 700, 200);
			scrollPane.setViewportView(getTableFrais());
		}
		return scrollPane;
	}

	private JTable getTableFrais() {
		if (tableFrais == null) {
			tableFrais = new JTable();

			String[] entetes = { "Nom", "Prénom", "Montant total (€)" };

			DefaultTableModel modeleTableau = new DefaultTableModel(entetes, 0) {
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int ligne, int colonne) {
					return false;
				}
			};

			tableFrais.setModel(modeleTableau);

			tableFrais.setRowHeight(30);
			tableFrais.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
		}
		return tableFrais;
	}

	private int getMoisNumero(String nomMois) {
		switch (nomMois) {
		case "Janvier":
			return 1;
		case "Février":
			return 2;
		case "Mars":
			return 3;
		case "Avril":
			return 4;
		case "Mai":
			return 5;
		case "Juin":
			return 6;
		case "Juillet":
			return 7;
		case "Août":
			return 8;
		case "Septembre":
			return 9;
		case "Octobre":
			return 10;
		case "Novembre":
			return 11;
		case "Décembre":
			return 12;
		default:
			return 0;
		}
	}

	private void mettreAJourTableau() {
		String regionSelect = comboBoxRegion.getSelectedItem().toString();
		String moisSelect = comboBoxMois.getSelectedItem().toString();

		DefaultTableModel modele = (DefaultTableModel) tableFrais.getModel();
		modele.setRowCount(0);

		if (regionSelect.equals("Région") || moisSelect.equals("Mois")) {
			return;
		}

		int moisFiltre = getMoisNumero(moisSelect);
		List<Utilisateur> tousLesUtilisateurs = AccesData.getTousLesUtilisateurs();

		for (Utilisateur u : tousLesUtilisateurs) {
			if (u.getRegion() != null && u.getRegion().equals(regionSelect)) {
				double montant = AccesData.getMontantFraisHorsForfaitParMois(u.getIdUtilisateur(), moisFiltre);

				if (montant > 0) {
					modele.addRow(new Object[] { u.getNom(), u.getPrenom(), montant });
				}
			}
		}
	}

	private JButton getBtnRetour() {
		if (btnRetour == null) {
			btnRetour = new JButton("Retour");
			btnRetour.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewAccueilRf frame = new ViewAccueilRf();
					frame.setVisible(true);
					dispose();
				}
			});
			btnRetour.setBounds(800, 600, 120, 30);
		}
		return btnRetour;
	}
}