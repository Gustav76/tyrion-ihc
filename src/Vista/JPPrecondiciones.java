package Vista;

import Controlador.ControladorPrecondiciones;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Vector;
import javax.swing.DropMode;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class JPPrecondiciones extends javax.swing.JPanel {

    ControladorPrecondiciones control;

    /** Creates new form JPPrecondiciones */
    public JPPrecondiciones(ControladorPrecondiciones controlador) {
        this.control = controlador;
        initComponents();
        //setear datos para la tabla de datos necesarios para la construccion de las precondiciones
        this.setCU();
        this.setWorkflowAnterior();
        this.setCaseOutWorkflow();
        //setar datos para la tabla de precondiciones
        this.setNomCU();
        if (this.control.getPrecondicionesCU() != null) {
            this.setPrecondiciones(this.control.getPrecondicionesCU());
        } else {
            this.setPreObjRestObj();
        }
        this.tDatosPrecondiciones.setDragEnabled(true);
        this.tDatosPrecondiciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tPrecondiciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tPrecondiciones.setDropMode(DropMode.ON);

        //para utilizar el drag and drop en la tabla
        this.tPrecondiciones.setTransferHandler(new TransferHandler() {

            @Override
            public boolean canImport(TransferSupport support) {
                if (!support.isDrop()) {
                    return false;
                }
                if (!support.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean importData(TransferSupport support) {
                if (!canImport(support)) {
                    return false;
                }

                // locación
                JTable.DropLocation dl = (JTable.DropLocation) support.getDropLocation();
                int row = dl.getRow();
                int col = dl.getColumn();

                if (tPrecondiciones.getValueAt(row, 2) == null) {
                    tPrecondiciones.setValueAt(tDatosPrecondiciones.getValueAt(tDatosPrecondiciones.getSelectedRow(), tDatosPrecondiciones.getSelectedColumn()), row, 2);
                } else {
                    tPrecondiciones.setValueAt(tPrecondiciones.getValueAt(row, 2) + tDatosPrecondiciones.getValueAt(tDatosPrecondiciones.getSelectedRow(), tDatosPrecondiciones.getSelectedColumn()).toString(), row, 2);
                }
                return true;
            }
        });

        //para visualizar el contenido de una celda al pasar el mouse por ella
        this.tPrecondiciones.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                Point p = e.getPoint();
                int row = tPrecondiciones.rowAtPoint(p);
                int column = tPrecondiciones.columnAtPoint(p);
                    if((!"null".equals(String.valueOf(tPrecondiciones.getValueAt(row, column)))) && (!"[]".equals(String.valueOf(tPrecondiciones.getValueAt(row, column))))){
                        tPrecondiciones.setToolTipText(String.valueOf(tPrecondiciones.getValueAt(row, column)));  
                    }
                    else{
                        tPrecondiciones.setToolTipText("Pre-condición no definida");
                    }
            }
        });
    }

    //seteo del nombre de los casos de uso en la tabla
    /**
     * Seteo del nombre de los casos de uso en la tabla
     */
    public void setNomCU() {
        Vector nomCU = new Vector();
        nomCU = this.control.getNombreCasoUso();
        this.setFilasP(nomCU.size());
        for (int i = 0; i < nomCU.size(); i++) {
            this.tPrecondiciones.setValueAt(nomCU.get(i), i, 1);
            Integer intObj = new Integer(i + 1);   //agrega el numero a la fila
            this.tPrecondiciones.setValueAt(intObj, i, 0);
        }
    }

    //seteo del nombre de los casos de uso en los datos complementarios
    /**
     * Seteo del nombre de los casos de uso en los datos complementarios
     */
    public void setCU() {
        Vector nomCU = new Vector();
        nomCU = this.control.getNombreCasoUso();
        this.setFilasD(nomCU.size());
        for (int i = 0; i < nomCU.size(); i++) {
            this.tDatosPrecondiciones.setValueAt(nomCU.get(i), i, 1);
            Integer intObj = new Integer(i + 1);   //agrega el numero a la fila
            this.tDatosPrecondiciones.setValueAt(intObj, i, 0);

        }
    }

    //seteo de los workflows anteriores
    /**
     * Seteo de los workflows anteriores
     */
    public void setWorkflowAnterior() {
        Vector workflowAnterior = new Vector();
        workflowAnterior = this.control.getWorkflowAnteriores();
        for (int i = 0; i < workflowAnterior.size(); i++) {
            this.tDatosPrecondiciones.setValueAt(workflowAnterior.get(i), i, 2);
        }
    }

    //seteo de los case out
    /**
     * Seteo de los case out
     */
    public void setCaseOutWorkflow() {
        Vector caseOutMC = new Vector();
        caseOutMC = this.control.getCaseOutMC();
        for (int i = 0; i < caseOutMC.size(); i++) {
            this.tDatosPrecondiciones.setValueAt(caseOutMC.get(i), i, 3);
        }
    }

    //seteo de las precondiciones provenientes de la plantilla de objetivos del negocio
    /**
     * Seteo de las precondiciones provenientes de la plantilla de objetivos del negocio
     */
    public void setPreObjRestObj() {
        Vector restriccionesON = new Vector();
        Vector precondicionesON = new Vector();
        precondicionesON = this.control.getPrecondicionesON();
        restriccionesON = this.control.getRestriccionesON();
        for (int i = 0; i < precondicionesON.size(); i++) {
            if (restriccionesON.get(i) == null) {
                this.tPrecondiciones.setValueAt(precondicionesON.get(i), i, 2);
            } else {
                this.tPrecondiciones.setValueAt(precondicionesON.get(i) + ". " + restriccionesON.get(i), i, 2);
            }
        }
    }

    //seteo de las propiedades de la tabla de precondiciones
    /**
     * Seteo de las propiedades de la tabla de precondiciones
     * @param tam indica tamaño de la fila de la tabla utilizada.
     */
    public void setFilasP(int tam) {
        DefaultTableModel tabla = new MyTableModel(new Object[][]{{}},
                new String[]{
                    "Número", "Caso de Uso", "Precondiciones"
                });
        tabla.setRowCount(tam);
        tabla.setColumnCount(3);
        this.tPrecondiciones.setModel(tabla);
        this.tPrecondiciones.getColumnModel().getColumn(2).setCellRenderer(new TextAreaRenderer());
        this.tPrecondiciones.setShowGrid(true);
        this.tPrecondiciones.setGridColor(Color.black);
        TableColumn col = tPrecondiciones.getColumn("Número");
        col.setMaxWidth(50);

        tPrecondiciones.getColumn("Precondiciones").setCellRenderer(new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                setText(value.toString());
                Icon ico = new ImageIcon(getClass().getResource("/Fotos/lapiz.png"));
                //setBackground(Color.LIGHT_GRAY);
                setIcon(ico);

                return this;
            }
        });

    }

    /**
     *  método que verifica que todas las precondiciones existan
     *      @return booleano que señala si los pasos estan completos (true) o no (false)
     */
    public boolean checkPcompletos() {
        //String precondicion="";
        for (int i = 0; i < this.tPrecondiciones.getRowCount(); i++) {
            //precondicion=(String)this.tPrecondiciones.getValueAt(i, 2);
            if (this.tPrecondiciones.getValueAt(i, 2).toString().trim().isEmpty()) {
                return false;
            }

            //if (precondicion.compareTo("")==0)return false;
        }
        return true;
    }

    /**
     *
     */
    class MyTableModel extends DefaultTableModel {

        /**
         *
         * @param data
         * @param columnNames
         */
        public MyTableModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        /**
         *
         * @param row
         * @param col
         * @return
         */
        @Override
        public boolean isCellEditable(int row, int col) {
            if (col == 0 || col == 1) {
                return false;
            } else {
                return true;
            }
        }
    }

    /**
     *
     */
    class MyTableModel2 extends DefaultTableModel {

        /**
         *
         * @param data
         * @param columnNames
         */
        public MyTableModel2(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        /**
         *
         * @param row
         * @param col
         * @return
         */
        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }
    }

    //seteo de las propiedades de la tabla de los datos complementarios
    /**
     * Seteo de las propiedades de la tabla de los datos complementarios
     * @param tam contador de filas de la tabla utilizada
     */
    public void setFilasD(int tam) {
        DefaultTableModel tabla = new MyTableModel2(new Object[][]{},
                new String[]{
                    "Número", "Caso de Uso", "Workflow Anterior", "Case Out Workflow"
                });
        tabla.setRowCount(tam);
        tabla.setColumnCount(4);
        this.tDatosPrecondiciones.setModel(tabla);
        this.tDatosPrecondiciones.getColumnModel().getColumn(1).setCellRenderer(new TextAreaRenderer());
        this.tDatosPrecondiciones.getColumnModel().getColumn(2).setCellRenderer(new TextAreaRenderer());
        this.tDatosPrecondiciones.getColumnModel().getColumn(3).setCellRenderer(new TextAreaRenderer());
        this.tDatosPrecondiciones.setShowGrid(true);
        this.tDatosPrecondiciones.setGridColor(Color.black);
        TableColumn col = tDatosPrecondiciones.getColumn("Número");
        col.setMaxWidth(50);

    }

    //seteo de las precondiciones de una sesion anterior
    /**
     * Seteo de las precondiciones de una sesion anterior
     * @param precondiciones muestra las precondiciones del caso de uso
     */
    public void setPrecondiciones(Vector precondiciones) {
        for (int i = 0; i < precondiciones.size(); i++) {
            this.tPrecondiciones.setValueAt(precondiciones.get(i), i, 2);
            Integer intObj = new Integer(i + 1);   //agrega el numero a la fila
            this.tPrecondiciones.setValueAt(intObj, i, 0);
        }
    }

    //se obtienen las precondiciones modificadas
    /**
     * se obtienen las precondiciones modificadas
     * @return las precondiciones asociadas
     */
    public Vector getPrecondiciones() {
        Vector precondiciones = new Vector();
        for (int i = 0; i < this.tPrecondiciones.getRowCount(); i++) {
            precondiciones.add(this.tPrecondiciones.getValueAt(i, 2));

        }
        return precondiciones;
    }

    //verificacion de nulos en la tabla
    /**
     * Verificacion de nulos en la tabla
     * @return cantidad de nulos
     */
    public Vector nulos() {
        Vector v = new Vector();
        for (int i = 0; i < this.tPrecondiciones.getRowCount(); i++) {
            if (this.tPrecondiciones.getValueAt(i, 2) == null) {
                v.add(0, 1);
                v.add(1, i + 1);
                return v;
            }
        }
        v.add(0, 0);
        return v;
    }

    //verificacion de celdas seleccionadas
    /**
     * Verificacion de celdas seleccionadas
     * @return 1 si la celda es seleccionada, 0 si no.
     */
    public int select() {
        for (int i = 0; i < this.tPrecondiciones.getRowCount(); i++) {
            if (this.tPrecondiciones.isCellSelected(i, 2)) {
                return 1;
            }
        }
        return 0;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        labelInstrucciones = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        panelTablas = new javax.swing.JPanel();
        labelInformacion = new javax.swing.JLabel();
        scrollPaneDatos = new javax.swing.JScrollPane();
        tDatosPrecondiciones = new javax.swing.JTable();
        scrollPanePrecondiciones = new javax.swing.JScrollPane();
        tPrecondiciones = new javax.swing.JTable();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(proyectodetitulo.ProyectoDeTituloApp.class).getContext().getResourceMap(JPPrecondiciones.class);
        labelInstrucciones.setText(resourceMap.getString("labelInstrucciones.text")); // NOI18N
        labelInstrucciones.setName("labelInstrucciones"); // NOI18N

        labelTitulo.setFont(resourceMap.getFont("labelTitulo.font")); // NOI18N
        labelTitulo.setText(resourceMap.getString("labelTitulo.text")); // NOI18N
        labelTitulo.setName("labelTitulo"); // NOI18N

        panelTablas.setName("panelTablas"); // NOI18N
        panelTablas.setLayout(new java.awt.GridBagLayout());

        labelInformacion.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelInformacion.setIcon(resourceMap.getIcon("labelInformacion.icon")); // NOI18N
        labelInformacion.setText(resourceMap.getString("labelInformacion.text")); // NOI18N
        labelInformacion.setName("labelInformacion"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        panelTablas.add(labelInformacion, gridBagConstraints);

        scrollPaneDatos.setName("scrollPaneDatos"); // NOI18N

        tDatosPrecondiciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Caso de Uso", "Workflow Anterior", "Case Out Workflow"
            }
        ));
        tDatosPrecondiciones.setCellSelectionEnabled(true);
        tDatosPrecondiciones.setName("tDatosPrecondiciones"); // NOI18N
        scrollPaneDatos.setViewportView(tDatosPrecondiciones);
        tDatosPrecondiciones.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tDatosPrecondiciones.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tDatosPrecondiciones.columnModel.title0")); // NOI18N
        tDatosPrecondiciones.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("tDatosPrecondiciones.columnModel.title1")); // NOI18N
        tDatosPrecondiciones.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("tDatosPrecondiciones.columnModel.title2")); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelTablas.add(scrollPaneDatos, gridBagConstraints);

        scrollPanePrecondiciones.setName("scrollPanePrecondiciones"); // NOI18N

        tPrecondiciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Caso de Uso", "Precondiciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tPrecondiciones.setCellSelectionEnabled(true);
        tPrecondiciones.setName("tPrecondiciones"); // NOI18N
        scrollPanePrecondiciones.setViewportView(tPrecondiciones);
        tPrecondiciones.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tPrecondiciones.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tPrecondiciones.columnModel.title0")); // NOI18N
        tPrecondiciones.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("tPrecondiciones.columnModel.title1")); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panelTablas.add(scrollPanePrecondiciones, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTitulo)
                    .addComponent(panelTablas, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                    .addComponent(labelInstrucciones, 0, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addGap(18, 18, 18)
                .addComponent(labelInstrucciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelTablas, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void deshacer() {
        Vector precondicionesON = new Vector();
        precondicionesON = this.control.getPrecondicionesON();
        for (int i = 0; i < this.tPrecondiciones.getRowCount(); i++) {
            if (this.tPrecondiciones.isCellSelected(i, 2)) {
                this.tPrecondiciones.setValueAt(precondicionesON.get(i), i, 2);
            }
        }
    }

    public void alerta(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "¡Advertencia!", JOptionPane.WARNING_MESSAGE);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelInformacion;
    private javax.swing.JLabel labelInstrucciones;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelTablas;
    private javax.swing.JScrollPane scrollPaneDatos;
    private javax.swing.JScrollPane scrollPanePrecondiciones;
    private javax.swing.JTable tDatosPrecondiciones;
    private javax.swing.JTable tPrecondiciones;
    // End of variables declaration//GEN-END:variables
}
