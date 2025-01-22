package servlets.servletsGerant;

import java.io.IOException;
import java.util.List;

import beans.Reclamation;
import dao.DAOFactory;
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
    

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.reclamationDao = daoFactory.getReclamationDao();
        
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
        request.getRequestDispatcher("/Gerant/Reclamation/reclamations.jsp").forward(request, response);
    }

   

    protected void deleteReclamation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        reclamationDao.deleteReclamation(id);
        response.sendRedirect(request.getContextPath() + "/ReclamationServlet");
    }

   
}
