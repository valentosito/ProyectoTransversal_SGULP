package vistas;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.Cursada;
import modelo.Materia;
import persistencia.CursadaData;
import persistencia.MateriaData;

public class VistaAlumnosDeMateria extends javax.swing.JInternalFrame {

    private MateriaData materiaData = new MateriaData();
    private CursadaData cursadaData = new CursadaData();
    private ArrayList<Materia> listaMaterias = new ArrayList<>();

    DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    public VistaAlumnosDeMateria() {
        initComponents();
        armarCabecera();
        cargarMaterias();

        setFrameIcon(new javax.swing.ImageIcon(
                getClass().getResource("/imagenes/logoULP.png")
        ));

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
    }

    private void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("DNI");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        modelo.addColumn("Año");
        modelo.addColumn("Cuatrimestre");
        modelo.addColumn("Nota final");
        jTablaAlumnos.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbMaterias = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaAlumnos = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();

        setMaximumSize(new java.awt.Dimension(2147483647, 80));
        setPreferredSize(new java.awt.Dimension(536, 573));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Consulta alumnos de una materia");

        jLabel2.setText("Materia");

        jcbMaterias.addActionListener(this::jcbMateriasActionPerformed);

        jTablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablaAlumnos.setPreferredSize(new java.awt.Dimension(548, 609));
        jScrollPane1.setViewportView(jTablaAlumnos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jcbMaterias, 0, 410, Short.MAX_VALUE))
                        .addComponent(jLabel1)
                        .addComponent(jSeparator1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMateriasActionPerformed
        cargarAlumnos();
    }//GEN-LAST:event_jcbMateriasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTablaAlumnos;
    private javax.swing.JComboBox<String> jcbMaterias;
    // End of variables declaration//GEN-END:variables

    private void cargarMaterias() {
        listaMaterias.clear();
        jcbMaterias.removeAllItems();
        for (Materia m : materiaData.listarMaterias()) {
            if (m.isEstado()) {
                listaMaterias.add(m);
                jcbMaterias.addItem(m.getIdMateria() + " - " + m.getNombre());
            }
        }
    }

    private void cargarAlumnos() {
        modelo.setRowCount(0);

        int indice = jcbMaterias.getSelectedIndex();
        if (indice == -1) {
            return;
        }

        Materia materia = listaMaterias.get(indice);

        for (Cursada c : cursadaData.listarCursadasPorMateria(materia.getIdMateria())) {
            Alumno a = c.getAlumno();
            modelo.addRow(new Object[]{
                a.getIdAlumno(),
                a.getDni(),
                a.getApellido(),
                a.getNombre(),
                c.getAnio(),
                c.getCuatrimestre(),
                c.getNotaFinal() != null ? c.getNotaFinal() : "Sin nota"
            });
        }
    }
}
