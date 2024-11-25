package servlets.servletsGerant;

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
        request.getRequestDispatcher("/reclamationJsp/reclamations.jsp").forward(request, response);
    }

    protected void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Habitant> habitants = habitantDao.habitants(); // Assurez-vous que cette méthode existe dans le DAO
        
        // Ajouter la liste des habitants à l'attribut de la requête
        request.setAttribute("habitants", habitants);
        request.getRequestDispatcher("/reclamationJsp/reclamationAdd.jsp").forward(request, response);
    }

    protected void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Reclamation reclamation = reclamationDao.getReclamationById(id);
        List<Habitant> habitants = habitantDao.habitants();
        request.setAttribute("reclamation", reclamation);
        request.setAttribute("habitants", habitants);
        request.getRequestDispatcher("/reclamationJsp/reclamationUpdate.jsp").forward(request, response);
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

    private void saveReclamation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String message = request.getParameter("message");
        String reponse = request.getParameter("reponse"); // Only for admin to fill later
        int habitantId = Integer.parseInt(request.getParameter("id_habitant"));

        Habitant habitant = habitantDao.getHabitantById(habitantId);

        Reclamation reclamation = new Reclamation();
        reclamation.setMessage(message);
        reclamation.setReponse(reponse); // Only for admin to fill later
        reclamation.setHabitant(habitant);

        if (id == null || id.isEmpty()) {
            reclamationDao.createReclamation(reclamation);
        } else {
            reclamation.setId(Integer.parseInt(id));
            reclamationDao.updateReclamation(reclamation);
        }

        response.sendRedirect(request.getContextPath() + "/ReclamationServlet");
    }
}


