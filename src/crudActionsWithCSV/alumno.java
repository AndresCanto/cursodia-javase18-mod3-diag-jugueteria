package crudActionsWithCSV;

public class alumno 
{
	private String nom;
	private int edad;
	private int mat;
	public alumno(String nom, int edad, int mat) {
		super();
		this.nom = nom;
		this.edad = edad;
		this.mat = mat;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int id) {
		this.edad = id;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public String toString() {
		return getNom()+","+getEdad()+","+getMat();
	}
}
