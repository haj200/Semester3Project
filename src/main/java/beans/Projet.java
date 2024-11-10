package beans;

import java.sql.Blob;

public class Projet {
	// attributs d'un projet
	private int id;
	private String titre;
	private String description;
	private String objectifs;
	private double budget;
	private Blob documentsJustif;
	private String localisation;
	private String benefice;
	private boolean estValide;
	private double gain;
	private Habitant habitant; // Association avec la classe Habitant
	private Domaine domaine; // Association avec la classe Domaine
	// constructeurs
	// par defaut
	public Projet() {
		super();
	}
	// avec tous les attributs
	public Projet(int id, String titre, String description, String objectifs, double budget, Blob documentsJustif,
			String localisation, String benefice, boolean estValide, double gain, Habitant habitant, Domaine domaine) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.objectifs = objectifs;
		this.budget = budget;
		this.documentsJustif = documentsJustif;
		this.localisation = localisation;
		this.benefice = benefice;
		this.estValide = estValide;
		this.gain = gain;
		this.habitant = habitant;
		this.domaine = domaine;
	}

	

	// avec tous les attributs sans id
	public Projet(String titre, String description, String objectifs, double budget, Blob documentsJustif,
			String localisation, String benefice, boolean estValide, double gain, Habitant habitant, Domaine domaine) {
		super();
		this.titre = titre;
		this.description = description;
		this.objectifs = objectifs;
		this.budget = budget;
		this.documentsJustif = documentsJustif;
		this.localisation = localisation;
		this.benefice = benefice;
		this.estValide = estValide;
		this.gain = gain;
		this.habitant = habitant;
		this.domaine = domaine;
	}
	// getters et setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getObjectifs() {
		return objectifs;
	}
	public void setObjectifs(String objectifs) {
		this.objectifs = objectifs;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public Blob getDocumentsJustif() {
		return documentsJustif;
	}
	public void setDocumentsJustif(Blob documentsJustif) {
		this.documentsJustif = documentsJustif;
	}
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public String getBenefice() {
		return benefice;
	}
	public void setBenefice(String benefice) {
		this.benefice = benefice;
	}
	public boolean isEstValide() {
		return estValide;
	}
	public void setEstValide(boolean estValide) {
		this.estValide = estValide;
	}
	public double getGain() {
		return gain;
	}
	public void setGain(double gain) {
		this.gain = gain;
	}
	public Habitant getHabitant() {
		return habitant;
	}
	public void setHabitant(Habitant habitant) {
		this.habitant = habitant;
	}
	public Domaine getDomaine() {
		return domaine;
	}
	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}
	

}
