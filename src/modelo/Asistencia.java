
package modelo;

import java.util.Date;


public class Asistencia {
    
    private int idAsistencia;
    private Date fecha;
    private boolean presente;
    // Una asistencia pertenece a una única cursada. Rerencia -> FK
    private Cursada cursada;

    public Asistencia(int idAsistencia, Date fecha, boolean presente, Cursada cursada) {
        this.idAsistencia = idAsistencia;
        this.fecha = fecha;
        this.presente = presente;
        this.cursada = cursada;
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    public Cursada getCursada() {
        return cursada;
    }

    public void setCursada(Cursada cursada) {
        this.cursada = cursada;
    }

    @Override
    public String toString() {
        return "Asistencia{" + "idAsistencia=" + idAsistencia + ", fecha=" + fecha + ", presente=" + presente + ", cursada=" + cursada + '}';
    }
    
    
}
