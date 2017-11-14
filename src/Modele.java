import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Modele {
	//Attributs statiques privés
	private static Connection connexion;
	private static ResultSet rs;
	
	
	
	//Connexion
	public static void connexion(){
		try {
			Class.forName("com.mysql.jdbc.Driver");//Chargement du driver
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/cinema", "root", "");//Connexion à la base de données
		}
		catch (SQLException erreur) {
			System.out.println("La connexion à la base de données à échoué " + erreur);
		}
		catch (ClassNotFoundException erreur) {
			System.out.println("Le driver n'a pas été chargé " + erreur);
		}
	}
	
	//Déconnexion
	public static void deconnexion(){
		try {
			connexion.close();
		} 
		catch (SQLException erreur) {
			System.out.println("Erreur lors de la déconnexion à la base de données" + erreur);
		}
	}
	//Méthode qui permet d'ajouter un film
	public static void ajouterFilm(Film unFilm){
		try {
			PreparedStatement statement = connexion.prepareStatement("INSERT INTO film(titre, duree, nationalite) values (?, ?, ?);");
			statement.setString(1, unFilm.getTitreFilm());
			statement.setInt(2, unFilm.getDureeFilm());
			statement.setString(3, unFilm.getNationaliteFilm());
			statement.executeUpdate();		
		} 
		catch (SQLException erreur) {
			System.out.println("L'insertion du film dans la base de données a échouée " + erreur);
		}
	}
	//Méthode qui permet d'ajouter le genre du film
	public static void ajouterGenre(Genre unGenre){
		try {
			PreparedStatement statement = connexion.prepareStatement("INSERT INTO genre(libelleGenre) values (?);");
			statement.setString(1, unGenre.getLibelle());
			statement.executeUpdate();	
		} 
		catch (SQLException erreur) {
			System.out.println("L'insertion du genre dans la base de données a échouée " + erreur);
		}
	}
	//Méthode qui ajoute le(s) acteur(s)
	public static void ajouterActeur(Acteur unActeur){
		try {
			PreparedStatement statement = connexion.prepareStatement("INSERT INTO acteur(nomActeur, prenomActeur, dateNaissance) values (?, ?, ?);");
			statement.setString(1, unActeur.getNomActeur());
			statement.setString(2, unActeur.getPrenomActeur());
			statement.setString(3, unActeur.getDateNaissance());
			statement.executeUpdate();	
		} 
		catch (SQLException erreur) {
			System.out.println("L'insertion de l'acteur dans la base de données a échouée " + erreur);
		}
	}
	public static void supprimerFilm(Film unFilm){
		try {
			PreparedStatement statement = connexion.prepareStatement("DELETE FROM film WHERE titre = ?;");
			statement.setString(1, unFilm.getTitreFilm());
			statement.executeUpdate();
		} 
		catch (SQLException erreur) {
			System.out.println("La suppression du film dans la base de données a échouée ou le film n'existe pas " + erreur);
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
			System.out.println("La récupération des films dans la base de données a échouée " + erreur);
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
			System.out.println("La recherche de l'acteur dans la base de données a échouée ou l'acteur n'existe pas " + erreur);
		}
		return lacteur;
	}

}
