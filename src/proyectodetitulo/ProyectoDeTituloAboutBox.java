/*1*/ package proyectodetitulo;
/*2*/ 
/*3*/ import org.jdesktop.application.Action;
/*4*/ 
/*5*/ /**
       *
       * @author
       */
/*9*/ public class ProyectoDeTituloAboutBox extends javax.swing.JDialog {
/*10*/ 
/*11*/     /**
            *
            * @param parent
            */
/*15*/     public ProyectoDeTituloAboutBox(java.awt.Frame parent) {
/*16*/         super(parent);
/*17*/         initComponents();
/*18*/         getRootPane().setDefaultButton(closeButton);
/*19*/     }
/*20*/ 
/*21*/     /**
            *
            */
/*24*/     @Action
/*25*/     public void closeAboutBox() {
/*26*/         dispose();
/*27*/     }
/*28*/ 
/*29*/     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
/*30*/     private void initComponents() {
/*31*/ 
/*32*/         closeButton = new javax.swing.JButton();
/*33*/         javax.swing.JLabel appTitleLabel = new javax.swing.JLabel();
/*34*/         javax.swing.JLabel versionLabel = new javax.swing.JLabel();
/*35*/         javax.swing.JLabel appVersionLabel = new javax.swing.JLabel();
/*36*/         javax.swing.JLabel vendorLabel = new javax.swing.JLabel();
/*37*/         javax.swing.JLabel appVendorLabel = new javax.swing.JLabel();
/*38*/         javax.swing.JLabel homepageLabel = new javax.swing.JLabel();
/*39*/         javax.swing.JLabel appHomepageLabel = new javax.swing.JLabel();
/*40*/         javax.swing.JLabel appDescLabel = new javax.swing.JLabel();
/*41*/         javax.swing.JLabel imageLabel = new javax.swing.JLabel();
/*42*/ 
/*43*/         setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
/*44*/         org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(proyectodetitulo.ProyectoDeTituloApp.class).getContext().getResourceMap(ProyectoDeTituloAboutBox.class);
/*45*/         setTitle(resourceMap.getString("title")); // NOI18N
/*46*/         setModal(true);
/*47*/         setName("aboutBox"); // NOI18N
/*48*/         setResizable(false);
/*49*/ 
/*50*/         javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(proyectodetitulo.ProyectoDeTituloApp.class).getContext().getActionMap(ProyectoDeTituloAboutBox.class, this);
/*51*/         closeButton.setAction(actionMap.get("closeAboutBox")); // NOI18N
/*52*/         closeButton.setName("closeButton"); // NOI18N
/*53*/ 
/*54*/         appTitleLabel.setFont(appTitleLabel.getFont().deriveFont(appTitleLabel.getFont().getStyle() | java.awt.Font.BOLD, appTitleLabel.getFont().getSize()+4));
/*55*/         appTitleLabel.setText(resourceMap.getString("Application.title")); // NOI18N
/*56*/         appTitleLabel.setName("appTitleLabel"); // NOI18N
/*57*/ 
/*58*/         versionLabel.setFont(versionLabel.getFont().deriveFont(versionLabel.getFont().getStyle() | java.awt.Font.BOLD));
/*59*/         versionLabel.setText(resourceMap.getString("versionLabel.text")); // NOI18N
/*60*/         versionLabel.setName("versionLabel"); // NOI18N
/*61*/ 
/*62*/         appVersionLabel.setText(resourceMap.getString("Application.version")); // NOI18N
/*63*/         appVersionLabel.setName("appVersionLabel"); // NOI18N
/*64*/ 
/*65*/         vendorLabel.setFont(vendorLabel.getFont().deriveFont(vendorLabel.getFont().getStyle() | java.awt.Font.BOLD));
/*66*/         vendorLabel.setText(resourceMap.getString("vendorLabel.text")); // NOI18N
/*67*/         vendorLabel.setName("vendorLabel"); // NOI18N
/*68*/ 
/*69*/         appVendorLabel.setText(resourceMap.getString("Application.vendor")); // NOI18N
/*70*/         appVendorLabel.setName("appVendorLabel"); // NOI18N
/*71*/ 
/*72*/         homepageLabel.setFont(homepageLabel.getFont().deriveFont(homepageLabel.getFont().getStyle() | java.awt.Font.BOLD));
/*73*/         homepageLabel.setText(resourceMap.getString("homepageLabel.text")); // NOI18N
/*74*/         homepageLabel.setName("homepageLabel"); // NOI18N
/*75*/ 
/*76*/         appHomepageLabel.setText(resourceMap.getString("Application.homepage")); // NOI18N
/*77*/         appHomepageLabel.setName("appHomepageLabel"); // NOI18N
/*78*/ 
/*79*/         appDescLabel.setText(resourceMap.getString("appDescLabel.text")); // NOI18N
/*80*/         appDescLabel.setName("appDescLabel"); // NOI18N
/*81*/ 
/*82*/         imageLabel.setIcon(resourceMap.getIcon("imageLabel.icon")); // NOI18N
/*83*/         imageLabel.setName("imageLabel"); // NOI18N
/*84*/ 
/*85*/         org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
/*86*/         getContentPane().setLayout(layout);
/*87*/         layout.setHorizontalGroup(
/*88*/             layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
/*89*/             .add(layout.createSequentialGroup()
/*90*/                 .add(imageLabel)
/*91*/                 .add(18, 18, 18)
/*92*/                 .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
/*93*/                     .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
/*94*/                         .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
/*95*/                             .add(versionLabel)
/*96*/                             .add(vendorLabel)
/*97*/                             .add(homepageLabel))
/*98*/                         .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
/*99*/                         .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
/*100*/                             .add(appVersionLabel)
/*101*/                             .add(appVendorLabel)
/*102*/                             .add(appHomepageLabel)))
/*103*/                     .add(org.jdesktop.layout.GroupLayout.LEADING, appTitleLabel)
/*104*/                     .add(org.jdesktop.layout.GroupLayout.LEADING, appDescLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
/*105*/                     .add(closeButton))
/*106*/                 .addContainerGap())
/*107*/         );
/*108*/         layout.setVerticalGroup(
/*109*/             layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
/*110*/             .add(imageLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
/*111*/             .add(layout.createSequentialGroup()
/*112*/                 .addContainerGap()
/*113*/                 .add(appTitleLabel)
/*114*/                 .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
/*115*/                 .add(appDescLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
/*116*/                 .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
/*117*/                 .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
/*118*/                     .add(versionLabel)
/*119*/                     .add(appVersionLabel))
/*120*/                 .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
/*121*/                 .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
/*122*/                     .add(vendorLabel)
/*123*/                     .add(appVendorLabel))
/*124*/                 .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
/*125*/                 .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
/*126*/                     .add(homepageLabel)
/*127*/                     .add(appHomepageLabel))
/*128*/                 .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 19, Short.MAX_VALUE)
/*129*/                 .add(closeButton)
/*130*/                 .addContainerGap())
/*131*/         );
/*132*/ 
/*133*/         pack();
/*134*/     }// </editor-fold>//GEN-END:initComponents
/*135*/     // Variables declaration - do not modify//GEN-BEGIN:variables
/*136*/     private javax.swing.JButton closeButton;
/*137*/     // End of variables declaration//GEN-END:variables
/*138*/ }
