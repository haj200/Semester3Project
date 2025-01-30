package servlets.servletsHabitant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import beans.Feedback;
import beans.Habitant;
import beans.Projet;
import dao.DAOFactory;
import dao.daoFeedback.FeedbackDao;
import dao.daoHabitant.HabitantDao;
import dao.daoProjet.ProjetDao;
import dao.daoProjet.ProjetDaoImp; // Assurez-vous que ProjetDaoImp est bien la classe implémentant ProjetDao

@WebServlet("/FeedbackHabitant")
public class FeedbackHabitant extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProjetDao projetDao;
    private HabitantDao habitantDao;
    private FeedbackDao feedbackDao;
    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
       
        this.projetDao = daoFactory.getProjetDao();  // Assurez-vous que getProjetDao() existe
        this.habitantDao = daoFactory.getHabitantDao();
        this.projetDao = daoFactory.getProjetDao();
        this.feedbackDao = daoFactory.getFeedbackDao();
    } 


    public FeedbackHabitant() {
        super();
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list"; // Action par défaut
        }

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "every" :
            	listFeedbacks(request, response);
            default:
                listProjects(request, response);
                break;
             
        }
    }
    private void listProjects(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("projects", projetDao.projets());
        request.getRequestDispatcher("/Habitant/dashboard.jsp").forward(request, response);
    }
    private void listFeedbacks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int idiiProjet = Integer.parseInt(request.getParameter("idProjet"));
        request.setAttribute("feedbacks", feedbackDao.getFeedbackByProject(idiiProjet));
        request.getRequestDispatcher("/Habitant/Feedback/listFeedback.jsp").forward(request, response);
    }
    
    

    
   
	


    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Vérifier si le paramètre "id" est présent et non vide
            String idProjetStr = request.getParameter("id");
            int idiiProjet = 0; // Valeur par défaut

            if (idProjetStr != null && !idProjetStr.isEmpty()) {
                try {
                    idiiProjet = Integer.parseInt(idProjetStr);
                } catch (NumberFormatException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID du projet invalide");
                    return;
                }
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID du projet manquant");
                return;
            }

            // Récupérer l'objet habitant depuis la session
            Habitant habitant = (Habitant) request.getSession().getAttribute("user");

            if (habitant == null) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not authenticated");
                return;
            }

            // Récupérer l'ID de l'habitant
            Integer habitantId = habitant.getId();
            System.out.println("id " + habitantId); 

            // Passer les données à la vue
            request.setAttribute("habitantId", habitantId);
            request.setAttribute("id", idiiProjet);
            
            // Redirection vers le formulaire
            request.getRequestDispatcher("Habitant/Feedback/formFeedback.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors du chargement des projets et habitants");
        }
    }


    	

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
    	if (action != null && action.equals("add")) {
    	    createFeedback(request, response);
    }
    }
  
    private void createFeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    	    // Vérifier les paramètres
    	    String message = request.getParameter("message");
    	    String proposition = request.getParameter("proposition");
    	    String projetIdStr = request.getParameter("idProjet");
    	    System.out.println("action: " + request.getParameter("action"));  // Affiche l'action
            System.out.println("message: " + message);  // Affiche le message
            System.out.println("proposition: " + proposition);  // Affiche la proposition
            System.out.println("projetId: " + projetIdStr);  // Affiche l'ID du projet
    	    if (message == null || proposition == null || projetIdStr == null) {
    	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing required fields");
    	        return;
    	    }

    	    // Convertir projetId en entier et vérifier sa validité
    	    int idiProjet = Integer.parseInt(projetIdStr);
    	    if (idiProjet <= 0) {
    	        throw new IllegalArgumentException("Invalid project ID");
    	    }

    	    // Récupérer l'habitant connecté depuis la session
    	    Habitant habitant = (Habitant) request.getSession().getAttribute("user");
    	    if (habitant == null) {
    	        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not authenticated");
    	        return;
    	    }

    	    // Créer le projet et l'habitant associés
    	    Projet projet = new Projet();
    	    projet.setId(idiProjet);

    	    // Utiliser l'objet habitant récupéré de la session
    	    habitant.setId(habitant.getId()); // Si nécessaire, vous pouvez faire une vérification ici

    	    // Créer l'objet Feedback
    	    Feedback feedback = new Feedback();
    	    feedback.setMessage(message);
    	    feedback.setProposition(proposition);
    	    feedback.setProjet(projet);
    	    feedback.setHabitant(habitant);

    	    // Insérer le feedback en base de données via le DAO
    	    feedbackDao.createFeedback(feedback);
    	    

    	    // Redirection vers une autre page (ex. la liste des feedbacks)
    	    response.sendRedirect(request.getContextPath() + "/FeedbackHabitant?action=list");
    	} catch (Exception e) {
    	    e.printStackTrace();
    	    response.getWriter().println("Error creating feedback: " + e.getMessage());
    	}

    }
}



