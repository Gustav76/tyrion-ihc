/*1*/ package Controlador;
/*2*/ 
/*3*/ import Modelo.ModeloCasoDeUso;
/*4*/ import Modelo.ModeloMapaConversacional;
/*5*/ import Modelo.ModeloObjetivosDelNegocio;
/*6*/ import Modelo.ModeloSesion;
import Vista.JPPostcondiciones;
import java.awt.CardLayout;
/*9*/ import java.util.Vector;
/*10*/ 
/*11*/ /**
        * Controlador que se encarga de gestionar las post condiciones de los casos de uso
        * @author DavidyAly
        */
/*15*/ public class ControladorPostCondiciones {
/*16*/     JPPostcondiciones vista;
/*18*/     ControladorPostCondiciones control;
/*19*/     ControladorPrincipal controlMain;
/*20*/     ModeloMapaConversacional modeloMC;
/*21*/     ModeloObjetivosDelNegocio modeloON;
/*22*/     ModeloCasoDeUso modeloCU;
/*23*/ 
/*24*/     /**
            * Controlador que llama a la vista de Post-condiciones
            * @param controlMain Controlador principal
            * @param modeloMC Modelo de mapa conversacional
            * @param modeloON Modelo de objetivos del negocio
            * @param modeloCU Modelo de casos de uso
            */
/*31*/     public ControladorPostCondiciones(ControladorPrincipal controlMain, ModeloMapaConversacional modeloMC, ModeloObjetivosDelNegocio modeloON, ModeloCasoDeUso modeloCU) {
/*32*/         this.controlMain = controlMain;
/*33*/         this.modeloMC = modeloMC;
/*34*/         this.modeloON = modeloON;
/*35*/         this.modeloCU = modeloCU;
/*36*/         vista=new JPPostcondiciones(this);
/*38*/     }
/*39*/ 
/*40*/ /**
        * Genera los nombres de casos de uso en la vista
        */
/*43*/     public void irVistaPostCondiciones(){
/*44*/         this.vista.setNomCU();
/*45*/         if(this.getPostCondicionesCU()==null){
/*46*/             this.vista.setPostCondiciones();
/*47*/         }
/*48*/         else{
/*49*/             this.vista.setPostCondiciones(this.getPostCondicionesCU());
/*50*/         }
/*51*/         this.vista.setVisible(true);
/*52*/     }
/*53*/ 
/*54*/     /**
            * Cierra la vista de ayuda de post-condiciones
           */
/*57*/     public void cerrarVistaAyudaPostCondiciones(){
/*58*/         this.vista.setVisible(true);
/*60*/     }
/*61*/ 


           public void activarVista() {
                ((CardLayout)controlMain.getVista().getPanel().getLayout()).show(controlMain.getVista().getPanel(),"VPostCondiciones");
           }
           public JPPostcondiciones getVista() {
                return vista;
           }

/*62*/     /**
            * Obtiene los casos de uso
            * @return Nombres de los casos de uso
            */
/*66*/     public Vector getNombreCasoUso(){
/*67*/         return this.modeloCU.getNombreCasoUso();
/*68*/     }
/*69*/ 
/*70*/     /**
            * Obtiene las post-condicones de los objetivos del negocio
            * @return Post-condiciones de los objetivos del negocio
            */
/*74*/     public Vector getPostCondiciones(){
/*75*/         return this.modeloON.getPostCondiciones();
/*76*/     }
/*77*/ 
/*78*/     /**
            * Obtiene las post-condiciones de los casos de uso
            * @return Post-condiciones de los casos de uso
            */
/*82*/     public Vector getPostCondicionesCU(){
/*83*/         return this.modeloCU.getPostCondicionesCasoUso();
/*84*/     }
/*85*/ 
/*86*/     /**
            * Genera post-condiciones de los casos de uso en la tabla
            * @param postCondicionesCU post-condiciones de los casos de uso a 
 * agregar
            */
/*90*/     public void setPostCondicionesCU(Vector postCondicionesCU){
/*91*/         this.modeloCU.setPostCondicionesCasoUso(postCondicionesCU);
/*92*/     }
/*93*/ 

/*90*/     public void setPostCondicionesCU(){
/*91*/         this.modeloCU.setPostCondicionesCasoUso(vista.getPostCondiciones());
/*92*/     }

/*93*/ 

/*94*/     /**
            * Llama al controlador de descripción
            */
/*97*/     public void irControladorDescripcion1(){
/*98*/         this.controlMain.irControladorDescripcion1(modeloMC, modeloON, modeloCU);
/*99*/         this.vista.setVisible(false);
/*100*/     }
/*101*/ 
/*102*/     /**
             * Llama al controlador de resumen
             */
/*105*/     public void irControladorResumen(){
/*106*/         this.controlMain.irControladorResumen(modeloMC, modeloON, modeloCU);
/*107*/         this.vista.setVisible(false);
/*108*/     }
/*109*/ 
/*110*/     /**
              * Llama a la vista de ayuda de post-condiciones
             */
/*124*/ 
/*125*/     /**
             * Llama al método que genera los archivos XML con los modelos 
 * conversacionales, objetivos del negocio y casos de uso existentes
             * @param ruta Ruta donde se guardará el archivo XML
             */
/*129*/     public void archivoSesion(String ruta){
                control = new ControladorPostCondiciones(controlMain, modeloMC, modeloON, modeloCU);
                control.setPostCondicionesCU();
/*130*/         ModeloSesion sa=new ModeloSesion(modeloMC,modeloON,modeloCU);
/*131*/         sa.generarSAXML(8,ruta);
/*132*/     }
public void Alerta(String mensaje) {
            this.vista.alerta(mensaje);
        }
/*133*/ 
public boolean validarPC(){
            if(this.vista.nulos())
            {
                return true;
            }
            
            return false;
        }
/*134*/ }
