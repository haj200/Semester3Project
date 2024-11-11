package beans;

public class Reclamation {

	
	    // attributs d'une réclamation
	    private int id;
	    private String message;
	    private String reponse;
	    private Habitant habitant; // Association avec la classe Habitant

	    // Constructeurs

	    // Constructeur par défaut
	    public Reclamation() {
	        super();
	    }

	    // Constructeur avec tous les attributs
	    public Reclamation(int id, String message, String reponse, Habitant habitant) {
	        super();
	        this.id = id;
	        this.message = message;
	        this.reponse = reponse;
	        this.habitant = habitant;
	    }

	    // Constructeur sans id
	    public Reclamation(String message, String reponse, Habitant habitant) {
	        super();
	        this.message = message;
	        this.reponse = reponse;
	        this.habitant = habitant;
	    }

	    // Getters et Setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

	    public String getReponse() {
	        return reponse;
	    }

	    public void setReponse(String reponse) {
	        this.reponse = reponse;
	    }

	    public Habitant getHabitant() {
	        return habitant;
	    }

	    public void setHabitant(Habitant habitant) {
	        this.habitant = habitant;
	    }
	}


