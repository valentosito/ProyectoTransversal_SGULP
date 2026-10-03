
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;


public class Alumno {
    
    private int idAlumno;
    private String dni;
    private String nombre;
    private String apellido;
    private LocalDate fecNac;
    private boolean estado;  // activo - inactivo
    
    // Relación desde Alumno a Cursada: 1:N
    // Consulta en BD: desde un alumno, saber qué materias/cursadas tiene.
    private ArrayList<Cursada> listaDeCursadas;  // Alumno → Cursada → Materia
    
    
    // Constructor para Alta de un alumno: sin idAlumno porque lo genera automáticamente la BD.
    // AlumnoData será quien posteriormente haga el INSERT y la BD generará el idAlumno.
    public Alumno(String dni, String nombre, String apellido, LocalDate fecNac, boolean estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecNac = fecNac;
        this.estado = estado;
        this.listaDeCursadas = new ArrayList<>();
    }
    
    
    // Constructor vacío para uso de SELECT también.
      public Alumno() {
          
        listaDeCursadas = new ArrayList<>();
    }
    
    
    // En cambio, cuando AlumnoData haga un SELECT, necesitará construir un objeto Alumno incluyendo el id.
    // Java necesita convertir el registro de la BD en un objeto.
    public Alumno(int idAlumno, String dni, String nombre, String apellido, LocalDate fecNac, boolean estado) {
        this.idAlumno = idAlumno;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecNac = fecNac;
        this.estado = estado;
        this.listaDeCursadas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "DNI: " +dni+ ", " +nombre+ " " +apellido+ ", Estado: " +estado+ "\n";
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFecNac() {
        return fecNac;
    }

    public void setFecNac(LocalDate fecNac) {
        this.fecNac = fecNac;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
       
    
    public void agregarCursada(Cursada cursada) {
        
        listaDeCursadas.add(cursada);
    }
    
    
    
}
