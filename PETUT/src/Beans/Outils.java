package Beans;

import java.util.*;

public abstract class Outils {
	
	public static void decouperListDocumentSujet(Document d,SujetDocument s){
		if(d.getNom().compareTo("document à importer")==0){
			s.addListeDocumentAImporter(d);
		}
		else if(d.getNom().compareTo("correction")==0){
			s.setCorrection(d);
		}
		else if(d.getNom().compareTo("sujet")==0){
			s.setSujet(d);
		}
		
	}

}
