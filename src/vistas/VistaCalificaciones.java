package vistas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cursada;
import modelo.Materia;
import persistencia.CursadaData;
import persistencia.MateriaData;

public class VistaCalificaciones extends javax.swing.JInternalFrame {

    private MateriaData materiaData = new MateriaData();
    private CursadaData cursadaData = new CursadaData();

    private ArrayList<Materia> materiasCargadas = new ArrayList<>();

    // Lista que conserva la correspondencia entre cada fila y su cursada, para guardar la nota en el registro correspondiente.
    private ArrayList<Cursada> cursadasTabla = new ArrayList<>();

    private DefaultTableModel modeloTabla;

    public VistaCalificaciones() {
        initComponents();

        setFrameIcon(new javax.swing.ImageIcon(
                getClass().getResource("/imagenes/logoULP.png")
        ));

        configurarTabla();
        cargarMaterias();
        configurarCuatrimestres();
        configurarEventos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        cmbCuatrimestre = new javax.swing.JComboBox<>();
        cmbMaterias = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlumnos = new javax.swing.JTable();
        btnLimpiar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setResizable(true);
        setTitle("SECCIÓN DOCENTES");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sombrero.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Gestión de calificaciones");

        jLabel3.setText("Seleccionar cursada");

        cmbMaterias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar materia" }));
        cmbMaterias.setToolTipText("");

        jLabel4.setText("Cuatrimestre");

        jLabel5.setText("Año");

        txtAnio.addActionListener(this::txtAnioActionPerformed);

        jLabel6.setText("Alumnos inscriptos");

        tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Alumno", "Nota Final"
            }
        ));
        jScrollPane1.setViewportView(tblAlumnos);

        btnLimpiar.setText("Limpiar");

        btnGuardar.setText("Guardar notas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbCuatrimestre, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbMaterias, javax.swing.GroupLayout.Alignment.LEADING, 0, 153, Short.MAX_VALUE))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpiar)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbCuatrimestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnioActionPerformed

        cargarSiCorresponde();
    }//GEN-LAST:event_txtAnioActionPerformed

    private void configurarTabla() {

        modeloTabla = new DefaultTableModel(
                new Object[]{"ID Alumno", "Alumno", "Nota final"}, 0) {

            @Override
            public boolean isCellEditable(int fila, int columna) {

                return columna == 2;
            }
        };

        tblAlumnos.setModel(modeloTabla);
    }

    private void cargarMaterias() {

        cmbMaterias.removeAllItems();
        cmbMaterias.addItem("Seleccionar materia");

        materiasCargadas = materiaData.listarMaterias();

        for (Materia materia : materiasCargadas) {

            cmbMaterias.addItem(materia.getNombre());
        }
    }

    private void configurarCuatrimestres() {

        cmbCuatrimestre.removeAllItems();
        cmbCuatrimestre.addItem("Seleccionar cuatrimestre");
        cmbCuatrimestre.addItem("1");
        cmbCuatrimestre.addItem("2");
    }

    // Conectar eventos:
    private void configurarEventos() {

        cmbMaterias.addActionListener(e -> cargarSiCorresponde());

        cmbCuatrimestre.addActionListener(e -> cargarSiCorresponde());

        btnGuardar.addActionListener(e -> guardarNotas());

        btnLimpiar.addActionListener(e -> limpiarFormulario());
    }

    // Validación:
    private void cargarSiCorresponde() {

        if (cmbMaterias.getSelectedIndex() > 0 && cmbCuatrimestre.getSelectedIndex() > 0 && !txtAnio.getText().trim().isEmpty()) {

            cargarAlumnos();

        } else {
            modeloTabla.setRowCount(0);
            cursadasTabla.clear();
        }
    }

    private void cargarAlumnos() {

        try {
            int anio = Integer.parseInt(txtAnio.getText().trim());

            if (anio <= 0) {
                return;
            }

            int indiceMateria = cmbMaterias.getSelectedIndex() - 1;

            if (indiceMateria < 0 || indiceMateria >= materiasCargadas.size()) {
                return;
            }

            Materia materia = materiasCargadas.get(indiceMateria);
            int cuatrimestre = cmbCuatrimestre.getSelectedIndex();

            modeloTabla.setRowCount(0);
            cursadasTabla.clear();

            cursadasTabla = cursadaData.listarCursadasPorMateriaYPeriodo(
                    materia.getIdMateria(), anio, cuatrimestre);

            for (Cursada cursada : cursadasTabla) {

                String nombreCompleto = cursada.getAlumno().getApellido() + ", " + cursada.getAlumno().getNombre();

                Object nota = cursada.getNotaFinal();

                modeloTabla.addRow(new Object[]{
                    cursada.getAlumno().getIdAlumno(),
                    nombreCompleto,
                    nota
                });
            }

        } catch (NumberFormatException e) {
            // El año todavía puede estar incompleto mientras se escribe.
        }
    }

    private void guardarNotas() {

        if (tblAlumnos.isEditing() && !tblAlumnos.getCellEditor().stopCellEditing()) {
            return;
        }

        if (cursadasTabla.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "No hay alumnos cargados para guardar.");
            return;
        }

        ArrayList<Double> notas = new ArrayList<>();

        // Primero, validar las notas:
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {

            Object valor = modeloTabla.getValueAt(i, 2);

            if (valor == null || valor.toString().trim().isEmpty()) {
                notas.add(null);
                continue;
            }

            try {
                double nota = Double.parseDouble(valor.toString().trim().replace(',', '.'));

                if (!Double.isFinite(nota) || nota < 0 || nota > 10) {
                    throw new NumberFormatException();
                }

                notas.add(nota);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        this,
                        "La nota de la fila " + (i + 1)
                        + " debe ser un número entre 0 y 10.",
                        "Nota inválida",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        // Segundo, guardar solo las notas nuevas o modificadas:
        int guardadas = 0;

        for (int i = 0; i < notas.size(); i++) {

            Double nuevaNota = notas.get(i);

            // Una celda vacía no modifica la nota existente.
            if (nuevaNota == null) {

                continue;
            }

            Cursada cursada = cursadasTabla.get(i);
            Double notaAnterior = cursada.getNotaFinal();

            if (notaAnterior != null && Double.compare(notaAnterior, nuevaNota) == 0) {
                continue;
            }

            if (!cursadaData.actualizarNotaFinal(cursada.getIdCursada(), nuevaNota)) {

                JOptionPane.showMessageDialog(
                        this,
                        "No se pudo guardar la nota del alumno "
                        + cursada.getAlumno().getApellido() + ", "
                        + cursada.getAlumno().getNombre()
                        + ". Revisá la consola para ver el error.",
                        "Error al guardar",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            cursada.setNotaFinal(nuevaNota);
            guardadas++;
        }

        JOptionPane.showMessageDialog(
                this,
                guardadas == 0
                        ? "No hay notas nuevas o modificadas para guardar."
                        : "Se guardaron correctamente "
                        + guardadas + " calificación(es).");

        cargarAlumnos();
    }

    private void limpiarFormulario() {

        cmbMaterias.setSelectedIndex(0);
        cmbCuatrimestre.setSelectedIndex(0);
        txtAnio.setText("");

        modeloTabla.setRowCount(0);
        cursadasTabla.clear();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmbCuatrimestre;
    private javax.swing.JComboBox<String> cmbMaterias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblAlumnos;
    private javax.swing.JTextField txtAnio;
    // End of variables declaration//GEN-END:variables
}
