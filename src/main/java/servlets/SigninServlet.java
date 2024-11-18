package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.DateUtils;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import beans.Habitant;
import dao.DAOFactory;
import dao.daoHabitant.HabitantDao;


public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HabitantDao habitantDao;

	 public void init() throws ServletException {
	        DAOFactory daoFactory = DAOFactory.getInstance();
	        this.habitantDao =daoFactory.getHabitantDao();
	    }
       
    
    public SigninServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 request.getRequestDispatcher("signIn.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String username = request.getParameter("username");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String password = request.getParameter("password");
        String cin = request.getParameter("cin");
        String adresse = request.getParameter("adresse");
        String dateDeNaissanceStr = request.getParameter("dateDeNaissance");
        String metier = request.getParameter("metier");
        String email = request.getParameter("email");
        
       
        Habitant habitant = new Habitant();
        habitant.setUsername(username);
        habitant.setNom(nom);
        habitant.setPrenom(prenom);
        habitant.setPassword(password);
        habitant.setCin(cin);
        habitant.setAddresse(adresse);
        LocalDate dateDeNaissance = null;
        try {
            dateDeNaissance = DateUtils.convertStringToDate(dateDeNaissanceStr);
            habitant.setDateDeNaissance(dateDeNaissance);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("signIn.jsp?error=invalid_date");
            return;
        }
        habitant.setMetier(metier);
        habitant.setEmail(email);
        
        
        try {
        	habitantDao.createHabitant(habitant);
        	
        } catch (Exception e) {
        	response.sendRedirect("signIn.jsp?error=invalid");
        }
        response.sendRedirect("index");
	}

}
