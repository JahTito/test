import java.util.ArrayList;


public class Film {
	//Attributs privés
	private int idFilm;
	private String titreFilm;
	private int dureeFilm;
	private String nationaliteFilm;
	private int nbPlace;
	private String libelle;
	private ArrayList<Acteur> lesActeurs;
	
	//Constructeurs
	public Film(){
		
	}
	public Film(int unId){
		this.idFilm = unId;
		this.lesActeurs = new ArrayList<Acteur>();
	}
	public Film(int unId, String unTitreFilm){
		this.idFilm = unId;
		this.titreFilm = unTitreFilm;
		this.lesActeurs = new ArrayList<Acteur>();
	}
	public Film(int unId, String unTitreFilm, int uneDuree){
		this.idFilm = unId;
		this.titreFilm = unTitreFilm;
		this.dureeFilm = uneDuree;
		this.lesActeurs = new ArrayList<Acteur>();
	}
	public Film(int unId, String unTitreFilm, int uneDuree, String uneNationalite){
		this.idFilm = unId;
		this.titreFilm = unTitreFilm;
		this.dureeFilm = uneDuree;
		this.nationaliteFilm = uneNationalite;
		this.lesActeurs = new ArrayList<Acteur>();
	}
	public Film(String unTitreFilm, int uneDuree, String uneNationalite){
		this.titreFilm = unTitreFilm;
		this.dureeFilm = uneDuree;
		this.nationaliteFilm = uneNationalite;
		this.lesActeurs = new ArrayList<Acteur>();
	}
	public Film(String unTitreFilm, int uneDuree, String uneNationalite, String unLibelle){
		this.titreFilm = unTitreFilm;
		this.dureeFilm = uneDuree;
		this.nationaliteFilm = uneNationalite;
		this.libelle = unLibelle;
		this.lesActeurs = new ArrayList<Acteur>();
	}
	public Film(String unTitreFilm){
		this.titreFilm = unTitreFilm;
		this.lesActeurs = new ArrayList<Acteur>();
	}
	
	//Accesseurs 
	public int getIdFilm(){
		return this.idFilm;
	}
	public void setNomCine(int unId){
		this.idFilm = unId;
	}
	
	public String getTitreFilm(){
		return this.titreFilm;
	}
	public void setTitreFilm(String unTitreFilm){
		this.titreFilm = unTitreFilm;
	}
	
	public int getDureeFilm(){
		return this.dureeFilm;
	}
	public void setDureeFilm(int uneDuree){
		this.dureeFilm = uneDuree;
	}
	
	public String getNationaliteFilm(){
		return this.nationaliteFilm;
	}
	public void setNationaliteFilm(String uneNationalite){
		this.nationaliteFilm = uneNationalite;
	}
	
	public int getNbPlace() {
		return nbPlace;
	}
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String unLibelle) {
		this.libelle = unLibelle;
	}
	
	
	
}
