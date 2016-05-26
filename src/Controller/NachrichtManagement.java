package Controller;

import Modell.Nachricht;
import Modell.User;

public class NachrichtManagement {
	private Nachricht n ; 
	private DB db; 

	public NachrichtManagement(){
		this.db = new DB (); 
	}
	
	public void nachrichtSenden(User a , User b , String nachricht){
		
		n = new Nachricht (a ,b,nachricht);
		this.saveNachrichtDB(n);
	}
	
	private void saveNachrichtDB(Nachricht n){
		
		String sql = "INSERT INTO nachricht VALUES ("+n.getVon() +
				" , "+n.getZu() + " , "+n.getNachricht()+")";

		db.saveData(sql);
	}
}
