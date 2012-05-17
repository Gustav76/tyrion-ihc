/*1*/ package DTO;
/*2*/ 
/*3*/ import java.util.Vector;
/*4*/ 
/*5*/ /**
       * Clase que representa los objetivos del negocio. Que es el modelo de objetivos de entrada al sistema.
       * @author Sebastian.
       */
/*9*/ public class ObjWorkDTO {
/*10*/ 
/*11*/     ObjetivoDTO Obj;
/*12*/     Vector workflow;
/*13*/ 
/*14*/     /**
            * Constructor para los objetivos del negocio, no recibe ni retorna parámetros.
            */
/*17*/     public ObjWorkDTO() {
/*18*/     }
/*19*/ 
/*20*/     /**
            * Constructor para los objetivos del negocio. Necesita el workflow y los objetivos de alto nivel del sistema.
            * @param Obj Son los objetivos de alto nivel que representa las metas a cumplir del sistema.
            * @param workflow Es el workflow.
            */
/*25*/     public ObjWorkDTO(ObjetivoDTO Obj, Vector workflow) {
/*26*/         this.Obj = Obj;
/*27*/         this.workflow = workflow;
/*28*/     }
/*29*/ 
/*30*/     /**
            * Función para obtener los objetivos de alto nivel.
            * @return Obj Son los objetivos de alto nivel que representa las metas a cumplir del sistema.
            */
/*34*/     public ObjetivoDTO getObj() {
/*35*/         return Obj;
/*36*/     }
/*37*/ 
/*38*/     /**
            * Función para asignar los objetivos de alto nivel.
            * @param Obj Son los objetivos de alto nivel que representa las metas a cumplir del sistema.
            */
/*42*/     public void setObj(ObjetivoDTO Obj) {
/*43*/         this.Obj = Obj;
/*44*/     }
/*45*/ 
/*46*/     /**
            * Función para obtener un Workflow.
            * @return workflow Es el Workflow.
            */
/*50*/     public Vector getWorkflow() {
/*51*/         return workflow;
/*52*/     }
/*53*/ 
/*54*/     /**
            * Función para asignar un Workflow.
            * @param workflow Es el Workflow.
            */
/*58*/     public void setWorkflow(Vector workflow) {
/*59*/         this.workflow = workflow;
/*60*/     }
/*61*/ }
