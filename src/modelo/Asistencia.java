
package modelo;


public class Asistencia {
    private int asistencia;
    private int fecha;
    private boolean asiste;
    
    
    
    
    // Una asistencia pertenece a una única cursada. Rerencia -> FK
    private Cursada cursada;
    
    
}
