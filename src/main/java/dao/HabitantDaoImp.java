package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Habitant;


public class HabitantDaoImp implements HabitantDao {

	private DAOFactory daoFactory;

	public HabitantDaoImp(DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	}

	@Override
	public void createHabitant(Habitant h) {
		 Connection connexion = null;
	      Statement statement = null;
	      String username = h.getUsername();
	      String nom = h.getNom();
	      String prenom = h.getPrenom();
	      String password = h.getPassword();
	      String cin = h.getCin();
	      String addresse = h.getAddresse();
	      Date dateDeNaissance = h.getDateDeNaissance();
	      String metier = h.getMetier();
	      String email = h.getEmail();

	      try {
	          connexion = daoFactory.getConnection();

	          // Using a PreparedStatement to prevent SQL injection and to set the parameters
	          String sql = "INSERT INTO habitants (username, nom, prenom, password, cin, addresse, dateDeNaissance, metier, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	          PreparedStatement preparedStatement = connexion.prepareStatement(sql);

	          
	          preparedStatement.setString(1, username);
	          preparedStatement.setString(2, nom);
	          preparedStatement.setString(3, prenom);
	          preparedStatement.setString(4, password);
	          preparedStatement.setString(5, cin);
	          preparedStatement.setString(6, addresse);
	          preparedStatement.setDate(7, new java.sql.Date(dateDeNaissance.getTime())); // Convert java.util.Date to java.sql.Date
	          preparedStatement.setString(8, metier);
	          preparedStatement.setString(9, email);

	         
	          int rowsInserted = preparedStatement.executeUpdate();
	          if (rowsInserted > 0) {
	              System.out.println("L'habitant est inseré avec succès! ");
	          }
	      } catch (SQLException e) {
	          e.printStackTrace();
	      } finally {
	    	   
	    	    if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
	    	    if (connexion != null) try { connexion.close(); } catch (SQLException ignore) {}
	    	}
		

	}

	

	@Override
	public List<Habitant> habitants() {
		List<Habitant> habitants = new ArrayList<Habitant>();
	      Connection connexion = null;
	      Statement statement = null;
	      ResultSet resultat = null;
	      try {
	          connexion = daoFactory.getConnection();
	          statement = connexion.createStatement();
	          resultat = statement.executeQuery("SELECT *  FROM habitants;");
	          while (resultat.next()) {
	        	  int id= resultat.getInt("id");
	        	  String username= resultat.getString("username");
	              String nom = resultat.getString("nom");
	              String prenom= resultat.getString("prenom");
	              String password= resultat.getString("password");
	              String cin= resultat.getString("cin");
	              String addresse= resultat.getString("addresse");
	              Date dateDeNaissance= resultat.getDate("dateDeNaissance");
	              String metier= resultat.getString("metier");
	              String email= resultat.getString("email");

	             Habitant habitant = new Habitant();
	             habitant.setId(id);
	             habitant.setUsername(username);
	             habitant.setNom(nom);
	             habitant.setPrenom(prenom);
	             habitant.setPassword(password);
	             habitant.setCin(cin);
	             habitant.setAddresse(addresse);
	             habitant.setDateDeNaissance(dateDeNaissance);
	             habitant.setMetier(metier);
	             habitant.setEmail(email);

	             habitants.add(habitant);

	              
	          }
	      } catch (SQLException e) {
	          e.printStackTrace();
	      }
	      return habitants;
	}

	@Override
	public void updateHabitant(Habitant u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteHabitant(int id) {
		// TODO Auto-generated method stub

	}

}
