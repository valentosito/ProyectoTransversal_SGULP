
package modelo;

import java.util.ArrayList;
import java.util.List;

public class Materia {

    private int idMateria;
    private String nombre;
    private boolean estado;

    // Relación desde Materia hacia Cursada: 1:N 
    private List<Cursada> listaDeCursadas;

    public Materia() {
        this.listaDeCursadas = new ArrayList<>();
    }

    public Materia(String nombre, boolean estado) {
        this.nombre = nombre;
        this.estado = estado;
        this.listaDeCursadas = new ArrayList<>();
    }

    public Materia(int idMateria, String nombre, boolean estado) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.estado = estado;
        this.listaDeCursadas = new ArrayList<>();
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<Cursada> getListaDeCursadas() {
        return listaDeCursadas;
    }

    public void setListaDeCursadas(ArrayList<Cursada> listaDeCursadas) {
        this.listaDeCursadas = listaDeCursadas;
    }

    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", nombre=" + nombre + '}';
    }
    
    

}
