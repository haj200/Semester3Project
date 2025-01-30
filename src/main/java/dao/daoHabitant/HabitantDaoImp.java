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
    
	public Habitant getUserById(int userId) throws SQLException {
        Habitant habitant = null;
        String query = "SELECT * FROM habitants WHERE id = ?";
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    habitant = new Habitant();
                    habitant.setUsername(resultSet.getString("username"));
                    habitant.setPassword(resultSet.getString("password"));
                    habitant.setNom(resultSet.getString("name"));
                    habitant.setPrenom(resultSet.getString("prenom"));
                    habitant.setEmail(resultSet.getString("email"));
                    habitant.setAddresse(resultSet.getString("addresse"));
                    habitant.setCin(resultSet.getString("cin"));
                    habitant.setMetier(resultSet.getString("metier"));
                    
                    // Ajoutez d'autres attributs si nécessaires
                }
            }
        }
        return habitant;
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
	    }      }
	

	

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
	    } 
	   
	    
	    return habitant;
	}
	@Override
	public int getHabitantsCount() {
	    int count = 0;
	    String query = "SELECT COUNT(*) FROM habitants";
	    try (Connection conn = daoFactory.getConnection();
	         PreparedStatement ps = conn.prepareStatement(query);
	         ResultSet rs = ps.executeQuery()) {
	        if (rs.next()) {
	            count = rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return count;
	}
	@Override
	public List<Habitant> getHabitantsPaginated(int start, int rowsPerPage) {
	    List<Habitant> habitants = new ArrayList<>();
	    String query = "SELECT * FROM habitants LIMIT ?, ?";
	    try (Connection conn = daoFactory.getConnection();
	         PreparedStatement ps = conn.prepareStatement(query)) {
	        ps.setInt(1, start);
	        ps.setInt(2, rowsPerPage);
	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                Habitant habitant = new Habitant();
	                habitant.setId(rs.getInt("id"));
	                habitant.setNom(rs.getString("nom"));
	                habitant.setPrenom(rs.getString("prenom"));
	                habitant.setUsername(rs.getString("username"));
	                habitant.setEmail(rs.getString("email"));
	                habitant.setCin(rs.getString("cin"));
	                habitant.setAddresse(rs.getString("addresse"));
	                habitant.setDateDeNaissance(rs.getDate("dateDeNaissance").toLocalDate());
	                habitant.setMetier(rs.getString("metier"));
	                habitants.add(habitant);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return habitants;
	}


	@Override
	public Habitant getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}


}
