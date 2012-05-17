/*1*/ package DTO;
/*2*/ 
/*3*/ import java.util.Vector;
/*4*/ 
      /**
       *Esta clase y los métodos que la componene, hacen referencia a la construcción de los ciclos de un mapa conversacional básico. En particular, en esta clase se construyen parte de los elementos de un workflow.
       * @author Rodrigo
       */
/*9*/ public class CicloDTO {
/*10*/ 
/*11*/     int id;
/*12*/     String idNom;
/*13*/     String Etiqueta;
/*14*/     Vector ListaClientes;
/*15*/     Vector ListaRealizadores;
/*16*/ 
/*17*/     /**
            *Constructor base de la clase CicloDTO. No recibe ni devuelve parámetros.
            */
/*20*/     public CicloDTO() {
/*21*/     }
/*22*/ 
/*23*/     /**
            *Constructor de la clase CicloDTO. Recibe 5 parámetros utiles para realizar un ciclo del workflow del mapa conversacional.
            * @param id Identificador númerico del workflow.
            * @param idNom Identificador nominal del workflow.
            * @param Etiqueta Representa el nombre del Workflow en cuestion.
            * @param ListaClientes Vector que guarda el rol que cumple cada uno de los clientes.
            * @param ListaRealizadores Vector que guarda el rol que cumple cada uno de los realizadores.
            */
/*31*/     public CicloDTO(int id, String idNom, String Etiqueta, Vector ListaClientes, Vector ListaRealizadores) {
/*32*/         this.id = id;
/*33*/         this.idNom = idNom;
/*34*/         this.Etiqueta = Etiqueta;
/*35*/         this.ListaClientes = ListaClientes;
/*36*/         this.ListaRealizadores = ListaRealizadores;
/*37*/     }
/*38*/ 
/*39*/     /**
            *Constructor de la clase cicloDTO. Recibe 3 parámetros relacionados con la identificación del workflow del mapa conversacional.
            * @param id Identificador numérico del workflow en cuestion.
            * @param idNom Identificador nominal del workflow en cuestion.
            * @param Etiqueta Representa el nombre del workflow en cuestion.
            */
/*45*/     public CicloDTO(int id, String idNom, String Etiqueta) {
/*46*/         this.id = id;
/*47*/         this.idNom = idNom;
/*48*/         this.Etiqueta = Etiqueta;
/*49*/     }
/*50*/ 
/*51*/     /**
            *Método que obtiene la etiqueta del workflow asociado.
            * @return Devuelve el nombre (etiqueta) del workflow en cuestion.
            */
/*55*/     public String getEtiqueta() {
/*56*/         return Etiqueta;
/*57*/     }
/*58*/ 
/*59*/     /**
            *Método que asigna un nombre a el workflow en cuestion.
            * @param Etiqueta Nuevo nombre para el workflow que se usará.
            */
/*63*/     public void setEtiqueta(String Etiqueta) {
/*64*/         this.Etiqueta = Etiqueta;
/*65*/     }
/*66*/ 
/*67*/     /**
            *Método con la cual se obtiene la lista de roles de clientes.
            * @return Devuelve un vector con los roles de clientes.
            */
/*71*/     public Vector getListaClientes() {
/*72*/         return ListaClientes;
/*73*/     }
/*74*/ 
/*75*/     /**
            *Método que asigna a un vector, la lista de roles de clientes.
            * @param ListaClientes Nuevos valores para el vector que guarda la lista de roles de clientes.
            */
/*79*/     public void setListaClientes(Vector ListaClientes) {
/*80*/         this.ListaClientes = ListaClientes;
/*81*/     }
/*82*/ 
/*83*/     /**
            *Método que obtiene la lista de roles de realizadores.
            * @return Devuelve la lista de roles de realizadores existentes.
            */
/*87*/     public Vector getListaRealizadores() {
/*88*/         return ListaRealizadores;
/*89*/     }
/*90*/ 
/*91*/     /**
            *Método que asigna a un vector, la lista de roles de realizadores existentes.
            * @param ListaRealizadores Nuevos valores para el vector que guardará la lista de roles de realizadores existentes.
            */
/*95*/     public void setListaRealizadores(Vector ListaRealizadores) {
/*96*/         this.ListaRealizadores = ListaRealizadores;
/*97*/     }
/*98*/ 
/*99*/     /**
             *Método que obtiene el identificador numérico del workflow en cuestion.
             * @return Devuelve el identificador númerico del workoflow en cuestion.
             */
/*103*/     public int getId() {
/*104*/         return id;
/*105*/     }
/*106*/ 
/*107*/     /**
             *Método que asigna un identificador númerico a un workflow.
             * @param id Nuevo valor para el identificador númerico del workflow en cuestion.
             */
/*111*/     public void setId(int id) {
/*112*/         this.id = id;
/*113*/     }
/*114*/ 
/*115*/     /**
             *Método que obtiene el identificador nominal del workflow en cuestion.
             * @return Devuelve el identificador nominal del workflow asociado.
             */
/*119*/     public String getIdNom() {
/*120*/         return idNom;
/*121*/     }
/*122*/ 
/*123*/     /**
             *Método que asigna un identificador nominal al workflow en cuestion.
             * @param idNom Nuevo valor para el identificador nominal del workflow en cuestion.
             */
/*127*/     public void setIdNom(String idNom) {
/*128*/         this.idNom = idNom;
/*129*/     }
/*130*/ }
