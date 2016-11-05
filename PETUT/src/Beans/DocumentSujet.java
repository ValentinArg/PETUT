package Beans;

public class DocumentSujet {
	
	private int idSujet;
	private int idDocument;
	private String type;
	private String typeDocumentSujet;
	
	
	public DocumentSujet(int idSujet, int idDocument, String type) {
		super();
		this.idSujet = idSujet;
		this.idDocument = idDocument;
		this.type = type;
	}
	
	public String getTypeDocumentSujet() {
		return typeDocumentSujet;
	}
	public void setTypeDocumentSujet(String typeDocumentSujet) {
		this.typeDocumentSujet = typeDocumentSujet;
	}
	public int getIdSujet() {
		return idSujet;
	}
	public void setIdSujet(int idSujet) {
		this.idSujet = idSujet;
	}
	public int getIdDocument() {
		return idDocument;
	}
	public void setIdDocument(int idDocument) {
		this.idDocument = idDocument;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
