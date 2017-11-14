

//import java.time.Date;
import java.util.ArrayList;

public class Acteur {
	//Attributs privés 
	private int idActeur;
	private String nomActeur;
	private String prenomActeur;
	private String dateNaissance;
	private ArrayList<Film> lesFilmsActeurs;
	
	//Constructeurs
	public Acteur(){
		
	}
	public Acteur(int unId){
		this.idActeur = unId;
		this.lesFilmsActeurs = new ArrayList<Film>();
	}
	public Acteur(int unId, String unNomActeur){
		this.idActeur = unId;
		this.nomActeur = unNomActeur;
		this.lesFilmsActeurs = new ArrayList<Film>();
	}
	public Acteur(int unId, String unNomActeur, String unPrenomActeur){
		this.idActeur = unId;
		this.nomActeur = unNomActeur;
		this.prenomActeur = unPrenomActeur;
		this.lesFilmsActeurs = new ArrayList<Film>();
	}
	public Acteur(int unId, String unNomActeur, String unPrenomActeur, String uneDate){
		this.idActeur = unId;
		this.nomActeur = unNomActeur;
		this.prenomActeur = unPrenomActeur;
		this.dateNaissance = uneDate;
		this.lesFilmsActeurs = new ArrayList<Film>();
	}
	public Acteur(String unNomActeur, String unPrenomActeur, String uneDate){
		this.nomActeur = unNomActeur;
		this.prenomActeur = unPrenomActeur;
		this.dateNaissance = uneDate;
		this.lesFilmsActeurs = new ArrayList<Film>();
	}
	public Acteur(String unNomActeur){
		this.nomActeur = unNomActeur;
		this.lesFilmsActeurs = new ArrayList<Film>();
	}

	
	//Accesseurs
	public int getIdActeur(){
		return this.idActeur;
	}
	public void setIdActeur(int unId){
		this.idActeur = unId;
	}
	
	public String getNomActeur(){
		return this.nomActeur;
	}
	public void setNomActeur(String unNomActeur){
		this.nomActeur = unNomActeur;
	}
	
	public String getPrenomActeur(){
		return this.prenomActeur;
	}
	public void setPrenomActeur(String unPrenomActeur){
		this.prenomActeur = unPrenomActeur;
	}
	
	public String getDateNaissance(){
		return this.dateNaissance;
	}
	public void setDateNaissance(String uneDate){
		this.dateNaissance = uneDate;
	}	
	
	
}
