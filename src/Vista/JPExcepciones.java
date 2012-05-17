package Vista;

import Controlador.ControladorExcepciones;
import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Vector;
import javax.swing.DropMode;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class JPExcepciones extends javax.swing.JPanel {

    ControladorExcepciones control;

    /** Creates new form JPExcepciones */
    public JPExcepciones(ControladorExcepciones controlador) {
        this.control = controlador;
        initComponents();
        //seteo tabla datos workflow
        this.setNomCUW();
        this.setDatosW();
        //seteo tabla datos ON
        this.setNomCUON();
        this.setObstaculos();
        this.setPrecondiciones();
        //seteo tabla excepciones
        this.setNomCUE();
        if (this.control.getExcepciones() != null) {
            this.setExcepciones(this.control.getExcepciones());
        }
        this.tableExcepciones.addKeyListener(null);
        this.tableObstaculos.setDragEnabled(true);
        this.tableObstaculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tableExcepciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tableExcepciones.setDropMode(DropMode.ON);

        //para utilizar el drag and drop en la tabla
        this.tableExcepciones.setTransferHandler(new TransferHandler() {

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

                JTable.DropLocation dl = (JTable.DropLocation) support.getDropLocation();
                int row = dl.getRow();
                int col = dl.getColumn();
                String data;
                try {
                    data = (String) support.getTransferable().getTransferData(DataFlavor.stringFlavor);
                } catch (UnsupportedFlavorException e) {
                    return false;
                } catch (IOException e) {
                    return false;
                }

                if (tableExcepciones.getValueAt(row, 2) == null) {
                    tableExcepciones.setValueAt(data, row, 2);
                } else {
                    tableExcepciones.setValueAt(data, row, 2);
                }
                return true;
            }
        });

    }

    /**
     * ADVERTENCIA: Constructor que nunca es utilizado
     **Asigna datos a las tablas tableWorkflow tDatosOn tableExcepciones
     * @param controlador de esta vista
     * @param excepciones Vector con excepciones guardadas en una sesión anterior
     */
    public JPExcepciones(ControladorExcepciones controlador, Vector excepciones) {
        this.control = controlador;
        initComponents();
        //tabla datos workflow
        this.setNomCUW();
        this.setDatosW();
        //tabla datos ON
        this.setNomCUON();
        this.setObstaculos();
        this.setPrecondiciones();
        //tabla excepciones
        this.setNomCUE();
        this.setExcepciones(excepciones);
        this.tableExcepciones.addKeyListener(null);
        this.tableObstaculos.setDragEnabled(true);
        this.tableObstaculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tableExcepciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tableExcepciones.setDropMode(DropMode.ON);

        //para utilizar el drag and drop en la tabla
        this.tableExcepciones.setTransferHandler(new TransferHandler() {

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
                JTable.DropLocation dl = (JTable.DropLocation) support.getDropLocation();
                int row = dl.getRow();
                int col = dl.getColumn();
                String data;
                try {
                    data = (String) support.getTransferable().getTransferData(DataFlavor.stringFlavor);
                } catch (UnsupportedFlavorException e) {
                    return false;
                } catch (IOException e) {
                    return false;
                }

                if (tableExcepciones.getValueAt(row, 2) == null) {
                    tableExcepciones.setValueAt(data, row, 2);
                } else {
                    tableExcepciones.setValueAt(data, row, 2);
                }
                return true;
            }
        });

    }

    //seteo de los nombres de los casos de uso en la tabla excepciones
    /**
     * Seteo de los nombres de los casos de uso en la tabla tableExcepciones
     */
    public void setNomCUE() {
        Vector nomCU = new Vector();
        nomCU = this.control.getNombreCasoUso();
        this.setFilasE(nomCU.size());
        for (int i = 0; i < nomCU.size(); i++) {
            this.tableExcepciones.setValueAt(nomCU.get(i), i, 1);
            Integer intObj = new Integer(i + 1);   //agrega el numero a la fila
            this.tableExcepciones.setValueAt(intObj, i, 0);
        }
    }

    //seteo del nombre de los casos de uso en la tabla de excepciones workflow
    /**
     * Seteo del nombre de los casos de uso en la tabla tableWorkflow
     */
    public void setNomCUW() {
        Vector nomCU = new Vector();
        nomCU = this.control.getNombreCasoUso();
        this.setFilasW(nomCU.size());
        for (int i = 0; i < nomCU.size(); i++) {
            this.tableWorkflow.setValueAt(nomCU.get(i), i, 1);
            Integer intObj = new Integer(i + 1);   //agrega el numero a la fila
            this.tableWorkflow.setValueAt(intObj, i, 0);

        }

    }

    //seteo de los datos complementarios de la tabla workflow
    /**
     * Seteo de los datos complementarios de la tabla tableWorkflow (excepciones y acción alternativa)
     */
    public void setDatosW() {
        Vector datos = this.control.datosWorkflow();
        for (int i = 0; i < datos.size(); i++) {
            //System.out.println(datos.size());
            Vector v = (Vector) datos.get(i);
            if (!((Integer) v.get(0) == -1)) {
                this.tableWorkflow.setValueAt(v.get(1), (Integer) v.get(0), 2);
                this.tableWorkflow.setValueAt(v.get(2), (Integer) v.get(0), 3);
            }

        }
    }

    //seteo del nombre de los casos de uso de la tabla de objetivos del negocio
    /**
     * Seteo del nombre de los casos de uso de la tabla de objetivos del negocio
     */
    public void setNomCUON() {
        Vector nomCU = new Vector();
        nomCU = this.control.getNombreCasoUso();
        this.setFilasON(nomCU.size());
        for (int i = 0; i < nomCU.size(); i++) {
            this.tableObstaculos.setValueAt(nomCU.get(i), i, 1);
            Integer intObj = new Integer(i + 1);   //agrega el numero a la fila
            this.tableObstaculos.setValueAt(intObj, i, 0);

        }
    }

    //seteo de los obstaculos en la tabla de los objetivos del negocio
    /**
     * Seteo de las precondiciones en la tabla de objetivos del negocio tableObstaculos
     */
    public void setObstaculos() {
        Vector obstaculos = new Vector();
        obstaculos = this.control.getObstaculos();
        for (int i = 0; i < obstaculos.size(); i++) {
            this.tableObstaculos.setValueAt(obstaculos.get(i), i, 2);
        }
    }

    //seteo de las precondiciones en la tabla de objetivos del negocio
    /**
     * Seteo de las precondiciones en la tabla de objetivos del negocio tableObstaculos
     */
    public void setPrecondiciones() {
        Vector precondiciones = new Vector();
        precondiciones = this.control.getPrecondiciones();
        for (int i = 0; i < precondiciones.size(); i++) {
            this.tableObstaculos.setValueAt(precondiciones.get(i), i, 3);
        }
    }

    //seteo de las propiedades de la tabla
    /**
     * Seteo de las propiedades de la tabla tableExcepciones
     * @param tam Número de filas de la tabla
     */
    public void setFilasE(int tam) {
        DefaultTableModel tabla = new MyTableModel(new Object[][]{},
                new String[]{
                    "Número", "Caso de Uso", "Excepciones"
                });
        tabla.setRowCount(tam);
        tabla.setColumnCount(3);
        this.tableExcepciones.setModel(tabla);
        MakeScrollableTextArea scrollArea = new MakeScrollableTextArea(this.tableExcepciones, this.tableExcepciones.getColumn("Excepciones"), 100, 70, 800);
        this.tableExcepciones.setShowGrid(true);
        this.tableExcepciones.setGridColor(Color.black);
        TableColumn col = tableExcepciones.getColumn("Número");
        col.setMaxWidth(50);

    }

    /**
     * Clases para generar las tablas
     */
    class MyTableModel extends DefaultTableModel {

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

    /**
     *
     */
    class MyTableModel3 extends DefaultTableModel {

        /**
         *
         * @param data
         * @param columnNames
         */
        public MyTableModel3(Object[][] data, Object[] columnNames) {
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

    /**
     * Seteo de las propiedads de la tabla tableWorkflow
     * @param tam Número de filas de la tabla tableWorkflow
     */
    public void setFilasW(int tam) {
        DefaultTableModel tabla = new MyTableModel2(new Object[][]{},
                new String[]{
                    "Número", "Caso de Uso", "Excepciones Workflow", "Acción Alternativa"
                });
        tabla.setRowCount(tam);
        tabla.setColumnCount(4);
        this.tableWorkflow.setModel(tabla);
        this.tableWorkflow.setShowGrid(true);
        this.tableWorkflow.setGridColor(Color.black);
        TableColumn col = tableWorkflow.getColumn("Número");
        col.setMaxWidth(50);

    }

    /**
     * Seteo de las propiedads de la tabla tableObstaculos
     * @param tam Número de filas de la tabla tableObstaculos
     */
    public void setFilasON(int tam) {
        DefaultTableModel tabla = new MyTableModel3(new Object[][]{},
                new String[]{
                    "Número", "Caso de Uso", "Precondición", "Obstáculo"
                });
        tabla.setRowCount(tam);
        tabla.setColumnCount(4);
        this.tableObstaculos.setModel(tabla);
        this.tableObstaculos.getColumnModel().getColumn(1).setCellRenderer(new TextAreaRenderer());
        this.tableObstaculos.getColumnModel().getColumn(2).setCellRenderer(new TextAreaRenderer());
        this.tableObstaculos.getColumnModel().getColumn(3).setCellRenderer(new TextAreaRenderer());
        this.tableObstaculos.setShowGrid(true);
        this.tableObstaculos.setGridColor(Color.black);
        TableColumn col = tableObstaculos.getColumn("Número");
        col.setMaxWidth(50);

    }

    /**
     * Captura los datos del campo Excepciones de la tabla tableExcepciones
     * @return Vector con los datos del campo
     */
    public Vector getExcepciones() {
        Vector excepciones = new Vector();
        for (int i = 0; i < this.tableExcepciones.getRowCount(); i++) {
            if (this.tableExcepciones.getValueAt(i, 2) == null || this.tableExcepciones.getValueAt(i, 2).toString().equals("")) {
                excepciones.add("--");
            } else {
                excepciones.add(this.tableExcepciones.getValueAt(i, 2));
            }
        }
        return excepciones;
    }

    //seteo de excepciones de una sesion anterior
    /**
     * Seteo de excepciones de una sesion anterior
     * @param excepciones
     */
    public void setExcepciones(Vector excepciones) {
        for (int i = 0; i < excepciones.size(); i++) {
            this.tableExcepciones.setValueAt(excepciones.get(i), i, 2);
        }
    }

    //verificar si hay celdas seleccionadas
    /**
     * Verifica si hay celdas seleccionadas
     * @return 1 si está seleccionada, 0 en caso contrario
     */
    public int select() {
        for (int i = 0; i < this.tableExcepciones.getRowCount(); i++) {
            if (this.tableExcepciones.isCellSelected(i, 2)) {
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
        scrollPaneWorkflow = new javax.swing.JScrollPane();
        tableWorkflow = new javax.swing.JTable();
        scrollPaneObstaculos = new javax.swing.JScrollPane();
        tableObstaculos = new javax.swing.JTable();
        scrollPaneExcepciones = new javax.swing.JScrollPane();
        tableExcepciones = new javax.swing.JTable();
        labelWorkflow = new javax.swing.JLabel();
        labelObstaculos = new javax.swing.JLabel();
        labelExcepciones = new javax.swing.JLabel();
        labelArrastrar1 = new javax.swing.JLabel();
        labelArrastrar2 = new javax.swing.JLabel();

        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(958, 611));

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(proyectodetitulo.ProyectoDeTituloApp.class).getContext().getResourceMap(JPExcepciones.class);
        labelInstrucciones.setText(resourceMap.getString("labelInstrucciones.text")); // NOI18N
        labelInstrucciones.setName("labelInstrucciones"); // NOI18N

        labelTitulo.setFont(resourceMap.getFont("labelTitulo.font")); // NOI18N
        labelTitulo.setText(resourceMap.getString("labelTitulo.text")); // NOI18N
        labelTitulo.setName("labelTitulo"); // NOI18N

        panelTablas.setName("panelTablas"); // NOI18N
        panelTablas.setLayout(new java.awt.GridBagLayout());

        scrollPaneWorkflow.setName("scrollPaneWorkflow"); // NOI18N

        tableWorkflow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Caso de Uso", "Acción Alternativa", "Excepciones Workflow"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableWorkflow.setCellSelectionEnabled(true);
        tableWorkflow.setDragEnabled(true);
        tableWorkflow.setName("tableWorkflow"); // NOI18N
        tableWorkflow.getTableHeader().setReorderingAllowed(false);
        scrollPaneWorkflow.setViewportView(tableWorkflow);
        tableWorkflow.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tableWorkflow.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tableWorkflow.columnModel.title0")); // NOI18N
        tableWorkflow.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("tDatosWorkflow.columnModel.title2")); // NOI18N
        tableWorkflow.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("tDatosWorkflow.columnModel.title1")); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        panelTablas.add(scrollPaneWorkflow, gridBagConstraints);

        scrollPaneObstaculos.setName("scrollPaneObstaculos"); // NOI18N

        tableObstaculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Caso de Uso", "Precondición", "Obstáculo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableObstaculos.setCellSelectionEnabled(true);
        tableObstaculos.setDragEnabled(true);
        tableObstaculos.setName("tableObstaculos"); // NOI18N
        tableObstaculos.getTableHeader().setReorderingAllowed(false);
        scrollPaneObstaculos.setViewportView(tableObstaculos);
        tableObstaculos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tableObstaculos.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tableObstaculos.columnModel.title0")); // NOI18N
        tableObstaculos.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("tDatosON.columnModel.title2")); // NOI18N
        tableObstaculos.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("tDatosON.columnModel.title1")); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        panelTablas.add(scrollPaneObstaculos, gridBagConstraints);

        scrollPaneExcepciones.setName("scrollPaneExcepciones"); // NOI18N

        tableExcepciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Caso de Uso", "Excepciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableExcepciones.setCellSelectionEnabled(true);
        tableExcepciones.setDropMode(javax.swing.DropMode.ON);
        tableExcepciones.setName("tableExcepciones"); // NOI18N
        tableExcepciones.getTableHeader().setReorderingAllowed(false);
        scrollPaneExcepciones.setViewportView(tableExcepciones);
        tableExcepciones.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tableExcepciones.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tableExcepciones.columnModel.title0")); // NOI18N
        tableExcepciones.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("tableExcepciones.columnModel.title1")); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panelTablas.add(scrollPaneExcepciones, gridBagConstraints);

        labelWorkflow.setFont(resourceMap.getFont("labelWorkflow.font")); // NOI18N
        labelWorkflow.setText(resourceMap.getString("labelWorkflow.text")); // NOI18N
        labelWorkflow.setName("labelWorkflow"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelTablas.add(labelWorkflow, gridBagConstraints);

        labelObstaculos.setFont(resourceMap.getFont("labelObstaculos.font")); // NOI18N
        labelObstaculos.setText(resourceMap.getString("labelObstaculos.text")); // NOI18N
        labelObstaculos.setName("labelObstaculos"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        panelTablas.add(labelObstaculos, gridBagConstraints);

        labelExcepciones.setFont(resourceMap.getFont("labelExcepciones.font")); // NOI18N
        labelExcepciones.setText(resourceMap.getString("labelExcepciones.text")); // NOI18N
        labelExcepciones.setName("labelExcepciones"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panelTablas.add(labelExcepciones, gridBagConstraints);

        labelArrastrar1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelArrastrar1.setIcon(resourceMap.getIcon("labelArrastrar1.icon")); // NOI18N
        labelArrastrar1.setText(resourceMap.getString("labelArrastrar1.text")); // NOI18N
        labelArrastrar1.setName("labelArrastrar1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 5);
        panelTablas.add(labelArrastrar1, gridBagConstraints);

        labelArrastrar2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelArrastrar2.setIcon(resourceMap.getIcon("labelArrastrar2.icon")); // NOI18N
        labelArrastrar2.setText(resourceMap.getString("labelArrastrar2.text")); // NOI18N
        labelArrastrar2.setName("labelArrastrar2"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelTablas.add(labelArrastrar2, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTablas, 0, 0, Short.MAX_VALUE)
                    .addComponent(labelInstrucciones, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                    .addComponent(labelTitulo))
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
                .addComponent(panelTablas, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelArrastrar1;
    private javax.swing.JLabel labelArrastrar2;
    private javax.swing.JLabel labelExcepciones;
    private javax.swing.JLabel labelInstrucciones;
    private javax.swing.JLabel labelObstaculos;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelWorkflow;
    private javax.swing.JPanel panelTablas;
    private javax.swing.JScrollPane scrollPaneExcepciones;
    private javax.swing.JScrollPane scrollPaneObstaculos;
    private javax.swing.JScrollPane scrollPaneWorkflow;
    private javax.swing.JTable tableExcepciones;
    private javax.swing.JTable tableObstaculos;
    private javax.swing.JTable tableWorkflow;
    // End of variables declaration//GEN-END:variables
}
