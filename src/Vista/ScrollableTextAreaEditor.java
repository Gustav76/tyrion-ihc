/*1*/ package Vista;
/*2*/ 
/*3*/ import java.awt.Component;
/*4*/ import java.awt.Dimension;
/*5*/ import javax.swing.AbstractCellEditor;
/*6*/ import javax.swing.JScrollPane;
/*7*/ import javax.swing.JTable;
/*8*/ import javax.swing.JTextArea;
/*9*/ import javax.swing.table.TableCellEditor;
/*10*/ 
/*11*/ /**
        * Clase establece la barra scroll de las tablas en edición.
        */
/*15*/ class ScrollableTextAreaEditor extends AbstractCellEditor implements TableCellEditor {
/*16*/     JScrollPane spScroll;
/*17*/     JTextArea   tarNotes;
/*18*/ 
/*19*/         /**
                 *
                 * @param table tabla adquirida
                 * @param tarInNotes
                 * @param intColWidth Ancho de columna
                 * @param intMaxScrollPane Máximo de "scroll" en el panel (Llegada al final)
                 */
/*26*/     public ScrollableTextAreaEditor(JTable table,JTextArea tarInNotes,int intColWidth,int intMaxScrollPane) {
/*27*/         spScroll = new JScrollPane(tarInNotes);
/*28*/         tarNotes = tarInNotes;
/*29*/         spScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
/*30*/         tarNotes.setLineWrap(true);
/*31*/         tarNotes.setWrapStyleWord(true);
/*32*/         tarNotes.setOpaque(true);
/*33*/         tarNotes.setEditable(true);
/*34*/         spScroll.setPreferredSize(new Dimension(intColWidth+10, intMaxScrollPane));
/*35*/     }
/*36*/ 
/*37*/     /**
            *
            * @return
            */
/*41*/      public Object getCellEditorValue() {
/*42*/         return ((JTextArea)tarNotes).getText();
/*43*/      }
/*44*/ 
/*45*/      /**
              *
              * @param table Tabla
              * @param value
              * @param isSelected si es seleccionada o no una parte de la tabla
              * @param row Fila
              * @param column Columna
              * @return spScroll
              */
/*54*/     public Component getTableCellEditorComponent(JTable table, Object value,
/*55*/                     boolean isSelected, int row, int column) {
/*56*/         tarNotes.setText((value == null) ? "" : value.toString());
/*57*/         return spScroll;
/*58*/     }
/*59*/ 
/*60*/ }
