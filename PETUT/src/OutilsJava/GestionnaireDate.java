package OutilsJava;

import java.util.HashMap;

public class GestionnaireDate {
	
	private static final String[] mois = {"Janvier","F�vrier","Mars","Avril","Mai","Juin","Juillet","Ao�t","Septembre","Octobre","Novembre","D�cembre"};
	
	// convertir une chaine date de type 00/00/0000 en chaine de type 00 mois 0000
	public static String convertDateToString(String date){
		String retour = "";
		String jour = "";
		String mois = ""; 
		String annee = "";
		int compteur = 0;
		while(date.charAt(compteur)!='/'){
			jour+=date.charAt(compteur);
			compteur++;
		}
		compteur++;
		while(date.charAt(compteur)!='/'){
			mois+=date.charAt(compteur);
			compteur++;
		}
		compteur++;
		while(date.charAt(compteur)!='/' && compteur!=9){
			annee+=date.charAt(compteur);
			if(compteur<9)
				compteur++;
		}
		annee+=date.charAt(compteur);
		int numeroMois = (Integer.parseInt(mois)-1);
		mois = GestionnaireDate.mois[numeroMois];
		return jour+" "+mois+" "+annee;
		
	}
	
	
	
	
	

}
