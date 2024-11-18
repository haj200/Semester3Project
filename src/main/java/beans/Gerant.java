package beans;

public class Gerant {
	// les attributs d'un gerant
		private int id;
		private String username;
		private String nom;
		private String prenom;
		private String email;
		private String password;

		// les constructeurs
		// constructeur par défaut
		public Gerant() {
			super();
		}
		// constructeur avec tous les attributs

		public Gerant(int id, String username, String nom, String prenom, String email, String password) {
			super();
			this.id = id;
			this.username = username;
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.password = password;
		}

		// constructeur avec tous les attributs sans id
		public Gerant(String username, String nom, String prenom, String email, String password) {
			super();
			this.username = username;
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.password = password;
		}
		// getters et setters

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}


}
