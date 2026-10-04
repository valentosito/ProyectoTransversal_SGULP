
package modelo;

import java.util.List;


public class Cursada {
    
    private int idCursada;
    private int anio;
    private int cuatrimestre;
    private String condicion; 
    private double notaFinal;
    private boolean recursante; 
    
    
    // Referencias a objeto Alumno y Materia porque Cursada representa una inscripción concreta de un alumno a una materia: equivalen a las FK.
    // Cursada necesita saber de quién es y de qué materia es la inscripción.
    private Alumno alumno;
    private Materia materia;  
    
    private int porcAsistencia;
    
    
    // Una cursada puede tener muchos registros de asistencia, uno por cada clase/día:
    private List<Asistencia> listaDeAsistencias;

    public Cursada(int idCursada, int anio, int cuatrimestre, String condicion, double asistencia, double notaFinal, boolean recursante, Alumno alumno, Materia materia, int porcAsistencia, List<Asistencia> listaDeAsistencias) {
        this.idCursada = idCursada;
        this.anio = anio;
        this.cuatrimestre = cuatrimestre;
        this.condicion = condicion;
        this.notaFinal = notaFinal;
        this.recursante = recursante;
        this.alumno = alumno;
        this.materia = materia;
        this.porcAsistencia = porcAsistencia;
        this.listaDeAsistencias = listaDeAsistencias;
    }

    public int getIdCursada() {
        return idCursada;
    }

    public void setIdCursada(int idCursada) {
        this.idCursada = idCursada;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(int cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public boolean isRecursante() {
        return recursante;
    }

    public void setRecursante(boolean recursante) {
        this.recursante = recursante;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public int getPorcAsistencia() {
        return porcAsistencia;
    }

    public void setPorcAsistencia(int porcAsistencia) {
        this.porcAsistencia = porcAsistencia;
    }

    public List<Asistencia> getListaDeAsistencias() {
        return listaDeAsistencias;
    }

    public void setListaDeAsistencias(List<Asistencia> listaDeAsistencias) {
        this.listaDeAsistencias = listaDeAsistencias;
    }

    @Override
    public String toString() {
        return "Cursada{ " + "idCursada=" + idCursada 
                + ", anio=" + anio 
                + ", cuatrimestre=" + cuatrimestre 
                + ", condicion=" + condicion 
                + ", notaFinal=" + notaFinal 
                + ", recursante=" + recursante 
                + ", alumno=" + alumno 
                + ", materia=" + materia 
                + ", porcAsistencia=" + porcAsistencia 
                + ", listaDeAsistencias=" + listaDeAsistencias 
                + '}';
    }
    
    
}
