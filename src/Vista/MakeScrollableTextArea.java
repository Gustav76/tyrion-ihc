/*1*/ package Vista;
/*2*/ 
/*3*/ import javax.swing.JTable;
/*4*/ import javax.swing.JTextArea;
/*5*/ import javax.swing.table.TableColumn;
/*6*/ 
/*7*/ /**
       * Clase que genera de forma dinámica las tablas
       * que aparecen en las vistas
       */
/*11*/ class MakeScrollableTextArea {
/*12*/     JTable table;
/*13*/     TableColumn tableColumn;
/*14*/     JTextArea tarNotes;
/*15*/ 
/*16*/         /**
     * Hacer un textarea "scrollable"
     * @param table Tabla
     * @param tableColumn Columna de una tabla, la cual puede ser editada
     * @param intColWidth Ancho de una columna
     * @param intRowHeight Alto de una fila
     * @param intMaxScrollPane Tope de scroll
     */
/*24*/     public MakeScrollableTextArea(JTable table,TableColumn tableColumn,
/*25*/                                  int intColWidth,int intRowHeight,int intMaxScrollPane) {
/*26*/       this.table = table;
/*27*/       this.tableColumn = tableColumn;
/*28*/       this.tableColumn.setCellRenderer(new ScrollableTextAreaRenderer(table,new JTextArea(),intColWidth,intMaxScrollPane));
/*29*/       this.tableColumn.setCellEditor(new ScrollableTextAreaEditor(table,new JTextArea(),intColWidth,intMaxScrollPane));
/*30*/       this.table.setRowHeight(intRowHeight);
/*31*/     }
/*32*/ }
/*33*/ 
/*34*/ 
