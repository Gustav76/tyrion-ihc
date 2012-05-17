/*1*/ package Modelo;
/*2*/ 
/*3*/ import DTO.CicloDTO;
/*4*/ import DTO.ControlAndDTO;
/*5*/ import DTO.ControlOrDTO;
/*6*/ import DTO.DescripcionObjDTO;
/*7*/ import DTO.ExcepcionDTO;
/*8*/ import DTO.ObjetivoDTO;
/*9*/ import DTO.PertenenciaDTO;
/*10*/ import DTO.TareaDTO;
/*11*/ import DTO.WorkflowDTO;
/*12*/ import DTO.nodoDTO;
/*13*/ import com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl;
/*14*/ import com.sun.org.apache.xml.internal.serialize.OutputFormat;
/*15*/ import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
/*16*/ import java.io.BufferedOutputStream;
/*17*/ import java.io.File;
/*18*/ import java.io.FileOutputStream;
/*19*/ import java.io.IOException;
/*20*/ import java.io.OutputStream;
/*21*/ import java.io.OutputStreamWriter;
/*22*/ import java.io.StringWriter;
/*23*/ import java.io.UnsupportedEncodingException;
/*24*/ import java.util.Vector;
/*25*/ import javax.xml.parsers.DocumentBuilder;
/*26*/ import javax.xml.parsers.DocumentBuilderFactory;
/*27*/ import javax.xml.parsers.ParserConfigurationException;
/*28*/ import org.w3c.dom.Document;
/*29*/ import org.w3c.dom.Element;
/*30*/ import org.w3c.dom.NodeList;
/*31*/ import org.xml.sax.SAXException;
/*32*/ 
/*33*/ /**
        *
        * 
        * Clase que representa la sesión guardada de trabajo.
        * Posee funciones para guardar la sesión iniciada en un .xml y para 
        * abrir una sesión previamente guardada.
        * 
        */
/*37*/ public class ModeloSesion {
/*38*/ 
/*39*/     public ModeloMapaConversacional MC;
/*40*/     public ModeloObjetivosDelNegocio ON;
/*41*/     public ModeloCasoDeUso CU;
/*42*/     private Document documentoXML = null;
/*43*/     private Element sesionAnterior = null;
/*44*/     static Document document;
/*45*/     private static final String TAG_SA = "SesionAnterior";
/*46*/     // Codificacion
/*47*/     private static final String XML_VERSION = "1.0";
/*48*/     private static final String XML_ENCODING = "ISO-8859-1";
/*49*/     private static final String JAVA_ENCODING = "8859_1";
/*50*/     public int ventana;
/*51*/ 
/*52*/     /**
            * Constructor de la clase ModeloSesion: 
            * Asigna los valores delas variables privadas ModeloMapaConversacional MC, 
            * ModeloObjetivosDeNegocio ON y ModeloCasoDeUso CU. 
            * 
            * @param MC Modelo de Mapa conversacional.
            * @param ON Modelo de Objeto de negocios.
            * @param CU Modelo de casos de uso.
            * 
            */
/*58*/     public ModeloSesion(ModeloMapaConversacional MC, ModeloObjetivosDelNegocio ON, ModeloCasoDeUso CU) {
/*59*/         this.MC = MC;
/*60*/         this.ON = ON;
/*61*/         this.CU = CU;
/*62*/     }
/*63*/ 
/*64*/     /**
            * Getter ventana:
            * Método get que entrega la ventana de la clase. 
            * 
            * @return ventana, valor int de la variable ventana de la clase.
            * 
            */
/*68*/     public int getVentana() {
/*69*/         return ventana;
/*70*/     }
/*71*/ 
/*72*/     /**
            * Setter ventana: 
            * Método set que asigna un valor a la variable ventana de la clase.
            * 
            * @param ventana Entero que representa el valor de la ventana.
            */
/*76*/     public void setVentana(int ventana) {
/*77*/         this.ventana = ventana;
/*78*/     }
/*79*/ 
/*80*/     /**
            * Generar XML Sesión anterior: 
            * Método que genera un documento XML que contiene la informacion de Mapas conversacionales, 
            * Modelo Objeto de negocios y Modelo de casos de uso cargando datos desde una determinada ruta 
            * y guarda el XML.
            *  
            * @param v int que repenta la cantidad de casos de uso. 
            * @param ruta String para indicar la ruta donde se gaurdará el archivo.
            */
/*85*/     public void generarSAXML(int v, String ruta) {
/*86*/         this.generaDocumentoXML();
/*87*/         this.generarXMLMC();
/*88*/         this.generarXMLON();
/*89*/         this.generarXMLCU();
/*90*/         this.generarDatosXML(v);
/*91*/         String textoXML = obtenerTextoXML();
/*92*/         guardarDocumentoXML(textoXML, ruta);
/*93*/ 
/*94*/     }
/*95*/ 
/*96*/     /**
            * Generar XML del modelo conversacional: 
            * método que genera un XML para del ModeloMapaConversacional
            * 
            */
/*99*/     public void generarXMLMC() {
/*100*/         Element mapa, estaciones, ciclos, controles, controlesAnd, controlesOr, enlaces, pertenencias, excepciones;
/*101*/         mapa = documentoXML.createElement("MapaConversacional");
/*102*/         sesionAnterior.appendChild(mapa);
/*103*/         estaciones = documentoXML.createElement("Estaciones");
/*104*/         mapa.appendChild(estaciones);
/*105*/         ciclos = documentoXML.createElement("Ciclos");
/*106*/         estaciones.appendChild(ciclos);
/*107*/         Vector vCiclos = this.MC.getMapaC().getCiclos();
/*108*/         for (int i = 0; i < vCiclos.size(); i++) {
/*109*/             CicloDTO cDTO = (CicloDTO) vCiclos.get(i);
/*110*/             cicloXML(ciclos, cDTO);
/*111*/         }
/*112*/         controles = documentoXML.createElement("Controles");
/*113*/         estaciones.appendChild(controles);
/*114*/         controlesAnd = documentoXML.createElement("ControlesAnd");
/*115*/         controles.appendChild(controlesAnd);
/*116*/         Vector vControlAnd = this.MC.getMapaC().getControlesAnd();
/*117*/         for (int i = 0; i < vControlAnd.size(); i++) {
/*118*/             ControlAndDTO cADTO = (ControlAndDTO) vControlAnd.get(i);
/*119*/             controlAndXML(controlesAnd, cADTO);
/*120*/         }
/*121*/         controlesOr = documentoXML.createElement("ControlesOr");
/*122*/         controles.appendChild(controlesOr);
/*123*/         Vector vControlOr = this.MC.getMapaC().getControlesOr();
/*124*/         for (int i = 0; i < vControlOr.size(); i++) {
/*125*/             ControlOrDTO cODTO = (ControlOrDTO) vControlOr.get(i);
/*126*/             controlOrXML(controlesOr, cODTO);
/*127*/         }
/*128*/         enlaces = documentoXML.createElement("Enlaces");
/*129*/         mapa.appendChild(enlaces);
/*130*/         pertenencias = documentoXML.createElement("Pertenencias");
/*131*/         enlaces.appendChild(pertenencias);
/*132*/         Vector vPertenencias = this.MC.getMapaC().getPertenencias();
/*133*/         for (int i = 0; i < vPertenencias.size(); i++) {
/*134*/             PertenenciaDTO pDTO = (PertenenciaDTO) vPertenencias.get(i);
/*135*/             pertenenciaXML(pertenencias, pDTO);
/*136*/         }
/*137*/         excepciones = documentoXML.createElement("Excepciones");
/*138*/         enlaces.appendChild(excepciones);
/*139*/         Vector vExcepciones = this.MC.getMapaC().getExcepciones();
/*140*/         for (int i = 0; i < vExcepciones.size(); i++) {
/*141*/             ExcepcionDTO eDTO = (ExcepcionDTO) vExcepciones.get(i);
/*142*/             excepcionXML(excepciones, eDTO);
/*143*/         }
/*144*/     }
/*145*/ 
/*146*/     /**
             * Ciclo de XML:
             * Agrega al arbol de ciclos un elemento para la creación del XML de Mapa conversacional. 
             * 
             * @param ciclos Árbol de elementos de ciclos para la formación del XML.
             * @param c Ciclo del Mapa conversacional.
             */
/*151*/     public void cicloXML(Element ciclos, CicloDTO c) {
/*152*/         Element ciclo, listaClientes, listaRealizadores;
/*153*/         ciclo = documentoXML.createElement("Ciclo");
/*154*/         ciclo.setAttribute("id", Integer.toString(c.getId()));
/*155*/         ciclo.setAttribute("idNom", c.getIdNom());
/*156*/         ciclo.setAttribute("Etiqueta", c.getEtiqueta());
/*157*/         ciclos.appendChild(ciclo);
/*158*/         listaClientes = documentoXML.createElement("ListaClientes");
/*159*/         ciclo.appendChild(listaClientes);
/*160*/         Vector vClientes = c.getListaClientes();
/*161*/         for (int j = 0; j < vClientes.size(); j++) {
/*162*/             clientesXML(listaClientes, vClientes.get(j).toString());
/*163*/         }
/*164*/         listaRealizadores = documentoXML.createElement("ListaRealizadores");
/*165*/         ciclo.appendChild(listaRealizadores);
/*166*/         Vector vRealizadores = c.getListaRealizadores();
/*167*/         for (int j = 0; j < vRealizadores.size(); j++) {
/*168*/             realizadoresXML(listaRealizadores, vRealizadores.get(j).toString());
/*169*/         }
/*170*/     }
/*171*/ 
/*172*/     /**
             * Control andXML:
             * Agrega elementos al arbol de control.
             * 
             * @param controlesAnd Arbol de elementos de control para formar XML .
             * @param c Control a agregar al Mapa conversacional.
             */
/*177*/     public void controlAndXML(Element controlesAnd, ControlAndDTO c) {
/*178*/         Element andControl;
/*179*/         andControl = documentoXML.createElement("AndControl");
/*180*/         andControl.setAttribute("id", Integer.toString(c.getId()));
/*181*/         andControl.setAttribute("idNom", c.getIdNom());
/*182*/         controlesAnd.appendChild(andControl);
/*183*/     }
/*184*/ 
/*185*/     /**
             * Control or XML:
             * Agrega elementos al arbol de condiciones de control. 
             *
             * @param controlesOr Árbol de condiciones de control del Mapa conversacional.
             * @param c condiciones de control a agregar al Mapa conversacional.
             */
/*190*/     public void controlOrXML(Element controlesOr, ControlOrDTO c) {
/*191*/         Element orControl;
/*192*/         orControl = documentoXML.createElement("OrControl");
/*193*/         orControl.setAttribute("id", Integer.toString(c.getId()));
/*194*/         orControl.setAttribute("idNom", c.getIdNom());
/*195*/         orControl.setAttribute("Condicion", c.getCondicion());
/*196*/         controlesOr.appendChild(orControl);
/*197*/     }
/*198*/ 
/*199*/     /**
             * Pertencencia XML:
             * Agrega un elemento al árbol de pertenencias del Mapa conversacional.
             * 
             * @param pertenencias Arbol de las pertenencias del Mapa conversacional.
             * @param p Pertenencia gregar al Mapa conversacional.
             */
/*204*/     public void pertenenciaXML(Element pertenencias, PertenenciaDTO p) {
/*205*/         Element pertenencia;
/*206*/         pertenencia = documentoXML.createElement("Pertenencia");
/*207*/         pertenencia.setAttribute("Origen", Integer.toString(p.getOrigen()));
/*208*/         pertenencia.setAttribute("Destino", Integer.toString(p.getDestino()));
/*209*/         pertenencia.setAttribute("Etiqueta", p.getEtiqueta());
/*210*/         pertenencias.appendChild(pertenencia);
/*211*/     }
/*212*/ 
/*213*/     /**
             * Excepcion XML:
             * Agrega un elemento al arbol de excepciones del Mapa conversacional.
             * 
             * @param excepciones Arbol de excepciones para el Mapa conversacional.
             * @param e Excepciones del Mapa conversacional a agregar.
             */
/*218*/     public void excepcionXML(Element excepciones, ExcepcionDTO e) {
/*219*/         Element excepcion;
/*220*/         excepcion = documentoXML.createElement("Excepcion");
/*221*/         excepcion.setAttribute("Origen", Integer.toString(e.getOrigen()));
/*222*/         excepcion.setAttribute("Destino", Integer.toString(e.getDestino()));
/*223*/         excepcion.setAttribute("Probabilidad", Integer.toString(e.getProbabilidad()));
/*224*/         excepcion.setAttribute("Etiqueta", e.getEtiqueta());
/*225*/         excepciones.appendChild(excepcion);
/*226*/     }
/*227*/ 
/*228*/     /**
             * Clientes XML:
             * Agrega un cliente al arbol de clientes del Mapa conversacional.
             * 
             * @param listaClientes Arbol de clientes para el Mapa conversacional.
             * @param nombre Nombre del nuevo cliente a agregar al Mapa conversacional.
             */
/*233*/     public void clientesXML(Element listaClientes, String nombre) {
/*234*/         Element rolC;
/*235*/         rolC = documentoXML.createElement("RolC");
/*236*/         rolC.setAttribute("nombre", nombre);
/*237*/         listaClientes.appendChild(rolC);
/*238*/     }
/*239*/ 
/*240*/     /**
             * Realizadores XML: 
             * Agrega un realizador a un Arbol para la creacion del Mapa conversacional.
             *
             * @param listaRealizadores Arbol de realizadores del Mapa conversacional.
             * @param nombre Nombre del realizador a agregar al Mapa conversacional.
             */
/*245*/     public void realizadoresXML(Element listaRealizadores, String nombre) {
/*246*/         Element rolR;
/*247*/         rolR = documentoXML.createElement("RolR");
/*248*/         rolR.setAttribute("nombre", nombre);
/*249*/         listaRealizadores.appendChild(rolR);
/*250*/     }
/*251*/ 
/*252*/     /**
             * Generar XMl ON:
             * Genera el XML del Modelo Objetivo de negocios.
             * 
             */
/*255*/     public void generarXMLON() {
/*256*/         TareaDTO OR = this.ON.lecturaObjetivoRaiz();
/*257*/         Element objNegocio, objRaiz;
/*258*/         objNegocio = documentoXML.createElement("ObjetivosDelNegocio");
/*259*/         sesionAnterior.appendChild(objNegocio);
/*260*/         objRaiz = documentoXML.createElement("ObjetivoRaiz");
/*261*/         objRaiz.setAttribute("id", Integer.toString(OR.getId()));
/*262*/         objRaiz.setAttribute("nombre", OR.getEtiqueta());
/*263*/         objNegocio.appendChild(objRaiz);
/*264*/         Vector vObjetivos = this.ON.getObjetivos();
/*265*/         for (int i = 0; i < vObjetivos.size(); i++) {
/*266*/             ObjetivoDTO oDTO = (ObjetivoDTO) vObjetivos.get(i);
/*267*/             objetivoXML(objRaiz, oDTO, i);
/*268*/         }
/*269*/     }
/*270*/ 
/*271*/     /**
             * Objetivo XML:
             * Agrega un objetivo al arbol de objetivos.
             * 
             * @param objRaiz raiz del arbol de objetivos.
             * @param o Objetivo que se agregará.
             * @param i Indica el id de la tarea.
             */
/*277*/     public void objetivoXML(Element objRaiz, ObjetivoDTO o, int i) {
/*278*/         Element objetivo, tareas;
/*279*/         objetivo = documentoXML.createElement("Objetivo");
/*280*/         objetivo.setAttribute("id", Integer.toString(o.getId()));
/*281*/         objetivo.setAttribute("nombre", o.getNombre());
/*282*/         objRaiz.appendChild(objetivo);
/*283*/         descObjXML(objetivo, o.getDescObj());
/*284*/         tareas = documentoXML.createElement("Tareas");
/*285*/         objetivo.appendChild(tareas);
/*286*/         getTareas(tareas, i);
/*287*/ 
/*288*/     }
/*289*/ 
/*290*/     /**
             * Descripcion Objetivo XML:
             * Agrega una descripción a un determinado objetivo para la creación del Modelo Objetivos del Negocio.
             * 
             * @param objetivo Objetivo del Modelo Objetivos del Negocio.
             * @param d Descripción del objetivo.
             */
/*295*/     public void descObjXML(Element objetivo, DescripcionObjDTO d) {
/*296*/         Element descripcion, agentes, interesados;
/*297*/         descripcion = documentoXML.createElement("DescripcionObjetivo");
/*298*/         descripcion.setAttribute("nombreObjetivo", d.getNombreObjetivo());
/*299*/         descripcion.setAttribute("Descripcion", d.getDescripcion());
/*300*/         descripcion.setAttribute("Accion", d.getAccion());
/*301*/         descripcion.setAttribute("Restricciones", d.getRestricciones());
/*302*/         descripcion.setAttribute("Obstaculos", d.getObstaculos());
/*303*/         descripcion.setAttribute("Precondiciones", d.getPreCondiciones());
/*304*/         descripcion.setAttribute("PostCondiciones", d.getPostCondiciones());
/*305*/         descripcion.setAttribute("SubObjetivos", d.getSubObjetivos());
/*306*/         objetivo.appendChild(descripcion);
/*307*/         agentes = documentoXML.createElement("Agentes");
/*308*/         descripcion.appendChild(agentes);
/*309*/         Vector vAgentes = d.getAgentes();
/*310*/         for (int j = 0; j < vAgentes.size(); j++) {
/*311*/             agenteXML(agentes, vAgentes.get(j).toString());
/*312*/         }
/*313*/         interesados = documentoXML.createElement("Interesados");
/*314*/         descripcion.appendChild(interesados);
/*315*/         Vector vInteresados = d.getInteresados();
/*316*/         for (int j = 0; j < vInteresados.size(); j++) {
/*317*/             interesadoXML(interesados, vInteresados.get(j).toString());
/*318*/         }
/*319*/     }
/*320*/ 
/*321*/     /** 
             * Agente XML:
             * Agrega un agente al arbol de agentes para la creación del XML de Modelo de Objetivos de Negocio.
             *
             * @param agentes Arbol de agentes del Modelo Objetivos del Negocio.
             * @param a Nombre del agente a agregar.
             */
/*326*/     public void agenteXML(Element agentes, String a) {
/*327*/         Element agente;
/*328*/         agente = documentoXML.createElement("Agente");
/*329*/         agente.setAttribute("nombre", a);
/*330*/         agentes.appendChild(agente);
/*331*/     }
/*332*/ 
/*333*/     /**
             * Interesado XML:
             * Agrega un interesado para la creación del XML de Modelo Objetivos del Negocio.
             * 
             * @param interesados Arbol de interesados del Modelo Objetivos del Negocio.
             * @param in Nombre del interesado a agregar.
             */
/*338*/     public void interesadoXML(Element interesados, String in) {
/*339*/         Element interesado;
/*340*/         interesado = documentoXML.createElement("Interesado");
/*341*/         interesado.setAttribute("nombre", in);
/*342*/         interesados.appendChild(interesado);
/*343*/     }
/*344*/ 
/*345*/     /**
             * Tarea Inicial:
             * 
             * 
             * @param tareas 
             * @param t 
             * @return Element Entrega la tarea inicial.
             */
/*351*/     public Element tareaInicialXML(Element tareas, TareaDTO t) {
/*352*/         Element tarea;
/*353*/         tarea = documentoXML.createElement("Tarea");
/*354*/         tarea.setAttribute("id", Integer.toString(t.getId()));
/*355*/         tarea.setAttribute("nombre", t.getEtiqueta());
/*356*/         tareas.appendChild(tarea);
/*357*/         return tarea;
/*358*/     }
/*359*/ 
/*360*/     /**
             *
             * @param tarea
             * @param t
             * @return
             */
/*366*/     public Element tareaXML(Element tarea, TareaDTO t) {
/*367*/         Element tar;
/*368*/         tar = documentoXML.createElement("Tarea");
/*369*/         tar.setAttribute("id", Integer.toString(t.getId()));
/*370*/         tar.setAttribute("nombre", t.getEtiqueta());
/*371*/         tarea.appendChild(tar);
/*372*/         return tar;
/*373*/     }
/*374*/ 
/*375*/     /**
             * Getter Tareas:
             * Entrega las tareas finales de determinada tarea.
             * 
             * @param tareass Arbol de tareas del Modelo Objetivo del Negocio.
             * @param i id de la tarea.
             */
/*380*/     public void getTareas(Element tareass, int i) {
/*381*/         Vector v = this.ON.getArbolTareas();
/*382*/         Vector t = (Vector) v.get(i);
/*383*/         nodoDTO nodo = (nodoDTO) t.get(0);
/*384*/         TareaDTO tarea = (TareaDTO) nodo.getDatosT();
/*385*/         this.getHojasFinales(tarea.getId(), tareass);
/*386*/     }
/*387*/ 
/*388*/     /**
             * Getter Hojas finales:
             * Entrega las hojas finales de las tareas.
             * 
             * @param idNodoPadre Nodo padre de la tarea.
             * @param tareass Arbol de tareas.
             */
/*393*/     public void getHojasFinales(int idNodoPadre, Element tareass) {
/*394*/         Vector v = this.ON.getArbolTareas();
/*395*/         for (int i = 0; i < v.size(); i++) {
/*396*/             Vector tareas = (Vector) v.get(i);
/*397*/             for (int j = 0; j < tareas.size(); j++) {
/*398*/                 nodoDTO nod = (nodoDTO) tareas.get(j);
/*399*/                 if (nod.getIdPadre() == idNodoPadre) {
/*400*/                     TareaDTO tarea = (TareaDTO) nod.getDatosT();
/*401*/                     Element aux2 = tareaXML(tareass, tarea);
/*402*/                     //si no hay hijos
/*403*/                     if (hayHijos(tarea.getId()) == 0) {
/*404*/                     } //si hay hijos vuelvo a buscar las ultimas hojas
/*405*/                     else {
/*406*/                         getHojasFinales(tarea.getId(), aux2);
/*407*/                     }
/*408*/                 }
/*409*/             }
/*410*/         }
/*411*/     }
/*412*/ 
/*413*/     /**
             * Hay Hijos:
             * Indica si un determinado nodo del árbol de tareas tiene hijos o no.
             * 
             * @param idPadre Nodo del árbol de tareas que se desea analizar.
             * @return int Entero que indica si un determinado nodo del arbol de tareas tiene un hijo (valor 1) o no tiene hijos (Valor 0).
             * 
            */
/*418*/     public int hayHijos(int idPadre) {
/*419*/         Vector v = this.ON.getArbolTareas();
/*420*/         Vector hojas = new Vector();
/*421*/         for (int i = 0; i < v.size(); i++) {
/*422*/             Vector tareas = (Vector) v.get(i);
/*423*/             for (int j = 0; j < tareas.size(); j++) {
/*424*/                 nodoDTO nod = (nodoDTO) tareas.get(j);
/*425*/                 if (nod.getIdPadre() == idPadre) {
/*426*/                     return 1;
/*427*/                 }
/*428*/             }
/*429*/         }
/*430*/         return 0;
/*431*/     }
/*432*/ 
/*433*/     /**
             * Generar XML CU:
             * Genera un XML para el Modelo Caso de Uso.
             * 
             */
/*436*/     public void generarXMLCU() {
/*437*/         Element casosUso, atributos, nombresCU, precondicionesCU, resumenesCU, postcondicionesCU, actoresCU, descripcionesCU, excepcionesCU;
/*438*/         casosUso = documentoXML.createElement("CasosDeUso");
/*439*/         sesionAnterior.appendChild(casosUso);
/*440*/         atributos = documentoXML.createElement("Atributos");
/*441*/         casosUso.appendChild(atributos);
/*442*/         nombresCU = documentoXML.createElement("NombresCasoDeUso");
/*443*/         atributos.appendChild(nombresCU);
/*444*/         Vector nomCU = this.CU.getNombreCasoUso();
/*445*/         if (nomCU != null) {
/*446*/             for (int i = 0; i < nomCU.size(); i++) {
/*447*/                 nombreCUXML(nombresCU, nomCU.get(i).toString());
/*448*/             }
/*449*/         }
/*450*/         precondicionesCU = documentoXML.createElement("PrecondicionesCasoDeUso");
/*451*/         atributos.appendChild(precondicionesCU);
/*452*/         Vector preCU = this.ON.getPrecondiciones();
/*453*/         if (preCU != null) {
/*454*/             for (int i = 0; i < preCU.size(); i++) {
/*455*/                 precondicionCUXML(precondicionesCU, preCU.get(i).toString());
/*456*/             }
/*457*/         }
/*458*/         resumenesCU = documentoXML.createElement("ResumenesCasoDeUso");
/*459*/         atributos.appendChild(resumenesCU); System.out.println(CU.getResumenCasoUso());
/*460*/         Vector resCU = this.ON.getResumen();
/*461*/         if (resCU != null) {
/*462*/             for (int i = 0; i < resCU.size(); i++) {
/*463*/                 resumenCUXML(resumenesCU, resCU.get(i).toString());
/*464*/             }
/*465*/         }
/*466*/         postcondicionesCU = documentoXML.createElement("PostcondicionesCasoDeUso");
/*467*/         atributos.appendChild(postcondicionesCU);
/*468*/          Vector postCU = this.ON.getPostCondiciones();
/*469*/         if (postCU != null) {
/*470*/             for (int i = 0; i < postCU.size(); i++) {
/*471*/                 postcondicionCUXML(postcondicionesCU, postCU.get(i).toString());
/*472*/             }
/*473*/         }
/*474*/         actoresCU = documentoXML.createElement("ActoresCasoDeUso");
/*475*/         atributos.appendChild(actoresCU);
/*476*/         Vector actCU = this.CU.getActores();
/*477*/         if (actCU != null) {
/*478*/             for (int i = 0; i < actCU.size(); i++) {
/*479*/                 actoresCUXML(actoresCU, (Vector) actCU.get(i));
/*480*/             }
/*481*/         }
/*482*/         descripcionesCU = documentoXML.createElement("DescripcionesCasoDeUso");
/*483*/         atributos.appendChild(descripcionesCU);
/*484*/         Vector descCU = this.CU.getDescripcion();
/*485*/         if (descCU != null) {
/*486*/             for (int i = 0; i < descCU.size(); i++) {
/*487*/                 descripcionCUXML(descripcionesCU, descCU.get(i).toString());
/*488*/             }
/*489*/         }
/*490*/         excepcionesCU = documentoXML.createElement("ExcepcionesCasoDeUso");
/*491*/         atributos.appendChild(excepcionesCU);
/*492*/         Vector excCU = this.CU.getExcepciones();
/*493*/         if (excCU != null) {
/*494*/             for (int i = 0; i < excCU.size(); i++) {
/*495*/                 excepcionCUXML(excepcionesCU, excCU.get(i).toString());
/*496*/             }
/*497*/         }
/*498*/     }
/*499*/ 
/*500*/     /**
             * Nombre Caso de USo XML:
             * Agrega un caso de uso con su nombre al arbol de Casos de uso para la creacion del XML de modelo Caso de Uso.
             * 
             * @param nombresCU Arbol de nombre de casos de uso.
             * @param n Nombre del caso de uso a agregar.
             */
/*505*/     public void nombreCUXML(Element nombresCU, String n) {
/*506*/         Element nombreCU;
/*507*/         nombreCU = documentoXML.createElement("NombreCasoDeUso");
/*508*/         nombreCU.setAttribute("nombre", n);
/*509*/         nombresCU.appendChild(nombreCU);
/*510*/     }
/*511*/ 
/*512*/     /**
             * PrecondicionCasos de Uso:
             * Agrega una precondición al albol de precondiciones para la creacion del XML de Modelo Caso de Uso.
             * 
             * @param precondicionesCU Arbol de precondiciones del Modelo de Casos de uso.
             * @param p Nombre de la precondicion a agregar.
             */
/*517*/     public void precondicionCUXML(Element precondicionesCU, String p) {
/*518*/         Element precondicionCU;
/*519*/         precondicionCU = documentoXML.createElement("PrecondicionCasoDeUso");
/*520*/         precondicionCU.setAttribute("nombre", p);
/*521*/         precondicionesCU.appendChild(precondicionCU);
/*522*/     }
/*523*/ 
/*524*/     /**
             * Resumen Casos de Uso XML:
             * Agrega un resumen al arbol de resumenes para la creacion del XMl de Modelo de Casos de Uso.
             * 
             * @param resumenesCU Arbol de resumenes del Modelo de casos de uso.
             * @param r nombre del resumen a agregar.
             */
/*529*/     public void resumenCUXML(Element resumenesCU, String r) {
/*530*/         Element resumenCU;
/*531*/         resumenCU = documentoXML.createElement("ResumenCasoDeUso");
/*532*/         resumenCU.setAttribute("nombre", r);
/*533*/         resumenesCU.appendChild(resumenCU);
/*534*/     }
/*535*/ 
/*536*/     /**
             * 
             * @param postcondicionesCU Arbol de post condiciones del Modelo de Casos de Uso.
             * @param p Nombre de la postcondicion a agregar.
             */
/*541*/     public void postcondicionCUXML(Element postcondicionesCU, String p) {
/*542*/         Element postcondicionCU;
/*543*/         postcondicionCU = documentoXML.createElement("PostcondicionCasoDeUso");
/*544*/         postcondicionCU.setAttribute("nombre", p);
/*545*/         postcondicionesCU.appendChild(postcondicionCU);
/*546*/     }
/*547*/ 
/*548*/     /**
             * Actores Casos de uso: 
             * Agrega un vector de actores al arbol de actores para la creacion del XML del Modelo de casos de uso.
             *
             * @param actoresCU Arbol de actores del modelo de Casos de uso.
             * @param a vector de actores.
             */
/*553*/     public void actoresCUXML(Element actoresCU, Vector a) {
/*554*/         Element actorCU;
/*555*/         actorCU = documentoXML.createElement("ActorCasoDeUso");
/*556*/         actoresCU.appendChild(actorCU);
/*557*/         for (int j = 0; j < a.size(); j++) {
/*558*/             actorCUXML(actorCU, a.get(j).toString());
/*559*/         }
/*560*/     }
/*561*/ 
/*562*/     /**
             * Actor casos de usoXML:
             * Agrega el nombre a un actor del modelo de casos de uso para la creacion del XML.
             *
             * @param actor actor del casode uso.
             * @param a Nombre del actor a agregar.
             */
/*567*/     public void actorCUXML(Element actor, String a) {
/*568*/         Element aCU;
/*569*/         aCU = documentoXML.createElement("Actor");
/*570*/         aCU.setAttribute("nombre", a);
/*571*/         actor.appendChild(aCU);
/*572*/     }
/*573*/ 
/*574*/     /**
             * Descripciones Casos de uso: 
             * Agrega una descripcion al arbol de descripciones para la creacion del XML de Modelo de casos de uso.
             *
             * @param descripcionesCU Arbol de casos de uso del Modelo de Casos de Uso.
             * @param d Nombre de la descripción a agregar.
             */
/*579*/     public void descripcionCUXML(Element descripcionesCU, String d) {
/*580*/         Element descripcionCU;
/*581*/         descripcionCU = documentoXML.createElement("DescripcionCasoDeUso");
/*582*/         descripcionCU.setAttribute("nombre", d);
/*583*/         descripcionesCU.appendChild(descripcionCU);
/*584*/     }
/*585*/ 
/*586*/     /**
             * Excepcion Casos de Uso XML:  
             * Agrega uan exepcion a un caso de uso.
             *
             * @param excepcionesCU Arbol de excepciones del modelo de casos de uso.
             * @param e Nombre de la excepcion a agregar.
             */
/*591*/     public void excepcionCUXML(Element excepcionesCU, String e) {
/*592*/         Element excepcionCU;
/*593*/         excepcionCU = documentoXML.createElement("ExcepcionCasoDeUso");
/*594*/         excepcionCU.setAttribute("nombre", e);
/*595*/         excepcionesCU.appendChild(excepcionCU);
/*596*/     }
/*597*/ 
/*598*/     /**
             * Genera el archivo XML
             * Funcion principal que junto con las demas funciones
             * genera el archivo de salida XML.
             * 
             * @param v  es la cantidad de workflows.
             */
/*602*/     public void generarDatosXML(int v) {
/*603*/         Element datos, datoslistadoWO, rsTabla, rsLista, rsDato, nuevos, listadoWO, actoresD1, datosD2, clientes, realizadores, nombresCU, tareas, listadoCC;
/*604*/         Element listadoWO2;
/*605*/         datos = documentoXML.createElement("Datos");
/*606*/         datos.setAttribute("ventana", Integer.toString(v));
/*607*/         sesionAnterior.appendChild(datos);
/*608*/         datoslistadoWO = documentoXML.createElement("DatosListadoWO");
/*609*/         datos.appendChild(datoslistadoWO);
/*610*/         rsTabla = documentoXML.createElement("RowsTabla");
/*611*/         datoslistadoWO.appendChild(rsTabla);
/*612*/         Vector rT = this.MC.getRowTabla();
/*613*/         if (rT != null) {
/*614*/             for (int i = 0; i < rT.size(); i++) {
/*615*/                 rowTabla(rsTabla, rT.get(i).toString());
/*616*/             }
/*617*/         }
/*618*/         rsLista = documentoXML.createElement("RowsLista");
/*619*/         datoslistadoWO.appendChild(rsLista);
/*620*/         Vector rL = this.MC.getRowLista();
/*621*/         if (rL != null) {
/*622*/             for (int i = 0; i < rL.size(); i++) {
/*623*/                 rowLista(rsLista, rL.get(i).toString());
/*624*/             }
/*625*/         }
/*626*/         rsDato = documentoXML.createElement("Rowsdato");
/*627*/         datoslistadoWO.appendChild(rsDato);
/*628*/         Vector rD = this.MC.getRowDato();
/*629*/         if (rD != null) {
/*630*/             for (int i = 0; i < rD.size(); i++) {
/*631*/                 rowDato(rsDato, rD.get(i).toString());
/*632*/             }
/*633*/         }
/*634*/         nuevos = documentoXML.createElement("Nuevos");
/*635*/         datoslistadoWO.appendChild(nuevos);
/*636*/         Vector n = this.MC.getNuevo();
/*637*/         if (n != null) {
/*638*/             for (int i = 0; i < n.size(); i++) {
/*639*/                 nuevo(nuevos, n.get(i).toString());
/*640*/             }
/*641*/         }
/*642*/         listadoWO = documentoXML.createElement("ListadoWO");
/*643*/         datoslistadoWO.appendChild(listadoWO);
/*644*/         Vector WO = this.MC.getListadoSA();
/*645*/         if (WO != null) {
/*646*/             for (int i = 0; i < WO.size(); i++) {
/*647*/                 workObj(listadoWO, WO.get(i).toString());
/*648*/             }
/*649*/         }
/*650*/         listadoWO2 = documentoXML.createElement("ListadoWO2");
/*651*/         datoslistadoWO.appendChild(listadoWO2);
/*652*/         Vector WO2 = this.MC.getListaCiclosW();
/*653*/         if (WO2 != null) {
/*654*/             for (int i = 0; i < WO2.size(); i++) {
/*655*/                 workObj2(listadoWO2, (Vector) WO2.get(i));
/*656*/             }
/*657*/         }
/*658*/         listadoCC = documentoXML.createElement("ListadoCC");
/*659*/         datoslistadoWO.appendChild(listadoCC);
/*660*/         Vector CC = this.MC.getListaCiclosWCompleto();
/*661*/         if (CC != null) {
/*662*/             for (int i = 0; i < CC.size(); i++) {
/*663*/                 WorkflowDTO wf = (WorkflowDTO) CC.get(i);
/*664*/                 listadoCompleto(listadoCC, wf);
/*665*/             }
/*666*/         }
/*667*/         datosD2 = documentoXML.createElement("DatosDescripcion2");
/*668*/         datos.appendChild(datosD2);
/*669*/         clientes = documentoXML.createElement("Clientes");
/*670*/         datosD2.appendChild(clientes);
/*671*/         Vector cD2 = this.MC.getClientesD1();
/*672*/         if (cD2 != null) {
/*673*/             for (int i = 0; i < cD2.size(); i++) {
/*674*/                 clienteD2XML(clientes, cD2.get(i).toString());
/*675*/             }
/*676*/         }
/*677*/         realizadores = documentoXML.createElement("Realizadores");
/*678*/         datosD2.appendChild(realizadores);
/*679*/         Vector rD2 = this.MC.getRealizadoresD1();
/*680*/         if (rD2 != null) {
/*681*/             for (int i = 0; i < rD2.size(); i++) {
/*682*/                 realizadorD2XML(realizadores, rD2.get(i).toString());
/*683*/             }
/*684*/         }
/*685*/         tareas = documentoXML.createElement("TareasD2");
/*686*/         datosD2.appendChild(tareas);
/*687*/         Vector tD2 = this.ON.getTareasD1();
/*688*/         if (tD2 != null) {
/*689*/             for (int i = 0; i < tD2.size(); i++) {
/*690*/                 tareaD2XML(tareas, tD2.get(i).toString());
/*691*/             }
/*692*/         }
/*693*/         nombresCU = documentoXML.createElement("NombresCUD2");
/*694*/         datosD2.appendChild(nombresCU);
/*695*/         Vector nD2 = this.CU.getNombreCuD1();
/*696*/         if (nD2 != null) {
/*697*/             for (int i = 0; i < nD2.size(); i++) {
/*698*/                 nombreCUD2XML(nombresCU, nD2.get(i).toString());
/*699*/             }
/*700*/         }
/*701*/     }
/*702*/ 
/*703*/     /**
             * Crea un listado completo del workflow.
             * crea un Element para guardar el listado completo del workflow. 
             * 
             * @param listadoCC listado de workflows.
             * @param wf estructura de dato DTO.
             */
/*708*/     public void listadoCompleto(Element listadoCC, WorkflowDTO wf) {
/*709*/         Element work;
/*710*/         work = documentoXML.createElement("WorkflowC");
/*711*/         work.setAttribute("id", Integer.toString(wf.getId()));
/*712*/         work.setAttribute("idNom", wf.getIdNom());
/*713*/         work.setAttribute("Etiqueta", wf.getEtiqueta());
/*714*/         work.setAttribute("tipo", wf.getTipo());
/*715*/         listadoCC.appendChild(work);
/*716*/     }
/*717*/ 
/*718*/     /**
             * Crea una fila para cada tabla.
             * Crea una fila para cada tabla y la guarda en un Element.
             * 
             * @param rsTabla lista de tipo element con los datos.
             * @param t nombre de cada dato.
             */
/*723*/     public void rowTabla(Element rsTabla, String t) {
/*724*/         Element rTabla;
/*725*/         rTabla = documentoXML.createElement("RowTabla");
/*726*/         rTabla.setAttribute("dato", t);
/*727*/         rsTabla.appendChild(rTabla);
/*728*/     }
/*729*/ 
/*730*/     /**
             * Crea una lista para cada dato.
             * Crea una lista para cada dato y la guarda en un Element.
             * 
             * @param rsLista lista de tipo element con los datos.
             * @param l nombre de cada dato.
             */
/*735*/     public void rowLista(Element rsLista, String l) {
/*736*/         Element rLista;
/*737*/         rLista = documentoXML.createElement("RowLista");
/*738*/         rLista.setAttribute("dato", l);
/*739*/         rsLista.appendChild(rLista);
/*740*/     }
/*741*/ 
/*742*/     /**
             * Crea una fila para cada dato.
             * Crea una fila para cada dato y la guarda en un Element.
             * 
             * @param rsDato lista de tipo Element con los Datos.
             * @param d nombre de cada dato.
             */
/*747*/     public void rowDato(Element rsDato, String d) {
/*748*/         Element rDato;
/*749*/         rDato = documentoXML.createElement("Rowdato");
/*750*/         rDato.setAttribute("dato", d);
/*751*/         rsDato.appendChild(rDato);
/*752*/     }
/*753*/ 
/*754*/     /**
             * Agrega la nueva accion alternativa.
             * Agrega la nueva accion alternativa en caso de excepcion.
             * 
             * @param nuevos lista de nuevas acciones en Element.
             * @param n nombre de cada nueva accion.
             */
/*759*/     public void nuevo(Element nuevos, String n) {
/*760*/         Element nuevo;
/*761*/         nuevo = documentoXML.createElement("Nuevo");
/*762*/         nuevo.setAttribute("dato", n);
/*763*/         nuevos.appendChild(nuevo);
/*764*/     }
/*765*/ 
/*766*/     /**
             * Agrega el workflow al XML.
             * Toma el workflow y lo agrega a un Element. 
             * 
             * @param listadoWO es el listado de todos los workflow en un Element.
             * @param w es el nombre de cada workflow.
             */
/*771*/     public void workObj(Element listadoWO, String w) {
/*772*/         Element workObj;
/*773*/         workObj = documentoXML.createElement("WorkflowObjetivo");
/*774*/         workObj.setAttribute("dato", w);
/*775*/         listadoWO.appendChild(workObj);
/*776*/     }
/*777*/ 
/*778*/     /**
             * Agrega el workflow al XML.
             * Toma el workflow y lo agrega a un Element. 
             * 
             * @param listadoWO2 es el workflow de tipo Element.
             * @param w es el nombre de cada workflow.
             */
/*783*/     public void workObj2(Element listadoWO2, Vector w) {
/*784*/         Element workObj2;
/*785*/         workObj2 = documentoXML.createElement("WorkflowObjetivo2");
/*786*/         listadoWO2.appendChild(workObj2);
/*787*/         if (w != null) {
/*788*/             for (int j = 0; j < w.size(); j++) {
/*789*/                 workflowXML(workObj2, w.get(j).toString());
/*790*/             }
/*791*/         }
/*792*/     }
/*793*/ 
/*794*/     /**
             * Agrega el workflow al XML.
             * Toma el workflow y lo agrega a un Element. 
             * 
             * @param workObj2 es el workflow de tipo Element.
             * @param f es el nonmbre del workflow.
             */
/*799*/     public void workflowXML(Element workObj2, String f) {
/*800*/         Element workflow;
/*801*/         workflow = documentoXML.createElement("Workflow");
/*802*/         workflow.setAttribute("dato", f);
/*803*/         workObj2.appendChild(workflow);
/*804*/     }
/*805*/ 
/*806*/     /**
             * Agrega los clientes para cada caso de uso.
             * Toma los clientes y los agrega a un Element.
             * 
             * @param clientes nombre de los clientes.
             * @param c los nombres de cada cliente.
             */
/*811*/     public void clienteD2XML(Element clientes, String c) {
/*812*/         Element cliente;
/*813*/         cliente = documentoXML.createElement("ClienteD2");
/*814*/         cliente.setAttribute("clienteD2", c);
/*815*/         clientes.appendChild(cliente);
/*816*/     }
/*817*/ 
/*818*/     /**
             * Agrega los realizadores para cada caso de uso.
             * Toma los realizadores y los agrega a un Element. 
             *  
             * @param realizadores nombre de los realizadores.
             * @param r los nombres de cada realizador.
             */
/*823*/     public void realizadorD2XML(Element realizadores, String r) {
/*824*/         Element realizador;
/*825*/         realizador = documentoXML.createElement("RealizadorD2");
/*826*/         realizador.setAttribute("realizadorD2", r);
/*827*/         realizadores.appendChild(realizador);
/*828*/     }
/*829*/ 
/*830*/     /**
             * Agrega las tareas para cada caso de uso.
             * Toma los nombres de las tareas y las agrega a un Element. 
             * 
             * @param tareas nombre de las tareas.
             * @param t los nombres de cada tarea.
             */
/*835*/     public void tareaD2XML(Element tareas, String t) {
/*836*/         Element tarea;
/*837*/         tarea = documentoXML.createElement("TareaD2");
/*838*/         tarea.setAttribute("nombre", t);
/*839*/         tareas.appendChild(tarea);
/*840*/     }
/*841*/ 
/*842*/     /**
             * Agrega lo nombre de los casos de uso.
             * Toma los nombres de casos de uso y los agrega a un Element. 
             * 
             * @param nombresCUD2 un elemento con los nombres de casos de uso.
             * @param n el nombre de cada caso de uso.
             */
/*847*/     public void nombreCUD2XML(Element nombresCUD2, String n) {
/*848*/         Element nombreCUD2;
/*849*/         nombreCUD2 = documentoXML.createElement("NombreCUD2");
/*850*/         nombreCUD2.setAttribute("nombre", n);
/*851*/         nombresCUD2.appendChild(nombreCUD2);
/*852*/     }
/*853*/ 
/*854*/     /**
             * Genera documento XML.
             * crea los objetos  para generar el XML. 
             * 
             */
/*857*/     public void generaDocumentoXML() {
/*858*/         try {
/*859*/             // 1. Crear objeto DocumentBuilderFactory
/*860*/             DocumentBuilderFactory dbFactory = DocumentBuilderFactoryImpl.newInstance();
/*861*/             // 2. A partir del objeto DocumentBuilderFactory crear un objeto DocumentBuilder
/*862*/             DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
/*863*/             // 3. Generar el documento XML
/*864*/             documentoXML = docBuilder.newDocument();
/*865*/         } catch (Exception e) {
/*866*/             System.out.println("Error : " + e);
/*867*/         }
/*868*/         // 4. Crear el elemento "casos de uso"
/*869*/         sesionAnterior = documentoXML.createElement(TAG_SA);
/*870*/         // 5. Agregar al documento principal
/*871*/         documentoXML.appendChild(sesionAnterior);
/*872*/     }
/*873*/ 
/*874*/     /**
             * Genera texto para ser enviado al XML final. 
             * establece el formato y serializa el 
             * documento a una archivo XML
             * 
             * @return String que indica si la operacíon fue realizada con exito. 
             */
/*878*/     private String generaTextoXML() {
/*879*/         StringWriter strWriter = null;
/*880*/         XMLSerializer seliarizadorXML = null;
/*881*/         OutputFormat formatoSalida = null;
/*882*/         try {
/*883*/             seliarizadorXML = new XMLSerializer();
/*884*/             strWriter = new StringWriter();
/*885*/             formatoSalida = new OutputFormat();
/*886*/             // 1. Establecer el formato
/*887*/             formatoSalida.setEncoding(XML_ENCODING);
/*888*/             formatoSalida.setVersion(XML_VERSION);
/*889*/             formatoSalida.setIndenting(true);
/*890*/             formatoSalida.setIndent(4);
/*891*/             // 2. Definir un objeto donde se generara el codigo
/*892*/             seliarizadorXML.setOutputCharStream(strWriter);
/*893*/             // 3. Aplicar el formato
/*894*/             seliarizadorXML.setOutputFormat(formatoSalida);
/*895*/             // 4. Serializar documento XML
/*896*/             seliarizadorXML.serialize(documentoXML);
/*897*/             strWriter.close();
/*898*/         } catch (IOException ioEx) {
/*899*/             System.out.println("Error : " + ioEx);
/*900*/         }
/*901*/         return strWriter.toString();
/*902*/     }
/*903*/ 
/*904*/     /**
             * Guarda un documento XML.
             * Gurada un XML con la sesión anterior.
             *  
             * @param texto el nombre que recibirá el archivo.
             * @param ruta la direccion de donde se guardará el archivo en el pc.
             */
/*909*/     public void guardarDocumentoXML(String texto, String ruta) {
/*910*/         try {
/*911*/             OutputStream fout = new FileOutputStream(ruta);
/*912*/             OutputStream bout = new BufferedOutputStream(fout);
/*913*/             OutputStreamWriter out = new OutputStreamWriter(bout, JAVA_ENCODING);
/*914*/             out.write(texto);
/*915*/             out.flush();
/*916*/             out.close();
/*917*/         } catch (UnsupportedEncodingException e) {
/*918*/             System.out.println("Error codificacion");
/*919*/         } catch (IOException e) {
/*920*/             System.out.println(e.getMessage());
/*921*/         } catch (Exception e) {
/*922*/             System.out.println("Error : " + e);
/*923*/         }
/*924*/     }
/*925*/ 
/*926*/     /**
             * Funcion que obtiene el texto XML.
             * llama a la función generaTextoXML, la cual escribe la salida 
             * en un archivo XML.
             * 
             * @return String devuelte un string indicando si guardo el archivo.
             */
/*930*/     public String obtenerTextoXML() {
/*931*/         return generaTextoXML();
/*932*/     }
/*933*/ 
/*934*/     /**
             * Lee la ruta del archivo.
             * Lee la ruta ingresada por el usuario donde está localizado el
             * archivo 
             * 
             * @param ruta ingresada por el usuario.
             * @return String resp indicando error  o si encontró la ruta indicada.
             * @throws ParserConfigurationException
             */
/*940*/     public String lecturaSAXML(String ruta) throws ParserConfigurationException {
/*941*/         String resp = null;
/*942*/         String resp1 = this.MC.lecturaXMLMC(ruta);
/*943*/         String resp2 = this.ON.lecturaXMLON(ruta);
/*944*/         String resp3 = this.CU.lecturaXMLCU(ruta);
/*945*/         String resp4 = this.lecturaXMLDatos(ruta);
/*946*/ 
/*947*/         if (resp1 == null && resp2 == null && resp3 == null && resp4 == null) {
/*948*/         } else {
/*949*/             resp = "Error en la carga";
/*950*/         }
/*951*/ 
/*952*/         return resp;
/*953*/     }
/*954*/ 
/*955*/     /**
             * Lee el archivo de sesion anterior.
             * Recibe como parametro el nombre del archivo y llama a las funciones de
             * lectura para guardar los datos en la estructura asignada. 
             * 
             * @param DatosXML es el nombre del archivo en el cual se guardó la sesión anterior.
             * @return String null si leyó bien la entrada o ex.toString() si hubo error.
             * @throws ParserConfigurationException.
             */
/*961*/     public String lecturaXMLDatos(String DatosXML) throws ParserConfigurationException {
/*962*/         DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
/*963*/         DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
/*964*/         try {
/*965*/             document = docBuilder.parse(new File(DatosXML));
/*966*/             //elemento raiz del xml de Objetivos del Negocio
/*967*/             document.getDocumentElement().normalize();
/*968*/             NodeList datos = document.getElementsByTagName("Datos");
/*969*/             Element el = (Element) datos.item(0);
/*970*/             int ventanaD = Integer.parseInt(el.getAttribute("ventana"));
/*971*/             this.setVentana(ventanaD);
/*972*/             this.MC.setRowTabla(this.lecturaRowTabla());
/*973*/             this.MC.setRowLista(this.lecturaRowLista());
/*974*/             this.MC.setRowDato(this.lecturaRowDato());
/*975*/             this.MC.setNuevo(this.lecturaNuevo());
/*976*/             this.MC.setListadoSA(this.lecturaWorkObj());
/*977*/             this.MC.setListaCiclosW(this.lecturaWorkObj2());
/*978*/             this.MC.setClientesD1(this.lecturaClienteD2());
/*979*/             this.MC.setRealizadoresD1(this.lecturaRealizadorD2());
/*980*/             this.ON.setTareasD1(this.lecturaTareaD2());
/*981*/             this.CU.setNombreCuD1(this.lecturaNomCUD2());
/*982*/             this.MC.setListaCiclosWCompleto(this.lecturaWorkflowCompleto());
/*983*/             return null;
/*984*/         } catch (SAXException ex) {
/*985*/             return ex.toString();
/*986*/             //Logger.getLogger(ModeloObjetivosDelNegocio.class.getName()).log(Level.SEVERE, null, ex);
/*987*/         } catch (IOException ex) {
/*988*/             return ex.toString();
/*989*/             //Logger.getLogger(ModeloObjetivosDelNegocio.class.getName()).log(Level.SEVERE, null, ex);
/*990*/         }
/*991*/     }
/*992*/ 
/*993*/     /**
              * Lee los nombres de los titulos de los workflows del archivo sesion anterior.
              * Al abrir el archivo de sesion anterior crea un vector
              * y guarda los titulos de los workflows, en una tabla donde se indica
              * la relacion de los workflows con los objetivos.
              *
              * @return Vector rTablaXML es un Vector que guarda los titulos de los workflows.
             */
/*997*/     public Vector lecturaRowTabla() {
/*998*/         Vector rTablaXML = new Vector();
/*999*/         NodeList rTabla = document.getElementsByTagName("RowTabla");
/*1000*/         if (rTabla != null && rTabla.getLength() > 0) {
/*1001*/             for (int i = 0; i < rTabla.getLength(); i++) {
/*1002*/                 Element el = (Element) rTabla.item(i);
/*1003*/                 rTablaXML.add(el.getAttribute("dato"));
/*1004*/             }
/*1005*/         }
/*1006*/         return rTablaXML;
/*1007*/     }
/*1008*/ 
/*1009*/     /**
              * Lee los nombres de los titulos de los workflows del archivo sesion anterior.
              * Al abrir el archivo de sesion anterior crea un vector
              * y guarda los titulos de los workflows en una lista, todos con pertenecia 0,
              * o sea, todos pertenecen a la misma lista.
              *
              * @return Vector rListaXML es un Vector que guarda los titulos de los workflows.
              */
/*1013*/     public Vector lecturaRowLista() {
/*1014*/         Vector rListaXML = new Vector();
/*1015*/         NodeList rLista = document.getElementsByTagName("RowLista");
/*1016*/         if (rLista != null && rLista.getLength() > 0) {
/*1017*/             for (int i = 0; i < rLista.getLength(); i++) {
/*1018*/                 Element el = (Element) rLista.item(i);
/*1019*/                 rListaXML.add(el.getAttribute("dato"));
/*1020*/             }
/*1021*/         }
/*1022*/         return rListaXML;
/*1023*/     }
/*1024*/ 
/*1025*/     /**
              * Lee los nombres de los titulos de los workflows del archivo sesion anterior.
              * Al abrir el archivo de sesion anterior crea un vector
              * y guarda los titulos de los workflows.
              *
              * @return Vector rDatoXML es un Vector que guarda los titulos de los workflows.
              */
/*1029*/     public Vector lecturaRowDato() {
/*1030*/         Vector rDatoXML = new Vector();
/*1031*/         NodeList rDato = document.getElementsByTagName("Rowdato");
/*1032*/         if (rDato != null && rDato.getLength() > 0) {
/*1033*/             for (int i = 0; i < rDato.getLength(); i++) {
/*1034*/                 Element el = (Element) rDato.item(i);
/*1035*/                 rDatoXML.add(el.getAttribute("dato"));
/*1036*/             }
/*1037*/         }
/*1038*/         return rDatoXML;
/*1039*/     }
/*1040*/ 
/*1041*/     /**
              * Lee los nombres de las acciones alternativas del archivo sesion anterior.
              * Al abrir el archivo de sesion anterior crea un vector
              * y guarda las acciones alternativas.
              *
              * @return Vector nuevoXML es un Vector que guarda las acciones alternativas.
              */
/*1045*/     public Vector lecturaNuevo() {
/*1046*/         Vector nuevoXML = new Vector();
/*1047*/         NodeList nuevo = document.getElementsByTagName("Nuevo");
/*1048*/         if (nuevo != null && nuevo.getLength() > 0) {
/*1049*/             for (int i = 0; i < nuevo.getLength(); i++) {
/*1050*/                 Element el = (Element) nuevo.item(i);
/*1051*/                 nuevoXML.add(el.getAttribute("dato"));
/*1052*/             }
/*1053*/         }
/*1054*/         return nuevoXML;
/*1055*/     }
/*1056*/ 
/*1057*/     /**
              * Lee los nombres de los workflows del archivo sesion anterior.
              * Al abrir el archivo de sesion anterior crea un vector
              * y guarda los workflows.
              *
              * @return Vector workObjXML es un Vector que guarda los workflows.
              */
/*1061*/     public Vector lecturaWorkObj() {
/*1062*/         Vector workObjXML = new Vector();
/*1063*/         NodeList workObj = document.getElementsByTagName("WorkflowObjetivo");
/*1064*/         if (workObj != null && workObj.getLength() > 0) {
/*1065*/             for (int i = 0; i < workObj.getLength(); i++) {
/*1066*/                 Element el = (Element) workObj.item(i);
/*1067*/                 workObjXML.add(el.getAttribute("dato"));
/*1068*/             }
/*1069*/         }
/*1070*/         return workObjXML;
/*1071*/     }
/*1072*/ 
/*1073*/     /**
              * Lee el conjunto de nombres de los workflows asociados del archivo sesion anterior.
              * Al abrir el archivo de sesion anterior crea un vector
              * y guarda los workflows asociados a los objetivos. 
              *
              * @return Vector workObjXML es un Vector que guarda los workflows asociados a los objetivos.
              */
/*1077*/     public Vector lecturaWorkObj2() {
/*1078*/         Vector workObjXML = new Vector();
/*1079*/         NodeList workObj = document.getElementsByTagName("WorkflowObjetivo2");
/*1080*/         if (workObj != null && workObj.getLength() > 0) {
/*1081*/             for (int i = 0; i < workObj.getLength(); i++) {
/*1082*/                 Element el = (Element) workObj.item(i);
/*1083*/                 workObjXML.add(this.lecturaWorkflow(el));
/*1084*/             }
/*1085*/         }
/*1086*/         return workObjXML;
/*1087*/     }
/*1088*/ 
/*1089*/     /**
              * Lee el subconjunto de los nombres de los workflows asociados del archivo sesion anterior.
              * Al abrir el archivo de sesion anterior crea un vector
              * y guarda los workflows asociados por cada objetivo.
              *
              * @param el Es un Element que contiene el conjunto de workflows y objetivos.
              * 
              * @return Vector workflows es un Vector que guarda los workflows asociados por cada objetivo.
              */
/*1094*/     public Vector lecturaWorkflow(Element el) {
/*1095*/         Vector workflows = new Vector();
/*1096*/         NodeList work = el.getElementsByTagName("Workflow");
/*1097*/         if (work != null && work.getLength() > 0) {
/*1098*/             for (int i = 0; i < work.getLength(); i++) {
/*1099*/                 Element w = (Element) work.item(i);
/*1100*/                 workflows.add(w.getAttribute("dato"));
/*1101*/             }
/*1102*/         }
/*1103*/         return workflows;
/*1104*/     }
/*1105*/ 
/*1106*/     /**
              * Lee los nombres de los clientes del archivo sesion anterior.
              * Al abrir el archivo de sesion anterior crea un vector
              * y guarda los clientes para caso de uso.
              *
              * @return Vector clienteD2XML es un Vector que guarda los clientes.
              */
/*1110*/     public Vector lecturaClienteD2() {
/*1111*/         Vector clienteD2XML = new Vector();
/*1112*/         NodeList clienteD2 = document.getElementsByTagName("ClienteD2");
/*1113*/         if (clienteD2 != null && clienteD2.getLength() > 0) {
/*1114*/             for (int i = 0; i < clienteD2.getLength(); i++) {
/*1115*/                 Element el = (Element) clienteD2.item(i);
/*1116*/                 clienteD2XML.add(el.getAttribute("clienteD2"));
/*1117*/             }
/*1118*/         }
/*1119*/         return clienteD2XML;
/*1120*/     }
/*1121*/ 
/*1122*/     /**
              * Lee el listado de realizadores del archivo sesion anterior.
              * Al abrir el archivo de sesion anterior crea un vector
              * y guarda el listado de realizadores para cada caso de uso.
              *
              * @return Vector realizadorD2XML es un Vector que guarda los realizadores.
              */
/*1126*/     public Vector lecturaRealizadorD2() {
/*1127*/         Vector realizadorD2XML = new Vector();
/*1128*/         NodeList realizadorD2 = document.getElementsByTagName("RealizadorD2");
/*1129*/         if (realizadorD2 != null && realizadorD2.getLength() > 0) {
/*1130*/             for (int i = 0; i < realizadorD2.getLength(); i++) {
/*1131*/                 Element el = (Element) realizadorD2.item(i);
/*1132*/                 realizadorD2XML.add(el.getAttribute("realizadorD2"));
/*1133*/             }
/*1134*/         }
/*1135*/         return realizadorD2XML;
/*1136*/     }
/*1137*/ 
/*1138*/     /**
              * Lee los nombres de las tareas del archivo sesion anterior.
              * Al abrir el archivo de sesion anterior crea un vector
              * y guarda las tareas que se ocuparán en la descripción del caso de uso.
              *
              * @return Vector tareaD2XML es un Vector que guarda las tareas.
              */
/*1142*/     public Vector lecturaTareaD2() {
/*1143*/         Vector tareaD2XML = new Vector();
/*1144*/         NodeList tareaD2 = document.getElementsByTagName("TareaD2");
/*1145*/         if (tareaD2 != null && tareaD2.getLength() > 0) {
/*1146*/             for (int i = 0; i < tareaD2.getLength(); i++) {
/*1147*/                 Element el = (Element) tareaD2.item(i);
/*1148*/                 tareaD2XML.add(el.getAttribute("nombre"));
/*1149*/             }
/*1150*/         }
/*1151*/         return tareaD2XML;
/*1152*/     }
/*1153*/ 
/*1154*/     /**
              * Lee los nombres de casos de uso del archivo sesion anterior.
              * Al abrir el archivo de sesion anterior crea un vector
              * y guarda los nombres de casos de uso creados por el usuario.
              *
              * @return Vector nomCUD2XML es un Vector que guarda los nombres de casos de uso.
              */
/*1158*/     public Vector lecturaNomCUD2() {
/*1159*/         Vector nomCUD2XML = new Vector();
/*1160*/         NodeList nomCUD2 = document.getElementsByTagName("NombreCUD2");
/*1161*/         if (nomCUD2 != null && nomCUD2.getLength() > 0) {
/*1162*/             for (int i = 0; i < nomCUD2.getLength(); i++) {
/*1163*/                 Element el = (Element) nomCUD2.item(i);
/*1164*/                 nomCUD2XML.add(el.getAttribute("nombre"));
/*1165*/             }
/*1166*/         }
/*1167*/         return nomCUD2XML;
/*1168*/     }
/*1169*/ 
/*1170*/     /**
              * Lee el Workflow del archivo sesion anterior.
              * Al abrir el archivo de sesion anterior crea un vector
              * y guarda los elementos del workflow.
              *
              * @return Vector Listado es un Vector que guarda los datos del Workflow.
              */
/*1174*/     public Vector lecturaWorkflowCompleto() {
/*1175*/         Vector Listado = new Vector();
/*1176*/         NodeList wf = document.getElementsByTagName("WorkflowC");
/*1177*/         if (wf != null && wf.getLength() > 0) {
/*1178*/             for (int i = 0; i < wf.getLength(); i++) {
/*1179*/                 Element el = (Element) wf.item(i);
/*1180*/                 WorkflowDTO w = new WorkflowDTO();
/*1181*/                 w.setId(Integer.parseInt(el.getAttribute("id")));
/*1182*/                 w.setIdNom(el.getAttribute("idNom"));
/*1183*/                 w.setEtiqueta(el.getAttribute("Etiqueta"));
/*1184*/                 w.setTipo(el.getAttribute("tipo"));
/*1185*/                 Listado.add(w);
/*1186*/             }
/*1187*/         }
/*1188*/         return Listado;
/*1189*/     }




/*1190*/

    public ModeloCasoDeUso getCU() {
        return CU;
    }

    public void setCU(ModeloCasoDeUso CU) {
        this.CU = CU;
    }

    public ModeloMapaConversacional getMC() {
        return MC;
    }

    public void setMC(ModeloMapaConversacional MC) {
        this.MC = MC;
    }

    public ModeloObjetivosDelNegocio getON() {
        return ON;
    }

    public void setON(ModeloObjetivosDelNegocio ON) {
        this.ON = ON;
    }
 }
