package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] listeEquipement;
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
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
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}

	private String ajouterEquipement(Equipement equipement, String texte) {
		this.listeEquipement[this.nbEquipement] = equipement;
		this.nbEquipement++;
		texte += " s'équipe avec un " + equipement.getEquipement() + "!";
		return texte;
	}

	public String sEquiper(Equipement equipement) {
		String texte = "Le soldat ";
		texte += this.getNom();
		switch (this.nbEquipement) {
		case 2: {
			texte += " est déjà bien protégé!";
			return texte;
		}
		case 1:
			if (this.listeEquipement[this.nbEquipement - 1] == equipement) {
				texte += " a déjà un " + equipement.getEquipement() + "!";
				return texte;
			} else {
				return ajouterEquipement(equipement, texte);
			}
		case 0:
			return ajouterEquipement(equipement, texte);
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.nbEquipement);
		}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}

}
