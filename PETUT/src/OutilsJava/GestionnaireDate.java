package OutilsJava;

import java.util.HashMap;

public class GestionnaireDate {
	
	private static final String[] mois = {"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Décembre"};
	
	// convertir une chaine date de type 0000/00/00 en chaine de type 00 mois 0000
	public static String convertDateToString(String date){
		String retour = "";
		String jour = "";
		String mois = ""; 
		String annee = "";
		int compteur = 0;
		while(date.charAt(compteur)!='-'){
			annee+=date.charAt(compteur);
			compteur++;
		}
		compteur++;
		while(date.charAt(compteur)!='-'){
			mois+=date.charAt(compteur);
			compteur++;
		}
		compteur++;
		while(date.charAt(compteur)!='-' && compteur!=9){
			jour+=date.charAt(compteur);
			if(compteur<9)
				compteur++;
		}
		jour+=date.charAt(compteur);
		int numeroMois = (Integer.parseInt(mois)-1);
		mois = GestionnaireDate.mois[numeroMois];
		return jour+" "+mois+" "+annee;
		
	}
	
	
	
	
	

}
