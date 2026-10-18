package vistas;

import modelo.Asistencia;
import modelo.Cursada;
import persistencia.AsistenciaData;
import persistencia.CursadaData;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


  

    public class VistaAsistencia extends javax.swing.JInternalFrame {

        private final CursadaData cursadaData = new CursadaData();  // atributo de acceso a los datos
        private final AsistenciaData asistenciaData = new AsistenciaData();
        private List<Cursada> listaCursadas = new ArrayList<>();

        public VistaAsistencia() {
            initComponents();
            configurarTabla();
            cargarCursadas();
            
            setFrameIcon(new javax.swing.ImageIcon(
                    getClass().getResource("/imagenes/logoULP.png")
            ));
            
            setClosable(true);
            setIconifiable(true);
            setMaximizable(true);
            setResizable(true);
        }
    

        private void cargarCursadas() {
            // consultamos todas las cursadas, recorremos la lista y carga el combo con los datos

            listaCursadas = cursadaData.listarCursadas();
            cbCursada.removeAllItems();

            for (Cursada cursada : listaCursadas) {

                String texto = "ID: " + cursada.getIdCursada()
                        + " - " + cursada.getMateria().getNombre()
                        + " - " + cursada.getAlumno().getApellido();

             cbCursada.addItem(texto);
            }
        }

        private void configurarTabla() {   // configuramos la tabla 

            DefaultTableModel modeloTabla = new DefaultTableModel(
                    new Object[]{"Fecha", "Alumno", "Materia", "Asistencia"}, 0
            ) {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            tblAsistencias.setModel(modeloTabla);

        }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLRegistroAsistencia = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbCursada = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        dcFecha = new com.toedter.calendar.JDateChooser();
        chkPresente = new javax.swing.JCheckBox();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAsistencias = new javax.swing.JTable();

        jLRegistroAsistencia.setFont(new java.awt.Font("Segoe UI", 0, 21)); // NOI18N
        jLRegistroAsistencia.setText("Registro de Asistencias");

        jLabel2.setText("Cursada");

        jLabel3.setText("Fecha de Asistencia");

        chkPresente.setText("Presente");

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/escoba.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

        tblAsistencias.setBackground(new java.awt.Color(153, 153, 255));
        tblAsistencias.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        tblAsistencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha", "Alumno", "Materia", "Asistencia"
            }
        ));
        jScrollPane1.setViewportView(tblAsistencias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbCursada, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLRegistroAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkPresente))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLRegistroAsistencia)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(19, 19, 19)
                .addComponent(cbCursada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chkPresente)
                    .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        int indice = cbCursada.getSelectedIndex();

        if (indice == -1) {
            JOptionPane.showMessageDialog(
                    this, "Seleccioná una cursada."
            );
            return;
        }

        if (dcFecha.getDate() == null) {
            JOptionPane.showMessageDialog(
                    this, "Seleccioná la fecha de asistencia."
            );
            return;
        }

        Cursada cursada = listaCursadas.get(indice);

        Asistencia asistencia = new Asistencia(
                0,
                dcFecha.getDate(),
                chkPresente.isSelected(),
                cursada
        );

        asistenciaData.guardarAsistencia(asistencia);

        cargarAsistencias();
        JOptionPane.showMessageDialog(
                this, "Se ejecutó el registro de asistencia."
        );
    }

    private void cargarAsistencias() {

        int indice = cbCursada.getSelectedIndex();

        if (indice == -1) {
            return;
        }

        Cursada cursada = listaCursadas.get(indice);

        List<Asistencia> asistencias
                = asistenciaData.listarPorCursada(cursada);

        DefaultTableModel modelo
                = (DefaultTableModel) tblAsistencias.getModel();

        modelo.setRowCount(0);

        for (Asistencia asistencia : asistencias) {

            modelo.addRow(new Object[]{
                asistencia.getFecha(),
                "Alumno " + cursada.getAlumno().getIdAlumno(),
                "Materia " + cursada.getMateria().getIdMateria(),
                asistencia.isPresente() ? "Presente" : "Ausente"
            });
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        dcFecha.setDate(null);
        chkPresente.setSelected(false);
        cbCursada.setSelectedIndex(-1);

        DefaultTableModel modelo
                = (DefaultTableModel) tblAsistencias.getModel();

        modelo.setRowCount(0);

    }//GEN-LAST:event_btnLimpiarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbCursada;
    private javax.swing.JCheckBox chkPresente;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLRegistroAsistencia;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAsistencias;
    // End of variables declaration//GEN-END:variables
    }