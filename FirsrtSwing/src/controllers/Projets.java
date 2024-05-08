package controllers;


import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class Projets {

    
    private DefaultTableModel model;

    public Projets() throws SQLException {
      models.Projet projet = new models.Projet();
     model= projet.getModel();
    }

    // Getters for project attributes
  
	public DefaultTableModel getModel() {
		return model;
	}
	
	public DefaultTableModel getQuery(String option) throws SQLException {
		model = new models.Projet().selectProjet(option);
		
		return model;
	}
}
