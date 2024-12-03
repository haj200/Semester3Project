package dao.daoGerant;

import java.util.List;

import beans.Gerant;

public interface GerantDao {

	void createGerant(Gerant g);

	List<Gerant> gerants();

	void updateGerant(Gerant g);

	void deleteGerant(int id);

	Gerant getGerantById(int id);

	Gerant getGerantByUsername(String username);
	

}
