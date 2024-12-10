package beans;

public class Reclamation {

	
	    // attributs d'une réclamation
	    private int id;
	    private String message;
	    private String reponse;
	    private Habitant habitant;
	    private int est_repondu;
	    // Association avec la classe Habitant

	    // Constructeurs

	    // Constructeur par défaut
	    public Reclamation() {
	        super();
	    }

	    

	    public Reclamation(int id, String message, String reponse, Habitant habitant, int est_repondu) {
			super();
			this.id = id;
			this.message = message;
			this.reponse = reponse;
			this.habitant = habitant;
			this.est_repondu = est_repondu;
		}
	    public Reclamation(String message, String reponse, Habitant habitant, int est_repondu) {
			super();
			
			this.message = message;
			this.reponse = reponse;
			this.habitant = habitant;
			this.est_repondu = est_repondu;
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



		public int getEst_repondu() {
			return est_repondu;
		}



		public void setEst_repondu(int est_repondu) {
			this.est_repondu = est_repondu;
		}
	    
	}


