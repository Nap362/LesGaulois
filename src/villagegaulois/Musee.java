package villagegaulois;

import personnages.Equipement;
import personnages.Gaulois;

public class Musee {
	private Equipement[] trophees = new Equipement[200];
	private int nbTrophee = 0;
	private String[] donnateurs = new String[200];
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		trophees[nbTrophee]= equipement;
		donnateurs[nbTrophee]= gaulois.getNom();
		nbTrophee++;
	}
	
	
	public String extrairenInstructionsCaml() {
		String texte = "let musee = [";
		for (int i=0; i<(nbTrophee-1); i++) {
			texte+= "\"" + donnateurs[i] + "\", \"" + trophees[i] + "\"; ";
		}
		texte += "\"" + donnateurs[nbTrophee-1] + "\", \"" + trophees[nbTrophee-1] + "\"]";
		return texte;
	}

}
