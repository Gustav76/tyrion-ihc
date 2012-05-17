/*1*/ package Controlador;
/*2*/ 
/*3*/ import Modelo.ModeloCasoDeUso;
/*4*/ import Modelo.ModeloMapaConversacional;
/*5*/ import Modelo.ModeloObjetivosDelNegocio;
      import Modelo.ModeloSesion;
import Vista.JPIdentificarCU1;
import java.awt.CardLayout;
import java.util.LinkedList;
/*8*/ import java.util.Vector;
import javax.swing.ListModel;
/*9*/ 
/*10*/ /**
        * Controlador que gestiona el primer paso de la identificación de los casos de uso
        * @author DavidyAly
        */
/*14*/ public class ControladorIdentificarCU1 {
/*15*/ 
/*16*/     private JPIdentificarCU1 vista;
/*18*/     private ControladorIdentificarCU1 control;
/*19*/     private ControladorPrincipal controlMain;
/*20*/     public ModeloObjetivosDelNegocio modeloON;
/*21*/     public ModeloMapaConversacional modeloMC;
/*22*/     public ModeloCasoDeUso modeloCU;
           public boolean valido = false;
/*23*/ 
/*24*/     /**
            * Controlador de esta clase. Recibe parámetros necesarios de las etapas anteriores y los almacena localmente. Además, crea la vista de esta etapa ("Identificar caso de uso primer paso").
            * @param controlM   Controlador principal creador de este controlador.
            * @param modeloMC   Modelo de mapa conversacional recopilado anteriormente.
            * @param modeloON   Modelo de objetivos de negocio recopilado anteriormente.
            * @param modeloCU   Modelo de casos de uso recopilado anteriormente.
            */

           public ControladorIdentificarCU1(ControladorPrincipal cnt){
               this.controlMain = cnt;
              this.modeloON = new ModeloObjetivosDelNegocio();
              this.modeloMC = new ModeloMapaConversacional();
              this.modeloCU = new ModeloCasoDeUso();
               vista = new JPIdentificarCU1(this);

           }

/*31*/     public ControladorIdentificarCU1(ControladorPrincipal controlM, ModeloMapaConversacional modeloMC, ModeloObjetivosDelNegocio modeloON, ModeloCasoDeUso modeloCU) {
/*32*/         this.controlMain = controlM;
/*33*/         this.modeloMC = modeloMC;
/*34*/         this.modeloON = modeloON;
/*35*/         this.modeloCU = modeloCU;
/*36*/         vista = new JPIdentificarCU1(this);
/*37*/         
/*38*/     }
           public void activarVista() {
                ((CardLayout)controlMain.getVista().getPanel().getLayout()).show(controlMain.getVista().getPanel(),"VIdentificarCU1");
           }
           public JPIdentificarCU1 getVista() {
                return vista;
           }
/*39*/ 
/*40*/     /**
            * Redirige a la vista de esta etapa ("Identificar caso de uso primer paso").
            */
/*43*/     public void irVistaIdentificarCU1() {
/*44*/         this.vista.setVisible(true);
/*45*/     }
/*46*/ 
/*47*/     /**
            * Método que oculta la ayuda de esta etapa ("Identificar caso de uso primer paso").
            */
/*53*/ 
/*54*/     /**
            * Método que permite obtener el nombre de los objetivos del negocio, mediante la llamada al método correspondiente.
            * @return Vector de nombres de los objetivos del negocio.
            */
/*58*/     public Vector getNombreON() {
/*59*/         return this.modeloON.getObjetivos();
/*60*/     }
/*61*/ 
/*62*/     /**
            * Método que permite obtener los workflows del modelo de casos de uso, mediante la llamada al método correspondiente.
            * @return Vector de workflows del mapa conversacional
            */
/*66*/     public Vector getWorkflows() {
/*67*/         return this.modeloMC.getWorkflows();
/*68*/     }
/*69*/ 
/*70*/     /**
            * Método que permite obtener los workflows del modelo de casos de uso, mediante la llamada al método correspondiente.
            * @return Vector de workflows por ciclo del mapa conversacional, 
            */
/*74*/     public Vector getWorkflowsSeparados() {
/*75*/         return this.modeloMC.getWorkflowsSeparados();
/*76*/     }
/*77*/ 
/*78*/     /**
            * Método que permite avanzar a la siguiente etapa ("Identificar casos de uso segundo paso"), ocultando la vista de la actual ("Identificar casos de uso primer paso")
            */
/*81*/     public void irControladorIdentificarCU2() {
/*82*/         //System.out.println(list);
/*83*/         this.controlMain.irControladorIdentificarCU2(modeloMC, modeloON, modeloCU);
/*84*/         this.vista.setVisible(false);
/*85*/     }
/*86*/ 
/*87*/     /**
            * Método que guarda la historia al asociaciar entre objetivos y workflows en el modelo de mapa conversacional.
            * @param rTabla Vector histórico de objetivo de tabla
            * @param rLista Vector histórico de lista de workflows
            * @param rDato Vector histórico de worflows asociados a objetivo
            * @param nuevo Vector de workflows no asociados
            */
/*94*/     public void setRows(Vector rTabla, Vector rLista, Vector rDato, Vector nuevo) {
/*95*/         this.modeloMC.setRowTabla(rTabla);
/*96*/         this.modeloMC.setRowLista(rLista);
/*97*/         this.modeloMC.setRowDato(rDato);
/*98*/         this.modeloMC.setNuevo(nuevo);
/*99*/     }

            public void setRows() {
/*95*/         this.modeloMC.setRowTabla(vista.rowTabla);
/*96*/         this.modeloMC.setRowLista(vista.rowLista);
/*97*/         this.modeloMC.setRowDato(vista.rowDato);
/*98*/         this.modeloMC.setNuevo(vista.nuevo);
/*99*/     }

/*100*/ 
/*101*/     /**
             * Método que retorna los objetivos de tabla históricos, mediante el llamado al método correspondiente.
             * @return Vector histórico de objetivo de tabla
             */
/*105*/     public Vector rTabla() {
/*106*/         return this.modeloMC.getRowTabla();
/*107*/     }
/*108*/ 
/*109*/     /**
             * Método que retorna el historial de la lista de workflows, mediante el llamado al método correspondiente.
             * @return Vector histórico de lista de workflows
             */
/*113*/     public Vector rLista() {
/*114*/         return this.modeloMC.getRowLista();
/*115*/     }
/*116*/ 
/*117*/     /**
             * Método que retorna el historial de workflows asociados a objetivo, mediante el llamado al método correspondiente.
             * @return Vector histórico de lista de workflows asociados a objetivo
             */
/*121*/     public Vector rDato() {
/*122*/         return this.modeloMC.getRowDato();
/*123*/     }
/*124*/ 
/*125*/     /**
             * Método que retorna los workflows sin asociación, mediante el llamado al método correspondiente.
             * @return Vector de workflows sin asociación.
/*129*/     public Vector nuevo() {
/*130*/         return this.modeloMC.getNuevo();
/*131*/     }
/*132*/ 
/*133*/
/*134*/
/*135*/
/*136*/     /**
             * Método que guarda, en el modelo de mapa conversacional, la lista de ciclos del workflow obtenida en esta etapa.
             * @param lista Vector de lista de ciclos del workflow
             */
/*140*/     public void setListWO(Vector lista) {
/*141*/         this.modeloMC.setListaCiclosW(lista);
/*142*/     }

/*140*/     public void setListWO() {
/*141*/         this.modeloMC.setListaCiclosW(vista.setWorkXObj());
/*142*/     }
/*143*/ 
/*144*/     /**
             * Método que no es llamado, por lo que no hace nada.
             * @param lCC 
             */
/*148*/     public void setListaCiclosCompletos(Vector lCC) {
/*149*/         this.modeloMC.setListaCiclosWCompleto(lCC);
/*150*/     }
/*151*/ 
/*152*/     /**
             * Método que no es llamado, por lo que no hace nada.
             * @return
             */
/*156*/     public Vector getListaCiclosCompletos() {
/*157*/         return this.modeloMC.getListaCiclosWCompleto();
/*158*/     }
/*159*/ 
/*160*/     /**
             * Método que no es llamado, por lo que no hace nada.
             * @return
             */
/*164*/     public Vector getListaObjWork() {
/*165*/         return this.modeloMC.getListaCiclosW();
/*166*/     }
/*167*/ 
/*168*/     /**
             * Método que guarda la asociación entre objetivos y workflows en el modelo de mapa conversacional, mediante la llamada al método correspondiente.
             * @param listado Vector de asociación entre objetivos y workflows
             */
/*172*/     public void setListadoSA(Vector listado) {
/*173*/         this.modeloMC.setListadoSA(listado);
/*174*/     }
/*175*/ 

/*172*/     public void setListadoSA() {
/*173*/         this.modeloMC.setListadoSA(vista.getDatosTabla());
/*174*/     }

/*176*/     /**
             * Método que obtiene la asociación entre objetivos y workflows en el modelo de mapa conversacional.
             * @return Vector de asociación entre objetivos y workflows
             */
/*180*/     public Vector getListadoSA() {
/*181*/         return this.modeloMC.getListadoSA();
/*182*/     }

        public boolean validarCU1(){
            ListModel modelo = this.vista.getListaWorkflow().getModel();
            if (modelo.getSize()==0){
                System.out.println("Tamaño del modelo: "+modelo.getSize());
                return true;
            }
            else{
                System.out.println("Tamaño del modelo: "+modelo.getSize());
                return false;
            }
        }
        
        public void archivoSesion(String ruta) {
                //this = new ControladorIdentificarCU1(this, controladorCA.modeloMC, controladorCA.modeloON, controladorCA.modeloCU);
                ModeloSesion sa = new ModeloSesion(modeloMC, modeloON, modeloCU);
                sa.generarSAXML(3, ruta);
        }
        
        public void Alerta(String mensaje) {
            this.vista.alerta(mensaje);
        }
/*183*/ 
/*184*/     /**
             * Método que muestra la ayuda y oculta la vista actual ("Identificar casos de uso primer paso")
             */
/*197*/ }
