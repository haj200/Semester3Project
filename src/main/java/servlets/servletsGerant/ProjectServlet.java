package servlets.servletsGerant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import beans.Projet;
import dao.DAOFactory;
import dao.daoProjet.ProjetDao;

@WebServlet("/ProjectServlet")
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjetDao projetDao;

	public void init() throws ServletException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		this.projetDao = daoFactory.getProjetDao();

	}

	public ProjectServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			action = "list";
		}

		switch (action) {

		case "delete":
			deleteProject(request, response);
			break;
		case "view":
			viewProject(request, response);
			break;
		default:
			listProjects(request, response);
			break;
		}
	}

	private void viewProject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Projet projet = projetDao.getProjetById(id);
		request.setAttribute("projet", projet);
		request.getRequestDispatcher("/Gerant/Projet/viewProjet.jsp").forward(request, response);

	}

	private void listProjects(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("projects", projetDao.projets());
		request.getRequestDispatcher("/Gerant/Projet/projets.jsp").forward(request, response);
	}

	private void deleteProject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		projetDao.deleteProjet(id);
		response.sendRedirect(request.getContextPath() + "/ProjectServlet");
	}

}
