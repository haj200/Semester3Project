package servlets.servletsGerant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.DAOFactory;
import dao.daoDomaine.DomaineDao;
import dao.daoHabitant.HabitantDao;



public class DomaineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DomaineDao domaineDao;

	 public void init() throws ServletException {
	        DAOFactory daoFactory = DAOFactory.getInstance();
	        this.domaineDao =daoFactory.getDomaineDao();
	    }  
    
    public DomaineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("domaines", domaineDao.domaines());
		this.getServletContext().getRequestDispatcher("/domaineJsp/domaines.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
