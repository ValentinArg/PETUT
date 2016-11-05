package Beans;

import java.util.*;

public abstract class Outils {
	
	public static void decouperListDocumentSujet(List<Document> listeDocuments,Sujet s){
		for(Document d : listeDocuments){
			if(d.getNom()=="document à importer"){
				s.addListeDocumentsAImporter(d);
			}
			else if(d.getNom()=="correction"){
				s.setCorrection(d);
			}
			else if(d.getNom()=="sujet"){
				s.setSujet(d);
			}
		}
	}

}
