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

/**
 * Écran de la moyenne des frais forfait par région.
 *
 * @author Matthieu CAMPAGNA
 */
public class ViewMoyenneForfait extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTitre;
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
					ViewMoyenneForfait frame = new ViewMoyenneForfait();
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
	public ViewMoyenneForfait() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.add(getLblTitre());
		contentPane.add(getLblMois());
		contentPane.add(getComboBoxMois());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnRetour());
	}

	private JLabel getLblTitre() {
		if (lblTitre == null) {
			lblTitre = new JLabel("Moyenne des frais forfait par région");
			lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblTitre.setBounds(150, 40, 700, 40);
			lblTitre.setForeground(new Color(0, 0, 0));
		}
		return lblTitre;
	}

	private JLabel getLblMois() {
		JLabel lblMois = new JLabel("Sélectionner un mois :");
		lblMois.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMois.setBounds(350, 115, 200, 30);
		return lblMois;
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

			comboBoxMois.setBounds(350, 150, 300, 30);
			comboBoxMois.setBackground(Color.WHITE);
			comboBoxMois.addActionListener(e -> mettreAJourTableau());
		}
		return comboBoxMois;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(150, 250, 700, 300);
			scrollPane.setViewportView(getTableFrais());
		}
		return scrollPane;
	}

	private JTable getTableFrais() {
		if (tableFrais == null) {
			tableFrais = new JTable();

			String[] entetes = { "Région", "Nombre de visiteurs", "Moyenne Frais Forfait (€)" };

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
		String moisSelect = (String) comboBoxMois.getSelectedItem();

		DefaultTableModel modele = (DefaultTableModel) tableFrais.getModel();

		modele.setRowCount(0);

		if (moisSelect == null || moisSelect.equals("Mois")) {
			return;
		}

		int moisFiltre = getMoisNumero(moisSelect);

		List<Object[]> moyenneRegion = AccesData.getMoyenneFraisForfaitParRegion(moisFiltre);

		for (Object[] ligne : moyenneRegion) {
			String region = (String) ligne[0];
			int nbVisiteurs = (int) ligne[1];
			double moyenne = (double) ligne[2];

			moyenne = Math.round(moyenne * 100.0) / 100.0;
			
			modele.addRow(new Object[] { region, nbVisiteurs, moyenne });
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