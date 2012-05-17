/*1*/ package Vista;
/*2*/ 
/*3*/ import javax.swing.table.*;
/*4*/ import java.awt.*;
/*5*/ import java.util.*;
/*6*/ import javax.swing.JTable;
/*7*/ import javax.swing.JTextArea;
/*8*/ 
/*9*/ /**
       * ...
       * 
       */
/*13*/ public class TextAreaRenderer extends JTextArea
/*14*/         implements TableCellRenderer {
/*15*/ /**
        * estructura
        */
/*16*/     private final DefaultTableCellRenderer adaptee =
/*17*/             new DefaultTableCellRenderer();
/*18*/     /** map from table to map of rows to map of column heights */
/*19*/     private final Map cellSizes = new HashMap();
/*20*/ 
/*21*/     /**
           * Mapa de la tabla de mapa de filas al mapa de alturas de las columnas
           */
/*24*/     public TextAreaRenderer() {
/*25*/         setLineWrap(true);
/*26*/         setWrapStyleWord(true);
/*27*/         setRows(2);
/*28*/     }
/*29*/ 
/*30*/     /**
           *
           * @param table Tabla
           * @param obj
           * @param isSelected 0 si no es seleccionada, 1 si lo es.
           * @param hasFocus
           * @param row Fila de la tabla
           * @param column Columna de la tabla
           * @return La celda de la tabla seleccionada
           */
/*40*/     public Component getTableCellRendererComponent(//
/*41*/             JTable table, Object obj, boolean isSelected,
/*42*/             boolean hasFocus, int row, int column) {
/*43*/         // set the colours, etc. using the standard for that platform
/*44*/         adaptee.getTableCellRendererComponent(table, obj,
/*45*/                 isSelected, hasFocus, row, column);
/*46*/         setForeground(adaptee.getForeground());
/*47*/         setBackground(adaptee.getBackground());
/*48*/         setBorder(adaptee.getBorder());
/*49*/         setFont(adaptee.getFont());
/*50*/         setText(adaptee.getText());
/*51*/         // This line was very important to get it working with JDK1.4
/*52*/         TableColumnModel columnModel = table.getColumnModel();
/*53*/         setSize(columnModel.getColumn(column).getWidth(), 100000);
/*54*/         int height_wanted = (int) getPreferredSize().getHeight();
/*55*/         addSize(table, row, column, height_wanted);
/*56*/         height_wanted = findTotalMaximumRowSize(table, row);
/*57*/         if (height_wanted != table.getRowHeight(row)) {
/*58*/             table.setRowHeight(row, height_wanted);
/*59*/         }
/*60*/         return this;
/*61*/     }
/*62*/ 
/*63*/ //cambio de private a public
          /**
           *
           * @param table Tabla
           * @param row Fila de la tabla
           * @param column Columna de la tabla
           * @param height Ancho de la fila
           */
/*71*/     public void addSize(JTable table, int row, int column,
/*72*/             int height) {
/*73*/         Map rows = (Map) cellSizes.get(table);
/*74*/         if (rows == null) {
/*75*/             cellSizes.put(table, rows = new HashMap());
/*76*/         }
/*77*/         Map rowheights = (Map) rows.get(new Integer(row));
/*78*/         if (rowheights == null) {
/*79*/             rows.put(new Integer(row), rowheights = new HashMap());
/*80*/         }
/*81*/         rowheights.put(new Integer(column), new Integer(height));
/*82*/     }
/*83*/     
/*84*/       /**
           *
           * @param table Tabla
           * @param row Fila de la tabla
           * @return Ancho máximo de la fila
           */
/*90*/     private int findTotalMaximumRowSize(JTable table, int row) {
/*91*/         int maximum_height = 0;
/*92*/         Enumeration columns = table.getColumnModel().getColumns();
/*93*/         while (columns.hasMoreElements()) {
/*94*/             TableColumn tc = (TableColumn) columns.nextElement();
/*95*/             TableCellRenderer cellRenderer = tc.getCellRenderer();
/*96*/             if (cellRenderer instanceof TextAreaRenderer) {
/*97*/                 TextAreaRenderer tar = (TextAreaRenderer) cellRenderer;
/*98*/                 maximum_height = Math.max(maximum_height,
/*99*/                         tar.findMaximumRowSize(table, row));
/*100*/             }
/*101*/         }
/*102*/         return maximum_height;
/*103*/     }
/*104*/ 
/*105*/     /**
           *
           * @param table Tabla
           * @param row Fila de la tabla
           * @return Ancho máximo de la fila
           */
/*111*/     private int findMaximumRowSize(JTable table, int row) {
/*112*/         Map rows = (Map) cellSizes.get(table);
/*113*/         if (rows == null) {
/*114*/             return 0;
/*115*/         }
/*116*/         Map rowheights = (Map) rows.get(new Integer(row));
/*117*/         if (rowheights == null) {
/*118*/             return 0;
/*119*/         }
/*120*/         int maximum_height = 0;
/*121*/         for (Iterator it = rowheights.entrySet().iterator();
/*122*/                 it.hasNext();) {
/*123*/             Map.Entry entry = (Map.Entry) it.next();
/*124*/             int cellHeight = ((Integer) entry.getValue()).intValue();
/*125*/             maximum_height = Math.max(maximum_height, cellHeight);
/*126*/         }
/*127*/         return maximum_height;
/*128*/     }
/*129*/ }
