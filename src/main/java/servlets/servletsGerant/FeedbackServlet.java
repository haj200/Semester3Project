package servlets.servletsGerant;

import java.io.IOException;
import java.util.List;

import beans.Feedback;
import dao.DAOFactory;
import dao.daoFeedback.FeedbackDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
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

    public FeedbackServlet() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            listFeedbacks(request, response);
        } else {
            switch (action) {
                
                case "supprimer":
                    deleteFeedback(request, response);
                    break;
                default:
                    listFeedbacks(request, response);
                    break;
            }
        }
    }

    protected void listFeedbacks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Feedback> feedbacks = feedbackDao.feedbacks();
        request.setAttribute("feedbacks", feedbacks);
        request.getRequestDispatcher("/Gerant/Feedback/feedbacks.jsp").forward(request, response);
    }

   

    protected void deleteFeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        feedbackDao.deleteFeedback(id);
        response.sendRedirect(request.getContextPath() + "/FeedbackServlet");
    }

    

    

    

    
}

