/*1*/ package DTO;
/*2*/ 
/*3*/ /**
       * Esta clase y sus métodos hacen referencia a un tipo de workflow "paralelo" que compone controles especiales de un mapa conversacional. Por lo que sus Métodos y el termino "workflow" (en este caso) estan orientadas a ello.
       * @author DavidyAly
       */
/*7*/ public class ControlAndDTO {
/*8*/ 
/*9*/      int id;
/*10*/     String idNom;
/*11*/ 
/*12*/     /**
            *Constructor base de la clase ControlAndDTO. No recibe ni devuelve parametros.
            */
/*15*/     public ControlAndDTO() {
/*16*/     }
/*17*/ 
/*18*/     /**
            *Constructor de la clase ControlAndDTO. Recibe 2 parámetros asociados al identificador, tanto númerico como nominal del workflow en cuestión.
            * @param id Identificador numérico del workflow en cuestion.
            * @param idNom Identificador nominal del workflow en cuestion.
            */
/*23*/     public ControlAndDTO(int id, String idNom) {
/*24*/         this.id = id;
/*25*/         this.idNom = idNom;
/*26*/     }
/*27*/ 
/*28*/     /**
            *Método que obtiene el identificador numérico del workflow en cuestion.
            * @return Devuelve el identificador numérico del workflow en cuestion.
            */
/*32*/     public int getId() {
/*33*/         return id;
/*34*/     }
/*35*/ 
/*36*/     /**
            *Método que asigna un identificador numérico al workflow en cuestion.
            * @param id Nuevo valor para el identificador numérico del workflow en cuestion.
            */
/*40*/     public void setId(int id) {
/*41*/         this.id = id;
/*42*/     }
/*43*/ 
/*44*/     /**
            *Método que obtiene el identificador nominal del workflow en cuestion.
            * @return Devuelve el identificador nominal del workflow en cuestion.
            */
/*48*/     public String getIdNom() {
/*49*/         return idNom;
/*50*/     }
/*51*/ 
/*52*/     /**
            *Método que asigna un identificador nominal a un workflow en cuestion.
            * @param idNom Nuevo valor para el identificador nominal del workflow en cuestion.
            */
/*56*/     public void setIdNom(String idNom) {
/*57*/         this.idNom = idNom;
/*58*/     }
/*59*/ }
