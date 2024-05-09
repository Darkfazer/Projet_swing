package controllers;

import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.table.DefaultTableModel;

import Views.DetailsProjet;

public class Taches {
	
	 private DefaultTableModel model;
	 private static Views.InserTache insertache;
	 private static String nomProjet;
	 public void setNomProjet(String nom) {
		 this.nomProjet = nom;
	 }
	public Taches() throws SQLException {
		
		 models.Taches tache = new models.Taches();
	    model = tache.getModel();
	}
	public DefaultTableModel getModel() {
		return model;
	}
	
	 public void addtache(Object[] modell,int indix) throws SQLException, ParseException {
		
		 if(indix==1) {
			 new models.Projet().InsertData(modell);	
			Views.InsertProject  projet = new controllers.Projets().getInsertprojet();
			projet.setVisible(false);
			projet.dispose();	
		insertache = new Views.InserTache((String) modell[0]);
		 }else {
			 new models.Taches().InserTache(modell,nomProjet);	
		 }
		}
	
	public void LesTache(int row) throws SQLException {
		
		Views.DetailsProjet tache = new  controllers.Projets().getProjet();
		tache.setVisible(false);
		tache.dispose();
		new Views.Taches();
		}
	public Views.InserTache getInsertache() {
		return insertache;
	}

}
