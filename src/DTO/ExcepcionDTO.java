/*1*/ package DTO;
/*2*/ 
/*3*/ /**
       *Esta clase y sus métodos asociados, tienen relacion con la construcción de los elementos necesarios para determinar los origenes y destinos de los workflows con que se trabajará, y así poder determinar su pertenencia.
       * @author DavidyAly
       */
/*7*/ public class ExcepcionDTO {
/*8*/ 
/*9*/     int origen;
/*10*/     int destino;
/*11*/     int probabilidad;
/*12*/     String Etiqueta;
/*13*/ 
/*14*/     /**
            *Constructor base de la clase ExcepcionDTO. No recibe ni devuelve argumentos.
            */
/*17*/     public ExcepcionDTO() {
/*18*/     }
/*19*/ 
/*20*/     /**
            *Constructor de la clase ExcepcionDTO. Recibe 3 parametros asociados al origen y destino de los workflow y su probabilidad.
            * @param origen Representa el identificador númerico interno del workflow origen.
            * @param destino Representa el identificador númerico interno del workflow destino.
            * @param probabilidad Representa la probabilidad de conexión de pertenencia.
            */
/*26*/     public ExcepcionDTO(int origen, int destino, int probabilidad) {
/*27*/         this.origen = origen;
/*28*/         this.destino = destino;
/*29*/         this.probabilidad = probabilidad;
/*30*/     }
/*31*/ 
/*32*/     /**
            *Constructor de la clase ExcepcionDTO. Recibe 4 parametros asociados al origen y destino de los workflow asi como también la probabilidad y el "tag" o etiqueta que identifica la conexion.
            * @param origen  Representa el identificador númerico interno del workflow origen.
            * @param destino  Representa el identificador númerico interno del workflow origen.
            * @param probabilidad Representa la probabilidad de conexión de pertenencia.
            * @param Etiqueta Representa un nombre o "tag" para la conexion de pertenencia.
            */
/*39*/     public ExcepcionDTO(int origen, int destino, int probabilidad, String Etiqueta) {
/*40*/         this.origen = origen;
/*41*/         this.destino = destino;
/*42*/         this.probabilidad = probabilidad;
/*43*/         this.Etiqueta = Etiqueta;
/*44*/     }
/*45*/ 
/*46*/     /**
            *Método que obtiene la etiqueta o "tag" de la conexion de pertenencia.
            * @return Devuelve el "tag" o etiqueta de la conexion.
            */
/*50*/     public String getEtiqueta() {
/*51*/         return Etiqueta;
/*52*/     }
/*53*/ 
/*54*/     /**
            *Método que asigna una etiqueta o "tag" de la conexion de pertenencia.
            * @param Etiqueta Nuevo nombre o tag para la conexión de pertennecia.
            */
/*58*/     public void setEtiqueta(String Etiqueta) {
/*59*/         this.Etiqueta = Etiqueta;
/*60*/     }
/*61*/ 
/*62*/     /**
            *Método que obtiene el identificador numérico del destino del workflow.
            * @return Devuelve el identificador numérico del destino del workflow.
            */
/*66*/     public int getDestino() {
/*67*/         return destino;
/*68*/     }
/*69*/ 
/*70*/     /**
            *Método que asigna el identificador numérico del destino del workflow.
            * @param destino Nuevo valor para el identificador numérico del destino del workflow.
            */
/*74*/     public void setDestino(int destino) {
/*75*/         this.destino = destino;
/*76*/     }
/*77*/ 
/*78*/     /**
            *Método que Obtiene el identificador numérico del origen del workflow.
            * @return Devuelve el identificador numérico del origen del workflow.
            */
/*82*/     public int getOrigen() {
/*83*/         return origen;
/*84*/     }
/*85*/ 
/*86*/     /**
            *Metodo que asigna el identificador numérico del origen del workflow.
            * @param origen Nuevo valor para el identificador numérico del origen del workflow.
            */
/*90*/     public void setOrigen(int origen) {
/*91*/         this.origen = origen;
/*92*/     }
/*93*/ 
/*94*/     /**
            *Método que obtiene la probabilidad de pertenencia de la conexión..
            * @return Devuelve la probabilidad de pertenencia de la conexión.
            */
/*98*/     public int getProbabilidad() {
/*99*/         return probabilidad;
/*100*/     }
/*101*/ 
/*102*/     /**
             *Método que asigna la probabilidad de pertenencia de la conexión.
             * @param probabilidad Nuevo valor para la probabilidad de pertenencia de la conexión.
             */
/*106*/     public void setProbabilidad(int probabilidad) {
/*107*/         this.probabilidad = probabilidad;
/*108*/     }
/*109*/ }
