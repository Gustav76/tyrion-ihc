/*1*/ package DTO;
/*2*/ 
/*3*/ import java.util.Vector;
/*4*/ 
/*5*/ /**
       *Esta clase y los métodos que la componen hacen referencia a la construcción de la descripción de los objetivos. Algunos elementos básicos que la componen son el nombre del objetivo, los sub-objetivos que emergen, los interesados en que suceda ese objetivo, etc.
       * @author DavidyAly
       */
/*9*/ public class DescripcionObjDTO {
/*10*/     String nombreObjetivo;
/*11*/     String descripcion;
/*12*/     String accion;
/*13*/     String restricciones;
/*14*/     String obstaculos;
/*15*/     String preCondiciones;
/*16*/     String postCondiciones;
/*17*/     String subObjetivos;
/*18*/     Vector Agentes;
/*19*/     Vector Interesados;
/*20*/ 
/*21*/     /**
            *Constructor base de la clase DescripcionObjDTO. No recibe ni devuelve argumentos.
            */
/*24*/     public DescripcionObjDTO() {
/*25*/     }
/*26*/ 
/*27*/     /**
            *Constructor de la clase DescripcionObjDTO. Recibe 10 parámetros útiles para la construcción de excepciones de los casos de uso en cuestión.
            * @param nombreObjetivo Identificador único para cada objetivo.
            * @param descripcion Breve resumen del objetivo en cuestión.
            * @param accion Representa la acción alternativa que se debe seguir para las excepciones del workflow.
            * @param restricciones Representa limitaciones bajo las que un objetivo se debe cumplir.
            * @param obstaculos Representa circunstancia que pueda impedir que se cumpla objetivo.
            * @param preCondiciones Representa una precondición a cumplir, asociada al caso de uso en cuestión para que se cumpla el objetivo.
            * @param postCondiciones Representa una condición a la que se llega luego de que un objetivo ha sido cumplido.
            * @param subObjetivos Representa acciones menores que se deben conseguir. Estas acciones estan asociadas a los objetivos del caso de uso en cuestión.
            * @param Agentes Representa a quien debe completar o cumplir un objetivo.
            * @param Interesados Representa a los interesados en que se cumpla un objetivo.
            */
/*40*/     public DescripcionObjDTO(String nombreObjetivo, String descripcion, String accion, String restricciones, String obstaculos, String preCondiciones, String postCondiciones, String subObjetivos, Vector Agentes, Vector Interesados) {
/*41*/         this.nombreObjetivo = nombreObjetivo;
/*42*/         this.descripcion = descripcion;
/*43*/         this.accion = accion;
/*44*/         this.restricciones = restricciones;
/*45*/         this.obstaculos = obstaculos;
/*46*/         this.preCondiciones = preCondiciones;
/*47*/         this.postCondiciones = postCondiciones;
/*48*/         this.subObjetivos = subObjetivos;
/*49*/         this.Agentes = Agentes;
/*50*/         this.Interesados = Interesados;
/*51*/     }
/*52*/ 
/*53*/     /**
            *Método que obtiene la lista de de agentes que deben cumplir un objetivo particular.
            * @return Devuelve un vector con la lista de agentes en cuestión.
            */
/*57*/     public Vector getAgentes() {
/*58*/         return Agentes;
/*59*/     }
/*60*/ 
/*61*/     /**
            *Método que asigna un valor para el vector de agentes, los cuales deben cumplir un objetivo particular.
            * @param Agentes Nuevo valor para el vector de agentes, los cuales deben cumplir un objetivo particular.
            */
/*65*/     public void setAgentes(Vector Agentes) {
/*66*/         this.Agentes = Agentes;
/*67*/     }
/*68*/ 
/*69*/     /**
            *Método que obtiene el vector de interesados en que se cumpla un objetivo particular.
            * @return Devuelve el vector de interesados en un objetivo.
            */
/*73*/     public Vector getInteresados() {
/*74*/         return Interesados;
/*75*/     }
/*76*/ 
/*77*/     /**
            *Método que asigna un valor para el vector de interesados en que se cumpla un objetivo particular.
            * @param Interesados Nuevo valor para el vector de interesados en que se cumpla un objetivo en particular.
            */
/*81*/     public void setInteresados(Vector Interesados) {
/*82*/         this.Interesados = Interesados;
/*83*/     }
/*84*/ 
/*85*/     /**
            *Método que obtiene la acción necesaria para satisfacer un objetivo. 
            * @return Devuelve un string indicando la acción que se debe satisfacer para cumplir un objetivo.
            */
/*89*/     public String getAccion() {
/*90*/         return accion;
/*91*/     }
/*92*/ 
/*93*/     /**
            *Método que asigna un valor para realizar la acción necesaria que satisfaga un objetivo.
            * @param accion Nuevo valor de la acción que se debe satisfacer para cumplir un objetivo.
            */
/*97*/     public void setAccion(String accion) {
/*98*/         this.accion = accion;
/*99*/     }
/*100*/ 
/*101*/     /**
             *Método que obtiene la descripción del objetivo a conseguir.
             * @return Devuelve la descripción del objetivo a conseguir.
             */
/*105*/     public String getDescripcion() {
/*106*/         return descripcion;
/*107*/     }
/*108*/ 
/*109*/     /**
             *Método que asigna una descripción para el objetivo a conseguir.
             * @param descripcion Nueva descripción para el objetivo a conseguir.
             */
/*113*/     public void setDescripcion(String descripcion) {
/*114*/         this.descripcion = descripcion;
/*115*/     }
/*116*/ 
/*117*/     /**
             *Método que obtiene el identificador único del objetivo.
             * @return Devuelve el identificador único del objetivo.
             */
/*121*/     public String getNombreObjetivo() {
/*122*/         return nombreObjetivo;
/*123*/     }
/*124*/ 
/*125*/     /**
             *Método que asigna un nombre para el identificador único del objetivo.
             * @param nombreObjetivo Nuevo valor para el nombre del identificador único del objetivo.
             */
/*129*/     public void setNombreObjetivo(String nombreObjetivo) {
/*130*/         this.nombreObjetivo = nombreObjetivo;
/*131*/     }
/*132*/ 
/*133*/     /**
             *Método que obtiene los obstáculos que pueden impedir que un objetivo sea cumplido.
             * @return Devuelve los obstáculos existentes que pueden impedir que un objetivo se cumpla.
             */ 
/*137*/     public String getObstaculos() {
/*138*/         return obstaculos;
/*139*/     }
/*140*/ 
/*141*/     /**
             *Método que asigna los obstaculos que puedan impedir la realización de un objetivo.
             * @param obstaculos Nuevos obstaculos que puedan impedir la realización de un objetivo.
             */
/*145*/     public void setObstaculos(String obstaculos) {
/*146*/         this.obstaculos = obstaculos;
/*147*/     }
/*148*/ 
/*149*/     /**
             *Método que obtiene las postcondiciones a las que se arriba luego de completar un objetivo.
             * @return Devuelve las postcondiciones a las que se llega luego de completar el objetivo.
             */
/*153*/     public String getPostCondiciones() {
/*154*/         return postCondiciones;
/*155*/     }
/*156*/ 
/*157*/     /**
             *Método que asigna las postcondiciones a las que se arriba luego de completar un objetivo.
             * @param postCondiciones Nuevas postcondiciones a las que se arriba luego de completar objetivo.
             */
/*161*/     public void setPostCondiciones(String postCondiciones) {
/*162*/         this.postCondiciones = postCondiciones;
/*163*/     }
/*164*/ 
/*165*/     /**
             *Método que obtiene la condición que se debe conseguir para lograr que un objetivo se cumpla.
             * @return Devuelve la condición que se debe seguir para lograr que el objetivo se cumpla.
             */
/*169*/     public String getPreCondiciones() {
/*170*/         return preCondiciones;
/*171*/     }
/*172*/ 
/*173*/     /**
             *Método que asigna la condición que se debe seguir para lograr que un objetivo se cumpla.
             * @param preCondiciones Nuevas condiciones que se deben seguir para lograr que el objetivo se cumpla.
             */
/*177*/     public void setPreCondiciones(String preCondiciones) {
/*178*/         this.preCondiciones = preCondiciones;
/*179*/     }
/*180*/ 
/*181*/     /**
             *Método que obtiene las limitantes bajo las cuales un objetivo debe cumplirse.
             * @return Devuelve las limitantes bajo las cuales un objetivo debe cumplirse.
             */
/*185*/     public String getRestricciones() {
/*186*/         return restricciones;
/*187*/     }
/*188*/ 
/*189*/     /**
             *Método que asigna las limitantes bajo las cuales un objetivo debe cumplirse.
             * @param restricciones Nuevas restricciones para las cuales un objetivo debe cumplirse.
             */
/*193*/     public void setRestricciones(String restricciones) {
/*194*/         this.restricciones = restricciones;
/*195*/     }
/*196*/ 
/*197*/     /**
             *Método que obtiene los objetivos menores que un se deben dar dentro de un objetivo mayor, mapeando siempre una o más acciones.
             * @return Devuelve los subobjetivos que se deben realizar dentro del objetivo mayor.
             */
/*201*/     public String getSubObjetivos() {
/*202*/         return subObjetivos;
/*203*/     }
/*204*/ 
/*205*/     /**
             *Método que asigna los subobjetivos que mapean a una o más acciones.
             * @param subObjetivos Nuevos subobjetivos que mapean a una acción.
             */
/*209*/     public void setSubObjetivos(String subObjetivos) {
/*210*/         this.subObjetivos = subObjetivos;
/*211*/     }
/*212*/ 
/*213*/     
/*214*/ 
/*215*/ }
