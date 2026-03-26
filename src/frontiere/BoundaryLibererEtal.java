package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if(!this.controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		}else {
			String[] donneeEtal = this.controlLibererEtal.libererEtal(nomVendeur);
			if(donneeEtal[0].equals("true")) {
				System.out.println("Vous avez vendu "+donneeEtal[4]+" sur "+donneeEtal[3]+donneeEtal[2]+".");
				System.out.println("Au revoir "+nomVendeur+" passez une bonne journée.");
			}
		}
	}

}
