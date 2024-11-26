package servlets.servletsGerant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import beans.Projet;
import beans.Habitant;
import beans.Domaine;
import dao.DAOFactory;
import dao.daoProjet.ProjetDao;
import dao.daoHabitant.HabitantDao;
import dao.daoDomaine.DomaineDao;

@WebServlet("/ProjectServlet")
public class ProjectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProjetDao projetDao;
    private HabitantDao habitantDao;
    private DomaineDao domaineDao;

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.projetDao = daoFactory.getProjetDao();
        this.habitantDao = daoFactory.getHabitantDao();
        this.domaineDao = daoFactory.getDomaineDao();
    }

    public ProjectServlet() {
        super();
    }

    // Afficher la liste des projets
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            listProjets(request, response);
        } else {
            switch (action) {
                case "ajouter":
                    showNewForm(request, response);
                    break;
                case "modifier":
                    showEditForm(request, response);
                    break;
                case "supprimer":
                    deleteProjet(request, response);
                    break;
                default:
                    listProjets(request, response);
                    break;
            }
        }
    }

    // Liste des projets
    protected void listProjets(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Projet> projets = projetDao.projets();
        request.setAttribute("projets", projets);
        request.getRequestDispatcher("/projetJsp/projets.jsp").forward(request, response);
    }

    // Afficher le formulaire d'ajout d'un projet
    protected void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les listes d'habitants et de domaines pour les afficher dans le formulaire
        List<Habitant> habitants = habitantDao.habitants();
        List<Domaine> domaines = domaineDao.domaines();
        
        request.setAttribute("habitants", habitants);
        request.setAttribute("domaines", domaines);
        request.getRequestDispatcher("/projetJsp/projetAdd.jsp").forward(request, response);
    }

    // Afficher le formulaire de modification d'un projet
    protected void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Projet projet = projetDao.getProjetById(id);
        List<Habitant> habitants = habitantDao.habitants();
        List<Domaine> domaines = domaineDao.domaines();
        
        request.setAttribute("projet", projet);
        request.setAttribute("habitants", habitants);
        request.setAttribute("domaines", domaines);
        request.getRequestDispatcher("/projetJsp/projetUpdate.jsp").forward(request, response);
    }

    // Supprimer un projet
    protected void deleteProjet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        projetDao.deleteProjet(id);
        response.sendRedirect(request.getContextPath() + "/ProjectServlet");
    }

    // Traitement de la soumission du formulaire (ajout ou modification)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("save")) {
            saveProjet(request, response);
        }
    }

    // Sauvegarder ou mettre à jour un projet
    private void saveProjet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String titre = request.getParameter("titre");
        String description = request.getParameter("description");
        String objectifs = request.getParameter("objectifs");
        double budget = Double.parseDouble(request.getParameter("budget"));
        String localisation = request.getParameter("localisation");
        String benefice = request.getParameter("benefice");
        boolean estValide = Boolean.parseBoolean(request.getParameter("estValide"));
        double gain = Double.parseDouble(request.getParameter("gain"));
        int habitantId = Integer.parseInt(request.getParameter("id_habitant"));
        int domaineId = Integer.parseInt(request.getParameter("id_domaine"));

        // Récupérer les objets associés par leurs ID
        Habitant habitant = habitantDao.getHabitantById(habitantId);
        Domaine domaine = domaineDao.getDomaineById(domaineId);

        // Créer un nouveau projet
        Projet projet = new Projet();
        projet.setTitre(titre);
        projet.setDescription(description);
        projet.setObjectifs(objectifs);
        projet.setBudget(budget);
        projet.setLocalisation(localisation);
        projet.setBenefice(benefice);
        projet.setEstValide(estValide);
        projet.setGain(gain);
        projet.setHabitant(habitant);
        projet.setDomaine(domaine);

        if (id == null || id.isEmpty()) {
            projetDao.createProjet(projet); // Créer un nouveau projet
        } else {
            projet.setId(Integer.parseInt(id));
            projetDao.updateProjet(projet); // Mettre à jour un projet existant
        }

        response.sendRedirect(request.getContextPath() + "/ProjectServlet");
    }
}

