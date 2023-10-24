package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] listeEquipement;
	private int nbEquipement;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public int getForce() {
		return force;
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

//public void recevoirCoup(int forceCoup) {
//force -= forceCoup;
//if (force > 0) {
//parler("Aïe");
//} else {
//parler("J'abandonne...");
//}
//}

//TP3 -> 
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		assert force < oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((listeEquipement[i] != null && listeEquipement[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup < 0) {
			forceCoup = 0;
		}
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[this.nbEquipement];
		System.out.println("L'équipement de " + this.getNom() + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < this.nbEquipement; i++) {
			if (listeEquipement[i] != null) {
				equipementEjecte[nbEquipementEjecte] = listeEquipement[i];
				nbEquipementEjecte++;
				listeEquipement[i] = null;
			}
		}
		return equipementEjecte;
	}

//...

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
