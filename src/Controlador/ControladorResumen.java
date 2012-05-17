/*1*/ package Controlador;
/*2*/ import Controlador.*;
/*3*/ import Modelo.ModeloCasoDeUso;
/*4*/ import Modelo.ModeloMapaConversacional;
/*5*/ import Modelo.ModeloObjetivosDelNegocio;
/*6*/ import Modelo.ModeloSesion;
import Vista.JPResumen;
/*9*/ import java.util.Vector;
/*10*/import java.awt.CardLayout;
/*11*/ /**
        *Clase del controlador de la vista referente al resumen de los casos de uso
        * @author DavidyAly
        */
/*15*/ public class ControladorResumen {
/*16*/     private JPResumen vista;
/*18*/     ControladorResumen control;
/*19*/     ControladorPrincipal controlMain;
/*20*/     ModeloMapaConversacional modeloMC;
/*21*/     ModeloObjetivosDelNegocio modeloON;
/*22*/     ModeloCasoDeUso modeloCU;
/*23*/     Vector filas;
/*24*/     Vector columnas;
/*25*/     Vector datos;
            public boolean valido = false;
/*26*/ 
/*27*/     /**
            *Método del controlador respecto a la vista del resumen de los casos de uso
            * @param controlMain,
            * @param modeloMC, modelo conversacional instanciado en el resumen del caso de uso
            * @param modeloON, modelo de objetivo del negocio instanciado en el resumen del caso de uso
            * @param modeloCU, modelo de casos de uso instanciado en el resumen del caso de uso
            */
/*34*/     public ControladorResumen(ControladorPrincipal controlMain, ModeloMapaConversacional modeloMC, ModeloObjetivosDelNegocio modeloON, ModeloCasoDeUso modeloCU) {
/*35*/         this.controlMain = controlMain;
/*36*/         this.modeloMC = modeloMC;
/*37*/         this.modeloON = modeloON;
/*38*/         this.modeloCU = modeloCU;
/*39*/         vista=new JPResumen(this);
/*40*/         vista.setVisible(true);
/*41*/     }
/*42*/ 
/*43*/ /**
        *Método que hace visible la ventana asociada al resumen de los casos de uso
        */
/*46*/     public void irVistaResumen(){
/*47*/         this.vista.setNomCU();
/*48*/         if(this.getResumenCU()==null){
/*49*/             this.vista.setResumen();
/*50*/         }
/*51*/         else{
/*52*/             this.vista.setResumenCU(this.getResumenCU());
/*53*/         }
/*54*/         this.vista.setVisible(true);
/*55*/     }
/*56*/ 
/*57*/     /**
            *Método que permite cerrar/ocultar la vista correspondiente a la ayuda acerca del
            * resumen de los casos de uso
            */
/*60*/     public void cerrarVistaAyudaResumen(){
/*61*/         this.vista.setVisible(true);
/*63*/     }
/*64*/ 
/*65*/     /**
            *Método que entrega el nombre de un caso de uso,de acuerdo al modelo de casos de uso
            * @return el nombre de un caso de uso
            */
/*69*/     public Vector getNombreCasoUso(){
/*70*/         return this.modeloCU.getNombreCasoUso();
/*71*/     }
/*72*/ 
/*73*/     /**
            *Método que entrega un resumen de objetivos del negocio,de acuerdo al modelo de objetivos del negocio
            * @return el resumen de los objetivos del negocio
            */
/*77*/     public Vector getResumen(){
/*78*/         return this.modeloON.getResumen();
/*79*/     }
/*80*/ 
/*81*/     /**
            *Método que permite modificar el resuman de un caso de uso,
            * proveniente del modelo de casos de uso
            * @param resumenCU, es el vector a partir del cual se puede modificar la información del resumen
            */
/*85*/     public void setResumenCU(Vector resumenCU){
/*86*/          this.modeloCU.setResumenCasoUso(resumenCU);
/*87*/     }

/*85*/     public void setResumenCU(){
/*86*/          this.modeloCU.setResumenCasoUso(vista.resumenCU());
/*87*/     }

/*88*/ 
/*89*/     /**
            * Método que entrega un resumen del caso de uso,de acuerdo al modelo de casos de uso
            * @return el resumen de un caso de uso
            */
/*93*/     public Vector getResumenCU(){
/*94*/         return this.modeloCU.getResumenCasoUso();
/*95*/     }
/*96*/ 
/*97*/     /**
            *Método que invoca el controlador de las postcondiciones de un caso de uso.
            *Oculta la vista correspondiente a las postcondiciones de un caso de uso
            */
/*100*/     public void irControladorPostCondiciones(){
/*101*/         this.controlMain.irControladorPostCondiciones(modeloMC, modeloON, modeloCU);
/*102*/         this.vista.setVisible(false);
/*103*/     }
/*104*/ 
/*105*/     /**
             *Método que invoca el controlador de las precondiciones de un caso de uso.
             *Oculta la vista correspondiente a las precondiciones de un caso de uso
             */
/*108*/     public void irControladorPrecondiciones(){
/*109*/         this.controlMain.irControladorPrecondiciones(modeloMC, modeloON, modeloCU);
/*110*/         this.vista.setVisible(false);
/*111*/     }
/*112*/ 
/*113*/     /**
             * Método que invoca el controlador de ayuda del resumen de un casos de uso.
             * Puede poner a vista del usuario la ventana de ayuda u ocultarla, segun sea el caso.
            */
/*127*/ 
/*128*/     /**
             *Método que instacia los modelos (conversacional, de obj. de negocio y de casos de uso)
             * para generar un archivo XML de una sesion anterior
             * @param ruta, direccion en la cual los mapas abiertos o modificados durante una sesión, serán guardados
             */
/*132*/     public void archivoSesion(String ruta){
                control = new ControladorResumen(controlMain, modeloMC, modeloON, modeloCU);
                control.setResumenCU();
/*133*/         ModeloSesion sa=new ModeloSesion(modeloMC,modeloON,modeloCU);
/*134*/         sa.generarSAXML(7,ruta);
/*135*/     }


           public void activarVista() {
                ((CardLayout)controlMain.getVista().getPanel().getLayout()).show(controlMain.getVista().getPanel(),"VResumen");
           }
           public JPResumen getVista() {
                return vista;
           }
           /**
            * Realiza una la validación de la columna "Resumen" llamando a la funcion checjRcompletos 
            */
               public void checkValido() {
                valido=vista.checkRcompletos();

                return;

            }
            /**
            * LLama a la funcion alerta de la vista JPResumen
            * @param mensaje 
            */   
            public void Alerta(String mensaje){
                vista.alerta(mensaje);
            }
 

/*136*/ 
/*137*/ }
