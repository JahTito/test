import javax.swing.*;
import java.awt.event.* ;


public class PanelAccueil extends JPanel{
	private JLabel lblMessage;
	
	public PanelAccueil(){

		lblMessage = new JLabel ("Bienvenue dans mon Cinéma");
		
		this.add(lblMessage);
		
		this.setVisible(true); 
	}
	
	//Permet de récuperer l'objet JPanel dans la JFrame (actionListener actionMBanque)
	public JPanel getPanelAccueil(){
		return(this);
	}
}
