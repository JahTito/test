import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AjouterFilm extends JPanel {
	//Attributs privés
	private JLabel ajouterFilm = new JLabel ("AJOUTER UN FILM");
	private JLabel infoActeur = new JLabel ("ACTEUR PRINCIPALE");
	
	private JLabel titre = new JLabel ("Titre");
	private JTextField jtfTitre = new JTextField ();
	private JLabel genre = new JLabel ("Genre");
	private JTextField jtfGenre = new JTextField ();
	private JLabel nomActeur = new JLabel ("Nom");
	private JTextField jtfNomActeur = new JTextField ();
	private JLabel prenomActeur = new JLabel ("Prenom");
	private JTextField jtfPrenomActeur = new JTextField ();
	private JLabel duree = new JLabel ("Durée (en mn)");
	private JLabel dateNaiss = new JLabel ("Date de Naissance");
	private JTextField jtfDateNaiss = new JTextField ();
	private JTextField jtfDuree = new JTextField ();
	private JLabel nationaliteFilm = new JLabel ("Nationalité");
	private JTextField jtfNationaliteFilm = new JTextField ();
	/*private JLabel prixSeance = new JLabel ("Prix de la séance");
	private JTextField jtfPrixSeance = new JTextField ("Saisir le prix de la séance");*/
	private JButton ajouter = new JButton("Ajouter");
	private JButton annuler = new JButton("Annuler");
	
	private JLabel espace1 = new JLabel ();
	private JLabel espace2 = new JLabel ();
	private JLabel espace3 = new JLabel ();
	private JLabel espace4 = new JLabel ();
	private JLabel espace5 = new JLabel ();
	private JLabel lblInfoValid;
	public AjouterFilm(){
		
		this.setLayout(new FlowLayout());
		this.lblInfoValid = new JLabel("");
		
		
		//Film
		this.ajouterFilm.setPreferredSize(new Dimension(350, 40));
		this.ajouterFilm.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,24));
		this.add(lblInfoValid);
		this.add(ajouterFilm);
		this.espace1.setPreferredSize(new Dimension(500, 20));
		this.add(espace1);
		
		//Champs pour Titre
		this.titre.setPreferredSize(new Dimension(200, 34));
		this.add(titre);		
		this.jtfTitre.setPreferredSize(new Dimension(250, 34));
		this.add(jtfTitre);
		
		//Champs pour Genre
		this.genre.setPreferredSize(new Dimension(200, 34));
		this.add(genre);
		this.jtfGenre.setPreferredSize(new Dimension(250, 34));
		this.add(jtfGenre);
		
		//Champs pour Durée
		this.duree.setPreferredSize(new Dimension(200, 34));
		this.add(duree);
		this.jtfDuree.setPreferredSize(new Dimension(250, 34));
		this.add(jtfDuree);
		
		//Champs pour Nationalité
		this.nationaliteFilm.setPreferredSize(new Dimension(200, 34));
		this.add(nationaliteFilm);
		this.jtfNationaliteFilm.setPreferredSize(new Dimension(250, 34));
		this.add(jtfNationaliteFilm);	
		
		//Saut d'une ligne
		this.espace3.setPreferredSize(new Dimension(500, 20));
		this.add(espace3);
		
		this.infoActeur.setPreferredSize(new Dimension(350, 40));
		this.infoActeur.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,24));
		this.add(infoActeur);
		
		this.espace4.setPreferredSize(new Dimension(500, 20));
		this.add(espace4);

		//Champs pour Acteurs
		this.nomActeur.setPreferredSize(new Dimension(200, 34));
		this.add(nomActeur);
		this.jtfNomActeur.setPreferredSize(new Dimension(250, 34));
		this.add(jtfNomActeur);
		
		this.prenomActeur.setPreferredSize(new Dimension(200, 34));
		this.add(prenomActeur);
		this.jtfPrenomActeur.setPreferredSize(new Dimension(250, 34));
		this.add(jtfPrenomActeur);
		
		this.dateNaiss.setPreferredSize(new Dimension(200, 34));
		this.add(dateNaiss);
		this.jtfDateNaiss.setPreferredSize(new Dimension(250, 34));
		this.add(jtfDateNaiss);
		
		//Saut d'une ligne
		this.espace5.setPreferredSize(new Dimension(500, 20));
		this.add(espace5);
		
		//Permet l'alignement des boutons 
		this.espace2.setPreferredSize(new Dimension(130, 34));
		this.add(espace2);
		
		//Bouton ajouter
		this.ajouter.addActionListener(new actionBtnValider());
		this.add(ajouter);
		
		//Bouton annuler
		this.add(annuler);
		
		this.setVisible(true); 
	}
	
	//Permet de récuperer l'objet JPanel dans la JFrame (actionListener actionFilm)
	public JPanel getPanelAjouterFilm(){
		return(this);
	}
	
	//Action sur l'objet JButton btnValider
		public class actionBtnValider implements ActionListener{
			public void actionPerformed(ActionEvent ae) {
				if(!jtfTitre.getText().isEmpty() && !jtfGenre.getText().isEmpty() && !jtfDuree.getText().isEmpty() && !jtfNationaliteFilm.getText().isEmpty() && !jtfNomActeur.getText().isEmpty() && !jtfPrenomActeur.getText().isEmpty() && !jtfDateNaiss.getText().isEmpty()){
					int uneDuree = Integer.parseInt(jtfDuree.getText());
					/*SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					Date uneDate = dateFormat.parse(jtfDateNaiss.getText());*/
					Modele.connexion();
					Modele.ajouterFilm(new Film(jtfTitre.getText(), uneDuree, jtfNationaliteFilm.getText()));
					Modele.ajouterGenre(new Genre(jtfGenre.getText()));
					Modele.ajouterActeur(new Acteur(jtfNomActeur.getText(), jtfPrenomActeur.getText(), jtfDateNaiss.getText()));
					Modele.deconnexion();
					lblInfoValid.setText("Film ajouter avec succès");
				}
			}		
		}
			
		//Action sur l'objet JButton btnEffacer
		public class actionBtnEffacer implements ActionListener{
			public void actionPerformed(ActionEvent ae) {
				jtfTitre.setText(null);
				jtfGenre.setText(null);
				jtfNomActeur.setText(null);
				jtfPrenomActeur.setText(null);
			}	
		}
}
