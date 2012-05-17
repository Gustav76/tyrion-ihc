/*1*/ package DTO;
/*2*/ 
/*3*/ import java.util.Vector;
/*4*/ 
/*5*/ /**
       * 
       * Clase que mantiene un tipo de dato abstracto para el mapa conversacional con todos los Workflows.
       */
/*9*/ public class MapaConversacionalDTO {
/*10*/ 
/*11*/     Vector Ciclos;
/*12*/     Vector ControlesAnd;
/*13*/     Vector ControlesOr;
/*14*/     Vector pertenencias;
/*15*/     Vector excepciones;
/*16*/ 
/*17*/     /**
            * Constructor para MapaConversacional. No recibe ni devuelve parametros.
            */
/*20*/     public MapaConversacionalDTO() {
/*21*/     }
/*22*/ 
/*23*/     /**
            * Constructor para la clase Mapa conversacional, recibe 5 parámetros,  sirve para generar los workflows y crear las conexiones que representarn el mapa conversacional.
            * @param Ciclos  Es el Workflow básico.
            * @param ControlesAnd Workflow paralelo que compone los controles especiales de un mapa conversacional.
            * @param ControlesOr Workflow Condicional (Case Out) que componen los workflow de un mapa conversacional.
            * @param pertenencias Representa la conexión de pertenencia entre los Workflows.
            * @param excepciones Representa las excepciones del mapa conversacional.
            */
/*31*/     public MapaConversacionalDTO(Vector Ciclos, Vector ControlesAnd, Vector ControlesOr, Vector pertenencias, Vector excepciones) {
/*32*/         this.Ciclos = Ciclos;
/*33*/         this.ControlesAnd = ControlesAnd;
/*34*/         this.ControlesOr = ControlesOr;
/*35*/         this.pertenencias = pertenencias;
/*36*/         this.excepciones = excepciones;
/*37*/     }
/*38*/ 
/*39*/     /**
            * Constructor para la clase Mapa conversacional, recibe 4 parámetros, sirve para generar los workflows y crear las conexiones que representarn el mapa conversacional.
            * @param Ciclos  Representa el Workflow básico para componer el mapa conversacional.
            * @param ControlesAnd Workflow paralelo que compone los controles especiales de un mapa conversacional.
            * @param ControlesOr Workflow Condicional (Case Out) que componen los workflow de un mapa conversacional.
            * @param pertenencias Representa la conexión de pertenencia entre los Workflows.
            */
/*46*/     public MapaConversacionalDTO(Vector Ciclos, Vector ControlesAnd, Vector ControlesOr, Vector pertenencias) {
/*47*/         this.Ciclos = Ciclos;
/*48*/         this.ControlesAnd = ControlesAnd;
/*49*/         this.ControlesOr = ControlesOr;
/*50*/         this.pertenencias = pertenencias;
/*51*/     }
/*52*/ 
/*53*/     /**
            * Funcion que obtiene los ciclos, que representan los workflow.
            * @return Ciclos.
            */
/*57*/     public Vector getCiclos() {
/*58*/         return Ciclos;
/*59*/     }
/*60*/ 
/*61*/     /**
            * Función que asigna al vector las caracteristicas del Workflow basico.
            * @param Ciclos Nuevo workflow
            */
/*65*/     public void setCiclos(Vector Ciclos) {
/*66*/         this.Ciclos = Ciclos;
/*67*/     }
/*68*/ 
/*69*/     /**
            * Función que retorna los parámetros de un workflow paralelo.
            * @return ControlesAnd.
            */
/*73*/     public Vector getControlesAnd() {
/*74*/         return ControlesAnd;
/*75*/     }
/*76*/ 
/*77*/     /**
            * Función que asigna a un vector las condiciones referentes al workflow paralelo.
            * @param ControlesAnd workflow paralelo.
            */
/*81*/     public void setControlesAnd(Vector ControlesAnd) {
/*82*/         this.ControlesAnd = ControlesAnd;
/*83*/     }
/*84*/ 
/*85*/     /**
            * Funcion que retorna los parámetros en el vector de los Workflow Condicionales.
            * @return ControlesOr Workflow Condicional.
            */
/*89*/     public Vector getControlesOr() {
/*90*/         return ControlesOr;
/*91*/     }
/*92*/ 
/*93*/     /**
            * Funcion que asigna al vector los parámetros de un workflow condicional.
            * @param ControlesOr Workflow Condicional.
            */
/*97*/     public void setControlesOr(Vector ControlesOr) {
/*98*/         this.ControlesOr = ControlesOr;
/*99*/     }
/*100*/ 
/*101*/     /**
             * Función que retorna las excepciones del mapa conversacional.
             * @return excepciones Son las excepciones del mapa conversacional.
             */
/*105*/     public Vector getExcepciones() {
/*106*/         return excepciones;
/*107*/     }
/*108*/ 
/*109*/     /**
             * Función que asigna al vector excepciones una excepción para el mapa conversacional.
             * @param excepciones Excepciones para el mapa conversacional.
             */
/*113*/     public void setExcepciones(Vector excepciones) {
/*114*/         this.excepciones = excepciones;
/*115*/     }
/*116*/ 
/*117*/     /**
             * Función que retorna el vector con las pertenencias entre los workflows
             * @return pertenencias son las pertenencias entre los workflows.
             */
/*121*/     public Vector getPertenencias() {
/*122*/         return pertenencias;
/*123*/     }
/*124*/ 
/*125*/     /**
             * Función que asigna el vector que contiene las pertenencias entre un workflow y otro.
             * @param pertenencias Vector que mantiene las pertenencias entre los workflows.
             */
/*129*/     public void setPertenencias(Vector pertenencias) {
/*130*/         this.pertenencias = pertenencias;
/*131*/     }
/*132*/ }
