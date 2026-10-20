package vistas;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.Cursada;
import persistencia.AlumnoData;
import persistencia.CursadaData;

public class VistaMateriasDeAlumno extends javax.swing.JInternalFrame {

    private AlumnoData alumnoData = new AlumnoData();
    private CursadaData cursadaData = new CursadaData();
    private ArrayList<Alumno> listaAlumnos = new ArrayList<>();

    DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    public VistaMateriasDeAlumno() {
        initComponents();
        armarCabecera();
        cargarAlumnos();

        setFrameIcon(new javax.swing.ImageIcon(
                getClass().getResource("/imagenes/logoULP.png")
        ));

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
    }

    public void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("Materia");
        modelo.addColumn("Año");
        modelo.addColumn("Cuatrimestre");
        modelo.addColumn("Nota final");
        jTablaMaterias.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbAlumnos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaMaterias = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();

        setTitle("GESTIÓN DE CONSULTAS");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Consultar materias por alumno/a");

        jLabel2.setText("Alumno/a");

        jcbAlumnos.addActionListener(this::jcbAlumnosActionPerformed);

        jTablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTablaMaterias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jcbAlumnos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAlumnosActionPerformed
        cargarMaterias();
    }//GEN-LAST:event_jcbAlumnosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTablaMaterias;
    private javax.swing.JComboBox<String> jcbAlumnos;
    // End of variables declaration//GEN-END:variables

    private void cargarAlumnos() {
        listaAlumnos.clear();
        jcbAlumnos.removeAllItems();
        for (Alumno al : alumnoData.listarAlumnos()) {
            listaAlumnos.add(al);
            jcbAlumnos.addItem(al.getDni() + " | " + al.getNombre() + " " + al.getApellido());
        }
    }

    private void cargarMaterias() {
        modelo.setRowCount(0);

        int indice = jcbAlumnos.getSelectedIndex();
        if (indice == -1) {
            return;
        }

        Alumno alumno = listaAlumnos.get(indice);

        for (Cursada c : cursadaData.listarCursadasPorAlumno(alumno.getIdAlumno())) {
            modelo.addRow(new Object[]{
                c.getMateria().getIdMateria(),
                c.getMateria().getNombre(),
                c.getAnio(),
                c.getCuatrimestre(),
                c.getNotaFinal() != null ? c.getNotaFinal() : "Sin nota"
            });
        }
    }

}
