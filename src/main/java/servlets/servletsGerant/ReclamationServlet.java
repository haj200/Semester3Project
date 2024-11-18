package servlets.servletsGerant;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.DAOFactory;
import dao.daoReclamation.ReclamationDao;


/**
 * Servlet implementation class ReclamationServlet
 */
@WebServlet("/ReclamationServlet")
public class ReclamationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReclamationDao reclamationDao;

	 public void init() throws ServletException {
	        DAOFactory daoFactory = DAOFactory.getInstance();
	        this.reclamationDao =daoFactory.getReclamationDao();
	    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReclamationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("reclamations", reclamationDao.reclamations());
		this.getServletContext().getRequestDispatcher("/reclamations.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
