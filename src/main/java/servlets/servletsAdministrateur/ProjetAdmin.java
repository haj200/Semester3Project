package servlets.servletsAdministrateur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import beans.Projet;
import dao.DAOFactory;
import dao.daoDomaine.DomaineDao;
import dao.daoHabitant.HabitantDao;
import dao.daoProjet.ProjetDao;


@WebServlet("/ProjetAdmin")
public class ProjetAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjetDao projetDao;
    private static final String ROOT_DIRECTORY = "C:/Projects/";

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.projetDao = daoFactory.getProjetDao();
       
    }

       
    
    public ProjetAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
            	listProjects(request, response);
                break;
            case "validate":
                validate(request, response);
                break;
            case "view":
                viewProject(request, response);
                break;
            default:
                listProjects(request, response);
                break;
        }
	}

	
	private void validate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int projectId = Integer.parseInt(request.getParameter("id"));
		int est_valide = Integer.parseInt(request.getParameter("est_valide"));
		
		Projet projet = new Projet();
		projet.setId(projectId);
		projet.setEstValide(est_valide);
		
		projetDao.validateProjet(projet);
		
		response.sendRedirect(request.getContextPath() + "/ProjetAdmin");
	}

	private void viewProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("projet", projetDao.getProjetById(id));
        request.getRequestDispatcher("/Administrateur/Projet/projetView.jsp").forward(request, response);
    }

	private void listProjects(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("projets", projetDao.projets());
        request.getRequestDispatcher("/Administrateur/Projet/projets.jsp").forward(request, response);
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
