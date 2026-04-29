package launch;

import view.ViewConnexion;

/**
 * Point d'entrée de l'application GSBRh.
 * Lance la fenêtre de connexion.
 * 
 * @author Matthieu CAMPAGNA
 */
public class Program {

	public static void main(String[] args) {
		ViewConnexion frame = new ViewConnexion();
		frame.setVisible(true);
	}

}
