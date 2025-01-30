package servlets.servletsHabitant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import utils.DocumentsJustif;

import java.io.File;
import java.io.IOException;
import beans.Projet;
import beans.Domaine;
import beans.Habitant;
import dao.DAOFactory;
import dao.daoProjet.ProjetDao;
import dao.daoHabitant.HabitantDao;
import dao.daoDomaine.DomaineDao;

@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50   // 50MB
)
@WebServlet("/ProjetHabitant")
public class ProjetHabitant extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProjetDao projetDao;
    private HabitantDao habitantDao;
    private DomaineDao domaineDao;
    private static final String ROOT_DIRECTORY = "C:/Projects/";

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.projetDao = daoFactory.getProjetDao();
        this.habitantDao = daoFactory.getHabitantDao();
        this.domaineDao = daoFactory.getDomaineDao();
    }

    public ProjetHabitant() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "nouveau":
                showNouvForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteProject(request, response);
                break;
            case "myprojet":
            	myprojects(request, response);
            break;
            default:
                listProjects(request, response);
               break;
        }
    }

    private void showNouvForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("Habitant/Projets/formProjet.jsp").forward(request, response);
		
	}

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "add":
                createProject(request, response);
                break;
            case "update":
                updateProject(request, response);
                break;
        }
    }

    private void updateProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int projectId = Integer.parseInt(request.getParameter("id"));
            Projet projet = projetDao.getProjetById(projectId);

            String titre = request.getParameter("titre");
            String description = request.getParameter("description");
            String objectifs = request.getParameter("objectifs");
            double budget = Double.parseDouble(request.getParameter("budget"));
            String localisation = request.getParameter("localisation");
            String benefice = request.getParameter("benefice");
            int habitantId = 3;
            int domaineId = 1;

            Domaine domaine = new Domaine();
            domaine.setId(domaineId);

            Habitant habitant = new Habitant();
            habitant.setId(habitantId);
            
            String projectDirectory = projet.getDocumentsJustifChemin();
            DocumentsJustif documentsJustif = projet.getDocumentsJustif();
            if (documentsJustif == null) {
                documentsJustif = new DocumentsJustif();
                projet.setDocumentsJustif(documentsJustif);
            }

            if (projectDirectory == null || projectDirectory.isEmpty()) {
                projectDirectory = ROOT_DIRECTORY + "project_" + projectId + "/";
                File dir = new File(projectDirectory);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
            }

            DocumentsJustif documentsJustif1 = projet.getDocumentsJustif();
            if (documentsJustif1 == null) {
                documentsJustif1 = new DocumentsJustif();
            }

            documentsJustif1.setPlanBusiness(saveFileIfUpdated(request.getPart("planBusiness"), projectDirectory, "planBusiness", documentsJustif1.getPlanBusiness()));
            documentsJustif1.setEtudeFinanciere(saveFileIfUpdated(request.getPart("etudeFinanciere"), projectDirectory, "etudeFinanciere", documentsJustif1.getEtudeFinanciere()));
            documentsJustif1.setPhoto(saveFileIfUpdated(request.getPart("photo"), projectDirectory, "photo", documentsJustif1.getPhoto()));
            documentsJustif1.setFullDescriptif(saveFileIfUpdated(request.getPart("fullDescriptif"), projectDirectory, "fullDescriptif", documentsJustif1.getFullDescriptif()));

            projet.setTitre(titre);
            projet.setDescription(description);
            projet.setObjectifs(objectifs);
            projet.setBudget(budget);
            projet.setLocalisation(localisation);
            projet.setBenefice(benefice);
            projet.setDomaine(domaine);
            projet.setHabitant(habitant);
            projet.setDocumentsJustif(documentsJustif1);

            projetDao.updateProjet(projet);
            response.sendRedirect(request.getContextPath() + "/ProjetHabitant");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error updating project: " + e.getMessage());
        }}
    private void createProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Récupérer les paramètres du formulaire
            String titre = request.getParameter("titre");
            String description = request.getParameter("description");
            double budget = Double.parseDouble(request.getParameter("budget"));
            String objectifs = request.getParameter("objectifs");
            String localisation = request.getParameter("localisation");
            String benefice = request.getParameter("benefice");

            // Récupérer l'utilisateur authentifié depuis la session
            Habitant habitant = (Habitant) request.getSession().getAttribute("user");

            // Vérifier si l'utilisateur est authentifié
            if (habitant == null) {
                // L'utilisateur n'est pas authentifié, renvoyer une erreur ou rediriger
                response.sendRedirect("login.jsp");
                return;
            }

            // Récupérer le paramètre "id" et le convertir en entier
            String idParam = request.getParameter("id");
            int domaineId = 0;

            if (idParam != null) {
                try {
                    domaineId = Integer.parseInt(idParam); // Conversion de la chaîne en int
                } catch (NumberFormatException e) {
                    System.out.println("L'ID n'est pas un nombre valide.");
                    response.getWriter().println("L'ID du domaine est invalide.");
                    return;
                }
            }

            // Créer l'objet Domaine
            Domaine domaine = new Domaine();
            domaine.setId(domaineId);

            // Créer l'objet Projet
            Projet projet = new Projet();
            projet.setTitre(titre);
            projet.setDescription(description);
            projet.setObjectifs(objectifs);
            projet.setBudget(budget);
            projet.setLocalisation(localisation);
            projet.setBenefice(benefice);
            projet.setDomaine(domaine);
            projet.setHabitant(habitant); // Associer l'habitant au projet

            // Créer un répertoire pour le projet
            String projectDirectory = ROOT_DIRECTORY + "project_" + System.currentTimeMillis() + "/";
            File dir = new File(projectDirectory);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // Gérer les documents associés au projet
            DocumentsJustif documentsJustif = new DocumentsJustif();
            documentsJustif.setPlanBusiness(saveFile(request.getPart("planBusiness"), projectDirectory, "planBusiness"));
            documentsJustif.setEtudeFinanciere(saveFile(request.getPart("etudeFinanciere"), projectDirectory, "etudeFinanciere"));
            documentsJustif.setPhoto(saveFile(request.getPart("photo"), projectDirectory, "photo"));
            documentsJustif.setFullDescriptif(saveFile(request.getPart("fullDescriptif"), projectDirectory, "fullDescriptif"));

            projet.setDocumentsJustif(documentsJustif);

            // Enregistrer le projet dans la base de données
            projetDao.createProjet(projet);

            // Rediriger l'utilisateur vers la page de projets de l'habitant
            response.sendRedirect(request.getContextPath() + "/ProjetHabitant");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error creating project: " + e.getMessage());
        }
    }


    private String saveFile(Part part, String directory, String fileNamePrefix) throws IOException {
        if (part != null && part.getSize() > 0) {
            String extension = getFileExtension(part);
            if (extension.isEmpty()) {
                throw new IOException("Invalid file type.");
            }
            
            String filePath = directory + fileNamePrefix + "_" + System.currentTimeMillis() + extension;
            part.write(filePath);
            return filePath;
        }
        return null;
    }

    private String getFileExtension(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        for (String cd : contentDisposition.split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                if (fileName.contains(".")) {
                    return fileName.substring(fileName.lastIndexOf('.'));
                }
            }
        }
        return "";
    }
    private String saveFileIfUpdated(Part part, String directory, String fileName, String existingFilePath) throws IOException {
        if (part != null && part.getSize() > 0) {
            if (existingFilePath != null) {
                File oldFile = new File(existingFilePath);
                if (oldFile.exists()) {
                    oldFile.delete();
                }
            }
            return saveFile(part, directory, fileName);
        }
        return existingFilePath;}

    private void listProjects(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("projects", projetDao.projets());
        request.getRequestDispatcher("/Habitant/dashboard.jsp");
    }
   
            // Récupérer et convertir l'identifiant en entier
        	private void myprojects(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	    String idParam = request.getParameter("id"); // Récupérer le paramètre "id" de la requête

        	    if (idParam != null && !idParam.isEmpty()) {
        	        try {
        	            // Convertir l'ID en entier
        	            int habitantId = Integer.parseInt(idParam);

        	            // Récupérer les projets associés à cet habitant
        	            request.setAttribute("projects", projetDao.projetsParHabitant(habitantId));

        	            // Rediriger vers la page JSP pour afficher les projets
        	            request.getRequestDispatcher("/Habitant/Projets/mesprojets.jsp").forward(request, response);
        	        } catch (NumberFormatException e) {
        	            // Si l'ID n'est pas un entier valide, rediriger vers la page dashboard
        	            response.sendRedirect(request.getContextPath() + "/Habitant/dashboard.jsp");
        	        }
        	    } else {
        	        // Si le paramètre "id" est manquant ou vide, rediriger vers la page dashboard
        	        response.sendRedirect(request.getContextPath() + "/Habitant/dashboard.jsp");
        	    }
        	}

       
     



    private void deleteProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        projetDao.deleteProjet(id);
        response.sendRedirect(request.getContextPath() + "/ProjetHabitant");
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Habitant/listDomaines.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Projet projet = projetDao.getProjetById(id);
        request.setAttribute("projet", projet);
        request.getRequestDispatcher("/Habitant/Projets/UpdateProjet.jsp").forward(request, response);
    }

    
}
