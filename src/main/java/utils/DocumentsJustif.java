package utils;

public class DocumentsJustif {
 private String planBusiness;
 private String EtudeFinanciere;
 private String photo;
 private String fullDescriptif;
public DocumentsJustif(String planBusiness, String etudeFinanciere, String photo, String fullDescriptif) {
	super();
	this.planBusiness = planBusiness;
	EtudeFinanciere = etudeFinanciere;
	this.photo = photo;
	this.fullDescriptif = fullDescriptif;
}
public DocumentsJustif() {
	super();
}
public String getPlanBusiness() {
	return planBusiness;
}
public void setPlanBusiness(String planBusiness) {
	this.planBusiness = planBusiness;
}
public String getEtudeFinanciere() {
	return EtudeFinanciere;
}
public void setEtudeFinanciere(String etudeFinanciere) {
	EtudeFinanciere = etudeFinanciere;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
public String getFullDescriptif() {
	return fullDescriptif;
}
public void setFullDescriptif(String fullDescriptif) {
	this.fullDescriptif = fullDescriptif;
}
 
 

}
