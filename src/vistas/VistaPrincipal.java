package vistas;

public class VistaPrincipal extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VistaPrincipal.class.getName());

    /*
        Flujo:
        Abrir Alumnos por primera vez
        Se crea una instancia, se agrega al escritorio y se muestra.
        ↓
        Abrir Materias
        Se crea otra ventana. Alumnos sigue abierta en el escritorio.
        ↓
        Volver a pulsar Alumnos
        Se reutiliza la instancia existente y se la lleva al frente; no se crea otra.
        ↓
        Alumnos estaba minimizada
        Se restaura y se intenta seleccionarla.
    
    */
  
    
    
    private <T extends javax.swing.JInternalFrame> void abrirVentana(Class<T> tipoVentana, java.util.function.Supplier<T> creador) {

        // Buscar si ya existe una ventana de este tipo.
        for (javax.swing.JInternalFrame ventana : jDesktopPane1.getAllFrames()) {

            if (tipoVentana.isInstance(ventana)) {

                try {
                    // Si estaba minimizada, restaurar.
                    if (ventana.isIcon()) {
                        ventana.setIcon(false);
                    }

                    // Llevarla al frente y seleccionarla.
                    jDesktopPane1.moveToFront(ventana);
                    ventana.setSelected(true);

                } catch (java.beans.PropertyVetoException e) {
                    System.out.println("No se pudo seleccionar la ventana: "
                            + e.getMessage());
                }

                return;
            }
        }

        // Si no existe una instancia, crear una nueva.
        T ventana = creador.get();

        jDesktopPane1.add(ventana);
        ventana.setVisible(true);
        jDesktopPane1.moveToFront(ventana);

        try {
            ventana.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            System.out.println("No se pudo seleccionar la ventana: "
                    + e.getMessage());
        }
    }

    
    public VistaPrincipal() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        mnbMenu = new javax.swing.JMenuBar();
        mnuAdministracion = new javax.swing.JMenu();
        mniAlumnos = new javax.swing.JMenuItem();
        mniMaterias = new javax.swing.JMenuItem();
        mnuConsultas = new javax.swing.JMenu();
        mniMateriasAlumno = new javax.swing.JMenuItem();
        mnuAlumnosMateria = new javax.swing.JMenuItem();
        mnuDocentes = new javax.swing.JMenu();
        mniRegistrarCalificacion = new javax.swing.JMenuItem();
        mnuAlumnos = new javax.swing.JMenu();
        mniInscripcion = new javax.swing.JMenuItem();
        mniAsistencia = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA DE GESTIÓN SGULP");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 803, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );

        mnuAdministracion.setText("ADMINISTRACIÓN");

        mniAlumnos.setText("Alumnos");
        mniAlumnos.addActionListener(this::mniAlumnosActionPerformed);
        mnuAdministracion.add(mniAlumnos);

        mniMaterias.setText("Materias");
        mniMaterias.addActionListener(this::mniMateriasActionPerformed);
        mnuAdministracion.add(mniMaterias);

        mnuConsultas.setText("Consultas (¿?)");

        mniMateriasAlumno.setText("Materias de un alumno");
        mnuConsultas.add(mniMateriasAlumno);

        mnuAlumnosMateria.setText("Alumnos de una materia");
        mnuConsultas.add(mnuAlumnosMateria);

        mnuAdministracion.add(mnuConsultas);

        mnbMenu.add(mnuAdministracion);

        mnuDocentes.setText("DOCENTES");

        mniRegistrarCalificacion.setText("Registrar calificación");
        mniRegistrarCalificacion.addActionListener(this::mniRegistrarCalificacionActionPerformed);
        mnuDocentes.add(mniRegistrarCalificacion);

        mnbMenu.add(mnuDocentes);

        mnuAlumnos.setText("ALUMNOS");

        mniInscripcion.setText("Inscripción");
        mniInscripcion.addActionListener(this::mniInscripcionActionPerformed);
        mnuAlumnos.add(mniInscripcion);

        mniAsistencia.setText("Asistencia");
        mniAsistencia.addActionListener(this::mniAsistenciaActionPerformed);
        mnuAlumnos.add(mniAsistencia);

        mnbMenu.add(mnuAlumnos);

        setJMenuBar(mnbMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniMateriasActionPerformed
        abrirVentana(VistaMaterias.class, VistaMaterias::new);
    }//GEN-LAST:event_mniMateriasActionPerformed

    private void mniAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAsistenciaActionPerformed
       abrirVentana(VistaAsistencia.class, VistaAsistencia::new);
    }//GEN-LAST:event_mniAsistenciaActionPerformed

    private void mniRegistrarCalificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniRegistrarCalificacionActionPerformed

    }//GEN-LAST:event_mniRegistrarCalificacionActionPerformed

    private void mniAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAlumnosActionPerformed

        abrirVentana(VistaAlumnos.class, VistaAlumnos::new);

    }//GEN-LAST:event_mniAlumnosActionPerformed

    private void mniInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniInscripcionActionPerformed
        
         abrirVentana(VistaInscripcion.class, VistaInscripcion::new);
    }//GEN-LAST:event_mniInscripcionActionPerformed

    public static void main(String args[]) {

        // Esta línea no comprueba si la conexión con MariaDB se estableció correctamente o no,  
        // por lo que la ventana principal se puede abrir aunque la base de datos esté apagada.
        // java.awt.EventQueue.invokeLater(() -> new VistaPrincipal().setVisible(true));
        
        java.awt.EventQueue.invokeLater(() -> {

            persistencia.Conexion conexion = persistencia.Conexion.getInstancia();

            if (!conexion.isConectado()) {
                javax.swing.JOptionPane.showMessageDialog(
                        null,
                        "No se pudo conectar con la base de datos SGULP.\n"
                        + "Verificá que MariaDB esté iniciado y reiniciá la aplicación.",
                        "Error de conexión",
                        javax.swing.JOptionPane.ERROR_MESSAGE
                );

                System.exit(0);
            }

            new VistaPrincipal().setVisible(true);
        });
        
    }
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuBar mnbMenu;
    private javax.swing.JMenuItem mniAlumnos;
    private javax.swing.JMenuItem mniAsistencia;
    private javax.swing.JMenuItem mniInscripcion;
    private javax.swing.JMenuItem mniMaterias;
    private javax.swing.JMenuItem mniMateriasAlumno;
    private javax.swing.JMenuItem mniRegistrarCalificacion;
    private javax.swing.JMenu mnuAdministracion;
    private javax.swing.JMenu mnuAlumnos;
    private javax.swing.JMenuItem mnuAlumnosMateria;
    private javax.swing.JMenu mnuConsultas;
    private javax.swing.JMenu mnuDocentes;
    // End of variables declaration//GEN-END:variables
}
