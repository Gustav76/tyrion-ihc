/*1*/ package DTO;
/*2*/ 
/*3*/ import java.util.Vector;
/*4*/ 
/*5*/ /**
       *
       * Creacion de la clase NodoDTO, Genera el arbol de tareas.
       */
/*9*/ public class nodoDTO {
/*10*/ 
/*11*/     int idPadre;
/*12*/     Vector nodHijos;
/*13*/     TareaDTO datosT;
/*14*/ 
/*15*/     /**
            *  Constructor para un nodo del arbol de tareas.
            */
/*18*/     public nodoDTO() {
/*19*/     }
/*20*/ 
/*21*/     /**
            * Constructor que genera un nodo del árbol de tareas, Recibe los 3 parámetros.
            * @param idPadre Es el identificador del nodo padre del árbol.
            * @param nodHijos Son los nodos hijos del árbol.
            * @param datosT Son las tareas del árbol.
            */
/*27*/     public nodoDTO(int idPadre, Vector nodHijos, TareaDTO datosT) {
/*28*/         this.idPadre = idPadre;
/*29*/         this.nodHijos = nodHijos;
/*30*/         this.datosT = datosT;
/*31*/     }
/*32*/ 
/*33*/     /**
            * Constructor para un nodo del árbol d tareas, genera el nodo padre.
            * @param idPadre Es el identificador del nodo padre.
            * @param datosT Son las tareas asignadas al nodo.
            */
/*38*/     public nodoDTO(int idPadre, TareaDTO datosT) {
/*39*/         this.idPadre = idPadre;
/*40*/         this.datosT = datosT;
/*41*/     }
/*42*/ 
/*43*/     /**
            * Función para obtener las tareas del nodo.
            * @return datosT Son las tareas asignadas al nodo.
            */
/*47*/     public TareaDTO getDatosT() {
/*48*/         return datosT;
/*49*/     }
/*50*/ 
/*51*/     /**
            * Función para asignar las tareas a un Nodo el arbol.
            * @param datosT Son las tareas del nodo.
            */
/*55*/     public void setDatosT(TareaDTO datosT) {
/*56*/         this.datosT = datosT;
/*57*/     }
/*58*/ 
/*59*/     /**
            * Función para obtener el identificador de nodo padre.
            * @return idPadre es el identificador del nodo padre en el árbol.
            */
/*63*/     public int getIdPadre() {
/*64*/         return idPadre;
/*65*/     }
/*66*/ 
/*67*/     /**
            * Función para asignar el identificador del padre.
            * @param idPadre Es el identificador del nodo padre en el árbol.
            */
/*71*/     public void setIdPadre(int idPadre) {
/*72*/         this.idPadre = idPadre;
/*73*/     }
/*74*/ 
/*75*/     /**
            * Función para obtener los hijos de un nodo.
            * @return nodHijos Es el vector de hijos de un Nodo.
            */
/*79*/     public Vector getNodHijos() {
/*80*/         return nodHijos;
/*81*/     }
/*82*/ 
/*83*/     /**
            * Función para asignar los hijos a un nodo.
            * @param nodHijos Es el vector de hijos de un nodo.
            */
/*87*/     public void setNodHijos(Vector nodHijos) {
/*88*/         this.nodHijos = nodHijos;
/*89*/     }
/*90*/ }
