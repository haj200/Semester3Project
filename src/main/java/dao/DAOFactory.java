package dao;

import java.io.IOException;
import dao.daoFeedback.FeedbackDaoImp;
import dao.daoGerant.GerantDao;
import dao.daoGerant.GerantDaoImp;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import dao.daoAdministrateur.AdministrateurDao;
import dao.daoAdministrateur.AdministrateurDaoImp;
import dao.daoDomaine.DomaineDao;
import dao.daoDomaine.DomaineDaoImp;
import dao.daoFeedback.FeedbackDao;
import dao.daoHabitant.HabitantDao;
import dao.daoHabitant.HabitantDaoImp;
import dao.daoProjet.ProjetDao;
import dao.daoProjet.ProjetDaoImp;
import dao.daoReclamation.ReclamationDao;
import dao.daoReclamation.ReclamationDaoImp;

public class DAOFactory {

    private static final String FICHIER_PROPERTIES       = "dao/dao.properties";
    private static final String PROPERTY_URL             = "url";
    private static final String PROPERTY_DRIVER          = "driver";
    private static final String PROPERTY_NOM_UTILISATEUR = "root";
    private static final String PROPERTY_MOT_DE_PASSE    = "";

    private String              url;
    private String              username;
    private String              password;

    DAOFactory( String url, String username, String password ) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /*
     * Méthode chargée de récupérer les informations de connexion à la base de
     * données, charger le driver JDBC et retourner une instance de la Factory
     */
    public static DAOFactory getInstance() throws DAOConfigurationException {
        Properties properties = new Properties();
        String url;
        String driver;
        String nomUtilisateur;
        String motDePasse;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream( FICHIER_PROPERTIES );

        if ( fichierProperties == null ) {
            throw new DAOConfigurationException( "Le fichier properties " + FICHIER_PROPERTIES + " est introuvable." );
        }

        try {
            properties.load( fichierProperties );
            url = properties.getProperty( PROPERTY_URL );
            driver = properties.getProperty( PROPERTY_DRIVER );
            nomUtilisateur = properties.getProperty( PROPERTY_NOM_UTILISATEUR );
            motDePasse = properties.getProperty( PROPERTY_MOT_DE_PASSE );
        } catch ( IOException e ) {
            throw new DAOConfigurationException( "Impossible de charger le fichier properties " + FICHIER_PROPERTIES, e );
        }

        try {
            Class.forName( driver );
        } catch ( ClassNotFoundException e ) {
            throw new DAOConfigurationException( "Le driver est introuvable dans le classpath.", e );
        }

        DAOFactory instance = new DAOFactory( url, nomUtilisateur, motDePasse );
        return instance;
    }

    /* Méthode chargée de fournir une connexion à la base de données */
     /* package */ public Connection getConnection() throws SQLException {
        return DriverManager.getConnection( url, username, password );
    }

    /*
     * Méthodes de récupération de l'implémentation des différents DAO (un seul
     * pour le moment)
     */
     public HabitantDao getHabitantDao() {
    	 return new HabitantDaoImp(this);
     }
     public DomaineDao getDomaineDao() {
    	 return new DomaineDaoImp(this);
     }
     public ProjetDao getProjetDao() {
    	 return new ProjetDaoImp(this);
     }
     public ReclamationDao getReclamationDao() {
    	 return new ReclamationDaoImp(this);
     }
     public DAOAuth getAuthDao() {
    	 return new DAOAuth(this);
     }
     public GerantDao getGerantDao() {
    	 return new GerantDaoImp(this);
     }
     public AdministrateurDao getAdministrateurDao() {
    	 return new AdministrateurDaoImp(this);
     }

	public FeedbackDao getFeedbackDao() {
		
		return new FeedbackDaoImp(this);
	}

	

     

	
     
     
}