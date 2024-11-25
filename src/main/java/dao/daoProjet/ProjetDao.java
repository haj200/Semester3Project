package dao.daoProjet;

import java.util.List;

import beans.Projet;

public interface ProjetDao {
	void createProjet(Projet p);
	List<Projet> projets();
	void updateProjet(Projet p);
	void deleteProjet(int id);
	Projet getProjetById(int id);
}
