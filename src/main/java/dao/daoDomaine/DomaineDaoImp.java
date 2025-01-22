package dao.daoDomaine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Domaine;
import dao.DAOFactory;

public class DomaineDaoImp implements DomaineDao {
	private DAOFactory daoFactory;
	
	public DomaineDaoImp(DAOFactory daoFactory) {
		super();
		this.daoFactory = daoFactory;
	}
	@Override
	public int getDomainesCount() {
	    int count = 0;
	    String query = "SELECT COUNT(*) FROM domaines";
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
	public List<Domaine> getDomainesPaginated(int start, int rowsPerPage) {
	    List<Domaine> domaines = new ArrayList<>();
	    String query = "SELECT * FROM domaines LIMIT ?, ?";
	    try (Connection conn = daoFactory.getConnection();
	         PreparedStatement ps = conn.prepareStatement(query)) {
	        ps.setInt(1, start);
	        ps.setInt(2, rowsPerPage);
	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                Domaine domaine = new Domaine();
	                domaine.setId(rs.getInt("id"));
	                domaine.setNom(rs.getString("nom"));
	                domaine.setDescription(rs.getString("description"));
	                domaine.setCriteres(rs.getString("criteres"));
	                domaines.add(domaine);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return domaines;
	}



	@Override
	public void createDomaine(Domaine d) {
		// TODO Auto-generated method stub
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    try {
		       
	        connexion = daoFactory.getConnection();
	        String sql = "INSERT INTO domaines(nom,description,criteres) VALUES(?,?,?)";
	        preparedStatement =connexion.prepareStatement(sql);
	        
	        	preparedStatement.setString(1,d.getNom());
	        	preparedStatement.setString(2,d.getDescription());
	        	preparedStatement.setString(3,d.getCriteres());
	        	
	    
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
        }}}
	@Override
	public List<Domaine> domaines() {
		List<Domaine> domaines = new ArrayList<Domaine>();
	    Connection connexion = null;
	    Statement statement = null;
	    ResultSet resultat = null;

	    try {
	        connexion = daoFactory.getConnection();
	        statement = connexion.createStatement();
	        
	        // Requête SQL pour récupérer tous les domaines
	        String query = "SELECT id, nom, description, criteres FROM domaines;";
	        resultat = statement.executeQuery(query);
	        
	        while (resultat.next()) {
	            // Récupérer les attributs du domaine
	            int id = resultat.getInt("id");
	            String nom = resultat.getString("nom");
	            String description = resultat.getString("description");
	            String criteres = resultat.getString("criteres");

	            // Création de l'objet Domaine
	            Domaine domaine = new Domaine();
	            domaine.setId(id);
	            domaine.setNom(nom);
	            domaine.setDescription(description);
	            domaine.setCriteres(criteres);

	            // Ajout de l'objet Domaine à la liste
	            domaines.add(domaine);
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

	    return domaines;
	}


	@Override
	public void updateDomaine(Domaine d) {
	    // TODO Auto-generated method stub
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    try {
	        // Récupérer la connexion à la base de données
	        connexion = daoFactory.getConnection();
	        
	        // SQL pour mettre à jour un domaine existant dans la base de données
	        String sql = "UPDATE domaines SET nom = ?, description = ?, criteres = ? WHERE id = ?";
	        
	        // Préparer la requête
	        preparedStatement = connexion.prepareStatement(sql);
	        
	        // Remplacer les paramètres de la requête préparée
	        preparedStatement.setString(1, d.getNom());         // Set the domain name
	        preparedStatement.setString(2, d.getDescription()); // Set the description
	        preparedStatement.setString(3, d.getCriteres());    // Set the criteria
	        preparedStatement.setInt(4, d.getId());             // Set the domain ID for identifying which domain to update
	        
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
	public void deleteDomaine(int id) {
		// TODO Auto-generated method stub
		
		    Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    try {
		        // Récupérer la connexion à la base de données
		        connexion = daoFactory.getConnection();
		        
		        // SQL pour supprimer un domaine existant dans la base de données
		        String sql = "DELETE FROM domaines WHERE id = ?";
		        
		        // Préparer la requête
		        preparedStatement = connexion.prepareStatement(sql);
		        
		        // Remplacer le paramètre de la requête préparée
		        preparedStatement.setInt(1, id); // Set the domain ID to identify which domain to delete
		        
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
	
		// TODO Auto-generated method stub
		public Domaine getDomaineById(int id) {
		    Domaine domaine = null;  // Initialisation de l'objet Domaine qui sera retourné
		    Connection connexion = null;  // Déclaration de la connexion à la base de données
		    PreparedStatement preparedStatement = null;  // Déclaration de la requête préparée
		    ResultSet resultSet = null;  // Déclaration de l'objet pour stocker les résultats

		    try {
		        // Connexion à la base de données
		        connexion = daoFactory.getConnection();  // Utilisation de votre méthode pour obtenir une connexion à la DB

		        // SQL pour récupérer le domaine par son ID
		        String sql = "SELECT * FROM domaines WHERE id = ?";  // Requête SQL pour récupérer le domaine par ID

		        // Préparation de la requête SQL
		        preparedStatement = connexion.prepareStatement(sql);
		        preparedStatement.setInt(1, id);  // Remplir le paramètre avec l'ID du domaine

		        // Exécution de la requête
		        resultSet = preparedStatement.executeQuery();

		        // Si un domaine est trouvé dans la base de données
		        if (resultSet.next()) {
		            domaine = new Domaine();  // Création d'un nouvel objet Domaine
		            domaine.setId(resultSet.getInt("id"));  // Récupération de l'ID du domaine
		            domaine.setNom(resultSet.getString("nom"));  // Récupération du nom du domaine
		            domaine.setDescription(resultSet.getString("description"));  // Récupération de la description
		            domaine.setCriteres(resultSet.getString("criteres"));  // Récupération des critères
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();  // Affichage des erreurs SQL dans la console (à améliorer en production)
		    } finally {
		        // Fermeture des ressources (connexions, requêtes, résultats) pour éviter les fuites de mémoire
		        try {
		            if (resultSet != null) resultSet.close();
		            if (preparedStatement != null) preparedStatement.close();
		            if (connexion != null) connexion.close();
		        } catch (SQLException e) {
		            e.printStackTrace();  // Affichage des erreurs lors de la fermeture des ressources
		        }
		    }

		    return domaine;  // Retourner le domaine trouvé (ou null si non trouvé)
		

	}

}
