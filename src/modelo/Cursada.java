package modelo;

import java.util.ArrayList;
import java.util.List;

public class Cursada {

    private int idCursada;
    private int anio;
    private int cuatrimestre;
    private int condicion;
    //private double notaFinal;
    private Double notaFinal;
    private boolean recursante;
    private int porcAsistencia;
    // Una cursada puede tener muchos registros de asistencia, uno por cada clase/día:
    // Referencias a objeto Alumno y Materia porque Cursada representa una inscripción concreta de un alumno a una materia: equivalen a las FK.
    // Cursada necesita saber de quién es y de qué materia es la inscripción.
    private Alumno alumno;
    private Materia materia;

    // Una cursada puede tener muchos registros de asistencia, uno por cada clase/día:
    private List<Asistencia> listaDeAsistencias;

    public Cursada(int idCursada, int anio, int cuatrimestre,
            int condicion, Double notaFinal,
            boolean recursante, int porcAsistencia,
            Alumno alumno, Materia materia) {

        this.idCursada = idCursada;
        this.anio = anio;
        this.cuatrimestre = cuatrimestre;
        this.condicion = condicion;
        this.notaFinal = notaFinal;
        this.recursante = recursante;
        this.porcAsistencia = porcAsistencia;
        this.alumno = alumno;
        this.materia = materia;

        this.listaDeAsistencias = new ArrayList<>();
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

    public int getCondicion() {
        return condicion;
    }

    public void setCondicion(int condicion) {
        this.condicion = condicion;
    }

    public Double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public boolean isRecursante() {
        return recursante;
    }

    public void setRecursante(boolean recursante) {
        this.recursante = recursante;
    }

    public int getPorcAsistencia() {
        return porcAsistencia;
    }

    public void setPorcAsistencia(int porcAsistencia) {
        this.porcAsistencia = porcAsistencia;
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

    public List<Asistencia> getListaDeAsistencias() {
        return listaDeAsistencias;
    }

    // agregamos la asistencia a la lista
    public void agregarAsistencia(Asistencia asistencia) {
        listaDeAsistencias.add(asistencia);
    }

    // calculamos el porcentaje de asistencia 
    public int calcularPorcentajeAsistencia() {

        // si nohay asistencias retorna 0
        if (listaDeAsistencias.isEmpty()) {
            return 0;

        }
        int presentes = 0;
// si tenemos asistencias, las recorremos y calculamos el porcentaje
        for (Asistencia asistencia : listaDeAsistencias) {
            if (asistencia.isPresente()) {
                presentes++;
            }
        }
        return (presentes * 100) / listaDeAsistencias.size();

    }
    // actualizamos el porcentaje de asistencia 

    public void actualizarPorcentajeDeAsistencia() {
        this.porcAsistencia = calcularPorcentajeAsistencia();
    }

    @Override
    public String toString() {
        return "Cursada{ "
                + "idCursada=" + idCursada
                + ", anio=" + anio
                + ", cuatrimestre=" + cuatrimestre
                + ", condicion=" + condicion
                + ", notaFinal=" + notaFinal
                + ", recursante=" + recursante
                + ", porcAsistencia=" + porcAsistencia
                + ", alumno=" + alumno
                + ", materia=" + materia
                + ", listaDeAsistencias=" + listaDeAsistencias
                + '}';
    }

}
