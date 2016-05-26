package Modell;

public class Nachricht {

	private User von ;
	private User zu ; 
	private String nachricht ; 
	
	public User getVon() {
		return von;
	}

	public void setVon(User von) {
		this.von = von;
	}

	public User getZu() {
		return zu;
	}

	public void setZu(User zu) {
		this.zu = zu;
	}

	public String getNachricht() {
		return nachricht;
	}

	public void setNachricht(String nachricht) {
		this.nachricht = nachricht;
	}

	public Nachricht (User a , User b , String nachricht){
		
		this.von = a; 
		this.zu = b ; 
		this.nachricht= nachricht; 
	}
	
}
