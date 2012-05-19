package Vista;

import Controlador.ControladorResumen;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class JPResumen extends javax.swing.JPanel {

	ControladorResumen control;

	/** Creates new form JPResumen */
	public JPResumen(ControladorResumen controlador) {
		this.control = controlador;
		try {
// apariencia del SO
			UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
		}
		//seteo de los datos de la tabla
		initComponents();
		this.setNomCU();
		if (this.control.getResumenCU() == null) {
			this.setResumen();
		} else {
			this.setResumenCU(this.control.getResumenCU());
		}

		//para visualizar el contenido de una celda al pasar el mouse en ella
		this.tablaResumen.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				Point p = e.getPoint();
				int row = tablaResumen.rowAtPoint(p);
				int column = tablaResumen.columnAtPoint(p);
                                if((!"null".equals(String.valueOf(tablaResumen.getValueAt(row, column)))) && (!"[]".equals(String.valueOf(tablaResumen.getValueAt(row, column))))){
                                    tablaResumen.setToolTipText(String.valueOf(tablaResumen.getValueAt(row, column)));  
                                }
                                else{
                                    tablaResumen.setToolTipText("Resumen no definido");
                                }
			}
		});

	}

	//seteo de los resumenes de una sesion anterior
	/**
	 * Seteo de los resumenes de una sesion anterior
	 * @param resumen
	 */
	public void setResumenCU(Vector resumen) {
		for (int i = 0; i < resumen.size(); i++) {
			this.tablaResumen.setValueAt(resumen.get(i), i, 2);
			Integer intObj = new Integer(i + 1);   //agrega el numero a la fila
			this.tablaResumen.setValueAt(intObj, i, 0);
		}
	}

	//seteo del nombte de los casos de uso
	/**
	 * Seteo del nombre de los casos de uso
	 */
	public void setNomCU() {
		Vector nomCU = new Vector();
		nomCU = this.control.getNombreCasoUso();
		this.setFilas(nomCU.size());
		for (int i = 0; i < nomCU.size(); i++) {
			this.tablaResumen.setValueAt(nomCU.get(i), i, 1);
		}
	}

	//seteo de los resumenes en la tabla
	/**
	 * Seteo de los resumenes en la tabla
	 */
	public void setResumen() {
		Vector resumenON = new Vector();
		resumenON = this.control.getResumen();
		for (int i = 0; i < resumenON.size(); i++) {
			this.tablaResumen.setValueAt(resumenON.get(i), i, 2);
			Integer intObj = new Integer(i + 1);   //agrega el numero a la fila
			this.tablaResumen.setValueAt(intObj, i, 0);
		}
	}

	//seteo de las propiedades de la tabla resumen
	/**
	 * Seteo de las propiedades de la tabla resumen
	 * @param tam indica el tamaño de las filas seteadas
	 */
	public void setFilas(int tam) {
		DefaultTableModel tabla = new MyTableModel(new Object[][]{},
				new String[]{
					"Número", "Caso de Uso", "Resumen"
				});
		tabla.setRowCount(tam);
		tabla.setColumnCount(3);
		this.tablaResumen.setModel(tabla);
		this.tablaResumen.getColumnModel().getColumn(2).setCellRenderer(new TextAreaRenderer());
		this.tablaResumen.setShowGrid(true);
		TableColumn col = tablaResumen.getColumn("Número");
		col.setMaxWidth(50);
		this.tablaResumen.setGridColor(Color.black);

		tablaResumen.getColumn("Resumen").setCellRenderer(new DefaultTableCellRenderer() {

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				setText(value.toString());
				Icon ico = new ImageIcon(getClass().getResource("/Fotos/lapiz.png"));
				setIcon(ico);
				//  setBackground(Color.LIGHT_GRAY);
				table.getTableHeader().setReorderingAllowed(false);
				return this;
			}
		});
	}

	/**
	 *
	 */
	class MyTableModel extends DefaultTableModel {

		/**
		 * Modelo de tabla
		 * @param data
		 * @param columnNames
		 */
		public MyTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		/**
		 * Verificar si alguna de las celdas que se tienen son editables
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

	//obtener los resumenes modificados de la tabla
	/**
	 * Obtener los resumenes modificados de la tabla
	 * @return devuelve el resumen de los casos de uso
	 */
	public Vector resumenCU() {
		Vector resumenCU = new Vector();
		for (int i = 0; i < this.tablaResumen.getRowCount(); i++) {
			resumenCU.add(this.tablaResumen.getValueAt(i, 2));
		}
		return resumenCU;
	}

	//verificar si hay nulos
	/**
	 * Verificar si hay nulos
	 * @return los vectores que son nulos (para el caso de los resúmenes)
	 */
	public Vector nulos() {
		Vector v = new Vector();
		for (int i = 0; i < this.tablaResumen.getRowCount(); i++) {
			if (this.tablaResumen.getValueAt(i, 2) == null) {
				v.add(0, 1);
				v.add(1, i + 1);
				return v;
			}
		}
		v.add(0, 0);
		return v;
	}

	//verificar si hay celdas seleccionadas
	/**
	 * Verificar si hay celdas seleccionadas
	 * @return Retorna si la celda ha sido seleccionada (1) o no (0)
	 */
	public int select() {
		for (int i = 0; i < this.tablaResumen.getRowCount(); i++) {
			if (this.tablaResumen.isCellSelected(i, 2)) {
				return 1;
			}
		}
		return 0;
	}

	public void alerta(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "¡Advertencia!", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Verifica si las celdas de la columna "Resumen" estan completas.  
	 * @return Boolean, true, si todas las celdas se encuentran con descripción y false de otra forma
	 */
	public boolean checkRcompletos() {
		String resumen = "";
		for (int i = 0; i < this.tablaResumen.getRowCount(); i++) {
			resumen = (String) this.tablaResumen.getValueAt(i, 2);

			if (resumen.compareTo("") == 0) {
				return false;
			}
		}
		return true;
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
        jPanel1 = new javax.swing.JPanel();
        labelInformacion = new javax.swing.JLabel();
        labelResumenCasosDeUso = new javax.swing.JLabel();
        scrollPaneResumen = new javax.swing.JScrollPane();
        tablaResumen = new javax.swing.JTable();

        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(450, 400));

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(proyectodetitulo.ProyectoDeTituloApp.class).getContext().getResourceMap(JPResumen.class);
        labelInstrucciones.setText(resourceMap.getString("labelInstrucciones.text")); // NOI18N
        labelInstrucciones.setName("labelInstrucciones"); // NOI18N

        labelTitulo.setFont(resourceMap.getFont("labelTitulo.font")); // NOI18N
        labelTitulo.setText(resourceMap.getString("labelTitulo.text")); // NOI18N
        labelTitulo.setName("labelTitulo"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new java.awt.GridBagLayout());

        labelInformacion.setIcon(resourceMap.getIcon("labelInformacion.icon")); // NOI18N
        labelInformacion.setText(resourceMap.getString("labelInformacion.text")); // NOI18N
        labelInformacion.setName("labelInformacion"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(labelInformacion, gridBagConstraints);

        labelResumenCasosDeUso.setFont(resourceMap.getFont("labelResumenCasosDeUso.font")); // NOI18N
        labelResumenCasosDeUso.setText(resourceMap.getString("labelResumenCasosDeUso.text")); // NOI18N
        labelResumenCasosDeUso.setName("labelResumenCasosDeUso"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(labelResumenCasosDeUso, gridBagConstraints);

        scrollPaneResumen.setName("scrollPaneResumen"); // NOI18N

        tablaResumen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Caso de Uso", "Resumen"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaResumen.setToolTipText(resourceMap.getString("tablaResumen.toolTipText")); // NOI18N
        tablaResumen.setCellSelectionEnabled(true);
        tablaResumen.setName("tablaResumen"); // NOI18N
        scrollPaneResumen.setViewportView(tablaResumen);
        tablaResumen.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tablaResumen.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tablaResumen.columnModel.title0")); // NOI18N
        tablaResumen.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("tablaResumen.columnModel.title1")); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(scrollPaneResumen, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                        .addGap(270, 270, 270))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelInstrucciones, 0, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addGap(18, 18, 18)
                .addComponent(labelInstrucciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

	public void deshacer() {
		Vector resumenON = new Vector();
		resumenON = this.control.getResumen();
		for (int i = 0; i < resumenON.size(); i++) {
			if (this.tablaResumen.isCellSelected(i, 2)) {
				this.tablaResumen.setValueAt(resumenON.get(i), i, 2);
			}
		}
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelInformacion;
    private javax.swing.JLabel labelInstrucciones;
    private javax.swing.JLabel labelResumenCasosDeUso;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JScrollPane scrollPaneResumen;
    private javax.swing.JTable tablaResumen;
    // End of variables declaration//GEN-END:variables
}
