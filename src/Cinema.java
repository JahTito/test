
public class Cinema {
	//Attributs priv�s
	private String nomCine;
	
	//Constructeurs
	public Cinema(){
		
	}
	public Cinema(String unNomCine){
		this.nomCine = unNomCine;
	}
	
	//Accesseurs 
	public String getNomCine(){
		return this.nomCine;
	}
	public void setNomCine(String unNomCine){
		this.nomCine = unNomCine;
	}
}
