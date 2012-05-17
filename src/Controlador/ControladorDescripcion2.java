/*1*/ package Controlador;
/*2*/ 
/*3*/ import Modelo.ModeloCasoDeUso;
/*4*/ import Modelo.ModeloMapaConversacional;
/*5*/ import Modelo.ModeloObjetivosDelNegocio;
/*6*/ import Modelo.ModeloSesion;
import Vista.JPIdentificarCU2;
/*8*/ import Vista.JPDescripcion2;
import java.awt.CardLayout;
/*9*/ import java.util.Vector;
/*10*/ 
/*11*/ /**
        *Clase del controlador de la vista referente a la segunda descripcion de los casos de uso
        * @author DavidyAly
        */
/*15*/ public class ControladorDescripcion2 {
/*16*/ 
/*17*/     JPDescripcion2 vista;
/*19*/     ControladorDescripcion2 control;
/*20*/     ControladorPrincipal controlMain;
/*21*/     ModeloMapaConversacional modeloMC;
/*22*/     ModeloObjetivosDelNegocio modeloON;
/*23*/     ModeloCasoDeUso modeloCU;
/*24*/     Vector clientes;
/*25*/     Vector realizadores;
/*26*/     Vector tareas;
/*27*/     Vector nomCU;
/*28*/ 
/*29*/     /**
            *Método del controlador respecto a la vista de la segunda descripcion de los casos de uso
            * @param controlMain, controlador principal de la aplicacion
            * @param modeloMC, modelo conversacional instanciado en esta segunda descripcion del caso de uso
            * @param modeloON, modelo de objetivo del negocio instanciado en esta segunda descripcion del caso de uso
            * @param modeloCU, modelo de casos de uso instanciado en esta segunda descripcion del caso de uso
            */
/*36*/     public ControladorDescripcion2(ControladorPrincipal controlMain, ModeloMapaConversacional modeloMC, ModeloObjetivosDelNegocio modeloON, ModeloCasoDeUso modeloCU) {
/*37*/         this.controlMain = controlMain;
/*38*/         this.modeloMC = modeloMC;
/*39*/         this.modeloON = modeloON;
/*40*/         this.modeloCU = modeloCU;
/*41*/         this.clientes = this.modeloMC.getClientesD1();
/*42*/         this.realizadores = this.modeloMC.getRealizadoresD1();
/*43*/         this.tareas = this.modeloON.getTareasD1();
/*44*/         this.nomCU = this.modeloCU.getNombreCuD1();
/*45*/         vista = new JPDescripcion2(this);
/*47*/     }
/*48*/ 
/*49*/     /**
            *Método que hace visible la ventana asociada a la segunda descripcion de los casos de uso,
            * rescatando la informacion obtenida en la primera descripcion
            */
/*52*/     public void irVistaDescripcion2() {
/*53*/         this.clientes = this.modeloMC.getClientesD1();
/*54*/         this.realizadores = this.modeloMC.getRealizadoresD1();
/*55*/         this.tareas = this.modeloON.getTareasD1();
/*56*/         this.nomCU = this.modeloCU.getNombreCuD1();
/*57*/         this.vista.setNomCU();
/*58*/         vista.setAcccionesUsuario();
/*59*/         vista.setAccionesSistema();
/*60*/         //vista.setVisible(true);
/*61*/ 
/*62*/     }

           public void activarVista() {
                ((CardLayout)controlMain.getVista().getPanel().getLayout()).show(controlMain.getVista().getPanel(),"VDescripcion2");
           }
           public JPDescripcion2 getVista() {
                return vista;
           }

/*63*/ 
/*64*/     /**
            *Método que hace visible la ventana asociada a la segunda descripcion de los casos de uso
            */
/*67*/     public void irVistaDescripcion22() {
/*68*/         this.vista.setVisible(true);
/*69*/     }
/*70*/ 
/*71*/     /**
            *Método que permite cerrar/ocultar la vista correspondiente a la ayuda acerca de la
            * segunda descripción de los casos de uso
            */
/*77*/ 
/*78*/     /**
            *Método que permite almacenar la información respectiva a las acciones que los usuarios deben realizar
            * @return vector con las acciones a realizar por parte de los usuarios
            */
/*82*/     public Vector getAccionesUsuario() {
/*83*/         Vector accionesUsuario = new Vector();
/*84*/         int pos = 1;
/*85*/         for (int i = 0; i < clientes.size(); i++) {
/*86*/             if (i == 0) {
/*87*/                 if (clientes.get(i).equals("Sistema")) {
/*88*/                     accionesUsuario.add(tareas.get(i).toString());
/*89*/                 } else {
/*90*/                     accionesUsuario.add("");
/*91*/                 }
/*92*/                 pos++;
/*93*/             } else {
/*94*/                 if (nomCU.get(i).equals(nomCU.get(i - 1))) {
/*95*/                     if (clientes.get(i).equals("Sistema")) {
/*96*/                         accionesUsuario.add(tareas.get(i).toString());
/*97*/                     } else {
/*98*/                         accionesUsuario.add("");
/*99*/                     }
/*100*/                     pos++;
/*101*/                 } else {
/*102*/                     pos = 1;
/*103*/                     if (clientes.get(i).equals("Sistema")) {
/*104*/                         accionesUsuario.add(tareas.get(i).toString());
/*105*/                     } else {
/*106*/                         accionesUsuario.add("");
/*107*/                     }
/*108*/                     pos++;
/*109*/                 }
/*110*/             }
/*111*/         }
/*112*/         return accionesUsuario;
/*113*/     }
/*114*/ 
/*115*/     /**
             *Método que permite almacenar la información respectiva a las acciones que el sistema debe realizar
             * @return vector con las acciones a realizar por parte del sistema
             */
/*119*/     public Vector getAccionesSistema() {
/*120*/         Vector accionesSistema = new Vector();
/*121*/         int pos = 1;
/*122*/         for (int i = 0; i < realizadores.size(); i++) {
/*123*/             if (i == 0) {
/*124*/                 if (realizadores.get(i).equals("Sistema")) {
/*125*/                     accionesSistema.add(tareas.get(i).toString());
/*126*/                 } else {
/*127*/                     accionesSistema.add("");
/*128*/                 }
/*129*/                 pos++;
/*130*/             } else {
/*131*/                 if (nomCU.get(i).equals(nomCU.get(i - 1))) {
/*132*/                     if (realizadores.get(i).equals("Sistema")) {
/*133*/                         accionesSistema.add(tareas.get(i).toString());
/*134*/                     } else {
/*135*/                         accionesSistema.add("");
/*136*/                     }
/*137*/                     pos++;
/*138*/                 } else {
/*139*/                     pos = 1;
/*140*/                     if (realizadores.get(i).equals("Sistema")) {
/*141*/                         accionesSistema.add(tareas.get(i).toString());
/*142*/                     } else {
/*143*/                         accionesSistema.add("");
/*144*/                     }
/*145*/                     pos++;
/*146*/                 }
/*147*/             }
/*148*/         }
/*149*/         return accionesSistema;
/*150*/     }
/*151*/ 
/*152*/     /**
             *Método para obtener el nombre de un caso de uso
             * @return nombre del caso de uso, almacenado en un vector
             */
/*156*/     public Vector getNomCU() {
/*157*/         return this.nomCU;
/*158*/     }
/*159*/ 
/*160*/     /**
             * Método que permite modificar la descripción de los casos de uso,
             * provenientes del modelo de casos de uso
             * @param nomCU, nombre del caso de uso a ser descrito
             * @param accionesUsuario, acciones que realiza el usuario incorporadas en la descripcion
             * @param accionesSistema, acciones del sistema incorporadas a la descripcion
             */
/*166*/     public void setDescripcionCU(Vector nomCU, Vector accionesUsuario, Vector accionesSistema) {
/*167*/         Vector descripcionCU = new Vector();
/*168*/         String descripcion = null;
/*169*/         String CU = null;
/*170*/         for (int i = 0; i < nomCU.size(); i++) {
/*171*/             if (i == 0) {
/*172*/                 CU = nomCU.get(i).toString();
/*173*/                 if (!accionesUsuario.get(i).equals("")) {
/*174*/                     descripcion = "El usuario " + accionesUsuario.get(i).toString();
/*175*/                 }
/*176*/                 //System.out.println("acciones Usuario: "+accionesUsuario.get(i));
/*177*/                 if (!accionesSistema.get(i).equals("")) {
/*178*/                     descripcion = "El sistema " + accionesSistema.get(i).toString();
/*179*/                     //System.out.println("acciones Sistema: "+accionesSistema.get(i));
/*180*/                 }
/*181*/             } else {
/*182*/                 if (CU.equals(nomCU.get(i).toString())) {
/*183*/                     if (!accionesUsuario.get(i).equals("")) {
/*184*/                         if (!accionesUsuario.get(i - 1).equals("")) {
/*185*/                             if (i == nomCU.size() - 1) {
/*186*/                                 descripcion = descripcion + ", " + accionesUsuario.get(i).toString();
/*187*/                                 descripcionCU.add(descripcion);
/*188*/                             } else {
/*189*/                                 descripcion = descripcion + ", " + accionesUsuario.get(i).toString();
/*190*/                             }
/*191*/                         } else {
/*192*/                             if (i == nomCU.size() - 1) {
/*193*/                                 descripcion = descripcion + " El usuario " + accionesUsuario.get(i).toString();
/*194*/                                 descripcionCU.add(descripcion);
/*195*/                             } else {
/*196*/                                 descripcion = descripcion + " El usuario " + accionesUsuario.get(i).toString();
/*197*/                             }
/*198*/                         }
/*199*/                     }
/*200*/                     //System.out.println("acciones Usuario: "+accionesUsuario.get(i));
/*201*/                     if (!accionesSistema.get(i).equals("")) {
/*202*/                         if (i == nomCU.size() - 1) {
/*203*/                             descripcion = descripcion + " y el sistema " + accionesSistema.get(i).toString() + ".";
/*204*/                             descripcionCU.add(descripcion);
/*205*/                         } else {
/*206*/                             descripcion = descripcion + " y el sistema " + accionesSistema.get(i).toString() + ".";
/*207*/                         }
/*208*/                         //System.out.println("acciones Sistema: "+accionesSistema.get(i));
/*209*/                     }
/*210*/                 } else {
/*211*/                     CU = nomCU.get(i).toString();
/*212*/                     descripcionCU.add(descripcion);
/*213*/                     descripcion = null;
/*214*/                     if (!accionesUsuario.get(i).equals("")) {
/*215*/                         if (i == nomCU.size() - 1) {
/*216*/                             descripcion = "El usuario " + accionesUsuario.get(i).toString();
/*217*/                             descripcionCU.add(descripcion);
/*218*/                         } else {
/*219*/                             descripcion = "El usuario " + accionesUsuario.get(i).toString();
/*220*/                         }
/*221*/                     }
/*222*/                     //System.out.println("acciones Usuario: "+accionesUsuario.get(i));
/*223*/                     if (!accionesSistema.get(i).equals("")) {
/*224*/                         if (i == nomCU.size() - 1) {
/*225*/                             descripcion = "El sistema " + accionesSistema.get(i).toString();
/*226*/                             descripcionCU.add(descripcion);
/*227*/                         } else {
/*228*/                             descripcion = "El sistema " + accionesSistema.get(i).toString();
/*229*/                         }
/*230*/                         //System.out.println("acciones Sistema: "+accionesSistema.get(i));
/*231*/                     }
/*232*/                 }
/*233*/             }
/*234*/ 
/*235*/         }
/*236*/ 
/*237*/         this.modeloCU.setDescripcion(descripcionCU);
/*238*/     }
/*239*/
/**
* Método que invoca el controlador de las excepciones de un caso de uso,
* desde el controlador principal. Oculta la vista respectiva a la segunda
* descripcion de los casos de uso.
*/
/*240*/     public void irControladorExcepciones() {
/*241*/         this.controlMain.irControladorExcepciones(modeloMC, modeloON, modeloCU);
/*242*/         this.vista.setVisible(false);
/*243*/     }
/*244*/ 
/*245*/     /**
             *Método que invoca el controlador de la primera descripción de los casos de uso.
             * Oculta la vista correspondiente a la segunda descripcion de los casos de uso
             */
/*248*/     public void irControladorDescripcion1() {
/*249*/         this.controlMain.irControladorDescripcion1(modeloMC, modeloON, modeloCU);
/*250*/         //this.vista.setVisible(false);
/*251*/     }
/*252*/ 
/*253*/     

public void setDescripcionCU(){
    
    Vector nomCU;
    Vector accionesUsuario;
    Vector accionesSistema;
    
    nomCU = vista.getNomCU();
    accionesUsuario = vista.getAccionesUsuario();
    accionesSistema =vista.getAccionesSistema();
    
/*167*/         Vector descripcionCU = new Vector();
/*168*/         String descripcion = null;
/*169*/         String CU = null;
/*170*/         for (int i = 0; i < nomCU.size(); i++) {
/*171*/             if (i == 0) {
/*172*/                 CU = nomCU.get(i).toString();
/*173*/                 if (!accionesUsuario.get(i).equals("")) {
/*174*/                     descripcion = "El usuario " + accionesUsuario.get(i).toString();
/*175*/                 }
/*176*/                 //System.out.println("acciones Usuario: "+accionesUsuario.get(i));
/*177*/                 if (!accionesSistema.get(i).equals("")) {
/*178*/                     descripcion = "El sistema " + accionesSistema.get(i).toString();
/*179*/                     //System.out.println("acciones Sistema: "+accionesSistema.get(i));
/*180*/                 }
/*181*/             } else {
/*182*/                 if (CU.equals(nomCU.get(i).toString())) {
/*183*/                     if (!accionesUsuario.get(i).equals("")) {
/*184*/                         if (!accionesUsuario.get(i - 1).equals("")) {
/*185*/                             if (i == nomCU.size() - 1) {
/*186*/                                 descripcion = descripcion + ", " + accionesUsuario.get(i).toString();
/*187*/                                 descripcionCU.add(descripcion);
/*188*/                             } else {
/*189*/                                 descripcion = descripcion + ", " + accionesUsuario.get(i).toString();
/*190*/                             }
/*191*/                         } else {
/*192*/                             if (i == nomCU.size() - 1) {
/*193*/                                 descripcion = descripcion + " El usuario " + accionesUsuario.get(i).toString();
/*194*/                                 descripcionCU.add(descripcion);
/*195*/                             } else {
/*196*/                                 descripcion = descripcion + " El usuario " + accionesUsuario.get(i).toString();
/*197*/                             }
/*198*/                         }
/*199*/                     }
/*200*/                     //System.out.println("acciones Usuario: "+accionesUsuario.get(i));
/*201*/                     if (!accionesSistema.get(i).equals("")) {
/*202*/                         if (i == nomCU.size() - 1) {
/*203*/                             descripcion = descripcion + " y el sistema " + accionesSistema.get(i).toString() + ".";
/*204*/                             descripcionCU.add(descripcion);
/*205*/                         } else {
/*206*/                             descripcion = descripcion + " y el sistema " + accionesSistema.get(i).toString() + ".";
/*207*/                         }
/*208*/                         //System.out.println("acciones Sistema: "+accionesSistema.get(i));
/*209*/                     }
/*210*/                 } else {
/*211*/                     CU = nomCU.get(i).toString();
/*212*/                     descripcionCU.add(descripcion);
/*213*/                     descripcion = null;
/*214*/                     if (!accionesUsuario.get(i).equals("")) {
/*215*/                         if (i == nomCU.size() - 1) {
/*216*/                             descripcion = "El usuario " + accionesUsuario.get(i).toString();
/*217*/                             descripcionCU.add(descripcion);
/*218*/                         } else {
/*219*/                             descripcion = "El usuario " + accionesUsuario.get(i).toString();
/*220*/                         }
/*221*/                     }
/*222*/                     //System.out.println("acciones Usuario: "+accionesUsuario.get(i));
/*223*/                     if (!accionesSistema.get(i).equals("")) {
/*224*/                         if (i == nomCU.size() - 1) {
/*225*/                             descripcion = "El sistema " + accionesSistema.get(i).toString();
/*226*/                             descripcionCU.add(descripcion);
/*227*/                         } else {
/*228*/                             descripcion = "El sistema " + accionesSistema.get(i).toString();
/*229*/                         }
/*230*/                         //System.out.println("acciones Sistema: "+accionesSistema.get(i));
/*231*/                     }
/*232*/                 }
/*233*/             }
/*234*/ 
/*235*/         }
/*236*/ 
/*237*/         this.modeloCU.setDescripcion(descripcionCU);
}

/**
             * Método que invoca el controlador de ayuda de la segunda descripcion de los casos de uso.
             * Puede poner a vista del usuario la ventana de ayuda u ocultarla, segun sea el caso.
             */
/*266*/ 
/*267*/     /**
             *Método que instacia los modelos (conversacional, de obj. de negocio y de casos de uso)
             * para generar un archivo XML de una sesion anterior
             * @param ruta, direccion en la cual los mapas abiertos o modificados durante una sesión, serán guardados
             */
/*271*/     public void archivoSesion(String ruta) {
/*272*/         ModeloSesion sa = new ModeloSesion(modeloMC, modeloON, modeloCU);
/*273*/         sa.generarSAXML(10, ruta);
/*274*/     }
/*275*/ }
