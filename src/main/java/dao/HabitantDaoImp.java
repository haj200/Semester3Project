package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Habitant;


public class HabitantDaoImp implements HabitantDao {

	private DAOFactory daoFactory;

	public HabitantDaoImp(DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	}

	@Override
	public void createHabitant(Habitant h) {
		

	}

	

	@Override
	public List<Habitant> habitants() {
		List<Habitant> habitants = new ArrayList<Habitant>();
	      Connection connexion = null;
	      Statement statement = null;
	      ResultSet resultat = null;
	      try {
	          connexion = daoFactory.getConnection();
	          statement = connexion.createStatement();
	          resultat = statement.executeQuery("SELECT nom,email  FROM habitants;");
	          while (resultat.next()) {
	              String nom = resultat.getString("nom");
	              String email= resultat.getString("email");

	             Habitant habitant = new Habitant();
	              habitant.setNom(nom);
	              habitant.setEmail(email);

	              habitants.add(habitant);
	          }
	      } catch (SQLException e) {
	          e.printStackTrace();
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

}
