package servlets.servletsGerant;

import java.io.IOException;
import java.util.List;

import beans.Feedback;
import beans.Habitant;
import beans.Projet;
import dao.DAOFactory;
import dao.daoFeedback.FeedbackDao;
import dao.daoHabitant.HabitantDao;
import dao.daoProjet.ProjetDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private FeedbackDao feedbackDao;
    private HabitantDao habitantDao;
    private ProjetDao projetDao;

    public void init() throws ServletException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            this.feedbackDao = daoFactory.getFeedbackDao();
            this.habitantDao = daoFactory.getHabitantDao();
            this.projetDao = daoFactory.getProjetDao();
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
                case "ajouter":
                    showNewForm(request, response);
                    break;
                case "modifier":
                    showEditForm(request, response);
                    break;
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
        request.getRequestDispatcher("/feedbackJsp/feedbacks.jsp").forward(request, response);
    }

    protected void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Habitant> habitants = habitantDao.habitants();
        List<Projet> projets = projetDao.projets();
        request.setAttribute("habitants", habitants);
        request.setAttribute("projets", projets);
        request.getRequestDispatcher("/feedbackJsp/feedbackAdd.jsp").forward(request, response);
    }

    protected void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Feedback feedback = feedbackDao.getFeedbackById(id);
        List<Habitant> habitants = habitantDao.habitants();
        List<Projet> projets = projetDao.projets();
        request.setAttribute("feedback", feedback);
        request.setAttribute("habitants", habitants);
        request.setAttribute("projets", projets);
        request.getRequestDispatcher("/feedbackJsp/feedbackUpdate.jsp").forward(request, response);
    }

    protected void deleteFeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        feedbackDao.deleteFeedback(id);
        response.sendRedirect(request.getContextPath() + "/FeedbackServlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("save")) {
            saveFeedback(request, response);
        }
    }

    // Méthode refactorisée pour gérer la sauvegarde du feedback
    private void saveFeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String message = request.getParameter("message");
        String proposition = request.getParameter("proposition");
        String projetId = request.getParameter("id_projet");
        String habitantId = request.getParameter("id_habitant");

        Feedback feedback = new Feedback();
        Projet projet = getProjet(projetId);  // Récupère le projet de manière séparée
        Habitant habitant = getHabitant(habitantId);  // Récupère l'habitant de manière séparée

        // Définir les propriétés du feedback
        feedback.setMessage(message);
        feedback.setProposition(proposition);
        feedback.setProjet(projet);
        feedback.setHabitant(habitant);

        // Si l'ID est présent, on met à jour le feedback, sinon on crée un nouveau feedback
        if (id != null && !id.isEmpty()) {
            updateFeedback(id, feedback);
        } else {
            createFeedback(feedback);
        }

        // Redirection après l'enregistrement du feedback
        response.sendRedirect(request.getContextPath() + "/FeedbackServlet");
    }

    // Méthode pour récupérer le projet à partir de son ID
    private Projet getProjet(String projetId) {
        if (projetId != null && !projetId.isEmpty()) {
            int projetIntId = Integer.parseInt(projetId);
            return projetDao.getProjetById(projetIntId);
        }
        return null;  // Si l'ID du projet est nul ou vide, retourne null
    }

    // Méthode pour récupérer l'habitant à partir de son ID
    private Habitant getHabitant(String habitantId) {
        if (habitantId != null && !habitantId.isEmpty()) {
            int habitantIntId = Integer.parseInt(habitantId);
            return habitantDao.getHabitantById(habitantIntId);
        }
        return null;  // Si l'ID de l'habitant est nul ou vide, retourne null
    }

    // Méthode pour mettre à jour un feedback
    private void updateFeedback(String id, Feedback feedback) {
        feedback.setId(Integer.parseInt(id));  // Convertir l'ID pour l'update
        feedbackDao.updateFeedback(feedback);  // Mettre à jour le feedback
    }

    // Méthode pour créer un nouveau feedback
    private void createFeedback(Feedback feedback) {
        feedbackDao.createFeedback(feedback);  // Créer le feedback
    }
}

