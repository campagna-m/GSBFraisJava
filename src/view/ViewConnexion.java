package view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import bdd.Connexion;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import dao.UtilisateurDao;
import pojo.Utilisateur;
import view.directeur.ViewAccueilDr;
import view.responsable.ViewAccueilRf;
import view.rh.ViewAccueilRh;

/**
 * Écran de connexion. Authentifie l'utilisateur et redirige selon son rôle (DR, RF, SR).
 *
 * @author Matthieu CAMPAGNA
 */
public class ViewConnexion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnLogin;
	private JLabel lblIdentifiant;
	private JLabel lblMotDePasse;
	private JPasswordField passwordField;
	private JTextField textLogin;
	private JLabel lblLogo;
	private JButton btnQuitter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewConnexion frame = new ViewConnexion();
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
	public ViewConnexion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnLogin());
		contentPane.add(getLblIdentifiant());
		contentPane.add(getLblMotDePasse());
		contentPane.add(getPasswordField());
		contentPane.add(getTextLogin());
		contentPane.add(getLblLogo());
		contentPane.add(getBtnQuitter());
	}

	public JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setBounds(400, 20, 200, 100);
			ImageIcon icon = new ImageIcon("Z:\\Examen\\GSB\\GSBRh\\gsb.png");
			Image img = icon.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
			lblLogo.setIcon(new ImageIcon(img));
		}
		return lblLogo;
	}

	public JLabel getLblIdentifiant() {
		if (lblIdentifiant == null) {
			lblIdentifiant = new JLabel("Identifiant :");
			lblIdentifiant.setBounds(290, 300, 120, 20);
			lblIdentifiant.setFont(new Font("Monospaced", Font.PLAIN, 13));
		}
		return lblIdentifiant;
	}

	public JTextField getTextLogin() {
		if (textLogin == null) {
			textLogin = new JTextField();
			textLogin.setBounds(420, 300, 200, 30);
			textLogin.setColumns(10);
		}
		return textLogin;
	}

	public JLabel getLblMotDePasse() {
		if (lblMotDePasse == null) {
			lblMotDePasse = new JLabel("Mot de passe :");
			lblMotDePasse.setBounds(290, 350, 120, 20);
			lblMotDePasse.setFont(new Font("Monospaced", Font.PLAIN, 13));
		}
		return lblMotDePasse;
	}

	public JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(420, 350, 200, 30);
		}
		return passwordField;
	}

	public JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Se connecter");
			btnLogin.setBounds(500, 400, 120, 30);

			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String login = textLogin.getText();
					String mdp = new String(passwordField.getPassword());

					Utilisateur user = null;
					for (Utilisateur u : new UtilisateurDao(Connexion.getInstance()).findAll()) {
						if (u.getLogin().equals(login) && u.getMdp().equals(mdp)) {
							user = u;
							break;
						}
					}

					if (user != null) {
						String role = user.getIdRole().getId();

						if ("DR".equals(role)) {
							new ViewAccueilDr().setVisible(true);
							dispose();
						} else if ("RF".equals(role)) {
							new ViewAccueilRf().setVisible(true);
							dispose();
						} else if ("SR".equals(role)) {
							new ViewAccueilRh().setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Accès refusé pour ce rôle.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Identifiant ou mot de passe incorrect.");
					}
				}
			});
		}
		return btnLogin;
	}

	public JButton getBtnQuitter() {
		if (btnQuitter == null) {
			btnQuitter = new JButton("Quitter");
			btnQuitter.setBounds(800, 600, 120, 30);

			btnQuitter.addActionListener(e -> System.exit(0));
		}
		return btnQuitter;
	}

}