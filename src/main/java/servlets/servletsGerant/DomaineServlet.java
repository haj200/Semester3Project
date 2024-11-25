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

                default:
                    list_Domaine(request, response);
                    break;
            }
        }
    }

    protected void list_Domaine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Domaine> domaines = domaineDao.domaines();
        request.setAttribute("domaines", domaines);
        request.getRequestDispatcher("/domaineJsp/domaines.jsp").forward(request, response);
    }

    protected void shownewform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/domaineJsp/domaineAdd.jsp").forward(request, response);
    }

    protected void showeditform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Domaine domaine = domaineDao.getDomaineById(id);
        request.setAttribute("domaine", domaine);
        request.getRequestDispatcher("/domaineJsp/domaineUpdate.jsp").forward(request, response);
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
        }
    }

    private void savedomaine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        String criteres = request.getParameter("criteres");
        Domaine domaine = new Domaine();
        
        domaine.setNom(nom);
        domaine.setDescription(description);
        domaine.setCriteres(criteres);

        if (id == null || id.isEmpty()) {
            domaineDao.createDomaine(domaine);
        } else {
            domaine.setId(Integer.parseInt(id));
            domaineDao.updateDomaine(domaine);
        }

        response.sendRedirect(request.getContextPath() + "/DomaineServlet");
    }
}

