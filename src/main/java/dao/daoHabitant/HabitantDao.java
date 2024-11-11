package dao;

import java.util.List;

import beans.Habitant;


public interface HabitantDao {
	
	 void  createHabitant(Habitant h);
	
	List<Habitant> habitants();
	
	void  updateHabitant(Habitant u);
	
	 void deleteHabitant(int id );


}
