package Controller;

import Modell.Flug;

public class FlugManagement {
	
	private Flug flug ; 
	private DB db; 
	
	public FlugManagement(){
		this.db = new DB (); 
	}
	public void createFlug ( String abflug , String ankunft , double preis, int sitzAnzahl){
		
		flug = new Flug(abflug ,  ankunft ,  preis,  sitzAnzahl);
		this.saveFlugDB (flug);
	}
	
	private void saveFlugDB(Flug flug){
		
		String sql = "INSERT INTO flug VALUES ("+this.flug.getAbflug()+
				" , "+this.flug.getAnkunft() + " , "+this.flug.getPreis()+" , "+ this.flug.getSitzAnzahl()+")";

		db.saveData(sql);
	}
	
}
