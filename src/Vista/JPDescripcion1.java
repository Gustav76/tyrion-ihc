/*1*/ package Vista;
/*2*/
/*3*/ import Controlador.ControladorDescripcion1;
/*4*/ import java.awt.Color;
import java.awt.Component;
/*5*/ import java.awt.event.WindowAdapter;
/*6*/ import java.awt.event.WindowEvent;
/*7*/ import java.io.File;
import java.util.HashSet;
import java.util.Set;
/*8*/ import java.util.Vector;
/*9*/ import javax.swing.JOptionPane;
import javax.swing.JPopupMenu.Separator;
import javax.swing.JTable;
/*10*/ import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
/*11*/ import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
/*12*/


public class JPDescripcion1 extends javax.swing.JPanel {

/*19*/     ControladorDescripcion1 control;
/*20*/     Vector filas = new Vector();
/*21*/     Vector columnas = new Vector();
/*22*/     Vector editorsC = new Vector();
/*23*/     Vector editorsR = new Vector();
           RenderTabla miRender;
/*24*/

    /** Creates new form JPDescripcion1 */
    public JPDescripcion1(ControladorDescripcion1 controlador) {
/*30*/         this.control = controlador;
/*31*/         //seteo de datos de la tabla
/*32*/         initComponents();
/*33*/         this.setTareasCU();
      
/*34*/         //this.bContinuar.setEnabled(false);
/*35*/         if (this.control.getActoresCU() != null) {
/*36*/            // this.bContinuar.setEnabled(true);
                   //control.controlMain.getVista().setforwardEnable(); // <- nuevo
/*37*/             this.setClientes();
/*38*/             this.setRealizadores();
/*39*/         }
/*66*/     }
/*69*/         /**
             * Setea los clientes de una sesión anterior en la tabla
             */
/*72*/     public void setClientes() {
/*73*/         Vector c = this.control.getClientesD1();
/*74*/         for (int i = 0; i < c.size(); i++) {
/*75*/             this.tTareasPorCasoDeUso.setValueAt(c.get(i), i, 2);
/*76*/         }
/*77*/     }
/*78*/
/*79*/     //seteo de los realizadores de una sesion anterior en la tabla
/*80*/         /**
             * seteo de los realizadores de una sesion anterior en la tabla
             */
/*83*/     public void setRealizadores() {
/*84*/         Vector r = this.control.getRealizadoresD1();
/*85*/         for (int i = 0; i < r.size(); i++) {
/*86*/             this.tTareasPorCasoDeUso.setValueAt(r.get(i), i, 3);
/*87*/         }
/*88*/     }
/*89*/
/*91*/         /**
             * seteo de las tareas por casos de uso de una sesion anterior
             */
/*94*/     public void setTareasCU() {
/*95*/         Vector tareas = new Vector();
/*96*/         Vector nomCU = new Vector();
/*97*/         tareas = this.control.getTareas();
/*98*/         nomCU = this.control.getNomCU();
/*99*/         this.setFilas(this.getTam(tareas));
/*100*/         int pos = 0;
/*101*/         for (int i = 0; i < tareas.size(); i++) {
/*102*/             Vector v = (Vector) tareas.get(i);
/*103*/             for (int j = 0; j < v.size(); j++) {
/*104*/                 this.tTareasPorCasoDeUso.setValueAt(nomCU.get(i), pos, 1);
/*105*/                 this.tTareasPorCasoDeUso.setValueAt(v.get(j), pos, 4);
                          Integer intObj = new Integer(pos+1);   //agrega el numero a la fila
                          this.tTareasPorCasoDeUso.setValueAt(intObj, pos, 0);
/*76*/        
/*106*/                 pos++;
/*107*/             }
//                    this.tTareasPorCasoDeUso.setValueAt("", pos, 0);
/*108*/         }
/*109*/         this.tTareasPorCasoDeUso.getColumn("Cliente").setCellEditor(new MyTableCellEditor(this.tTareasPorCasoDeUso.getRowCount(), this.tTareasPorCasoDeUso.getColumnCount(), editorsC, editorsR));
/*110*/         this.tTareasPorCasoDeUso.getColumn("Realizador").setCellEditor(new MyTableCellEditor(this.tTareasPorCasoDeUso.getRowCount(), this.tTareasPorCasoDeUso.getColumnCount(), editorsC, editorsR));
/*111*/     }
/*114*/         /**
                 * obtencion del tamaño de la tabla
                 * @param tareas vector que contiene las tareas
                 * @return tamaño del vector de tareas
                 */
/*119*/     public int getTam(Vector tareas) {
/*120*/         int tam = 0;
/*121*/         for (int i = 0; i < tareas.size(); i++) {
/*122*/             Vector v = (Vector) tareas.get(i);
/*123*/             tam = v.size() + tam;
/*124*/         }
/*125*/         return tam;
/*126*/     }
/*129*/         /**
                 * seteo de la seleccion de cliente y realizador
                 */
/*132*/     public void setEditor() {
/*133*/         Vector actores = this.control.getActores();
/*134*/         Vector tareas = this.control.getTareas();
/*135*/         for (int i = 0; i < tareas.size(); i++) {
/*136*/             Vector v = (Vector) tareas.get(i);
/*137*/             for (int j = 0; j < v.size(); j++) {
/*138*/                 Vector aux = (Vector) actores.get(i);
/*139*/                 editorsC.add(aux);
/*140*/                 editorsR.add(aux);
/*141*/             }
/*142*/         }
/*143*/     }
/*146*/         /**
                 * seteo de las propiedades de la tabla
                 * @param tam cantidad de filas
                 */
/*150*/     public void setFilas(int tam) {
/*151*/         this.setEditor();
/*152*/
/*153*/         DefaultTableModel tabla = new MyTableModel(new Object[][]{},
/*154*/                 new String[]{
/*155*/                    "Número", "Caso de Uso", "Cliente", "Realizador", "Tareas"
/*156*/                 });
/*157*/         tabla.setRowCount(tam);
/*158*/         tabla.setColumnCount(5);
/*159*/         this.tTareasPorCasoDeUso.setModel(tabla);
/*160*/      //   this.tTareasPorCasoDeUso.getColumnModel().getColumn(0).setCellRenderer(new TextAreaRenderer());
                TableColumn col= tTareasPorCasoDeUso.getColumn("Número");
                col.setMaxWidth(50);
                         
                this.tTareasPorCasoDeUso.getColumnModel().getColumn(1).setCellRenderer(new TextAreaRenderer());
/*161*/         this.tTareasPorCasoDeUso.getColumnModel().getColumn(2).setCellRenderer(new TextAreaRenderer());
/*162*/         this.tTareasPorCasoDeUso.getColumnModel().getColumn(3).setCellRenderer(new TextAreaRenderer());
/*163*/         this.tTareasPorCasoDeUso.getColumnModel().getColumn(4).setCellRenderer(new TextAreaRenderer());
/*164*/         this.tTareasPorCasoDeUso.setShowGrid(true);
/*165*/         this.tTareasPorCasoDeUso.setGridColor(Color.black);
/*166*/     }
/*167*/
/*168*/         /**
                 * clase para generar tabla
                 */
/*171*/     class MyTableModel extends DefaultTableModel {
/*172*/
/*173*/         public MyTableModel(Object[][] data, Object[] columnNames) {
/*174*/             super(data, columnNames);
/*175*/         }
/*176*/
/*177*/             /**
                     * El método esblece la posibilidad de edición de la tabla
                     * @param row filas de la tabla
                     * @param col columnas de la tabla
                     * @return valor booleano true o false
                     */
/*183*/         @Override
/*184*/         public boolean isCellEditable(int row, int col) {
/*185*/             if (col == 1 || col == 4 || col == 0) {
/*186*/                 return false;
/*187*/             } else {
/*188*/                 return true;
/*189*/             }
/*190*/         }

        /*
         * Método que sobreescribe al por defecto, permitiendo añadir "Sistema"
         * a la columna Cliente al editar Realizador o viceversa.
         * @param value Dato a ingresar a la tabla
         * @param row Fila donde se ingresara el dato
         * @param col Columna donde se ingresara el dato
         */
                @Override
                public void setValueAt(Object value, int row, int col) {
                    super.setValueAt(value, row, col);
                    if (!(value.toString().equals("Sistema"))){
                        if (col == 2 /*&& getValueAt(row, col+1) == null*/)
                            super.setValueAt("Sistema", row, 3);
                        else if(col==3 /*&& getValueAt(row, col-1) == null*/)
                            super.setValueAt("Sistema", row, 2);
                    }
                    else{
                        if (col==2 /*&& getValueAt(row, col+1) == null*/)
                            super.setValueAt("", row, 3);
                        else if (col==3 /*&& getValueAt(row, col-1) == null*/)
                            super.setValueAt("", row, 2);
                    }
                }
/*191*/     }
/*192*/

/**
 * Clase que permite determinar como se dibuja la tabla, poniendole color si se edita
 */      
class RenderTabla extends DefaultTableCellRenderer{

      Set<Integer> highlightedRows = new HashSet<Integer>();
 
     /** 
      *  Retorna el componente usado para dibujar la celda. Este método es
      *  usado para configurar el renderer apropiadamente antes de dibujar.
      *
      * @param	table	La JTable que se desea dibujar; puede ser nulo
      * @param	value	El valor de la celda a ser dibujada. Es trabajo del renderer
      * 		interpretar y dibujar el valor.
      * @param	isSelected	Booleano que indica si la celda esta siendo seleccionada
      * @param	hasFocus	Si es verdadero para dibujar la celda apropiadamente
      * @param	row	El indice de la fila siendo dibujada. los titulos tienen valor -1
      * @param	column	El indice de la columna siendo dibujada
      * 
      */
  @Override
  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
      Color HIGHLIGHT = Color.getHSBColor((float)0.17,(float)0.55, 1);
      super.getTableCellRendererComponent(table, value,isSelected, hasFocus, row, column);
      setBackground(highlightedRows.contains(row)
              ? HIGHLIGHT
              : isSelected
              ? table.getSelectionBackground()
              : table.getBackground());
      return this;
  }
 /**
   * Metodo que determina la fila a ser pintada de color.
   * @param row Fila a ser pintada de color
   */
  public void setHighlighted(Integer row) {
      highlightedRows.clear();
      highlightedRows.add(row);
  }
 /**
   * Metodo que indica si la fila ya esta pintada de color
   * @param row Entero que indica la fila de la tabla.
   * @return Si esta pintada
   */
  public boolean isHighlighted(Integer row) {
    return highlightedRows.contains(row);
  }
}

/*193*/     //obtener los clientes seleccionados
/*194*/         /**
             * obtener los clientes seleccionados
             * @return Vector con clientes
             */
/*198*/     public Vector getClientes() {
/*199*/         Vector clientes = new Vector();
/*200*/         for (int i = 0; i < this.tTareasPorCasoDeUso.getRowCount(); i++) {
/*201*/             clientes.add(this.tTareasPorCasoDeUso.getValueAt(i, 2));
/*202*/         }
/*203*/         return clientes;
/*204*/     }
/*205*/
/*206*/     //obtener los realizadores seleccionados
/*207*/         /**
                 * obtener los realizadores seleccionados
                 * @return  Vector con realizadores
                 */
/*211*/     public Vector getRealizadores() {
/*212*/         Vector realizadores = new Vector();
/*213*/         for (int i = 0; i < this.tTareasPorCasoDeUso.getRowCount(); i++) {
/*214*/             //System.out.println(this.tTareasPorCasoDeUso.getColumnModel().getColumn(2).getCellEditor().getCellEditorValue());
/*215*/             realizadores.add(this.tTareasPorCasoDeUso.getValueAt(i, 3));
/*216*/         }
/*217*/         return realizadores;
/*218*/     }
/*219*/
/*220*/     //obtener las tareas por caso de uso
/*221*/         /**
                 * obtener las tareas por caso de uso
                 * @return Vector con tareas
                 */
/*225*/     public Vector getTareas() {
/*226*/         Vector tareas = new Vector();
/*227*/         for (int i = 0; i < this.tTareasPorCasoDeUso.getRowCount(); i++) {
/*228*/             tareas.add(this.tTareasPorCasoDeUso.getValueAt(i, 4));
/*229*/         }
/*230*/         return tareas;
/*231*/     }
/*232*/
/*233*/
/*234*/              /**
     * Obtener los nombres de los casos de uso
     * @return Vector con nombres de los casos de uso
     */
/*238*/     public Vector getNomCU() {
/*239*/         Vector nomCU = new Vector();
/*240*/         for (int i = 0; i < this.tTareasPorCasoDeUso.getRowCount(); i++) {
/*241*/             nomCU.add(this.tTareasPorCasoDeUso.getValueAt(i, 1));
/*242*/         }
/*243*/         return nomCU;
/*244*/     }
/*245*/
/*246*/     //verificacion si hay actores iguales en una misma tarea
/*247*/       /**
                 * verificacion si hay actores iguales en una misma tarea
                 * @return Vector
                 */
/*251*/     public Vector iguales() {    //agrege el if y else
/*252*/         Vector iguales = new Vector();
/*253*/         Vector clientes = this.getClientes();
/*254*/         Vector realizadores = this.getRealizadores();
                if(clientes.get(1) == null){
                    System.out.println("--------" + clientes);
                }else{
/*255*/         for (int i = 0; i < clientes.size(); i++) { 
/*256*/             if (clientes.get(i).toString().equals(realizadores.get(i).toString())) { // aca son nulas
/*257*/                 iguales.add(0, 1);
/*258*/                 iguales.add(1, i + 1);
/*259*/                 return iguales;
/*260*/             }
/*261*/         }}
/*262*/         iguales.add(0, 0);
/*263*/         return iguales;
/*264*/     }
/*265*/
/*266*/     //verificar que uno de los actores de las tareas sea el sistema
/*267*/         /**
     * verificar que uno de los actores de las tareas sea el sistema
     * @return
     */
/*271*/     public Vector chekSistema() {
/*272*/         Vector chek = new Vector();
/*273*/         Vector clientes = this.getClientes();
/*274*/         Vector realizadores = this.getRealizadores();
/*275*/         int resp = 0;
                if(clientes.get(1) == null){    //agrege el if y else
                    System.out.println("--------" + clientes);
                }else{
/*276*/         for (int i = 0; i < clientes.size(); i++) {
/*277*/             if (clientes.get(i).toString().equals("Sistema")) {
/*278*/                 if (realizadores.get(i).toString().equals("Sistema")) {
/*279*/                     chek.add(0, 1);
/*280*/                     chek.add(1, i + 1);
/*281*/                     return chek;
/*282*/                 }
/*283*/
/*284*/             } else {
/*285*/                 if (realizadores.get(i).toString().equals("Sistema")) {
/*286*/                 } else {
/*287*/                     chek.add(0, 1);
/*288*/                     chek.add(1, i + 1);
/*289*/                     return chek;
/*290*/                 }
/*291*/             }
/*292*/         }}
/*293*/         chek.add(0, 0);
/*294*/         return chek;
/*295*/     }
/*296*/
/*297*/     //verificar que no hay celdas nulas
/*298*/         /**
                 * verificar que no hay celdas nulas
                 * @return 1 si hay celdas nulas, 0 en caso contrario
                 */
/*302*/     public int nulos() {
/*303*/
/*304*/         for (int i = 0; i < this.tTareasPorCasoDeUso.getRowCount(); i++) {
/*305*/             if (this.tTareasPorCasoDeUso.getValueAt(i, 2) == null || this.tTareasPorCasoDeUso.getValueAt(i, 2).toString().equals("")) {
/*306*/                 return 1;
/*307*/             }
/*308*/             if (this.tTareasPorCasoDeUso.getValueAt(i, 3) == null || this.tTareasPorCasoDeUso.getValueAt(i, 3).toString().equals("")) {
/*309*/                 return 1;
/*310*/             }
/*311*/         }
/*312*/         return 0;
/*313*/     }
/*314*/
/*315*/     //se debe validar que se escoja los mismos usuarios a lo largo de las tareas
/*316*/         /**
                 * se debe validar que se escoja los mismos usuarios a lo largo de las tareas
                 * @return Vector con selecciones validadas
                 */
/*320*/     public Vector validarSeleccionCombo() {
/*321*/         String aux = null;
/*322*/         Vector validacion = new Vector();
/*323*/         for (int i = 1; i < this.tTareasPorCasoDeUso.getRowCount(); i++) {
/*324*/             if (this.tTareasPorCasoDeUso.getValueAt(i, 1).toString().equals(this.tTareasPorCasoDeUso.getValueAt(i - 1, 1).toString())) {
/*325*/                 if (!this.tTareasPorCasoDeUso.getValueAt(i - 1, 2).toString().equals("Sistema")) {
/*326*/                     aux = this.tTareasPorCasoDeUso.getValueAt(i - 1, 2).toString();
/*327*/                 }
/*328*/                 if (!this.tTareasPorCasoDeUso.getValueAt(i - 1, 3).toString().equals("Sistema")) {
/*329*/                     aux = this.tTareasPorCasoDeUso.getValueAt(i - 1, 3).toString();
/*330*/                 }
/*331*/                 if (!this.tTareasPorCasoDeUso.getValueAt(i, 2).toString().equals("Sistema")) {
/*332*/                     if (!this.tTareasPorCasoDeUso.getValueAt(i, 2).toString().equals(aux)) {
/*333*/                         validacion.add(0, 1);
/*334*/                         validacion.add(1, i + 1);
                                validacion.add(2, 2);
/*335*/                         return validacion;
/*336*/                     }
/*337*/                 }
/*338*/                 if (!this.tTareasPorCasoDeUso.getValueAt(i, 3).toString().equals("Sistema")) {
/*339*/                     if (!this.tTareasPorCasoDeUso.getValueAt(i, 3).toString().equals(aux)) {
/*340*/                         validacion.add(0, 1);
/*341*/                         validacion.add(1, i + 1);
                                validacion.add(2, 3);
/*342*/                         return validacion;
/*343*/                     }
/*344*/                 }
/*345*/             }
/*346*/         }
/*347*/         validacion.add(0, 0);
/*348*/         return validacion;
/*349*/     }
/*350*/
/*351*/     //si un cliente esta seleccionado
/*352*/         /**
                 * si un cliente esta seleccionado
                 * @return 1 si el cliente esta seleccionado, 0 en caso contrario
                 */
/*356*/     public int selectC() {
/*357*/         for (int i = 0; i < this.tTareasPorCasoDeUso.getRowCount(); i++) {
/*358*/             if (this.tTareasPorCasoDeUso.isCellSelected(i, 2)) {
/*359*/                 return 1;
/*360*/             }
/*361*/         }
/*362*/         return 0;
/*363*/     }
/*364*/
/*365*/     //si un relizador esta seleccionado
/*366*/         /**
                 * si un relizador esta seleccionado
                 * @return 1 si el realizador esta seleccionado, 0 en caso contrario
                 */
/*370*/     public int selectR() {
/*371*/         for (int i = 0; i < this.tTareasPorCasoDeUso.getRowCount(); i++) {
/*372*/             if (this.tTareasPorCasoDeUso.isCellSelected(i, 3)) {
/*373*/                 return 1;
/*374*/             }
/*375*/         }
/*376*/         return 0;
/*377*/     }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tabla = new javax.swing.JScrollPane();
        tTareasPorCasoDeUso = new javax.swing.JTable();
        LabelDescripción = new javax.swing.JLabel();
        LabelDescripcionDeCasosDeUso = new javax.swing.JLabel();
        LabelTitulo = new javax.swing.JLabel();

        setEnabled(false);
        setName("Form"); // NOI18N

        Tabla.setName("Tabla"); // NOI18N

        tTareasPorCasoDeUso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Caso de Uso", "Cliente", "Realizador", "Tareas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tTareasPorCasoDeUso.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tTareasPorCasoDeUso.setCellSelectionEnabled(true);
        tTareasPorCasoDeUso.setName("tTareasPorCasoDeUso"); // NOI18N
        tTareasPorCasoDeUso.getTableHeader().setReorderingAllowed(false);
        tTareasPorCasoDeUso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tTareasPorCasoDeUsoMouseClicked(evt);
            }
        });
        tTareasPorCasoDeUso.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tTareasPorCasoDeUsoMouseMoved(evt);
            }
        });
        tTareasPorCasoDeUso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tTareasPorCasoDeUsoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tTareasPorCasoDeUsoKeyTyped(evt);
            }
        });
        Tabla.setViewportView(tTareasPorCasoDeUso);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(proyectodetitulo.ProyectoDeTituloApp.class).getContext().getResourceMap(JPDescripcion1.class);
        tTareasPorCasoDeUso.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tTareasPorCasoDeUso.getColumnModel().getColumn(0).setResizable(false);
        tTareasPorCasoDeUso.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tTareasPorCasoDeUso.columnModel.title0")); // NOI18N
        tTareasPorCasoDeUso.getColumnModel().getColumn(1).setResizable(false);
        tTareasPorCasoDeUso.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("tTareasPorCasoDeUso.columnModel.title1")); // NOI18N
        tTareasPorCasoDeUso.getColumnModel().getColumn(2).setResizable(false);
        tTareasPorCasoDeUso.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("tTareasPorCasoDeUso.columnModel.title2")); // NOI18N
        tTareasPorCasoDeUso.getColumnModel().getColumn(3).setResizable(false);
        tTareasPorCasoDeUso.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("tTareasPorCasoDeUso.columnModel.title3")); // NOI18N
        tTareasPorCasoDeUso.getColumnModel().getColumn(4).setResizable(false);
        tTareasPorCasoDeUso.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("tTareasPorCasoDeUso.columnModel.title4")); // NOI18N

        LabelDescripción.setText(resourceMap.getString("LabelDescripción.text")); // NOI18N
        LabelDescripción.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        LabelDescripción.setName("LabelDescripción"); // NOI18N

        LabelDescripcionDeCasosDeUso.setFont(resourceMap.getFont("LabelDescripcionDeCasosDeUso.font")); // NOI18N
        LabelDescripcionDeCasosDeUso.setText(resourceMap.getString("LabelDescripcionDeCasosDeUso.text")); // NOI18N
        LabelDescripcionDeCasosDeUso.setName("LabelDescripcionDeCasosDeUso"); // NOI18N

        LabelTitulo.setFont(resourceMap.getFont("LabelTitulo.font")); // NOI18N
        LabelTitulo.setText(resourceMap.getString("LabelTitulo.text")); // NOI18N
        LabelTitulo.setName("LabelTitulo"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Tabla, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addComponent(LabelDescripción, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addComponent(LabelDescripcionDeCasosDeUso, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelTitulo, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LabelDescripción, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LabelDescripcionDeCasosDeUso, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tabla, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Evento que permite cambiar el color de la fila seleccionada
     * @param evt   Movimiento del mouse dentro de la tabla
     */
    private void tTareasPorCasoDeUsoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tTareasPorCasoDeUsoMouseMoved
        // TODO add your handling code here:
    /*    int row=this.tTareasPorCasoDeUso.getSelectedRow();
        if (!miRender.isHighlighted(row)){
            miRender.setHighlighted(row);
            this.tTareasPorCasoDeUso.repaint();
        }*/
    }//GEN-LAST:event_tTareasPorCasoDeUsoMouseMoved

    private void tTareasPorCasoDeUsoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tTareasPorCasoDeUsoMouseClicked
        // TODO add your handling code here:
        int fila = this.tTareasPorCasoDeUso.getSelectedRow();
        for (int i = 0; i < this.tTareasPorCasoDeUso.getColumnCount(); i++) {
            this.tTareasPorCasoDeUso.changeSelection(fila, i, true, true);    
        }
        
    }//GEN-LAST:event_tTareasPorCasoDeUsoMouseClicked

    private void tTareasPorCasoDeUsoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tTareasPorCasoDeUsoKeyPressed
        // TODO add your handling code here:
        /*int fila = this.tTareasPorCasoDeUso.getSelectedRow();
        for (int i = 0; i < this.tTareasPorCasoDeUso.getColumnCount(); i++) {
            this.tTareasPorCasoDeUso.changeSelection(fila, i, true, true);    
        }*/
    }//GEN-LAST:event_tTareasPorCasoDeUsoKeyPressed

    private void tTareasPorCasoDeUsoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tTareasPorCasoDeUsoKeyTyped
        // TODO add your handling code here:
        /*int fila = this.tTareasPorCasoDeUso.getSelectedRow();
        for (int i = 0; i < this.tTareasPorCasoDeUso.getColumnCount(); i++) {
            this.tTareasPorCasoDeUso.changeSelection(fila, i, true, true);    
        }*/
    }//GEN-LAST:event_tTareasPorCasoDeUsoKeyTyped

    public void setActores()
    {
                /*767*/         if (this.selectC() == 1 || this.selectR() == 1) {
            /*768*/             this.tTareasPorCasoDeUso.setValueAt(this.tTareasPorCasoDeUso.getColumnModel().getColumn(this.tTareasPorCasoDeUso.getSelectedColumn()).getCellEditor().getCellEditorValue(), this.tTareasPorCasoDeUso.getSelectedRow(), this.tTareasPorCasoDeUso.getSelectedColumn());
            /*769*/         }
    }
    public void alerta(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje, "¡Advertencia!", JOptionPane.WARNING_MESSAGE);
    }


public void validandoTabla(){
    /*766*/         //si hay un cliente o un realizador seleccionado, se asigna dicho actor a la celda
/*767*/         if (this.selectC() == 1 || this.selectR() == 1) {
    /*768*/             this.tTareasPorCasoDeUso.setValueAt(this.tTareasPorCasoDeUso.getColumnModel().getColumn(this.tTareasPorCasoDeUso.getSelectedColumn()).getCellEditor().getCellEditorValue(), this.tTareasPorCasoDeUso.getSelectedRow(), this.tTareasPorCasoDeUso.getSelectedColumn());
    /*769*/     }
/*770*/         //si no hay actores iguales
/*771*/         if (((Integer) this.iguales().get(0)) == 0) {
                        control.valido = true;
    /*772*/             //si uno de los actores es el sistema
    /*773*/             if (((Integer) this.chekSistema().get(0)) == 0) {
                                control.valido = true;
        /*774*/                 //si los actores por tareas de un caso de uso son iguales
        /*775*/                 if (Integer.parseInt(this.validarSeleccionCombo().get(0).toString()) == 0) {
            /*776*/                 //se guardan los datos
            /*777*/                 this.control.setDatosD2(this.getClientes(), this.getRealizadores(), this.getNomCU(), this.getTareas());
            /*778*/                 this.control.setActoresCU(this.getNomCU(), this.getClientes(), this.getRealizadores());
            /*779*/                 //se va al paso siguiente correspondiente a obtener descripcion paso 2
            /*780*/                 this.control.irControladorDescripcion2();
                                    control.valido = true;
            /*781*/             } else {
                                        control.valido = false;
            /*782*/                     JOptionPane.showMessageDialog(null, "Error fila " + this.validarSeleccionCombo().get(1) + ", " +
                                            ((this.validarSeleccionCombo().get(2).toString().equals("2"))? "columna Cliente": ((this.validarSeleccionCombo().get(2).toString().equals("3"))? "columna Realizador" : "")) + 
                                            ".\r\nEl Actor debe ser el mismo en todas las tareas del caso de uso", "¡Error!", JOptionPane.ERROR_MESSAGE);
            /*783*/                 }
        /*784*/             } else {
                                control.valido = false;
        /*785*/                 JOptionPane.showMessageDialog(null, "Error fila " + this.chekSistema().get(1) + ". Cliente o Realizador debe ser el Sistema", "¡Error!", JOptionPane.ERROR_MESSAGE);
        /*786*/             }
/*787*/         } else {
                    control.valido = false;
/*788*/             JOptionPane.showMessageDialog(null, "Error fila " + (this.iguales().get(1)) + ". Cliente y Realizador iguales en una misma tarea.\r\nCambie el cliente o realizador", "¡Error!", JOptionPane.ERROR_MESSAGE);
/*789*/         }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelDescripcionDeCasosDeUso;
    private javax.swing.JLabel LabelDescripción;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JScrollPane Tabla;
    private javax.swing.JTable tTareasPorCasoDeUso;
    // End of variables declaration//GEN-END:variables

}
