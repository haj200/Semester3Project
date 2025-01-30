package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import beans.Administrateur;
import beans.Gerant;
import beans.Habitant;
import beans.User;
import dao.DAOAuth;
import dao.DAOFactory;
import dao.daoAdministrateur.AdministrateurDao;
import dao.daoDomaine.DomaineDao;
import dao.daoGerant.GerantDao;
import dao.daoHabitant.HabitantDao;
import dao.daoProjet.ProjetDao;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOAuth  authDao;
	private HabitantDao habitantDao;
	private GerantDao gerantDao;
	private AdministrateurDao administrateurDao;
	private ProjetDao projetDao;

   
	 public void init() throws ServletException {
	        DAOFactory daoFactory = DAOFactory.getInstance();
	        this.authDao = daoFactory.getAuthDao();
	        this.habitantDao = daoFactory.getHabitantDao();
	        this.projetDao = daoFactory.getProjetDao();
	        this.gerantDao = daoFactory.getGerantDao();
	        this.administrateurDao = daoFactory.getAdministrateurDao();
	    }  
   
   
    public LoginServlet() {
        super();
       
    }
    
    

@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	 req.getRequestDispatcher("login.jsp").forward(req, resp);
	}


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String username = request.getParameter("username");
    String password = request.getParameter("password");

    
    User user = authDao.authenticate(username, password);

    if (user != null) {
        HttpSession session = request.getSession();
        session.setAttribute("username", user.getUsername());
        session.setAttribute("typeUser", user.getTypeUser());

        // Rediriger en fonction du type d'utilisateur
        switch (user.getTypeUser()) {
            case "habitant":
            	Habitant habitant = habitantDao.getHabitantByusername(username);
            	session.setAttribute("user", habitant);
            	request.setAttribute("projects", projetDao.projets());
            	request.getRequestDispatcher("Habitant/dashboard.jsp").forward(request, response);

                break;
            case "gerant":
            	Gerant gerant = gerantDao.getGerantByUsername(username);
            	session.setAttribute("user", gerant);
                response.sendRedirect("Gerant/dash.jsp");
                break;
            case "administrateur":
            	Administrateur administrateur = administrateurDao.getAdministrateurByUsername(username);
            	session.setAttribute("user", administrateur);
                response.sendRedirect("Administrateur/dashboard.jsp");
                break;
        }
    } else {
        // Authentification échouée
        response.sendRedirect("login.jsp?error=invalid");
    }
	}

}
