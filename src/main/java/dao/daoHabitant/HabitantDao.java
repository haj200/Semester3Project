package dao.daoHabitant;

import java.util.List;

import beans.Habitant;


public interface HabitantDao {
	
	 void  createHabitant(Habitant h);
	
	List<Habitant> habitants();
	
	void  updateHabitant(Habitant u);
	
	void deleteHabitant(int id );
	Habitant getHabitantById(int id);

	Habitant getHabitantByusername(String username);

<<<<<<< HEAD
	Habitant getUserById(Integer userId);
=======
	int getHabitantsCount();

	List<Habitant> getHabitantsPaginated(int start, int rowsPerPage);
>>>>>>> 05f798494aad71d365178bd1cd6999fc2c90d77d


}
