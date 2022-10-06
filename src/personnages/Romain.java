package personnages;

import personnages.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement=0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		assert force>0;
		this.force = force;
		equipements = new Equipement[2];
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "«" + texte + "»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		int forceInitiale=force;
		assert forceInitiale>0;
		force -= forceCoup;
		if (force>0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		} 
		assert force<forceInitiale;
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			equipements[0]=equipement;
			System.out.println("Le soldat "+ nom + " s'équipe avec un " + equipement + ".");
			nbEquipement++;
			break;
		case 1:
			Equipement equipementActuel=equipements[0];
			if (equipementActuel==equipement) {
				System.out.println("Le soldat "+ nom + " possède déjà un " + equipement + " !");
			} else {
				System.out.println("Le soldat "+ nom + " s'équipe avec un " + equipement + ".");
				nbEquipement++;
			}
			break;
		default:
			System.out.println("Le soldat "+ nom + " est déjà bien protégé !");
			break;
		}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.recevoirCoup(3);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
