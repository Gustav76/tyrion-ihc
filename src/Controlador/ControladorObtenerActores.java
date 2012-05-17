/*1*/ package Controlador;
/*2*/ 
/*3*/ import Modelo.ModeloCasoDeUso;
/*4*/ import Modelo.ModeloMapaConversacional;
/*5*/ import Modelo.ModeloObjetivosDelNegocio;
/*6*/ import Modelo.ModeloSesion;
import Vista.JPObtenerActores;
import java.awt.CardLayout;
/*9*/ import java.util.Vector;
/*10*/ 
/*11*/ /**
        * Controlador que se encarga de gestionar los actores
        * @author DavidyAly
        */
/*15*/ public class ControladorObtenerActores {
/*16*/ 
/*19*/     ControladorObtenerActores control;
/*20*/     ControladorPrincipal controlMain;
/*21*/     ModeloObjetivosDelNegocio modeloON;
/*22*/     ModeloMapaConversacional modeloMC;
/*23*/     ModeloCasoDeUso modeloCU;
           private JPObtenerActores vista;
           
/*24*/ 
/*25*/     /**
            *
            * Controlador de esta clase. Recibe parámetros necesarios de las etapas anteriores y los almacena localmente. Además, crea la vista de esta etapa ("Identificar caso de uso primer paso").
            * @param controMain   Controlador principal creador de este controlador.
            * @param modeloMC   Modelo de mapa conversacional recopilado anteriormente.
            * @param modeloON   Modelo de objetivos de negocio recopilado anteriormente.
            * @param modeloCU   Modelo de casos de uso recopilado anteriormente.
            */
/*32*/     public ControladorObtenerActores(ControladorPrincipal controlMain, ModeloMapaConversacional modeloMC, ModeloObjetivosDelNegocio modeloON, ModeloCasoDeUso modeloCU) {
/*33*/         this.controlMain = controlMain;
/*34*/         this.modeloMC = modeloMC;
/*35*/         this.modeloON = modeloON;
/*36*/         this.modeloCU = modeloCU;
/*38*/         vista = new JPObtenerActores(this);
/*39*/     }
/*40*/ 
/*41*/     /**
            * Método que redirige a la vista ("Obtener Actores")
            */
/*44*/     public void irVistaObtenerACtores() {
/*45*/         this.vista.setNomCU();
/*46*/         this.vista.setClientes();
/*47*/         this.vista.setRealizadores();
/*48*/         this.vista.setVisible(true);
/*49*/     }
/*50*/ 
/*51*/     /**
            * Método que oculta la ayuda de esta etapa ("Obtener actores")
            */
/*54*/     public void cerrarVistaAyudaObtenerActores() {
/*55*/         this.vista.setVisible(true);
/*57*/     }
/*58*/ 
/*59*/     /**
            * Método que obtiene el nombre de los casos de uso, mediante la llamada al método correspondiente.
            * @return Vector con los nombres de los casos de uso.
            */
/*63*/     public Vector getNombreCasoUso() {
/*64*/         return this.modeloCU.getNombreCasoUso();
/*65*/     }
/*66*/ 
/*67*/     /**
            * Método que obtiene los clientes, mediante la llamada al método correspondiente.
            * @returnn Vector con los clientes.
            */
/*71*/     public Vector getClientes() {
/*72*/         Vector c = new Vector();
/*73*/         //c=this.modeloMC.getClientes();
/*74*/         c = this.modeloMC.getClientes2();
/*75*/         return c;
/*76*/     }
/*77*/ 
/*78*/     /**
            * Método que obtiene los realizadores, mediante la llamada al método correspondiente.
            * @return Vector con los realizadores
            */
/*82*/     public Vector getRealizadores() {
/*83*/         Vector r = new Vector();
/*84*/         r = this.modeloMC.getRealizadores2();
/*85*/         return r;
/*86*/     }
/*87*/ 
/*88*/     /**
            * Método que revisa si se encuentra un agente, llamando al método correspondiente.
            * @return Int, 1 si se encuentra al agente o 0 si no está
            */
/*92*/     public int revisionAgentes() {
/*93*/         Vector agentes = new Vector();
/*94*/         int esta = 0;
/*95*/         agentes = (Vector) this.modeloON.getAgentes();
/*96*/         for (int i = 0; i < agentes.size(); i++) {
/*97*/             Vector v = (Vector) agentes.get(i);
/*98*/             for (int j = 0; j < v.size(); j++) {
/*99*/                 String ag = v.get(j).toString();
/*100*/                 if (this.revisarActores(ag, i) == 0) {
/*101*/                     esta = 1;
/*102*/                 }
/*103*/             }
/*104*/         }
/*105*/         return esta;
/*106*/     }
/*107*/ 
/*108*/     /**
             *
             * @param ag
             * @param pos
             * @return
             */
/*114*/     public int revisarActores(String ag, int pos) {
/*115*/         int esta = 0;
/*116*/         //System.out.println("agente: "+ag);
/*117*/         //Vector clientes=this.modeloMC.getClientes();
/*118*/         Vector clientes = this.modeloMC.getClientes2();
/*119*/         Vector realizadores = this.modeloMC.getRealizadores2();
/*120*/         Vector v = (Vector) clientes.get(pos);
/*121*/         for (int k = 0; k < v.size(); k++) {
/*122*/             String cl = v.get(k).toString();
/*123*/             //System.out.println("clientes: "+cl);
/*124*/             if (ag.equals(cl)) {
/*125*/                 //System.out.println(cl+" y "+ag+" "+esta);
/*126*/                 esta = 1;
/*127*/             }
/*128*/         }
/*129*/         Vector t = (Vector) realizadores.get(pos);
/*130*/         for (int s = 0; s < t.size(); s++) {
/*131*/             String rl = t.get(s).toString();
/*132*/             //System.out.println("realizador: "+rl);
/*133*/             if (ag.equals(rl)) {
/*134*/                 //System.out.println(rl+" y "+ag+" "+esta);
/*135*/                 esta = 1;
/*136*/             }
/*137*/         }
/*138*/         return esta;
/*139*/     }
/*140*/ 
/*141*/     /**
             * Método que redirige a la vista ("Controlador precondiciones")
             */
/*144*/     public void irControladorPrecondiciones() {
/*145*/         this.controlMain.irControladorPrecondiciones(modeloMC, modeloON, modeloCU);
/*146*/         this.vista.setVisible(false);
/*147*/     }
/*148*/ 
/*149*/     /**
             * Método que redirige a la vista ("Identificar casos de uso segundo paso paso") y oculta la vista actual ("Identificar casos de uso segundo paso")
             */
/*152*/     public void irControladorIdentificarCU2() {
/*153*/     //    this.controlMain.irControladorIdentificarCU2(modeloMC, modeloON, modeloCU);
/*154*/       //  this.vista.setVisible(false);
/*155*/     }
/*156*/ 
/*157*/     /**
             * Método que muestra la ayuda y oculta la vista actual ("Obtener actores")
             */
/*170*/ 
/*171*/     /**
             *
             * @param ruta
             */
/*175*/     public void archivoSesion(String ruta) {
/*176*/         ModeloSesion sa = new ModeloSesion(modeloMC, modeloON, modeloCU);
/*177*/         sa.generarSAXML(5, ruta);
/*178*/     }

           public  JPObtenerActores getVista() {
                return vista;
           }
           
                      public void activarVista() {
                ((CardLayout)controlMain.getVista().getPanel().getLayout()).show(controlMain.getVista().getPanel(),"VObtenerActores");
           }

/*179*/ }
