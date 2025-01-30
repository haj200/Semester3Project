package servlets.servletsHabitant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import beans.Habitant;
import dao.DAOFactory;
import dao.daoHabitant.HabitantDao;

/**
 * Servlet implementation class MyAccount
 */
@WebServlet("/MyAccount")
public class MyAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HabitantDao habitantDao;
public void init() {
    habitantDao = DAOFactory.getInstance().getHabitantDao();

}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Supposons que l'ID de l'utilisateur est stocké dans la session
        HttpSession session = request.getSession();
        Integer Id = (Integer) session.getAttribute("userId");

        if (Id != null) {
            Habitant habitant = habitantDao.getUserById(Id);
			request.setAttribute("habitant", habitant);
			// Transfert vers la page JSP
			request.getRequestDispatcher("/Habitant/views/myAccount.jsp").forward(request, response);
        } 
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
