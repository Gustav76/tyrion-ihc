/*1*/ package Modelo;
/*2*/ 
/*3*/ import org.w3c.dom.Element;
/*4*/ import org.w3c.dom.Document;
/*5*/ import DTO.CasoDeUsoDTO;
/*6*/ import com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl;
/*7*/ import com.sun.org.apache.xml.internal.serialize.OutputFormat;
/*8*/ import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
/*9*/ import java.io.BufferedOutputStream;
/*10*/ import java.io.File;
/*11*/ import java.io.FileOutputStream;
/*12*/ import java.io.IOException;
/*13*/ import java.io.OutputStream;
/*14*/ import java.io.OutputStreamWriter;
/*15*/ import java.io.StringWriter;
/*16*/ import java.io.UnsupportedEncodingException;
/*17*/ import java.util.Vector;
/*18*/ import javax.xml.parsers.DocumentBuilder;
/*19*/ import javax.xml.parsers.DocumentBuilderFactory;
/*20*/ import javax.xml.parsers.ParserConfigurationException;
/*21*/ import org.w3c.dom.NodeList;
/*22*/ import org.xml.sax.SAXException;
/*23*/ 
/*24*/ /**
        *
        * 
        * Clase que representa los casos de uso.
        * Posee funciones para agregar y modificar los casos de uso, además de las 
        * funciones necesarias para generar y guardar el documento que contendrá a éstos. 
        */    

/*28*/ public class ModeloCasoDeUso {
/*29*/     //Vector casosDeUso;
/*30*/ 
/*31*/     static Document document;
/*32*/     Vector nombreCasoUso = null;
/*33*/     Vector resumenCasoUso = null;
/*34*/     Vector postCondicionesCasoUso = null;
/*35*/     Vector preCondiciones = null;
/*36*/     Vector excepciones = null;
/*37*/     Vector descripcion = null;
/*38*/     Vector descripcionGenerada = new Vector();
/*39*/     Vector actores = null;
/*40*/     Vector nombreCuD1 = null;
/*41*/     CasoDeUsoDTO cu;
/*42*/     Vector casoDeUso = null;
/*43*/     private Document documentoXML = null;
/*44*/     private Element casosUso = null;
/*45*/     private static final String TAG_CUS = "CasosDeUso";
/*46*/     private static final String TAG_CU = "casoDeUso";
/*47*/     private static final String TAG_NOMBRE = "nombre";
/*48*/     private static final String TAG_VERSION = "version";
/*49*/     private static final String TAG_RESUMEN = "resumen";
/*50*/     private static final String TAG_PRECONDICIONES = "precondiciones";
/*51*/     private static final String TAG_DESCRIPCION = "descripcion";
/*52*/     private static final String TAG_EXCEPCIONES = "excepciones";
/*53*/     private static final String TAG_POSTCONDICIONES = "postcondiciones";
/*54*/     private static final String TAG_ACTOR = "actores";
/*55*/     private static final String TAG_ID = "id";
/*56*/     private static final String TAG_ETIQUETA = "etiqueta";
/*57*/     // Codificacion
/*58*/     private static final String XML_VERSION = "1.0";
/*59*/     private static final String XML_ENCODING = "ISO-8859-1";
/*60*/     private static final String JAVA_ENCODING = "8859_1";
/*61*/     // Nombre del archivo
/*62*/     private static final String NOMBRE_ARCHIVO_XML = "descargas.xml";
/*63*/ 
/*64*/    /**
           * Constructor vacío de ModeloCasoDeUso 
           */
/*67*/     public ModeloCasoDeUso() {
/*68*/     }
/*69*/ 
/*70*/     /**
            * Método que obtiene el vector nombreCuD1 de alguna instancia de la clase ModeloCasoDeUso.
            * 
            * @return nombreCuD1
            */
/*74*/     public Vector getNombreCuD1() {
/*75*/         return nombreCuD1;
/*76*/     }
/*77*/ 
/*78*/     /**
            * Método que setea el vector nombreCuD1 en alguna instancia de la clase ModeloCasoDeUso 
            * según el vector parámetro.
            * @param nombreCuD1
            */
/*82*/     public void setNombreCuD1(Vector nombreCuD1) {
/*83*/         this.nombreCuD1 = nombreCuD1;
/*84*/     }
/*85*/ 
/*86*/     /**
            * Método que obtiene el vector nombreCasoUso de alguna instancia de la clase ModeloCasoDeUso.
            * @return nombreCasoUso.
            */
/*90*/     public Vector getNombreCasoUso() {
/*91*/         return nombreCasoUso;
/*92*/     }
/*93*/ 
/*94*/     /**
            * Método que setea el vector nombreCasoUso en alguna instancia de la clase ModeloCasoDeUso 
            * según el vector parámetro.
            * @param nombreCasoUso Vector con datos para setear nombreCasoUso.
            */
/*98*/     public void setNombreCasoUso(Vector nombreCasoUso) {
/*99*/         this.nombreCasoUso = nombreCasoUso;
/*100*/     }
/*101*/ 
/*102*/     /**
             * Método que obtiene el vector resumenCadoUso de alguna instancia de la clase ModeloCasoDeUso.
             * @return Vector resumen caso de uso.
             */
/*106*/     public Vector getResumenCasoUso() {
/*107*/         return resumenCasoUso;
/*108*/     }
/*109*/ 
/*110*/     /**
             * Método que setea el vector resumenCasoUso en alguna instancia de la clase ModeloCasoDeUso 
             * según el vector parámetro.
             * @param resumenCasoUso ,vector que contiene datos para setear resumenCasoUso.
             */
/*114*/     public void setResumenCasoUso(Vector resumenCasoUso) {
/*115*/         this.resumenCasoUso = resumenCasoUso;
/*116*/     }
/*117*/ 
/*118*/     /**
             * Método que obtiene el vector postCondicionesCasoUso de alguna instancia de la clase ModeloCasoDeUso.
             * @return vector PosCondiciones del caso de uso.
             */
/*122*/     public Vector getPostCondicionesCasoUso() {
/*123*/         return postCondicionesCasoUso;
/*124*/     }
/*125*/ 
/*126*/     /**
             * Método que setea el vector postCondicionesCasoUso en alguna instancia de la clase ModeloCasoDeUso 
             * según el vector parámetro.
             * @param postCondicionesCasoUso  PostCondiciones del caso de uso.
             */
/*130*/     public void setPostCondicionesCasoUso(Vector postCondicionesCasoUso) {
/*131*/         this.postCondicionesCasoUso = postCondicionesCasoUso;
/*132*/     }
/*133*/ 
/*134*/     /**
             * Método que obtiene el vector preCondiciones de alguna instancia de la clase ModeloCasoDeUso.
             * @return Vector Precondicones del caso de uso.
       /      */
/*138*/     public Vector getPreCondiciones() {
/*139*/         return preCondiciones;
/*140*/     }
/*141*/ 
/*142*/     /**
             * Método que setea el vector preCondiciones en alguna instancia de la clase ModeloCasoDeUso 
             * según el vector parámetro.
             * @param preCondiciones Vector PreCondiciones del caso de uso.
             */
/*146*/     public void setPreCondiciones(Vector preCondiciones) {
/*147*/         this.preCondiciones = preCondiciones;
/*148*/     }
/*149*/ 
/*150*/     /**
             * Método que obtiene el vector excepciones de alguna instancia de la clase ModeloCasoDeUso.
             * @return Vector excepciones del caso de uso.
             */
/*154*/     public Vector getExcepciones() {
/*155*/         return excepciones;
/*156*/     }
/*157*/ 
/*158*/     /**
             * Método que setea el vector excepciones en alguna instancia de la clase ModeloCasoDeUso 
             * según el vector parámetro.
             * @param excepciones Vector excepciones del caso de uso.
             */
/*162*/     public void setExcepciones(Vector excepciones) {
/*163*/         this.excepciones = excepciones;
/*164*/     }
/*165*/ 
/*166*/     /**
             * Método que obtiene el vector descripcion de alguna instancia de la clase ModeloCasoDeUso.
             * @return Vector con la descripcion del caso de uso.
             */
/*170*/     public Vector getDescripcion() {
/*171*/         return descripcion;
/*172*/     }
/*173*/ 
/*174*/     /**
             * Método que setea el vector descripcion en alguna instancia de la clase ModeloCasoDeUso 
             * según el vector parámetro.
             * @param descripcion Vector descripcion del caso de uso.
             */
/*178*/     public void setDescripcion(Vector descripcion) {
/*179*/         this.descripcion = descripcion;
/*180*/     }
/*181*/ 
/*182*/     /**
             * Método que obtiene el vector actores de alguna instancia de la clase ModeloCasoDeUso.
             * @return Vector con actores del caso de uso.
             */
/*186*/     public Vector getActores() {
/*187*/         return actores;
/*188*/     }
/*189*/ 
/*190*/     /**
             * Método que setea el vector actores en alguna instancia de la clase ModeloCasoDeUso 
             * según el vector parámetro.
             * @param actores Vector con actoes del caso de uso.
             */
/*194*/     public void setActores(Vector actores) {
/*195*/         this.actores = actores;
/*196*/     }
/*197*/ 
/*198*/     /**
             * Método que setea los casos de uso iniciales en el vector casoDeUso desde una instancia de la clase ModeloCasoDeUso.
             * Se inicializa la variable casoDeUso y mediante un ciclo for, se agregan
             * los valores de los casos de uso iniciales.
             * 
             */
/*201*/     public void setCasosDeUsoInicial() {
/*202*/         //Vector vCasosDeUso=new Vector();
/*203*/         //casoDeUso.removeAllElements();
/*204*/         casoDeUso = new Vector();
/*205*/         for (int i = 0; i < this.nombreCasoUso.size(); i++) {
/*206*/             CasoDeUsoDTO CU = new CasoDeUsoDTO();
/*207*/             CU.setNombre(this.nombreCasoUso.get(i).toString());
/*208*/             //System.out.println(this.nombreCasoUso.size());
/*209*/             CU.setVersion(1.0);
/*210*/             CU.setResumen(this.resumenCasoUso.get(i).toString());
/*211*/             //System.out.println(this.resumenCasoUso.size());
/*212*/             CU.setActores((Vector) this.actores.get(i));
/*213*/             //System.out.println(this.actores.size());
/*214*/             CU.setPrecondiciones(this.preCondiciones.get(i).toString());
/*215*/             //System.out.println(this.preCondiciones.size());
/*216*/             CU.setDescripcion(this.descripcion.get(i).toString());
/*217*/             //System.out.println(this.descripcion.size());
/*218*/             CU.setExcepciones(this.excepciones.get(i).toString());
/*219*/             //System.out.println(this.excepciones.size());
/*220*/             CU.setPostcondiciones(this.postCondicionesCasoUso.get(i).toString());
/*221*/             //System.out.println(this.postCondicionesCasoUso.size());
/*222*/ 
/*223*/             casoDeUso.add(CU);
/*224*/         }
/*225*/     }
/*226*/ 
/*227*/     /**
             * Método que setea los casos de uso en el vector casoDeUso2 luego lo retorna.
             * Se inicializa la variable casoDeUso2 y mediante un ciclo for, se agregan
             * los valores de los casos de uso contenidos en alguna instancia de la clase ModeloCasoDeUso
             * y luego se retorna.
             * @return Vector con los casos de uso.
             */
/*231*/     public Vector casosUsoMod() {
/*232*/         Vector casoDeUso2 = new Vector();
/*233*/         for (int i = 0; i < this.nombreCasoUso.size(); i++) {
/*234*/             CasoDeUsoDTO CU = new CasoDeUsoDTO();
/*235*/             CU.setNombre(this.nombreCasoUso.get(i).toString());
/*236*/             //System.out.println(this.nombreCasoUso.size());
/*237*/             CU.setVersion(1.0);
/*238*/             CU.setResumen(this.resumenCasoUso.get(i).toString());
/*239*/             //System.out.println(this.resumenCasoUso.size());
/*240*/             CU.setActores((Vector) this.actores.get(i));
/*241*/             //System.out.println(this.actores.size());
/*242*/             CU.setPrecondiciones(this.preCondiciones.get(i).toString());
/*243*/             //System.out.println(this.preCondiciones.size());
/*244*/             CU.setDescripcion(this.descripcion.get(i).toString());
/*245*/             //System.out.println(this.descripcion.size());
/*246*/             CU.setExcepciones(this.excepciones.get(i).toString());
/*247*/             //System.out.println(this.excepciones.size());
/*248*/             CU.setPostcondiciones(this.postCondicionesCasoUso.get(i).toString());
/*249*/             //System.out.println(this.postCondicionesCasoUso.size());
/*250*/ 
/*251*/             casoDeUso2.add(CU);
/*252*/         }
/*253*/         return casoDeUso2;
/*254*/     }
/*255*/ 
/*256*/     /**
             * Método que obtiene el vector cadoDeUso de alguna instancia de la clase ModeloCasoDeUso.
             * @return Vector conn los casos de uso.
             */
/*260*/     public Vector getCasosDeUso() {
/*261*/         return casoDeUso;
/*262*/     }
/*263*/ 
/*264*/     /**
             * Método que setea casoDeUso con los datos y la posicion ingresada como parametros.
             * @param cu Vector con datos del caso de uso.
             * @param pos Entero con la posicion del ingreso del caso de uso.
             */
/*269*/     public void setCasoDeUso(Vector cu, int pos) {
/*270*/         CasoDeUsoDTO casoUso = new CasoDeUsoDTO();
/*271*/         casoUso.setNombre(cu.get(0).toString());
/*272*/         casoUso.setVersion(Double.parseDouble(cu.get(1).toString()));
/*273*/         casoUso.setResumen(cu.get(2).toString());
/*274*/         casoUso.setActores((Vector) cu.get(3));
/*275*/         casoUso.setPrecondiciones(cu.get(4).toString());
/*276*/         casoUso.setDescripcion(cu.get(5).toString());
/*277*/         casoUso.setExcepciones(cu.get(6).toString());
/*278*/         casoUso.setPostcondiciones(cu.get(7).toString());
/*279*/         casoDeUso.set(pos, casoUso);
/*280*/         guardarDescripcion(pos, cu.get(5).toString());
/*281*/ 
/*282*/     }
/*283*/ 
/*284*/     /**
             * Método que guarda la descripción de un caso de uso en una posicion determinada.
             * @param pos Entero con la posicion del ingreso.
             * @param desc String con la descripción.
            */
/*289*/     public void guardarDescripcion(int pos, String desc) {
/*290*/         descripcion.set(pos, desc);
/*291*/         //System.out.println("descripcion mod: "+descripcion);
/*292*/         //System.out.println("descripcion ge: "+descripcionGenerada);
/*293*/     }
/*294*/ 
/*295*/     /**
             * Método que genera y guarda el archivo XML de los casos de uso segun la entrada ingresada.
             * Se ingresa como parámetro el nombre con el cual el archivo será guardado.
             * @param entrada String con el nombre del archivo a guardar.
             */
/*299*/     public void generarXML(String entrada) {
/*300*/         this.generaDocumentoXML();
/*301*/         for (int i = 0; i < casoDeUso.size(); i++) {
/*302*/             CasoDeUsoDTO cUso = (CasoDeUsoDTO) casoDeUso.get(i);
/*303*/             this.generarDocumentoXMLCasoUso(cUso, i);
/*304*/         }
/*305*/         String textoXML = obtenerTextoXML();
/*306*/         guardarDocumentoXML(textoXML, entrada);
/*307*/     }
/*308*/ 
/*309*/     /**
             *Se crea un nuevo elemento casosUso y se agrega a documentoXML.
             */
/*312*/     public void generaDocumentoXML() {
/*313*/         try {
/*314*/             // 1. Crear objeto DocumentBuilderFactory
/*315*/             DocumentBuilderFactory dbFactory = DocumentBuilderFactoryImpl.newInstance();
/*316*/             // 2. A partir del objeto DocumentBuilderFactory crear un objeto DocumentBuilder
/*317*/             DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
/*318*/             // 3. Generar el documento XML
/*319*/             documentoXML = docBuilder.newDocument();
/*320*/         } catch (Exception e) {
/*321*/             System.out.println("Error : " + e);
/*322*/         }
/*323*/         // 4. Crear el elemento "casos de uso"
/*324*/         casosUso = documentoXML.createElement(TAG_CUS);
/*325*/         // 5. Agregar al documento principal
/*326*/         documentoXML.appendChild(casosUso);
/*327*/     }
/*328*/ 
/*329*/     /**
             * Agrega los datos de CasoDeUsoDTO y los ingresa en el elemento casosUso
             * @param cu CasoDeUsoDTO que contiene los datos de un determnado caso de uso
             * @param pos Entero que representa el id del caso de uso
            */
/*334*/     public void generarDocumentoXMLCasoUso(CasoDeUsoDTO cu, int pos) {
/*335*/         Element elemento;
/*336*/         Element item, item1;
/*337*/         elemento = documentoXML.createElement(TAG_CU);
/*338*/         elemento.setAttribute(TAG_ID, "" + pos);
/*339*/         elemento.setAttribute(TAG_ETIQUETA, cu.getNombre());
/*340*/         elemento.setAttribute(TAG_VERSION, Double.toString(cu.getVersion()));
/*341*/         elemento.setAttribute(TAG_RESUMEN, cu.getResumen());
/*342*/         elemento.setAttribute(TAG_PRECONDICIONES, cu.getPrecondiciones());
/*343*/         elemento.setAttribute(TAG_DESCRIPCION, cu.getDescripcion());
/*344*/         elemento.setAttribute(TAG_EXCEPCIONES, cu.getExcepciones());
/*345*/         elemento.setAttribute(TAG_POSTCONDICIONES, cu.getPostcondiciones());
/*346*/         casosUso.appendChild(elemento);
/*347*/         item = documentoXML.createElement(TAG_ACTOR);
/*348*/         item.appendChild(documentoXML.createTextNode(cu.getActores().get(0).toString()));
/*349*/         elemento.appendChild(item);
/*350*/     }
/*351*/ 
/*352*/     /**
             * Se genera el texto XML mediante la serializacion de documentoXML y se devuelve un string
             * con los datos serializados. 
             * @return String que contiene los datos serializados de documentoXML
             */
/*356*/     private String generaTextoXML() {
/*357*/         StringWriter strWriter = null;
/*358*/         XMLSerializer seliarizadorXML = null;
/*359*/         OutputFormat formatoSalida = null;
/*360*/         try {
/*361*/             seliarizadorXML = new XMLSerializer();
/*362*/             strWriter = new StringWriter();
/*363*/             formatoSalida = new OutputFormat();
/*364*/             // 1. Establecer el formato
/*365*/             formatoSalida.setEncoding(XML_ENCODING);
/*366*/             formatoSalida.setVersion(XML_VERSION);
/*367*/             formatoSalida.setIndenting(true);
/*368*/             formatoSalida.setIndent(4);
/*369*/             // 2. Definir un objeto donde se generara el codigo
/*370*/             seliarizadorXML.setOutputCharStream(strWriter);
/*371*/             // 3. Aplicar el formato
/*372*/             seliarizadorXML.setOutputFormat(formatoSalida);
/*373*/             // 4. Serializar documento XML
/*374*/             seliarizadorXML.serialize(documentoXML);
/*375*/             strWriter.close();
/*376*/         } catch (IOException ioEx) {
/*377*/             System.out.println("Error : " + ioEx);
/*378*/         }
/*379*/         return strWriter.toString();
/*380*/     }
/*381*/ 
/*382*/     /**
             * Se guarda el contenido de un String en la ruta especificada.
             * @param texto contiene los datos serializados de docuentoXML
             * @param ruta contiene la dirección ruta en la cual se guardará el archivo
             */
/*387*/     public void guardarDocumentoXML(String texto, String ruta) {
/*388*/         try {
/*389*/             OutputStream fout = new FileOutputStream(ruta);
/*390*/             OutputStream bout = new BufferedOutputStream(fout);
/*391*/             OutputStreamWriter out = new OutputStreamWriter(bout, JAVA_ENCODING);
/*392*/             out.write(texto);
/*393*/             out.flush();
/*394*/             out.close();
/*395*/         } catch (UnsupportedEncodingException e) {
/*396*/             System.out.println("Error codificacion");
/*397*/         } catch (IOException e) {
/*398*/             System.out.println(e.getMessage());
/*399*/         } catch (Exception e) {
/*400*/             System.out.println("Error : " + e);
/*401*/         }
/*402*/     }
/*403*/ 
/*404*/     /**
             * Método que genera el texto XML en base al documentoXML.
             * @return String serializado con los datos de documentoXML.
             */
/*408*/     public String obtenerTextoXML() {
/*409*/         return generaTextoXML();
/*410*/     }
/*411*/ 
/*412*/     /**
             * Método que rellena un objeto ModeloCasoDeUso con los datos del archivo segun su ruta especificada.
             * @param CUXML String ruta del archivo a leer
             * @return String con el error en caso que suceda, null si la operacion ocurre correctamente
             * @throws ParserConfigurationException
             */
/*418*/     public String lecturaXMLCU(String CUXML) throws ParserConfigurationException {
/*419*/         DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
/*420*/         DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
/*421*/         try {
/*422*/             document = docBuilder.parse(new File(CUXML));
/*423*/             //elemento raiz del xml de Objetivos del Negocio
/*424*/             document.getDocumentElement().normalize();
/*425*/             this.setNombreCasoUso(this.lecturaNombreCasosUso());
/*426*/             this.setPreCondiciones(this.lecturaPrecondicionCasosUso());
/*427*/             this.setResumenCasoUso(this.lecturaResumenCasosUso());
/*428*/             this.setPostCondicionesCasoUso(this.lecturaPostcondicionCasosUso());
/*429*/             this.setActores(this.lecturaActorCasosUso());
/*430*/             this.setDescripcion(this.lecturaDescripcionCasosUso());
/*431*/             this.setExcepciones(this.lecturaExcepcionCasosUso());
/*432*/             return null;
/*433*/         } catch (SAXException ex) {
/*434*/             return ex.toString();
/*435*/             //Logger.getLogger(ModeloObjetivosDelNegocio.class.getName()).log(Level.SEVERE, null, ex);
/*436*/         } catch (IOException ex) {
/*437*/             return ex.toString();
/*438*/             //Logger.getLogger(ModeloObjetivosDelNegocio.class.getName()).log(Level.SEVERE, null, ex);
/*439*/         }
/*440*/     }
/*441*/ 
/*442*/     /**
             * Método que lee los nombres de los casos de uso desde un documento XML y los guarda en un vector.
             * @return Vector con los nombres de los casos de uso
             */
/*446*/     public Vector lecturaNombreCasosUso() {
/*447*/         Vector casosUsoXML = new Vector();
/*448*/         NodeList nombresCasosDeUso = document.getElementsByTagName("NombreCasoDeUso");
/*449*/         if (nombresCasosDeUso != null && nombresCasosDeUso.getLength() > 0) {
/*450*/             for (int i = 0; i < nombresCasosDeUso.getLength(); i++) {
/*451*/                 Element el = (Element) nombresCasosDeUso.item(i);
/*452*/                 casosUsoXML.add(el.getAttribute("nombre"));
/*453*/             }
/*454*/         }
/*455*/         return casosUsoXML;
/*456*/     }
/*457*/ 
/*458*/     /**
             * Método que lee las precondiciones de los casos de uso desde un documento XML y los guarda en un vector.
             * @return Vector con las precondiciones de los casos de uso.
             */
/*462*/     public Vector lecturaPrecondicionCasosUso() {
/*463*/         Vector precondicionesXML = new Vector();
/*464*/         NodeList precondicionesCasosDeUso = document.getElementsByTagName("PrecondicionCasoDeUso");
/*465*/         if (precondicionesCasosDeUso != null && precondicionesCasosDeUso.getLength() > 0) {
/*466*/             for (int i = 0; i < precondicionesCasosDeUso.getLength(); i++) {
/*467*/                 Element el = (Element) precondicionesCasosDeUso.item(i);
/*468*/                 precondicionesXML.add(el.getAttribute("nombre"));
/*469*/             }
/*470*/         }
/*471*/         return precondicionesXML;
/*472*/     }
/*473*/ 
/*474*/     /**
             * Método que lee los resúmenes de los casos de uso desde un documento XML y los guarda en un vector.
             * @return Vector con los resumenes de los casos de uso.
             */
/*478*/     public Vector lecturaResumenCasosUso() {
/*479*/         Vector resumenesXML = new Vector();
/*480*/         NodeList resumenesCasosDeUso = document.getElementsByTagName("ResumenCasoDeUso");
/*481*/         if (resumenesCasosDeUso != null && resumenesCasosDeUso.getLength() > 0) {
/*482*/             for (int i = 0; i < resumenesCasosDeUso.getLength(); i++) {
/*483*/                 Element el = (Element) resumenesCasosDeUso.item(i);
/*484*/                 resumenesXML.add(el.getAttribute("nombre"));
/*485*/             }
/*486*/         }
/*487*/         return resumenesXML;
/*488*/     }
/*489*/ 
/*490*/     /**
             * Método que lee las postcondiciones de los casos de uso desde un documento XML y los guarda en un vector.
             * @return Vector con las postcondiciones de los casos de uso.
             */
/*494*/     public Vector lecturaPostcondicionCasosUso() {
/*495*/         Vector postcondicionesXML = new Vector();
/*496*/         NodeList postcondicionesCasosDeUso = document.getElementsByTagName("PostcondicionCasoDeUso");
/*497*/         if (postcondicionesCasosDeUso != null && postcondicionesCasosDeUso.getLength() > 0) {
/*498*/             for (int i = 0; i < postcondicionesCasosDeUso.getLength(); i++) {
/*499*/                 Element el = (Element) postcondicionesCasosDeUso.item(i);
/*500*/                 postcondicionesXML.add(el.getAttribute("nombre"));
/*501*/             }
/*502*/         }
/*503*/         return postcondicionesXML;
/*504*/     }
/*505*/ 
/*506*/     /**
             * Método que lee los actores de los casos de uso desde un documento XML y los guarda en un vector.
             * @return Vector con lactores de los casos de uso.
             */
/*510*/     public Vector lecturaActorCasosUso() {
/*511*/         Vector actoresXML = new Vector();
/*512*/         NodeList actoresCasosDeUso = document.getElementsByTagName("ActorCasoDeUso");
/*513*/         if (actoresCasosDeUso != null && actoresCasosDeUso.getLength() > 0) {
/*514*/             for (int i = 0; i < actoresCasosDeUso.getLength(); i++) {
/*515*/                 Element el = (Element) actoresCasosDeUso.item(i);
/*516*/                 actoresXML.add(lecturaActor(el));
/*517*/             }
/*518*/         }
/*519*/         return actoresXML;
/*520*/     }
/*521*/ 
/*522*/     /**
             * Método que lee y los actores de un elemento ingresado como parámetro 
             * @param el Elemento a ser analizado para obtener el vector de actores
             * @return Vector que contiene los actores obtenidos del elemento ingresado.
             */
/*527*/     public Vector lecturaActor(Element el) {
/*528*/         Vector actor = new Vector();
/*529*/         NodeList actorNode = el.getElementsByTagName("Actor");
/*530*/         if (actorNode != null && actorNode.getLength() > 0) {
/*531*/             for (int i = 0; i < actorNode.getLength(); i++) {
/*532*/                 Element e = (Element) actorNode.item(i);
/*533*/                 actor.add(e.getAttribute("nombre"));
/*534*/             }
/*535*/         }
/*536*/         return actor;
/*537*/     }
/*538*/ 
/*539*/     /**
             * Método que lee las descripciones de los casos de uso desde un documento XML y los guarda en un vector.
             * @return Vector con las descripciones de los casos de uso.
             */
/*543*/     public Vector lecturaDescripcionCasosUso() {
/*544*/         Vector descripcionesXML = new Vector();
/*545*/         NodeList descripcionesCasosDeUso = document.getElementsByTagName("DescripcionCasoDeUso");
/*546*/         if (descripcionesCasosDeUso != null && descripcionesCasosDeUso.getLength() > 0) {
/*547*/             for (int i = 0; i < descripcionesCasosDeUso.getLength(); i++) {
/*548*/                 Element el = (Element) descripcionesCasosDeUso.item(i);
/*549*/                 descripcionesXML.add(el.getAttribute("nombre"));
/*550*/             }
/*551*/         }
/*552*/         return descripcionesXML;
/*553*/     }
/*554*/ 
/*555*/     /**
             * Método que lee las excepcioness de los casos de uso desde un documento XML y los guarda en un vector.
             * @return Vector con las excepciones de los casos de uso.
             */
/*559*/     public Vector lecturaExcepcionCasosUso() {
/*560*/         Vector excepcionesXML = new Vector();
/*561*/         NodeList excepcionesCasosDeUso = document.getElementsByTagName("ExcepcionCasoDeUso");
/*562*/         if (excepcionesCasosDeUso != null && excepcionesCasosDeUso.getLength() > 0) {
/*563*/             for (int i = 0; i < excepcionesCasosDeUso.getLength(); i++) {
/*564*/                 Element el = (Element) excepcionesCasosDeUso.item(i);
/*565*/                 excepcionesXML.add(el.getAttribute("nombre"));
/*566*/             }
/*567*/         }
/*568*/         return excepcionesXML;
/*569*/     }
/*570*/ }
