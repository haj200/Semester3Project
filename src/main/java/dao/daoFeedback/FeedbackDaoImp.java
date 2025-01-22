package dao.daoFeedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Domaine;
import beans.Feedback;
import beans.Habitant;
import beans.Projet;
import dao.DAOFactory;

public class FeedbackDaoImp implements FeedbackDao {

	private DAOFactory daoFactory;

    public FeedbackDaoImp(DAOFactory daoFactory) {
        super();
        this.daoFactory = daoFactory;
    }
    
    public void createFeedback(Feedback f) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            
            // Insertion dans la table feedbacks avec les valeurs fournies
            String sql = "INSERT INTO feedbacks(message, proposition, id_projet, id_habitant) VALUES(?, ?, ?, ?)";
            preparedStatement = connexion.prepareStatement(sql);
            
            // Récupération des données de Feedback (message, proposition)
            preparedStatement.setString(1, f.getMessage());
            preparedStatement.setString(2, f.getProposition());
            
            // Récupération de l'ID du projet et de l'habitant
            preparedStatement.setInt(3, f.getProjet().getId()); // ID du projet
            preparedStatement.setInt(4, f.getHabitant().getId()); // ID de l'habitant

            // Exécution de l'insertion dans la base de données
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


    

    public List<Feedback> feedbacks() {
        List<Feedback> feedbacks = new ArrayList<>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            
            // Requête SQL pour récupérer les réclamations avec les informations de l'habitant
            String query = "SELECT f.id, f.message, f.proposition,  "
            		+ "       h.nom AS habitantNom, h.prenom AS habitantPrenom,  "
            		+ "       p.titre AS projetTitre "
            		+ "FROM feedbacks f "
            		+ "JOIN habitants h ON f.id_habitant = h.id "
            		+ "JOIN projets p ON f.id_projet = p.id;";
            
            resultat = statement.executeQuery(query);
            
            while (resultat.next()) {
                int id = resultat.getInt("id");
                String message = resultat.getString("message");
                String proposition = resultat.getString("proposition");
               

                // Récupérer les informations de l'habitant et projet
                String habitantNom = resultat.getString("habitantNom");
                String habitantPrenom = resultat.getString("habitantPrenom");
                String projetTitre = resultat.getString("projetTitre");

                // Création de l'objet Habitant et Projet avec les informations nécessaires
                Habitant habitant = new Habitant();
                habitant.setNom(habitantNom);
                habitant.setPrenom(habitantPrenom);
                
                Projet projet = new Projet();
				projet.setTitre(projetTitre);

                // Création de l'objet Feedback
                Feedback feedback = new Feedback();
                feedback.setId(id);
                feedback.setMessage(message);
                feedback.setProposition(proposition);
                
                feedback.setHabitant(habitant);
                feedback.setProjet(projet);

                // Ajout de l'objet Reclamation à la liste
                feedbacks.add(feedback);
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

		return feedbacks;

	}

    public void updateFeedback(Feedback f) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            // Récupérer la connexion à la base de données
            connexion = daoFactory.getConnection();
            
            // SQL pour mettre à jour un feedback existant dans la base de données
            String sql = "UPDATE feedbacks SET message = ?, proposition = ?, id_projet = ?, id_habitant = ? WHERE id = ?";
            
            // Préparer la requête
            preparedStatement = connexion.prepareStatement(sql);
            
            // Remplacer les paramètres de la requête préparée
            preparedStatement.setString(1, f.getMessage());
            preparedStatement.setString(2, f.getProposition());
            preparedStatement.setInt(3, f.getProjet().getId()); // Associer l'ID du projet
            preparedStatement.setInt(4, f.getHabitant().getId()); // Associer l'ID de l'habitant
            preparedStatement.setInt(5, f.getId()); // Utiliser l'ID du feedback pour identifier lequel mettre à jour
            
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
    public Feedback getFeedbackById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Feedback feedback = new Feedback();
        try {
            // Obtenir une connexion depuis le DAOFactory
            connection = daoFactory.getConnection();
            // Préparer la requête SQL
            String sql = "SELECT f.id, f.message, f.proposition, f.id_projet, p.titre , h.id "
            		+ "AS id_habitant, h.nom AS habitant_nom, h.prenom AS habitant_prenom FROM feedbacks"
            		+ " f JOIN projets p ON f.id_projet = p.id JOIN habitants h ON "
            		+ "f.id_habitant = h.id WHERE f.id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            // Exécuter la requête
            resultSet = preparedStatement.executeQuery();
            

                if (resultSet.next()) {
                    Habitant habitant = new Habitant(
                        resultSet.getInt("id_habitant"),
                       
                        resultSet.getString("habitant_nom"),
                        resultSet.getString("habitant_prenom")
                        
                    );

                    Projet projet = new Projet(
                        resultSet.getInt("id_projet"),
                        resultSet.getString("titre")
                        
                        
                        
                    );
                    feedback.setId(resultSet.getInt("id"));
                    feedback.setProposition(resultSet.getString("proposition"));
                    feedback.setMessage(resultSet.getString("message"));
                    feedback.setProjet(projet);
                    feedback.setHabitant(habitant);

                        
                    }

                

            

            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return feedback;
    }
    public void deleteFeedback(int id) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            // Récupérer la connexion à la base de données
            connexion = daoFactory.getConnection();
            
            // SQL pour supprimer un feedback existant dans la base de données
            String sql = "DELETE FROM feedbacks WHERE id = ?";
            
            // Préparer la requête
            preparedStatement = connexion.prepareStatement(sql);
            
            // Remplacer le paramètre de la requête préparée
            preparedStatement.setInt(1, id); // Utiliser l'ID du feedback pour identifier lequel supprimer
            
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
