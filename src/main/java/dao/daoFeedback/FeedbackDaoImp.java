package dao.daoFeedback;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Feedback;
import beans.Habitant;
import beans.Projet;
import dao.DAOFactory;

public class FeedbackDaoImp {

	private DAOFactory daoFactory;

    public FeedbackDaoImp(DAOFactory daoFactory) {
        super();
        this.daoFactory = daoFactory;
    }
    public void createFeedback(Feedback f) {
        // TODO Auto-generated method stub
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
            String query = "SELECT f.id, f.message,f.proposition " +
                           "h.nom AS habitantNom, h.prenom AS habitantPrenom " +
                           "p.titre AS projetTitre " +
		                   "FROM feedback f " +
		                   "JOIN habitants h ON f.id_habitant = h.id " +
		                   "JOIN projets p ON f.id_projet = p.id;";
            
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
		// TODO Auto-generated method stub
		
	}

	
	public void deleteFeedback(int id) {
		// TODO Auto-generated method stub
		
	}

}
