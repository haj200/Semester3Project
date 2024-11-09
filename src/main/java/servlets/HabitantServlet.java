package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.DAOFactory;
import dao.HabitantDao;



public class HabitantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HabitantDao habitantDao;

	 public void init() throws ServletException {
	        DAOFactory daoFactory = DAOFactory.getInstance();
	        this.habitantDao =daoFactory.getHabitantDao();
	    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HabitantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("habitants", habitantDao.habitants());
		this.getServletContext().getRequestDispatcher("/habitants.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
