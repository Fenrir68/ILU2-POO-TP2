package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(!this.controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolé "+nomVendeur+" mais il faut être un habitant du village pour commercer ici.");
		}else {
			System.out.println("Bonjour "+nomVendeur+", je vais regarder si je peux vous trouver un étal.");
			if(!this.controlPrendreEtal.resteEtals()) {
				System.out.println("Désolé "+nomVendeur+" je n'ai plus d'étal qui ne soit pas occupé.");
			}else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait il me reste un étal pour vous!\nIlme faudra quelques renseignements:");
		String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre?");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre?");
		int numEtal = this.controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numEtal!=-1) {
			System.out.println("Le vendeur "+nomVendeur+" s'est bien installé a l'étal n°"+numEtal);
		}
	}
}
