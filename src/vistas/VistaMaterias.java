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
        jrActiva = new javax.swing.JRadioButton();
        jrInactiva = new javax.swing.JRadioButton();
        jbGuardar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbNuevo = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtBuscarPorId = new javax.swing.JTextField();
        jBtnBuscar = new javax.swing.JButton();
        jAltaLogica = new javax.swing.JButton();
        jBajaLogica = new javax.swing.JButton();

        setClosable(true);

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

        jLabel3.setText("ID");

        jLabel4.setText("Nombre");

        jLabel5.setText("Estado");

        jbgEstado.add(jrActiva);
        jrActiva.setText("Activa");

        jbgEstado.add(jrInactiva);
        jrInactiva.setText("Inactiva");

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
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addGroup(jPanelMateriaLayout.createSequentialGroup()
                        .addGroup(jPanelMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrInactiva)
                            .addComponent(jrActiva))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextFieldID))
                .addContainerGap())
        );
        jPanelMateriaLayout.setVerticalGroup(
            jPanelMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMateriaLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanelMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanelMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jrActiva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrInactiva)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(this::jbGuardarActionPerformed);

        jbActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar.png"))); // NOI18N
        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(this::jbActualizarActionPerformed);

        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(this::jbEliminarActionPerformed);

        jbNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(this::jbNuevoActionPerformed);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtBuscarPorId, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBajaLogica, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jAltaLogica, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanelMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtBuscarPorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAltaLogica, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBajaLogica, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //LIMPIAR CAMPOS DEL FORMULARIO/TABLA/BOTONES 
    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        vaciarCampos(jPanelMateria);
        modoNuevo();
        jTablaMaterias.clearSelection();

    }//GEN-LAST:event_jbNuevoActionPerformed

    //GUARDAR NUEVA MATERIA EN LA BD
    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        if (validarCamposVacios(jPanelMateria)) {
            JOptionPane.showMessageDialog(this, "Campos incompletos.");
        } else {
            String nombre = jTextFieldNombre.getText();
            Materia m = new Materia(nombre, jrActiva.isSelected());
            if (materiaData.guardarMateria(m)) {
                JOptionPane.showMessageDialog(this, "Materia guardada correctamente.");
                cargarMaterias();
                vaciarCampos(jPanelMateria);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo guardar la materia.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jbGuardarActionPerformed

    //SELECCIÓN DE PRODUCTO EN TABLA + AUTO-COMPLETE DE FORMULARIO
    private void jTablaMateriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaMateriasMouseClicked
        int fila = jTablaMaterias.getSelectedRow();
        if (fila != -1) {
            jTextFieldID.setText(jTablaMaterias.getValueAt(fila, 0).toString());
            jTextFieldNombre.setText(jTablaMaterias.getValueAt(fila, 1).toString());
            boolean activa = jTablaMaterias.getValueAt(fila, 2).toString().equals("Activa");
            jrActiva.setSelected(activa);
            jrInactiva.setSelected(!activa);

            modoSeleccion(activa);
        }
    }//GEN-LAST:event_jTablaMateriasMouseClicked

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        try {
            int idMateria = Integer.parseInt(jTextFieldID.getText());
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que quiéres eliminar la materia?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                if (materiaData.borrarMateria(idMateria)) {
                    JOptionPane.showMessageDialog(this, "Se ha eliminado la materia correctamente.");
                    vaciarCampos(jPanelMateria);
                    cargarMaterias();
                    modoNuevo();
                    jTablaMaterias.clearSelection();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar la materia.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una materia para eliminarla.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        if (validarCamposVacios(jPanelMateria)) {
            JOptionPane.showMessageDialog(this, "Campos incompletos.");
        } else {
            int idMateria = Integer.parseInt(jTextFieldID.getText());
            String nombre = jTextFieldNombre.getText();
            Materia m = new Materia(idMateria, nombre, jrActiva.isSelected());

            if (materiaData.actualizarMateria(m)) {
                JOptionPane.showMessageDialog(this, "Se ha actualizado la materia correctamente.");
                vaciarCampos(jPanelMateria);
                cargarMaterias();
                modoNuevo();
                jTablaMaterias.clearSelection();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar la materia.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed

        try {
            String idIngresado = jtBuscarPorId.getText().trim();

            if (idIngresado.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe completar el campo ID.");
            } else {

                int idMateria = Integer.parseInt(idIngresado);
                Materia m = materiaData.buscarMateria((idMateria));
                if (m == null) {
                    JOptionPane.showMessageDialog(this, "Materia no encontrada");
                } else {
                    int id = m.getIdMateria();
                    String nombre = m.getNombre();
                    boolean estado = m.isEstado();

                    jTextFieldID.setText(String.valueOf(id));
                    jTextFieldNombre.setText(nombre);
                    jrActiva.setSelected(estado);
                    jrInactiva.setSelected(!estado);
                    modoSeleccion(estado);
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
            return;
        } else {
            int id = Integer.parseInt(idMateria);
            int respuesta = JOptionPane.showConfirmDialog(this, "Seguro quieres dar de alta esta materia?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {

                if (materiaData.altaEstado(id)) {
                    JOptionPane.showMessageDialog(this, "Se ha dado de alta la materia.");
                    vaciarCampos(jPanelMateria);
                    cargarMaterias();
                    modoNuevo();
                    jTablaMaterias.clearSelection();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo dar de alta la materia.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jAltaLogicaActionPerformed

    private void jBajaLogicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBajaLogicaActionPerformed
        String idMateria = jTextFieldID.getText().trim();

        if (idMateria.isEmpty()) {
            return;
        } else {
            int id = Integer.parseInt(idMateria);
            int respuesta = JOptionPane.showConfirmDialog(this, "Seguro quieres dar de baja esta materia?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                if (materiaData.bajaEstado(id)) {
                    JOptionPane.showMessageDialog(this, "Se ha dado de baja la materia.");
                    vaciarCampos(jPanelMateria);
                    cargarMaterias();
                    modoNuevo();
                    jTablaMaterias.clearSelection();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo dar de baja la materia.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jBajaLogicaActionPerformed


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
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.ButtonGroup jbgEstado;
    private javax.swing.JRadioButton jrActiva;
    private javax.swing.JRadioButton jrInactiva;
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

        if (jbgEstado.getSelection() == null) {
            return true;
        }

        return false;
    }

    public void vaciarCampos(JPanel jPanel) {

        for (Component c : jPanel.getComponents()) {
            if (c instanceof JTextField) {
                JTextField caja = (JTextField) c;
                caja.setText("");
            }
        }

        for (int i = 0; i < jPanel.getComponents().length; i++) {
            if (jPanel.getComponents()[i] instanceof JTextField) {
                JTextField caja = (JTextField) jPanel.getComponents()[i];
                caja.setText("");
            }

        }

        jbgEstado.clearSelection();
    }

// Formulario vacío: solo se puede guardar una materia nueva
    private void modoNuevo() {
        jbGuardar.setEnabled(true);
        jbActualizar.setEnabled(false);
        jbEliminar.setEnabled(false);
        jAltaLogica.setEnabled(false);
        jBajaLogica.setEnabled(false);
    }

// Materia seleccionada: Alta solo si está inactiva, Baja solo si está activa
    private void modoSeleccion(boolean activa) {
        jbGuardar.setEnabled(false);
        jbActualizar.setEnabled(true);
        jbEliminar.setEnabled(true);
        jAltaLogica.setEnabled(!activa);
        jBajaLogica.setEnabled(activa);
    }
}
