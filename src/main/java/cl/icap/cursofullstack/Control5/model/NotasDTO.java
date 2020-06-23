package cl.icap.cursofullstack.Control5.model;

public class NotasDTO {
	private int curso_cod;
	private String curso_nom;
	private int alumno_rut;
	private String alumno_nombre;
	private int nmodulo;
	private int neval;
	private int nota;
	
	public int getCurso_cod() {
		return curso_cod;
	}
	public void setCurso_cod(int curso_cod) {
		this.curso_cod = curso_cod;
	}
	public String getCurso_nom() {
		return curso_nom;
	}
	public void setCurso_nom(String curso_nom) {
		this.curso_nom = curso_nom;
	}
	public int getAlumno_rut() {
		return alumno_rut;
	}
	public void setAlumno_rut(int alumno_rut) {
		this.alumno_rut = alumno_rut;
	}
	public String getAlumno_nombre() {
		return alumno_nombre;
	}
	public void setAlumno_nombre(String alumno_nombre) {
		this.alumno_nombre = alumno_nombre;
	}
	public int getNmodulo() {
		return nmodulo;
	}
	public void setNmodulo(int nmodulo) {
		this.nmodulo = nmodulo;
	}
	public int getNeval() {
		return neval;
	}
	public void setNeval(int neval) {
		this.neval = neval;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}

}
