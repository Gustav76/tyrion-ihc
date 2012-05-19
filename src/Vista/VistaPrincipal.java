package Vista;

import Controlador.ControladorCargarArchivos;
import Controlador.ControladorPrincipal;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;

public class VistaPrincipal extends javax.swing.JFrame {

    /* Atributos nuevos */
    private static final ImageIcon ICON_COMPLETADA = new ImageIcon(VistaPrincipal.class.getResource("/iconos/tick.png"));
    private static final ImageIcon ICON_ACTUAL = new ImageIcon(VistaPrincipal.class.getResource("/iconos/arrow.png"));
    private static final ImageIcon ICON_PENDIENTE = new ImageIcon(VistaPrincipal.class.getResource("/iconos/gray-bullet.png"));
    private final List<JLabel> etapas;
    private String ruta = "";

    /* Atributos originales de VistaPrincipal */
    static final int MY_MINIMUM = 0;
    static final int MY_MAXIMUM = 134;
    // XXX: Cuál es la diferencia entre nvista y numeroEstado ?
    private static int nvista = 1; // G01: Cambiado default -> private
    private int numeroEstado = 1; // G01: Cambiado public -> private
    ControladorPrincipal control;
    // XXX: Por qué existe una referencia a ControladorCargarArchivos en esta vista?
    public ControladorCargarArchivos controlador;
    public String nombreVista;
    int cargarA = 0;
    // XXX: Qué hace esto?
    int SA = 0;
    public int descripcion1Val;

    public VistaPrincipal(ControladorPrincipal controlador) {
        this.control = controlador;

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

        etapas = new ArrayList<JLabel>() {

            {
                add(labelEtapa1);
                add(labelEtapa2);
                add(labelEtapa3);
                add(labelEtapa4);
                add(labelEtapa5);
                add(labelEtapa6);
                add(labelEtapa7);
                add(labelEtapa8);
                add(labelEtapa9);
                add(labelEtapa10);
                add(labelEtapa11);
                add(labelEtapa12);
            }
        };
    }

    public void setTextLabelEstado(String text) {
        labelEstado.setText(text);
    }

    public JPanel getPanel() {
        return panelContenido;
    }

    public void setDescripcion1Val(int descripcion1Val) {
        this.descripcion1Val = descripcion1Val;
    }

    public int getDescripcion1Val() {
        return descripcion1Val;
    }

    public static void setNvista(int nvista) {
        VistaPrincipal.nvista = nvista;
    }

    public static int getNvista() {
        return nvista;
    }

    public void setNumeroEstado(int numeroEstado) {
        this.numeroEstado = numeroEstado;
    }

    public int getNumeroEstado() {
        return numeroEstado;
    }

    public void setAnteriorEnabled(boolean b) {
        buttonAnterior.setEnabled(b);
    }

    public void setSiguienteEnabled(boolean b) {
        buttonSiguiente.setEnabled(b);
    }

    // tag: svizcay problema4 boton siguiente en la ultima etapa
    public void setButtonSiguienteVisible(boolean visibilidad) {
        buttonSiguiente.setVisible(visibilidad);
    }

    public void recuperarEstado6() {
        // XXX: Por qué existe esto?
        this.labelEtapa6.setIcon(ICON_ACTUAL);
        this.labelEtapa7.setIcon(ICON_COMPLETADA);
        this.numeroEstado = 6;
    }

    public int getSA() {
        return SA;
    }

    public void setSA(int SA) {
        this.SA = SA;
    }

    private void iniciarNuevoProyecto() {
        // Restaurar ultima ruta guardada
        this.ruta = "";
        // Reiniciar iconos al estado original
        labelEtapa1.setIcon(ICON_ACTUAL);
        for (int i = 1; i < etapas.size(); i++) {
            etapas.get(i).setIcon(ICON_PENDIENTE);
        }
        // Cambiar vista
        control.reiniciarEstado();
        /* 
         * No es necesario crear un nuevo controladorCargarArchivos,
         * puesto que al presionar siguiente se realizará esta acción
         * normalmente
         */
    }

    private void guardar() {
        if (this.ruta.equals("")) {
            guardarComo();
        } else {
            setTextLabelEstado("Guardando...");
            control.guardar(nvista, ruta);
            setTextLabelEstado("Guardado");
        }
    }

    private void guardarComo() {
        JFileChooser jF1 = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo XML (.xml)", "xml");
        jF1.setFileFilter(filtro);
        try {
            if (jF1.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                this.ruta = jF1.getSelectedFile().getAbsolutePath();
                if (new File(ruta).exists()) {
                    if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null,
                            "El archivo existe, ¿desea reemplazarlo?", "Advertencia",
                            JOptionPane.YES_NO_OPTION)) {
                        setTextLabelEstado("Guardando...");
                        control.guardar(nvista, ruta);
                        setTextLabelEstado("Guardado");
                    }
                } else {
                    setTextLabelEstado("Guardando...");
                    control.guardar(nvista, ruta);
                    setTextLabelEstado("Guardado");
                }
            }
        } catch (Exception ex) {
            setTextLabelEstado("Error al guardar");
            ex.printStackTrace();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        toolBar = new javax.swing.JToolBar();
        buttonNuevo = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        buttonAbrir = new javax.swing.JButton();
        buttonGuardar = new javax.swing.JButton();
        buttonGuardarComo = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        buttonDeshacer = new javax.swing.JButton();
        buttonRehacer = new javax.swing.JButton();
        panelEtapas = new javax.swing.JPanel();
        labelEtapa1 = new javax.swing.JLabel();
        labelEtapa2 = new javax.swing.JLabel();
        labelEtapa3 = new javax.swing.JLabel();
        labelEtapa4 = new javax.swing.JLabel();
        labelEtapa5 = new javax.swing.JLabel();
        labelEtapa6 = new javax.swing.JLabel();
        labelEtapa7 = new javax.swing.JLabel();
        labelEtapa8 = new javax.swing.JLabel();
        labelEtapa9 = new javax.swing.JLabel();
        labelEtapa10 = new javax.swing.JLabel();
        labelEtapa11 = new javax.swing.JLabel();
        labelEtapa12 = new javax.swing.JLabel();
        labelTituloEtapas = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        panelContenido = new javax.swing.JPanel();
        panelInferior = new javax.swing.JPanel();
        panelControles = new javax.swing.JPanel();
        buttonAnterior = new javax.swing.JButton();
        buttonSiguiente = new javax.swing.JButton();
        panelEstado = new javax.swing.JPanel();
        labelEstado = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        itemNuevoProyecto = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemAbrirProyecto = new javax.swing.JMenuItem();
        itemGuardarProyecto = new javax.swing.JMenuItem();
        itemGuardarProyectoComo = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itemSalir = new javax.swing.JMenuItem();
        menuEdicion = new javax.swing.JMenu();
        itemDeshacer = new javax.swing.JMenuItem();
        itemRehacer = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        itemAcercaDe = new javax.swing.JMenuItem();
        itemAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 550));
        setName("Form"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        toolBar.setFloatable(false);
        toolBar.setRollover(true);
        toolBar.setName("toolBar"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(proyectodetitulo.ProyectoDeTituloApp.class).getContext().getResourceMap(VistaPrincipal.class);
        buttonNuevo.setIcon(resourceMap.getIcon("buttonNuevo.icon")); // NOI18N
        buttonNuevo.setText(resourceMap.getString("buttonNuevo.text")); // NOI18N
        buttonNuevo.setToolTipText(resourceMap.getString("buttonNuevo.toolTipText")); // NOI18N
        buttonNuevo.setFocusable(false);
        buttonNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonNuevo.setName("buttonNuevo"); // NOI18N
        buttonNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNuevoActionPerformed(evt);
            }
        });
        toolBar.add(buttonNuevo);

        jSeparator4.setName("jSeparator4"); // NOI18N
        toolBar.add(jSeparator4);

        buttonAbrir.setIcon(resourceMap.getIcon("buttonAbrir.icon")); // NOI18N
        buttonAbrir.setToolTipText(resourceMap.getString("buttonAbrir.toolTipText")); // NOI18N
        buttonAbrir.setFocusable(false);
        buttonAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonAbrir.setName("buttonAbrir"); // NOI18N
        buttonAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAbrirActionPerformed(evt);
            }
        });
        toolBar.add(buttonAbrir);

        buttonGuardar.setIcon(resourceMap.getIcon("buttonGuardar.icon")); // NOI18N
        buttonGuardar.setText(resourceMap.getString("buttonGuardar.text")); // NOI18N
        buttonGuardar.setToolTipText(resourceMap.getString("buttonGuardar.toolTipText")); // NOI18N
        buttonGuardar.setFocusable(false);
        buttonGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonGuardar.setName("buttonGuardar"); // NOI18N
        buttonGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGuardarActionPerformed(evt);
            }
        });
        toolBar.add(buttonGuardar);

        buttonGuardarComo.setIcon(resourceMap.getIcon("buttonGuardarComo.icon")); // NOI18N
        buttonGuardarComo.setToolTipText(resourceMap.getString("buttonGuardarComo.toolTipText")); // NOI18N
        buttonGuardarComo.setFocusable(false);
        buttonGuardarComo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonGuardarComo.setName("buttonGuardarComo"); // NOI18N
        buttonGuardarComo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGuardarComoActionPerformed(evt);
            }
        });
        toolBar.add(buttonGuardarComo);

        jSeparator3.setName("jSeparator3"); // NOI18N
        toolBar.add(jSeparator3);

        buttonDeshacer.setIcon(resourceMap.getIcon("buttonDeshacer.icon")); // NOI18N
        buttonDeshacer.setToolTipText(resourceMap.getString("buttonDeshacer.toolTipText")); // NOI18N
        buttonDeshacer.setEnabled(false);
        buttonDeshacer.setFocusable(false);
        buttonDeshacer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonDeshacer.setName("buttonDeshacer"); // NOI18N
        buttonDeshacer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeshacerActionPerformed(evt);
            }
        });
        toolBar.add(buttonDeshacer);

        buttonRehacer.setIcon(resourceMap.getIcon("buttonRehacer.icon")); // NOI18N
        buttonRehacer.setToolTipText(resourceMap.getString("buttonRehacer.toolTipText")); // NOI18N
        buttonRehacer.setEnabled(false);
        buttonRehacer.setFocusable(false);
        buttonRehacer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonRehacer.setName("buttonRehacer"); // NOI18N
        buttonRehacer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonRehacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRehacerActionPerformed(evt);
            }
        });
        toolBar.add(buttonRehacer);

        getContentPane().add(toolBar, java.awt.BorderLayout.NORTH);

        panelEtapas.setBackground(resourceMap.getColor("panelEtapas.background")); // NOI18N
        panelEtapas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelEtapas.setName("panelEtapas"); // NOI18N
        panelEtapas.setLayout(new java.awt.GridBagLayout());

        labelEtapa1.setIcon(resourceMap.getIcon("labelEtapa1.icon")); // NOI18N
        labelEtapa1.setText(resourceMap.getString("labelEtapa1.text")); // NOI18N
        labelEtapa1.setName("labelEtapa1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        panelEtapas.add(labelEtapa1, gridBagConstraints);

        labelEtapa2.setIcon(resourceMap.getIcon("labelEtapa2.icon")); // NOI18N
        labelEtapa2.setText(resourceMap.getString("labelEtapa2.text")); // NOI18N
        labelEtapa2.setName("labelEtapa2"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        panelEtapas.add(labelEtapa2, gridBagConstraints);

        labelEtapa3.setIcon(resourceMap.getIcon("labelEtapa3.icon")); // NOI18N
        labelEtapa3.setText(resourceMap.getString("labelEtapa3.text")); // NOI18N
        labelEtapa3.setName("labelEtapa3"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        panelEtapas.add(labelEtapa3, gridBagConstraints);

        labelEtapa4.setIcon(resourceMap.getIcon("labelEtapa3.icon")); // NOI18N
        labelEtapa4.setText(resourceMap.getString("labelEtapa4.text")); // NOI18N
        labelEtapa4.setName("labelEtapa4"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        panelEtapas.add(labelEtapa4, gridBagConstraints);

        labelEtapa5.setIcon(resourceMap.getIcon("labelEtapa3.icon")); // NOI18N
        labelEtapa5.setText(resourceMap.getString("labelEtapa5.text")); // NOI18N
        labelEtapa5.setName("labelEtapa5"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        panelEtapas.add(labelEtapa5, gridBagConstraints);

        labelEtapa6.setIcon(resourceMap.getIcon("labelEtapa3.icon")); // NOI18N
        labelEtapa6.setText(resourceMap.getString("labelEtapa6.text")); // NOI18N
        labelEtapa6.setName("labelEtapa6"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        panelEtapas.add(labelEtapa6, gridBagConstraints);

        labelEtapa7.setIcon(resourceMap.getIcon("labelEtapa3.icon")); // NOI18N
        labelEtapa7.setText(resourceMap.getString("labelEtapa7.text")); // NOI18N
        labelEtapa7.setName("labelEtapa7"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        panelEtapas.add(labelEtapa7, gridBagConstraints);

        labelEtapa8.setIcon(resourceMap.getIcon("labelEtapa3.icon")); // NOI18N
        labelEtapa8.setText(resourceMap.getString("labelEtapa8.text")); // NOI18N
        labelEtapa8.setName("labelEtapa8"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        panelEtapas.add(labelEtapa8, gridBagConstraints);

        labelEtapa9.setIcon(resourceMap.getIcon("labelEtapa3.icon")); // NOI18N
        labelEtapa9.setText(resourceMap.getString("labelEtapa9.text")); // NOI18N
        labelEtapa9.setName("labelEtapa9"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        panelEtapas.add(labelEtapa9, gridBagConstraints);

        labelEtapa10.setIcon(resourceMap.getIcon("labelEtapa3.icon")); // NOI18N
        labelEtapa10.setText(resourceMap.getString("labelEtapa10.text")); // NOI18N
        labelEtapa10.setName("labelEtapa10"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        panelEtapas.add(labelEtapa10, gridBagConstraints);

        labelEtapa11.setIcon(resourceMap.getIcon("labelEtapa3.icon")); // NOI18N
        labelEtapa11.setText(resourceMap.getString("labelEtapa11.text")); // NOI18N
        labelEtapa11.setName("labelEtapa11"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        panelEtapas.add(labelEtapa11, gridBagConstraints);

        labelEtapa12.setIcon(resourceMap.getIcon("labelEtapa3.icon")); // NOI18N
        labelEtapa12.setText(resourceMap.getString("labelEtapa12.text")); // NOI18N
        labelEtapa12.setName("labelEtapa12"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        panelEtapas.add(labelEtapa12, gridBagConstraints);

        labelTituloEtapas.setFont(resourceMap.getFont("labelTituloEtapas.font")); // NOI18N
        labelTituloEtapas.setText(resourceMap.getString("labelTituloEtapas.text")); // NOI18N
        labelTituloEtapas.setName("labelTituloEtapas"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(1, 5, 2, 5);
        panelEtapas.add(labelTituloEtapas, gridBagConstraints);

        filler1.setName("filler1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.weighty = 0.5;
        panelEtapas.add(filler1, gridBagConstraints);

        filler2.setName("filler2"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        panelEtapas.add(filler2, gridBagConstraints);

        filler3.setName("filler3"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panelEtapas.add(filler3, gridBagConstraints);

        filler4.setName("filler4"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        panelEtapas.add(filler4, gridBagConstraints);

        getContentPane().add(panelEtapas, java.awt.BorderLayout.WEST);

        panelContenido.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelContenido.setMinimumSize(new java.awt.Dimension(700, 400));
        panelContenido.setName("panelContenido"); // NOI18N
        panelContenido.setLayout(new java.awt.CardLayout());
        getContentPane().add(panelContenido, java.awt.BorderLayout.CENTER);

        panelInferior.setName("panelInferior"); // NOI18N
        panelInferior.setLayout(new java.awt.BorderLayout());

        panelControles.setName("panelControles"); // NOI18N
        panelControles.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        buttonAnterior.setText(resourceMap.getString("buttonAnterior.text")); // NOI18N
        buttonAnterior.setMaximumSize(new java.awt.Dimension(95, 23));
        buttonAnterior.setMinimumSize(new java.awt.Dimension(95, 23));
        buttonAnterior.setName("buttonAnterior"); // NOI18N
        buttonAnterior.setPreferredSize(new java.awt.Dimension(95, 23));
        buttonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnteriorActionPerformed(evt);
            }
        });
        panelControles.add(buttonAnterior);

        buttonSiguiente.setText(resourceMap.getString("buttonSiguiente.text")); // NOI18N
        buttonSiguiente.setName("buttonSiguiente"); // NOI18N
        buttonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSiguienteActionPerformed(evt);
            }
        });
        panelControles.add(buttonSiguiente);

        panelInferior.add(panelControles, java.awt.BorderLayout.CENTER);

        panelEstado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelEstado.setName("panelEstado"); // NOI18N
        panelEstado.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 1, 1));

        labelEstado.setText(resourceMap.getString("labelEstado.text")); // NOI18N
        labelEstado.setName("labelEstado"); // NOI18N
        panelEstado.add(labelEstado);

        panelInferior.add(panelEstado, java.awt.BorderLayout.SOUTH);

        getContentPane().add(panelInferior, java.awt.BorderLayout.SOUTH);

        menuBar.setName("menuBar"); // NOI18N

        menuArchivo.setText(resourceMap.getString("menuArchivo.text")); // NOI18N
        menuArchivo.setName("menuArchivo"); // NOI18N

        itemNuevoProyecto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        itemNuevoProyecto.setIcon(resourceMap.getIcon("itemNuevoProyecto.icon")); // NOI18N
        itemNuevoProyecto.setText(resourceMap.getString("itemNuevoProyecto.text")); // NOI18N
        itemNuevoProyecto.setName("itemNuevoProyecto"); // NOI18N
        itemNuevoProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoProyectoActionPerformed(evt);
            }
        });
        menuArchivo.add(itemNuevoProyecto);

        jSeparator1.setName("jSeparator1"); // NOI18N
        menuArchivo.add(jSeparator1);

        itemAbrirProyecto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        itemAbrirProyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/open.png"))); // NOI18N
        itemAbrirProyecto.setText(resourceMap.getString("itemAbrirProyecto.text")); // NOI18N
        itemAbrirProyecto.setName("itemAbrirProyecto"); // NOI18N
        itemAbrirProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAbrirProyectoActionPerformed(evt);
            }
        });
        menuArchivo.add(itemAbrirProyecto);

        itemGuardarProyecto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        itemGuardarProyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/save.png"))); // NOI18N
        itemGuardarProyecto.setText(resourceMap.getString("itemGuardarProyecto.text")); // NOI18N
        itemGuardarProyecto.setName("itemGuardarProyecto"); // NOI18N
        itemGuardarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGuardarProyectoActionPerformed(evt);
            }
        });
        menuArchivo.add(itemGuardarProyecto);

        itemGuardarProyectoComo.setIcon(resourceMap.getIcon("itemGuardarProyectoComo.icon")); // NOI18N
        itemGuardarProyectoComo.setText(resourceMap.getString("itemGuardarProyectoComo.text")); // NOI18N
        itemGuardarProyectoComo.setToolTipText(resourceMap.getString("itemGuardarProyectoComo.toolTipText")); // NOI18N
        itemGuardarProyectoComo.setName("itemGuardarProyectoComo"); // NOI18N
        itemGuardarProyectoComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGuardarProyectoComoActionPerformed(evt);
            }
        });
        menuArchivo.add(itemGuardarProyectoComo);

        jSeparator2.setName("jSeparator2"); // NOI18N
        menuArchivo.add(jSeparator2);

        itemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        itemSalir.setIcon(resourceMap.getIcon("itemSalir.icon")); // NOI18N
        itemSalir.setText(resourceMap.getString("itemSalir.text")); // NOI18N
        itemSalir.setName("itemSalir"); // NOI18N
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(itemSalir);

        menuBar.add(menuArchivo);

        menuEdicion.setText(resourceMap.getString("menuEdicion.text")); // NOI18N
        menuEdicion.setName("menuEdicion"); // NOI18N

        itemDeshacer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        itemDeshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/undo.png"))); // NOI18N
        itemDeshacer.setText(resourceMap.getString("itemDeshacer.text")); // NOI18N
        itemDeshacer.setName("itemDeshacer"); // NOI18N
        itemDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDeshacerActionPerformed(evt);
            }
        });
        menuEdicion.add(itemDeshacer);

        itemRehacer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        itemRehacer.setIcon(resourceMap.getIcon("itemRehacer.icon")); // NOI18N
        itemRehacer.setText(resourceMap.getString("itemRehacer.text")); // NOI18N
        itemRehacer.setName("itemRehacer"); // NOI18N
        itemRehacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRehacerActionPerformed(evt);
            }
        });
        menuEdicion.add(itemRehacer);

        menuBar.add(menuEdicion);

        menuAyuda.setText(resourceMap.getString("menuAyuda.text")); // NOI18N
        menuAyuda.setName("menuAyuda"); // NOI18N

        itemAcercaDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        itemAcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/info.png"))); // NOI18N
        itemAcercaDe.setText(resourceMap.getString("itemAcercaDe.text")); // NOI18N
        itemAcercaDe.setName("itemAcercaDe"); // NOI18N
        menuAyuda.add(itemAcercaDe);

        itemAyuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itemAyuda.setIcon(resourceMap.getIcon("itemAyuda.icon")); // NOI18N
        itemAyuda.setText(resourceMap.getString("itemAyuda.text")); // NOI18N
        itemAyuda.setName("itemAyuda"); // NOI18N
        itemAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAyudaActionPerformed(evt);
            }
        });
        menuAyuda.add(itemAyuda);

        menuBar.add(menuAyuda);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSiguienteActionPerformed
        
        
         
        this.control.activarV(nvista, numeroEstado);
        etapas.get(numeroEstado - 2).setIcon(ICON_COMPLETADA);
        if (numeroEstado < 13) {
            etapas.get(numeroEstado - 1).setIcon(ICON_ACTUAL);
        }
        if(this.nvista > 1 && numeroEstado > 2){
            if(!buttonDeshacer.isEnabled() && !buttonRehacer.isEnabled()){
                
                buttonDeshacer.setEnabled(true);
                buttonRehacer.setEnabled(true);
            }
        }
    }//GEN-LAST:event_buttonSiguienteActionPerformed

    private void buttonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAnteriorActionPerformed
        //codigo para volver atras y guardarComo si es que estoy en vista 3
        int eleccion = JOptionPane.NO_OPTION;
	
        // tag: svizcay problema4
        if (nvista == 12) {
			setSiguienteEnabled(true);
            //setButtonSiguienteVisible(true);
        }
		
        if (nvista == 3) {
            Object[] opciones = {"Si", "No", "Cancelar"};
            eleccion = JOptionPane.showOptionDialog(
                    this,
                    "Se volverá a la etapa de carga de archivos del programa y se perderán los datos de la sesión actual.\r\n"
                    + "¿Desea Guardar ahora los datos de la misma?", "Advertencia",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, opciones, "Aceptar");
            if (eleccion == JOptionPane.YES_OPTION) {
                if (control.getControladorCU1().validarCU1() == false) {
                    control.getControladorCU1().Alerta("No es posible guardar si no ha completado al menos los pasos de esta ventana.");
                } else {
                    buttonGuardarComoActionPerformed(evt);
                    this.control.activarVatras(nvista, numeroEstado);
                    // TODO: Factorizar esto si es posible
                    if (this.numeroEstado == 2 && VistaPrincipal.nvista == 2) {
                        this.labelEtapa2.setIcon(ICON_ACTUAL);
                        this.labelEtapa3.setIcon(ICON_PENDIENTE);
                        this.labelEtapa4.setIcon(ICON_PENDIENTE);
                        this.labelEtapa5.setIcon(ICON_PENDIENTE);
                        this.labelEtapa6.setIcon(ICON_PENDIENTE);
                        this.labelEtapa7.setIcon(ICON_PENDIENTE);
                        this.labelEtapa8.setIcon(ICON_PENDIENTE);
                        this.labelEtapa9.setIcon(ICON_PENDIENTE);
                        this.labelEtapa10.setIcon(ICON_PENDIENTE);
                        this.labelEtapa11.setIcon(ICON_PENDIENTE);
                        this.labelEtapa12.setIcon(ICON_PENDIENTE);
                    } else if (this.numeroEstado == 3 && VistaPrincipal.nvista == 3) {
                        this.labelEtapa4.setIcon(ICON_COMPLETADA);
                        this.labelEtapa3.setIcon(ICON_ACTUAL);
                    } else if (this.numeroEstado == 4 && VistaPrincipal.nvista == 4) {
                        this.labelEtapa5.setIcon(ICON_COMPLETADA);
                        this.labelEtapa4.setIcon(ICON_ACTUAL);
                    } else if (this.numeroEstado == 5 && VistaPrincipal.nvista == 5) {
                        this.labelEtapa6.setIcon(ICON_COMPLETADA);
                        this.labelEtapa5.setIcon(ICON_ACTUAL);
                    } else if (this.numeroEstado == 6 && VistaPrincipal.nvista == 6) {
                        this.labelEtapa7.setIcon(ICON_COMPLETADA);
                        this.labelEtapa6.setIcon(ICON_ACTUAL);
                    } else if (this.numeroEstado == 7 && VistaPrincipal.nvista == 7) {
                        this.labelEtapa8.setIcon(ICON_COMPLETADA);
                        this.labelEtapa7.setIcon(ICON_ACTUAL);
                    } else if (this.numeroEstado == 8 && VistaPrincipal.nvista == 8) {
                        if (this.getDescripcion1Val() == 1) {
                            this.labelEtapa9.setIcon(ICON_COMPLETADA);
                            this.labelEtapa8.setIcon(ICON_ACTUAL);
                        } else {
                            this.labelEtapa9.setIcon(ICON_PENDIENTE);
                            this.labelEtapa8.setIcon(ICON_ACTUAL);
                        }
                    } else if (this.numeroEstado == 9 && VistaPrincipal.nvista == 9) {
                        this.setDescripcion1Val(1);
                        this.labelEtapa10.setIcon(ICON_COMPLETADA);
                        this.labelEtapa9.setIcon(ICON_ACTUAL);
                    } else if (this.numeroEstado == 10 && VistaPrincipal.nvista == 10) {
                        this.labelEtapa11.setIcon(ICON_COMPLETADA);
                        this.labelEtapa10.setIcon(ICON_ACTUAL);
                        this.numeroEstado = 9;
                    } else if (this.numeroEstado == 11 && VistaPrincipal.nvista == 11) {
                        this.labelEtapa12.setIcon(ICON_COMPLETADA);
                        this.labelEtapa11.setIcon(ICON_ACTUAL);
                    }
                    
                    if(buttonDeshacer.isEnabled() && buttonRehacer.isEnabled()){
                
                            buttonDeshacer.setEnabled(false);
                            buttonRehacer.setEnabled(false);
                    }
                    
                }
            } else if (eleccion == JOptionPane.CANCEL_OPTION) {
                eleccion = JOptionPane.YES_OPTION;
            }
        }
        if (nvista == 4) {
            Object[] opciones = {"Si", "No", "Cancelar"};
            eleccion = JOptionPane.showOptionDialog(
                    this,
                    "Se volverá a la etapa de identificar casos de uso primer paso del programa y se perderán los datos editados de la sesión actual.\r\n"
                    + "¿Desea Guardar ahora los datos de la misma?", "Advertencia",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, opciones, "Aceptar");
            if (eleccion == JOptionPane.YES_OPTION) {
                    buttonGuardarComoActionPerformed(evt);
                    this.control.activarVatras(nvista, numeroEstado);
                // TODO: Factorizar esto si es posible
                if (this.numeroEstado == 2 && VistaPrincipal.nvista == 2) {
                    this.labelEtapa2.setIcon(ICON_ACTUAL);
                    this.labelEtapa3.setIcon(ICON_PENDIENTE);
                    this.labelEtapa4.setIcon(ICON_PENDIENTE);
                    this.labelEtapa5.setIcon(ICON_PENDIENTE);
                    this.labelEtapa6.setIcon(ICON_PENDIENTE);
                    this.labelEtapa7.setIcon(ICON_PENDIENTE);
                    this.labelEtapa8.setIcon(ICON_PENDIENTE);
                    this.labelEtapa9.setIcon(ICON_PENDIENTE);
                    this.labelEtapa10.setIcon(ICON_PENDIENTE);
                    this.labelEtapa11.setIcon(ICON_PENDIENTE);
                    this.labelEtapa12.setIcon(ICON_PENDIENTE);
                } else if (this.numeroEstado == 3 && VistaPrincipal.nvista == 3) {
                    this.labelEtapa4.setIcon(ICON_COMPLETADA);
                    this.labelEtapa3.setIcon(ICON_ACTUAL);
                } else if (this.numeroEstado == 4 && VistaPrincipal.nvista == 4) {
                    this.labelEtapa5.setIcon(ICON_COMPLETADA);
                    this.labelEtapa4.setIcon(ICON_ACTUAL);
                } else if (this.numeroEstado == 5 && VistaPrincipal.nvista == 5) {
                    this.labelEtapa6.setIcon(ICON_COMPLETADA);
                    this.labelEtapa5.setIcon(ICON_ACTUAL);
                } else if (this.numeroEstado == 6 && VistaPrincipal.nvista == 6) {
                    this.labelEtapa7.setIcon(ICON_COMPLETADA);
                    this.labelEtapa6.setIcon(ICON_ACTUAL);
                } else if (this.numeroEstado == 7 && VistaPrincipal.nvista == 7) {
                    this.labelEtapa8.setIcon(ICON_COMPLETADA);
                    this.labelEtapa7.setIcon(ICON_ACTUAL);
                } else if (this.numeroEstado == 8 && VistaPrincipal.nvista == 8) {
                    if (this.getDescripcion1Val() == 1) {
                        this.labelEtapa9.setIcon(ICON_COMPLETADA);
                        this.labelEtapa8.setIcon(ICON_ACTUAL);
                    } else {
                        this.labelEtapa9.setIcon(ICON_PENDIENTE);
                        this.labelEtapa8.setIcon(ICON_ACTUAL);
                    }
                } else if (this.numeroEstado == 9 && VistaPrincipal.nvista == 9) {
                    this.setDescripcion1Val(1);
                    this.labelEtapa10.setIcon(ICON_COMPLETADA);
                    this.labelEtapa9.setIcon(ICON_ACTUAL);
                } else if (this.numeroEstado == 10 && VistaPrincipal.nvista == 10) {
                    this.labelEtapa11.setIcon(ICON_COMPLETADA);
                    this.labelEtapa10.setIcon(ICON_ACTUAL);
                    this.numeroEstado = 9;
                } else if (this.numeroEstado == 11 && VistaPrincipal.nvista == 11) {
                    this.labelEtapa12.setIcon(ICON_COMPLETADA);
                    this.labelEtapa11.setIcon(ICON_ACTUAL);
                }
            } else if (eleccion == JOptionPane.CANCEL_OPTION) {
                eleccion = JOptionPane.YES_OPTION;
            }
        }
        if (nvista == 5) {
            Object[] opciones = {"Si", "No", "Cancelar"};
            eleccion = JOptionPane.showOptionDialog(
                    this,
                    "Se volverá a la etapa de identificar casos de uso segundo paso del programa y se perderán los datos editados de la etapa anterior.\r\n"
                    + "¿Desea Guardar ahora los datos de la misma?", "Advertencia",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, opciones, "Aceptar");
            if (eleccion == JOptionPane.YES_OPTION) {
                   buttonGuardarComoActionPerformed(evt);
                   this.control.activarVatras(nvista, numeroEstado);
                // TODO: Factorizar esto si es posible
                if (this.numeroEstado == 2 && VistaPrincipal.nvista == 2) {
                    this.labelEtapa2.setIcon(ICON_ACTUAL);
                    this.labelEtapa3.setIcon(ICON_PENDIENTE);
                    this.labelEtapa4.setIcon(ICON_PENDIENTE);
                    this.labelEtapa5.setIcon(ICON_PENDIENTE);
                    this.labelEtapa6.setIcon(ICON_PENDIENTE);
                    this.labelEtapa7.setIcon(ICON_PENDIENTE);
                    this.labelEtapa8.setIcon(ICON_PENDIENTE);
                    this.labelEtapa9.setIcon(ICON_PENDIENTE);
                    this.labelEtapa10.setIcon(ICON_PENDIENTE);
                    this.labelEtapa11.setIcon(ICON_PENDIENTE);
                    this.labelEtapa12.setIcon(ICON_PENDIENTE);
                } else if (this.numeroEstado == 3 && VistaPrincipal.nvista == 3) {
                    this.labelEtapa4.setIcon(ICON_COMPLETADA);
                    this.labelEtapa3.setIcon(ICON_ACTUAL);
                } else if (this.numeroEstado == 4 && VistaPrincipal.nvista == 4) {
                    this.labelEtapa5.setIcon(ICON_COMPLETADA);
                    this.labelEtapa4.setIcon(ICON_ACTUAL);
                } else if (this.numeroEstado == 5 && VistaPrincipal.nvista == 5) {
                    this.labelEtapa6.setIcon(ICON_COMPLETADA);
                    this.labelEtapa5.setIcon(ICON_ACTUAL);
                } else if (this.numeroEstado == 6 && VistaPrincipal.nvista == 6) {
                    this.labelEtapa7.setIcon(ICON_COMPLETADA);
                    this.labelEtapa6.setIcon(ICON_ACTUAL);
                } else if (this.numeroEstado == 7 && VistaPrincipal.nvista == 7) {
                    this.labelEtapa8.setIcon(ICON_COMPLETADA);
                    this.labelEtapa7.setIcon(ICON_ACTUAL);
                } else if (this.numeroEstado == 8 && VistaPrincipal.nvista == 8) {
                    if (this.getDescripcion1Val() == 1) {
                        this.labelEtapa9.setIcon(ICON_COMPLETADA);
                        this.labelEtapa8.setIcon(ICON_ACTUAL);
                    } else {
                        this.labelEtapa9.setIcon(ICON_PENDIENTE);
                        this.labelEtapa8.setIcon(ICON_ACTUAL);
                    }
                } else if (this.numeroEstado == 9 && VistaPrincipal.nvista == 9) {
                    this.setDescripcion1Val(1);
                    this.labelEtapa10.setIcon(ICON_COMPLETADA);
                    this.labelEtapa9.setIcon(ICON_ACTUAL);
                } else if (this.numeroEstado == 10 && VistaPrincipal.nvista == 10) {
                    this.labelEtapa11.setIcon(ICON_COMPLETADA);
                    this.labelEtapa10.setIcon(ICON_ACTUAL);
                    this.numeroEstado = 9;
                } else if (this.numeroEstado == 11 && VistaPrincipal.nvista == 11) {
                    this.labelEtapa12.setIcon(ICON_COMPLETADA);
                    this.labelEtapa11.setIcon(ICON_ACTUAL);
                }
            } else if (eleccion == JOptionPane.CANCEL_OPTION) {
                eleccion = JOptionPane.YES_OPTION;
            }
        }
        if (eleccion == JOptionPane.NO_OPTION) {
            this.control.activarVatras(nvista, numeroEstado);
            
                if(buttonDeshacer.isEnabled() && buttonRehacer.isEnabled()){
                
                    buttonDeshacer.setEnabled(false);
                    buttonRehacer.setEnabled(false);
                }
                
            // TODO: Factorizar esto si es posible
            if (this.numeroEstado == 2 && VistaPrincipal.nvista == 2) {
                this.labelEtapa2.setIcon(ICON_ACTUAL);
                this.labelEtapa3.setIcon(ICON_PENDIENTE);
                this.labelEtapa4.setIcon(ICON_PENDIENTE);
                this.labelEtapa5.setIcon(ICON_PENDIENTE);
                this.labelEtapa6.setIcon(ICON_PENDIENTE);
                this.labelEtapa7.setIcon(ICON_PENDIENTE);
                this.labelEtapa8.setIcon(ICON_PENDIENTE);
                this.labelEtapa9.setIcon(ICON_PENDIENTE);
                this.labelEtapa10.setIcon(ICON_PENDIENTE);
                this.labelEtapa11.setIcon(ICON_PENDIENTE);
                this.labelEtapa12.setIcon(ICON_PENDIENTE);
            } else if (this.numeroEstado == 3 && VistaPrincipal.nvista == 3) {
                this.labelEtapa4.setIcon(ICON_COMPLETADA);
                this.labelEtapa3.setIcon(ICON_ACTUAL);
            } else if (this.numeroEstado == 4 && VistaPrincipal.nvista == 4) {
                this.labelEtapa5.setIcon(ICON_COMPLETADA);
                this.labelEtapa4.setIcon(ICON_ACTUAL);
            } else if (this.numeroEstado == 5 && VistaPrincipal.nvista == 5) {
                this.labelEtapa6.setIcon(ICON_COMPLETADA);
                this.labelEtapa5.setIcon(ICON_ACTUAL);
            } else if (this.numeroEstado == 6 && VistaPrincipal.nvista == 6) {
                this.labelEtapa7.setIcon(ICON_COMPLETADA);
                this.labelEtapa6.setIcon(ICON_ACTUAL);
            } else if (this.numeroEstado == 7 && VistaPrincipal.nvista == 7) {
                this.labelEtapa8.setIcon(ICON_COMPLETADA);
                this.labelEtapa7.setIcon(ICON_ACTUAL);
            } else if (this.numeroEstado == 8 && VistaPrincipal.nvista == 8) {
                if (this.getDescripcion1Val() == 1) {
                    this.labelEtapa9.setIcon(ICON_COMPLETADA);
                    this.labelEtapa8.setIcon(ICON_ACTUAL);
                } else {
                    this.labelEtapa9.setIcon(ICON_PENDIENTE);
                    this.labelEtapa8.setIcon(ICON_ACTUAL);
                }
            } else if (this.numeroEstado == 9 && VistaPrincipal.nvista == 9) {
                this.setDescripcion1Val(1);
                this.labelEtapa10.setIcon(ICON_COMPLETADA);
                this.labelEtapa9.setIcon(ICON_ACTUAL);
            } else if (this.numeroEstado == 10 && VistaPrincipal.nvista == 10) {
                this.labelEtapa11.setIcon(ICON_COMPLETADA);
                this.labelEtapa10.setIcon(ICON_ACTUAL);
                this.numeroEstado = 9;
            } else if (this.numeroEstado == 11 && VistaPrincipal.nvista == 11) {
                this.labelEtapa12.setIcon(ICON_COMPLETADA);
                this.labelEtapa11.setIcon(ICON_ACTUAL);
            }
        }
    }//GEN-LAST:event_buttonAnteriorActionPerformed

    private void buttonAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAbrirActionPerformed
        
        int respuesta = JOptionPane.NO_OPTION;

        if (numeroEstado > 1) {
            respuesta = JOptionPane.showConfirmDialog(this, "El proyecto actual se perderá,\r\n¿Desea guardar los cambios?",
                    "Nuevo Proyecto", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        }
        if (respuesta == JOptionPane.YES_OPTION) {
            buttonGuardarComoActionPerformed(evt);
            cargarSesion();
        } else if (respuesta == JOptionPane.NO_OPTION) {
            cargarSesion();
        } 
    }//GEN-LAST:event_buttonAbrirActionPerformed

    private void cargarSesion(){
        
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo XML (.xml)", "xml");
        fileChooser.setFileFilter(filtro);
        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            String resp = null;
            File file = fileChooser.getSelectedFile();
            String path = file.getPath();
            controlador = new ControladorCargarArchivos(control);
            try {
                // Valida la estructura del archivo de sesion                       
                if (controlador.validarSesionXML(path) == null) {
                    setTextLabelEstado("Cargando Sesión...");

                    // Para cargar el archivo de la sesion anterior
                    resp = controlador.cargarSesionAnterior(path);
                    this.cargarA = 1;
                    if (resp == null) {
                        // TODO: Es necesario un icono asi en este JOptionPane?
                        Icon ico = new ImageIcon(getClass().getResource("/Fotos/tick2.png"));
                        setTextLabelEstado("Sesión cargada.");
                        this.ruta = path;
                        JOptionPane.showMessageDialog(null, "Los sesión ha sido cargada exitosamente", "Aviso", JOptionPane.INFORMATION_MESSAGE, ico);
                        controlador.irControladorSesion();
                        //Antes de re-dibujar iconos de estado, se re-inician todos
                        for (int i = 0; i < etapas.size(); i++) {
                            etapas.get(i).setIcon(ICON_PENDIENTE);
                        }
                        if (VistaPrincipal.nvista == 3) {
                            this.labelEtapa1.setIcon(ICON_COMPLETADA);
                            this.labelEtapa2.setIcon(ICON_COMPLETADA);
                            this.labelEtapa3.setIcon(ICON_ACTUAL);
                        } else if (VistaPrincipal.nvista == 4) {
                            this.labelEtapa1.setIcon(ICON_COMPLETADA);
                            this.labelEtapa2.setIcon(ICON_COMPLETADA);
                            this.labelEtapa3.setIcon(ICON_COMPLETADA);
                            this.labelEtapa4.setIcon(ICON_ACTUAL);
                        } else if (VistaPrincipal.nvista == 5) {
                            this.labelEtapa1.setIcon(ICON_COMPLETADA);
                            this.labelEtapa2.setIcon(ICON_COMPLETADA);
                            this.labelEtapa3.setIcon(ICON_COMPLETADA);
                            this.labelEtapa4.setIcon(ICON_COMPLETADA);
                            this.labelEtapa5.setIcon(ICON_ACTUAL);
                        } else if (VistaPrincipal.nvista == 6) {
                            this.labelEtapa1.setIcon(ICON_COMPLETADA);
                            this.labelEtapa2.setIcon(ICON_COMPLETADA);
                            this.labelEtapa3.setIcon(ICON_COMPLETADA);
                            this.labelEtapa4.setIcon(ICON_COMPLETADA);
                            this.labelEtapa5.setIcon(ICON_COMPLETADA);
                            this.labelEtapa6.setIcon(ICON_ACTUAL);
                        } else if (VistaPrincipal.nvista == 7) {
                            this.labelEtapa1.setIcon(ICON_COMPLETADA);
                            this.labelEtapa2.setIcon(ICON_COMPLETADA);
                            this.labelEtapa3.setIcon(ICON_COMPLETADA);
                            this.labelEtapa4.setIcon(ICON_COMPLETADA);
                            this.labelEtapa5.setIcon(ICON_COMPLETADA);
                            this.labelEtapa6.setIcon(ICON_COMPLETADA);
                            this.labelEtapa7.setIcon(ICON_ACTUAL);
                        } else if (VistaPrincipal.nvista == 8) {
                            this.labelEtapa1.setIcon(ICON_COMPLETADA);
                            this.labelEtapa2.setIcon(ICON_COMPLETADA);
                            this.labelEtapa3.setIcon(ICON_COMPLETADA);
                            this.labelEtapa4.setIcon(ICON_COMPLETADA);
                            this.labelEtapa5.setIcon(ICON_COMPLETADA);
                            this.labelEtapa6.setIcon(ICON_COMPLETADA);
                            this.labelEtapa7.setIcon(ICON_COMPLETADA);
                            this.labelEtapa8.setIcon(ICON_ACTUAL);
                        } else if (VistaPrincipal.nvista == 9) {
                            this.labelEtapa1.setIcon(ICON_COMPLETADA);
                            this.labelEtapa2.setIcon(ICON_COMPLETADA);
                            this.labelEtapa3.setIcon(ICON_COMPLETADA);
                            this.labelEtapa4.setIcon(ICON_COMPLETADA);
                            this.labelEtapa5.setIcon(ICON_COMPLETADA);
                            this.labelEtapa6.setIcon(ICON_COMPLETADA);
                            this.labelEtapa7.setIcon(ICON_COMPLETADA);
                            this.labelEtapa8.setIcon(ICON_COMPLETADA);
                            this.labelEtapa9.setIcon(ICON_ACTUAL);
                        } else if (VistaPrincipal.nvista == 10) {
                            this.labelEtapa1.setIcon(ICON_COMPLETADA);
                            this.labelEtapa2.setIcon(ICON_COMPLETADA);
                            this.labelEtapa3.setIcon(ICON_COMPLETADA);
                            this.labelEtapa4.setIcon(ICON_COMPLETADA);
                            this.labelEtapa5.setIcon(ICON_COMPLETADA);
                            this.labelEtapa6.setIcon(ICON_COMPLETADA);
                            this.labelEtapa7.setIcon(ICON_COMPLETADA);
                            this.labelEtapa8.setIcon(ICON_COMPLETADA);
                            this.labelEtapa9.setIcon(ICON_COMPLETADA);
                            this.labelEtapa10.setIcon(ICON_ACTUAL);
                        } else if (VistaPrincipal.nvista == 11) {
                            this.labelEtapa1.setIcon(ICON_COMPLETADA);
                            this.labelEtapa2.setIcon(ICON_COMPLETADA);
                            this.labelEtapa3.setIcon(ICON_COMPLETADA);
                            this.labelEtapa4.setIcon(ICON_COMPLETADA);
                            this.labelEtapa5.setIcon(ICON_COMPLETADA);
                            this.labelEtapa6.setIcon(ICON_COMPLETADA);
                            this.labelEtapa7.setIcon(ICON_COMPLETADA);
                            this.labelEtapa8.setIcon(ICON_COMPLETADA);
                            this.labelEtapa9.setIcon(ICON_COMPLETADA);
                            this.labelEtapa10.setIcon(ICON_COMPLETADA);
                            this.labelEtapa11.setIcon(ICON_ACTUAL);
                        } else if (VistaPrincipal.nvista == 12) {
                            this.labelEtapa1.setIcon(ICON_COMPLETADA);
                            this.labelEtapa2.setIcon(ICON_COMPLETADA);
                            this.labelEtapa3.setIcon(ICON_COMPLETADA);
                            this.labelEtapa4.setIcon(ICON_COMPLETADA);
                            this.labelEtapa5.setIcon(ICON_COMPLETADA);
                            this.labelEtapa6.setIcon(ICON_COMPLETADA);
                            this.labelEtapa7.setIcon(ICON_COMPLETADA);
                            this.labelEtapa8.setIcon(ICON_COMPLETADA);
                            this.labelEtapa9.setIcon(ICON_COMPLETADA);
                            this.labelEtapa10.setIcon(ICON_COMPLETADA);
                            this.labelEtapa11.setIcon(ICON_COMPLETADA);
                            this.labelEtapa12.setIcon(ICON_ACTUAL);
                        } else if (VistaPrincipal.nvista == 13) {
                            this.labelEtapa1.setIcon(ICON_COMPLETADA);
                            this.labelEtapa2.setIcon(ICON_COMPLETADA);
                            this.labelEtapa3.setIcon(ICON_COMPLETADA);
                            this.labelEtapa4.setIcon(ICON_COMPLETADA);
                            this.labelEtapa5.setIcon(ICON_COMPLETADA);
                            this.labelEtapa6.setIcon(ICON_COMPLETADA);
                            this.labelEtapa7.setIcon(ICON_COMPLETADA);
                            this.labelEtapa8.setIcon(ICON_COMPLETADA);
                            this.labelEtapa9.setIcon(ICON_COMPLETADA);
                            this.labelEtapa10.setIcon(ICON_COMPLETADA);
                            this.labelEtapa11.setIcon(ICON_COMPLETADA);
                            this.labelEtapa12.setIcon(ICON_COMPLETADA);
                        }
                    } else {
                        setTextLabelEstado("Error al cargar archivos");
                        JOptionPane.showMessageDialog(null, "Los archivos de entrada presentan problemas al cargar. " + resp, "Aviso", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    setTextLabelEstado("Error al cargar archivos");
                    JOptionPane.showMessageDialog(null, "El archivo seleccionado no corresponde a un archivo de sesión valido", "¡Error!", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(JPCargarArchivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 }
    
    
    private void buttonGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGuardarComoActionPerformed
        // Guarda la sesion con los datos ingresados hasta el momento en un archivo xml
        if (VistaPrincipal.nvista == 1) {
            control.getInicio().Alerta("No es posible guardar sesión en este paso");
        } else if (VistaPrincipal.nvista == 2) {
            control.getControladorCA().Alerta("No es posible guardar sesión en este paso");
        } else if (VistaPrincipal.nvista == 3 && control.getControladorCU1().validarCU1() == false) {
            control.getControladorCU1().Alerta("No es posible guardar sesión si no ha completado al menos los pasos de esta ventana.");
        } else {
            guardarComo();
        }
    }//GEN-LAST:event_buttonGuardarComoActionPerformed

    private void buttonDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeshacerActionPerformed
        
            itemDeshacerActionPerformed(evt);
        
    }//GEN-LAST:event_buttonDeshacerActionPerformed

    private void buttonRehacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRehacerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRehacerActionPerformed

    private void itemAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAyudaActionPerformed
        String path = null;
        try {
            path = new File(".").getCanonicalPath();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        Desktop escritorio = Desktop.getDesktop();
        try {
            File archivo = new File(path + "/Ayuda.chm");
            escritorio.open(archivo);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_itemAyudaActionPerformed

    private void itemGuardarProyectoComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGuardarProyectoComoActionPerformed
        buttonGuardarComoActionPerformed(evt);
    }//GEN-LAST:event_itemGuardarProyectoComoActionPerformed

    private void itemAbrirProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAbrirProyectoActionPerformed
        buttonAbrirActionPerformed(evt);
    }//GEN-LAST:event_itemAbrirProyectoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO: Ver si es posible integrar el funcionamiento con metodos de guardado, para evitar este copy+paste
        // Guarda la sesion con los datos ingresados hasta el momento en un archivo xml
        Object[] opciones = {"Si", "No", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this, "Se cerrará el programa,\r\n¿Desea Guardar los datos antes de salir?", "Advertencia", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
        if (eleccion == JOptionPane.YES_OPTION) {
            setTextLabelEstado("Guardando...");
            if (VistaPrincipal.nvista == 1) {
                setTextLabelEstado("Error al guardar");
                control.getInicio().Alerta("No es posible guardar en este paso");
            } else if (VistaPrincipal.nvista == 2) {
                setTextLabelEstado("Error al guardar");
                control.getControladorCA().Alerta("No es posible guardar en este paso");
            } else if (VistaPrincipal.nvista == 3 && control.getControladorCU1().validarCU1() == false) {
                setTextLabelEstado("Error al guardar");
                control.getControladorCU1().Alerta("No es posible guardar si no ha completado al menos los pasos de esta ventana.");
            } else {
                guardar();
            }
            if (VistaPrincipal.nvista != 1 && VistaPrincipal.nvista != 2) {
                setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        } else if (eleccion == JOptionPane.NO_OPTION) {
            System.exit(0);
        } else if (eleccion == JOptionPane.CANCEL_OPTION)
                setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        formWindowClosing(null);
    }//GEN-LAST:event_itemSalirActionPerformed

    private void itemDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDeshacerActionPerformed
        
       

        if (this.numeroEstado == 3 && VistaPrincipal.nvista == 3) {
            this.control.getControladorCU1().getVista().deshacer();
        }
        if (this.numeroEstado == 4 && VistaPrincipal.nvista == 4) {
            this.control.getControladorCU2().getVista().deshacer();
        }
        if (this.numeroEstado == 6 && VistaPrincipal.nvista == 6) {
            this.control.getConroladorP().getVista().deshacer();
        }
        if (this.numeroEstado == 7 && VistaPrincipal.nvista == 7) {
            this.control.getControladorR().getVista().deshacer();
        }
        if (this.numeroEstado == 8 && VistaPrincipal.nvista == 8) {
            this.control.getControladorPC().getVista().deshacer();
        }
    }//GEN-LAST:event_itemDeshacerActionPerformed

    private void buttonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNuevoActionPerformed
        int respuesta = JOptionPane.NO_OPTION;
        if (numeroEstado > 1) {
            respuesta = JOptionPane.showConfirmDialog(this, "El proyecto actual se perderá,\r\n¿Desea guardar los cambios?",
                    "Nuevo Proyecto", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        }
        if (respuesta == JOptionPane.YES_OPTION) {
            buttonGuardarComoActionPerformed(evt);
            iniciarNuevoProyecto();
        } else if (respuesta == JOptionPane.NO_OPTION) {
            iniciarNuevoProyecto();
        }
    }//GEN-LAST:event_buttonNuevoActionPerformed

    private void itemNuevoProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoProyectoActionPerformed
        buttonNuevoActionPerformed(evt);
    }//GEN-LAST:event_itemNuevoProyectoActionPerformed

    private void itemRehacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRehacerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemRehacerActionPerformed

    private void buttonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGuardarActionPerformed
        if (VistaPrincipal.nvista == 1) {
                control.getInicio().Alerta("No es posible guardar sesión en este paso");
            } else if (VistaPrincipal.nvista == 2) {
                control.getControladorCA().Alerta("No es posible guardar sesión en este paso");
            } else if (VistaPrincipal.nvista == 3 && control.getControladorCU1().validarCU1() == false) {
                control.getControladorCU1().Alerta("No es posible guardar sesión si no ha completado al menos los pasos de esta ventana.");
            } else {
                guardar();
                //guardado=true;
            }
    }//GEN-LAST:event_buttonGuardarActionPerformed

    private void itemGuardarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGuardarProyectoActionPerformed
        buttonGuardarActionPerformed(evt);
    }//GEN-LAST:event_itemGuardarProyectoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAbrir;
    private javax.swing.JButton buttonAnterior;
    private javax.swing.JButton buttonDeshacer;
    private javax.swing.JButton buttonGuardar;
    private javax.swing.JButton buttonGuardarComo;
    private javax.swing.JButton buttonNuevo;
    private javax.swing.JButton buttonRehacer;
    private javax.swing.JButton buttonSiguiente;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JMenuItem itemAbrirProyecto;
    private javax.swing.JMenuItem itemAcercaDe;
    private javax.swing.JMenuItem itemAyuda;
    private javax.swing.JMenuItem itemDeshacer;
    private javax.swing.JMenuItem itemGuardarProyecto;
    private javax.swing.JMenuItem itemGuardarProyectoComo;
    private javax.swing.JMenuItem itemNuevoProyecto;
    private javax.swing.JMenuItem itemRehacer;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JLabel labelEtapa1;
    private javax.swing.JLabel labelEtapa10;
    private javax.swing.JLabel labelEtapa11;
    private javax.swing.JLabel labelEtapa12;
    private javax.swing.JLabel labelEtapa2;
    private javax.swing.JLabel labelEtapa3;
    private javax.swing.JLabel labelEtapa4;
    private javax.swing.JLabel labelEtapa5;
    private javax.swing.JLabel labelEtapa6;
    private javax.swing.JLabel labelEtapa7;
    private javax.swing.JLabel labelEtapa8;
    private javax.swing.JLabel labelEtapa9;
    private javax.swing.JLabel labelTituloEtapas;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuEdicion;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelControles;
    private javax.swing.JPanel panelEstado;
    private javax.swing.JPanel panelEtapas;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
}
