/*1*/ package DTO;
/*2*/ 
/*3*/ /**
       *
       * Clase que representa los identificadores del workflow.
       */
/*7*/ public class WorkflowDTO {
/*8*/ 
/*9*/     int id;
/*10*/     String idNom;
/*11*/     String Etiqueta;
/*12*/     String tipo;
/*13*/ 
/*14*/     /**
            * Constructor para crear un workflow, no recibe ni retorna datos.
            */
/*17*/     public WorkflowDTO() {
/*18*/     }
/*19*/ 
/*20*/     /**
            * Contructor de los identificadores de un workflow recibe 4 parámetros.
            * @param id Identificador numérico del workflow.
            * @param idNom Identificador Nominal del workflow.
            * @param Etiqueta Detalle de workflow.
            * @param tipo tipo de workflow.
            */
/*27*/     public WorkflowDTO(int id, String idNom, String Etiqueta, String tipo) {
/*28*/         this.id = id;
/*29*/         this.idNom = idNom;
/*30*/         this.Etiqueta = Etiqueta;
/*31*/         this.tipo = tipo;
/*32*/     }
/*33*/ 
/*34*/     /**
            * Función para obtener la etiqueta asignada a un workflow.
            * @return Etiqueta representa la etiqueta de un workflow
            */
/*38*/     public String getEtiqueta() {
/*39*/         return Etiqueta;
/*40*/     }
/*41*/ 
/*42*/     /**
            * Función para asignar una etiqueta a un workflow.
            * @param Etiqueta representa la etiqueta de un workflow.
            */
/*46*/     public void setEtiqueta(String Etiqueta) {
/*47*/         this.Etiqueta = Etiqueta;
/*48*/     }
/*49*/ 
/*50*/     /**
            * Función para obtener el ID de un workflow.
            * @return id es el ID del workflow.
            */
/*54*/     public int getId() {
/*55*/         return id;
/*56*/     }
/*57*/ 
/*58*/     /**
            * Función para asignar un id a un workflow.
            * @param id es el id del workflow.
            */
/*62*/     public void setId(int id) {
/*63*/         this.id = id;
/*64*/     }
/*65*/ 
/*66*/     /**
            * Función para obtener el IDnominal del Workflow.
            * @return idNom  es el ID nominal del workflow,
            */
/*70*/     public String getIdNom() {
/*71*/         return idNom;
/*72*/     }
/*73*/ 
/*74*/     /**
            * Función para asignar un id Nominal a un Workflow.
            * @param idNom Representa el id Nominal del workflow.
            */
/*78*/     public void setIdNom(String idNom) {
/*79*/         this.idNom = idNom;
/*80*/     }
/*81*/ 
/*82*/     /**
            * Función para obtener el tipo de Workflow
            * @return tipo Representa el tipo de Workflow.
            */
/*86*/     public String getTipo() {
/*87*/         return tipo;
/*88*/     }
/*89*/ 
/*90*/     /**
            * Función para asignar un tipo a un Workflow.
            * @param tipo Representa el tipo de Workflow.
            */
/*94*/     public void setTipo(String tipo) {
/*95*/         this.tipo = tipo;
/*96*/     }
/*97*/ }
