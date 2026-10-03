
package vistas;

import modelo.Alumno;
import java.time.LocalDate;
import java.util.ArrayList;
import persistencia.AlumnoData;

public class TestAlumno {
    

    public static void main(String[] args) {

        
        // Línea de código para que aparezcan las tildes y la ñ.
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));
        
        // Conexión a la BD gracias al connection del constructor.
        AlumnoData alumnoData = new AlumnoData();

        Alumno alumno1 = new Alumno("30111222", "Hernán", "López", LocalDate.of(2000, 5, 15), true);
        Alumno alumno2 = new Alumno("31222333", "Brenda", "Martínez", LocalDate.of(2001, 8, 20), true);
        Alumno alumno3 = new Alumno("32333444", "Martín", "García", LocalDate.of(1999, 3, 10), true);

        // Guardar alumnos en la BD:
        alumnoData.guardarAlumno(alumno1);
        alumnoData.guardarAlumno(alumno2);
        alumnoData.guardarAlumno(alumno3);

        // Listar y mostrar todos los alumnos:
        ArrayList<Alumno> listaDeAlumnos = alumnoData.listarAlumnos();

        System.out.println("\n LISTADO DE ALUMNOS \n");

        for (Alumno alumno : listaDeAlumnos) {
            
            System.out.println(alumno);
        }

        // Buscar alumno:
        Alumno alumnoBuscado = alumnoData.buscarAlumno(1);
        System.out.println("\n ALUMNO BUSCADO \n");
        System.out.println(alumnoBuscado);

        // Modificar alumno:
        alumno1.setNombre("Hernán Modificado");
        alumnoData.actualizarAlumno(alumno1);

        // Baja lógica:
        alumnoData.bajaEstado(1);

        // Alta lógica:
        alumnoData.altaEstado(1);

        // Baja física:
        alumnoData.borrarAlumno(1);
   
    }
    
    
}
    
    
