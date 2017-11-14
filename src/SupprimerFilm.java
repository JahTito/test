import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SupprimerFilm extends JPanel{
	//Attributs privés
	private JLabel supprimerFilm = new JLabel ("SUPPRIMER UN FILM");
	
	private JLabel titre = new JLabel ("Titre ");
	private JTextField jtfTitre = new JTextField ("Saisir le titre du film ");
	
	private JButton supprimer = new JButton("Supprimer");
	private JButton annuler = new JButton("Annuler");
	
	private JLabel espace1 = new JLabel ();
	private JLabel espace2 = new JLabel ();
	
	private JLabel lblInfoValid;
	
	public SupprimerFilm(){
		this.setLayout(new FlowLayout());
		this.lblInfoValid = new JLabel("");
		this.add(lblInfoValid);
		//Titre de la fenêtre
		this.supprimerFilm.setPreferredSize(new Dimension(400, 40));
		this.supprimerFilm.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,24));
		this.add(supprimerFilm);		
		//Espace après le titre
		this.espace1.setPreferredSize(new Dimension(600, 20));
		this.add(espace1);		
		//Label Titre
		this.titre.setPreferredSize(new Dimension(200, 34));
		this.add(titre);
		//Champs titre
		this.jtfTitre.setPreferredSize(new Dimension(250, 34));
		this.add(jtfTitre);
		//Espace apres la saisi du titre
		this.espace2.setPreferredSize(new Dimension(500, 20));
		this.add(espace2);	
		
		//Bouton supprimer
		this.supprimer.addActionListener(new actionBtnSupprimer());
		this.add(supprimer);
		
		
		//Bouton annuler
		this.annuler.addActionListener(new actionBtnEffacer());
		this.add(annuler);
		
		
		this.setVisible(true); 
	}
	public JPanel getPanelSupprimerFilm(){
		return(this);
	}
	
	//Action sur l'objet JButton btnValider
		public class actionBtnSupprimer implements ActionListener{
			public void actionPerformed(ActionEvent ae) {
				if(!jtfTitre.getText().isEmpty()){
					Modele.connexion();
					Modele.supprimerFilm(new Film(jtfTitre.getText()));
					Modele.deconnexion();
					lblInfoValid.setText("Suppression du film réussi avec succès");
				}
			}	
		}
			
		//Action sur l'objet JButton btnEffacer
		public class actionBtnEffacer implements ActionListener{
			public void actionPerformed(ActionEvent ae) {
				jtfTitre.setText(null);
			}	
		}
		
		//Ecouteur
		public void actionPerformed(ActionEvent arg0) {}
}
