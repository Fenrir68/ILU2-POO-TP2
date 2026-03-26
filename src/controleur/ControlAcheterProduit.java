package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isAcheteur(String nomAcheteur) {
		return this.controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	
	public String[] trouverEtalProduit(String produit) {
		Gaulois[] gauloisList = this.village.rechercherVendeursProduit(produit);
		String[] noms = new String[gauloisList.length];
		for(int i=0; i<gauloisList.length; i++) {
			noms[i]=gauloisList[i].getNom();
		}
		return noms;
	}
	
	public int acheterProduit(String nomVendeur, int quantite) {
		return this.controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).acheterProduit(quantite);
	}
}
