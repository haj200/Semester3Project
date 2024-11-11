package beans;


	

	public class Feedback {

	    // Attributs d'un feedback
	    private int id;
	    private String message;
	    private String proposition;
	    private Projet projet; // Association avec la classe Projet
	    private Habitant habitant; // Association avec la classe Habitant

	    // Constructeurs

	    // Constructeur par défaut
	    public Feedback() {
	        super();
	    }

	    // Constructeur avec tous les attributs
	    public Feedback(int id, String message, String proposition, Projet projet, Habitant habitant) {
	        super();
	        this.id = id;
	        this.message = message;
	        this.proposition = proposition;
	        this.projet = projet;
	        this.habitant = habitant;
	    }

	    // Constructeur sans id
	    public Feedback(String message, String proposition, Projet projet, Habitant habitant) {
	        super();
	        this.message = message;
	        this.proposition = proposition;
	        this.projet = projet;
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

	    public String getProposition() {
	        return proposition;
	    }

	    public void setProposition(String proposition) {
	        this.proposition = proposition;
	    }

	    public Projet getProjet() {
	        return projet;
	    }

	    public void setProjet(Projet projet) {
	        this.projet = projet;
	    }

	    public Habitant getHabitant() {
	        return habitant;
	    }

	    public void setHabitant(Habitant habitant) {
	        this.habitant = habitant;
	    }
	}



