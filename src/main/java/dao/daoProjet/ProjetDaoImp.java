package dao.daoProjet;


import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Domaine;
import beans.Habitant;
import beans.Projet;
import dao.DAOFactory;

public class ProjetDaoImp implements ProjetDao {
	private DAOFactory daoFactory;
	
	public ProjetDaoImp(DAOFactory daoFactory) {
		super();
		this.daoFactory = daoFactory;
	}

	@Override
	public void createProjet(Projet p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Projet> projets() {
		List<Projet> projets = new ArrayList<Projet>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {
		    connexion = daoFactory.getConnection();
		    statement = connexion.createStatement();
		    
		    // Requête SQL avec jointures pour récupérer le nom de l'habitant et le nom du domaine
		    String query = "SELECT p.id, p.titre, p.description, p.objectifs, p.budget, p.documentsJustif, " +
		                   "p.localisation, p.benefice, p.estValide, p.gain, " +
		                   "h.nom AS habitantNom, h.prenom AS habitantPrenom, " +
		                   "d.nom AS domaineNom " +
		                   "FROM projets p " +
		                   "JOIN habitants h ON p.id_habitant = h.id " +
		                   "JOIN domaines d ON p.id_domaine = d.id;";
		    
		    resultat = statement.executeQuery(query);
		    
		    while (resultat.next()) {
		        int id = resultat.getInt("id");
		        String titre = resultat.getString("titre");
		        String description = resultat.getString("description");
		        String objectifs = resultat.getString("objectifs");
		        double budget = resultat.getDouble("budget");
		        Blob documentsJustif = resultat.getBlob("documentsJustif");
		        String localisation = resultat.getString("localisation");
		        String benefice = resultat.getString("benefice");
		        boolean estValide = resultat.getBoolean("estValide");
		        double gain = resultat.getDouble("gain");

		        // Récupérer les noms de l'Habitant et du Domaine
		        String habitantNom = resultat.getString("habitantNom");
		        String habitantPrenom = resultat.getString("habitantPrenom");
		        String domaineNom = resultat.getString("domaineNom");

		        // Création des objets Habitant et Domaine avec les informations nécessaires
		        Habitant habitant = new Habitant();
		        habitant.setNom(habitantNom);
		        habitant.setPrenom(habitantPrenom);

		        Domaine domaine = new Domaine();
		        domaine.setNom(domaineNom);

		        // Création de l'objet Projet
		        Projet projet = new Projet();
		        projet.setId(id);
		        projet.setTitre(titre);
		        projet.setDescription(description);
		        projet.setObjectifs(objectifs);
		        projet.setBudget(budget);
		        projet.setDocumentsJustif(documentsJustif);
		        projet.setLocalisation(localisation);
		        projet.setBenefice(benefice);
		        projet.setEstValide(estValide);
		        projet.setGain(gain);
		        projet.setHabitant(habitant);
		        projet.setDomaine(domaine);

		        // Ajout de l'objet Projet à la liste
		        projets.add(projet);
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

		return projets;

	}

	@Override
	public void updateProjet(Projet p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProjet(int id) {
		// TODO Auto-generated method stub
		
	}

}
