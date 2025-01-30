package servlets.servletsGerant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import beans.Domaine;
import dao.DAOFactory;
import dao.daoDomaine.DomaineDao;

@WebServlet("/DomaineServlet")
public class DomaineServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DomaineDao domaineDao;

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.domaineDao = daoFactory.getDomaineDao();
    }

    public DomaineServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            list_Domaine(request, response);
        } else {
            switch (action) {
                case "ajouter":
                    shownewform(request, response);
                    break;

                case "modifier":
                    showeditform(request, response);
                    break;

                case "supprimer":
                    deleteDomaine(request, response);
                    break;
                case "view":
                    viewDomaine(request, response);
                    break;

                default:
                    list_Domaine(request, response);
                    break;
            }
        }
    }

    private void viewDomaine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
        Domaine domaine = domaineDao.getDomaineById(id);
        request.setAttribute("domaine", domaine);
        request.getRequestDispatcher("/Gerant/Domaine/viewDomaine.jsp").forward(request, response);
		
	}

	private void list_Domaine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Page actuelle (par défaut : 1)
        int currentPage = 1;
        String pageParam = request.getParameter("page");
        if (pageParam != null && !pageParam.isEmpty()) {
            currentPage = Integer.parseInt(pageParam);
        }

        // Nombre d'éléments par page
        int rowsPerPage = 6;

        // Total des domaines
        int totalDomaines = domaineDao.getDomainesCount();

        // Calcul de la ligne de départ pour la pagination
        int start = (currentPage - 1) * rowsPerPage;

        // Récupération des domaines pour la page actuelle
        List<Domaine> domaines = domaineDao.getDomainesPaginated(start, rowsPerPage);

        // Calcul du nombre total de pages
        int totalPages = (int) Math.ceil((double) totalDomaines / rowsPerPage);

        // Définir les attributs pour la requête
        request.setAttribute("domaines", domaines);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", totalPages);

        // Redirection vers la JSP
        request.getRequestDispatcher("/Gerant/Domaine/domaines.jsp").forward(request, response);
    }


    protected void shownewform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Gerant/Domaine/addDomaine.jsp").forward(request, response);
    }

    protected void showeditform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Domaine domaine = domaineDao.getDomaineById(id);
        request.setAttribute("domaine", domaine);
        request.getRequestDispatcher("/Gerant/Domaine/updateDomaine.jsp").forward(request, response);
    }

    protected void deleteDomaine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        domaineDao.deleteDomaine(id);
        response.sendRedirect(request.getContextPath() + "/DomaineServlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("save")) {
            savedomaine(request, response);
            System.out.println("save");
        }
    }

    private void savedomaine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("hjr");
    	String id = request.getParameter("id");
        
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        String criteres = request.getParameter("criteres");
        Domaine domaine = new Domaine();

        domaine.setNom(nom);
        domaine.setDescription(description);
        domaine.setCriteres(criteres);
        System.out.println(domaine);
        if (id != null && !id.isEmpty()) {
            domaine.setId(Integer.parseInt(id));  // Si l'ID existe, on le définit
        }

        // Si l'ID est null ou vide, il s'agit d'une création de domaine
        if (id == null || id.isEmpty()) {
            domaineDao.createDomaine(domaine);  // Créer un nouveau domaine
        } else {
            domaineDao.updateDomaine(domaine);  // Mettre à jour un domaine existant
        }
        System.out.println("sav");
        response.sendRedirect(request.getContextPath() + "/DomaineServlet");
    }
}

