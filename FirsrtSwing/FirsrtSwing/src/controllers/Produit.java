package controllers;

import java.sql.SQLException;

import javax.swing.JList;

public class Produit {
	
	private static Views.Produits produit;
	public Produit() {
		
	}
	
	public void suivant(JList<String> jList,String[] nomTache) throws SQLException {
		Views.selectResource  employe = new controllers.Employe().getRessource();
		employe.setVisible(false);
		employe.dispose();
   produit = new Views.Produits(jList, nomTache);
	}

	public static Views.Produits getProduit() {
		return produit;
	}

}
