package servlets.servletsGerant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.DAOFactory;
import dao.daoHabitant.HabitantDao;
import dao.daoProjet.ProjetDao;



public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjetDao projetDao;

	 public void init() throws ServletException {
	        DAOFactory daoFactory = DAOFactory.getInstance();
	        this.projetDao =daoFactory.getProjetDao();
	    }
    
    public ProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("projets", projetDao.projets());
		this.getServletContext().getRequestDispatcher("/projetJsp/projets.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
