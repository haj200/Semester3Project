package servlets.servletsGerant;

import java.io.IOException;
import java.util.List;

import beans.Habitant;
import beans.Reclamation;
import dao.DAOFactory;
import dao.daoHabitant.HabitantDao;
import dao.daoReclamation.ReclamationDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ReclamationServlet")
public class ReclamationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReclamationDao reclamationDao;
    private HabitantDao habitantDao;

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.reclamationDao = daoFactory.getReclamationDao();
        this.habitantDao = daoFactory.getHabitantDao();
    }

    public ReclamationServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            listReclamations(request, response);
        } else {
            switch (action) {
                case "ajouter":
                    showNewForm(request, response);
                    break;
                case "modifier":
                    showEditForm(request, response);
                    break;
                case "supprimer":
                    deleteReclamation(request, response);
                    break;
                default:
                    listReclamations(request, response);
                    break;
            }
        }
    }

    protected void listReclamations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Reclamation> reclamations = reclamationDao.reclamations();
        request.setAttribute("reclamations", reclamations);
        request.getRequestDispatcher("/Gerant/reclamationJsp/reclamations.jsp").forward(request, response);
    }

    protected void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Habitant> habitants = habitantDao.habitants();
        request.setAttribute("habitants", habitants);
        request.getRequestDispatcher("/Gerant/reclamationJsp/reclamationAdd.jsp").forward(request, response);
    }

    protected void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Reclamation reclamation = reclamationDao.getReclamationById(id);
        List<Habitant> habitants = habitantDao.habitants();
        request.setAttribute("reclamation", reclamation);
        request.setAttribute("habitants", habitants);
        request.getRequestDispatcher("/Gerant/reclamationJsp/reclamationUpdate.jsp").forward(request, response);
    }

    protected void deleteReclamation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        reclamationDao.deleteReclamation(id);
        response.sendRedirect(request.getContextPath() + "/ReclamationServlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("save")) {
            saveReclamation(request, response);
        }
    }

    // Méthode refactorisée pour gérer la sauvegarde de la réclamation
    private void saveReclamation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String message = request.getParameter("message");
        String habitantId = request.getParameter("habitants");

        Reclamation reclamation = new Reclamation();
        Habitant habitant = getHabitant(habitantId);  // Récupère l'habitant de manière séparée

        // Définir les propriétés de la réclamation
        reclamation.setMessage(message);
        reclamation.setHabitant(habitant);

        // Si l'ID est présent, on met à jour la réclamation, sinon on crée une nouvelle réclamation
        if (id != null && !id.isEmpty()) {
            updateReclamation(id, reclamation);
        } else {
            createReclamation(reclamation);
        }

        // Redirection après l'enregistrement de la réclamation
        response.sendRedirect(request.getContextPath() + "/ReclamationServlet");
    }

    // Méthode pour récupérer l'habitant à partir de son ID
    private Habitant getHabitant(String habitantId) {
        if (habitantId != null && !habitantId.isEmpty()) {
            int habitantIntId = Integer.parseInt(habitantId);
            return habitantDao.getHabitantById(habitantIntId);
        }
        return null;  // Si l'ID de l'habitant est nul ou vide, retourne null
    }

    // Méthode pour mettre à jour une réclamation
    private void updateReclamation(String id, Reclamation reclamation) {
        reclamation.setId(Integer.parseInt(id));  // Convertir l'ID pour l'update
        reclamationDao.updateReclamation(reclamation);  // Mettre à jour la réclamation
    }

    // Méthode pour créer une nouvelle réclamation
    private void createReclamation(Reclamation reclamation) {
        reclamationDao.createReclamation(reclamation);  // Créer la réclamation
    }
}
