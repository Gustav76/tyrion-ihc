/*1*/ package Controlador;
/*2*/ 
/*3*/ import Modelo.ModeloCasoDeUso;
/*4*/ import Modelo.ModeloMapaConversacional;
/*5*/ import Modelo.ModeloObjetivosDelNegocio;
/*6*/ import Modelo.ModeloSesion;
      import Vista.JPIdentificarCU2;
/*8*/ import Vista.JPIdentificarCU2;
      import java.awt.CardLayout;
/*9*/ import java.util.Vector;
/*10*/ 
/*11*/ /**
        * Controlador que gestiona el segundo paso de la identificación de los casos de uso
        * @author DavidyAly
        */
/*15*/ public class ControladorIdentificarCU2 {
/*16*/ 
/*17*/     public JPIdentificarCU2 vista;
/*19*/     //private ControladorIdentificarCU2 control;
/*20*/     public ControladorPrincipal controlMain;
/*21*/     public ModeloObjetivosDelNegocio modeloON;
/*22*/     public ModeloMapaConversacional modeloMC;
/*23*/     public ModeloCasoDeUso modeloCU;
/*24*/     public Vector rTabla;
/*25*/     public Vector rLista;
/*26*/     public Vector rDato;
/*27*/     public Vector list;
           public boolean valido = true;
/*28*/ 
/*29*/     /**
            *
            * Controlador de esta clase. Recibe parámetros necesarios de las etapas anteriores y los almacena localmente. Además, crea la vista de esta etapa ("Identificar caso de uso primer paso").
            * @param controMain   Controlador principal creador de este controlador.
            * @param modeloMC   Modelo de mapa conversacional recopilado anteriormente.
            * @param modeloON   Modelo de objetivos de negocio recopilado anteriormente.
            * @param modeloCU   Modelo de casos de uso recopilado anteriormente.
            */

//            public ControladorIdentificarCU2(ControladorPrincipal ControlMain){
//                this.controlMain = controlMain;
//                vista = new JPIdentificarCU2(this);
//            }
           

/*36*/     public ControladorIdentificarCU2(ControladorPrincipal controlMain, ModeloMapaConversacional modeloMC, ModeloObjetivosDelNegocio modeloON, ModeloCasoDeUso modeloCU) {
/*37*/         
    
               this.controlMain = controlMain;
/*38*/         this.modeloMC = modeloMC;
/*39*/         this.modeloON = modeloON;
/*40*/         this.modeloCU = modeloCU;     
               vista = new JPIdentificarCU2(this);
                        
/*41*/         
               
/*42*/         
/*43*/     }
 
          public ControladorIdentificarCU2 (ControladorPrincipal controlMain){
              this.controlMain = controlMain;
              if(vista == null){
              vista = new JPIdentificarCU2(this);
              }
          }
          
          public ControladorIdentificarCU2 (){
              
              if(vista == null){
              vista = new JPIdentificarCU2(this);
              }
          }        

    public void setModeloCU(ModeloCasoDeUso modeloCU) {
        this.modeloCU = modeloCU;
    }

    public void setModeloMC(ModeloMapaConversacional modeloMC) {
        this.modeloMC = modeloMC;
    }

    public void setModeloON(ModeloObjetivosDelNegocio modeloON) {
        this.modeloON = modeloON;
    }

           

           public void activarVista() {
                ((CardLayout)controlMain.getVista().getPanel().getLayout()).show(controlMain.getVista().getPanel(),"VIdentificarCU2");
           }
           public JPIdentificarCU2 getVista() {
                return vista;
           }
/*44*/ 
/*45*/     /**
            *Redirige a la vista de esta etapa ("Identificar caso de uso segundo paso").
            */
/*48*/     public void irVistaIdentificarCU2() {
/*49*/         this.vista.setVisible(true);
/*50*/     }
/*51*/ 
/*52*/     /**
            * Método que oculta la ayuda de esta etapa ("Identificar caso de uso segundo paso").
            */
/*58*/ 
/*59*/     /**
            * Método que permite obtener los objetivos del negocio, mediante la llamada al método correspondiente.
            * @return Vector de los objetivos del negocio.
            */
/*63*/     public Vector getObjetivosNegocio() {
/*64*/         return this.modeloON.getObjetivos();
/*65*/     }
/*66*/ 
/*67*/     /**
            * Método que obtiene el nombre de los casos de uso, mediante la llamada al método correspondiente.
            * @return Vector con los nombres de los casos de uso.
            */
/*71*/     public Vector getNombreCasosUso() {
/*72*/         return this.modeloCU.getCasosDeUso();
/*73*/     }
/*74*/ 
/*75*/     /**
            * Metodo que guarda en el modelo de casos de uso los nombres de estos
            * @param Vector nombreCasosUso
            */
/*79*/     public void setNombreCasosUso(Vector nombreCasosUso) {
/*80*/         this.modeloCU.setNombreCasoUso(nombreCasosUso);
/*81*/     }

/*79*/     public void setNombreCasosUso() {
/*80*/         this.modeloCU.setNombreCasoUso(vista.nombreCasosUso());
/*81*/     }

/*82*/ 
/*83*/     /**
            * Método que permite avanzar a la siguiente etapa ("Obtener actores") ocultando la vista actual ("Identificar casos de uso segundo paso")
            */
/*86*/     public void irControladorObtenerActores() {
/*87*/         this.controlMain.irControladorObtenerActores(modeloMC, modeloON, modeloCU);
/*88*/         this.vista.setVisible(false);
/*89*/     }
/*90*/ 
/*91*/     /**
            * Metodo que redirige a la etapa ("Identificar casos de uso primer paso") y oculta la vista actual ("Identificar casos de uso segundo paso")
            */
/*94*/     public void irControladorIdentificarCU1() {
/*95*/         this.controlMain.irControladorIdentificarCU1(modeloMC, modeloON, modeloCU);
/*96*/         this.vista.setVisible(false);
/*97*/     }
/*98*/ 
/*99*/     /**
             * Método que muestra la ayuda y oculta la vista actual ("Identificar casos de uso segundo paso")
             */
/*112*/ 
/*113*/     /**
             *
             * @param ruta String para indicar la ruta donde se gaurdará el archivo.
             */
/*117*/     public void archivoSesion(String ruta) {
/*118*/         ModeloSesion sa = new ModeloSesion(modeloMC, modeloON, modeloCU);
/*119*/         sa.generarSAXML(4, ruta);
/*120*/     }
            public void Alerta(String mensaje)
            {
                vista.alerta(mensaje);
            }
            
           /* public void Validador()
            {
                vista.nulo();
            }
            */
            public void Validador(){
                vista.inNull();
            }

/*121*/ }


