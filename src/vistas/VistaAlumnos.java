
package vistas;

import java.awt.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import persistencia.AlumnoData;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;



public class VistaAlumnos extends javax.swing.JInternalFrame {
    
    private AlumnoData alumnoData = new AlumnoData();
    
    public VistaAlumnos() {
        
        initComponents();
           
        setFrameIcon(new javax.swing.ImageIcon(
                getClass().getResource("/imagenes/logoULP.png")
        ));
        
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jtAlumnos.setDefaultEditor(Boolean.class, null);
        
        tfID.setEditable(false);
        jtAlumnos.setDefaultEditor(Boolean.class, null);
        jtAlumnos.setDefaultEditor(Object.class, null);
    }

    // Método para refrescar la información de la tabla cada vez que se realiza un cambio.
    private void cargarTablaAlumnos() {
        
        ArrayList<Alumno> lista = alumnoData.listarAlumnos();
        DefaultTableModel modelo = (DefaultTableModel) jtAlumnos.getModel();
        modelo.setRowCount(0);

        for (Alumno a : lista) {
            modelo.addRow(new Object[]{
                a.getIdAlumno(),
                a.getDni(),
                a.getNombre(),
                a.getApellido(),
                a.getFecNac(),
                a.isEstado()
            });
        }
    }
    
    private void limpiarFormulario() {
        tfID.setText("");
        tfDNI.setText("");
        tfNombre.setText("");
        tfApellido.setText("");
        tfFechaN.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        tfDNI = new javax.swing.JTextField();
        tfNombre = new javax.swing.JTextField();
        tfApellido = new javax.swing.JTextField();
        tfFechaN = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbAlta = new javax.swing.JButton();
        jbBaja = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jbListar = new javax.swing.JButton();
        jbNuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAlumnos = new javax.swing.JTable();

        setTitle("GESTIÓN DE ALUMNOS");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Alumnos");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/estudiante_32x32.png"))); // NOI18N

        jLabel3.setText("ID:");

        jLabel4.setText("Nombre:");

        jLabel5.setText("DNI:");

        jLabel6.setText("Apellido:");

        jLabel7.setText("Fecha de Nacimiento:");

        jbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(this::jbGuardarActionPerformed);

        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(this::jbEliminarActionPerformed);

        jbActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar.png"))); // NOI18N
        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(this::jbActualizarActionPerformed);

        jbAlta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/alta.png"))); // NOI18N
        jbAlta.setText("Alta");
        jbAlta.addActionListener(this::jbAltaActionPerformed);

        jbBaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/baja.png"))); // NOI18N
        jbBaja.setText("Baja");
        jbBaja.addActionListener(this::jbBajaActionPerformed);

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(this::jbBuscarActionPerformed);

        jbListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/listar.png"))); // NOI18N
        jbListar.setText("Listar");
        jbListar.addActionListener(this::jbListarActionPerformed);

        jbNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(this::jbNuevoActionPerformed);

        jtAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DNI", "Nombre", "Apellido", "Fecha de Nacimiento", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtAlumnos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tfID)
                                        .addComponent(tfDNI)
                                        .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfFechaN, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfFechaN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbGuardar)
                            .addComponent(jbBuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbEliminar)
                            .addComponent(jbActualizar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbListar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAlta))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbBaja)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAltaActionPerformed
        
        String idAlumno = tfID.getText().trim();

        if (idAlumno.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el ID del alumno.");
            return;
        }

        try {
            int id = Integer.parseInt(idAlumno);

            int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro quieres dar de alta a este alumno?", "Confirmar", JOptionPane.YES_NO_OPTION
            );

            if (respuesta == JOptionPane.YES_OPTION) {

                boolean resultado = alumnoData.altaEstado(id);

                if (resultado) {
                    JOptionPane.showMessageDialog(this, "El alta se realizó correctamente."
                    );
                    cargarTablaAlumnos();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo realizar el alta."
                    );
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número entero."
            );
        }
    }//GEN-LAST:event_jbAltaActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
       
        limpiarFormulario();
    }//GEN-LAST:event_jbNuevoActionPerformed

    
    private void jbBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBajaActionPerformed
        
        String idAlumno = tfID.getText().trim();

        if (idAlumno.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el ID del alumno.");
            return;
        }

        try {
            int id = Integer.parseInt(idAlumno);

            int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro quieres dar de baja a este alumno?", "Confirmar", JOptionPane.YES_NO_OPTION
            );

            if (respuesta == JOptionPane.YES_OPTION) {

                boolean resultado = alumnoData.bajaEstado(id);

                if (resultado) {
                    JOptionPane.showMessageDialog(this, "La baja se realizó correctamente."
                    );
                    cargarTablaAlumnos();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo realizar la baja."
                    );
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número entero."
            );
        }
    }//GEN-LAST:event_jbBajaActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        
        if (tfNombre.getText().trim().isEmpty()
                || tfApellido.getText().trim().isEmpty()
                || tfDNI.getText().trim().isEmpty()
                || tfFechaN.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.",
                    "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String nombre = tfNombre.getText().trim();
            String apellido = tfApellido.getText().trim();
            String dni = tfDNI.getText().trim();
            LocalDate fechaN = LocalDate.parse(tfFechaN.getText().trim());

            Alumno a = new Alumno(dni, nombre, apellido, fechaN, true);

            if (alumnoData.guardarAlumno(a)) {
                JOptionPane.showMessageDialog(this, "Alumno guardado correctamente.");
                cargarTablaAlumnos();
                limpiarFormulario();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo guardar el alumno.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (java.time.format.DateTimeParseException e) {
            JOptionPane.showMessageDialog(this,
                    "La fecha debe tener el formato AAAA-MM-DD.",
                    "Fecha inválida", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        
        String idAlumno = tfID.getText().trim();

        if (idAlumno.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el ID del alumno.");
            return;
        }

        try {
            int id = Integer.parseInt(idAlumno);

            int respuesta = JOptionPane.showConfirmDialog(
                    this,
                    "¿Seguro que quieres eliminar el alumno?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if (respuesta == JOptionPane.YES_OPTION) {
                boolean resultado = alumnoData.borrarAlumno(id);

                if (resultado) {
                    JOptionPane.showMessageDialog(this,
                            "Se ha eliminado el alumno correctamente.");
                    limpiarFormulario();
                    cargarTablaAlumnos();
                } else {
                    JOptionPane.showMessageDialog(this,
                            "No se pudo eliminar el alumno. Puede tener cursadas asociadas.");
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "El ID debe ser un número entero.");
        }
        
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
    
        String idIngresado = JOptionPane.showInputDialog(
                this, "Ingrese el ID del alumno: ");

        if (idIngresado == null) {
            return;
        }

        idIngresado = idIngresado.trim();

        // Validar que no esté vacío.
        if (idIngresado.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Debe ingresar un ID.");
            return;
        }

        try {
            int idAlumno = Integer.parseInt(idIngresado);

            Alumno a = alumnoData.buscarAlumno(idAlumno);

            if (a == null) {
                JOptionPane.showMessageDialog(this,
                        "No se encontró un alumno con ese ID.");
                return;
            }

            // Volcar los datos del alumno en el formulario.
            tfID.setText(String.valueOf(a.getIdAlumno()));
            tfDNI.setText(a.getDni());
            tfNombre.setText(a.getNombre());
            tfApellido.setText(a.getApellido());
            tfFechaN.setText(a.getFecNac().toString());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "El ID debe ser un número entero.");
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
       
        if (tfID.getText().trim().isEmpty()
                || tfNombre.getText().trim().isEmpty()
                || tfApellido.getText().trim().isEmpty()
                || tfDNI.getText().trim().isEmpty()
                || tfFechaN.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.",
                    "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int id = Integer.parseInt(tfID.getText().trim());
            String dni = tfDNI.getText().trim();
            String nombre = tfNombre.getText().trim();
            String apellido = tfApellido.getText().trim();
            LocalDate fechaN = LocalDate.parse(tfFechaN.getText().trim());

            Alumno a = new Alumno(id, dni, nombre, apellido, fechaN);

            if (alumnoData.actualizarAlumno(a)) {
                JOptionPane.showMessageDialog(this,
                        "El alumno se actualizó correctamente.");
                cargarTablaAlumnos();
            } else {
                JOptionPane.showMessageDialog(this,
                        "No se pudo actualizar el alumno.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "El ID debe ser un número entero.");
        } catch (java.time.format.DateTimeParseException e) {
            JOptionPane.showMessageDialog(this,
                    "La fecha debe tener el formato AAAA-MM-DD.",
                    "Fecha inválida", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbListarActionPerformed
   
        cargarTablaAlumnos();

        int cantidad = jtAlumnos.getRowCount();
        JOptionPane.showMessageDialog(this,
                "Se listaron " + cantidad + " alumnos.");
        
    }//GEN-LAST:event_jbListarActionPerformed

    private void jtAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAlumnosMouseClicked
   
        int fila = jtAlumnos.getSelectedRow();

        if (fila == -1) {
            return;
        }

        Object id = jtAlumnos.getValueAt(fila, 0);
        Object dni = jtAlumnos.getValueAt(fila, 1);
        Object nombre = jtAlumnos.getValueAt(fila, 2);
        Object apellido = jtAlumnos.getValueAt(fila, 3);
        Object fechaN = jtAlumnos.getValueAt(fila, 4);

        tfID.setText(id != null ? id.toString() : "");
        tfDNI.setText(dni != null ? dni.toString() : "");
        tfNombre.setText(nombre != null ? nombre.toString() : "");
        tfApellido.setText(apellido != null ? apellido.toString() : "");
        tfFechaN.setText(fechaN != null ? fechaN.toString() : "");
     
    }//GEN-LAST:event_jtAlumnosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbAlta;
    private javax.swing.JButton jbBaja;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbListar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JTable jtAlumnos;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfDNI;
    private javax.swing.JTextField tfFechaN;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
