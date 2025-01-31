package servlets.servletsGerant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import beans.Habitant;
import dao.DAOFactory;
import dao.daoHabitant.HabitantDao;

@WebServlet("/HabitantServlet")
public class HabitantServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HabitantDao habitantDao;

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.habitantDao = daoFactory.getHabitantDao();
    }

    public HabitantServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            listHabitants(request, response); // Appeler la méthode qui liste les habitants
        } else {
            switch (action) {
                case "ajouter":
                    showNewForm(request, response); // Afficher le formulaire d'ajout
                    break;
                case "modifier":
                    showEditForm(request, response); // Afficher le formulaire de modification
                    break;
                case "supprimer":
                    deleteHabitant(request, response); // Supprimer l'habitant
                    break;
                default:
                    listHabitants(request, response); // Afficher la liste des habitants pour une action inconnue
                    break;
            }
        }
    }

    private void listHabitants(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the current page from the request; default to 1 if not provided
        int currentPage = 1;
        String pageParam = request.getParameter("page");
        if (pageParam != null && !pageParam.isEmpty()) {
            currentPage = Integer.parseInt(pageParam);
        }

        // Define the number of rows per page
        int rowsPerPage = 6;

        // Get the total number of habitants from the database
        int totalHabitants = habitantDao.getHabitantsCount();

        // Calculate the starting row for the current page
        int start = (currentPage - 1) * rowsPerPage;

        // Fetch the habitants for the current page
        List<Habitant> habitants = habitantDao.getHabitantsPaginated(start, rowsPerPage);

        // Calculate the total number of pages
        int totalPages = (int) Math.ceil((double) totalHabitants / rowsPerPage);

        // Set attributes for the request
        request.setAttribute("habitants", habitants);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", totalPages);

        // Forward to the JSP
        request.getRequestDispatcher("/Gerant/Habitant/habitants.jsp").forward(request, response);
    }


    protected void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("hi");
    	request.getRequestDispatcher("/Gerant/Habitant/addHabitant.jsp").forward(request, response); // Rediriger vers le formulaire d'ajout
    }

    protected void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Habitant habitant = habitantDao.getHabitantById(id); // Récupérer l'habitant par son ID
        request.setAttribute("h", habitant); // Ajouter l'habitant à la requête
        request.getRequestDispatcher("/Gerant/Habitant/updateHabitant.jsp").forward(request, response); // Rediriger vers le formulaire de modification
    }

    protected void deleteHabitant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        habitantDao.deleteHabitant(id); // Supprimer l'habitant
        response.sendRedirect(request.getContextPath() + "/HabitantServlet"); // Rediriger vers la liste des habitants
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("hi");
    	String action = request.getParameter("action");
        if (action != null && action.equals("save")) {
            saveHabitant(request,response);
        }
    }

    private void saveHabitant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("hi");
    	String id = request.getParameter("id");
        String username = request.getParameter("username");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cin = request.getParameter("cin");
        String adresse = request.getParameter("addresse");
        LocalDate dateDeNaissance = LocalDate.parse(request.getParameter("dateDeNaissance"));
        String metier = request.getParameter("metier");
        Habitant habitant = new Habitant();
        habitant.setUsername(username);
        habitant.setNom(nom);
        habitant.setPrenom(prenom);
        habitant.setEmail(email);
        habitant.setPassword(password);
        habitant.setCin(cin);
        habitant.setAddresse(adresse);
        habitant.setDateDeNaissance(dateDeNaissance);
        habitant.setMetier(metier);
        

        if (id == null || id.isEmpty()) {
        	 System.out.println("sav");
            habitantDao.createHabitant(habitant); // Créer un nouvel habitant
            System.out.println("save");
        } else {
        	habitant.setId(Integer.parseInt(id));
            habitantDao.updateHabitant(habitant); // Mettre à jour l'habitant existant
        }

        response.sendRedirect(request.getContextPath() + "/HabitantServlet");
    }
}
