
public class Film2D extends Film{
	//Attributs privés
	private static double prix2D;
	
	Film2D(){
		
	}
	Film2D(int unId, String unTitreFilm, int uneDuree, String uneNationalite, double unPrix){
		super(unId, unTitreFilm, uneDuree, uneNationalite);
		this.prix2D = unPrix;
	}
	
	Film2D(String unTitreFilm, int uneDuree, String uneNationalite, double unPrix){
		super(unTitreFilm, uneDuree, uneNationalite);
		this.prix2D = unPrix;
	}
	
	public double getPrix2D(){
		return this.prix2D;
	}
	
}
