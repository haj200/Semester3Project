package servlets.servletsHabitant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import beans.Domaine;
import dao.DAOFactory;
import dao.daoDomaine.DomaineDao;

@WebServlet("/DomaineHabitant")
public class DomaineHabitant extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DomaineDao domaineDao;

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.domaineDao = daoFactory.getDomaineDao();
    }

    public DomaineHabitant() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
        if (action == null) {
            action = "list"; // Action par défaut
        }
        switch (action) {
        case "view":
        	viewDomaine(request, response);
            break;
        default:
        listDomaines(request, response); // Par défaut, afficher la liste
        break;
        
    	
        
        }}
    

    private void viewDomaine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("domaine", domaineDao.getDomaineById(id));
        request.getRequestDispatcher("/Habitant/domaines/domaineView.jsp").forward(request, response);
    }


	private void listDomaines(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		// TODO Auto-generated method stub
		List<Domaine> domaines = domaineDao.domaines();
        request.setAttribute("domaines", domaines);
        request.getRequestDispatcher("/Habitant/listDomaines.jsp").forward(request, response);
	}

}