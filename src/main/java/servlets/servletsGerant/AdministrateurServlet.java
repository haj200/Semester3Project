package servlets.servletsGerant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import beans.Administrateur;
import beans.Domaine;
import dao.DAOFactory;
import dao.daoAdministrateur.AdministrateurDao;
import dao.daoDomaine.DomaineDao;


@WebServlet("/AdministrateurServlet")
public class AdministrateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdministrateurDao adminDao;
    
	public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.adminDao = daoFactory.getAdministrateurDao();
    }
    public AdministrateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

        if (action == null) {
            list_Administrateurs(request, response);
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
                    list_Administrateurs(request, response);
                    break;
            }}
	}

	
	
	private void deleteDomaine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        adminDao.deleteAdministrateur(id);
        response.sendRedirect(request.getContextPath() + "/AdministrateurServlet");
		
	}
	private void shownewform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/Gerant/AdministrateurJsp/administrateurAdd.jsp").forward(request, response);
		
	}
	private void showeditform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        Administrateur admin = adminDao.getAdministrateurById(id);
        request.setAttribute("admin", admin);
        request.getRequestDispatcher("/Gerant/AdministrateurJsp/administrateurUpdate.jsp").forward(request, response);
		
	}
	private void list_Administrateurs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Administrateur> admins = adminDao.getAdministrateurs();
        request.setAttribute("admins", admins);
        request.getRequestDispatcher("/Gerant/AdministrateurJsp/administrateurs.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
	    if (action != null && action.equals("save")) {
	        saveAdministrateur(request, response);
	        System.out.println("save");
	}
	
    }
	private void saveAdministrateur(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
        
        String nom = request.getParameter("nom");
        String username = request.getParameter("username");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Administrateur admin = new Administrateur();
        
        
        admin.setNom(nom);
        admin.setPrenom(prenom);
        admin.setUsername(username);
        admin.setEmail(email);
        admin.setPassword(password);
        if (id != null && !id.isEmpty()) {
            admin.setId(Integer.parseInt(id));  // Si l'ID existe, on le définit
        }

        // Si l'ID est null ou vide, il s'agit d'une création de domaine
        if (id == null || id.isEmpty()) {
            adminDao.createAdministrateur(admin);  // Créer un nouveau domaine
        } else {
            adminDao.updateAdministrateur(admin);  // Mettre à jour un domaine existant
        }
        System.out.println("sav");
        response.sendRedirect(request.getContextPath() + "/AdministrateurServlet");
    }
		
	}


