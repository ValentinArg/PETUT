package Beans;

public class Document {
	
	private int id;
	private String lienAcces;
	private String date;
	
	public Document(int id, String lienAcces, String date) {
		super();
		this.id = id;
		this.lienAcces = lienAcces;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLienAcces() {
		return lienAcces;
	}
	public void setLienAcces(String lienAcces) {
		this.lienAcces = lienAcces;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
