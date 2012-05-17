/*1*/ package DTO;
/*2*/ 
/*3*/ /**
       *Esta clase hace referencia a métodos que se utilizan en el workflow condicional (Workflow Case-Out) que se son parte de los workflows especiales utilizados en un mapa conversacional.
       * @author DavidyAly
       */
/*7*/ public class ControlOrDTO {
/*8*/ 
/*9*/     int id;
/*10*/     String idNom;
/*11*/     String condicion;
/*12*/ 
/*13*/     /**
            *Constructor base de la clase ControlOrDTO. No recibe ni devuelve parámetros.
            */
/*16*/     public ControlOrDTO() {
/*17*/     }
/*18*/ 
/*19*/     /**
            *Constructor de la clase ControlOrDTO. Recibe 3 parametros asociados a la identificación numerica y nominal de workflow y una condicionante asociada al mismo (Ej: ¿Crédito>500M?").
            * @param id Identificador numérico del workflow en cuestion.
            * @param idNom Identificador nominal del workflow en cuestion.
            * @param condicion Representa la condicionante que se puede elegir o no para la construccion de las precondicones.
            */
/*25*/     public ControlOrDTO(int id, String idNom, String condicion) {
/*26*/         this.id = id;
/*27*/         this.idNom = idNom;
/*28*/         this.condicion = condicion;
/*29*/     }
/*30*/ 
/*31*/     /**
            *Método que obtiene el valor de la condicionante para la construcción de las precondiciones.
            * @return
            */
/*35*/     public String getCondicion() {
/*36*/         return condicion;
/*37*/     }
/*38*/ 
/*39*/     /**
            *Método que asigna una condicionante  para la construcción de las precondiciones.
            * @param condicion Nuevo valor para la condicionante asociada a la construcción de las precondiciones.
            */
/*43*/     public void setCondicion(String condicion) {
/*44*/         this.condicion = condicion;
/*45*/     }
/*46*/ 
/*47*/     /**
            *Método que obtiene el identificador numérico del workflow en cuestión.
            * @return Devuelve el valor del identificador numérico del workflow en cuestión.
            */
/*51*/     public int getId() {
/*52*/         return id;
/*53*/     }
/*54*/ 
/*55*/     /**
            *Método que asigna un valor para el identificador númerico del workflow en cuestión.
            * @param id Nuevo valor para el identificador numérico del workflow en cuestión.
            */
/*59*/     public void setId(int id) {
/*60*/         this.id = id;
/*61*/     }
/*62*/ 
/*63*/     /**
            *Método que obtiene el identificador nominal del workflow en cuestión.
            * @return Devuelve el valor del identificador nominal del workflow en cuestión.
            */
/*67*/     public String getIdNom() {
/*68*/         return idNom;
/*69*/     }
/*70*/ 
/*71*/     /**
            *Fucnión que asinga un valor para el identificador nominal para el workflow en cuestión.
            * @param idNom Nuevo valor para el identificador nominal del workflow en cuestiión.
           */
/*75*/     public void setIdNom(String idNom) {
/*76*/         this.idNom = idNom;
/*77*/     }
/*78*/ }
