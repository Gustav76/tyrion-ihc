/*1*/ package Controlador;
/*2*/ 
/*3*/ import DTO.WorkflowDTO;
/*4*/ import Modelo.ModeloCasoDeUso;
/*5*/ import Modelo.ModeloMapaConversacional;
/*6*/ import Modelo.ModeloObjetivosDelNegocio;
/*7*/ import Modelo.ModeloSesion;
import Vista.JPPrecondiciones;
import java.awt.CardLayout;
/*10*/ import java.util.Vector;
/*11*/ 
/*12*/ /**
        * Controlador que gestiona las precondiciones de los casos de uso
        * @author DavidyAly
        */
/*16*/ public class ControladorPrecondiciones {
/*17*/ 
/*18*/     private JPPrecondiciones vista;
/*20*/     ControladorPrecondiciones control;
/*21*/     ControladorPrincipal controlMain;
/*22*/     ModeloMapaConversacional modeloMC;
/*23*/     ModeloObjetivosDelNegocio modeloON;
/*24*/     ModeloCasoDeUso modeloCU;
/*25*/     Vector actores;
/*26*/     Vector filas;
/*27*/     Vector columnas;
/*28*/     Vector datos;
           public boolean valido = false;
/*29*/ 
/*30*/     /**
            * Controlador que llama a la vista de pre-condiciones
            * @param controlMain Controlador principal
            * @param modeloMC Modelo del mapa conversacional
            * @param modeloON Modelo de objetivos del negocio
            * @param modeloCU Modelo de casos de uso
            */
/*37*/     public ControladorPrecondiciones(ControladorPrincipal controlMain, ModeloMapaConversacional modeloMC, ModeloObjetivosDelNegocio modeloON, ModeloCasoDeUso modeloCU) {
/*38*/         this.controlMain = controlMain;
/*39*/         this.modeloMC = modeloMC;
/*40*/         this.modeloON = modeloON;
/*41*/         this.modeloCU = modeloCU;
/*42*/         vista = new JPPrecondiciones(this);
/*44*/     }
/*45*/ 
/*46*/

           public void activarVista() {
                ((CardLayout)controlMain.getVista().getPanel().getLayout()).show(controlMain.getVista().getPanel(),"VPrecondiciones");
           }
           public JPPrecondiciones getVista() {
                return vista;
           }

/**
            * Controlador que llama a la vista de pre-condiciones
            */
/*49*/     public void irVistaPrecondiciones() {
/*50*/         this.vista.setCU();
/*51*/         this.vista.setWorkflowAnterior();
/*52*/         this.vista.setCaseOutWorkflow();
/*53*/         //setar datos para la tabla de precondiciones
/*54*/         this.vista.setNomCU();
/*55*/         if (this.getPrecondicionesCU() != null) {
/*56*/             this.vista.setPrecondiciones(this.getPrecondicionesCU());
/*57*/         } else {
/*58*/             this.vista.setPreObjRestObj();
/*59*/         }
/*60*/         this.vista.setVisible(true);
/*61*/     }
/*62*/ 
/*63*/     /**
            * Controlador que cierra la vista del menú de ayuda de 
 * pre-condiciones
            */
/*66*/     public void cerrarVistaAyudaPrecondiciones() {
/*67*/         this.vista.setVisible(true);
/*69*/     }
/*70*/ 
/*71*/     /**
            * Obtiene las filas de la vista de pre-condiciones
            * @return Datos de las filas obtenidas 
            */
/*75*/     public Vector getFilas() {
/*76*/         return filas;
/*77*/     }
/*78*/ 
/*79*/     /**
            * Obtiene las columnas de la vista de pre-condiciones
            * @return Datos de las columnas obtenidas
            */
/*83*/     public Vector getColumnas() {
/*84*/         return columnas;
/*85*/     }
/*86*/ 
/*87*/     /**
            * Obtiene los datos
            * @return datos Datos obtenidos
            */
/*91*/     public Vector getDatos() {
/*92*/         return datos;
/*93*/     }
/*94*/ 
/*95*/     /**
            * Obtiene las precondicones de los casos de uso
            * @return Datos de las precondiciones existentes de cada caso de uso
            */
/*99*/     public Vector getPrecondicionesCU() {
/*100*/         return this.modeloCU.getPreCondiciones();
/*101*/     }
/*102*/ 
/*103*/     /**
             * Obtiene el nombre de cada caso de uso
             * @return Nombres de cada uno de los casos de uso existentes
             */
/*107*/     public Vector getNombreCasoUso() {
/*108*/         return this.modeloCU.getNombreCasoUso();
/*109*/     }
/*110*/ 
/*111*/     /**
             * Arma un workflow a partir de las precodiciones del modelo 
 * conversacional
             * @return Vector con los datos de precondiciones
             */
/*115*/     public Vector getPrecondiciones() {
/*116*/         Vector precondiciones = new Vector();
/*117*/         Vector precondicionesON = this.modeloON.getPrecondiciones();
/*118*/         Vector precondicionesMC = this.modeloMC.getPreCondiciones();
/*119*/         for (int i = 0; i < precondicionesMC.size(); i++) {
/*120*/             Vector v = (Vector) precondicionesMC.get(i);
/*121*/             for (int j = 0; j < v.size(); j++) {
/*122*/                 WorkflowDTO wf = (WorkflowDTO) v.get(j);
/*123*/ 
/*124*/             }
/*125*/         }
/*126*/ 
/*127*/         return precondiciones;
/*128*/     }
/*129*/ 
/*130*/     /**
             * Obtiene las precondiciones del objetivo del negocio
             * @return Precondiciones del objetivo del negocio pre-existentes
             */
/*134*/     public Vector getPrecondicionesON() {
/*135*/         Vector precondicionesON = this.modeloON.getPrecondiciones();
/*136*/         return precondicionesON;
/*137*/     }
/*138*/ 
/*139*/     /**
             * Obtiene las restricciones del objetivo del negocio
             * @return Restricciones del objetivo del negocio pre-existentes
             */
/*143*/     public Vector getRestriccionesON() {
/*144*/         Vector restriccionesON = this.modeloON.getRestricciones();
/*145*/         return restriccionesON;
/*146*/     }
/*147*/ 
/*148*/     /**
             *
             * @return
             */
/*152*/     public Vector getCaseOutMC() {
/*153*/         Vector caseOutMC = new Vector();
/*154*/         Vector ciclos = new Vector();
/*155*/         Vector v = this.modeloMC.getPreCondiciones();
/*156*/         for (int i = 0; i < v.size(); i++) {
/*157*/             Vector c = (Vector) v.get(i);
/*158*/             ciclos = new Vector();
/*159*/             for (int j = 0; j < c.size(); j++) {
/*160*/                 WorkflowDTO wf = (WorkflowDTO) c.get(j);
/*161*/                 //System.out.println(wf.getEtiqueta());
/*162*/                 ciclos.add(wf.getEtiqueta());
/*163*/             }
/*164*/             //System.out.println(ciclos);
/*165*/             if (ciclos.isEmpty()) {
/*166*/                 caseOutMC.add("--");
/*167*/             } else {
/*168*/                 caseOutMC.add(ciclos);
/*169*/             }
/*170*/ 
/*171*/         }
/*172*/         return caseOutMC;
/*173*/     }
/*174*/ 
/*175*/     /**
             * Obtiene lo workflows anteriores del mapa conversacional
             * @return Workflow de los mapas conversacionales preexistentes
             */
/*179*/     public Vector getWorkflowAnteriores() {
/*180*/         Vector workflowAnterioresMC = new Vector();
/*181*/         Vector v = new Vector();
/*182*/         v = this.modeloMC.getListaCiclosW();
/*183*/         workflowAnterioresMC.add("--");
/*184*/         for (int i = 0; i < v.size() - 1; i++) {
/*185*/             workflowAnterioresMC.add(v.get(i));
/*186*/         }
/*187*/         return workflowAnterioresMC;
/*188*/     }
/*189*/ 
/*190*/     /**
             * Determina las precondicione de lo casos de uso
             * @param precondiciones
             */
/*194*/     public void setPrecondicionesCU(Vector precondiciones) {
/*195*/         this.modeloCU.setPreCondiciones(precondiciones);
/*196*/     }

/*194*/     public void setPrecondicionesCU() {
/*195*/         this.modeloCU.setPreCondiciones(vista.getPrecondiciones());
/*196*/     }


/*197*/ 
/*198*/     /**
             * Llama al controlador resumen
             */
/*201*/     public void irControladorResumen() {
/*202*/         this.controlMain.irControladorResumen(modeloMC, modeloON, modeloCU);
/*203*/         this.vista.setVisible(false);
/*204*/     }
/*205*/ 
/*206*/     /**
             * Llama al controlador de obtener actores
             */
/*209*/     public void irControladorObtenerActores() {
/*210*/         this.controlMain.irControladorObtenerActores(modeloMC, modeloON, modeloCU);
/*211*/         this.vista.setVisible(false);
/*212*/     }
/*213*/ 
/*214*/     /**
             * Llama a la vista de ayuda de pre-condiciones
             */
/*227*/ 
/*228*/     /**
             * Llama al método para cargar lo archivos XML de una sesión 
 * anterior
             * @param ruta Ruta donde se encuentran los archivos XML
             */
/*232*/     public void archivoSesion(String ruta) {
                control=new ControladorPrecondiciones(controlMain, modeloMC, modeloON, modeloCU);
                control.setPrecondicionesCU();
/*233*/         ModeloSesion sa = new ModeloSesion(modeloMC, modeloON, modeloCU);
/*234*/         sa.generarSAXML(6, ruta);
/*235*/     }
            public void Alerta(String mensaje)
            {
                vista.alerta(mensaje);
            }
            
            
/*236*/

    public void checkValido() {
        valido=vista.checkPcompletos();
        return;      
    }
 }


//sospecha