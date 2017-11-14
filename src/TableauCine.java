// Importation du package permettant de cr�er l'interface
import javax.swing.*;
// Importation du package awt permettant de g�rer certains objets
import java.awt.*;
import java.util.ArrayList;

public class TableauCine extends JPanel{
	
	//Attributs priv�s(panels et composants) 
	private JPanel panelTableauCine;
	private JPanel panelDisponibilite;
	private JPanel panelLesFilms;
	private JLabel lblDisponibilite;
	private JTable tLesFilms;
	private double laDisponibilite;
	private ArrayList<Film>listeFilms;
	private String slisteFilms;
		
	// Constructeur
	public TableauCine(){
		//On instancie l'objet JPanel
		this.panelTableauCine = new JPanel();
		this.panelDisponibilite = new JPanel();
		this.panelLesFilms = new JPanel();
		//On d�finit le layout des panels
		this.panelTableauCine.setLayout(new GridLayout(5,1));
		this.panelDisponibilite.setLayout(new FlowLayout());
		this.panelLesFilms.setLayout(new FlowLayout());
		//On se connecte � la base de donn�es
		Modele.connexion();
		//On r�cup�re la disponibilite de la banque(somme de chaque solde des comptes de la banque)
		//this.laDisponibilite = Modele.getDisponibilite();
		//On r�cup�re tous les comptes dans la base de donn�es qu'on stocke dans une collection d'objet Compte
		this.listeFilms = Modele.getLesFilms();
		//On se d�connecte de la base de donn�es
		Modele.deconnexion();
		//On parcourt chaque objet Compte de la collection auquel on r�cup�re la chaine renvoye par la m�thode afficherCompte() dans la variable slisteFilms
		this.tLesFilms = new JTable();
		Object[][] data = new Object[this.listeFilms.size()][5];
		int i = 0;
		for(Film unFilm : listeFilms){
			
            data[i][0] = unFilm.getTitreFilm();
            data[i][1] = unFilm.getDureeFilm();
            data[i][2] = unFilm.getNationaliteFilm();
            data[i][3] = unFilm.getLibelle();
            data[i][4] = unFilm.getLibelle();
          
            i++;
		}
		String title[] = {"Titre", "Duree (en mn)", "Nationalite", "Genre", "Prix"};
		this.tLesFilms = new JTable(data, title);
		//On instancie les objets JLabel
		//this.lblDisponibilite = new JLabel("Disponibilite de la banque " + String.valueOf(this.laDisponibilite) + "�");
		//On ajoute le(s) composant(s) dans le panelDisponibilite
		//this.panelDisponibilite.add(this.lblDisponibilite);
		//On ajoute le(s) composant(s) dans le panelLesFilms
		this.panelLesFilms.add(this.tLesFilms);
		this.panelLesFilms.add(new JScrollPane(this.tLesFilms));
		//On ajoute les panels dans le panel principal
		this.panelTableauCine.add(this.panelDisponibilite);
		this.panelTableauCine.add(this.panelLesFilms);
	}
	
	//Permet de r�cuperer l'objet JPanel dans la JFrame (actionListener actionMBanque)
	public JPanel getPanelTableauCine(){
		return(this.panelTableauCine);
	}
}