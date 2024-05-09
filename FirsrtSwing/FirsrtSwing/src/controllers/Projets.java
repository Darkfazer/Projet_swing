package controllers;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class Projets {

    
    private DefaultTableModel model;
    private static Views.DetailsProjet projet;
    private static Views.InsertProject insertprojet;
    
    public Projets() throws SQLException {
        models.Projet projet = new models.Projet();
       model= projet.getModel();
      }

    public void DetailProjet(int row,DefaultTableModel model) throws SQLException {
		Views.Acceuil acceuil = new controllers.VerifyLogin().getAcceuil();
		acceuil.setVisible(false);
		acceuil.dispose();
	projet = new Views.DetailsProjet(row,model);
	}
    public void addProjet() throws SQLException {
		Views.Acceuil acceuil = new controllers.VerifyLogin().getAcceuil();
		acceuil.setVisible(false);
		acceuil.dispose();
		
	insertprojet = new Views.InsertProject();
	}

   public String[] chefs() throws SQLException {
	  
	 
	  DefaultTableModel    mode = new models.Employeur().selectEmpl("chefProjet");
	  String[] objet = new String[mode.getRowCount()];
	 
	   for(int i=0;i<mode.getRowCount();i++) {
		
		  objet[i] =  (String) mode.getValueAt(i, 1);
	   }
	   
	   return objet;
   }
    // Getters for project attributes
  
	public DefaultTableModel getModel() {
		return model;
	}
	
	public DefaultTableModel getQuery(String option) throws SQLException {
		model = new models.Projet().selectProjet(option);
		
		return model;
	}
	
	public void ModifierData(DefaultTableModel model , int row) throws SQLException {
		if(model!= null) { 
			new models.Projet().modifierProjet(model, row);
		}
		
	}
	
	
	
		
	
	
	public void DeletProjet(int id) throws SQLException	{
		new models.Projet().deleteData(id);
	}

	public Views.DetailsProjet getProjet() {
		return projet;
	}

	public static Views.InsertProject getInsertprojet() {
		return insertprojet;
	}
	
	
}
