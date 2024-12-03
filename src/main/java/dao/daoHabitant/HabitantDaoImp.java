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
	public void updateHabitant(Habitant h) {
		// TODO Auto-generated method stub
	
		    Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    try {
		        // Récupérer la connexion à la base de données
		        connexion = daoFactory.getConnection();
		        
		        // SQL pour mettre à jour un habitant existant dans la base de données
		        String sql = "UPDATE habitants SET username = ?, nom = ?, prenom = ?, email = ?, password = ?, cin = ?, addresse = ?, dateDeNaissance = ?, metier = ? WHERE id = ?";
		        
		        // Préparer la requête
		        preparedStatement = connexion.prepareStatement(sql);
		        
		        // Remplacer les paramètres de la requête préparée
		        preparedStatement.setString(1, h.getUsername());
		        preparedStatement.setString(2, h.getNom());
		        preparedStatement.setString(3, h.getPrenom());
		        preparedStatement.setString(4, h.getEmail());
		        preparedStatement.setString(5, h.getPassword());
		        preparedStatement.setString(6, h.getCin());
		        preparedStatement.setString(7, h.getAddresse());
		        preparedStatement.setDate(8, Date.valueOf(h.getDateDeNaissance())); // Convertir LocalDate en Date
		        preparedStatement.setString(9, h.getMetier());
		        preparedStatement.setInt(10, h.getId());
		        
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

	

	@Override
	public void deleteHabitant(int id) {
		// TODO Auto-generated method stub
		
		    Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    try {
		        // Récupérer la connexion à la base de données
		        connexion = daoFactory.getConnection();
		        
		        // SQL pour supprimer un habitant existant dans la base de données
		        String sql = "DELETE FROM habitants WHERE id = ?";
		        
		        // Préparer la requête
		        preparedStatement = connexion.prepareStatement(sql);
		        
		        // Remplacer le paramètre de la requête préparée
		        preparedStatement.setInt(1, id); // Set the habitant ID to identify which habitant to delete
		        
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

	

	@Override
	public Habitant getHabitantById(int id) {
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Habitant habitant = null;
	    
	    try {
	        // Récupérer la connexion à la base de données
	        connexion = daoFactory.getConnection();
	        
	        // SQL pour récupérer un habitant par son ID
	        String sql = "SELECT * FROM habitants WHERE id = ?";
	        
	        // Préparer la requête
	        preparedStatement = connexion.prepareStatement(sql);
	        
	        // Remplacer le paramètre de la requête préparée avec l'ID de l'habitant
	        preparedStatement.setInt(1, id);
	        
	        // Exécuter la requête et récupérer le résultat
	        resultSet = preparedStatement.executeQuery();
	        
	        // Vérifier si un habitant avec cet ID existe
	        if (resultSet.next()) {
	            // Récupérer les données de l'habitant depuis le ResultSet
	            int habitantId = resultSet.getInt("id");
	            String username = resultSet.getString("username");
	            String nom = resultSet.getString("nom");
	            String prenom = resultSet.getString("prenom");
	            String email = resultSet.getString("email");
	            String password = resultSet.getString("password");
	            String cin = resultSet.getString("cin");
	            String addresse = resultSet.getString("addresse");
	            LocalDate dateDeNaissance = resultSet.getDate("dateDeNaissance").toLocalDate();
	            String metier = resultSet.getString("metier");
	            
	            // Créer un objet Habitant avec les données récupérées
	            habitant = new Habitant(habitantId, username, nom, prenom, email, password, cin, addresse, dateDeNaissance, metier);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace(); // Gérer l'exception
	    } finally {
	        // Fermer les ressources pour éviter les fuites de mémoire
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
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
	    
	    return habitant;
	}
	@Override
	public Habitant getHabitantByusername(String username) {
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Habitant habitant = null;
	    
	    try {
	        // Récupérer la connexion à la base de données
	        connexion = daoFactory.getConnection();
	        
	        // SQL pour récupérer un habitant par son ID
	        String sql = "SELECT * FROM habitants WHERE username = ?";
	        
	        // Préparer la requête
	        preparedStatement = connexion.prepareStatement(sql);
	        
	        // Remplacer le paramètre de la requête préparée avec l'ID de l'habitant
	        preparedStatement.setString(1, username);
	        
	        // Exécuter la requête et récupérer le résultat
	        resultSet = preparedStatement.executeQuery();
	        
	        // Vérifier si un habitant avec cet ID existe
	        if (resultSet.next()) {
	            // Récupérer les données de l'habitant depuis le ResultSet
	            int habitantId = resultSet.getInt("id");
	            String nom = resultSet.getString("nom");
	            String prenom = resultSet.getString("prenom");
	            String email = resultSet.getString("email");
	            String password = resultSet.getString("password");
	            String cin = resultSet.getString("cin");
	            String addresse = resultSet.getString("addresse");
	            LocalDate dateDeNaissance = resultSet.getDate("dateDeNaissance").toLocalDate();
	            String metier = resultSet.getString("metier");
	            
	            // Créer un objet Habitant avec les données récupérées
	            habitant = new Habitant(habitantId, username, nom, prenom, email, password, cin, addresse, dateDeNaissance, metier);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace(); // Gérer l'exception
	    } finally {
	        // Fermer les ressources pour éviter les fuites de mémoire
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
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
	    
	    return habitant;
	}


}
