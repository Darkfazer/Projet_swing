package controllers;

import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JList;

public class Employe {
	private static Views.selectResource ressource;
	public Employe() {}
	
	
	 public void openRessource(JList<String> jList,String[] nomTache) throws SQLException {
			Views.InserTache  tache = new controllers.Taches().getInsertache();
			tache.setVisible(false);
			tache.dispose();
	   ressource = new Views.selectResource(jList,nomTache);
		}


	public Views.selectResource getRessource() {
		return ressource;
	}
	public void suivant() throws SQLException {
		new controllers.Produit().suivant();
	}


}
