package beans;

import java.sql.Date;


public class Habitant {
	// les attributs d'un habitant
	private int id;
	private String username;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String cin;
	private String addresse;
	private Date dateDeNaissance;
	private String metier;
	// les constructeurs
	//constructeur avec la donnée de tous les champs
	public Habitant(int id, String username, String nom, String prenom, String email, String password, String cin,
			String addresse, Date dateDeNaissance, String metier) {
		super();
		this.id = id;
		this.username = username;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.cin = cin;
		this.addresse = addresse;
		this.dateDeNaissance = dateDeNaissance;
		this.metier = metier;
	}
	//constructeur avec la donnée de tous les champs sans l'id
	public Habitant(String username, String nom, String prenom, String email, String password, String cin,
			String addresse, Date dateDeNaissance, String metier) {
		super();
		this.username = username;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.cin = cin;
		this.addresse = addresse;
		this.dateDeNaissance = dateDeNaissance;
		this.metier = metier;
	}
	
	
	public Habitant() {
		// TODO Auto-generated constructor stub
	}
	// les getters et les setters
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
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(Date dateDeNaissance2) {
		this.dateDeNaissance = dateDeNaissance2;
	}
	public String getMetier() {
		return metier;
	}
	public void setMetier(String metier) {
		this.metier = metier;
	}
	

	
	

}
