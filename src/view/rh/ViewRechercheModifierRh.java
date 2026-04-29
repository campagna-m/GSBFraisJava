package view.rh;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import bdd.AccesData;
import pojo.Utilisateur;

/**
 * Écran de recherche de visiteurs pour les modifier (RH).
 *
 * @author Matthieu CAMPAGNA
 */
public class ViewRechercheModifierRh extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnRetour;
	private JButton btnValider;
	private JLabel lblTitre;
	private JLabel lblRechercheId;
	private JTextField txtRechercheId;
	private JLabel lblNom;
	private JTextField txtNom;
	private JLabel lblRegion;
	private JTextField txtRegion;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRechercheModifierRh frame = new ViewRechercheModifierRh();
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
	public ViewRechercheModifierRh() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.add(getLblTitre());
		contentPane.add(getLblRechercheId());
		contentPane.add(getTxtRechercheId());
		contentPane.add(getLblNom());
		contentPane.add(getTxtNom());
		contentPane.add(getLblRegion());
		contentPane.add(getTxtRegion());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnValider());
		contentPane.add(getBtnRetour());

		List<Utilisateur> liste = AccesData.getTousLesUtilisateurs();
		remplirTableau(liste);
	}

	public void remplirTableau(List<Utilisateur> utilisateurs) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		for (Utilisateur u : utilisateurs) {
			Object[] ligne = new Object[4];
			ligne[0] = u.getIdUtilisateur();
			ligne[1] = u.getNom();
			ligne[2] = u.getPrenom();
			ligne[3] = u.getRegion();

			model.addRow(ligne);
		}
	}

	private void filtrer() {
		String texteId = txtRechercheId.getText();
		String idRecherche = texteId.toLowerCase();

		String texteNom = txtNom.getText();
		String nomRecherche = texteNom.toLowerCase();

		String texteRegion = txtRegion.getText();
		String regionRecherche = texteRegion.toLowerCase();

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		List<Utilisateur> liste = bdd.AccesData.getTousLesUtilisateurs();

		for (Utilisateur u : liste) {

			String id = "";
			if (u.getIdUtilisateur() != null) {
				id = u.getIdUtilisateur();
				id = id.toLowerCase();
			}

			String nom = "";
			if (u.getNom() != null) {
				nom = u.getNom();
				nom = nom.toLowerCase();
			}

			String prenom = "";
			if (u.getPrenom() != null) {
				prenom = u.getPrenom();
				prenom = prenom.toLowerCase();
			}

			String nomPrenom = nom + " " + prenom;

			String region = "";
			if (u.getRegion() != null) {
				region = u.getRegion();
				region = region.toLowerCase();
			}

			boolean okId = false;
			if (id.contains(idRecherche)) {
				okId = true;
			}

			boolean okNom = false;
			if (nomPrenom.contains(nomRecherche)) {
				okNom = true;
			}

			boolean okRegion = false;
			if (region.contains(regionRecherche)) {
				okRegion = true;
			}

			if (okId == true) {
				if (okNom == true) {
					if (okRegion == true) {
						Object[] ligne = new Object[4];
						ligne[0] = u.getIdUtilisateur();
						ligne[1] = u.getNom();
						ligne[2] = u.getPrenom();
						ligne[3] = u.getRegion();

						model.addRow(ligne);
					}
				}
			}
		}
	}

	private void ouvrirFiche() {
		int ligne = table.getSelectedRow();

		if (ligne == -1) {
			javax.swing.JOptionPane.showMessageDialog(null, "Veuillez sélectionner un utilisateur.");
		} else {
			Object valeur = table.getValueAt(ligne, 0);
			String idUtilisateur = valeur.toString();

			ViewModifierRh frame = new ViewModifierRh();
			frame.remplir(idUtilisateur);
			frame.setVisible(true);

			dispose();
		}
	}

	private DocumentListener filtreListener() {
		return new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				filtrer();
			}

			public void removeUpdate(DocumentEvent e) {
				filtrer();
			}

			public void changedUpdate(DocumentEvent e) {
				filtrer();
			}
		};
	}

	private JLabel getLblTitre() {
		if (lblTitre == null) {
			lblTitre = new JLabel("Rechercher un visiteur");
			lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblTitre.setBounds(300, 10, 400, 40);
		}
		return lblTitre;
	}

	private JLabel getLblRechercheId() {
		if (lblRechercheId == null) {
			lblRechercheId = new JLabel("Chercher par ID :");
			lblRechercheId.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblRechercheId.setBounds(30, 68, 115, 20);
		}
		return lblRechercheId;
	}

	private JTextField getTxtRechercheId() {
		if (txtRechercheId == null) {
			txtRechercheId = new JTextField();
			txtRechercheId.setBounds(150, 64, 120, 30);
			txtRechercheId.getDocument().addDocumentListener(filtreListener());
		}
		return txtRechercheId;
	}

	private JLabel getLblNom() {
		if (lblNom == null) {
			lblNom = new JLabel("Nom et Prénom :");
			lblNom.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNom.setBounds(300, 68, 115, 20);
		}
		return lblNom;
	}

	private JTextField getTxtNom() {
		if (txtNom == null) {
			txtNom = new JTextField();
			txtNom.setBounds(420, 64, 160, 30);
			txtNom.getDocument().addDocumentListener(filtreListener());
		}
		return txtNom;
	}

	private JLabel getLblRegion() {
		if (lblRegion == null) {
			lblRegion = new JLabel("Région :");
			lblRegion.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblRegion.setBounds(610, 68, 65, 20);
		}
		return lblRegion;
	}

	private JTextField getTxtRegion() {
		if (txtRegion == null) {
			txtRegion = new JTextField();
			txtRegion.setBounds(680, 64, 160, 30);
			txtRegion.getDocument().addDocumentListener(filtreListener());
		}
		return txtRegion;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane(getTable());
			scrollPane.setBounds(30, 115, 920, 440);
		}
		return scrollPane;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			String[] entetes = { "ID", "Nom", "Prénom", "Région" };
			DefaultTableModel model = new DefaultTableModel(entetes, 0) {
				private static final long serialVersionUID = 1L;
				
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			table.setModel(model);
			table.setRowHeight(30);
			table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));

			table.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (e.getClickCount() == 2) {
						ouvrirFiche();
					}
				}
			});
		}
		return table;
	}

	private JButton getBtnValider() {
		if (btnValider == null) {
			btnValider = new JButton("Valider");
			btnValider.setBounds(30, 575, 120, 30);
			btnValider.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ouvrirFiche();
				}
			});
		}
		return btnValider;
	}

	private JButton getBtnRetour() {
		if (btnRetour == null) {
			btnRetour = new JButton("Retour");
			btnRetour.setBounds(840, 575, 120, 30);
			btnRetour.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewAccueilRh frame = new ViewAccueilRh();
					frame.setVisible(true);
					dispose();
				}
			});
		}
		return btnRetour;
	}
}