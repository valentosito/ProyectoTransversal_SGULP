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
import modelo.Materia;
import persistencia.MateriaData;

public class VistaAsistencia extends javax.swing.JInternalFrame {

    private final MateriaData materiaData = new MateriaData(); // atributo de acceso a los datos
    private final CursadaData cursadaData = new CursadaData();
    private final AsistenciaData asistenciaData = new AsistenciaData();

    private List<Materia> listaMaterias = new ArrayList<>();
    private List<Cursada> listaCursadas = new ArrayList<>();

    public VistaAsistencia() {

        initComponents();

        configurarFecha();
        configurarTabla();
        cargarMaterias();

        cbAlumno.removeAllItems();

        setFrameIcon(new javax.swing.ImageIcon(
                getClass().getResource("/imagenes/logoULP.png")
        ));

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
    }

    // Obtiene el año académico actual.
    private int obtenerAnioActual() {
        return java.time.LocalDate.now().getYear();
    }

    // Método que obtiene el cuatrimestre académico actual.
    // Marzo a julio: primer cuatrimestre.
    // Agosto a diciembre: segundo cuatrimestre.
    private int obtenerCuatrimestreActual() {

        int mes = java.time.LocalDate.now().getMonthValue();

        if (mes >= 3 && mes <= 7) {
            return 1;
        }

        if (mes >= 8 && mes <= 12) {
            return 2;
        }

        return 0;
    }

    private void configurarFecha() {

        dcFecha.setDate(new java.util.Date());
        dcFecha.setEnabled(false);
    }

    // Método para el jcombobox de materias
    private void cargarMaterias() {

        listaMaterias = materiaData.listarMaterias();
        cbMateria.removeAllItems();

        for (Materia materia : listaMaterias) {
            if (materia.isEstado()) {
                cbMateria.addItem(materia.getNombre());
            }
        }

        cbMateria.setSelectedIndex(-1);
    }

    // Método para el jcombobox de alumnos: solo carga los alumnos inscriptos a la materia elegida vigente.
    private void cargarAlumnosPorMateria() {

        cbAlumno.removeAllItems();
        listaCursadas.clear();

        int indiceMateria = cbMateria.getSelectedIndex();

        if (indiceMateria == -1) {
            return;
        }

        Materia materiaSeleccionada = null;
        String nombreSeleccionado = cbMateria.getSelectedItem().toString();

        for (Materia materia : listaMaterias) {
            if (materia.isEstado()
                    && materia.getNombre().equals(nombreSeleccionado)) {
                materiaSeleccionada = materia;
                break;
            }
        }

        if (materiaSeleccionada == null) {
            return;
        }

        ArrayList<Cursada> cursadas = cursadaData.listarCursadasPorMateria(
                materiaSeleccionada.getIdMateria()
        );
        
        int anioActual = obtenerAnioActual();
        int cuatrimestreActual = obtenerCuatrimestreActual();
        
        for (Cursada cursada : cursadas) {
                      
            if (cuatrimestreActual == 0) {
                break;
            }
  
            if (cursada.getAnio() == anioActual
                    && cursada.getCuatrimestre() == cuatrimestreActual
                    && cursada.getAlumno() != null) {

                listaCursadas.add(cursada);

                cbAlumno.addItem(
                        cursada.getAlumno().getApellido() + ", "
                        + cursada.getAlumno().getNombre() + " - DNI: "
                        + cursada.getAlumno().getDni()
                );
            }
        }
        System.out.println("Alumnos cargados en el combo: "
                + cbAlumno.getItemCount());

        System.out.println("Índice seleccionado: "
                + cbAlumno.getSelectedIndex());
        //cbAlumno.setSelectedIndex(-1);
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
        cbMateria = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        dcFecha = new com.toedter.calendar.JDateChooser();
        chkPresente = new javax.swing.JCheckBox();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAsistencias = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        cbAlumno = new javax.swing.JComboBox<>();

        setTitle("SECCIÓN ALUMNOS");

        jLRegistroAsistencia.setFont(new java.awt.Font("Segoe UI", 0, 21)); // NOI18N
        jLRegistroAsistencia.setText("Registro de Asistencias");

        jLabel2.setText("Materia ");

        cbMateria.addActionListener(this::cbMateriaActionPerformed);

        jLabel3.setText("Fecha de Asistencia");

        chkPresente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        chkPresente.setText("Presente");

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/escoba.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registro.png"))); // NOI18N

        jLabel4.setText("Alumno");

        cbAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbAlumno.addActionListener(this::cbAlumnoActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLRegistroAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(chkPresente, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbMateria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLRegistroAsistencia)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(cbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addGap(22, 22, 22)
                .addComponent(cbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chkPresente)
                    .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
        // Método que obtiene la cursada que vincula a un alumno con una materia y usa la fecha actual automáticamente. 
        // También impide duplicados: (UNIQUE (idCursada, fecha).
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

            if (cbMateria.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "Seleccioná una materia.");
                cbMateria.requestFocus();
                return;
            }

            int indiceAlumno = cbAlumno.getSelectedIndex();

            if (indiceAlumno == -1) {
                JOptionPane.showMessageDialog(this, "Seleccioná un alumno.");
                cbAlumno.requestFocus();
                return;
            }

            if (indiceAlumno >= listaCursadas.size()) {
                JOptionPane.showMessageDialog(
                        this, "No se encontró la cursada seleccionada."
                );
                return;
            }

            Cursada cursada = listaCursadas.get(indiceAlumno);

            // Obtenemos la fecha actual, sin depender del calendario.
            java.util.Date fechaActual = new java.util.Date();

            Asistencia asistencia = new Asistencia(
                    0,
                    fechaActual,
                    chkPresente.isSelected(),
                    cursada
            );

            boolean guardada = asistenciaData.guardarAsistencia(asistencia);

            if (guardada) {
                JOptionPane.showMessageDialog(
                        this, "La asistencia se registró correctamente."
                );
                cargarAsistencias();
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "No se pudo registrar la asistencia. "
                        + "Verificá si ya existe un registro para hoy.",
                        "Error al guardar",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }

        private void cargarAsistencias() {

            int indice = cbMateria.getSelectedIndex();

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
        cbMateria.setSelectedIndex(-1);

        DefaultTableModel modelo
                = (DefaultTableModel) tblAsistencias.getModel();

        modelo.setRowCount(0);

    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void cbMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMateriaActionPerformed

        // se cargan los alumnos inscriptos
        cargarAlumnosPorMateria();
    }//GEN-LAST:event_cbMateriaActionPerformed

    private void cbAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAlumnoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbAlumno;
    private javax.swing.JComboBox<String> cbMateria;
    private javax.swing.JCheckBox chkPresente;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLRegistroAsistencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblAsistencias;
    // End of variables declaration//GEN-END:variables
}
