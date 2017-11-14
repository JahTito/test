import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Modele {
	//Attributs statiques priv�s
	private static Connection connexion;
	private static ResultSet rs;
	
	
	
	//Connexion
	public static void connexion(){
		try {
			Class.forName("com.mysql.jdbc.Driver");//Chargement du driver
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/cinema", "root", "");//Connexion � la base de donn�es
		}
		catch (SQLException erreur) {
			System.out.println("La connexion � la base de donn�es � �chou� " + erreur);
		}
		catch (ClassNotFoundException erreur) {
			System.out.println("Le driver n'a pas �t� charg� " + erreur);
		}
	}
	
	//D�connexion
	public static void deconnexion(){
		try {
			connexion.close();
		} 
		catch (SQLException erreur) {
			System.out.println("Erreur lors de la d�connexion � la base de donn�es" + erreur);
		}
	}
	//M�thode qui permet d'ajouter un film
	public static void ajouterFilm(Film unFilm){
		try {
			PreparedStatement statement = connexion.prepareStatement("INSERT INTO film(titre, duree, nationalite) values (?, ?, ?);");
			statement.setString(1, unFilm.getTitreFilm());
			statement.setInt(2, unFilm.getDureeFilm());
			statement.setString(3, unFilm.getNationaliteFilm());
			statement.executeUpdate();		
		} 
		catch (SQLException erreur) {
			System.out.println("L'insertion du film dans la base de donn�es a �chou�e " + erreur);
		}
	}
	//M�thode qui permet d'ajouter le genre du film
	public static void ajouterGenre(Genre unGenre){
		try {
			PreparedStatement statement = connexion.prepareStatement("INSERT INTO genre(libelleGenre) values (?);");
			statement.setString(1, unGenre.getLibelle());
			statement.executeUpdate();	
		} 
		catch (SQLException erreur) {
			System.out.println("L'insertion du genre dans la base de donn�es a �chou�e " + erreur);
		}
	}
	//M�thode qui ajoute le(s) acteur(s)
	public static void ajouterActeur(Acteur unActeur){
		try {
			PreparedStatement statement = connexion.prepareStatement("INSERT INTO acteur(nomActeur, prenomActeur, dateNaissance) values (?, ?, ?);");
			statement.setString(1, unActeur.getNomActeur());
			statement.setString(2, unActeur.getPrenomActeur());
			statement.setString(3, unActeur.getDateNaissance());
			statement.executeUpdate();	
		} 
		catch (SQLException erreur) {
			System.out.println("L'insertion de l'acteur dans la base de donn�es a �chou�e " + erreur);
		}
	}
	public static void supprimerFilm(Film unFilm){
		try {
			PreparedStatement statement = connexion.prepareStatement("DELETE FROM film WHERE titre = ?;");
			statement.setString(1, unFilm.getTitreFilm());
			statement.executeUpdate();
		} 
		catch (SQLException erreur) {
			System.out.println("La suppression du film dans la base de donn�es a �chou�e ou le film n'existe pas " + erreur);
		}
	}
	public static ArrayList<Film> getLesFilms(){
		ArrayList<Film>lesFilms = new ArrayList<Film>();
		Film unFilm;
		String unTitre;
		int uneDuree;
		String uneNation;
		int unNbPlace;
		int unIdGenre;
		int idGenre;
		String libelle;
		//Genre leGenre = new Genre(idGenre, libelleGenre);
		Genre leGenre;
		try {
			PreparedStatement statement = connexion.prepareStatement("SELECT numFilm,titre,duree,nationalite,nbPlace,film.idGenre,genre.idGenre,libelleGenre  FROM film,genre WHERE film.idGenre = genre.idGenre ORDER BY numFilm;");
			rs = statement.executeQuery();
			while (rs.next()){
				unTitre = rs.getString("titre");
				uneDuree = rs.getInt("duree");
				uneNation = rs.getString("nationalite");
				unNbPlace = rs.getInt("nbPlace");
				libelle = rs.getString("libelleGenre");
				/*unIdGenre = rs.getInt("film.idGenre");
				idGenre = rs.getInt("genre.idGenre");
				leGenre = new Genre(idGenre, libelle);
				if(unIdGenre == idGenre){
					
				}*/
				lesFilms.add(new Film(unTitre,uneDuree,uneNation, libelle));
			}
			rs.close();
		} 
		catch (SQLException erreur) {
			System.out.println("La r�cup�ration des films dans la base de donn�es a �chou�e " + erreur);
		}
		return(lesFilms);
	}

	public static Acteur rechercherActeur(String unActeur){
		Acteur lacteur = null;
		String nom;
		String prenom;
		String date;
		String req = "SELECT * FROM acteur WHERE nomActeur = ?";
		try {
			//Modele.connexion();
			PreparedStatement statement = connexion.prepareStatement(req);
			statement.setString(1, unActeur);
			rs = statement.executeQuery();
			while(rs.next()){
				nom = rs.getString("nomActeur");
				prenom = rs.getString("prenomActeur");
				date = rs.getString("dateNaissance");
				lacteur = new Acteur(nom,prenom,date);
				
			}
		} 
		catch (SQLException erreur){
			System.out.println("La recherche de l'acteur dans la base de donn�es a �chou�e ou l'acteur n'existe pas " + erreur);
		}
		return lacteur;
	}

}
