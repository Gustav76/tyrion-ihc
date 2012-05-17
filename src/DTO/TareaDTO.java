/*1*/ package DTO;
/*2*/ 
/*3*/ /**
       * Clase que representa una tarea, que son los objetivos de mas bajo nivel que describen el funcionamiento del sistema.
       * @author Sebastian.
       */
/*7*/ public class TareaDTO {
/*8*/ 
/*9*/     int id;
/*10*/     String Etiqueta;
/*11*/ 
/*12*/     /**
            * Construcor para la clase Tarea, no recibe ni retorna parámetros.
            */
/*15*/     public TareaDTO() {
/*16*/     }
/*17*/ 
/*18*/     /**
            * Constructor para la clase tarea
            * @param id representa el identificador de la tarea
            * @param Etiqueta representa el nombre de la tarea, como se muestra ésta en el programa.
            */
/*23*/     public TareaDTO(int id, String Etiqueta) {
/*24*/         this.id = id;
/*25*/         this.Etiqueta = Etiqueta;
/*26*/     }
/*27*/ 
/*28*/     /**
            * Función para obtener la etiqueta de la tarea.
            * @return Etiqueta Representa el detalle de la tarea.
            */
/*32*/     public String getEtiqueta() {
/*33*/         return Etiqueta;
/*34*/     }
/*35*/ 
/*36*/     /**
            * Función para asignar la etiqueta a la tarea.
            * @param Etiqueta Representa el detalle de la tarea.
            */
/*40*/     public void setEtiqueta(String Etiqueta) {
/*41*/         this.Etiqueta = Etiqueta;
/*42*/     }
/*43*/ 
/*44*/     /**
            * Función para obtener el ID de una tarea.
            * @return id Es el identificador de la tarea.
            */
/*48*/     public int getId() {
/*49*/         return id;
/*50*/     }
/*51*/ 
/*52*/     /**
            * Función para asignar el ID a una tarea.
            * @param id Es el identificador de una tarea.
            */
/*56*/     public void setId(int id) {
/*57*/         this.id = id;
/*58*/     }
/*59*/ }
