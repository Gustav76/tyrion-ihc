package Vista;

import Controlador.ControladorIdentificarCU1;
import DTO.ObjWorkDTO;
import DTO.ObjetivoDTO;
import java.awt.Color;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.util.Vector;
import javax.swing.DropMode;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Tapsin
 */
public class JPIdentificarCU1 extends javax.swing.JPanel {

	ControladorIdentificarCU1 control;
	DefaultTableModel tablaModel;
	public Vector nuevo = new Vector();
	public Vector rowTabla = new Vector();
	public Vector rowLista = new Vector();
	public Vector rowDato = new Vector();
	public Vector listObj = new Vector();
	public Vector listWork = new Vector();
	public String datos;

	/** Creates new form JPIdentificarCU1 */
	public JPIdentificarCU1(ControladorIdentificarCU1 controlador) {

		this.control = controlador;
		//carga los componentes y datos de la vista
		initComponents();
		this.cargarObjetivos();
		//this.jButton1.setEnabled(false);
		if (this.control.getListadoSA() == null) {
			nuevo = this.cargarWorkflosSeparados();
			this.listaWorkflow.setListData(nuevo);
		} else {
			//this.jButton1.setEnabled(true);
//             this.bContinuar.setEnabled(true);
			this.setTablaWO(this.control.getListadoSA());
			this.rowDato = this.control.rDato();
			this.rowLista = this.control.rLista();
			this.rowTabla = this.control.rTabla();
			this.nuevo = this.control.nuevo();

			this.cargarWorkflosSeparados();
			this.listaWorkflow.setListData(nuevo);
		}
		this.listaWorkflow.setDragEnabled(true);
		this.tablaObjWork.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		this.tablaObjWork.setDropMode(DropMode.ON);

		//para utilizar el drag and drop en la tabla
		this.tablaObjWork.setTransferHandler(new TransferHandler() {

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
				String aux;
				if (!canImport(support)) {
					return false;
				}
				//locaci�n
				JTable.DropLocation dl = (JTable.DropLocation) support.getDropLocation();
				int row = dl.getRow();
				String data;
				try {
					//el dato arrastrado
					data = (String) support.getTransferable().getTransferData(DataFlavor.stringFlavor);

				} catch (UnsupportedFlavorException e) {
					return false;
				} catch (IOException e) {
					return false;
				}
				//cuando no hay datos en la tabla
				if (tablaObjWork.getValueAt(row, 2) == null) {
					aux = data;
					aux = aux + "; ";
					tablaObjWork.setValueAt(aux, row, 2);
					rowTabla.add(row);
					rowLista.add(getListaWorkflow().getSelectedIndex());
					rowDato.add(data);
					nuevo.remove(getListaWorkflow().getSelectedIndex());
					getListaWorkflow().setListData(nuevo);
					//jButton1.setEnabled(true);
					if (nuevo.isEmpty()) {
//                         bContinuar.setEnabled(true);
						control.valido = true;
					}
				}// cuando hay elementos ya ingresados en la tabla
				else {
					aux = data;
					aux = aux + "; ";
					tablaObjWork.setValueAt(tablaObjWork.getValueAt(row, 2) + aux, row, 2);
					//tablaObjWork.setValueAt(data, row, 1);
					rowTabla.add(row);
					rowLista.add(getListaWorkflow().getSelectedIndex());
					rowDato.add(data);
					nuevo.remove(getListaWorkflow().getSelectedIndex());
					getListaWorkflow().setListData(nuevo);
					//jButton1.setEnabled(true);
					if (nuevo.isEmpty()) {
//                         bContinuar.setEnabled(true);
						control.valido = true;
					}
				}
				return true;
			}
		});
		//para visualizar el contenido de una celda al pasar el mouse por ella
		this.tablaObjWork.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				Point p = e.getPoint();
				int row = tablaObjWork.rowAtPoint(p);
				int column = tablaObjWork.columnAtPoint(p);
				tablaObjWork.setToolTipText(String.valueOf(tablaObjWork.getValueAt(row, column)));
			}
		});

	}

	/**
	 * Asigna los objetivos a tableModel
	 * no tiene entrada ni retorno
	 */
	public void cargarObjetivos() {
		ObjetivoDTO objDTO = new ObjetivoDTO();
		ObjWorkDTO objWork;
		Vector ON = this.control.getNombreON();
		this.setFilas(ON.size());
		for (int i = 0; i < ON.size(); i++) {
			objDTO = (ObjetivoDTO) ON.get(i);
			this.tablaObjWork.setValueAt(objDTO.getNombre(), i, 1);
			Integer intObj = new Integer(i + 1);   //agrega el numero a la fila
			this.tablaObjWork.setValueAt(intObj, i, 0);
		}
	}

	//todos los workflows juntos
	/**
	 * Carga todos los workflows juntos
	 * no posee entrada
	 * @return Vetor con workflows
	 */
	public Vector cargarWorkflos() {
		Vector workflows = new Vector();
		workflows = this.control.getWorkflows();
		return workflows;
	}

	//los ciclos separados
	/**
	 * Carga los workflows por separado
	 * no posee entrada
	 * @return  Vector con workflows
	 */
	public Vector cargarWorkflosSeparados() {
		Vector workflows = new Vector();
		workflows = this.control.getWorkflowsSeparados();
		return workflows;
	}

	//seteo de propiedades de la tabla
	/**
	 * Seteo de propiedades de la tabla
	 * @param tam de tipo int para generaci�n de la tabla
	 */
	public void setFilas(int tam) {

		DefaultTableModel tabla = new MyTableModel(new Object[][]{},
				new String[]{
					"Número", "Nombre Objetivo", "Workflow Asociado"
				});
		tabla.setRowCount(tam);
		tabla.setColumnCount(3);
		tablaObjWork.setModel(tabla);
		this.tablaObjWork.getColumnModel().getColumn(2).setCellRenderer(new TextAreaRenderer());
		tablaObjWork.setShowGrid(true);
		tablaObjWork.setGridColor(Color.black);
		TableColumn col = tablaObjWork.getColumn("Número");
		col.setMaxWidth(50);
	}

	public void alerta(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Identificar Casos de Uso", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * @return the listaWorkflow
	 */
	public javax.swing.JList getListaWorkflow() {
		return listaWorkflow;
	}

	/**
	 * @param listaWorkflow the listaWorkflow to set
	 */
	public void setListaWorkflow(javax.swing.JList listaWorkflow) {
		this.listaWorkflow = listaWorkflow;
	}

	//seteo de propiedades de la tabla
	/**
	 * clase para generar tabla
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
		 * El m�todo esblece la posibilidad de edici�n de la tabla
		 * @param row filas de la tabla
		 * @param col columnas de la tabla
		 * @return valor booleano true o false
		 */
		@Override
		public boolean isCellEditable(int row, int col) {
			if (col == 0 || col == 1 || col == 2) {
				return false;
			} else {
				return true;
			}
		}
	}

	//seteo del listado de workflows por objetivos asignados
	/**
	 * El m�todo asigna los workflows a los objetivos
	 * @return Vector de workflows
	 */
	public Vector setObjWork() {
		Vector ON = this.control.getNombreON();
		Vector listObjWork = new Vector();
		for (int i = 0; i < ON.size(); i++) {
			listObjWork.add(this.tablaObjWork.getValueAt(i, 2));
		}
		return listObjWork;
	}

	/**
	 *
	 * @return Vector con workflows objetivos
	 */
	public Vector setWorkXObj() {
		Vector ON = this.control.getNombreON();
		int cont = 0;
		Vector listWorkflowXObjetivo = new Vector();
		Vector workflow;
		for (int i = 0; i < ON.size(); i++) {
			workflow = new Vector();
			for (int j = 0; j < this.rowTabla.size(); j++) {
				if (Integer.parseInt(this.rowTabla.get(j).toString()) == i) {
					workflow.add(this.rowDato.get(j));
				}
			}
			listWorkflowXObjetivo.add(workflow);
		}
		return listWorkflowXObjetivo;
	}

	//obtiene los datos de la tabla
	/**
	 * Obtiene los valores de los elementos de la tabla
	 * @return Vector con los elementos de la lista
	 */
	public Vector getDatosTabla() {
		Vector listadoSA = new Vector();
		for (int i = 0; i < this.tablaObjWork.getRowCount(); i++) {
			listadoSA.add(this.tablaObjWork.getValueAt(i, 2));
		}
		return listadoSA;
	}

	//setea los valores en la tabla
	/**
	 * Setea los valores de los elementos de la tabla
	 * @param list setea los workflows en la tabla con su correspondiente objetivo
	 */
	public void setTablaWO(Vector list) {
		for (int i = 0; i < list.size(); i++) {
			this.tablaObjWork.setValueAt(list.get(i), i, 2);
			Integer intObj = new Integer(i + 1);   //agrega el numero a la fila
			this.tablaObjWork.setValueAt(intObj, i, 0);
		}
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
        scrollPaneObjWork = new javax.swing.JScrollPane();
        tablaObjWork = new javax.swing.JTable();
        scrollPaneWorkflow = new javax.swing.JScrollPane();
        listaWorkflow = new javax.swing.JList();
        labelWorkflow = new javax.swing.JLabel();
        labelObjWork = new javax.swing.JLabel();
        labelArrastrar = new javax.swing.JLabel();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(proyectodetitulo.ProyectoDeTituloApp.class).getContext().getResourceMap(JPIdentificarCU1.class);
        labelInstrucciones.setText(resourceMap.getString("labelInstrucciones.text")); // NOI18N
        labelInstrucciones.setName("labelInstrucciones"); // NOI18N

        labelTitulo.setFont(resourceMap.getFont("labelTitulo.font")); // NOI18N
        labelTitulo.setText(resourceMap.getString("labelTitulo.text")); // NOI18N
        labelTitulo.setName("labelTitulo"); // NOI18N

        panelTablas.setName("panelTablas"); // NOI18N
        panelTablas.setLayout(new java.awt.GridBagLayout());

        scrollPaneObjWork.setName("scrollPaneObjWork"); // NOI18N

        tablaObjWork.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Nombre Objetivo", "Workflow Asociado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaObjWork.setCellSelectionEnabled(true);
        tablaObjWork.setDragEnabled(true);
        tablaObjWork.setName("tablaObjWork"); // NOI18N
        tablaObjWork.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tablaObjWorkMouseDragged(evt);
            }
        });
        scrollPaneObjWork.setViewportView(tablaObjWork);
        tablaObjWork.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tablaObjWork.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tablaObjWork.columnModel.title2")); // NOI18N
        tablaObjWork.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("tablaObjWork.columnModel.title0")); // NOI18N
        tablaObjWork.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("tablaObjWork.columnModel.title1")); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelTablas.add(scrollPaneObjWork, gridBagConstraints);

        scrollPaneWorkflow.setName("scrollPaneWorkflow"); // NOI18N

        listaWorkflow.setName("listaWorkflow"); // NOI18N
        listaWorkflow.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                listaWorkflowMouseDragged(evt);
            }
        });
        scrollPaneWorkflow.setViewportView(listaWorkflow);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panelTablas.add(scrollPaneWorkflow, gridBagConstraints);

        labelWorkflow.setFont(resourceMap.getFont("labelWorkflow.font")); // NOI18N
        labelWorkflow.setText(resourceMap.getString("labelWorkflow.text")); // NOI18N
        labelWorkflow.setName("labelWorkflow"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelTablas.add(labelWorkflow, gridBagConstraints);

        labelObjWork.setFont(resourceMap.getFont("labelObjWork.font")); // NOI18N
        labelObjWork.setText(resourceMap.getString("labelObjWork.text")); // NOI18N
        labelObjWork.setName("labelObjWork"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelTablas.add(labelObjWork, gridBagConstraints);

        labelArrastrar.setIcon(resourceMap.getIcon("labelArrastrar.icon")); // NOI18N
        labelArrastrar.setText(resourceMap.getString("labelArrastrar.text")); // NOI18N
        labelArrastrar.setName("labelArrastrar"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panelTablas.add(labelArrastrar, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(158, 158, 158))
                    .addComponent(labelInstrucciones, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                    .addComponent(panelTablas, 0, 0, Short.MAX_VALUE))
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
                .addComponent(panelTablas, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablaObjWorkMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaObjWorkMouseDragged
		// TODO add your handling code here:
}//GEN-LAST:event_tablaObjWorkMouseDragged

    private void listaWorkflowMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaWorkflowMouseDragged
		// TODO add your handling code here:
}//GEN-LAST:event_listaWorkflowMouseDragged
	public void deshacer() {
		int t = Integer.parseInt(this.rowTabla.lastElement().toString());
		this.rowTabla.remove(this.rowTabla.size() - 1);
		if (this.tablaObjWork.getValueAt(t, 2).toString().equals(this.rowDato.lastElement().toString())) {
			this.tablaObjWork.setValueAt(null, t, 2);
		} else {
			String nuevoDato = this.tablaObjWork.getValueAt(t, 2).toString().substring(0, this.tablaObjWork.getValueAt(t, 2).toString().length() - (this.rowDato.lastElement().toString().length() + 2));
			this.tablaObjWork.setValueAt(nuevoDato, t, 2);
		}
		int l = Integer.parseInt(this.rowLista.lastElement().toString());
		this.rowLista.remove(this.rowLista.size() - 1);
		this.nuevo.add(l, this.rowDato.lastElement());
		this.rowDato.remove(this.rowDato.size() - 1);
		this.listaWorkflow.setListData(nuevo);
		//if ((rowTabla.isEmpty()) && (rowLista.isEmpty()) && (rowDato.isEmpty())) {
		//jButton1.setEnabled(false);
		//}
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelArrastrar;
    private javax.swing.JLabel labelInstrucciones;
    private javax.swing.JLabel labelObjWork;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelWorkflow;
    private javax.swing.JList listaWorkflow;
    private javax.swing.JPanel panelTablas;
    private javax.swing.JScrollPane scrollPaneObjWork;
    private javax.swing.JScrollPane scrollPaneWorkflow;
    private javax.swing.JTable tablaObjWork;
    // End of variables declaration//GEN-END:variables
}
