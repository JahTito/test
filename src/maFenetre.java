import javax.swing.*;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.* ;

public class maFenetre extends JFrame implements ActionListener{
	//Attributs privés
	private JMenuBar menu;	
		private JMenuItem monCine;
		private JMenu films;
			private JMenuItem ajouterFilm;
			private JMenuItem supprimerFilm;
		private JMenu acteurs;
			private JMenuItem rechercherActeur;

		/*private JMenu consulter;
			private JMenuItem film;
			private JMenuItem acteur;
			private JMenuItem genre;*/
		private JMenuItem quitter;
	
	public maFenetre(){
		this.setVisible(true); 
		this.setTitle("Cinéma");
		this.setLocation(300, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("logoCinema.jpg"));
		this.setSize(600, 600);
		//this.setContentPane(new AfficheImage("E:\\Workspace\\TpCinema\\logoCinema.jpg"));
		this.setResizable(false);
		
		
		//On instancie l'objet JMenuBar
		this.menu = new JMenuBar();
		
		//On instancie les objets JMenu
		this.monCine = new JMenuItem("Mon Cinéma");
		this.monCine.setPreferredSize(new Dimension(5, 24));
		this.films = new JMenu("Films");
		this.acteurs = new JMenu("Acteurs");
		/*this.consulter = new JMenu("Consultation");*/		
		
		//On instancie les objets JMenuItem
		this.ajouterFilm = new JMenuItem("Ajouter un film");
		this.supprimerFilm = new JMenuItem("Supprimer un film");
		this.rechercherActeur = new JMenuItem("Rechercher un acteur");		
		/*this.film = new JMenuItem("Film");
		this.acteur = new JMenuItem("Acteur");
		this.genre = new JMenuItem("Genre");*/	
		this.quitter = new JMenuItem("Quitter");
		this.quitter.setPreferredSize(new Dimension(200, 24));
		
		//On ajoute les objets JMenuItem dans les objets JMenu
		this.films.add(ajouterFilm);
		this.films.add(supprimerFilm);
		this.acteurs.add(rechercherActeur);
		/*this.consulter.add(film);
		this.consulter.add(acteur);
		this.consulter.add(genre);*/
		
		//On ajoute les objets JMenu et les objets JMenuItem dans l'objet JMenuBar
		this.menu.add(monCine);
		this.menu.add(films);
		this.menu.add(acteurs);
		/*this.menu.add(consulter);*/
		this.menu.add(quitter);
		
		//On set leJMenuBar dans la JFrame
		this.setJMenuBar(this.menu);
		
		//Ecouteur sur les objets JMenuItem
		this.monCine.addActionListener(new actionTabCine());
		this.ajouterFilm.addActionListener(new actionAjouterFilm());
		this.supprimerFilm.addActionListener(new actionSupprimerFilm());
		this.rechercherActeur.addActionListener(new actionRechercherActeur());
        /*this.film.addActionListener(new actionFilm());*/
        this.quitter.addActionListener(new actionquitter());
		
        PanelAccueil monPanelAccueil = new PanelAccueil();
        
		this.getContentPane().add(monPanelAccueil);
		this.setVisible(true); 
	}
	
	//Méthode qui change le panel de la fenêtre
    public void setJPanel(JPanel unPanel){
        this.setContentPane(unPanel);
        this.revalidate();
    }
    
  //Action sur l'objet JMenu MonCinema
  	public class actionTabCine implements ActionListener{
  		public void actionPerformed(ActionEvent ae) {
  			setJPanel(new TableauCine().getPanelTableauCine());
  		}	
  	}
	
    //Action sur l'objet JMenuItem ajouterFilm
	public class actionAjouterFilm implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			setJPanel(new AjouterFilm().getPanelAjouterFilm());
		}		
	}
	
	//Action sur l'objet JMenuItem supprimerFilm
	public class actionSupprimerFilm implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			setJPanel(new SupprimerFilm().getPanelSupprimerFilm());
		}		
	}
	
	//Action sur l'objet JMenuItem supprimerFilm
	public class actionRechercherActeur implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			setJPanel(new ConlsultationActeur().getConsultationActeur());
		}		
	}
	
	//Action sur l'objet JMenu quitter
	public class actionquitter implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			System.exit(0);
		}	
	}
	
	class AfficheImage extends JPanel{
		//Déclaration de l'attribut fond de type Image
		private Image fond;
		//Création du constructeur de la classe
		AfficheImage(String cheminImage){
			//Permet de charger une image
			this.fond = getToolkit().getImage(cheminImage);
		}
		/* Cette méthode est appelée automatiquement lors du chargement ou du redimensionnement
		de la fenêtre*/
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(this.fond, 0, 0, getWidth(), getHeight(), this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	} 
	
	
}