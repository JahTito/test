import javax.swing.*;
import java.awt.event.* ;


public class PanelAccueil extends JPanel{
	private JLabel lblMessage;
	
	public PanelAccueil(){

		lblMessage = new JLabel ("Bienvenue dans mon Cin�ma");
		
		this.add(lblMessage);
		
		this.setVisible(true); 
	}
	
	//Permet de r�cuperer l'objet JPanel dans la JFrame (actionListener actionMBanque)
	public JPanel getPanelAccueil(){
		return(this);
	}
}
