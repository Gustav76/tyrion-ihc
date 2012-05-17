/*1*/ package proyectodetitulo;
/*2*/ 
/*3*/ import org.jdesktop.application.Application;
/*4*/ import org.jdesktop.application.SingleFrameApplication;
/*5*/ 
      /**
       * The main class of the application.
       */
       /**
        *
        * @author
        */
/*13*/ public class ProyectoDeTituloApp extends SingleFrameApplication {
/*14*/ 
           /**
            * At startup create and show the main frame of the application.
            */
           /**
            *
            */
/*21*/     @Override protected void startup() {
/*22*/         show(new ProyectoDeTituloView(this));
/*23*/     }
/*24*/ 
/*25*/     /**
            *
            * @param root
            */
/*29*/     @Override protected void configureWindow(java.awt.Window root) {
/*30*/     }
/*31*/ 
/*32*/     /**
            * A convenient static getter for the application instance.
            * @return the instance of ProyectoDeTituloApp
            */
           /**
            *
            * @return
            */
/*40*/     public static ProyectoDeTituloApp getApplication() {
/*41*/         return Application.getInstance(ProyectoDeTituloApp.class);
/*42*/     }
/*43*/ 
           /**
            * Main method launching the application.
            */
           /**
            *
            * @param args
            */
/*51*/     public static void main(String[] args) {
/*52*/         launch(ProyectoDeTituloApp.class, args);
/*53*/     }
/*54*/ }
