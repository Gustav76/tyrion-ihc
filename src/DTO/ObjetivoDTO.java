/*1*/ package DTO;
/*2*/ 
/*3*/ import java.util.Vector;
/*4*/ 
/*5*/ /**
       * Clase que representa un objetivo. Los objetivos de alto nivel que representan las metas a cumplir de un sistema.
       * @author Sebastian.
       */
/*9*/ public class ObjetivoDTO {
/*10*/ 
/*11*/     int id;
/*12*/     String nombre;
/*13*/     DescripcionObjDTO descObj;
/*14*/     Vector arbolTareas;
/*15*/ 
/*16*/     /**
            * Constructor de la Clase Objetivo, no recibe ni retorna parámetros.
            */
/*19*/     public ObjetivoDTO() {
/*20*/     }
/*21*/ 
/*22*/     /**
            * Constructor para la clase ObjetivoDTO, representa un objetivo de alto nivel del sistema.
            * @param id Representa el identificador del objetivo.
            * @param nombre Es el nombre del Objetivo.
            * @param descObj Representa la descripción del objetivo.
            * @param arbolTareas Representa las tareas que componen el objetivo.
            */
/*29*/     public ObjetivoDTO(int id, String nombre, DescripcionObjDTO descObj, Vector arbolTareas) {
/*30*/         this.id = id;
/*31*/         this.nombre = nombre;
/*32*/         this.descObj = descObj;
/*33*/         this.arbolTareas = arbolTareas;
/*34*/     }
/*35*/ 
/*36*/     /**
            * Función para obtener el vector que almacena las tareas del objetivo.
            * @return arbolTareas Es el vector que almacena las tareas del objetivo.
            */
/*40*/     public Vector getArbolTareas() {
/*41*/         return arbolTareas;
/*42*/     }
/*43*/ 
/*44*/     /**
            * Función para asignar el vector de tareas a un objetivo.
            * @param arbolTareas Es el vector que almacena las tareas del objetivo.
            */
/*48*/     public void setArbolTareas(Vector arbolTareas) {
/*49*/         this.arbolTareas = arbolTareas;
/*50*/     }
/*51*/ 
/*52*/     /**
            * Función para obtener la descripción de un objetivo.
            * @return descObj Representa la descripción del objetivo.
            */
/*56*/     public DescripcionObjDTO getDescObj() {
/*57*/         return descObj;
/*58*/     }
/*59*/ 
/*60*/     /**
            * Función para asignar la descripción de un objetivo.
            * @param descObj Representa la descricpión del objetivo.
            */
/*64*/     public void setDescObj(DescripcionObjDTO descObj) {
/*65*/         this.descObj = descObj;
/*66*/     }
/*67*/ 
/*68*/     /**
            * Función para obtener el ID de un objetivo.
            * @return id Representa el ID del objetivo.
            */
/*72*/     public int getId() {
/*73*/         return id;
/*74*/     }
/*75*/ 
/*76*/     /**
            * Función para asignar un ID a un objetivo.
            * @param id Representa el Id del objetivo.
            */
/*80*/     public void setId(int id) {
/*81*/         this.id = id;
/*82*/     }
/*83*/ 
/*84*/     /**
            * Función para obtener el Nombre de un objetivo.
            * @return nombre Representa el nombre del objetivo.
            */
/*88*/     public String getNombre() {
/*89*/         return nombre;
/*90*/     }
/*91*/ 
/*92*/     /**
            * Función para asignar un nombre a un objetivo.
            * @param nombre Representa el nombre del objetivo.
            */
/*96*/     public void setNombre(String nombre) {
/*97*/         this.nombre = nombre;
/*98*/     }
/*99*/ }
