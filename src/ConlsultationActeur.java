import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;




public class ConlsultationActeur extends JPanel{
	//Attributs privés
	private JLabel rechercherActeur = new JLabel ("RECHERCHER ACTEUR");
	
	private JLabel acteur = new JLabel ("Acteur ");
	private JTextField jtfActeur = new JTextField ("Saisir le nom de l'acteur ");
	

	
	private JButton rechercher = new JButton("Rechercher");
	private JButton annuler = new JButton("Annuler");
	
	private JLabel espace1 = new JLabel ();
	private JLabel espace2 = new JLabel ();
	
	private JLabel lblInfoValid;
	
	public ConlsultationActeur(){
		this.setLayout(new FlowLayout());
		this.lblInfoValid = new JLabel("");
		this.add(lblInfoValid);
		//Titre de la fenêtre
		this.rechercherActeur.setPreferredSize(new Dimension(400, 40));
		this.rechercherActeur.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,24));
		this.add(rechercherActeur);		
		//Espace après le titre
		this.espace1.setPreferredSize(new Dimension(600, 20));
		this.add(espace1);		
		//Label Titre
		this.acteur.setPreferredSize(new Dimension(200, 34));
		this.add(acteur);
		//Champs titre
		this.jtfActeur.setPreferredSize(new Dimension(250, 34));
		this.add(jtfActeur);
		//Espace apres la saisi du titre
		this.espace2.setPreferredSize(new Dimension(500, 20));
		this.add(espace2);	
		
		//Bouton supprimer
		this.rechercher.addActionListener(new actionBtnRechercher());
		this.add(rechercher);
		
		//Bouton annuler
		this.annuler.addActionListener(new actionBtnEffacer());
		this.add(annuler);
		

	}
	
	//Permet de récuperer l'objet JPanel dans la JFrame (actionListener actionMBanque)
	public JPanel getConsultationActeur(){
		return(this);
	}
	
	//Action sur l'objet JButton btnValider
			public class actionBtnRechercher implements ActionListener{
				public void actionPerformed(ActionEvent ae) {
					if(!jtfActeur.getText().isEmpty()){
						Modele.connexion();
						Acteur macteur = Modele.rechercherActeur(jtfActeur.getText());
						lblInfoValid.setText(macteur.getNomActeur());
						Modele.deconnexion();
						
					}
				}	
			}
				
			//Action sur l'objet JButton btnEffacer
			public class actionBtnEffacer implements ActionListener{
				public void actionPerformed(ActionEvent ae) {
					jtfActeur.setText(null);
				}	
			}
			
			//Ecouteur
			public void actionPerformed(ActionEvent arg0) {}
}
