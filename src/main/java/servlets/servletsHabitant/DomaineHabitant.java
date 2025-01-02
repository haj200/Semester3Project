package servlets.servletsHabitant;

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

@WebServlet("/DomaineHabitant")
public class DomaineHabitant extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DomaineDao domaineDao;

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.domaineDao = daoFactory.getDomaineDao();
    }

    public DomaineHabitant() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Domaine> domaines = domaineDao.domaines();
        request.setAttribute("domaines", domaines);
        request.getRequestDispatcher("/Habitant/listDomaines.jsp").forward(request, response);
        }
    

    
}

