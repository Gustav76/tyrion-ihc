/*1*/ package Vista;
/*2*/ 
/*3*/ import java.awt.Component;
/*4*/ import java.awt.Dimension;
/*5*/ import javax.swing.JScrollPane;
/*6*/ import javax.swing.JTable;
/*7*/ import javax.swing.JTextArea;
/*8*/ import javax.swing.UIManager;
/*9*/ import javax.swing.border.EmptyBorder;
/*10*/ import javax.swing.table.TableCellRenderer;
/*11*/ /**
        * Clase establece la barra scroll de las tablas en edición.
        */
/*12*/ class ScrollableTextAreaRenderer extends JScrollPane implements TableCellRenderer {
/*13*/ 
/*14*/     JTextArea tarNotes;
/*15*/ 
/*16*/     ;
/*17*/

    /**
     *
     * @param table Tabla
     * @param tarInNotes
     * @param intColWidth Ancho de columna
     * @param intMaxScrollPane Panel de "scroll" máximo
     */


/*18*/     public ScrollableTextAreaRenderer(JTable table, JTextArea tarInNotes, int intColWidth, int intMaxScrollPane) {
/*19*/         super(tarInNotes);
/*20*/         tarNotes = tarInNotes;
/*21*/         setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
/*22*/         tarNotes.setLineWrap(true);
/*23*/         tarNotes.setWrapStyleWord(true);
/*24*/         tarNotes.setOpaque(true);
/*25*/         setPreferredSize(new Dimension(intColWidth + 10, intMaxScrollPane));
/*26*/     }
/*27*/

    /**
     *
     * @param table Tabla
     * @param value
     * @param isSelected 0 si es seleccionado, 1 si lo es.
     * @param hasFocus
     * @param row Fila de la tabla
     * @param column Columna de la tabla
     * @return La celda de la tabla seleccionada
     */

/*28*/     public Component getTableCellRendererComponent(JTable table, Object value,
/*29*/             boolean isSelected, boolean hasFocus, int row, int column) {
/*30*/         tarNotes.setText((value == null) ? "" : value.toString());
/*31*/         try {
/*32*/             tarNotes.setCaretPosition(1);
/*33*/         } catch (Exception expGen) {
/*34*/         }
/*35*/         if (hasFocus) {
/*36*/             setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
/*37*/         } else {
/*38*/             setBorder(new EmptyBorder(1, 1, 1, 1));
/*39*/         }
/*40*/         return this;
/*41*/     }
/*42*/ }
