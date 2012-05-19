package Vista;

import Controlador.ControladorCargarArchivos;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import javax.xml.parsers.ParserConfigurationException;

/**
 *
 * @author Tapsin
 */
public class JPCargarArchivos extends javax.swing.JPanel {

    /** Creates new form JPCargarArchivos */
    public ControladorCargarArchivos control;
    int cargarA = 0;
    final JFileChooser fc = new JFileChooser();

    public JPCargarArchivos(ControladorCargarArchivos control) {
        this.control = control;
        this.control.control.getVista().setTextLabelEstado("Listo");
        try {
            UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        labelMapaConversacional = new javax.swing.JLabel();
        campoRutaMC = new javax.swing.JTextField();
        bExaminarMC = new javax.swing.JButton();
        labelObjetivosDelN = new javax.swing.JLabel();
        campoRutaON = new javax.swing.JTextField();
        bExaminarON = new javax.swing.JButton();
        bCargarArchivos = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(proyectodetitulo.ProyectoDeTituloApp.class).getContext().getResourceMap(JPCargarArchivos.class);
        jPanel1.setBackground(resourceMap.getColor("jPanel1.background")); // NOI18N
        jPanel1.setBorder(new javax.swing.border.LineBorder(null, 1, true));
        jPanel1.setForeground(resourceMap.getColor("jPanel1.foreground")); // NOI18N
        jPanel1.setToolTipText(resourceMap.getString("jPanel1.toolTipText")); // NOI18N
        jPanel1.setEnabled(false);
        jPanel1.setName("jPanel1"); // NOI18N

        labelMapaConversacional.setText(resourceMap.getString("labelMapaConversacional.text")); // NOI18N
        labelMapaConversacional.setName("labelMapaConversacional"); // NOI18N

        campoRutaMC.setName("campoRutaMC"); // NOI18N

        bExaminarMC.setText(resourceMap.getString("bExaminarMC.text")); // NOI18N
        bExaminarMC.setName("bExaminarMC"); // NOI18N
        bExaminarMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExaminarMCActionPerformed(evt);
            }
        });

        labelObjetivosDelN.setText(resourceMap.getString("labelObjetivosDelN.text")); // NOI18N
        labelObjetivosDelN.setName("labelObjetivosDelN"); // NOI18N

        campoRutaON.setName("campoRutaON"); // NOI18N

        bExaminarON.setText(resourceMap.getString("bExaminarON.text")); // NOI18N
        bExaminarON.setName("bExaminarON"); // NOI18N
        bExaminarON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExaminarONActionPerformed(evt);
            }
        });

        bCargarArchivos.setText(resourceMap.getString("bCargarArchivos.text")); // NOI18N
        bCargarArchivos.setToolTipText(resourceMap.getString("bCargarArchivos.toolTipText")); // NOI18N
        bCargarArchivos.setName("bCargarArchivos"); // NOI18N
        bCargarArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCargarArchivosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bCargarArchivos)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMapaConversacional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelObjetivosDelN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoRutaON, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                            .addComponent(campoRutaMC, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bExaminarMC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bExaminarON, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoRutaMC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMapaConversacional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(bExaminarMC))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bExaminarON)
                    .addComponent(labelObjetivosDelN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoRutaON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bCargarArchivos)
                .addGap(49, 49, 49))
        );

        titulo.setFont(resourceMap.getFont("titulo.font")); // NOI18N
        titulo.setText(resourceMap.getString("titulo.text")); // NOI18N
        titulo.setName("titulo"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bExaminarMCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExaminarMCActionPerformed
        /*528*/         //funcion para buscar el archivo XML de entrada (Mapa Conversacional)
        /*529*/ String entrada;
        /*530*/ 
        /* Se agrega filtro de extension XML */
        FileFilter XMLFilter = new ExtensionFileFilter("Archivo XML", new String[]{"XML"});
        fc.addChoosableFileFilter(XMLFilter);
        /**************************************/
        /*531*/ int returnVal = fc.showOpenDialog(this);
        /*532*/ if (returnVal == JFileChooser.APPROVE_OPTION) {
        /*533*/ File file = fc.getSelectedFile();
        /*534*/ entrada = file.getPath();
        /*535*/             //seteo en el campo correspondiente
        /*536*/ campoRutaMC.setText(entrada);
        /*537*/        }
        /*538*/
        /*539*/ 
}//GEN-LAST:event_bExaminarMCActionPerformed

    private void bExaminarONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExaminarONActionPerformed
        /*547*/         //funcion para buscar el archivo XML de entrada (Objetivos del negocio)
        /*548*/ String entrada;
        /*549*/
        /* Se agrega filtro de extension XML */
        FileFilter XMLFilter = new ExtensionFileFilter("Archivo XML", new String[]{"XML"});
        fc.addChoosableFileFilter(XMLFilter);
        /**************************************/
        /*550*/ int returnVal = fc.showOpenDialog(this);
        /*551*/ if (returnVal == JFileChooser.APPROVE_OPTION) {
            /*552*/ File file = fc.getSelectedFile();
            /*553*/ entrada = file.getPath();
            /*554*/             //seteo en el campo correspondiente
            /*555*/ campoRutaON.setText(entrada);
            /*556*/        }
        /*557*/ this.bCargarArchivos.setEnabled(true);
}//GEN-LAST:event_bExaminarONActionPerformed

    private void bCargarArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCargarArchivosActionPerformed
        
        this.control.control.getVista().setTextLabelEstado("Cargando archivos...");
        String mapaConversacional = this.campoRutaMC.getText();
        String objetivoNegocio = this.campoRutaON.getText();
        
        String resp = null;
        try {
           if(!mapaConversacional.isEmpty() && mapaConversacional != null &&
                   !objetivoNegocio.isEmpty() && objetivoNegocio != null
             ){
             //valida la estructura del archivo mapa conversacional
             if (control.validarMapaConversacionelXML(mapaConversacional) == null) {
                                 //valida la estructura del archivo de los objetivos del negocio
                 if (control.validarObjetivosDelNegocioXML(objetivoNegocio) == null) {
                     resp = control.cargarArchivosXML(campoRutaMC.getText(), campoRutaON.getText());
                     this.cargarA = 0;
                     if (resp == null) {
                                                 //verifica que todas los enlaces de las pertenencias tengan un id existente
                         if (control.verificarPertenencias() == 0) {
                                                         //verifica que todos las excepciones tengan un id existente
                             if (control.verificarExcepciones() == 0) { 
                                Icon ico = new ImageIcon(getClass().getResource("/Fotos/tick2.png"));
                                this.control.control.getVista().setTextLabelEstado("Archivos Cargados");
                                 JOptionPane.showMessageDialog(null, "Los archivos han sido cargados exitosamente", "Aviso", JOptionPane.INFORMATION_MESSAGE, ico);
                                 control.valido = true;
                                                           } else {
                                  this.control.control.getVista().setTextLabelEstado("Error al cargar archivos");
                                 JOptionPane.showMessageDialog(null, "ID de Excepciones incorrecto", "¡Error!", JOptionPane.ERROR_MESSAGE);
                                control.valido = false;
                                                            }
                                                   } else {
                            control.valido = false;
                                  this.control.control.getVista().setTextLabelEstado("Error al cargar archivos");
                             JOptionPane.showMessageDialog(null, "ID de Pertenencias incorrecto", "¡Error!", JOptionPane.ERROR_MESSAGE);
                                                    }
                                            } else {
                        control.valido = false;
                                  this.control.control.getVista().setTextLabelEstado("Error al cargar archivos");//+ resp
                         JOptionPane.showMessageDialog(null, "Los archivos de entrada presentan problemas al cargar. ", "¡Error!", JOptionPane.ERROR_MESSAGE);
                                           }
                                    } else {
                    control.valido = false;
                                  this.control.control.getVista().setTextLabelEstado("Error al cargar archivos");
                     JOptionPane.showMessageDialog(null, "Archivo XML: 'Objetivos del negocio' incorrecto.\r\nRevise la sintaxis del archivo o verifique que éste sea válido", "¡Error!", JOptionPane.ERROR_MESSAGE);
                                         //resp="error";
                                    }
                
                            } else {
                                  this.control.control.getVista().setTextLabelEstado("Error al cargar archivos"); // + control.validarMapaConversacionelXML(mapaConversacional)
                 JOptionPane.showMessageDialog(null, "Archivo XML: 'Mapa Conversacional' incorrecto.\r\nRevise estructura del archivo o verifique que éste sea válido", "¡Error!", JOptionPane.ERROR_MESSAGE);
                               
                           }
              }else{
               
               this.control.control.getVista().setTextLabelEstado("Error al cargar archivos"); 
                 JOptionPane.showMessageDialog(null, "Debe ingresar ambos archivos antes de cargarlos.", "¡Error!", JOptionPane.ERROR_MESSAGE);
           }
        } catch (ParserConfigurationException ex) {       
      }
}//GEN-LAST:event_bCargarArchivosActionPerformed

    public void alerta(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "¡Advertencia!", JOptionPane.WARNING_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCargarArchivos;
    private javax.swing.JButton bExaminarMC;
    private javax.swing.JButton bExaminarON;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField campoRutaMC;
    private javax.swing.JTextField campoRutaON;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelMapaConversacional;
    private javax.swing.JLabel labelObjetivosDelN;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

    public JButton getbCargarArchivos() {
        return bCargarArchivos;
    }

    public void setbCargarArchivos(JButton bCargarArchivos) {
        this.bCargarArchivos = bCargarArchivos;
    }

    public JButton getbExaminarMC() {
        return bExaminarMC;
    }

    public void setbExaminarMC(JButton bExaminarMC) {
        this.bExaminarMC = bExaminarMC;
    }

    public JButton getbExaminarON() {
        return bExaminarON;
    }

    public void setbExaminarON(JButton bExaminarON) {
        this.bExaminarON = bExaminarON;
    }

    public JTextField getCampoRutaMC() {
        return campoRutaMC;
    }

    public void setCampoRutaMC(JTextField campoRutaMC) {
        this.campoRutaMC = campoRutaMC;
    }

    public JTextField getCampoRutaON() {
        return campoRutaON;
    }

    public void setCampoRutaON(JTextField campoRutaON) {
        this.campoRutaON = campoRutaON;
    }

}
