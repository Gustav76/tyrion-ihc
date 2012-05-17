/*1*/ package DTO;
/*2*/ 
/*3*/ import java.util.Vector;
/*4*/ 
/**
 * Esta clase y sus metodos, estan relacionados con la construcción de los elementos pertenecientes a los casos de uso, tales como precondiciones, excepciones, etc.
 * @author Rodrigo
 */
/*9*/ public class CasoDeUsoDTO {
/*10*/ 
/*11*/     String nombre;
/*12*/     double version;
/*13*/     String resumen;
/*14*/     Vector actores;
/*15*/     String precondiciones;
/*16*/     String descripcion;
/*17*/     String excepciones;
/*18*/     String postcondiciones;
/*19*/ 
/*20*/     /**
            * Constructor de la clase CasoDeUsoDTO. No recibe, ni devuelve parámetros.
            */
/*23*/     public CasoDeUsoDTO() {
/*24*/     }
/*25*/ 
/*26*/     /**
            * Método con la cual se obtiene la lista de actores del caso de uso 
            * @return Retorna el Vector cargado con los actores.
            */
/*30*/     public Vector getActores() {
/*31*/         return actores;
/*32*/     }
/*33*/ 
/*34*/     /**
            * Método que establece en la la variable global de nombre "actores"  el Vector con los actores del caso de uso actual.
            * @param actores Vector que se asigna a la variable global del mismo nombre.
            */
/*38*/     public void setActores(Vector actores) {
/*39*/         this.actores = actores;
/*40*/     }
/*41*/ 
/*42*/     /**
            * Método que obtiene el nombre del caso de uso actual.
            * @return retorna el nombre del caso de uso en cuestion.
            */
/*46*/     public String getNombre() {
/*47*/         return nombre;
/*48*/     }
/*49*/ 
/*50*/     /**
            * Método que Asigna un nombre al caso de uso actual.
            * @param nombre nuevo valor del nombre que se le dará al caso de uso actual.
            */
/*54*/     public void setNombre(String nombre) {
/*55*/         this.nombre = nombre;
/*56*/     }
/*57*/ 
/*58*/     /**
            *Método que obtiene una descripción del caso de uso actual.
            * @return retorna la descripción del caso de uso actual.
            */
/*62*/     public String getDescripcion() {
/*63*/         return descripcion;
/*64*/     }
/*65*/ 
/*66*/     /**
            *Método que asigna una descripción al caso de uso actual.
            * @param descripcion Nueva descripción que se le dará al caso de uso actual
            */
/*70*/     public void setDescripcion(String descripcion) {
/*71*/         this.descripcion = descripcion;
/*72*/     }
/*73*/ 
/*74*/     /**
            *Método que obtiene las excepciones del caso de uso actual.
            * @return Devuelve las excepciones relativas al caso de uso actual.
            */
/*78*/     public String getExcepciones() {
/*79*/         return excepciones;
/*80*/     }
/*81*/ 
/*82*/     /**
            *Método que asigna las excepciones pertinentes al caso de uso actual.
            * @param excepciones Nuevas Excepciones para el caso de uso actual.
            */
/*86*/     public void setExcepciones(String excepciones) {
/*87*/         this.excepciones = excepciones;
/*88*/     }
/*89*/ 
/*90*/     /**
            *Método que obtiene las postcondiciones del caso de uso actual.
            * @return Devuelve las postcondiciones  relativas al caso de uso actual.
            */
/*94*/     public String getPostcondiciones() {
/*95*/         return postcondiciones;
/*96*/     }
/*97*/ 
/*98*/     /**
             *Método que asigna  postcondicones al caso de uso actual.
             * @param postcondiciones Nuevas postcondicones para el caso de uso actual.
             */
/*102*/     public void setPostcondiciones(String postcondiciones) {
/*103*/         this.postcondiciones = postcondiciones;
/*104*/     }
/*105*/ 
/*106*/     /**
             *Método que obtiene las precondiciones del caso de uso actual.
             * @return Devuelve las precondicones relativas al caso de uso actual.
             */
/*110*/     public String getPrecondiciones() {
/*111*/         return precondiciones;
/*112*/     }
/*113*/ 
/*114*/     /**
             *Método que asigna precondicones al caso de uso actual.
             * @param precondiciones Nuevas precondiciones para el caso de uso actual.
             */
/*118*/     public void setPrecondiciones(String precondiciones) {
/*119*/         this.precondiciones = precondiciones;
/*120*/     }
/*121*/ 
/*122*/     /**
             *Método que obtiene un resumen de la Métodoalidad caso de uso actual.
             * @return Devuelve resumen de la Métodoalidad del caso de uso actual.
             */
/*126*/     public String getResumen() {
/*127*/         return resumen;
/*128*/     }
/*129*/ 
/*130*/     /**
             *Método que asigna un resumen de la Métodoalidad del caso de uso actual.
             * @param resumen Nueva descripción del resumen de Métodoalidad del caso de uso actual.
             */
/*134*/     public void setResumen(String resumen) {
/*135*/         this.resumen = resumen;
/*136*/     }
/*137*/ 
/*138*/     /**
             *Método que obtiene la versión actual del documento.
             * @return Devuelve la versión actual del documento.
            */
/*142*/     public double getVersion() {
/*143*/         return version;
/*144*/     }
/*145*/ 
/*146*/     /**
             *Método que asigna versión del documento.
             * @param version Nueva versión actual del documento.
             */
/*150*/     public void setVersion(double version) {
/*151*/         this.version = version;
/*152*/     }
/*153*/ }
