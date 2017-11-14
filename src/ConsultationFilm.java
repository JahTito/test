import javax.swing.JLabel;
import javax.swing.JPanel;


public class ConsultationFilm extends JPanel {
	private JLabel lblMessage;
	
	public ConsultationFilm(){
		
		lblMessage = new JLabel ("Voici la liste des films");
		
		this.add(lblMessage);
		
		this.setVisible(true); 
	}
	
	//Permet de récuperer l'objet JPanel dans la JFrame (actionListener action)
	public JPanel getConsultationFilm(){
		return(this);
	}
}
