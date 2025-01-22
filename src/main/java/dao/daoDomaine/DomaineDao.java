package dao.daoDomaine;

import java.util.List;

import beans.Domaine;

public interface DomaineDao {
 void createDomaine(Domaine d);
 List<Domaine> domaines();
 void updateDomaine(Domaine d);
 void deleteDomaine(int id);
 Domaine getDomaineById(int id);
 int getDomainesCount();
 List<Domaine> getDomainesPaginated(int start, int rowsPerPage);



}
