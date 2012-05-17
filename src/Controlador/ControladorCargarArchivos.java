/*1*/ package Controlador;
/*2*/ import Controlador.*;
/*3*/ import Modelo.ModeloCasoDeUso;
/*4*/ import Modelo.ModeloMapaConversacional;
/*5*/ import Modelo.ModeloObjetivosDelNegocio;
/*6*/ import Modelo.ModeloSesion;
/*7*/ import Vista.JPCargarArchivos;
/*8*/ import java.awt.CardLayout;
/*9*/ import java.io.FileReader;
/*10*/ import java.io.IOException;
/*11*/ import java.io.Reader;
/*12*/ import javax.xml.parsers.ParserConfigurationException;
/*13*/ import javax.xml.parsers.SAXParser;
/*14*/ import javax.xml.parsers.SAXParserFactory;
/*15*/ import org.xml.sax.InputSource;
/*16*/ import org.xml.sax.SAXException;
/*17*/ import org.xml.sax.SAXParseException;
/*18*/ import org.xml.sax.helpers.DefaultHandler;
/*19*/ 
/*20*/ /** 
        * Clase controlador para realizar la carga de los archivos
        * Maneja las vistas para cargar la ayuda de los archivos.
        * Opera con los modelos de objetivos de negocio, mapa conversacional, sesión y casos de uso
        * @author Alejandra Romero
        */
/*26*/ public class ControladorCargarArchivos {
/*27*/     
/*28*/     private static JPCargarArchivos vista;
/*29*/     
/*30*/     public ControladorPrincipal control;
/*31*/     public ModeloObjetivosDelNegocio modeloON;
/*32*/     public ModeloMapaConversacional modeloMC;
/*33*/     public ModeloSesion sa;
/*34*/     public ModeloCasoDeUso modeloCU;
/*35*/     final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
/*36*/     final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
/*37*/     final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
/*38*/     final String MY_SCHEMA = "validarMapaConversacional.xsd";
/*39*/        public boolean valido = false;
/*40*/ 
/*41*/     /**
            * Constructor de la clase ControladorCargarArchivos. Recibe como parámetro una instancia del controlador principal
            * @param controlM controlador principal correspondiente
            */
/*45*/     public ControladorCargarArchivos(ControladorPrincipal controlM) {
    
/*47*/         this.control = controlM;
/*48*/         vista = new JPCargarArchivos(this);
/*49*/         //vista.setVisible(true);
               

/*52*/     }
/*53*/ 
/*54*/     //paso a la vista cargar archivos
/*55*/     /**
            * Método encargado de mostrar la vista cargar archivos
            */
/*58*/     public void irVistaCargarArchivos() {
/*59*/         ControladorCargarArchivos.vista.setVisible(true);
/*60*/     }
/*61*/ 
/*62*/     //Carga los modelos de mapa conversacional y objetivos del negocio (XML)
/*63*/     /**
            * Método cargarArchivosXML: recibe como parámetros un modelo conversacional y un modelo de objetos de negocio
            * @param MC: dirección del archivo XML del mapa conversacional
            * @param ON: dirección del archivo XML del modelo de objetivo del negocio
            * @return String que representa el resultado de la lectura, un valor distinto de null representa que la operación tuvo éxito
            * @throws ParserConfigurationException
            */
/*70*/     public String cargarArchivosXML(String MC, String ON) throws ParserConfigurationException {
/*71*/         modeloMC = new ModeloMapaConversacional();
/*72*/         modeloON = new ModeloObjetivosDelNegocio();
/*73*/         modeloCU = new ModeloCasoDeUso();
/*74*/         String resp1 = this.modeloMC.lecturaXMLMC(MC);
/*75*/         String resp2 = this.modeloON.lecturaXMLON(ON);
/*76*/         if (resp1 != null) {
/*77*/             if (resp2 != null) {
/*78*/                 return resp1 + ". " + resp2;
/*79*/             } else {
/*80*/                 return resp1;
/*78*/             }
/*79*/         } else {
/*80*/             if (resp2 != null) {
/*81*/                 return resp2;
/*82*/             }
/*83*/         }
/*84*/         return null;
/*85*/     }
/*86*/ 
/*87*/     //Paso al siguiente controlador correpondiente a identificar caso de uso paso 1
/*88*/     /**
            * Método que cambia la vista del menú Cargar archivos al menú identificar los casos de uso
            */
/*91*/     public void irControladorIdentificarCU1() {
/*92*/         this.control.irControladorIdentificarCU1(modeloMC, modeloON, modeloCU);
/*93*/         this.vista.setVisible(false);
/*94*/     }
           public void activarVista() {
            ((CardLayout)control.getVista().getPanel().getLayout()).show(control.getVista().getPanel(),"VCargarArchivo");
            }
            public JPCargarArchivos getVista() {
                return vista;
            }           
/*95*/ 
/*96*/     //Función para validar la estructura del archivo de modelo mapa conversacional (XML) comparando con el xsd
/*97*/     /**
            * Método que valida la estructura del archivo del modelo de mapa conversacional comparándolo con el archivo de esquema XSD 
            * @param ruta: ruta del archivo a comparar
            * @return: null en caso de éxito. En caso de error entrega la excepción que gatilló la falla
            */
/*102*/     public String validarMapaConversacionelXML(String ruta) {
/*103*/         String YES = "yes";
/*104*/         String NO = "no";
/*105*/         String CHAR_ENCODING = "UTF8";
/*106*/         boolean NAME_SPACE_AWARE = true;
/*107*/         boolean VALIDATING = true;
/*108*/         String SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
/*109*/         String SCHEMA_LANGUAGE_VAL = "http://www.w3.org/2001/XMLSchema";
/*110*/         String SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
/*111*/ 
/*112*/         Reader xmlReader;
/*113*/         Reader xsdReader;
/*114*/         try {
/*115*/             xmlReader = new FileReader(ruta);
/*116*/             xsdReader = new FileReader("./ArchivosXSD/validarMapaConversacional.xsd");
/*117*/             SAXParserFactory factory = SAXParserFactory.newInstance();
/*118*/ 
/*119*/             // Configure SAXParserFactory to provide parsers that are namespace aware.
/*120*/             factory.setNamespaceAware(NAME_SPACE_AWARE);
/*121*/             // Configure SAXParserFactory to provide parsers that are validating. This property
/*122*/             // must have the value true for any of the property strings defined below to take
/*123*/             // effect.
/*124*/             factory.setValidating(VALIDATING);
/*125*/ 
/*126*/             SAXParser parser = factory.newSAXParser();
/*127*/             // Setting the schema language for xml schema validation
/*128*/             parser.setProperty(SCHEMA_LANGUAGE, SCHEMA_LANGUAGE_VAL);
/*129*/             // Setting the schema source for xml schema validation
/*130*/             parser.setProperty(SCHEMA_SOURCE, new InputSource(xsdReader));
/*131*/             DefaultHandler handler = new XmlDefaultHandler();
/*132*/             parser.parse(new InputSource(xmlReader), handler);
/*133*/             return null;
/*134*/         } catch (IOException ex) {
/*135*/             return ex.toString();
/*136*/             //Logger.getLogger(ControladorCargarArchivos.class.getName()).log(Level.SEVERE, null, ex);
/*137*/         } catch (ParserConfigurationException ex) {
/*138*/             return ex.toString();
/*139*/             //Logger.getLogger(ControladorCargarArchivos.class.getName()).log(Level.SEVERE, null, ex);
/*140*/         } catch (SAXException ex) {
/*141*/             return ex.toString();
/*142*/             //Logger.getLogger(ControladorCargarArchivos.class.getName()).log(Level.SEVERE, null, ex);
/*143*/         }
/*144*/     }
/*145*/ 
/*146*/     //Función para validar la estructura del archivo de modelo de objetivos del negocio (XML) comparando con el xsd
/*147*/     /**
             * Método que valida la estructura del archivo del modelo de objetivos del negocio, comparándolo con el archivo de esquema XSD
             * @param ruta: ruta del archivo a comparar
             * @return: null en caso de éxito. En caso de error, retorna el nombre de la excepción que gatilló la falla
             */
/*152*/     public String validarObjetivosDelNegocioXML(String ruta) {
/*153*/         String YES = "yes";
/*154*/         String NO = "no";
/*155*/         String CHAR_ENCODING = "UTF8";
/*156*/         boolean NAME_SPACE_AWARE = true;
/*157*/         boolean VALIDATING = true;
/*158*/         String SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
/*159*/         String SCHEMA_LANGUAGE_VAL = "http://www.w3.org/2001/XMLSchema";
/*160*/         String SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
/*161*/ 
/*162*/         Reader xmlReader;
/*163*/         Reader xsdReader;
/*164*/         try {
/*165*/             xmlReader = new FileReader(ruta);
/*166*/             //xsdReader = new FileReader(getClass().getResource("validarObjDelNegocio.xsd").getFile());
/*167*/             xsdReader = new FileReader("./ArchivosXSD/validarObjDelNegocio.xsd");
/*168*/             SAXParserFactory factory = SAXParserFactory.newInstance();
/*169*/ 
/*170*/             // Configure SAXParserFactory to provide parsers that are namespace aware.
/*171*/             factory.setNamespaceAware(NAME_SPACE_AWARE);
/*172*/             // Configure SAXParserFactory to provide parsers that are validating. This property
/*173*/             // must have the value true for any of the property strings defined below to take
/*174*/             // effect.
/*175*/             factory.setValidating(VALIDATING);
/*176*/ 
/*177*/             SAXParser parser = factory.newSAXParser();
/*178*/             // Setting the schema language for xml schema validation
/*179*/             parser.setProperty(SCHEMA_LANGUAGE, SCHEMA_LANGUAGE_VAL);
/*180*/             // Setting the schema source for xml schema validation
/*181*/             parser.setProperty(SCHEMA_SOURCE, new InputSource(xsdReader));
/*182*/             DefaultHandler handler = new XmlDefaultHandler();
/*183*/             parser.parse(new InputSource(xmlReader), handler);
/*184*/             return null;
/*185*/ 
/*186*/         } catch (IOException ex) {
/*187*/             return ex.toString();
/*188*/             //Logger.getLogger(ControladorCargarArchivos.class.getName()).log(Level.SEVERE, null, ex);
/*189*/         } catch (ParserConfigurationException ex) {
/*190*/             return ex.toString();
/*191*/             //Logger.getLogger(ControladorCargarArchivos.class.getName()).log(Level.SEVERE, null, ex);
/*192*/         } catch (SAXException ex) {
/*193*/             return ex.toString();
/*194*/             //Logger.getLogger(ControladorCargarArchivos.class.getName()).log(Level.SEVERE, null, ex);
/*195*/         }
/*196*/     }
/*197*/ 
/*198*/     //Función para validar la estructura del archivo de la sesion anterior (XML) comparando con el xsd
/*199*/     /**
             * Método que valida la estructura del archivo de sesión anterior comparándolo con el archivo de esquema XSL para las sesiones
             * @param ruta
             * @return null en caso de éxito. En caso de error, el nombre de la excepción que gatilló dicho error.
             */
/*204*/     public String validarSesionXML(String ruta) {
                System.out.println("HOLA a todos");
/*205*/         String YES = "yes";
/*206*/         String NO = "no";
/*207*/         String CHAR_ENCODING = "UTF8";
/*208*/         boolean NAME_SPACE_AWARE = true;
/*209*/         boolean VALIDATING = true;
/*210*/         String SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
/*211*/         String SCHEMA_LANGUAGE_VAL = "http://www.w3.org/2001/XMLSchema";
/*212*/         String SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
/*213*/        
/*214*/         Reader xmlReader;
/*215*/         Reader xsdReader;
/*216*/         try {
/*217*/             xmlReader = new FileReader(ruta);
/*218*/             xsdReader = new FileReader("./ArchivosXSD/validarSesion.xsd");
/*219*/             SAXParserFactory factory = SAXParserFactory.newInstance();
/*220*/ 
/*221*/             // Configure SAXParserFactory to provide parsers that are namespace aware.
/*222*/             factory.setNamespaceAware(NAME_SPACE_AWARE);
/*223*/             // Configure SAXParserFactory to provide parsers that are validating. This property
/*224*/             // must have the value true for any of the property strings defined below to take
/*225*/             // effect.
/*226*/             factory.setValidating(VALIDATING);
/*227*/ 
/*228*/             SAXParser parser = factory.newSAXParser();
/*229*/             // Setting the schema language for xml schema validation
/*230*/             parser.setProperty(SCHEMA_LANGUAGE, SCHEMA_LANGUAGE_VAL);
/*231*/             // Setting the schema source for xml schema validation
/*232*/             parser.setProperty(SCHEMA_SOURCE, new InputSource(xsdReader));
/*233*/             DefaultHandler handler = new XmlDefaultHandler();
/*234*/             parser.parse(new InputSource(xmlReader), handler);
/*235*/             return null;
/*236*/         } catch (IOException ex) {
/*237*/             return ex.toString();
/*238*/             //Logger.getLogger(ControladorCargarArchivos.class.getName()).log(Level.SEVERE, null, ex);
/*239*/         } catch (ParserConfigurationException ex) {
/*240*/             return ex.toString();
/*241*/             //Logger.getLogger(ControladorCargarArchivos.class.getName()).log(Level.SEVERE, null, ex);
/*242*/         } catch (SAXException ex) {
/*243*/             return ex.toString();
/*244*/             //Logger.getLogger(ControladorCargarArchivos.class.getName()).log(Level.SEVERE, null, ex);
/*245*/         }
/*246*/     }

/*247*/ 
/*248*/     /**
             * Definición de la clase XmlDefaultHandler, que manipula los errores y excepciones dentro del controlador
             */
/*251*/     class XmlDefaultHandler extends DefaultHandler {
/*252*/ 
/*253*/         /**
                 * Método error, encapsula los errores de parsing o warnings en XML
                 * @param spe: excepción arrojada
                 * @throws SAXException
                 */
/*258*/         @Override
/*259*/         public void error(SAXParseException spe) throws SAXException {
/*260*/             throw spe;
/*261*/         }
/*262*/ 
/*263*/         /**
                 * Método fatalError, encapsula los errores fatales de parsing
                 * @param spe: nombre de la excepción del error encontrado
                 * @throws SAXException
                 */
/*268*/         @Override
/*269*/         public void fatalError(SAXParseException spe) throws SAXException {
/*270*/             throw spe;
/*271*/         }
/*272*/     }
/*273*/ 
/*274*/     //Ir a la vista de ayuda de cargar archivos
/*275*/     /**
             *  Método que muestra la vista de ayuda al usuario
             */
/*288*/ 
/*289*/     //Carga de los modelos y datos de una sesión guardada
/*290*/     /**
             * Método que carga los datos de una sesión previamente guardada
             * @param ruta: ruta del archivo de sesión previa
             * @return resp1: resultado de la carga. En caso de error responde "Error en la carga"
             * @throws ParserConfigurationException
             */
/*296*/     public String cargarSesionAnterior(String ruta) throws ParserConfigurationException {
/*297*/         modeloMC = new ModeloMapaConversacional();
/*298*/         modeloON = new ModeloObjetivosDelNegocio();
/*299*/         modeloCU = new ModeloCasoDeUso();
/*300*/         sa = new ModeloSesion(modeloMC, modeloON, modeloCU);
/*301*/         String resp1 = sa.lecturaSAXML(ruta);
/*302*/ 
/*303*/         return resp1;
/*304*/     }
/*305*/ 
/*306*/     //Para ir a controlador que corresponda de la sesión guardada
/*307*/     /**
             * Método que muestra los datos de una sesión anterior
             */
/*310*/     public void irControladorSesion() {
/*311*/         this.control.irSesionAnterior(modeloMC, modeloON, modeloCU, sa.getVentana());
                System.out.println("valgo: "+ sa.getVentana());
/*312*/         //this.vista.setVisible(false);
/*313*/     }
/*314*/ 
/*315*/     //
/*316*/     /**
             * Método que verifica que las pertenencias tengan un id existente
             * @return el resultado de ModeloMapaConversacional.verificarPertenencias()
             */
/*320*/     public int verificarPertenencias() {
/*321*/         return this.modeloMC.verificarPertenencias();
/*322*/     }
/*323*/ 
/*324*/     //para verificar que las excepciones tengan un id existente
/*325*/     /**
             * Método que verifica que las excepciones tengan un id existente
             * @return el resultado de ModeloMapaConversacional.verificarExcepciones()
             */
/*329*/     public int verificarExcepciones() {
/*330*/         return this.modeloMC.verificarExcepciones();
/*331*/     }

            public void Alerta(String mensaje)
            {
                vista.alerta(mensaje);
            }
            
            
            

/*332*/

    public ModeloSesion getSa() {
        return sa;
    }

    public void setSa(ModeloSesion sa) {
        this.sa = sa;
    }
 }
