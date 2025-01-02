package servlets.servletsAdministrateur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import beans.Feedback;
import dao.DAOFactory;
import dao.daoFeedback.FeedbackDao;


@WebServlet("/FeedBackAdmin")
public class FeedBackAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FeedbackDao feedbackDao;
    
	 public void init() throws ServletException {
	        try {
	            DAOFactory daoFactory = DAOFactory.getInstance();
	            this.feedbackDao = daoFactory.getFeedbackDao();
	            
	        } catch (Exception e) {
	            throw new ServletException("Échec de l'initialisation de la servlet FeedbackServlet", e);
	        }
	    }
    public FeedBackAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            listFeedbacks(request, response);
        } else {
            switch (action) {
                case "view":
                    feedback(request, response);
                    break;
                
                default:
                    listFeedbacks(request, response);
                    break;
            }
        }
    }

	
    protected void feedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 int id = Integer.parseInt(request.getParameter("id"));
         Feedback feedback = feedbackDao.getFeedbackById(id);
        request.setAttribute("feedback", feedback);
        request.getRequestDispatcher("/Administrateur/FeedBack/feedback.jsp").forward(request, response);
    }
	protected void listFeedbacks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Feedback> feedbacks = feedbackDao.feedbacks();
        request.setAttribute("feedbacks", feedbacks);
        request.getRequestDispatcher("/Administrateur/FeedBack/feedbacks.jsp").forward(request, response);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
