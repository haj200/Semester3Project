package dao.daoReclamation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import beans.Habitant;
import beans.Reclamation;
import dao.DAOFactory;

public class ReclamationDaoImp implements ReclamationDao {
    private DAOFactory daoFactory;

    public ReclamationDaoImp(DAOFactory daoFactory) {
        super();
        this.daoFactory = daoFactory;
    }

    @Override
    public void createReclamation(Reclamation r) {
        // TODO Auto-generated method stub
    	
    	    Connection connexion = null;
    	    PreparedStatement preparedStatement = null;
    	    try {
    	        connexion = daoFactory.getConnection();
    	        String sql = "INSERT INTO reclamations(message, reponse, id_habitant) VALUES(?, ?, ?)";
    	        preparedStatement = connexion.prepareStatement(sql);
    	        
    	        preparedStatement.setString(1, r.getMessage());
    	        preparedStatement.setString(2, r.getReponse());
    	        preparedStatement.setInt(3, r.getHabitant().getId());

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
    public List<Reclamation> reclamations() {
        List<Reclamation> reclamations = new ArrayList<>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            
            // Requête SQL pour récupérer les réclamations avec les informations de l'habitant
            String query = "SELECT r.id, r.message, r.reponse, " +
                           "h.nom AS habitantNom, h.prenom AS habitantPrenom " +
                           "FROM reclamations r " +
                           "JOIN habitants h ON r.id_habitant = h.id;";
            
            resultat = statement.executeQuery(query);
            
            while (resultat.next()) {
                int id = resultat.getInt("id");
                String message = resultat.getString("message");
                String reponse = resultat.getString("reponse");

                // Récupérer les informations de l'habitant
                String habitantNom = resultat.getString("habitantNom");
                String habitantPrenom = resultat.getString("habitantPrenom");

                // Création de l'objet Habitant avec les informations nécessaires
                Habitant habitant = new Habitant();
                habitant.setNom(habitantNom);
                habitant.setPrenom(habitantPrenom);

                // Création de l'objet Reclamation
                Reclamation reclamation = new Reclamation();
                reclamation.setId(id);
                reclamation.setMessage(message);
                reclamation.setReponse(reponse);
                reclamation.setHabitant(habitant);

                // Ajout de l'objet Reclamation à la liste
                reclamations.add(reclamation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermeture des ressources
            try {
                if (resultat != null) resultat.close();
                if (statement != null) statement.close();
                if (connexion != null) connexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return reclamations;
    }

    @Override
    public void updateReclamation(Reclamation r) {
        // TODO Auto-generated method stub
    	
    	    Connection connexion = null;
    	    PreparedStatement preparedStatement = null;
    	    try {
    	        // Récupérer la connexion à la base de données
    	        connexion = daoFactory.getConnection();
    	        
    	        // SQL pour mettre à jour une réclamation existante dans la base de données
    	        String sql = "UPDATE reclamations SET message = ?, reponse = ?, id_habitant= ? WHERE id = ?";
    	        
    	        // Préparer la requête
    	        preparedStatement = connexion.prepareStatement(sql);
    	        
    	        // Remplacer les paramètres de la requête préparée
    	        preparedStatement.setString(1, r.getMessage());
    	        preparedStatement.setString(2, r.getReponse());
    	        preparedStatement.setInt(3, r.getHabitant().getId()); // Associer l'ID de l'habitant
    	        preparedStatement.setInt(4, r.getId()); // Utiliser l'ID de la réclamation pour identifier laquelle mettre à jour
    	        
    	        // Exécuter la mise à jour
    	        preparedStatement.executeUpdate();
    	        
    	    } catch (SQLException e) {
    	        e.printStackTrace(); // Gérer l'exception
    	    } finally {
    	        try {
    	            // Fermer le PreparedStatement et la connexion pour éviter les fuites de ressources
    	            if (preparedStatement != null) {
    	                preparedStatement.close();
    	            }
    	            if (connexion != null) {
    	                connexion.close();
    	            }
    	        } catch (SQLException e) {
    	            e.printStackTrace(); // Gérer l'exception pendant la fermeture
    	        }
    	    }
    	}

    public Reclamation getReclamationById(int id) {
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	ResultSet resultSet = null; 
    	Reclamation reclamation = null;
    	try { 
    		// Get a connection from the DAOFactory
    		connection = daoFactory.getConnection(); 
    		// Prepare the SQL query 
    		String sql = "SELECT r.id, r.message, r.reponse, r.id_habitant, h.username, h.nom, h.prenom, h.email, h.password, h.cin, h.addresse, h.dateDeNaissance, h.metier FROM reclamations r JOIN habitants h ON r.id_habitant = h.id WHERE r.id = ?";
    		preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setInt(1, id); 
    		// Execute the query 
    		resultSet = preparedStatement.executeQuery();
    		if (resultSet.next()) {
    			Habitant habitant = new Habitant( resultSet.getInt("id_habitant"), resultSet.getString("username"), 
    					                          resultSet.getString("nom"), resultSet.getString("prenom"),
    					                          resultSet.getString("email"), resultSet.getString("password"),
    					                          resultSet.getString("cin"), resultSet.getString("addresse"),
    					                          resultSet.getDate("dateDeNaissance").toLocalDate(),
    					                          resultSet.getString("metier") );
    			reclamation = new Reclamation( resultSet.getInt("id"), resultSet.getString("message"), resultSet.getString("reponse"), habitant ); } } 
    	catch (SQLException e) { e.printStackTrace();
    	} finally {
    		try { if (resultSet != null) resultSet.close();
    		if (preparedStatement != null) preparedStatement.close();
    		if (connection != null) connection.close(); } 
    		catch (SQLException e) { e.printStackTrace(); } } 
    	   return reclamation; }
    	
    

    @Override
    public void deleteReclamation(int id) {
        // TODO Auto-generated method stub
    	Connection connexion = null;
    	PreparedStatement preparedStatement = null;
    	try {
    	    // Récupérer la connexion à la base de données
    	    connexion = daoFactory.getConnection();
    	    
    	    // SQL pour supprimer une réclamation existante dans la base de données
    	    String sql = "DELETE FROM reclamations WHERE id = ?";
    	    
    	    // Préparer la requête
    	    preparedStatement = connexion.prepareStatement(sql);
    	    
    	    // Remplacer le paramètre de la requête préparée
    	    preparedStatement.setInt(1, id); // Set the reclamation ID to identify which reclamation to delete
    	    
    	    // Exécuter la suppression
    	    preparedStatement.executeUpdate();
    	    
    	} catch (SQLException e) {
    	    e.printStackTrace(); // Gérer l'exception
    	} finally {
    	    try {
    	        // Fermer le PreparedStatement et la connexion pour éviter les fuites de ressources
    	        if (preparedStatement != null) {
    	            preparedStatement.close();
    	        }
    	        if (connexion != null) {
    	            connexion.close();
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace(); // Gérer l'exception pendant la fermeture
    	    }
    	}

    }

}
