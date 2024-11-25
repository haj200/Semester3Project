package dao.daoReclamation;

import java.util.List;

import beans.Reclamation;

public interface ReclamationDao {

	
		void createReclamation(Reclamation r);
		List<Reclamation> reclamations();
		void updateReclamation(Reclamation r);
		void deleteReclamation(int id);
		Reclamation getReclamationById(int id);
		
		
	}

