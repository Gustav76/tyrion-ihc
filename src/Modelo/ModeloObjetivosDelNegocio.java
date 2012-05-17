/*1*/ package Modelo;
/*2*/ 
/*3*/ import DTO.DescripcionObjDTO;
/*4*/ import DTO.ObjetivoDTO;
/*5*/ import DTO.TareaDTO;
/*6*/ import DTO.nodoDTO;
/*7*/ import java.io.File;
/*8*/ import java.io.IOException;
/*9*/ import org.w3c.dom.Document;
/*10*/ import javax.xml.parsers.DocumentBuilder;
/*11*/ import javax.xml.parsers.DocumentBuilderFactory;
/*12*/ import javax.xml.parsers.ParserConfigurationException;
/*13*/ import org.w3c.dom.NodeList;
/*14*/ import org.w3c.dom.Element;
/*15*/ import org.xml.sax.SAXException;
/*16*/ import java.util.Vector;
/*17*/ import org.w3c.dom.Node;
/*18*/ 
/*19*/ /**
        * Modelo que gestiona los datos de los objetivos del negocio. Representa el documento de 
        * objetivos del negocio almacenado localmente.
        * @author DavidyAly
        */
/*23*/ public class ModeloObjetivosDelNegocio {
/*24*/ 
/*25*/     static Document document;
/*26*/     Vector objetivosDelNegocio = new Vector();
/*27*/     Vector tareasD1 = null;
/*28*/ 
/*29*/     /**
            * Constructor de la clase.
            */
/*32*/     public ModeloObjetivosDelNegocio() {
/*33*/     }
/*34*/ 
/*35*/     /**
            * Método que retorna el vector de tareas del negocio
            * @return Vector de tareas del negocio
            */
/*39*/     public Vector getTareasD1() {
/*40*/         return tareasD1;
/*41*/     }
/*42*/ 
/*43*/     /**
            * Método que asigna el vector de tareas del negocio
            * @param Vector de tareas del negocio
            */
/*47*/     public void setTareasD1(Vector tareas) {
/*48*/         this.tareasD1 = tareas;
/*49*/     }
/*50*/ 
/*51*/     /**
            * Método que retorna los objetivos del negocio
            * @return Vector de objetivos del negocio
            */
/*55*/     public Vector getObjetivos() {
/*56*/         return this.objetivosDelNegocio;
/*57*/     }
/*58*/ 
/*59*/     /**
            * Método que asigna los objetivos del negocio
            * @param Vector de objetivos del negocio
            */
/*63*/     public void setObjetivos(Vector objetivos) {
/*64*/         this.objetivosDelNegocio = objetivos;
/*65*/     }
/*66*/ 
/*67*/     /**
            * Método que crea y retorna el árbol de tareas del negocio
            * @return Vector de árbol de tareas del negocio.
            */
/*71*/     public Vector getArbolTareas() {
/*72*/         Vector arbolTareas = new Vector();
/*73*/         for (int i = 0; i < this.objetivosDelNegocio.size(); i++) {
/*74*/             ObjetivoDTO obj = (ObjetivoDTO) this.objetivosDelNegocio.get(i);
/*75*/             arbolTareas.add(obj.getArbolTareas());
/*76*/         }
/*77*/         return arbolTareas;
/*78*/     }
/*79*/ 
/*80*/     /**
            * Método que crea y retorna el resumen de objetivos del negocio
            * @return Vector de resumen de objetivos del negocio
            */
/*84*/     public Vector getResumen() {
/*85*/         Vector resumenes = new Vector();
/*86*/         for (int i = 0; i < this.objetivosDelNegocio.size(); i++) {
/*87*/             ObjetivoDTO obj = (ObjetivoDTO) this.objetivosDelNegocio.get(i);
/*88*/             DescripcionObjDTO desc = obj.getDescObj();
/*89*/             resumenes.add(desc.getDescripcion());
/*90*/         }
/*91*/         return resumenes;
/*92*/     }
/*93*/ 
/*94*/     /**
            * Método que obtiene y retorna las postcondiciones de los objetivos del negocio
            * @return Vector de postcondiciones de los objetivos del negocio
            */
/*98*/     public Vector getPostCondiciones() {
/*99*/         Vector pCondiciones = new Vector();
/*100*/         for (int i = 0; i < this.objetivosDelNegocio.size(); i++) {
/*101*/             ObjetivoDTO obj = (ObjetivoDTO) this.objetivosDelNegocio.get(i);
/*102*/             DescripcionObjDTO desc = obj.getDescObj();
/*103*/             pCondiciones.add(desc.getPostCondiciones());
/*104*/         }
/*105*/         return pCondiciones;
/*106*/     }
/*107*/ 
/*108*/     /**
             * Método que permite obtener y retorna los agentes que interactúan en el objetivo de negocio
             * @return Vector de agentes que interactúan
             */
/*112*/     public Vector getAgentes() {
/*113*/         Vector agentes = new Vector();
/*114*/         for (int i = 0; i < this.objetivosDelNegocio.size(); i++) {
/*115*/             ObjetivoDTO obj = (ObjetivoDTO) this.objetivosDelNegocio.get(i);
/*116*/             DescripcionObjDTO desc = obj.getDescObj();
/*117*/             Vector ag = desc.getAgentes();
/*118*/             agentes.add(ag);
/*119*/         }
/*120*/         return agentes;
/*121*/     }
/*122*/ 
/*123*/     /**
             * Método que permite obtener las precondiciones necesarias para lograr los objetivos de negocio
             * @return Vector de precondiciones
             */
/*127*/     public Vector getPrecondiciones() {
/*128*/         Vector precondiciones = new Vector();
/*129*/         for (int i = 0; i < this.objetivosDelNegocio.size(); i++) {
/*130*/             ObjetivoDTO obj = (ObjetivoDTO) this.objetivosDelNegocio.get(i);
/*131*/             DescripcionObjDTO desc = obj.getDescObj();
/*132*/             precondiciones.add(desc.getPreCondiciones());
/*133*/         }
/*134*/         return precondiciones;
/*135*/     }
/*136*/ 
/*137*/     /**
             * Método que obtiene y retorna las restricciones de los objetivos del negocio
             * @return Vector de restricciones de los objetivos del negocio
             */
/*141*/     public Vector getRestricciones() {
/*142*/         Vector restricciones = new Vector();
/*143*/         for (int i = 0; i < this.objetivosDelNegocio.size(); i++) {
/*144*/             ObjetivoDTO obj = (ObjetivoDTO) this.objetivosDelNegocio.get(i);
/*145*/             DescripcionObjDTO desc = obj.getDescObj();
/*146*/             restricciones.add(desc.getRestricciones());
/*147*/         }
/*148*/         return restricciones;
/*149*/     }
/*150*/ 
/*151*/     /**
             * Método que obtiene y retorna los obstáculos de los objetivos del negocio
             * @return Vector de obstáculos de los objetivos del negocio
             */
/*155*/     public Vector getObstaculos() {
/*156*/         Vector obstaculos = new Vector();
/*157*/         for (int i = 0; i < this.objetivosDelNegocio.size(); i++) {
/*158*/             ObjetivoDTO obj = (ObjetivoDTO) this.objetivosDelNegocio.get(i);
/*159*/             DescripcionObjDTO desc = obj.getDescObj();
/*160*/             obstaculos.add(desc.getObstaculos());
/*161*/         }
/*162*/         return obstaculos;
/*163*/     }
/*164*/ 
/*165*/     /**
             * Método que carga los objetivos del negocio desde el archivo XML correspondiente y retorna el error ocurrido en este proceso
             * @param OnXML Ruta del archivo XML
             * @return String de error
             * @throws ParserConfigurationException Error de análisis sintáctico del archivo
             */
/*171*/     public String lecturaXMLON(String OnXML) throws ParserConfigurationException {
/*172*/         ObjetivoDTO obj;
/*173*/         Vector objetivos = new Vector();
/*174*/         DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
/*175*/         DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
/*176*/         try {
/*177*/             document = docBuilder.parse(new File(OnXML));
/*178*/             //elemento raiz del xml de Objetivos del Negocio
/*179*/             document.getDocumentElement().normalize();
/*180*/             //Vector de objetivos del negocio
/*181*/             this.objetivosDelNegocio = this.lecturaObjetivos();
/*182*/             return null;
/*183*/         } catch (SAXException ex) {
/*184*/             return ex.toString();
/*185*/             //Logger.getLogger(ModeloObjetivosDelNegocio.class.getName()).log(Level.SEVERE, null, ex);
/*186*/         } catch (IOException ex) {
/*187*/             return ex.toString();
/*188*/             //Logger.getLogger(ModeloObjetivosDelNegocio.class.getName()).log(Level.SEVERE, null, ex);
/*189*/         }
/*190*/     }
/*191*/ 
/*192*/     /**
             * Método que ayuda a cargar los objetivos del negocio desde el archivo XML correspondiente
             * @return Vector de objetivos del negocio
             */
/*196*/     public Vector lecturaObjetivos() {
/*197*/         Vector objetivos = new Vector();
/*198*/         ObjetivoDTO obj;
/*199*/         nodoDTO nodo;
/*200*/         Vector arbol = new Vector();
/*201*/         NodeList listaObjetivos = document.getElementsByTagName("Objetivo");
/*202*/         if (listaObjetivos != null && listaObjetivos.getLength() > 0) {
/*203*/             for (int i = 0; i < listaObjetivos.getLength(); i++) {
/*204*/                 //obtengo el elemento Objetivo
/*205*/                 Element el = (Element) listaObjetivos.item(i);
/*206*/                 //almacenador del dato objetivo
/*207*/                 obj = new ObjetivoDTO();
/*208*/                 obj.setId(Integer.parseInt(el.getAttribute("id")));
/*209*/                 obj.setNombre(el.getAttribute("nombre"));
/*210*/                 obj.setDescObj(this.lecturaDescripcionObj(el));
/*211*/                 obj.setArbolTareas(this.lecturaTareas(el));
/*212*/                 objetivos.add(obj);
/*213*/             }
/*214*/         }
/*215*/         return objetivos;
/*216*/     }
/*217*/ 
/*218*/     /**
             * Método que ayuda a recoger las descripciones de los objetivos secundarios, desde un objetivo principal.
             * @param el Elemento de la lista de objetivos principal
             * @return Descripción de los objetivos secundarios
             */
/*223*/     public DescripcionObjDTO lecturaDescripcionObj(Element el) {
/*224*/         DescripcionObjDTO descripcionO = new DescripcionObjDTO();
/*225*/         NodeList descripcion = el.getElementsByTagName("DescripcionObjetivo");
/*226*/         if (descripcion != null && descripcion.getLength() > 0) {
/*227*/             for (int j = 0; j < descripcion.getLength(); j++) {
/*228*/                 //obtengo el elemento descripcion
/*229*/                 Element d = (Element) descripcion.item(j);
/*230*/                 descripcionO.setNombreObjetivo(d.getAttribute("nombreObjetivo"));
/*231*/                 descripcionO.setDescripcion(d.getAttribute("Descripcion"));
/*232*/                 descripcionO.setAccion(d.getAttribute("Acción"));
/*233*/                 descripcionO.setRestricciones(d.getAttribute("Restricciones"));
/*234*/                 descripcionO.setObstaculos(d.getAttribute("Obstaculos"));
/*235*/                 descripcionO.setPreCondiciones(d.getAttribute("Precondiciones"));
/*236*/                 descripcionO.setPostCondiciones(d.getAttribute("PostCondiciones"));
/*237*/                 descripcionO.setSubObjetivos(d.getAttribute("SubObjetivos"));
/*238*/                 descripcionO.setAgentes(this.lecturaAgentes(d));
/*239*/                 descripcionO.setInteresados(this.lecturaInteresados(d));
/*240*/             }
/*241*/         }
/*242*/         return descripcionO;
/*243*/     }
/*244*/ 
/*245*/     /**
             * Método que recopila y retorna los agentes que interactúan con el objetivo secundario
             * @param d Elemento que contiene los agentes
             * @return Vector de agentes
             */
/*250*/     public Vector lecturaAgentes(Element d) {
/*251*/         Vector agentes = new Vector();
/*252*/         NodeList listaAgentes = d.getElementsByTagName("Agente");
/*253*/         agentes = new Vector();
/*254*/         if (listaAgentes != null && listaAgentes.getLength() > 0) {
/*255*/             for (int k = 0; k < listaAgentes.getLength(); k++) {
/*256*/                 //obtengo el elemento Agente
/*257*/                 Element ag = (Element) listaAgentes.item(k);
/*258*/                 agentes.add(ag.getAttribute("nombre"));
/*259*/             }
/*260*/         }
/*261*/         return agentes;
/*262*/     }
/*263*/ 
/*264*/     /**
             * Método que recopila y retorna los interesados que interactúan con el objetivo secundario
             * @param d Elemento que contiene los ineteresados
             * @return Vector de interesados
             */
/*269*/     public Vector lecturaInteresados(Element d) {
/*270*/         Vector interesados = new Vector();
/*271*/         NodeList listaInteresados = d.getElementsByTagName("Interesado");
/*272*/         if (listaInteresados != null && listaInteresados.getLength() > 0) {
/*273*/             for (int l = 0; l < listaInteresados.getLength(); l++) {
/*274*/                 //obtengo el elemento Interesado
/*275*/                 Element in = (Element) listaInteresados.item(l);
/*276*/                 interesados.add(in.getAttribute("nombre"));
/*277*/             }
/*278*/         }
/*279*/         return interesados;
/*280*/     }
/*281*/ 
/*282*/     /**
             * Método que recopila y retorna las tareas del objetivo
             * @param el Elemento que contiene las tareas
             * @return Vector arbol de tareas
             */
/*287*/     public Vector lecturaTareas(Element el) {
/*288*/         Vector arbol = new Vector();
/*289*/         nodoDTO nodo;
/*290*/         //para la lectura de las tareas
/*291*/         nodo = new nodoDTO();
/*292*/         TareaDTO objetivo = new TareaDTO(Integer.parseInt(el.getAttribute("id")), el.getAttribute("nombre"));
/*293*/         nodo.setIdPadre(0);
/*294*/         nodo.setDatosT(objetivo);
/*295*/         arbol.add(nodo);
/*296*/         //lectura de tareas
/*297*/         NodeList tareas = el.getElementsByTagName("Tareas");
/*298*/         //obtengo el elemento tareas
/*299*/         Element t = (Element) tareas.item(0);
/*300*/         //buscar las tareas hijas
/*301*/         NodeList tar = t.getChildNodes();
/*302*/         Node child;
/*303*/         nodoDTO nuevoNodo;
/*304*/         for (int c = 0; c < tar.getLength(); c++) {
/*305*/             child = tar.item(c);
/*306*/             if (child.getNodeType() == Node.ELEMENT_NODE) {
/*307*/                 TareaDTO nuevaTarea = new TareaDTO(Integer.parseInt(child.getAttributes().getNamedItem("id").getNodeValue()), child.getAttributes().getNamedItem("nombre").getNodeValue());
/*308*/                 nuevoNodo = new nodoDTO();
/*309*/                 nuevoNodo.setIdPadre(Integer.parseInt(el.getAttribute("id")));
/*310*/                 nuevoNodo.setDatosT(nuevaTarea);
/*311*/                 arbol.add(nuevoNodo);
/*312*/                 //recursivamente se busca si hay más nodos hijos
/*313*/                 if (child.hasChildNodes()) {
/*314*/                     this.hijos(child, Integer.parseInt(child.getAttributes().getNamedItem("id").getNodeValue()), arbol);
/*315*/                 }
/*316*/             }
/*317*/         }
/*318*/         return arbol;
/*319*/     }
/*320*/ 
/*321*/    
/*322*/     /**
             * Método recursivo para la búsqueda de tareas hijas del arbol de tareas y las agrega al Vector arbol de tareas
             * @param child Nodo del arbol
             * @param idP Id del nodo
             * @param arbolD Vector arbol de tareas
             */
/*328*/     public void hijos(Node child, int idP, Vector arbolD) {
/*329*/         NodeList listAux;
/*330*/         nodoDTO nuevoNodo;
/*331*/         listAux = child.getChildNodes();
/*332*/         for (int au = 0; au < listAux.getLength(); au++) {
/*333*/             child = listAux.item(au);
/*334*/             if (child.getNodeType() == Node.ELEMENT_NODE) {
/*335*/                 TareaDTO nuevaTarea = new TareaDTO(Integer.parseInt(child.getAttributes().getNamedItem("id").getNodeValue()), child.getAttributes().getNamedItem("nombre").getNodeValue());
/*336*/                 nuevoNodo = new nodoDTO();
/*337*/                 nuevoNodo.setIdPadre(idP);
/*338*/                 nuevoNodo.setDatosT(nuevaTarea);
/*339*/                 arbolD.add(nuevoNodo);
/*340*/ 
/*341*/                 if (child.hasChildNodes()) {
/*342*/                     this.hijos(child, Integer.parseInt(child.getAttributes().getNamedItem("id").getNodeValue()), arbolD);
/*343*/                 }
/*344*/             }
/*345*/         }
/*346*/     }
/*347*/ 
/*348*/     /**
             * Método que permite leer el objetivo raíz para poder generar el XML de la sesión
             * @return Objetivo raíz
             */
/*352*/     public TareaDTO lecturaObjetivoRaiz() {
/*353*/         TareaDTO objR = new TareaDTO();
/*354*/         NodeList objetivoRaiz = document.getElementsByTagName("ObjetivoRaiz");
/*355*/         if (objetivoRaiz != null && objetivoRaiz.getLength() > 0) {
/*356*/             for (int i = 0; i < objetivoRaiz.getLength(); i++) {
/*357*/                 //obtengo el elemento Objetivo
/*358*/                 Element el = (Element) objetivoRaiz.item(i);
/*359*/                 objR.setId(Integer.parseInt(el.getAttribute("id")));
/*360*/                 objR.setEtiqueta(el.getAttribute("nombre"));
/*361*/             }
/*362*/         }
/*363*/         return objR;
/*364*/     }
/*365*/ 
/*366*/     /**
             * Método que obtiene y retorna las tareas desde el árbol de tareas.
             * @return Vector de tareas
             */
/*370*/     public Vector getTareas() {
/*371*/         Vector v = this.getArbolTareas();
/*372*/         Vector hojas = new Vector();
/*373*/         Vector tareas = new Vector();
/*374*/         for (int i = 0; i < v.size(); i++) {
/*375*/             Vector t = (Vector) v.get(i);
/*376*/             hojas = new Vector();
/*377*/             nodoDTO nodo = (nodoDTO) t.get(0);
/*378*/             TareaDTO tarea = (TareaDTO) nodo.getDatosT();
/*379*/             this.getHojasFinales(tarea.getId(), hojas);
/*380*/             tareas.add(hojas);
/*381*/         }
/*382*/         return tareas;
/*383*/     }
/*384*/ 
/*385*/     /**
             * Método que obtiene y retorna las tareas desde las hojas del árbol de tareas.
             * @param idNodoPadre
             * @param hojas
             */
/*390*/     public void getHojasFinales(int idNodoPadre, Vector hojas) {
/*391*/         Vector v = this.getArbolTareas();
/*392*/         for (int i = 0; i < v.size(); i++) {
/*393*/             Vector tareas = (Vector) v.get(i);
/*394*/             for (int j = 0; j < tareas.size(); j++) {
/*395*/                 nodoDTO nod = (nodoDTO) tareas.get(j);
/*396*/                 if (nod.getIdPadre() == idNodoPadre) {
/*397*/                     TareaDTO tarea = (TareaDTO) nod.getDatosT();
/*398*/                     //si no hay hijos
/*399*/                     if (hayHijos(tarea.getId()) == 0) {
/*400*/                         hojas.add(tarea.getEtiqueta());
/*401*/                     } //si hay hijos vuelvo a buscar las ultimas hojas
/*402*/                     else {
/*403*/                         getHojasFinales(tarea.getId(), hojas);
/*404*/                     }
/*405*/                 }
/*406*/             }
/*407*/         }
/*408*/     }
/*409*/ 
/*410*/     /**
             * Metodo que indica si un nodo del arbol de tareas tiene hijos
             * @param idPadre Identificador del nodo buscado
             * @return Si hay hijos (1) o no hay hijos (0)
             */
/*415*/     public int hayHijos(int idPadre) {
/*416*/         Vector v = this.getArbolTareas();
/*417*/         Vector hojas = new Vector();
/*418*/         for (int i = 0; i < v.size(); i++) {
/*419*/             Vector tareas = (Vector) v.get(i);
/*420*/             for (int j = 0; j < tareas.size(); j++) {
/*421*/                 nodoDTO nod = (nodoDTO) tareas.get(j);
/*422*/                 if (nod.getIdPadre() == idPadre) {
/*423*/                     return 1;
/*424*/                 }
/*425*/             }
/*426*/         }
/*427*/         return 0;
/*428*/     }
/*429*/ }
