/*1*/ package Vista;
/*2*/
/*3*/ import Controlador.ControladorObtenerActores;
/*4*/ import java.awt.Color;
/*5*/ import java.awt.Point;
/*6*/ import java.awt.event.MouseEvent;
/*7*/ import java.awt.event.MouseMotionAdapter;
/*8*/ import java.awt.event.WindowAdapter;
/*9*/ import java.awt.event.WindowEvent;
/*10*/ import java.io.File;
/*11*/ import java.util.Vector;
/*12*/ import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
/*13*/
/*14*/ /**
        * Clase VistaObtenerActores genera la vista de obtencion de actores
        * a partir de clientes y realizadores (quinta vista).
        */
public class JPObtenerActores extends javax.swing.JPanel {

    /*20*/     ControladorObtenerActores control;
    /** Creates new form JPObtenerActores */
    public JPObtenerActores(ControladorObtenerActores controlador) {
/*27*/         this.control = controlador;
/*28*/         //seteo de datos en la tabla
/*29*/         initComponents();
/*30*/         this.setNomCU();
/*31*/         if (this.control.revisionAgentes() == 1) {
/*32*/             this.setClientes();
/*33*/             this.setRealizadores();
/*34*/         }
/*35*/         this.tActores.setEnabled(false);
/*36*/
/*37*/         //para visualizar el contenido de una celda al pasar el mouse por ella
/*38*/         this.tActores.addMouseMotionListener(new MouseMotionAdapter() {
/*39*/
/*40*/             @Override
/*41*/             public void mouseMoved(MouseEvent e) {
/*42*/                 Point p = e.getPoint();
/*43*/                 int row = tActores.rowAtPoint(p);
/*44*/                 int column = tActores.columnAtPoint(p);
                       if((!"null".equals(String.valueOf(tActores.getValueAt(row, column)))) && (!"[]".equals(String.valueOf(tActores.getValueAt(row, column))))){
                            tActores.setToolTipText(String.valueOf(tActores.getValueAt(row, column)));  
                        }
                       else{
/*45*/                      tActores.setToolTipText("Actor no definido");
                       }
/*46*/             }
/*47*/         });
/*74*/     }

/*80*/     public void setNomCU() {
/*81*/         Vector nomCU = new Vector();
/*82*/         nomCU = this.control.getNombreCasoUso();
/*83*/         this.setFilas(nomCU.size());
/*84*/         for (int i = 0; i < nomCU.size(); i++) {
/*85*/             this.tActores.setValueAt(nomCU.get(i), i, 1);
                    Integer intObj = new Integer(i+1);   //agrega el numero a la fila
                          this.tActores.setValueAt(intObj, i, 0);
/*86*/         }
/*87*/     }

/*93*/     public void setClientes() {
/*94*/         Vector clientes = new Vector();
/*95*/         clientes = (Vector) this.control.getClientes();
/*96*/         for (int i = 0; i < clientes.size(); i++) {
/*97*/             this.tActores.setValueAt(clientes.get(i), i, 2);
/*98*/         }
/*99*/     }

/*105*/     public void setRealizadores() {
/*106*/         Vector realizadores = new Vector();
/*107*/         realizadores = (Vector) this.control.getRealizadores();
/*108*/         for (int j = 0; j < realizadores.size(); j++) {
/*109*/             this.tActores.setValueAt(realizadores.get(j), j, 3);
/*110*/         }
/*111*/     }

      /**
     * Seteo de las propiedades de la tabla
     * @param tam Tamaño de las filas utilizadas
     */
/*118*/     public void setFilas(int tam) {
/*119*/         javax.swing.table.DefaultTableModel tabla = new javax.swing.table.DefaultTableModel(
/*120*/                 new Object[][]{
/*121*/                     {null, null, null}
/*122*/                 },
/*123*/                 new String[]{
/*124*/                     "Número","Caso de Uso", "Cliente", "Realizador"
/*125*/                 });
/*126*/         tabla.setRowCount(tam);
/*127*/         tabla.setColumnCount(4);
/*128*/         this.tActores.setModel(tabla);
/*129*/         this.tActores.getColumnModel().getColumn(2).setCellRenderer(new TextAreaRenderer());
/*130*/         this.tActores.getColumnModel().getColumn(3).setCellRenderer(new TextAreaRenderer());
/*131*/         this.tActores.setShowGrid(true);
/*132*/         this.tActores.setGridColor(Color.black);
                TableColumn col= tActores.getColumn("Número");
                col.setMaxWidth(50);
/*133*/     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tActores = new javax.swing.JTable();
        descripcion = new javax.swing.JLabel();
        tituloTabla = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        descripcion1 = new javax.swing.JLabel();

        setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tActores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Caso de Uso", "Cliente", "Realizador"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tActores.setName("tActores"); // NOI18N
        tActores.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tActores);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(proyectodetitulo.ProyectoDeTituloApp.class).getContext().getResourceMap(JPObtenerActores.class);
        descripcion.setText(resourceMap.getString("descripcion.text")); // NOI18N
        descripcion.setName("descripcion"); // NOI18N

        tituloTabla.setFont(resourceMap.getFont("tituloTabla.font")); // NOI18N
        tituloTabla.setText(resourceMap.getString("tituloTabla.text")); // NOI18N
        tituloTabla.setName("tituloTabla"); // NOI18N

        titulo.setFont(resourceMap.getFont("titulo.font")); // NOI18N
        titulo.setText(resourceMap.getString("titulo.text")); // NOI18N
        titulo.setName("titulo"); // NOI18N

        descripcion1.setText(resourceMap.getString("descripcion1.text")); // NOI18N
        descripcion1.setName("descripcion1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addComponent(titulo)
                    .addComponent(descripcion, javax.swing.GroupLayout.Alignment.TRAILING, 0, 426, Short.MAX_VALUE)
                    .addComponent(tituloTabla)
                    .addComponent(descripcion1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 426, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addGap(18, 18, 18)
                .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tituloTabla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descripcion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel descripcion;
    private javax.swing.JLabel descripcion1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tActores;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel tituloTabla;
    // End of variables declaration//GEN-END:variables

}
