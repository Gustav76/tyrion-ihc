/*1*/ package proyectodetitulo;
/*2*/ 
/*3*/ import org.jdesktop.application.Action;
/*4*/ import org.jdesktop.application.ResourceMap;
/*5*/ import org.jdesktop.application.SingleFrameApplication;
/*6*/ import org.jdesktop.application.FrameView;
/*7*/ import org.jdesktop.application.TaskMonitor;
/*8*/ import java.awt.event.ActionEvent;
/*9*/ import java.awt.event.ActionListener;
/*10*/ import javax.swing.Timer;
/*11*/ import javax.swing.Icon;
/*12*/ import javax.swing.JDialog;
/*13*/ import javax.swing.JFrame;
/*14*/ 
       /**
        * The application's main frame.
        */
/*18*/ public class ProyectoDeTituloView extends FrameView {
/*19*/ 
/*20*/     /**
            *
            * @param app
            */
/*24*/     public ProyectoDeTituloView(SingleFrameApplication app) {
/*25*/         super(app);
/*26*/ 
/*27*/         initComponents();
/*28*/ 
/*29*/         // status bar initialization - message timeout, idle icon and busy animation, etc
/*30*/         ResourceMap resourceMap = getResourceMap();
/*31*/         int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
/*32*/         messageTimer = new Timer(messageTimeout, new ActionListener() {
/*33*/ 
/*34*/             public void actionPerformed(ActionEvent e) {
/*35*/                 statusMessageLabel.setText("");
/*36*/             }
/*37*/         });
/*38*/         messageTimer.setRepeats(false);
/*39*/         int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
/*40*/         for (int i = 0; i < busyIcons.length; i++) {
/*41*/             busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
/*42*/         }
/*43*/         busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
/*44*/ 
/*45*/             public void actionPerformed(ActionEvent e) {
/*46*/                 busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
/*47*/                 statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
/*48*/             }
/*49*/         });
/*50*/         idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
/*51*/         statusAnimationLabel.setIcon(idleIcon);
/*52*/         progressBar.setVisible(false);
/*53*/ 
/*54*/         // connecting action tasks to status bar via TaskMonitor
/*55*/         TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
/*56*/         taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
/*57*/ 
/*58*/             public void propertyChange(java.beans.PropertyChangeEvent evt) {
/*59*/                 String propertyName = evt.getPropertyName();
/*60*/                 if ("started".equals(propertyName)) {
/*61*/                     if (!busyIconTimer.isRunning()) {
/*62*/                         statusAnimationLabel.setIcon(busyIcons[0]);
/*63*/                         busyIconIndex = 0;
/*64*/                         busyIconTimer.start();
/*65*/                     }
/*66*/                     progressBar.setVisible(true);
/*67*/                     progressBar.setIndeterminate(true);
/*68*/                 } else if ("done".equals(propertyName)) {
/*69*/                     busyIconTimer.stop();
/*70*/                     statusAnimationLabel.setIcon(idleIcon);
/*71*/                     progressBar.setVisible(false);
/*72*/                     progressBar.setValue(0);
/*73*/                 } else if ("message".equals(propertyName)) {
/*74*/                     String text = (String) (evt.getNewValue());
/*75*/                     statusMessageLabel.setText((text == null) ? "" : text);
/*76*/                     messageTimer.restart();
/*77*/                 } else if ("progress".equals(propertyName)) {
/*78*/                     int value = (Integer) (evt.getNewValue());
/*79*/                     progressBar.setVisible(true);
/*80*/                     progressBar.setIndeterminate(false);
/*81*/                     progressBar.setValue(value);
/*82*/                 }
/*83*/             }
/*84*/         });
/*85*/     }
/*86*/ 
/*87*/     /**
            *
            */
/*90*/     @Action
/*91*/     public void showAboutBox() {
/*92*/         if (aboutBox == null) {
/*93*/             JFrame mainFrame = ProyectoDeTituloApp.getApplication().getMainFrame();
/*94*/             aboutBox = new ProyectoDeTituloAboutBox(mainFrame);
/*95*/             aboutBox.setLocationRelativeTo(mainFrame);
/*96*/         }
/*97*/         ProyectoDeTituloApp.getApplication().show(aboutBox);
/*98*/     }
/*99*/ 
/*100*/     @SuppressWarnings("unchecked")
/*101*/     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
/*102*/     private void initComponents() {
/*103*/ 
/*104*/         mainPanel = new javax.swing.JPanel();
/*105*/         menuBar = new javax.swing.JMenuBar();
/*106*/         javax.swing.JMenu fileMenu = new javax.swing.JMenu();
/*107*/         javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
/*108*/         javax.swing.JMenu helpMenu = new javax.swing.JMenu();
/*109*/         javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
/*110*/         statusPanel = new javax.swing.JPanel();
/*111*/         javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
/*112*/         statusMessageLabel = new javax.swing.JLabel();
/*113*/         statusAnimationLabel = new javax.swing.JLabel();
/*114*/         progressBar = new javax.swing.JProgressBar();
/*115*/ 
/*116*/         mainPanel.setName("mainPanel"); // NOI18N
/*117*/ 
/*118*/         org.jdesktop.layout.GroupLayout mainPanelLayout = new org.jdesktop.layout.GroupLayout(mainPanel);
/*119*/         mainPanel.setLayout(mainPanelLayout);
/*120*/         mainPanelLayout.setHorizontalGroup(
/*121*/             mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
/*122*/             .add(0, 400, Short.MAX_VALUE)
/*123*/         );
/*124*/         mainPanelLayout.setVerticalGroup(
/*125*/             mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
/*126*/             .add(0, 252, Short.MAX_VALUE)
/*127*/         );
/*128*/ 
/*129*/         menuBar.setName("menuBar"); // NOI18N
/*130*/ 
/*131*/         org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(proyectodetitulo.ProyectoDeTituloApp.class).getContext().getResourceMap(ProyectoDeTituloView.class);
/*132*/         fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
/*133*/         fileMenu.setName("fileMenu"); // NOI18N
/*134*/ 
/*135*/         javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(proyectodetitulo.ProyectoDeTituloApp.class).getContext().getActionMap(ProyectoDeTituloView.class, this);
/*136*/         exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
/*137*/         exitMenuItem.setName("exitMenuItem"); // NOI18N
/*138*/         fileMenu.add(exitMenuItem);
/*139*/ 
/*140*/         menuBar.add(fileMenu);
/*141*/ 
/*142*/         helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
/*143*/         helpMenu.setName("helpMenu"); // NOI18N
/*144*/ 
/*145*/         aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
/*146*/         aboutMenuItem.setName("aboutMenuItem"); // NOI18N
/*147*/         helpMenu.add(aboutMenuItem);
/*148*/ 
/*149*/         menuBar.add(helpMenu);
/*150*/ 
/*151*/         statusPanel.setName("statusPanel"); // NOI18N
/*152*/ 
/*153*/         statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N
/*154*/ 
/*155*/         statusMessageLabel.setName("statusMessageLabel"); // NOI18N
/*156*/ 
/*157*/         statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
/*158*/         statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N
/*159*/ 
/*160*/         progressBar.setName("progressBar"); // NOI18N
/*161*/ 
/*162*/         org.jdesktop.layout.GroupLayout statusPanelLayout = new org.jdesktop.layout.GroupLayout(statusPanel);
/*163*/         statusPanel.setLayout(statusPanelLayout);
/*164*/         statusPanelLayout.setHorizontalGroup(
/*165*/             statusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
/*166*/             .add(statusPanelSeparator, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
/*167*/             .add(statusPanelLayout.createSequentialGroup()
/*168*/                 .addContainerGap()
/*169*/                 .add(statusMessageLabel)
/*170*/                 .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 226, Short.MAX_VALUE)
/*171*/                 .add(progressBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
/*172*/                 .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
/*173*/                 .add(statusAnimationLabel)
/*174*/                 .addContainerGap())
/*175*/         );
/*176*/         statusPanelLayout.setVerticalGroup(
/*177*/             statusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
/*178*/             .add(statusPanelLayout.createSequentialGroup()
/*179*/                 .add(statusPanelSeparator, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
/*180*/                 .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
/*181*/                 .add(statusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
/*182*/                     .add(statusMessageLabel)
/*183*/                     .add(statusAnimationLabel)
/*184*/                     .add(progressBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
/*185*/                 .add(3, 3, 3))
/*186*/         );
/*187*/ 
/*188*/         setComponent(mainPanel);
/*189*/         setMenuBar(menuBar);
/*190*/         setStatusBar(statusPanel);
/*191*/     }// </editor-fold>//GEN-END:initComponents
/*192*/     // Variables declaration - do not modify//GEN-BEGIN:variables
/*193*/     private javax.swing.JPanel mainPanel;
/*194*/     private javax.swing.JMenuBar menuBar;
/*195*/     private javax.swing.JProgressBar progressBar;
/*196*/     private javax.swing.JLabel statusAnimationLabel;
/*197*/     private javax.swing.JLabel statusMessageLabel;
/*198*/     private javax.swing.JPanel statusPanel;
/*199*/     // End of variables declaration//GEN-END:variables
/*200*/     private final Timer messageTimer;
/*201*/     private final Timer busyIconTimer;
/*202*/     private final Icon idleIcon;
/*203*/     private final Icon[] busyIcons = new Icon[15];
/*204*/     private int busyIconIndex = 0;
/*205*/     private JDialog aboutBox;
/*206*/ }
