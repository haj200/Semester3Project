package servlets.servletsHabitant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import beans.Domaine;
import beans.Habitant;
import beans.Reclamation;
import dao.DAOFactory;
import dao.daoReclamation.ReclamationDao;

/**
 * Servlet implementation class ReclamationHabitant
 */
@WebServlet("/ReclamationHabitant")
public class ReclamationHabitant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReclamationDao reclamationDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReclamationHabitant() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.reclamationDao = daoFactory.getReclamationDao();
        
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
        if (action == null) {
            action = "list"; // Action par défaut
        }
        switch (action) {
        case "new":
            showNewForm(request, response);
            break;
        case "view":
        	viewReclamation(request, response);
            break;
        case "myreclam":
        	myreclam(request, response);
        break;
        default:
        listReclamations(request, response); // Par défaut, afficher la liste
        break;
		
	}}
	protected void myreclam(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Récupérer le paramètre "id" de la requête
	    String idParam = request.getParameter("id");

	    if (idParam != null && !idParam.isEmpty()) {
	        try {
	            // Convertir l'ID en entier
	            int habitantId = Integer.parseInt(idParam);

	            // Récupérer les réclamations associées à cet habitant
	            List<Reclamation> reclamations = reclamationDao.reclamationsParHabitant(habitantId);
	            request.setAttribute("reclamations", reclamations);

	            // Rediriger vers la page JSP pour afficher les réclamations
	            request.getRequestDispatcher("/Habitant/Reclamation/mesreclamations.jsp").forward(request, response);
	        } catch (NumberFormatException e) {
	            // Si l'ID n'est pas un entier valide, rediriger vers la page dashboard
	            response.sendRedirect(request.getContextPath() + "/Habitant/dashboard.jsp");
	        }
	    } else {
	        // Si le paramètre "id" est manquant ou vide, rediriger vers la page dashboard
	        response.sendRedirect(request.getContextPath() + "/Habitant/dashboard.jsp");
	    }
	}





	 private void viewReclamation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("reclamation", reclamationDao.getReclamationById(id));
	        request.getRequestDispatcher("/Habitant/Reclamation/reclamationView.jsp").forward(request, response);
	    }
	    
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        // Récupérer l'objet habitant depuis la session
	        Habitant habitant = (Habitant) request.getSession().getAttribute("user");

	        if (habitant == null) {
	            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not authenticated");
	            return;
	        }

	        // Récupérer l'ID de l'habitant connecté
	        Integer habitantId = habitant.getId();
	        System.out.println("ID de l'habitant connecté : " + habitantId);

	        // Ajouter l'ID de l'habitant en tant qu'attribut pour la vue
	        request.setAttribute("habitantId", habitantId);

	        // Redirection vers le formulaire de réclamation
	        request.getRequestDispatcher("/Habitant/Reclamation/formReclamation.jsp").forward(request, response);
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors du chargement du formulaire de réclamation");
	    }
	}

	protected void listReclamations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        // Récupérer les réclamations via la DAO
	        List<Reclamation> reclamations = reclamationDao.reclamations();
	        request.setAttribute("reclamations", reclamations);

	        // Transférer la requête et la réponse à la JSP
	        request.getRequestDispatcher("/Habitant/Reclamation/listReclamations.jsp").forward(request, response);
	    } catch (Exception e) {
	        e.printStackTrace();

	        // Gérer les erreurs et afficher un message approprié
	        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de l'affichage des réclamations.");
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");

        switch (action) {
            case "add":
                createReclamation(request, response);
                break;
		
	}
	}
	private void createReclamation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        // Vérifier les paramètres
	        String message = request.getParameter("message");
	        System.out.println("message: " + message); 

	        if (message == null || message.trim().isEmpty()) {
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing required fields: message");
	            return;
	        }

	        // Récupérer l'habitant connecté depuis la session
	        Habitant habitant = (Habitant) request.getSession().getAttribute("user");
	        if (habitant == null) {
	            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not authenticated");
	            return;
	        }

	        // Utiliser l'objet habitant récupéré de la session
	        
	        

	        // Créer l'objet Habitant (optionnel si déjà défini dans la session)
	        habitant.setId(habitant.getId());

	        // Créer l'objet Reclamation
	        Reclamation reclamation = new Reclamation();
	        reclamation.setMessage(message);
	        
	        reclamation.setHabitant(habitant);
	        // Par défaut, aucune réponse n'a encore été donnée
	        reclamation.setReponse(null);  // Pas de réponse au début
	        
	        // Insérer la réclamation en base de données via le DAO
	        reclamationDao.createReclamation(reclamation);

	        // Redirection vers une autre page (ex. la liste des réclamations)
	        response.sendRedirect(request.getContextPath() + "/ReclamationHabitant?action=list");
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.getWriter().println("Error creating reclamation: " + e.getMessage());
	    }
	}



}
