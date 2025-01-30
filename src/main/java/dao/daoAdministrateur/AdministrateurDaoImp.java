package dao.daoAdministrateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Administrateur;
import dao.DAOFactory;

public class AdministrateurDaoImp implements AdministrateurDao {

    private DAOFactory daoFactory;

    public AdministrateurDaoImp(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
   
    public class AdministrateurDao {
    	
        
      

    }
    @Override
    public void createAdministrateur(Administrateur a) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            String sql = "INSERT INTO administrateurs (username, nom, prenom, email, password) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connexion.prepareStatement(sql);

            preparedStatement.setString(1, a.getUsername());
            preparedStatement.setString(2, a.getNom());
            preparedStatement.setString(3, a.getPrenom());
            preparedStatement.setString(4, a.getEmail());
            preparedStatement.setString(5, a.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connexion != null) connexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Administrateur> getAdministrateurs() {
        List<Administrateur> administrateurs = new ArrayList<>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM administrateurs");

            while (resultat.next()) {
                int id = resultat.getInt("id");
                String username = resultat.getString("username");
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String email = resultat.getString("email");
                String password = resultat.getString("password");

                Administrateur admin = new Administrateur();
                admin.setId(id);
                admin.setUsername(username);
                admin.setNom(nom);
                admin.setPrenom(prenom);
                admin.setEmail(email);
                admin.setPassword(password);

                administrateurs.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultat != null) resultat.close();
                if (statement != null) statement.close();
                if (connexion != null) connexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return administrateurs;
    }

    @Override
    public void updateAdministrateur(Administrateur a) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            String sql = "UPDATE administrateurs SET username = ?, nom = ?, prenom = ?, email = ?, password = ? WHERE id = ?";
            preparedStatement = connexion.prepareStatement(sql);

            preparedStatement.setString(1, a.getUsername());
            preparedStatement.setString(2, a.getNom());
            preparedStatement.setString(3, a.getPrenom());
            preparedStatement.setString(4, a.getEmail());
            preparedStatement.setString(5, a.getPassword());
            preparedStatement.setInt(6, a.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connexion != null) connexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteAdministrateur(int id) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            String sql = "DELETE FROM administrateurs WHERE id = ?";
            preparedStatement = connexion.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connexion != null) connexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Administrateur getAdministrateurById(int id) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Administrateur admin = null;

        try {
            connexion = daoFactory.getConnection();
            String sql = "SELECT * FROM administrateurs WHERE id = ?";
            preparedStatement = connexion.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int adminId = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                admin = new Administrateur(adminId, username, nom, prenom, email, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connexion != null) connexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return admin;
    }

    @Override
    public Administrateur getAdministrateurByUsername(String username) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Administrateur admin = null;

        try {
            connexion = daoFactory.getConnection();
            String sql = "SELECT * FROM administrateurs WHERE username = ?";
            preparedStatement = connexion.prepareStatement(sql);

            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                admin = new Administrateur(id, username, nom, prenom, email, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connexion != null) connexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return admin;
    }

	@Override
	public int getAdministrateursCount() {
		int count = 0;
        String query = "SELECT COUNT(*) FROM administrateurs";
        try (Connection conn = daoFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
	}

	@Override
	public List<Administrateur> getAdministrateursPaginated(int start, int rowsPerPage) {
		List<Administrateur> admins = new ArrayList<>();
        String query = "SELECT * FROM administrateurs LIMIT ?, ?";
        try (Connection conn = daoFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, start);
            ps.setInt(2, rowsPerPage);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Administrateur admin = new Administrateur();
                    admin.setId(rs.getInt("id"));
                    admin.setNom(rs.getString("nom"));
                    admin.setPrenom(rs.getString("prenom"));
                    admin.setUsername(rs.getString("username"));
                    admin.setEmail(rs.getString("email"));
                    admin.setPassword(rs.getString("password"));
                    admins.add(admin);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    } } 
	

