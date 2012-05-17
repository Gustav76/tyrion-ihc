/*1*/ package Vista;
/*2*/
/*3*/ import Controlador.ControladorDescripcion2;
/*4*/ import java.awt.Color;
/*5*/ import java.awt.event.WindowAdapter;
/*6*/ import java.awt.event.WindowEvent;
/*7*/ import java.io.File;
/*8*/ import java.util.Vector;
/*9*/ import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;


public class JPDescripcion2 extends javax.swing.JPanel {


    /*17*/     ControladorDescripcion2 control;
    public JPDescripcion2(ControladorDescripcion2 controlador) {
/*24*/         this.control = controlador;
/*25*/         //seteo de los datos de la tabla
/*26*/         initComponents();
/*27*/         this.setNomCU();
/*28*/         this.tAccionesUsuarioSistema.setEnabled(false);
/*29*/         this.setAcccionesUsuario();
/*30*/         this.setAccionesSistema();
/*56*/     }
/*57*/
/*62*/     public void setAcccionesUsuario() {
/*63*/         Vector accionesUsuario = new Vector();
/*64*/         accionesUsuario = this.control.getAccionesUsuario();
/*65*/         //this.setFilas(accionesUsuario.size());
/*66*/         for (int i = 0; i < accionesUsuario.size(); i++) {
/*67*/             this.tAccionesUsuarioSistema.setValueAt(accionesUsuario.get(i), i, 2);
                    Integer intObj = new Integer(i+1);   //agrega el numero a la fila
                          this.tAccionesUsuarioSistema.setValueAt(intObj, i, 0);
/*68*/             //this.tAccionesUsuarioSistema.setValueAt(, i, i);
/*69*/         }
/*70*/     }
/*71*/
/*76*/     public void setAccionesSistema() {
/*77*/         Vector accionesSistema = new Vector();
/*78*/         accionesSistema = this.control.getAccionesSistema();
/*79*/         for (int i = 0; i < accionesSistema.size(); i++) {
/*80*/             this.tAccionesUsuarioSistema.setValueAt(accionesSistema.get(i), i, 3);
/*81*/         }
/*82*/     }
/*83*/
/*88*/     public void setNomCU() {
/*89*/         Vector nomCU = new Vector();
/*90*/         nomCU = this.control.getNomCU();
/*91*/         this.setFilas(nomCU.size());
/*92*/         for (int i = 0; i < nomCU.size(); i++) {
/*93*/             this.tAccionesUsuarioSistema.setValueAt(nomCU.get(i), i, 1);
/*94*/         }
/*95*/     }
/*96*/
     /**
     * Seteo de las propiedades de la tabla
     * @param tam Cantidad de filas de la tabla
     */
/*102*/     public void setFilas(int tam) {
/*103*/         javax.swing.table.DefaultTableModel tabla = new javax.swing.table.DefaultTableModel(
/*104*/                 new Object[][]{
/*105*/                     {null, null, null},
/*106*/                     {null, null, null},
/*107*/                     {null, null, null},
/*108*/                     {null, null, null}
/*109*/                 },
/*110*/                 new String[]{
/*111*/                     "Número","Caso de Uso", "Acciones del Usuario", "Acciones del Sistema"
/*112*/                 });
/*113*/         tabla.setRowCount(tam);
/*114*/         tabla.setColumnCount(4);
/*115*/         this.tAccionesUsuarioSistema.setModel(tabla);
/*116*/         this.tAccionesUsuarioSistema.setShowGrid(true);
/*117*/         this.tAccionesUsuarioSistema.setGridColor(Color.black);
                TableColumn col= tAccionesUsuarioSistema.getColumn("Número");
                col.setMaxWidth(50);  
/*118*/     }
/*121*/         /**
     * Se obtienen las acciones del usuario
     * @return Vector de acciones del usuario
     */
/*125*/     public Vector getAccionesUsuario() {
/*126*/         Vector accionesUsuario = new Vector();
/*127*/         for (int i = 0; i < this.tAccionesUsuarioSistema.getRowCount(); i++) {
/*128*/             accionesUsuario.add(this.tAccionesUsuarioSistema.getValueAt(i, 2));
/*129*/         }
/*130*/         return accionesUsuario;
/*131*/     }
/*134*/         /**
     * Se obtienen las acciones del sistema
     * @return Vector de acciones del sistema
     */
/*138*/     public Vector getAccionesSistema() {
/*139*/         Vector accionesSistema = new Vector();
/*140*/         for (int i = 0; i < this.tAccionesUsuarioSistema.getRowCount(); i++) {
/*141*/             accionesSistema.add(this.tAccionesUsuarioSistema.getValueAt(i, 3));
/*142*/         }
/*143*/         return accionesSistema;
/*144*/     }
/*147*/         /**
     * Se obtienen los nombres de los casos de uso
     * @return Vector con los nombres de los casos de uso
     */
/*151*/     public Vector getNomCU() {
/*152*/         Vector nomCU = new Vector();
/*153*/         for (int i = 0; i < this.tAccionesUsuarioSistema.getRowCount(); i++) {
/*154*/             nomCU.add(this.tAccionesUsuarioSistema.getValueAt(i, 1));
/*155*/         }
/*156*/         return nomCU;
/*157*/     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tAccionesUsuarioSistema = new javax.swing.JTable();
        descripcion = new javax.swing.JLabel();
        tituloTabla = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();

        setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tAccionesUsuarioSistema.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Caso de Uso", "Acciones del Usuario", "Acciones del Sistema"
            }
        ));
        tAccionesUsuarioSistema.setName("tAccionesUsuarioSistema"); // NOI18N
        tAccionesUsuarioSistema.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tAccionesUsuarioSistema);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(proyectodetitulo.ProyectoDeTituloApp.class).getContext().getResourceMap(JPDescripcion2.class);
        tAccionesUsuarioSistema.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tAccionesUsuarioSistema.columnModel.title0")); // NOI18N
        tAccionesUsuarioSistema.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("tAccionesUsuarioSistema.columnModel.title1")); // NOI18N
        tAccionesUsuarioSistema.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("tAccionesUsuarioSistema.columnModel.title2")); // NOI18N

        descripcion.setText(resourceMap.getString("descripcion.text")); // NOI18N
        descripcion.setName("descripcion"); // NOI18N

        tituloTabla.setFont(resourceMap.getFont("tituloTabla.font")); // NOI18N
        tituloTabla.setText(resourceMap.getString("tituloTabla.text")); // NOI18N
        tituloTabla.setName("tituloTabla"); // NOI18N

        titulo.setFont(resourceMap.getFont("titulo.font")); // NOI18N
        titulo.setText(resourceMap.getString("titulo.text")); // NOI18N
        titulo.setName("titulo"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloTabla)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addComponent(titulo)
                    .addComponent(descripcion, 0, 0, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel descripcion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tAccionesUsuarioSistema;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel tituloTabla;
    // End of variables declaration//GEN-END:variables

}
