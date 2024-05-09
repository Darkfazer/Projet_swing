package controllers;

import java.sql.SQLException;

import javax.swing.JList;

public class Acceuil {
	private static Views.Acceuil acceuil;
	public Acceuil() {}
	
	public void terminer() throws SQLException {
		Views.Produits  produit = new controllers.Produit().getProduit();
		produit.setVisible(false);
		produit.dispose();
		//new controllers.VerifyLogin();
   acceuil = new Views.Acceuil("Admine");
   }

	public void start() throws SQLException {
		Views.Log  produit = new controllers.VerifyLogin().getStart();
		produit.setVisible(false);
		produit.dispose();
   acceuil = new Views.Acceuil("Admine");
   }
	public static Views.Acceuil getAcceuil() {
		return acceuil;
	}

}
