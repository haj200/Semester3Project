package dao.daoHabitant;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import beans.Habitant;
import dao.DAOFactory;
import utils.DateUtils;


public class HabitantDaoImp implements HabitantDao {

	private DAOFactory daoFactory;

	public HabitantDaoImp(DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	}

	@Override
	public void createHabitant(Habitant h) {
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;

	    try {
	       
	        connexion = daoFactory.getConnection();

	        
	        String sql = "INSERT INTO habitants (username, nom, prenom, password, cin, addresse, dateDeNaissance, metier, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        preparedStatement = connexion.prepareStatement(sql);

	       
	        preparedStatement.setString(1, h.getUsername());
	        preparedStatement.setString(2, h.getNom());
	        preparedStatement.setString(3, h.getPrenom());
	        preparedStatement.setString(4, h.getPassword());
	        preparedStatement.setString(5, h.getCin());
	        preparedStatement.setString(6, h.getAddresse());
	        preparedStatement.setDate(7, java.sql.Date.valueOf(h.getDateDeNaissance())); 
	        preparedStatement.setString(8, h.getMetier());
	        preparedStatement.setString(9, h.getEmail());

	       
	        preparedStatement.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        
	        try {
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (connexion != null) {
	                connexion.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


	

	@Override
	public List<Habitant> habitants() {
	    List<Habitant> habitants = new ArrayList<>();
	    Connection connexion = null;
	    Statement statement = null;
	    ResultSet resultat = null;

	    try {
	        // Establish a connection
	        connexion = daoFactory.getConnection();
	        statement = connexion.createStatement();
	        resultat = statement.executeQuery("SELECT * FROM habitants");

	        // Loop through the result set
	        while (resultat.next()) {
	            int id = resultat.getInt("id");
	            String username = resultat.getString("username");
	            String nom = resultat.getString("nom");
	            String prenom = resultat.getString("prenom");
	            String password = resultat.getString("password");
	            String cin = resultat.getString("cin");
	            String addresse = resultat.getString("addresse");
	            LocalDate dateDeNaissance = resultat.getDate("dateDeNaissance").toLocalDate(); // Convert to LocalDate
	            String metier = resultat.getString("metier");
	            String email = resultat.getString("email");

	            // Create a Habitant object and populate its fields
	            Habitant habitant = new Habitant();
	            habitant.setId(id);
	            habitant.setUsername(username);
	            habitant.setNom(nom);
	            habitant.setPrenom(prenom);
	            habitant.setPassword(password);
	            habitant.setCin(cin);
	            habitant.setAddresse(addresse);
	            habitant.setDateDeNaissance(dateDeNaissance); // Set LocalDate
	            habitant.setMetier(metier);
	            habitant.setEmail(email);

	            // Add the habitant to the list
	            habitants.add(habitant);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Close resources
	        try {
	            if (resultat != null) {
	                resultat.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	            if (connexion != null) {
	                connexion.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
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

	@Override
	public Habitant getHabitantById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
