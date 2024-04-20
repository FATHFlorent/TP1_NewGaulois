package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nb_trophees;
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
				&& tropheesObtenus[i] != null; i++, nb_trophees++) {
			this.trophees[nb_trophees] = tropheesObtenus[i];
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

	public void faireUneDonnation(Musee musee) {
		if (trophees != null) {
			String texte = "Je donne au musee tout mes trophees :";
			for (int i = 0; i < nb_trophees; i++) {
				texte += "\n-" + trophees[i].getEquipement();
			}
			this.parler(texte);
		}
	}

	public static void main(String[] args) {

	}
}