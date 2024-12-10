package dao.daoProjet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import beans.Projet;
import beans.Habitant;
import beans.Domaine;
import dao.DAOFactory;
import dao.daoHabitant.HabitantDao;
import dao.daoDomaine.DomaineDao;

public class ProjetDaoImp implements ProjetDao {

    private DAOFactory daoFactory;
    private HabitantDao habitantDao;
    private DomaineDao domaineDao;

    public ProjetDaoImp(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
        this.habitantDao = daoFactory.getHabitantDao();
        this.domaineDao = daoFactory.getDomaineDao();
    }

    @Override
    public void createProjet(Projet projet) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            // Step 1: Establish connection
            connexion = daoFactory.getConnection();

            // Step 2: Create SQL query
            String sql = "INSERT INTO projets (titre, description, objectifs, budget, localisation, benefice, estValide, gain, id_habitant, id_domaine, documentsJustif) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connexion.prepareStatement(sql);

            // Step 3: Set query parameters
            preparedStatement.setString(1, projet.getTitre());
            preparedStatement.setString(2, projet.getDescription());
            preparedStatement.setString(3, projet.getObjectifs());
            preparedStatement.setDouble(4, projet.getBudget());
            preparedStatement.setString(5, projet.getLocalisation());
            preparedStatement.setString(6, projet.getBenefice());
            preparedStatement.setInt(7, projet.isEstValide());
            preparedStatement.setDouble(8, projet.getGain());
            preparedStatement.setInt(9, projet.getHabitant().getId());
            preparedStatement.setInt(10, projet.getDomaine().getId());

            // Step 4: Handle file storage and set the directory path
            String documentDirectory = storeDocuments(projet);
            preparedStatement.setString(11, documentDirectory); // Save the directory path in the database

            // Step 5: Execute the query
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close resources
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Helper method to store documents on disk and return the directory path
    private String storeDocuments(Projet projet)  {
        String rootDirectory = "C:/Projects/";
        String userDirectory = "user_" + projet.getHabitant().getId();
        String projectDirectory = "project_" + UUID.randomUUID();
        String fullPath = rootDirectory + userDirectory + "/" + projectDirectory + "/";

        // Create directories if they don't exist
        File dir = new File(fullPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Save each document
        
        try {
			saveFile(projet.getDocumentsJustif().getEtudeFinanciere(), fullPath, "etudeFinanciere");
			saveFile(projet.getDocumentsJustif().getPlanBusiness(), fullPath, "planBusiness");
			saveFile(projet.getDocumentsJustif().getPhoto(), fullPath, "photo");
	        saveFile(projet.getDocumentsJustif().getFullDescriptif(), fullPath, "fullDescriptif");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        // Return the path to be saved in the database
        return fullPath;
    }

    // Helper method to save an individual file
    private void saveFile(String content, String directory, String fileName) throws IOException {
        if (content != null && !content.isEmpty()) {
            String filePath = directory + fileName;
            try (FileWriter fileWriter = new FileWriter(filePath)) {
                fileWriter.write(content);
            }
        }
    }


    @Override
    public List<Projet> projets() {
        List<Projet> projets = new ArrayList<>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM projets");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titre = resultSet.getString("titre");
                String description = resultSet.getString("description");
                String objectifs = resultSet.getString("objectifs");
                double budget = resultSet.getDouble("budget");
                String localisation = resultSet.getString("localisation");
                String benefice = resultSet.getString("benefice");
                int estValide = resultSet.getInt("estValide");
                double gain = resultSet.getDouble("gain");

                int habitantId = resultSet.getInt("id_habitant");
                int domaineId = resultSet.getInt("id_domaine");

                Habitant habitant = habitantDao.getHabitantById(habitantId);
                Domaine domaine = domaineDao.getDomaineById(domaineId);

                Projet projet = new Projet();
                projet.setId(id);
                projet.setTitre(titre);
                projet.setDescription(description);
                projet.setObjectifs(objectifs);
                projet.setBudget(budget);
                projet.setLocalisation(localisation);
                projet.setBenefice(benefice);
                projet.setEstValide(estValide);
                projet.setGain(gain);
                projet.setHabitant(habitant);
                projet.setDomaine(domaine);

                projets.add(projet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return projets;
    }

    @Override
    public List<Projet> projetsParHabitant(int habitantId) {
        List<Projet> projets = new ArrayList<>();
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connexion = daoFactory.getConnection();
            String query = "SELECT * FROM projets WHERE id_habitant = ?";
            preparedStatement = connexion.prepareStatement(query);
            preparedStatement.setInt(1, habitantId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titre = resultSet.getString("titre");
                String description = resultSet.getString("description");
                String objectifs = resultSet.getString("objectifs");
                double budget = resultSet.getDouble("budget");
                String localisation = resultSet.getString("localisation");
                String benefice = resultSet.getString("benefice");
                int estValide = resultSet.getInt("estValide");
                double gain = resultSet.getDouble("gain");

                int domaineId = resultSet.getInt("id_domaine");

                Habitant habitant = habitantDao.getHabitantById(habitantId);
                Domaine domaine = domaineDao.getDomaineById(domaineId);

                Projet projet = new Projet();
                projet.setId(id);
                projet.setTitre(titre);
                projet.setDescription(description);
                projet.setObjectifs(objectifs);
                projet.setBudget(budget);
                projet.setLocalisation(localisation);
                projet.setBenefice(benefice);
                projet.setEstValide(estValide);
                projet.setGain(gain);
                projet.setHabitant(habitant);
                projet.setDomaine(domaine);

                projets.add(projet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return projets;
    }

    @Override
    public void updateProjet(Projet projet) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            // Step 1: Establish connection
            connexion = daoFactory.getConnection();

            // Step 2: Create SQL query (excluding document paths)
            String sql = "UPDATE projets SET titre = ?, description = ?, objectifs = ?, budget = ?, localisation = ?, benefice = ?, estValide = ?, gain = ?, id_habitant = ?, id_domaine = ? WHERE id = ?";
            preparedStatement = connexion.prepareStatement(sql);

            // Step 3: Set query parameters
            preparedStatement.setString(1, projet.getTitre());
            preparedStatement.setString(2, projet.getDescription());
            preparedStatement.setString(3, projet.getObjectifs());
            preparedStatement.setDouble(4, projet.getBudget());
            preparedStatement.setString(5, projet.getLocalisation());
            preparedStatement.setString(6, projet.getBenefice());
            preparedStatement.setInt(7, projet.isEstValide());
            preparedStatement.setDouble(8, projet.getGain());
            preparedStatement.setInt(9, projet.getHabitant().getId());
            preparedStatement.setInt(10, projet.getDomaine().getId());
            preparedStatement.setInt(11, projet.getId());

            // Step 4: Execute query
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connexion != null) connexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void validateProjet(Projet projet) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            // Step 1: Establish connection
            connexion = daoFactory.getConnection();

            // Step 2: Create SQL query (excluding document paths)
            String sql = "UPDATE projets SET  estValide = ? WHERE id = ?";
            preparedStatement = connexion.prepareStatement(sql);

            // Step 3: Set query parameters
            
            preparedStatement.setInt(1, projet.isEstValide());
            
            preparedStatement.setInt(2, projet.getId());

            // Step 4: Execute query
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connexion != null) connexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void deleteProjet(int id) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            String sql = "DELETE FROM projets WHERE id = ?";
            preparedStatement = connexion.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Projet getProjetById(int id) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Projet projet = null;

        try {
            connexion = daoFactory.getConnection();
            String sql = "SELECT * FROM projets WHERE id = ?";
            preparedStatement = connexion.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String titre = resultSet.getString("titre");
                String description = resultSet.getString("description");
                String objectifs = resultSet.getString("objectifs");
                double budget = resultSet.getDouble("budget");
                String localisation = resultSet.getString("localisation");
                String benefice = resultSet.getString("benefice");
                int estValide = resultSet.getInt("estValide");
                double gain = resultSet.getDouble("gain");

                int habitantId = resultSet.getInt("id_habitant");
                int domaineId = resultSet.getInt("id_domaine");

                Habitant habitant = habitantDao.getHabitantById(habitantId);
                Domaine domaine = domaineDao.getDomaineById(domaineId);

                projet = new Projet();
                projet.setId(id);
                projet.setTitre(titre);
                projet.setDescription(description);
                projet.setObjectifs(objectifs);
                projet.setBudget(budget);
                projet.setLocalisation(localisation);
                projet.setBenefice(benefice);
                projet.setEstValide(estValide);
                projet.setGain(gain);
                projet.setHabitant(habitant);
                projet.setDomaine(domaine);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return projet;
    }
}
