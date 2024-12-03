package dao.daoGerant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Gerant;
import dao.DAOFactory;

public class GerantDaoImp implements GerantDao {

    private DAOFactory daoFactory;

    public GerantDaoImp(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void createGerant(Gerant g) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();

            String sql = "INSERT INTO gerants (username, nom, prenom, email, password) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connexion.prepareStatement(sql);

            preparedStatement.setString(1, g.getUsername());
            preparedStatement.setString(2, g.getNom());
            preparedStatement.setString(3, g.getPrenom());
            preparedStatement.setString(4, g.getEmail());
            preparedStatement.setString(5, g.getPassword());

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
    public List<Gerant> gerants() {
        List<Gerant> gerants = new ArrayList<>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM gerants");

            while (resultat.next()) {
                int id = resultat.getInt("id");
                String username = resultat.getString("username");
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String email = resultat.getString("email");
                String password = resultat.getString("password");

                Gerant gerant = new Gerant();
                gerant.setId(id);
                gerant.setUsername(username);
                gerant.setNom(nom);
                gerant.setPrenom(prenom);
                gerant.setEmail(email);
                gerant.setPassword(password);

                gerants.add(gerant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultat != null) {
                    resultat.close();
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

        return gerants;
    }

    @Override
    public void updateGerant(Gerant g) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();

            String sql = "UPDATE gerants SET username = ?, nom = ?, prenom = ?, email = ?, password = ? WHERE id = ?";
            preparedStatement = connexion.prepareStatement(sql);

            preparedStatement.setString(1, g.getUsername());
            preparedStatement.setString(2, g.getNom());
            preparedStatement.setString(3, g.getPrenom());
            preparedStatement.setString(4, g.getEmail());
            preparedStatement.setString(5, g.getPassword());
            preparedStatement.setInt(6, g.getId());

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
    public void deleteGerant(int id) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();

            String sql = "DELETE FROM gerants WHERE id = ?";
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
    public Gerant getGerantById(int id) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Gerant gerant = null;

        try {
            connexion = daoFactory.getConnection();

            String sql = "SELECT * FROM gerants WHERE id = ?";
            preparedStatement = connexion.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int gerantId = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                gerant = new Gerant(gerantId, username, nom, prenom, email, password);
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

        return gerant;
    }

    @Override
    public Gerant getGerantByUsername(String username) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Gerant gerant = null;

        try {
            connexion = daoFactory.getConnection();

            String sql = "SELECT * FROM gerants WHERE username = ?";
            preparedStatement = connexion.prepareStatement(sql);

            preparedStatement.setString(1, username);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int gerantId = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                gerant = new Gerant(gerantId, username, nom, prenom, email, password);
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

        return gerant;
    }
}
