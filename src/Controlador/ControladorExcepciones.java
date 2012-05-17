/*1*/ package Controlador;
/*2*/ 
/*3*/ import Modelo.ModeloCasoDeUso;
/*4*/ import Modelo.ModeloMapaConversacional;
/*5*/ import Modelo.ModeloObjetivosDelNegocio;
/*6*/ import Modelo.ModeloSesion;
import Vista.JPIdentificarCU1;
import java.awt.CardLayout;
/*9*/ import java.util.Vector;
import Vista.*;

/*10*/ 
/*11*/ /**
        * Controlador que gestiona las operaciones con las excepciones de los casos de uso
        * @author DavidyAly
        */
/*15*/ public class ControladorExcepciones {
/*16*/ 
/*17*/     JPExcepciones vista;
/*19*/     ControladorExcepciones control;
/*20*/     ControladorPrincipal controlMain;
/*21*/     ModeloMapaConversacional modeloMC;
/*22*/     ModeloObjetivosDelNegocio modeloON;
/*23*/     ModeloCasoDeUso modeloCU;
/*24*/ 
/*25*/     /**
            * Constructor de la clase ControlExcepciones. Recibe parámetros necesarios de las etapas anteriores y los almacena localmente. Además, crea la vista de esta etapa ("Obtener excepciones").
            * @param controlMain    Controlador principal creador de este controlador.
            * @param modeloMC   Modelo de mapa conversacional recopilado anteriormente.
            * @param modeloON   Modelo de objetivos de negocio recopilado anteriormente.
            * @param modeloCU   Modelo de casos de uso recopilado anteriormente.
            */
/*32*/     public ControladorExcepciones(ControladorPrincipal controlMain, ModeloMapaConversacional modeloMC, ModeloObjetivosDelNegocio modeloON, ModeloCasoDeUso modeloCU) {
/*33*/         this.controlMain = controlMain;
/*34*/         this.modeloMC = modeloMC;
/*35*/         this.modeloON = modeloON;
/*36*/         this.modeloCU = modeloCU;
/*37*/         vista = new JPExcepciones(this);
/*39*/     }
/*40*/ 
/*41*/     

           public void activarVista() {
                ((CardLayout)controlMain.getVista().getPanel().getLayout()).show(controlMain.getVista().getPanel(),"VExcepciones");
           }
           public JPExcepciones getVista() {
                return vista;
           }

/**
            * Método que redirige a la vista correspondiente a ("Obtener excepciones")
            */
/*44*/     public void irVistaExcepciones() {
/*45*/         //tabla datos workflow
/*46*/         this.vista.setNomCUW();
/*47*/         this.vista.setDatosW();
/*48*/         //tabla datos ON
/*49*/         this.vista.setNomCUON();
/*50*/         this.vista.setObstaculos();
/*51*/         this.vista.setPrecondiciones();
/*52*/         //tabla excepciones
/*53*/         this.vista.setNomCUE();
/*54*/         if (this.getExcepciones() != null) {
/*55*/             this.vista.setExcepciones(this.getExcepciones());
/*56*/         }
/*57*/         this.vista.setVisible(true);
/*58*/     }
/*59*/ 
/*60*/     /**
            * Método que oculta la ayuda y regresa a la vista de esta etapa ("Obtener excepciones").
            */
/*63*/     public void cerrarVistaAyudaExcepciones() {
/*64*/         this.vista.setVisible(true);
/*66*/     }
/*67*/ 
/*68*/     /**
            * Método que permite obtener los nombres de los casos de uso ya identificados, mediante la llamada al método correspondiente.
            * @return Vector de nombres de los casos de uso.
            */
/*72*/     public Vector getNombreCasoUso() {
/*73*/         return this.modeloCU.getNombreCasoUso();
/*74*/     }
/*75*/ 
/*76*/     /**
            * Método que permite obtener los obstáculos, mediante la llamada al método del modelo de objetivos del negocio.
            * @return Vector de obstáculos
            */
/*80*/     public Vector getObstaculos() {
/*81*/         return this.modeloON.getObstaculos();
/*82*/     }
/*83*/ 
/*84*/     /**
            * Método que permite obtener las precondiciones de los casos de uso, mediante la llamada al método del modelo de casos de uso.
            * @return Vector de precondiciones de los casos de uso
            */
/*88*/     public Vector getPrecondiciones() {
/*89*/         return this.modeloCU.getPreCondiciones();
/*90*/     }
/*91*/ 
/*92*/     /**
            * Método que permite setear las excepciones de los casos de uso, mediante la llamada al método del modelo de casos de uso
            * @param excepciones    Vector que contiene las excepciones de los casos de uso.
            */
/*96*/     public void setExcepciones(Vector excepciones) {
/*97*/         this.modeloCU.setExcepciones(excepciones);
/*98*/     }

/*96*/     public void setExcepciones() {
/*97*/         this.modeloCU.setExcepciones(vista.getExcepciones());
/*98*/     }

/*99*/ 
/*100*/     /**
             * Método que permite obtener las excepciones de los casos de uso, mediante la llamada al método correspondiente
             * @return Vector que contiene las excepciones de los casos de uso.
             */
/*104*/     public Vector getExcepciones() {
/*105*/         return this.modeloCU.getExcepciones();
/*106*/     }
/*107*/ 
/*108*/     /**
             * Método que permite setear los casos de uso iniciales, mediante la llamada al método correspondiente.
             */
/*111*/     public void setCU() {
/*112*/         this.modeloCU.setCasosDeUsoInicial();
/*113*/     }
/*114*/ 
/*115*/     /**
             * Método que redirige al proximo paso ("Definir caso de uso"), ocultando la vista gestionada por este controlador ("Obtener excepciones")
             */
/*118*/     public void irControladorDefinirCasoDeUso() {
/*119*/         this.controlMain.irControladorDefinirCasosDeUso(modeloMC, modeloON, modeloCU);
/*120*/         this.vista.setVisible(false);
/*121*/     }
/*122*/ 
/*123*/     /**
             * Método que redirige al paso anterior ("Obtener descripción 2do paso"), ocultando la vista gestionada por este controlador ("Obtener excepciones")
             */
/*126*/     public void irControladorDescripcion2() {
/*127*/         this.controlMain.irControladorDescripcion2(modeloMC, modeloON, modeloCU);
/*128*/         this.vista.setVisible(false);
/*129*/     }
/*130*/ 
/*131*/     /**
             * Método que muestra la ayuda y oculta la vista actual ("Obtener excepciones")
             */
/*144*/ 
/*145*/     /**
             * Método que retorna las asociaciones entre las excepciones y las alternativas asociadas del mapa conversacional, mediante la llamada al método correspondiente.
             * @return Vector que contiene las asociaciones entre las excepciones y las alternativas asociadas.
             */
/*149*/     public Vector datosWorkflow() {
/*150*/         return this.modeloMC.workflowExcepcionAlternativa();
/*151*/     }
/*152*/ 
/*153*/     /**
             * Método que genera el archivo XML conteniendo la sesión actual, en la ruta previamente especificada
             * @param ruta Ruta donde se guardará el archivo generado
             */
/*157*/     public void archivoSesion(String ruta) {
/*158*/         ModeloSesion sa = new ModeloSesion(modeloMC, modeloON, modeloCU);
/*159*/         sa.generarSAXML(11, ruta);
/*160*/     }
/*161*/ }
