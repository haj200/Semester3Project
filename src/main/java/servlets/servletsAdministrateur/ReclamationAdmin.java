package servlets.servletsAdministrateur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import beans.Habitant;
import beans.Reclamation;
import dao.DAOFactory;
import dao.daoHabitant.HabitantDao;
import dao.daoReclamation.ReclamationDao;


@WebServlet("/ReclamationAdmin")
public class ReclamationAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReclamationDao reclamationDao;
    
   
    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.reclamationDao = daoFactory.getReclamationDao();
        
    }
    
    public ReclamationAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("action");

	        if (action == null) {
	            listReclamations(request, response);
	        } else {
	            switch (action) {
	                case "list":
	                	listReclamations(request, response);
	                    break;
	                case "respond":
	                    showRespondForm(request, response);
	                    break;
	                case "view":
	                    viewReclamation(request, response);
	                    break;
	                default:
	                    listReclamations(request, response);
	                    break;
	            }
	        }
	}

	
	protected void viewReclamation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Reclamation reclamation = reclamationDao.getReclamationById(id);
        request.setAttribute("reclamation", reclamation);
        request.getRequestDispatcher("/Administrateur/Reclamation/reclamation.jsp").forward(request, response);
    }

	private void showRespondForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        Reclamation reclamation = reclamationDao.getReclamationById(id);
        
        request.setAttribute("reclamation", reclamation);
        
        request.getRequestDispatcher("/Administrateur/Reclamation/respondForm.jsp").forward(request, response);
		
	}

	protected void listReclamations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Reclamation> reclamations = reclamationDao.reclamations();
        request.setAttribute("reclamations", reclamations);
        request.getRequestDispatcher("/Administrateur/Reclamation/reclamations.jsp").forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    int idReclamation = Integer.parseInt(request.getParameter("id"));
	    String reponse = request.getParameter("reponse");
	    Reclamation reclamation = new Reclamation();
	    reclamation.setReponse(reponse);
	    reclamation.setId(idReclamation);
	    try {
	        // Appel au service pour enregistrer la réponse
	        reclamationDao.respondReclamation(reclamation);

	        // Redirection vers la liste des réclamations après traitement
	        response.sendRedirect(request.getContextPath() + "/ReclamationAdmin");
	    } catch (Exception e) {
	        // Gestion des erreurs
	        e.printStackTrace();
	        request.setAttribute("errorMessage", "Une erreur s'est produite lors de l'enregistrement de la réponse.");
	        request.getRequestDispatcher("/error.jsp").forward(request, response);
	    }
	}


}
