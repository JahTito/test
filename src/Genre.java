
public class Genre {
	//Attributs privés
	private int idGenre;
	private String libelleGenre;
	
	//Constructeurs
	public Genre(){
		
	}
	public Genre(int unId){
		this.idGenre = unId;
	}
	public Genre(int unId, String unLabel){
		this.idGenre = unId;
		this.libelleGenre = unLabel;
	}
	
	public Genre(String unLabel){
		this.libelleGenre = unLabel;
	}
	
	//Acesseurs
	public int getIdGenre(){
		return this.idGenre;
	}
	public void setIdGenre(int unId){
		this.idGenre = unId;
	}
	
	public String getLibelle(){
		return this.libelleGenre;
	}
	public void setLibelle(String unLibelle){
		this.libelleGenre = unLibelle;
	}
	
}
