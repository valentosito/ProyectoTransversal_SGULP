
package modelo;

import java.util.List;


public class Cursada {
    
    
    // Referencias a objeto Alumno y Materia porque Cursada representa una inscripción concreta de un alumno a una materia: equivalen a las FK.
    // Cursada necesita saber de quién es y de qué materia es la inscripción.
    private Alumno alumno;
    private Materia materia;  
    
    private int porcAsistencia;
    
    // Una cursada puede tener muchos registros de asistencia, uno por cada clase/día:
    private List<Asistencia> listaDeAsistencias;
    
    
}
