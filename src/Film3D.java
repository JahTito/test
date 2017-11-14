
public class Film3D extends Film{
	//Attributs privés
		private static double prix3D;
		
		Film3D(){
			
		}
		Film3D(int unId, String unTitreFilm, int uneDuree, String uneNationalite, double unPrix){
			super(unId, unTitreFilm, uneDuree, uneNationalite);
			this.prix3D = unPrix;
		}
		
		public double getPrix3D(){
			return this.prix3D;
		}
}
