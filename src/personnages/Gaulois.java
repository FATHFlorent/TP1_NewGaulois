package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//public void frapper(Romain romain) {
//System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//romain.recevoirCoup(force / 3);
//}

	public void frapper(Romain romain) {
		System.out.println(this.getNom() + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesObtenus = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesObtenus != null && i < tropheesObtenus.length
				&& tropheesObtenus[i] != null; i++, nbTrophees++) {
			this.trophees[nbTrophees] = tropheesObtenus[i];
		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée.");
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) {

	}
}
