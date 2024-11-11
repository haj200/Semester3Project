package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import beans.Habitant;
import beans.Reclamation;

public class ReclamationDaoImp implements ReclamationDao {
    private DAOFactory daoFactory;

    public ReclamationDaoImp(DAOFactory daoFactory) {
        super();
        this.daoFactory = daoFactory;
    }

    @Override
    public void createReclamation(Reclamation r) {
        // TODO Auto-generated method stub
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
    }

    @Override
    public void deleteReclamation(int id) {
        // TODO Auto-generated method stub
    }

}
