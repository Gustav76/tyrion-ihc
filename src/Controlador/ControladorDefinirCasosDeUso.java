/*1*/ package Controlador;
/*2*/ 
/*3*/ import Modelo.ModeloCasoDeUso;
/*4*/ import Modelo.ModeloMapaConversacional;
/*5*/ import Modelo.ModeloObjetivosDelNegocio;
/*6*/ import Modelo.ModeloSesion;
import Vista.*;
import java.awt.CardLayout;
/*9*/ import java.util.Vector;
/*10*/ 
/*11*/ /** 
        * Controlador encargado de la etapa de definir los casos de uso, 
 *      * Opera con los modelos ModeloMapaConversacional, ModeloObjetivosDelNegocio y ModeloCasoDeUso.
 *      * Despliega las vistas VistaDefinirCasosDeUso, VistaAyudaDefinirCasosDeUso y llama al controlador principal
        * @author DavidyAly
        */
/*15*/ public class ControladorDefinirCasosDeUso {
/*16*/ 
/*17*/     JPDefinirCasosDeUso vista;
/*19*/     ControladorDefinirCasosDeUso control;
/*20*/     ControladorPrincipal controlMain;
/*21*/     ModeloMapaConversacional modeloMC;
/*22*/     ModeloObjetivosDelNegocio modeloON;
/*23*/     ModeloCasoDeUso modeloCU;
/*24*/ 
/*25*/     /**
            * Constructor de la clase ControladorDefinirCasosDeUso
            * @param controlMain: controlador principal al que se hace referencia
            * @param modeloMC: modelo de mapa conversacional a usar
            * @param modeloON: modelo de objetivos del negocio a usar
            * @param modeloCU: modelo de casos de uso a usar
            */
/*32*/     public ControladorDefinirCasosDeUso(ControladorPrincipal controlMain, ModeloMapaConversacional modeloMC, ModeloObjetivosDelNegocio modeloON, ModeloCasoDeUso modeloCU) {
/*33*/         this.controlMain = controlMain;
/*34*/         this.modeloMC = modeloMC;
/*35*/         this.modeloON = modeloON;
/*36*/         this.modeloCU = modeloCU;
/*37*/         vista = new JPDefinirCasosDeUso(this);
/*38*/         vista.setVisible(true);
/*39*/     }
/*40*/ 
/*41*/     /**
            * getCasosDeUso: entrega los casos de uso del modelo 
            * @return vector con los casos de uso de modeloCU
            */

           public void activarVista() {
                ((CardLayout)controlMain.getVista().getPanel().getLayout()).show(controlMain.getVista().getPanel(),"VDefinirCasosUso");
           }
           public JPDefinirCasosDeUso getVista() {
                return vista;
           }

/*45*/     public Vector getCasosDeUso() {
/*46*/         return this.modeloCU.getCasosDeUso();
/*47*/     }
/*48*/ 
/*49*/     /**
            * casoUsoMod: utiliza el método casosUsoMod de la clase ModeloCasosDeUso y retorna un vector con los Casos de uso de dicha clase
            * @return Vector con los casos de uso
            */
/*53*/     public Vector casoUsoMod() {
/*54*/         return this.modeloCU.casosUsoMod();
/*55*/     }
/*56*/ 
/*57*/     /**
            * Método que setea los casos de uso iniciales, mediante el método setCasosDeUsoInicial de la clase ModeloCasosDeUso
            */
/*60*/     public void setCasosDeUsoInicial() {
/*61*/         this.modeloCU.setCasosDeUsoInicial();
/*62*/     }
/*63*/ 
/*64*/     /**
            * Método que setea un caso de uso a partir de un vector de casos de uso y una posición dentro de él, mediante la clase ModeloCasosDeUso
            * @param cu: vector de casos de uso
            * @param pos: posición del vector de casos de uso
            */
/*69*/     public void setCasoDeUso(Vector cu, int pos) {
/*70*/         this.modeloCU.setCasoDeUso(cu, pos);
/*71*/     }
/*72*/ 
/*73*/     /**
            * Método que redirige a la vista de definir los casos de uso
            */
/*76*/     public void irVistaDefinirCasosDeUso() {
/*77*/         //this.vista.setCU();
/*78*/         this.vista.setVisible(true);
/*79*/         this.vista.setCU(this.vista.getPos());
/*80*/     }
/*81*/ 
/*82*/     /**
            * Método que cierra la vista de definir los casos de uso
            */
/*85*/     public void cerrarVistaDefinirCasosDeUso() {
/*86*/         this.vista.setVisible(true);
/*88*/     }
/*89*/ 
/*90*/     /**
            * Método que redirige al controlador de excepciones de los casos de uso
            */
/*93*/     //public void irControladorExcepciones1() {
/*94*/     //    this.controlMain.irControladorExcepciones1(modeloMC, modeloON, modeloCU);
/*95*/     //    this.vista.setVisible(false);
/*96*/    // }
/*97*/
           public void irControladorExcepciones() {
               this.controlMain.irControladorExcepciones(modeloMC, modeloON, modeloCU);
               this.vista.setVisible(false);
           }
/*98*/     /**
            * Método que redirige a la vista de ayuda del menú de definición de casos de uso
            */
/*111*/ 
/*112*/     /**
             * Método que genera el archivo XML con el modelo de casos de uso
             * @param entrada: ruta del archivo XML con el modelo de casos de uso a guardar
             */
/*116*/     public void generarXML(String entrada) {
/*117*/         this.modeloCU.generarXML(entrada);
/*118*/     }
/*119*/ 
/*120*/     /**
             * Método que carga un archivo de sesión previa
             * @param ruta: ruta del archivo a cargar
             */
/*124*/     public void archivoSesion(String ruta) {
/*125*/         ModeloSesion sa = new ModeloSesion(modeloMC, modeloON, modeloCU);
/*126*/         sa.generarSAXML(9, ruta);
/*127*/     }
/*128*/ }
