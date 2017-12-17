package web;

import java.util.ArrayList;
import java.util.List;

public class ModeleJeu {
	
	private int nombre;
	private List<String> historique = new ArrayList<>();
	private int tentative;
	
	public ModeleJeu() {
		super();
		tentative = 0;
	}
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public int getTentative() {
		return tentative;
	}
	public void setTentative(int tentative) {
		this.tentative = tentative;
	}
	public List<String> getHistorique() {
		return historique;
	}
	public void setHistorique(List<String> historique) {
		this.historique = historique;
	}
	

}
