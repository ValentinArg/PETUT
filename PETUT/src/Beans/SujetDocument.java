package Beans;

import java.util.*;

public class SujetDocument {

	private Document sujet;
	private Document correction;
	private List<Document> listeDocumentsAImporter;
	
	public SujetDocument() {
		super();
		this.listeDocumentsAImporter = new ArrayList<Document>();
	}
	public Document getSujet() {
		return sujet;
	}
	public void setSujet(Document sujet) {
		this.sujet = sujet;
	}
	public Document getCorrection() {
		return correction;
	}
	public void setCorrection(Document correction) {
		this.correction = correction;
	}
	public List<Document> getListeDocumentsAImporter() {
		return listeDocumentsAImporter;
	}
	public void setListeDocumentsAImporter(List<Document> listeDocumentsAImporter) {
		this.listeDocumentsAImporter = listeDocumentsAImporter;
	}
	public void addListeDocumentAImporter(Document d){
		this.listeDocumentsAImporter.add(d);
	}
	
}
