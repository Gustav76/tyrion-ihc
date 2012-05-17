/*1*/ package Controlador;
/*2*/
/*3*/ import Modelo.ModeloCasoDeUso;
/*4*/ import Modelo.ModeloMapaConversacional;
/*5*/ import Modelo.ModeloObjetivosDelNegocio;
/*6*/ import Modelo.ModeloSesion;
import Vista.JPDescripcion1;
import java.awt.CardLayout;
/*9*/ import java.util.Vector;
/*10*/
/*11*/ /**
 *Clase del controlador de la vista referente a la primera descripcion de los casos de uso
 * @author DavidyAly
 */
/*15*/ public class ControladorDescripcion1 {
    /*16*/
    /*17*/ public JPDescripcion1 vista;
    /*19*/ public ControladorDescripcion1 control;
    /*20*/ public ControladorPrincipal controlMain;
    /*21*/ public ModeloMapaConversacional modeloMC;
    /*22*/ public ModeloObjetivosDelNegocio modeloON;
    /*23*/ public ModeloCasoDeUso modeloCU;
           public boolean valido = false;
    /*24*/
    /*25*/ /**
     *Método del controlador respecto a la vista de la primera descripcion de los casos de uso
     * @param controlMain, controlador principal de la aplicacion
     * @param modeloMC, modelo conversacional instanciado en esta primera descripcion del caso de uso
     * @param modeloON, modelo de objetivo del negocio instanciado en esta primera descripcion del caso de uso
     * @param modeloCU, modelo de casos de uso instanciado en esta primera descripcion del caso de uso
     */

    /*32*/ public ControladorDescripcion1(ControladorPrincipal controlMain, ModeloMapaConversacional modeloMC, ModeloObjetivosDelNegocio modeloON, ModeloCasoDeUso modeloCU) {
        /*33*/ this.controlMain = controlMain;
        /*34*/ this.modeloMC = modeloMC;
        /*35*/ this.modeloON = modeloON;
        /*36*/ this.modeloCU = modeloCU;
        /*37*/ vista = new JPDescripcion1(this);
        /*39*/    }
    /*40*/
    /*41*/

    public void activarVista() {
        ((CardLayout) controlMain.getVista().getPanel().getLayout()).show(controlMain.getVista().getPanel(), "VDescripcion1");
    }

    public JPDescripcion1 getVista() {
        return vista;
    }

    /**
     *Método que hace visible la ventana asociada a la primera descripcion de los casos de uso
     */
    /*44*/ public void irVistaDescripcion1() {
        /*45*/ this.vista.setTareasCU();
        /*46*/ if (this.getActoresCU() != null) {
            /*47*/ this.vista.setClientes();
            /*48*/ this.vista.setRealizadores();
            /*49*/        }
        /*50*/ this.vista.setVisible(true);
        /*51*/    }
    /*52*/
    /*53*/ /**
     *Método que permite cerrar/ocultar la vista correspondiente a la ayuda acerca de la
     * primera descripción de los casos de uso
     */
    /*56*/ public void cerrarVistaAyudaDescripcion1() {
        /*57*/ this.vista.setVisible(true);
        /*59*/    }
    /*60*/
    /*61*/
    /*62*/
    /*63*/
    /*64*/ /**
     * Función que invoca un metodo para obtener los actores de un caso de uso, desde un modelo conversacional
     * @return la llamada a la captura de los actores de un caso de uso
     */
    /*68*/ public Vector getActoresCU() {
        /*69*/ return this.modeloCU.getActores();
        /*70*/    }
    /*71*/
    /*72*/ /**
     *Funcion que invoca un metodo para obtener las tareas, desde un modelo de objetivo de negocio
     * @return la llamada a la captura de las tareas
     */
    /*76*/ public Vector getTareas() {
        /*77*/ return this.modeloON.getTareas();
        /*78*/    }
    /*79*/
    /*80*/ /**
     *Funcion que invoca un metodo para obtener el nombre de un caso de uso
     * @return la llamada a la captura del nombre del caso de uso
     */
    /*84*/ public Vector getNomCU() {
        /*85*/ return this.modeloCU.getNombreCasoUso();
        /*86*/    }
    /*87*/
    /*88*/ /**
     *Método que invoca la obtención de los clientes de un mapa conversacional
     * @return llamada al método que separa y almacena a los clientes
     */
    /*92*/ public Vector getClientes() {
        /*93*/ return this.modeloMC.getClientes2();
        /*94*/    }
    /*95*/
    /*96*/ /**
     *Método que invoca la obtención de los realizadores de un mapa conversacional
     * @return llamada al método que separa y almacena a los realizadores
     */
    /*100*/ public Vector getRealizadores() {
        /*101*/ return this.modeloMC.getRealizadores2();
        /*102*/    }
    /*103*/
    /*104*/ /**
     *Método que invoca la obtención de los clientes de un mapa conversacional,
     * según la primera descripcion de los casos de uso
     * @return llamada al método que identifica y almacena a los clientes
     */
    /*108*/ public Vector getClientesD1() {
        /*109*/ return this.modeloMC.getClientesD1();
        /*110*/    }
     /*111*/
    /*112*/ /**
     *Método que invoca la obtención de los realizadores de un mapa conversacional,
     * según la primera descripcion de los casos de uso
     * @return llamada al método que separa y almacena a los realizadores
     */
    /*116*/ public Vector getRealizadoresD1() {
        /*117*/ return this.modeloMC.getRealizadoresD1();
        /*118*/    }
    /*119*/
    /*120*/ /**
     *Método que invoca la modificación de información en el modelo conversacional,
     * (clientes y realizadores) el modelo de los objetivos de negocio (tareas)
     * y en el modelo de los casos de uso (nombre del caso de uso)
     * @param clientes, información de clientes, a ser modificada en el mapa conversacional
     * @param realizadores, información de los realizadores, a ser modificada en el mapa conversacional
     * @param nomCU, nombre del caso de uso, a ser modificado en el modelos de objetivo de negocio
     * @param tareas, tareas a ser modificadas en el modelo de casos de uso
     */
    /*127*/ public void setDatosD2(Vector clientes, Vector realizadores, Vector nomCU, Vector tareas) {
        /*128*/ this.modeloMC.setClientesD1(clientes);
        /*129*/ this.modeloMC.setRealizadoresD1(realizadores);
        /*130*/ this.modeloON.setTareasD1(tareas);
        /*131*/ this.modeloCU.setNombreCuD1(nomCU);
        /*132*/    }

    /*127*/ public void setDatosD2() {
        /*128*/ this.modeloMC.setClientesD1(vista.getClientes());
        /*129*/ this.modeloMC.setRealizadoresD1(vista.getRealizadores());
        /*130*/ this.modeloON.setTareasD1(vista.getNomCU());
        /*131*/ this.modeloCU.setNombreCuD1(vista.getTareas());
        /*132*/    }

    /*133*/
    /*134*/ /**
     *Método que permite almacenar a los actores del caso de uso desde el modelo conversacional
     * @return vector con los actores del caso de uso
     */
    /*138*/ public Vector getActores() {
        /*139*/ Vector vActores = new Vector();
        /*140*/ Vector actores;
        /*141*/ Vector clientes = this.modeloMC.getClientes2();
        /*142*/ Vector realizadores = this.modeloMC.getRealizadores2();
        /*143*/ for (int i = 0; i < clientes.size(); i++) {
            /*144*/ actores = new Vector();
            /*145*/ actores.add(clientes.get(i) + " (Cliente)");
            /*146*/ actores.add(realizadores.get(i) + " (Realizador)");
            /*147*/ actores.add("Sistema");
            /*148*/ vActores.add(actores);
            /*149*/        }
        /*150*/ return vActores;
        /*151*/    }
    /*152*/
    /*153*/ /**
     *Función que modifica el contenido (respectivo a los actores) del modelo de los casos de uso
     * @param nomCU, vector que contiene el nombre del caso de uso
     * @param clientes, vector que almacena individualmente a los clientes del caso de uso (correspondiente a nomCU)
     * @param realizadores, vector que almacena individualmente a los realizadores del caso de uso
     */
    /*159*/ public void setActoresCU(Vector nomCU, Vector clientes, Vector realizadores) {
        /*160*/ String CU = null;
        /*161*/ Vector actores = new Vector();
        /*162*/ for (int i = 0; i < nomCU.size(); i++) {
            /*163*/ if (i == 0) {
                /*164*/ CU = nomCU.get(i).toString();
                /*165*/ if (!clientes.get(i).toString().equals("Sistema")) {
                    /*166*/ actores.add(this.extraerActores(clientes.get(i).toString()));
                    /*167*/                }
                /*168*/ if (!realizadores.get(i).toString().equals("Sistema")) {
                    /*169*/ actores.add(this.extraerActores(realizadores.get(i).toString()));
                    /*170*/                }
                /*171*/            } else {
                /*172*/ if (!CU.equals(nomCU.get(i).toString())) {
                    /*173*/ CU = nomCU.get(i).toString();
                    /*174*/ if (!clientes.get(i).toString().equals("Sistema")) {
                        /*175*/ actores.add(this.extraerActores(clientes.get(i).toString()));
                        /*176*/                    }
                    /*177*/ if (!realizadores.get(i).toString().equals("Sistema")) {
                        /*178*/ actores.add(this.extraerActores(realizadores.get(i).toString()));
                        /*179*/                    }
                    /*180*/                }
                /*181*/            }
            /*182*/        }
        /*183*/ this.modeloCU.setActores(actores);
        /*184*/    }

    public void setActorCelda() {
        vista.setActores();
    }

    /*159*/ public void setActoresCU() {
        Vector nomCU = vista.getNomCU();
        Vector clientes = vista.getClientes();
        Vector realizadores = vista.getRealizadores();

        /*160*/ String CU = null;
        /*161*/ Vector actores = new Vector();
        /*162*/ for (int i = 0; i < nomCU.size(); i++) {
            /*163*/ if (i == 0) {
                /*164*/ CU = nomCU.get(i).toString();
                /*165*/ if (!clientes.get(i).toString().equals("Sistema")) {
                    /*166*/ actores.add(this.extraerActores(clientes.get(i).toString()));
                    /*167*/                }
                /*168*/ if (!realizadores.get(i).toString().equals("Sistema")) {
                    /*169*/ actores.add(this.extraerActores(realizadores.get(i).toString()));
                    /*170*/                }
                /*171*/            } else {
                /*172*/ if (!CU.equals(nomCU.get(i).toString())) {
                    /*173*/ CU = nomCU.get(i).toString();
                    /*174*/ if (!clientes.get(i).toString().equals("Sistema")) {
                        /*175*/ actores.add(this.extraerActores(clientes.get(i).toString()));
                        /*176*/                    }
                    /*177*/ if (!realizadores.get(i).toString().equals("Sistema")) {
                        /*178*/ actores.add(this.extraerActores(realizadores.get(i).toString()));
                        /*179*/                    }
                    /*180*/                }
                /*181*/            }
            /*182*/        }
        /*183*/ this.modeloCU.setActores(actores);
        /*184*/    }

    /*185*/
    /*186*/
    /**
     *Función que permite almacenar individualmente (en un vector) los actores de un caso de uso,
     * desde una cadena de caracteres.
     * @param String actores, contiene los actores
     * que van a ser almacendos en el vector
     * @return vector que almacena los actores del caso de uso
     */
    /*191*/ public Vector extraerActores(String actores) {
        /*192*/ Vector act = new Vector();
        /*193*/ String aux[] = actores.split("]");
        /*194*/ for (int i = 0; i < aux.length - 1; i++) {
            /*195*/             //System.out.println(aux[i].substring(1));
/*196*/ act.add(aux[i].substring(1));
            /*197*/        }
        /*198*/ return act;
        /*199*/    }
    /*200*/
    /*201*/

    /**
     *Método que invoca el controlador de la segunda descripción de los casos de uso.
     * Oculta la vista correspondiente a la primera descripcion de los casos de uso.
     */
    /*204*/ public void irControladorDescripcion2() {
        /*205*/ this.controlMain.irControladorDescripcion2(modeloMC, modeloON, modeloCU);
        /*206*/ this.vista.setVisible(false);
        /*207*/    }
    /*208*/
    /*209*/

    /**
     * Método que invoca el controlador de las post-condiciones de un caso de uso,
     * desde el controlador principal. Oculta la vista respectiva a la primera
     * descripcion de los casos de uso.
     */
    /*212*/ public void irControladorPostCondiciones() {
        /*213*/ this.controlMain.irControladorPostCondiciones(modeloMC, modeloON, modeloCU);
        /*214*/ this.vista.setVisible(false);
        /*215*/    }
    /*216*/
    /*217*/

    /**
     * Método que invoca el controlador de ayuda de la primera descripcion de los casos de uso.
     * Puede poner a vista del usuario la ventana de ayuda u ocultarla, segun sea el caso.
     */
    /*230*/
    /*231*/

    /**
     *La función recibe una cadena de caracteres y el invocarla genera el archivo XML 
     * de una sesión anterior, dicho archivo consta de 6 casos de uso en base a un mapa
     * conversacional, un modelo de objeto de negocios y un modelo de casos de uso.
     *@ param ruta Indica la ruta donde se guardará el archivo XML
     */
    /*235*/ public void archivoSesion(String ruta) {
    /*236*/     ModeloSesion sa = new ModeloSesion(modeloMC, modeloON, modeloCU);
    /*237*/     sa.generarSAXML(9, ruta);
    /*238*/ }
    
            public void Alerta(String mensaje)
            {
                vista.alerta(mensaje);
            }
             
            public boolean verificarNulos()
            {
               if (vista.nulos() == 1) return true;
               else return false;
            }
            
            public void validador()
            {
                vista.validandoTabla();

            }
    
    
/*239*/ }
