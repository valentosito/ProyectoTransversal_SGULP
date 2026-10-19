
package vistas;

import modelo.Alumno;
import persistencia.AlumnoData;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cursada;
import modelo.Materia;
import persistencia.CursadaData;
import persistencia.MateriaData;

public class VistaInscripcion extends javax.swing.JInternalFrame {

    private final AlumnoData alumnoData = new AlumnoData();
    private final MateriaData materiaData = new MateriaData();
    private final CursadaData cursadaData = new CursadaData();

    private ArrayList<Alumno> listaAlumnos;
    private ArrayList<Materia> listaMaterias;

    public VistaInscripcion() {

  
        initComponents();
        configurarFormulario();
        cargarAlumnos();
        cargarMaterias();
        configurarCuatrimestres();

        cbAlumno.setSelectedIndex(-1);
        cbMateria.setSelectedIndex(-1);
        cbCuatrimestre.setSelectedIndex(-1);
        
        setFrameIcon(new javax.swing.ImageIcon(
                getClass().getResource("/imagenes/logoULP.png")
        ));

    }

    private void configurarFormulario() {

        setTitle("Inscripción");  
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        
        spAnio.setValue(java.time.Year.now().getValue());  // obtenemos el año actual, el spinner permite seleccionar o modificar un valor 
        
        cbCuatrimestre.removeAllItems();   // carga los cuatrimestres 
        cbCuatrimestre.addItem("1");
        cbCuatrimestre.addItem("2");

    }

    private void cargarAlumnos() {
        
    // Creamos una lista nueva solo con alumnos activos.
        listaAlumnos = new ArrayList<>();

        DefaultComboBoxModel<String> modelo
                = new DefaultComboBoxModel<>();

        // Recorremos todos los alumnos de la base de datos.
        for (Alumno alumno : alumnoData.listarAlumnos()) {

            if (alumno.isEstado()) {

                listaAlumnos.add(alumno);

                String nombreCompleto
                        = alumno.getApellido() + ", "
                        + alumno.getNombre();

                modelo.addElement(nombreCompleto);
            }
        }

        // Asignamos el modelo al combo.
        cbAlumno.setModel(modelo);
        cbAlumno.setSelectedIndex(-1);
    }

    private void cargarMaterias() {

        listaMaterias = new ArrayList<>();

        DefaultComboBoxModel<String> modelo
                = new DefaultComboBoxModel<>();

        // Recorremos las materias registradas en la base de datos.
        for (Materia materia : materiaData.listarMaterias()) {

            if (materia.isEstado()) {

                listaMaterias.add(materia);

                modelo.addElement(
                        materia.getIdMateria() + " - "
                        + materia.getNombre()
                );
            }
        }

        // Asignamos el modelo al combo.
        cbMateria.setModel(modelo);
        cbMateria.setSelectedIndex(-1);
    }

    private void configurarCuatrimestres() {

        cbCuatrimestre.removeAllItems();

        cbCuatrimestre.addItem("Primer cuatrimestre");
        cbCuatrimestre.addItem("Segundo cuatrimestre");
        
        cbCuatrimestre.setSelectedIndex(-1);
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo = new javax.swing.JLabel();
        lblAlumno = new javax.swing.JLabel();
        cbAlumno = new javax.swing.JComboBox<>();
        jlMateria = new javax.swing.JLabel();
        cbMateria = new javax.swing.JComboBox<>();
        jlAnio = new javax.swing.JLabel();
        spAnio = new javax.swing.JSpinner();
        jblCustrimestre = new javax.swing.JLabel();
        cbCuatrimestre = new javax.swing.JComboBox<>();
        chkRecursante = new javax.swing.JCheckBox();
        btnInscribir = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setTitle("SECCIÓN ALUMNOS");

        jlTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jlTitulo.setText("Inscripción");

        lblAlumno.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblAlumno.setText("Alumno ");

        cbAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbAlumno.addActionListener(this::cbAlumnoActionPerformed);

        jlMateria.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jlMateria.setText("Materia");

        cbMateria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jlAnio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jlAnio.setText("Año ");

        spAnio.setModel(new javax.swing.SpinnerNumberModel(2026, 0, 3000, 1));

        jblCustrimestre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jblCustrimestre.setText("Cuatrimestre");

        cbCuatrimestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));

        chkRecursante.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        chkRecursante.setText("Recursante ");
        chkRecursante.addActionListener(this::chkRecursanteActionPerformed);

        btnInscribir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png"))); // NOI18N
        btnInscribir.setText("Inscribir");
        btnInscribir.addActionListener(this::btnInscribirActionPerformed);

        jbLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/limpiar.png"))); // NOI18N
        jbLimpiar.setText("Limpiar");
        jbLimpiar.addActionListener(this::jbLimpiarActionPerformed);

        jButton1.setText("jButton1");

        btnEliminar.setText("Desinscribir");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inscripcion.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkRecursante, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbAlumno, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbMateria, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(spAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                    .addComponent(cbCuatrimestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlMateria)
                                            .addComponent(lblAlumno)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jlAnio)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jblCustrimestre))))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(41, 41, 41)
                                    .addComponent(jbLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1))
                        .addGap(102, 102, 102))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlTitulo)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(lblAlumno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jlMateria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlAnio)
                    .addComponent(jblCustrimestre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCuatrimestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(chkRecursante)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkRecursanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkRecursanteActionPerformed

    }//GEN-LAST:event_chkRecursanteActionPerformed

    private void btnInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscribirActionPerformed

        // 1. Validar que haya un alumno seleccionado.
        int indiceAlumno = cbAlumno.getSelectedIndex();

        if (indiceAlumno == -1) {
            JOptionPane.showMessageDialog(this, "Seleccioná un alumno.");
            cbAlumno.requestFocus();
            return;
        }

        // 2. Validar que haya una materia seleccionada.
        int indiceMateria = cbMateria.getSelectedIndex();

        if (indiceMateria == -1) {
            JOptionPane.showMessageDialog(this, "Seleccioná una materia.");
            cbMateria.requestFocus();
            return;
        }

        // 3. Validar que haya un cuatrimestre seleccionado.
        int indiceCuatrimestre = cbCuatrimestre.getSelectedIndex();

        if (indiceCuatrimestre == -1) {
            JOptionPane.showMessageDialog(
                    this, "Seleccioná un cuatrimestre.");
            cbCuatrimestre.requestFocus();
            return;
        }

        // 4. Recuperar los objetos seleccionados.
        Alumno alumno = listaAlumnos.get(indiceAlumno);
        Materia materia = listaMaterias.get(indiceMateria);

        // 5. Obtener los datos del formulario.
        int anio = (Integer) spAnio.getValue();
        int cuatrimestre = indiceCuatrimestre + 1;
        boolean recursante = chkRecursante.isSelected();

        // 6. Crear la cursada.
        Cursada cursada = new Cursada(
                0, // ID generado por la base de datos.
                anio,
                cuatrimestre,
                1, // Condición inicial.
                null, // Nota final todavía no registrada.
                recursante,
                0, // Porcentaje inicial de asistencia.
                alumno,
                materia
        );

        // 7. Guardar la cursada.
        boolean guardada = cursadaData.guardarCursada(cursada);

        // 8. Informar el resultado.
        if (guardada) {

            JOptionPane.showMessageDialog(
                    this,
                    "Se registró la inscripción correctamente."
            );

        } else if (cursadaData.getUltimoError() == 1062) {

            JOptionPane.showMessageDialog(
                    this,
                    "Este alumno ya está inscripto en esta materia "
                    + "durante el año y cuatrimestre seleccionados.",
                    "Inscripción duplicada",
                    JOptionPane.WARNING_MESSAGE
            );

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "No se pudo registrar la inscripción. "
                    + "Revisá los datos e intentá nuevamente.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_btnInscribirActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed

        cbAlumno.setSelectedIndex(-1);
        cbMateria.setSelectedIndex(-1);

        spAnio.setValue(java.time.Year.now().getValue());

        cbCuatrimestre.setSelectedIndex(-1);

        chkRecursante.setSelected(false);

    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        // 1. Validar que haya un alumno seleccionado.
        int indiceAlumno = cbAlumno.getSelectedIndex();

<<<<<<< HEAD
        if (fila == -1) {
            JOptionPane.showMessageDialog(this,
                "Seleccioná una inscripción para eliminar.");
            return;
        }

        int idCursada = (Integer) tblInscripciones.getValueAt(fila, 0);    // obtiene el idCursada
        int confirmacion = JOptionPane.showConfirmDialog(
            this,
            "¿Seguro de que querés eliminar esta inscripción?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION
=======
        if (indiceAlumno == -1) {
            JOptionPane.showMessageDialog(
                    this, "Seleccioná un alumno.");
            cbAlumno.requestFocus();
            return;
        }

        // 2. Validar que haya una materia seleccionada.
        int indiceMateria = cbMateria.getSelectedIndex();

        if (indiceMateria == -1) {
            JOptionPane.showMessageDialog(
                    this, "Seleccioná una materia.");
            cbMateria.requestFocus();
            return;
        }

        // 3. Validar que haya un cuatrimestre seleccionado.
        int indiceCuatrimestre = cbCuatrimestre.getSelectedIndex();

        if (indiceCuatrimestre == -1) {
            JOptionPane.showMessageDialog(
                    this, "Seleccioná un cuatrimestre.");
            cbCuatrimestre.requestFocus();
            return;
        }

        // 4. Recuperar los datos seleccionados.
        Alumno alumno = listaAlumnos.get(indiceAlumno);
        Materia materia = listaMaterias.get(indiceMateria);

        int anio = (Integer) spAnio.getValue();
        int cuatrimestre = indiceCuatrimestre + 1;

        // 5. Buscar la cursada correspondiente.
        Cursada cursada = cursadaData.buscarCursada(
                alumno.getIdAlumno(),
                materia.getIdMateria(),
                anio,
                cuatrimestre
        );

        if (cursada == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "No existe una inscripción con los datos seleccionados.",
                    "Inscripción no encontrada",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // 6. Confirmar la eliminación.
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Seguro que querés eliminar esta inscripción?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
>>>>>>> bf5e6b4bb07c859a1694cf50fb9ac6d7dd3aa19f
        );

        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        // 7. Eliminar la cursada.
        boolean eliminado = cursadaData.borrarCursada(
                cursada.getIdCursada()
        );

        // 8. Informar el resultado.
        if (eliminado) {

            JOptionPane.showMessageDialog(
                this,
                "La inscripción fue eliminada.",
                "Inscripción eliminada",
                JOptionPane.INFORMATION_MESSAGE
            );

        } else {

            JOptionPane.showMessageDialog(
<<<<<<< HEAD
                this,
                "No se pudo eliminar la inscripción.",
                "Error",
                JOptionPane.ERROR_MESSAGE
=======
                    this,
                    "No se pudo eliminar la inscripción. "
                    + "Verificá si ya tiene una nota final registrada.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
>>>>>>> bf5e6b4bb07c859a1694cf50fb9ac6d7dd3aa19f
            );
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cbAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAlumnoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInscribir;
    private javax.swing.JComboBox<String> cbAlumno;
    private javax.swing.JComboBox<String> cbCuatrimestre;
    private javax.swing.JComboBox<String> cbMateria;
    private javax.swing.JCheckBox chkRecursante;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JLabel jblCustrimestre;
    private javax.swing.JLabel jlAnio;
    private javax.swing.JLabel jlMateria;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel lblAlumno;
    private javax.swing.JSpinner spAnio;
    // End of variables declaration//GEN-END:variables
}
