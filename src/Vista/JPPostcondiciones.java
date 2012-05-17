/*1*/ package Vista;
/*2*/
/*3*/ import Controlador.ControladorPostCondiciones;
/*4*/ import java.awt.Color;
import java.awt.Component;
/*5*/ import java.awt.Point;
/*6*/ import java.awt.event.MouseEvent;
/*7*/ import java.awt.event.MouseMotionAdapter;
/*8*/ import java.awt.event.WindowAdapter;
/*9*/ import java.awt.event.WindowEvent;
/*10*/ import java.io.File;
/*11*/ import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/*12*/ import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/*13*/ import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
/*14*/

public class JPPostcondiciones extends javax.swing.JPanel {


    /*21*/     ControladorPostCondiciones control;
    /** Creates new form JPPostcondiciones */
    public JPPostcondiciones(ControladorPostCondiciones controlador) {
/*28*/         this.control = controlador;
/*29*/         //seteo de los datos de las tablas
/*30*/         initComponents();
/*31*/         this.setNomCU();
/*32*/         if (this.control.getPostCondicionesCU() == null) {
/*33*/             this.setPostCondiciones();
/*34*/         } else {
/*35*/             this.setPostCondiciones(this.control.getPostCondicionesCU());
/*36*/         }
/*37*/
/*38*/         //para visualizar el contenido de una celda al pasar el mouse por ella
/*39*/         this.tPostCondiciones.addMouseMotionListener(new MouseMotionAdapter() {
/*40*/
/*41*/             @Override
/*42*/             public void mouseMoved(MouseEvent e) {
/*43*/                 Point p = e.getPoint();
/*44*/                 int row = tPostCondiciones.rowAtPoint(p);
/*45*/                 int column = tPostCondiciones.columnAtPoint(p);
/*46*/                 tPostCondiciones.setToolTipText(String.valueOf(tPostCondiciones.getValueAt(row, column)));
/*47*/             }
/*48*/         });
/*49*/
/*50*/         //al cerrar la ventana se pide guardar la información en un archivo
/////////////////*51*/         this.addWindowListener(new WindowAdapter() {
/////////////////*52*/
/////////////////*53*/             @Override
/////////////////*54*/             public void windowClosing(WindowEvent e) {
/////////////////*55*/                 javax.swing.JFileChooser jF1 = new javax.swing.JFileChooser();
/////////////////*56*/                 String ruta = "";
/////////////////*57*/                 try {
/////////////////*58*/                     if (jF1.showSaveDialog(null) == jF1.APPROVE_OPTION) {
/////////////////*59*/                         ruta = jF1.getSelectedFile().getAbsolutePath();
/////////////////*60*/                         if (new File(ruta).exists()) {
/////////////////*61*/                             if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "El fichero existe,desea reemplazarlo?", "Titulo", JOptionPane.YES_NO_OPTION)) {
/////////////////*62*/                                 control.archivoSesion(ruta);
/////////////////*63*/                             }
/////////////////*64*/                         } else {
/////////////////*65*/                             control.archivoSesion(ruta);
/////////////////*66*/                         }
/////////////////*67*/                     }
/////////////////*68*/                 } catch (Exception ex) {
/////////////////*69*/                     ex.printStackTrace();
/////////////////*70*/                 }
/////////////////*71*/
/////////////////*72*/                 System.exit(0);
/////////////////*73*/             }
/////////////////*74*/         });
/*75*/     }
/*76*/
/*77*/     //seteo del nombre de los casos de uso en la tabla
/*78*/         /**
     * Seteo del nombre de los casos de uso en la tabla
     */
/*81*/     public void setNomCU() {
/*82*/         Vector nomCU = new Vector();
/*83*/         nomCU = this.control.getNombreCasoUso();
/*84*/         this.setFilas(nomCU.size());
/*85*/         for (int i = 0; i < nomCU.size(); i++) {
/*86*/             this.tPostCondiciones.setValueAt(nomCU.get(i), i, 1);
/*87*/         }
/*88*/     }
/*89*/
/*90*/     //seteo de las postcondiciones en la tabla
/*91*/     /**
     * Seteo de las postcondiciones en la tabla
     */
/*94*/     public void setPostCondiciones() {
/*95*/         Vector postCondiciones = new Vector();
/*96*/         postCondiciones = this.control.getPostCondiciones();
/*97*/         for (int i = 0; i < postCondiciones.size(); i++) {
/*98*/             this.tPostCondiciones.setValueAt(postCondiciones.get(i), i, 2);
                    Integer intObj = new Integer(i+1);   //agrega el numero a la fila
                          this.tPostCondiciones.setValueAt(intObj, i, 0);
/*99*/         }
/*100*/     }
/*101*/
/*102*/     //seteo de las postcondiciones de una sesion anterior
/*103*/         /**
     * Seteo de las postcondiciones de una sesion anterior
     * @param postcondiciones Vector que contiene las postcondiciones.
     */
/*107*/     public void setPostCondiciones(Vector postcondiciones) {
/*108*/         for (int i = 0; i < postcondiciones.size(); i++) {
/*109*/             this.tPostCondiciones.setValueAt(postcondiciones.get(i), i, 2);
                    Integer intObj = new Integer(i+1);   //agrega el numero a la fila
                          this.tPostCondiciones.setValueAt(intObj, i, 0);
/*110*/         }
/*111*/     }
/*112*/
/*113*/     //seteo de las propiedades de la tabla
/*114*/         /**
     * Seteo de las propiedades de la tabla
     * @param tam Tamaño de las filas (Cantidad)
     */
/*118*/     public void setFilas(int tam) {
/*119*/         DefaultTableModel tabla = new MyTableModel(new Object[][]{},
/*120*/                 new String[]{
/*121*/                     "Número","Caso de Uso", "Post Condiciones"
/*122*/                 });
/*123*/         tabla.setRowCount(tam);
/*124*/         tabla.setColumnCount(3);
/*125*/         this.tPostCondiciones.setModel(tabla);
/*126*/         this.tPostCondiciones.setShowGrid(true);
                this.tPostCondiciones.getColumnModel().getColumn(2).setCellRenderer(new TextAreaRenderer());
/*127*/         this.tPostCondiciones.setGridColor(Color.black);
                TableColumn col= tPostCondiciones.getColumn("Número");
                col.setMaxWidth(50);
                
                tPostCondiciones.getColumn("Post Condiciones").setCellRenderer(new DefaultTableCellRenderer() {
                    @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                 setText(value.toString());
                 Icon ico = new ImageIcon(getClass().getResource("/Fotos/lapiz.png"));
                 setIcon(ico);
              //   setBackground(Color.LIGHT_GRAY);
                 table.getTableHeader().setReorderingAllowed(false);
                return this;
                }
            });
/*128*/     }
/*129*/
/*130*/     /**
             *
             */
/*133*/     class MyTableModel extends DefaultTableModel {
/*134*/
/*135*/         /**
                 *
                 * @param data
                 * @param columnNames
                 */
/*140*/         public MyTableModel(Object[][] data, Object[] columnNames) {
/*141*/             super(data, columnNames);
/*142*/         }
/*143*/
/*144*/         /**
                 *
                 * @param row
                 * @param col
                 * @return
                 */
/*150*/         @Override
/*151*/         public boolean isCellEditable(int row, int col) {
/*152*/             if (col == 0 || col == 1) {
/*153*/                 return false;
/*154*/             } else {
/*155*/                 return true;
/*156*/             }
/*157*/         }
/*158*/     }
/*159*/
/*160*/     //obtener las postcondiciones de la tabla
/*161*/         /**
     * Obtener las postcondiciones de la tabla
     * @return Muestra las postcondiciones
     */
/*165*/     public Vector getPostCondiciones() {
/*166*/         Vector postCondiciones = new Vector();
/*167*/         for (int i = 0; i < this.tPostCondiciones.getRowCount(); i++) {
/*168*/             postCondiciones.add(this.tPostCondiciones.getValueAt(i, 2));
/*169*/         }
/*170*/         return postCondiciones;
/*171*/     }
/*172*/
/*173*/     //verificar si hay valores nulos
/*174*/     /**
     * Verificar si hay valores nulos en el vector de las postcondiciones
     * @return Valores del vector
     */
/*178*/     public boolean nulos() {
/*179*/         Vector v = new Vector();
                int aux;
/*180*/         for (int i = 0; i < this.tPostCondiciones.getRowCount(); i++) {
/*181*/             if (this.tPostCondiciones.getValueAt(i, 2).equals("")) {
/*182*/                 v.add(0, 1);
/*183*/                 v.add(1, i + 1);
/*184*/                 return false;
/*185*/             }
/*186*/         }
/*187*/         v.add(0, 0);
/*188*/         return true;
/*189*/     }
/*190*/
/*191*/     //verificar si hay celdas seleccionadas
/*192*/     /**
     * Verificar si hay celdas seleccionadas
     * @return Si hay celdas seleccionadas, retorna 1, caso contrario, 0.
     */
/*196*/     public int select() {
/*197*/         for (int i = 0; i < this.tPostCondiciones.getRowCount(); i++) {
/*198*/             if (this.tPostCondiciones.isCellSelected(i, 2)) {
/*199*/                 return 1;
/*200*/             }
/*201*/         }
/*202*/         return 0;
/*203*/     }

public void alerta(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "¡Advertencia!", JOptionPane.WARNING_MESSAGE);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tPostCondiciones = new javax.swing.JTable();
        LabelDescripcion = new javax.swing.JLabel();
        LabelSubtitulo = new javax.swing.JLabel();
        LabelTitulo = new javax.swing.JLabel();
        LaberInstruccion = new javax.swing.JLabel();

        setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tPostCondiciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Caso de Uso", "Post Condiciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tPostCondiciones.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tPostCondiciones.setCellSelectionEnabled(true);
        tPostCondiciones.setName("tPostCondiciones"); // NOI18N
        tPostCondiciones.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tPostCondiciones);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(proyectodetitulo.ProyectoDeTituloApp.class).getContext().getResourceMap(JPPostcondiciones.class);
        tPostCondiciones.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tPostCondiciones.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tPostCondiciones.columnModel.title0")); // NOI18N
        tPostCondiciones.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("tPostCondiciones.columnModel.title1")); // NOI18N

        LabelDescripcion.setText(resourceMap.getString("LabelDescripcion.text")); // NOI18N
        LabelDescripcion.setName("LabelDescripcion"); // NOI18N

        LabelSubtitulo.setFont(resourceMap.getFont("LabelSubtitulo.font")); // NOI18N
        LabelSubtitulo.setText(resourceMap.getString("LabelSubtitulo.text")); // NOI18N
        LabelSubtitulo.setName("LabelSubtitulo"); // NOI18N

        LabelTitulo.setFont(resourceMap.getFont("LabelTitulo.font")); // NOI18N
        LabelTitulo.setText(resourceMap.getString("LabelTitulo.text")); // NOI18N
        LabelTitulo.setName("LabelTitulo"); // NOI18N

        LaberInstruccion.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        LaberInstruccion.setIcon(resourceMap.getIcon("LaberInstruccion.icon")); // NOI18N
        LaberInstruccion.setText(resourceMap.getString("LaberInstruccion.text")); // NOI18N
        LaberInstruccion.setName("LaberInstruccion"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelSubtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                        .addComponent(LaberInstruccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                    .addComponent(LabelDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LabelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelSubtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LaberInstruccion, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

/*    public boolean Validar(JTable table,int fila, int columna) {
    String valor;
    if(table.getValueAt(fila,columna)==null)
    {
        System.out.println("Error, El valor es nulo");
        return false;
    }
    else
    {
        valor=(String)table.getValueAt(fila,columna);
        System.out.println("El valor no es nulo: "+valor);
        return true;
    }
}*/
    public void deshacer(){
        Vector postCondiciones = new Vector();
        postCondiciones = this.control.getPostCondiciones();
        for (int i = 0; i < this.tPostCondiciones.getRowCount(); i++) {
            if (this.tPostCondiciones.isCellSelected(i, 2)){
                this.tPostCondiciones.setValueAt(postCondiciones.get(i), i, 2);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelDescripcion;
    private javax.swing.JLabel LabelSubtitulo;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JLabel LaberInstruccion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tPostCondiciones;
    // End of variables declaration//GEN-END:variables

}
