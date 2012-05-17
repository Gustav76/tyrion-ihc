/*1*/ package Vista;
/*2*/ 
      import java.awt.Color;
/*3*/ import java.util.*;
/*4*/ import java.awt.Component;
/*5*/ import javax.swing.*;
/*6*/ import javax.swing.table.*;
/*7*/ 
/*8*/ /**
       * Clase que permite la edición de celdas de las tablas.
       */
/*12*/ public class MyTableCellEditor extends AbstractCellEditor implements TableCellEditor {
/*13*/     static final long serialVersionUID = 2;
/*14*/     DefaultCellEditor[][] cellEditors;
/*15*/     int row;
/*16*/     int column;
/*17*/ 
/*18*/         /**
                 * Define los realizadores por fila, bajo combobox
                 * @param rows filas de la tabla
                 * @param columns Columnas de la tabla
                 * @param clientes Clientes considerados en los casos de uso
                 * @param realizadores Realizadores considerados en los casos de uso
                 */
/*25*/     public MyTableCellEditor(int rows, int columns,Vector clientes,Vector realizadores) {
/*26*/         this.cellEditors = new DefaultCellEditor[rows][columns];
/*27*/
/*28*/         //Define the editors row by row
/*29*/         for(int setRow=0;setRow<rows;setRow++){
/*30*/             for(int setColumn=0;setColumn<columns;setColumn++){
/*31*/                 if(setColumn==2){
/*32*/                     JComboBox comboBox=new JComboBox((Vector)clientes.get(setRow));
                           // Cambia color a la celda que se esta editando al RBG (255,100,50)
                           comboBox.setBackground(Color.getHSBColor((float)0.04,(float) 0.3, 1));
                           comboBox.setOpaque(true);
/*33*/                     //Set a combo box
/*34*/                     cellEditors[setRow][setColumn] = new DefaultCellEditor(comboBox);
/*35*/                 }
/*36*/                 else{
/*37*/                     if(setColumn==3){
/*38*/                         JComboBox comboBox=new JComboBox((Vector)realizadores.get(setRow));
                               // Cambia color a la celda que se esta editando al RBG (255,100,50)
                               comboBox.setBackground(Color.getHSBColor((float)0.04,(float) 0.3, 1));
                               comboBox.setOpaque(true);
/*39*/                         //Set a combo box
/*40*/                         cellEditors[setRow][setColumn] = new DefaultCellEditor(comboBox);
/*41*/                     }else {
/*42*/                         cellEditors[setRow][setColumn] = null;
/*43*/                     }
/*44*/                 }
/*45*/             }
/*46*/         }
/*47*/     }
/*48*/ 
/*49*/         /**
                 *
                 * @param table tabla completa
                 * @param value
                 * @param isSelected fila y columna seleccionada, en caso de que sea seleccionada
                 * @param row Fila de la tabla
                 * @param column Columna de la tabla
                 * @return Fila y columna obtenida
                 */
/*58*/     public Component getTableCellEditorComponent(JTable table, Object value,boolean isSelected, int row, int column) {
/*59*/         this.row = row;
/*60*/         this.column = column;
/*61*/         return cellEditors[row][column].getTableCellEditorComponent(table, "",isSelected, row, column);
/*62*/     }
/*63*/ 
/*64*/         /**
                 * Devuelve un valor de acuerdo con el componente
                 * @return el elemento seleccionado, de existir, o nulo
                 */
/*68*/     public Object getCellEditorValue() {
/*69*/         //Retrun a value according to the component
/*70*/         if ( cellEditors[row][column].getComponent() instanceof JComboBox ){
/*71*/             JComboBox c = (JComboBox)cellEditors[row][column].getComponent();
/*72*/             return c.getSelectedItem();
/*73*/         } else
/*74*/             if ( cellEditors[row][column].getComponent() instanceof JCheckBox ){
/*75*/                 JCheckBox c = (JCheckBox)cellEditors[row][column].getComponent();
/*76*/                 return c.isSelected();
/*77*/             }
/*78*/             return null;
/*79*/     }
/*80*/ }
