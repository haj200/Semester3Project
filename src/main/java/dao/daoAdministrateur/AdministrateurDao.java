package dao.daoAdministrateur;

import java.util.List;

import beans.Administrateur;

public interface AdministrateurDao {

	Administrateur getAdministrateurByUsername(String username);

	Administrateur getAdministrateurById(int id);

	void deleteAdministrateur(int id);

	void updateAdministrateur(Administrateur a);

	List<Administrateur> getAdministrateurs();

	void createAdministrateur(Administrateur a);

}
