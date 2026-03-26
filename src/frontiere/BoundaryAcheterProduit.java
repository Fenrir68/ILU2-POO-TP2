package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if(!this.controlAcheterProduit.isAcheteur(nomAcheteur)) {
			System.out.println("Je suis désolée "+nomAcheteur+" mais il faut être un habitant de notre village pour commercer ici.");
		}else {
			String produitCherche = Clavier.entrerChaine("Quel produit voulez-vous acheter?");
			String[] vendeurs = this.controlAcheterProduit.trouverEtalProduit(produitCherche);
			if(vendeurs.length==0) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			}else {
				int select;
				do {
				System.out.println("Chez quel commerçant voulez-vous acheter des fleurs ?");
				for(int i=1; i<=vendeurs.length; i++) {
					System.out.println(i+"- "+vendeurs[i-1]);
				}
				select = Clavier.entrerEntier("");
				}while(select<1 || select>vendeurs.length);
				System.out.println(nomAcheteur+" se déplace jusqu'à l'étal du vendeur "+vendeurs[--select]);
				System.out.println("Bonjour "+nomAcheteur);
				int nbWanted = Clavier.entrerEntier("Combien de "+produitCherche+" voulez-vous achetez?");
				int nbGeted = this.controlAcheterProduit.acheterProduit(vendeurs[select], nbWanted);
				if(nbGeted==0) {
					System.out.println(nomAcheteur+" veut acheter "+nbWanted+" "+produitCherche+", malheureusement il n’y en a plus !");
				}else if(nbGeted<nbWanted) {
					System.out.println(nomAcheteur+" veut acheter "+nbWanted+" "+produitCherche+", malheureusement "+vendeurs[select]+" n'en a plus que "+nbGeted+". "+nomAcheteur+" achète tout le stock de "+vendeurs[select]);
				}else {
					System.out.println(nomAcheteur+" achète "+nbGeted+" "+produitCherche+" à "+vendeurs[select]);
				}
			}
		}
	}
}
