/*1*/ package Vista;
/*2*/ import Controlador.ControladorPrincipal;
/*3*/ import Controlador.ControladorIdentificarCU2;
/*4*/ import DTO.ObjetivoDTO;
/*5*/ import java.awt.Color;
import java.awt.Component;
/*6*/ import java.awt.Point;
/*7*/ import java.awt.event.MouseEvent;
/*8*/ import java.awt.event.MouseMotionAdapter;
/*9*/ import java.awt.event.WindowAdapter;
/*10*/ import java.awt.event.WindowEvent;
/*11*/ import java.io.File;
/*12*/ import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
/*13*/ import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
/*14*/ import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
/*15*/

public class JPIdentificarCU2 extends javax.swing.JPanel {

    public ControladorIdentificarCU2 control;

    /** Creates new form JPIdentificarCU2 */
    public JPIdentificarCU2(ControladorIdentificarCU2 controlador) {
        /*30*/ this.control = controlador;
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
        /*31*/         //carga datos de la tabla
/*32*/ initComponents();
        /*33*/ if (this.control.getNombreCasosUso() == null) {
            /*34*/ this.cargarObjetivos();
            /*35*/        } else {
            /*36*/ setObjetivos();
            /*37*/ setNomCU(this.control.getNombreCasosUso());
            /*38*/        }
        /*39*/         //Para visualizar el contenido de una celda al pasar el mouse por ella
/*40*/ this.tNombreCasoUso.addMouseMotionListener(new MouseMotionAdapter() {
            /*41*/
            /*42*/ @Override
            /*43*/ public void mouseMoved(MouseEvent e) {
                /*44*/ Point p = e.getPoint();
                /*45*/ int row = tNombreCasoUso.rowAtPoint(p);
                /*46*/ int column = tNombreCasoUso.columnAtPoint(p);
                       if((!"null".equals(String.valueOf(tNombreCasoUso.getValueAt(row, column)))) && (!"[]".equals(String.valueOf(tNombreCasoUso.getValueAt(row, column))))){
                            tNombreCasoUso.setToolTipText(String.valueOf(tNombreCasoUso.getValueAt(row, column)));  
                        }
                       else{
/*47*/                      tNombreCasoUso.setToolTipText("Caso de Uso no asociado");
                       }
                /*48*/            }
            /*49*/        });
        /*50*/
        /*51*/         //al presionar botón cerrar de la ventana pide guardar los datos generados en un archivo (Archivo sesion anterior)
///*52*/         this.addWindowListener(new WindowAdapter() {
///*53*/
///*54*/             @Override
///*55*/             public void windowClosing(WindowEvent e) {
///*56*/                 javax.swing.JFileChooser jF1 = new javax.swing.JFileChooser();
///*57*/                 String ruta = "";
///*58*/                 try {
///*59*/                     if (jF1.showSaveDialog(null) == jF1.APPROVE_OPTION) {
///*60*/                         ruta = jF1.getSelectedFile().getAbsolutePath();
///*61*/                         //Aqui ya tiens la ruta,,,ahora puedes crear un fichero n esa ruta y escribir lo k kieras...
///*62*/                         if (new File(ruta).exists()) {
///*63*/                             if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "El fichero existe,desea reemplazarlo?", "Titulo", JOptionPane.YES_NO_OPTION)) {
///*64*/                                 control.archivoSesion(ruta);
///*65*/                             }
///*66*/                         } else {
///*67*/                             control.archivoSesion(ruta);
///*68*/                         }
///*69*/                     }
///*70*/                 } catch (Exception ex) {
///*71*/                     ex.printStackTrace();
///*72*/                 }
///*73*/
///*74*/                 System.exit(0);
///*75*/             }
///*76*/         });
/*77*/    }
    /*78*/
    /*79*/ /**
     * Carga los objetivos en la tabla tNombreCasoUso
     * este método no posee entrada ni salida
     */
    /*83*/ public void cargarObjetivos() {
        /*84*/ ObjetivoDTO objDTO = new ObjetivoDTO();
        /*85*/ Vector ON = this.control.getObjetivosNegocio();
        /*86*/ this.setFilas(ON.size());
        /*87*/ for (int i = 0; i < ON.size(); i++) {
            /*88*/ objDTO = (ObjetivoDTO) ON.get(i);
            /*89*/ this.tNombreCasoUso.setValueAt(objDTO.getNombre(), i, 1);
            /*90*/ this.tNombreCasoUso.setValueAt(objDTO.getNombre(), i, 2);
            Integer intObj = new Integer(i + 1);   //agrega el numero a la fila
            this.tNombreCasoUso.setValueAt(intObj, i, 0);
            /*91*/        }
        /*92*/    }
    /*93*/
    /*94*/     //setea los objetivos en la tabla
/*95*/ /**
     * Setea los objetivos en la tabla
     * este método no posee entrada ni salida
     */
    /*98*/ public void setObjetivos() {
        /*99*/ ObjetivoDTO objDTO = new ObjetivoDTO();
        /*100*/ Vector ON = this.control.getObjetivosNegocio();
        /*101*/ this.setFilas(ON.size());
        /*102*/ for (int i = 0; i < ON.size(); i++) {
            /*103*/ objDTO = (ObjetivoDTO) ON.get(i);
            /*104*/ this.tNombreCasoUso.setValueAt(objDTO.getNombre(), i, 1);
            Integer intObj = new Integer(i + 1);   //agrega el numero a la fila
            this.tNombreCasoUso.setValueAt(intObj, i, 0);
            /*105*/        }
        /*106*/    }
    /*107*/
    /*108*/     //seteo del nombre de los casos de uso
/*109*/ /**
     * Setea el nombre del caso de uso
     * @param nomCU de tipo vector con los nombres de los casos de uso que pueden ser editado en la tabla tNombreCasoUso
     * no retorna nada
     */
    /*113*/ public void setNomCU(Vector nomCU) {
        /*114*/ for (int i = 0; i < nomCU.size(); i++) {
            /*115*/ this.tNombreCasoUso.setValueAt(nomCU.get(i), i, 2);
            /*116*/        }
        /*117*/    }
    /*118*/
    /*119*/     //seteo de propiedades de la tabla
/*120*/ /**
     * Setea las propiedades de la tabla
     * @param tam Cantidad de filas
     */
    /*124*/ public void setFilas(int tam) {
        /*125*/ DefaultTableModel tabla = new MyTableModel(new Object[][]{
                    /*126*/{}
                /*127*/                },
                /*128*/ new String[]{
                    /*129*/"Número", "Objetivos", "Caso de Uso"
                /*130*/                });
        /*131*/ tabla.setRowCount(tam);
        /*132*/ tabla.setColumnCount(3);
        /*133*/ this.tNombreCasoUso.setModel(tabla);
        /*134*/ this.tNombreCasoUso.getColumnModel().getColumn(1).setCellRenderer(new TextAreaRenderer());
        /*135*/ this.tNombreCasoUso.getColumnModel().getColumn(2).setCellRenderer(new TextAreaRenderer());
        /*136*/ this.tNombreCasoUso.setShowGrid(true);
        /*137*/ this.tNombreCasoUso.setGridColor(Color.black);
        TableColumn col = tNombreCasoUso.getColumn("Número");
        col.setMaxWidth(50);

        /*  PINTAR COLUMNA
        tNombreCasoUso.getColumn("Número").setCellRenderer(new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        setBackground(isSelected ? Color.lightGray : Color.lightGray);
        
        return this;
        }
        });
        tNombreCasoUso.getColumn("Objetivos").setCellRenderer(new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        setBackground(isSelected ? Color.lightGray : Color.lightGray);
        
        
        return this;
        }
        }); 
        
         */


        tNombreCasoUso.getColumn("Caso de Uso").setCellRenderer(new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                setText(value.toString());
System.out.println("<<<<<<<<<<<<<<<< "+value);
                Icon ico = new ImageIcon(getClass().getResource("/Fotos/lapiz.png"));
                setIcon(ico);

                return this;
            }
        });


        //---endModified 
/*138*/    }


    /*139*/
    /*140*/     //seteo de propiedades de la tabla
/*141*/ /**
     * clase para generar tabla
     */
    /*144*/ class MyTableModel extends DefaultTableModel {
        /*145*/
        /*146*/ /**
         *
         * @param data
         * @param columnNames
         */
        /*151*/ public MyTableModel(Object[][] data, Object[] columnNames) {
            /*152*/ super(data, columnNames);
            /*153*/        }
        /*154*/
        /*155*/ /**
         * El método esblece la posibilidad de edición de la tabla
         * @param row filas de la tabla
         * @param col columnas de la tabla
         * @return valor booleano true o false
         */
        /*161*/ @Override
        /*162*/ public boolean isCellEditable(int row, int col) {
            /*163*/ if (col == 0 || col == 1) {
                /*164*/ return false;
                /*165*/            } else {
                /*166*/ return true;
                /*167*/            }
            /*168*/        }
        /*169*/    }
    /*170*/
    /*171*/     //verifica que todos las celdas de la tabla de los casos de uso esten completas
/*172*/ /**
     * Verifica que todos las celdas de la tabla de los casos de uso esten completas
     * @return Si las celdas están completas, retorna 1, caso contrario; 0
     */
    /*176*/ public int verificarCasosUsoCompletos() {
        /*177*/ for (int j = 0; j < this.tNombreCasoUso.getRowCount(); j++) {
            /*178*/ if ((this.tNombreCasoUso.getValueAt(j, 2) == null) || (this.tNombreCasoUso.getValueAt(j, 2).equals(""))) {
                /*179*/ return 0;
                /*180*/            }
            /*181*/        }
        /*182*/ return 1;
        /*183*/    }
    /*184*/
    /*185*/     //guarda los nombres de los casos de uso en un vector
/*186*/ /** Guarda la edición de los casos de uso en vector nCasoUso
     * @return vector con los nombres de los casos de uso
     */
    /*190*/ public Vector nombreCasosUso() {
        /*191*/ Vector nCasoUso = new Vector();
        /*192*/ for (int i = 0; i < this.tNombreCasoUso.getRowCount(); i++) {
            /*193*/ nCasoUso.add(this.tNombreCasoUso.getValueAt(i, 2));
            /*194*/        }
        /*195*/ return nCasoUso;
        /*196*/    }
    /*197*/
    /*198*/     //verificar valosres nullos en la tabla
/*199*/ /**
     * Verificar valores nulos en la tabla, para ver si puede pasar a la siguiente fase
     * @return  Vector si hay vectores nulos o no
     */
    /*203*/ public Vector nulos() {
        /*204*/ Vector v = new Vector();
        /*205*/ for (int i = 0; i < this.tNombreCasoUso.getRowCount(); i++) {
            /*206*/ if (this.tNombreCasoUso.getValueAt(i, 2) == null) {
                /*207*/ v.add(0, 1);
                /*208*/ v.add(1, i + 1);
                /*209*/ return v;
                /*210*/            }
            /*211*/        }
        /*212*/ v.add(0, 0);
        /*213*/ return v;
        /*214*/    }
    public void inNull() {
        for (int i = 0; i < this.tNombreCasoUso.getRowCount(); i++) {
            if (this.tNombreCasoUso.getValueAt(i,2)==null){
                control.valido = false;
            }
        }
    }
    /*203*/ public void nulo() {

        /*204*/ Vector v = new Vector();
        /*205*/ for (int i = 0; i < this.tNombreCasoUso.getRowCount(); i++) {
            /*206*/ if (this.tNombreCasoUso.getValueAt(i, 2) == null) {/*207*/
                control.valido = false;
                break;
                /*211*/            }
            /*212*/
            /*213*/        }
        /*214*/    }
    /*215*/
    /*216*/     //verifica si hay alguna celda seleccionada
/*217*/ /** Verifica si hay alguna celda en modo edición
     * @return 1 si está seleccionada, 0 si no lo está
     */
    /*221*/ public int select() {
        /*222*/ for (int i = 0; i < this.tNombreCasoUso.getRowCount(); i++) {
            /*223*/ if (this.tNombreCasoUso.isCellSelected(i, 2)) {
                /*224*/ return 1;
                /*225*/            }
            /*226*/        }
        /*227*/ return 0;
        /*228*/    }
    /*229*/

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelInstrucciones = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tNombreCasoUso = new javax.swing.JTable();
        labelInformacion = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(proyectodetitulo.ProyectoDeTituloApp.class).getContext().getResourceMap(JPIdentificarCU2.class);
        labelInstrucciones.setText(resourceMap.getString("labelInstrucciones.text")); // NOI18N
        labelInstrucciones.setName("labelInstrucciones"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tNombreCasoUso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Objetivos", "Casos de Uso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tNombreCasoUso.setName("tNombreCasoUso"); // NOI18N
        jScrollPane1.setViewportView(tNombreCasoUso);
        tNombreCasoUso.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tNombreCasoUso.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tNombreCasoUso.columnModel.title2")); // NOI18N
        tNombreCasoUso.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("tNombreCasoUso.columnModel.title0")); // NOI18N

        labelInformacion.setIcon(resourceMap.getIcon("labelInformacion.icon")); // NOI18N
        labelInformacion.setText(resourceMap.getString("labelInformacion.text")); // NOI18N
        labelInformacion.setName("labelInformacion"); // NOI18N

        labelTitulo.setFont(resourceMap.getFont("labelTitulo.font")); // NOI18N
        labelTitulo.setText(resourceMap.getString("labelTitulo.text")); // NOI18N
        labelTitulo.setName("labelTitulo"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                    .addComponent(labelTitulo)
                    .addComponent(labelInformacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelInstrucciones, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
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
                .addComponent(labelInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    public void deshacer(){
             ObjetivoDTO objDTO = new ObjetivoDTO();
               Vector ON = this.control.getObjetivosNegocio();
              //this.setFilas(ON.size());
               for (int i = 0; i < this.tNombreCasoUso.getRowCount(); i++) {
               objDTO = (ObjetivoDTO) ON.get(i);
                 if (this.tNombreCasoUso.isCellSelected(i, 2)){

              // this.tNombreCasoUso.setValueAt(objDTO.getNombre(), i, 0);
               this.tNombreCasoUso.setValueAt(objDTO.getNombre(), i, 1);
               this.tNombreCasoUso.setValueAt(objDTO.getNombre(), i, 2);
                 }
               }
    }    public void alerta(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "¡Advertencia!", JOptionPane.WARNING_MESSAGE);
    }

    public void validando() {
        /*627*/ if (this.select() == 1) {
            /*628*/ this.tNombreCasoUso.clearSelection();
            /*629*/ if (this.tNombreCasoUso.getCellEditor() != null) {
                /*630*/ this.tNombreCasoUso.getCellEditor().stopCellEditing();
                /*631*/            }
            /*632*/        }
        /*633*/         //si no hay elementos nulos se guardan los datos
        /*634*/ if (((Integer) this.nulos().get(0)) == 0) {
            System.out.println("me meti");
            control.valido = true;
            /*635*/ this.control.setNombreCasosUso(this.nombreCasosUso());
            /*636*/             //paso al siguiente paso correspondiente a obtener actores                                  
            /*637*/ this.control.irControladorObtenerActores();

            /*638*/        } else {
            control.valido = false;
            /*639*/            // JOptionPane.showMessageDialog(null, "Error fila " + this.nulos().get(1) + ". No deben haber celdas vacías.", "Proyecto de Título", JOptionPane.ERROR_MESSAGE);
            /*640*/        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelInformacion;
    private javax.swing.JLabel labelInstrucciones;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTable tNombreCasoUso;
    // End of variables declaration//GEN-END:variables

    public JTable gettNombreCasoUso() {
        return tNombreCasoUso;
    }

    public void settNombreCasoUso(JTable tNombreCasoUso) {
        this.tNombreCasoUso = tNombreCasoUso;
    }
}