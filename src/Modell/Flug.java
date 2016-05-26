package Modell;

public class Flug {

	
	private String abflug ; 
	private String ankunft;
	private double preis;
	private int sitzAnzahl; 
	
	
	public Flug ( String abflug , String ankunft , double preis, int sitzAnzahl){
		this.abflug = abflug;
		this.ankunft=ankunft; 
		this.preis = preis ;
		this.sitzAnzahl = sitzAnzahl ;
		
	}


	public String getAbflug() {
		return abflug;
	}


	public void setAbflug(String abflug) {
		this.abflug = abflug;
	}


	public String getAnkunft() {
		return ankunft;
	}


	public void setAnkunft(String ankunft) {
		this.ankunft = ankunft;
	}


	public double getPreis() {
		return preis;
	}


	public void setPreis(double preis) {
		this.preis = preis;
	}


	public int getSitzAnzahl() {
		return sitzAnzahl;
	}


	public void setSitzAnzahl(int sitzAnzahl) {
		this.sitzAnzahl = sitzAnzahl;
	}
	
	
	
}
