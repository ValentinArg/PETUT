package Beans;

import java.util.*;

public abstract class Outils {
	
	public static void decouperListDocumentSujet(Document d,Sujet s){
		if(d.getNom().compareTo("document � importer")==0){
			//s.addListeDocumentsAImporter(d);
		}
		else if(d.getNom().compareTo("correction")==0){
			s.setCorrection(d);
		}
		else if(d.getNom().compareTo("sujet")==0){
			//s.setSujet(d);
		}
		
	}

}
