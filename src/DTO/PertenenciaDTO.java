/*1*/ package DTO;
/*2*/ 
/*3*/ /**
       * Clase que representa la pertenencia de un Workflow con otro.
       * @author Sebastian.
       */
/*7*/ public class PertenenciaDTO {
/*8*/     int origen;
/*9*/     int destino;
/*10*/     String Etiqueta;
/*11*/ 
/*12*/     /**
            * Contructor para pertenencia, no recibe ni retorna valores.
            */
/*15*/     public PertenenciaDTO() {
/*16*/     }
/*17*/ 
/*18*/     /**
            * Contructor para la clase pertenencia, recibe 2 parámetros Origen y destino que representan los workflow asociados.
            * @param origen representa Workflow origen.
            * @param destino representa workflow destino.
            */
/*23*/     public PertenenciaDTO(int origen, int destino) {
/*24*/         this.origen = origen;
/*25*/         this.destino = destino;
/*26*/     }
/*27*/ 
/*28*/     /**
            * Contructor para la clase pertenencia, recibe 3 parámetros Origen y destino que representan los workflow asociados, etiqueta como detalle de la conexión entre los workflows.
            * @param origen representa workflow de origen.
            * @param destino representa workflow de destino.
            * @param Etiqueta detalle de la conexión entre los workflows.
            */
/*34*/     public PertenenciaDTO(int origen, int destino, String Etiqueta) {
/*35*/         this.origen = origen;
/*36*/         this.destino = destino;
/*37*/         this.Etiqueta = Etiqueta;
/*38*/     }
/*39*/ 
/*40*/     /**
            * Función para obtener el detalle de la conexión entre los workflows
            * @return Etiqueta  nombre o detalle de la conexión.
            */
/*44*/     public String getEtiqueta() {
/*45*/         return Etiqueta;
/*46*/     }
/*47*/ 
/*48*/     /**
            * Asigna el valor para la etiqueta que muestra el nombre o detalle de la conexión entre los workflows.
            * @param Etiqueta nombre o detalle de la conexión entre workflows.
            */
/*52*/     public void setEtiqueta(String Etiqueta) {
/*53*/         this.Etiqueta = Etiqueta;
/*54*/     }
/*55*/ 
/*56*/     /**
            * Función para obtener el workflow destino.
            * @return destino representa el id del workflow destino.
            */
/*60*/     public int getDestino() {
/*61*/         return destino;
/*62*/     }
/*63*/ 
/*64*/     /**
            * Función para asignar el valor del id del workflow destino.
            * @param destino representa el id del workflow destino.
            */
/*68*/     public void setDestino(int destino) {
/*69*/         this.destino = destino;
/*70*/     }
/*71*/ 
/*72*/     /**
            * Función para obtener el workflow origen.
            * @return origen representa el id del workflow origen.
            */
/*76*/     public int getOrigen() {
/*77*/         return origen;
/*78*/     }
/*79*/ 
/*80*/     /**
            * Función para asignar el valor del id del workflow origen.
            * @param origen representa el id del workflow origen.
            */
/*84*/     public void setOrigen(int origen) {
/*85*/         this.origen = origen;
/*86*/     }
/*87*/ }
