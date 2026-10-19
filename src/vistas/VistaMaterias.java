package vistas;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Materia;
import persistencia.MateriaData;
import java.sql.SQLException;

public class VistaMaterias extends javax.swing.JInternalFrame {

    private MateriaData materiaData = new MateriaData();

    DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    public VistaMaterias() {
        initComponents();
        armarCabecera();
        jTextFieldID.setEditable(false);
        modoNuevo();

        cargarMaterias();
        
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
        modelo.addColumn("Nombre");
        modelo.addColumn("Estado");

        jTablaMaterias.setModel(modelo);
    }

    private void cargarMaterias() {
        modelo.setRowCount(0);

        ArrayList<Materia> materias = materiaData.listarMaterias();

        for (Materia mat : materias) {
            modelo.addRow(new Object[]{
                mat.getIdMateria(),
                mat.getNombre(),
                mat.isEstado() ? "Activa" : "Inactiva"
            });
        }
    }

    
    private void mostrarEstado(boolean activa) {
        if (activa) {
            jlEstado.setText("Activa");
            jlEstado.setForeground(java.awt.Color.BLUE);
        } else {
            jlEstado.setText("Inactiva");
            jlEstado.setForeground(java.awt.Color.RED);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbgEstado = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaMaterias = new javax.swing.JTable();
        jPanelMateria = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jlEstado = new javax.swing.JLabel();
        jbBorrar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbNuevo = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtBuscarPorId = new javax.swing.JTextField();
        jBtnBuscar = new javax.swing.JButton();
        jAltaLogica = new javax.swing.JButton();
        jBajaLogica = new javax.swing.JButton();
        jbGuardar1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("GESTIÓN DE MATERIAS");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Materias");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/libros.png"))); // NOI18N

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
        jTablaMaterias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaMateriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablaMaterias);

        jPanelMateria.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("ID");

        jLabel4.setText("Nombre");

        jLabel5.setText("Estado:");

        jlEstado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanelMateriaLayout = new javax.swing.GroupLayout(jPanelMateria);
        jPanelMateria.setLayout(jPanelMateriaLayout);
        jPanelMateriaLayout.setHorizontalGroup(
            jPanelMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMateriaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanelMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(jTextFieldID)
                    .addGroup(jPanelMateriaLayout.createSequentialGroup()
                        .addComponent(jlEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelMateriaLayout.setVerticalGroup(
            jPanelMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMateriaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanelMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jlEstado))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jbBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        jbBorrar.setText("Borrar");
        jbBorrar.addActionListener(this::jbBorrarActionPerformed);

        jbActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar.png"))); // NOI18N
        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(this::jbActualizarActionPerformed);

        jbNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        jbNuevo.setText("Nueva");
        jbNuevo.addActionListener(this::jbNuevoActionPerformed);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel6.setText("Buscar por ID:");

        jtBuscarPorId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtBuscarPorIdKeyPressed(evt);
            }
        });

        jBtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        jBtnBuscar.setText("Buscar");
        jBtnBuscar.addActionListener(this::jBtnBuscarActionPerformed);

        jAltaLogica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/alta.png"))); // NOI18N
        jAltaLogica.setText("Alta");
        jAltaLogica.addActionListener(this::jAltaLogicaActionPerformed);

        jBajaLogica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/baja.png"))); // NOI18N
        jBajaLogica.setText("Baja");
        jBajaLogica.addActionListener(this::jBajaLogicaActionPerformed);

        jbGuardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        jbGuardar1.setText("Guardar");
        jbGuardar1.addActionListener(this::jbGuardar1ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBajaLogica, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jAltaLogica, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jPanelMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jbGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtBuscarPorId, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnBuscar)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtBuscarPorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelMateria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAltaLogica, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBajaLogica, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //LIMPIAR CAMPOS DEL FORMULARIO/TABLA/BOTONES 
    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        vaciarCampos(jPanelMateria);
        modoNuevo();
        jTablaMaterias.clearSelection();

    }//GEN-LAST:event_jbNuevoActionPerformed

 
    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
      
        String idMateria = jTextFieldID.getText().trim();

        if (idMateria.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione o busque una materia.");
            return;
        }

        int respuesta = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro de que desea borrar esta materia?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(idMateria);

            if (materiaData.borrarMateria(id)) {
                JOptionPane.showMessageDialog(this, "Materia borrada correctamente.");

                cargarMaterias();
                vaciarCampos(jPanelMateria);
                modoNuevo();
                jTablaMaterias.clearSelection();

            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "No se pudo borrar la materia.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_jbBorrarActionPerformed

    //SELECCIÓN DE MATERIA EN TABLA + AUTO-COMPLETE DE FORMULARIO
    private void jTablaMateriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaMateriasMouseClicked
        
        int fila = jTablaMaterias.getSelectedRow();

        if (fila != -1) {
            jTextFieldID.setText(jTablaMaterias.getValueAt(fila, 0).toString());
            jTextFieldNombre.setText(jTablaMaterias.getValueAt(fila, 1).toString());

            boolean activa = jTablaMaterias.getValueAt(fila, 2)
                    .toString().equals("Activa");

            mostrarEstado(activa);
            modoSeleccion(activa);
        }
    }//GEN-LAST:event_jTablaMateriasMouseClicked

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        if (validarCamposVacios(jPanelMateria)) {
            JOptionPane.showMessageDialog(this, "Campos incompletos.");
            return;
        }

        int idMateria = Integer.parseInt(jTextFieldID.getText());
        String nombre = jTextFieldNombre.getText().trim();

        Materia m = new Materia();
        m.setIdMateria(idMateria);
        m.setNombre(nombre);

        if (materiaData.actualizarMateria(m)) {
            JOptionPane.showMessageDialog(this,
                    "Se ha actualizado la materia correctamente.");

            cargarMaterias();
            vaciarCampos(jPanelMateria);
            modoNuevo();
            jTablaMaterias.clearSelection();
        } else {
            JOptionPane.showMessageDialog(this,
                    "No se pudo actualizar la materia.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed

        String idIngresado = jtBuscarPorId.getText().trim();

        if (idIngresado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe completar el campo ID.");
            return;
        }

        try {
            int idMateria = Integer.parseInt(idIngresado);
            Materia m = materiaData.buscarMateria(idMateria);

            if (m == null) {
                JOptionPane.showMessageDialog(this, "Materia no encontrada.");
                return;
            }

            // Cargar los datos en el formulario
            jTextFieldID.setText(String.valueOf(m.getIdMateria()));
            jTextFieldNombre.setText(m.getNombre());

            // Mostrar el estado con su color correspondiente
            boolean activa = m.isEstado();
            mostrarEstado(activa);

            // Habilitar los botones según el estado
            modoSeleccion(activa);

            // Buscar y seleccionar la fila correspondiente en la tabla
            for (int i = 0; i < modelo.getRowCount(); i++) {
                int idTabla = Integer.parseInt(
                        modelo.getValueAt(i, 0).toString()
                );

                if (idTabla == m.getIdMateria()) {

                    // Seleccionar la fila completa
                    jTablaMaterias.setRowSelectionInterval(i, i);

                    // Desplazar la tabla hasta la fila seleccionada
                    jTablaMaterias.scrollRectToVisible(
                            jTablaMaterias.getCellRect(i, 0, true)
                    );

                    break;
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número.");
        }
    }//GEN-LAST:event_jBtnBuscarActionPerformed

    
    private void jtBuscarPorIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBuscarPorIdKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jBtnBuscarActionPerformed(null);
        }
    }//GEN-LAST:event_jtBuscarPorIdKeyPressed

    private void jAltaLogicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAltaLogicaActionPerformed
        
        String idMateria = jTextFieldID.getText().trim();

        if (idMateria.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione o busque una materia.");
            return;
        }

        int respuesta = JOptionPane.showConfirmDialog(
                this,
                "¿Seguro que desea dar de alta esta materia?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(idMateria);

            if (materiaData.altaEstado(id)) {
                JOptionPane.showMessageDialog(this, "Se ha dado de alta la materia.");

                mostrarEstado(true);
                cargarMaterias();
                modoSeleccion(true);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo dar de alta la materia.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jAltaLogicaActionPerformed

    private void jBajaLogicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBajaLogicaActionPerformed
        String idMateria = jTextFieldID.getText().trim();

        if (idMateria.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione o busque una materia.");
            return;
        }

        int respuesta = JOptionPane.showConfirmDialog(
                this,
                "¿Seguro que desea dar de baja esta materia?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(idMateria);

            if (materiaData.bajaEstado(id)) {
                JOptionPane.showMessageDialog(this, "Se ha dado de baja la materia.");

                mostrarEstado(false);
                cargarMaterias();
                modoSeleccion(false);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo dar de baja la materia.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jBajaLogicaActionPerformed

    
    //GUARDAR NUEVA MATERIA EN LA BD. (ACTIVA POR DEFECTO).
    private void jbGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardar1ActionPerformed
    
        // Validar que los campos obligatorios estén completos
        if (validarCamposVacios(jPanelMateria)) {
            JOptionPane.showMessageDialog(this, "Campos incompletos.");
            return;
        }

        // Obtener los datos ingresados
        String nombre = jTextFieldNombre.getText().trim();

        // Crear la materia activa por defecto
        Materia materia = new Materia(nombre, true);

        // Guardar la materia en la base de datos
        if (materiaData.guardarMateria(materia)) {
            JOptionPane.showMessageDialog(
                    this,
                    "Se ha guardado la materia correctamente."
            );

            // Actualizar la tabla
            cargarMaterias();

            // Limpiar el formulario
            vaciarCampos(jPanelMateria);

            // Volver al modo de creación
            modoNuevo();

            // Quitar cualquier selección de la tabla
            jTablaMaterias.clearSelection();

        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "No se pudo guardar la materia.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        
    }//GEN-LAST:event_jbGuardar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAltaLogica;
    private javax.swing.JButton jBajaLogica;
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanelMateria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTablaMaterias;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbGuardar1;
    private javax.swing.JButton jbNuevo;
    private javax.swing.ButtonGroup jbgEstado;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JTextField jtBuscarPorId;
    // End of variables declaration//GEN-END:variables

    public boolean validarCamposVacios(JPanel jPanel) {

        for (Component c : jPanel.getComponents()) {
            if (c instanceof JTextField && c != jTextFieldID) {
                JTextField caja = (JTextField) c;

                if (caja.getText().trim().isEmpty()) {
                    return true;
                }
            }
        }

        return false;
    }
    
    
    public void vaciarCampos(JPanel jPanel) {

        for (Component c : jPanel.getComponents()) {
            if (c instanceof JTextField) {
                ((JTextField) c).setText("");
            }
        }

        jlEstado.setText("");
    }

// Formulario vacío: solo se puede guardar una materia nueva
    private void modoNuevo() {
        jbBorrar.setEnabled(false);
        jbActualizar.setEnabled(false);
        jAltaLogica.setEnabled(false);
        jBajaLogica.setEnabled(false);
    }

// Materia seleccionada: Alta solo si está inactiva, Baja solo si está activa
    private void modoSeleccion(boolean activa) {
        jbBorrar.setEnabled(true);
        jbActualizar.setEnabled(true);
        jAltaLogica.setEnabled(!activa);
        jBajaLogica.setEnabled(activa);
    }
}
