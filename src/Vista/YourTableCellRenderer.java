/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Poka
 */
import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;
/**
 * Clase que extiende las funcionalidades de getTableCellRendererCOmponent con el fin de aplicar nuevas modificacionoes a tablas especificas.
 * 
 */
public class YourTableCellRenderer
       extends DefaultTableCellRenderer {
    /**
     * Funcion que retorna un componente de tabla con los cabios definidos dentro del método, aplicados
     * @param table
     * @param value
     * @param isSelected
     * @param hasFocus
     * @param row
     * @param column
     * @return Component
     */
  public Component getTableCellRendererComponent(JTable table,
                                                 Object value,
                                                 boolean isSelected,
                                                 boolean hasFocus,
                                                 int row,
                                                 int column) {
    Component c = super.getTableCellRendererComponent(table, value,isSelected, hasFocus,row, column);
    Font fuente1=new Font("Tahoma", Font.ITALIC, 11);
    Font fuente=new Font("Tahoma", Font.BOLD, 11);
    // Only for specific cell
    if (row == 5 && column == 2) {

     c.setFont(fuente);
       // you may want to address isSelected here too
       c.setForeground(Color.BLACK);
    }else{
         c.setFont(fuente1);
        c.setForeground(Color.GRAY);
    }
    return c;
  }
}
