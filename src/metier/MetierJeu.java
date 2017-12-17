package metier;

public class MetierJeu {

	private int nombreSecret;
	private boolean fin;
	
	public MetierJeu() {
		super();
		genererSecret();
	}
	public void genererSecret(){
		this.nombreSecret = (int) (Math.random() * 1000);
	}
	public String jouer(int nbr){
		if(fin == false){
			if(nbr > nombreSecret) {
				return "Votre nombre "+nbr+" est plus grand que le nombre secret";
			}else if(nbr < nombreSecret){
				return "Votre nombre "+nbr+" est plus petit que le nombre secret";
			}
			else {
				fin = true;
				return "Bravo ! Vous avez gagné <3 , le nombre secret est bien "+ nombreSecret;
			}
		}else {
			return "Le jeu est terminé ! Le nombre secret qui était cherché : "+ nombreSecret;
		}
	}
	public boolean isFin() {
		return fin;
	}
	public void setFin(boolean fin) {
		this.fin = fin;
	}
	
}
