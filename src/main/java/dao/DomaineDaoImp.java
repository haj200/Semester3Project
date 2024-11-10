package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Domaine;

public class DomaineDaoImp implements DomaineDao {
	private DAOFactory daoFactory;
	
	public DomaineDaoImp(DAOFactory daoFactory) {
		super();
		this.daoFactory = daoFactory;
	}

	@Override
	public void createDomaine(Domaine d) {
		// TODO Auto-generated method stub
		
	}

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
		
	}

	@Override
	public void deleteDomaine(int id) {
		// TODO Auto-generated method stub
		
	}

}
