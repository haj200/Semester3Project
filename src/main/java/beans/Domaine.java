package beans;

public class Domaine {
	// les attributs d'un domaine
		private int id;
		private String nom;
		private String description;
		private String criteres;
		// les constructeurs
		//constructeur avec la donnée de tous les champs
		public Domaine(int id, String nom, String description, String criteres) {
			super();
			this.id = id;
			this.nom = nom;
			this.description = description;
			this.criteres = criteres;
		}
		//constructeur avec la donnée de tous les champs sans l'id
		public Domaine(String nom, String description, String criteres) {
			super();
			this.nom = nom;
			this.description = description;
			this.criteres = criteres;
		}
		//getters et setters
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getCriteres() {
			return criteres;
		}
		public void setCriteres(String criteres) {
			this.criteres = criteres;
		}
		
}
