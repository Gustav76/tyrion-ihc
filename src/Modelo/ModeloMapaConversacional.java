/*1*/ package Modelo;
/*2*/ 
/*3*/ import DTO.CicloDTO;
/*4*/ import DTO.ControlAndDTO;
/*5*/ import DTO.ControlOrDTO;
/*6*/ import DTO.ExcepcionDTO;
/*7*/ import DTO.MapaConversacionalDTO;
/*8*/ import DTO.PertenenciaDTO;
/*9*/ import DTO.WorkflowDTO;
/*10*/ import java.io.File;
/*11*/ import java.io.IOException;
/*12*/ import org.w3c.dom.Document;
/*13*/ import javax.xml.parsers.DocumentBuilder;
/*14*/ import javax.xml.parsers.DocumentBuilderFactory;
/*15*/ import javax.xml.parsers.ParserConfigurationException;
/*16*/ import org.w3c.dom.NodeList;
/*17*/ import org.w3c.dom.Element;
/*18*/ import org.xml.sax.SAXException;
/*19*/ import java.util.Vector;
/*20*/ 
/*21*/ /**
        * 
        * Clase que representa los mapa conversacionales 
        * Posee funciones para la lectura de cada uno de los componentes del mapa conversacional 
        * recibido como entrada en un archivo XML  
        * 
        */
/*25*/ public class ModeloMapaConversacional {
/*26*/ 
/*27*/     static Document document;
/*28*/     MapaConversacionalDTO mapaC = new MapaConversacionalDTO();
/*29*/     Vector workflowCompleto = new Vector();
/*30*/     Vector workflowObj = new Vector();
/*31*/     Vector ciclosSeparados = new Vector();
/*32*/     Vector listaObj = new Vector();
/*33*/     //Vector listaObjWork=new Vector();
/*34*/     Vector listaObjWork = null;
/*35*/     Vector listaCiclosWCompleto = null;
/*36*/     Vector actores;
/*37*/     Vector nuevo = new Vector();
/*38*/     Vector rowTabla = new Vector();
/*39*/     Vector rowLista = new Vector();
/*40*/     Vector rowDato = new Vector();
/*41*/     Vector clientesD1 = null;
/*42*/     Vector realizadoresD1 = null;
/*43*/     Vector listadoSA = null;
/*44*/     
/*45*/     /**
            *
            * 
            * 
            */
/*48*/     public ModeloMapaConversacional() {
/*49*/     }
/*50*/ 
/*51*/     /** Este método retorna el vector nuevo de esta clase 
            *
            * @return nuevo
            */
/*55*/     public Vector getNuevo() {
/*56*/         return nuevo;
/*57*/     }
/*58*/ 
/*59*/     /** Este método setea el valor del vector nuevo de la clase ModeloMapaConversacional
            * 
            * @param nuevo = vector con valores para setear nuevo
            */
/*63*/     public void setNuevo(Vector nuevo) {
/*64*/         this.nuevo = nuevo;
/*65*/     }
/*66*/ 
/*67*/     /** Este método retorna el vector rowDato de ésta clase
            *
            * @return Vector
            */
/*71*/     public Vector getRowDato() {
/*72*/         return rowDato;
/*73*/     }
/*74*/ 
/*75*/     /** Este método setea el valor del vector rowDato de la clase ModeloMapaConversacional
            *
            * @param rowDato = vector con valores para setear rowDato
            */
/*79*/     public void setRowDato(Vector rowDato) {
/*80*/         this.rowDato = rowDato;
/*81*/     }
/*82*/ 
/*83*/     /** Este método retorna el vector rowLista de ésta clase
            *
            * @return Vector
            */
/*87*/     public Vector getRowLista() {
/*88*/         return rowLista;
/*89*/     }
/*90*/ 
/*91*/     /** Este método setea el valor del vector rowLista de la clase ModeloMapaConversacional
            *
            * @param rowLista = vector con valores para setear rowLista
            */
/*95*/     public void setRowLista(Vector rowLista) {
/*96*/         this.rowLista = rowLista;
/*97*/     }
/*98*/ 
/*99*/     /** Este método retorna el vector rowTabla de ésta clase
             *
             * @return Vector
             */
/*103*/     public Vector getRowTabla() {
/*104*/         return rowTabla;
/*105*/     }
/*106*/ 
/*107*/     /** Este método setea el valor del vector rowTabla de la clase ModeloMapaConversacional
             *
             * @param rowTabla = vector con valores para setear rowTabla
             */
/*111*/     public void setRowTabla(Vector rowTabla) {
/*112*/         this.rowTabla = rowTabla;
/*113*/     }
/*114*/ 
/*115*/     /** Este método retorna el vector clientesD1 de ésta clase
             *
             * @return Vector
             */
/*119*/     public Vector getClientesD1() {
/*120*/         return clientesD1;
/*121*/     }
/*122*/ 
/*123*/     /** Este método setea el valor del vector clientesD1 de la clase ModeloMapaConversacional
             *
             * @param clientesD1  = vector con valores para setear clientesD1
             */
/*127*/     public void setClientesD1(Vector clientesD1) {
/*128*/         this.clientesD1 = clientesD1;
/*129*/     }
/*130*/ 
/*131*/     /** Este método retorna el vector realizadoresD1 de ésta clase
             *
             * @return Vector
             */
/*135*/     public Vector getRealizadoresD1() {
/*136*/         return realizadoresD1;
/*137*/     }
/*138*/ 
/*139*/     /** Este método setea el valor del vector realizadoresD1 de la clase ModeloMapaConversacional
             *
             * @param realizadoresD1 = vector con valores para setear realizadoresD1.
             */
/*143*/     public void setRealizadoresD1(Vector realizadoresD1) {
/*144*/         this.realizadoresD1 = realizadoresD1;
/*145*/     }
/*146*/ 
/*147*/     /** Este método retorna el vector listaCiclosWCompleto de ésta clase
             *
             * @return Vector
             */
/*151*/     public Vector getListaCiclosWCompleto() {
/*152*/         return listaCiclosWCompleto;
/*153*/     }
/*154*/ 
/*155*/     /** Este método setea el valor del listaCiclosWCompleto de la clase ModeloMapaConversacional
             *
             * @param listaCiclosWCompleto = vector con valores para setear listaCiclosWCompleto
             */
/*159*/     public void setListaCiclosWCompleto(Vector listaCiclosWCompleto) {
/*160*/         this.listaCiclosWCompleto = listaCiclosWCompleto;
/*161*/     }
/*162*/ 
/*163*/     /** Este método retorna el vector listadoSA de ésta clase
             *
             * @return Vector
             */
/*167*/     public Vector getListadoSA() {
/*168*/         return listadoSA;
/*169*/     }
/*170*/ 
/*171*/     /** Este método setea el valor del listadoSA de la clase ModeloMapaConversacional
             *
            * @param listadoSA = vector con valores para setear ListadoSA
             */
/*175*/     public void setListadoSA(Vector listadoSA) {
/*176*/         this.listadoSA = listadoSA;
/*177*/     }
/*178*/ 
/*179*/     /** Este método realiza la lectura del archivo que contiene el modelo de mapa conversacional
             * Abre el archivo correspodiente a al modelo de mapa conversacional y luego va capturando los datos correspondientes
             * 
             * @param McXML = Direccion donde se encuentra el mapa conversacional
             * @return retorna = valor que indica si fue realizado con exito la lectura
             */
/*185*/     public String lecturaXMLMC(String McXML) throws ParserConfigurationException {
/*186*/         CicloDTO ciclo;
/*187*/         PertenenciaDTO pertenencia;
/*188*/         ExcepcionDTO excepcion;
/*189*/         Vector ciclos = new Vector(), pertenencias = new Vector(), excepciones = new Vector();
/*190*/         Vector listControlesAnd = new Vector(), listControlesOr = new Vector();
/*191*/ 
/*192*/ 
/*193*/         DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
/*194*/         DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
/*195*/         try {
/*196*/             document = docBuilder.parse(new File(McXML));
/*197*/             //elemento raiz del xml de mapa conversacional
/*198*/             document.getDocumentElement().normalize();
/*199*/             //elementos ciclos del mapa conversacional
/*200*/             mapaC.setCiclos(this.lecturaCiclos());
/*201*/             //elementos controles and del mapa conversacional
/*202*/             mapaC.setControlesAnd(this.lecturaControlesAnd());
/*203*/             //elementos controles or del mapa conversacional
/*204*/             mapaC.setControlesOr(this.lecturaControlesOr());
/*205*/             //elementos pertenencias del mapa conversacional
/*206*/             mapaC.setPertenencias(this.lecturaPertenencias());
/*207*/             //elementos excepciones del mapa conversacional
/*208*/             mapaC.setExcepciones(this.lecturaExcepciones());
/*209*/             return null;
/*210*/         } catch (SAXException ex) {
/*211*/             return ex.toString();
/*212*/             //Logger.getLogger(ModeloMapaConversacional.class.getName()).log(Level.SEVERE, null, ex);
/*213*/         } catch (IOException ex) {
/*214*/             return ex.toString();
/*215*/             //Logger.getLogger(ModeloMapaConversacional.class.getName()).log(Level.SEVERE, null, ex);
/*216*/         }
/*217*/     }
/*218*/ 
/*219*/     /** Este método retorna el MapaConversacionalDTO de ésta clase
             *
             * @return MapaConversacionalDTO
             */
/*223*/     public MapaConversacionalDTO getMapaC() {
/*224*/         return mapaC;
/*225*/     }
/*226*/ 
/*227*/     /** Este método captura todos los datos de los ciclos del mapa conversacional
             * 
             * @return retorna los ciclos encontrados
           */
/*231*/     public Vector lecturaCiclos() {
/*232*/         CicloDTO ciclo;
/*233*/         Vector ciclos = new Vector();
/*234*/         //elementos ciclos del mapa conversacional
/*235*/         NodeList listaCiclos = document.getElementsByTagName("Ciclo");
/*236*/         int totalCiclos = listaCiclos.getLength();
/*237*/         if (listaCiclos != null && listaCiclos.getLength() > 0) {
/*238*/             for (int i = 0; i < listaCiclos.getLength(); i++) {
/*239*/                 //obtengo el elemento ciclo
/*240*/                 Element el = (Element) listaCiclos. item(i);
/*241*/                 ciclo = new CicloDTO();
/*242*/                 ciclo.setId(Integer.parseInt(el.getAttribute("id")));
/*243*/                 ciclo.setIdNom(el.getAttribute("idNom"));
/*244*/                 ciclo.setEtiqueta(el.getAttribute("Etiqueta"));
/*245*/                 ciclo.setListaClientes(this.lecturaClientes(el));
/*246*/                 ciclo.setListaRealizadores(this.lecturaRealizadores(el));
/*247*/                 ciclos.add(ciclo);
/*248*/             }
/*249*/         }
/*250*/         return ciclos;
/*251*/     }
/*252*/ 
/*253*/     /** Este método lee todos los datos de los clientes ingresados como parametros
             *
             * @param el Elemento a ser analizado para obtener el vector de clientes
             * @return retorna la lista de todos los clientes encontrados en el mapa conversacional
             */
/*258*/     public Vector lecturaClientes(Element el) {
/*259*/         Vector listClientes;
/*260*/         NodeList listaClientes = el.getElementsByTagName("RolC");
/*261*/         listClientes = new Vector();
/*262*/         if (listaClientes != null && listaClientes.getLength() > 0) {
/*263*/             for (int j = 0; j < listaClientes.getLength(); j++) {
/*264*/                 //obtengo el elemento cliente
/*265*/                 Element cl = (Element) listaClientes.item(j);
/*266*/                 listClientes.add(cl.getAttribute("nombre"));
/*267*/             }
/*268*/         }
/*269*/         return listClientes;
/*270*/     }
/*271*/ 
/*272*/     /** Este método lee todos los datos de realizadores ingresados como parametros
             *
             * @param el Elemento a ser analizado para obtener el vector de realizadores
             * @return Vector que contiene los datos de los realizadores ingresados
             */
/*277*/     public Vector lecturaRealizadores(Element el) {
/*278*/         Vector listRealizadores;
/*279*/         NodeList listaRealizadores = el.getElementsByTagName("RolR");
/*280*/         listRealizadores = new Vector();
/*281*/         if (listaRealizadores != null && listaRealizadores.getLength() > 0) {
/*282*/             for (int j = 0; j < listaRealizadores.getLength(); j++) {
/*283*/                 //obtengo el elemento realizador
/*284*/                 Element cl = (Element) listaRealizadores.item(j);
/*285*/                 listRealizadores.add(cl.getAttribute("nombre"));
/*286*/             }
/*287*/         }
/*288*/         return listRealizadores;
/*289*/     }
/*290*/ 
/*291*/     /** Este método lee los controladores And desde un archivo XML y los retorna en un vector
             *
             * @return Vector con los controladores And
             */
/*295*/     public Vector lecturaControlesAnd() {
/*296*/         Vector listControlesAnd = new Vector();
/*297*/         NodeList listaControlesAnd = document.getElementsByTagName("AndControl");
/*298*/         ControlAndDTO controlA;
/*299*/         if (listaControlesAnd != null && listaControlesAnd.getLength() > 0) {
/*300*/             for (int j = 0; j < listaControlesAnd.getLength(); j++) {
/*301*/                 //obtengo el elemento control and
/*302*/                 Element lc = (Element) listaControlesAnd.item(j);
/*303*/                 controlA = new ControlAndDTO();
/*304*/                 controlA.setId(Integer.parseInt(lc.getAttribute("id")));
/*305*/                 controlA.setIdNom(lc.getAttribute("idNom"));
/*306*/                 listControlesAnd.add(controlA);
/*307*/             }
/*308*/         }
/*309*/         return listControlesAnd;
/*310*/     }
/*311*/ 
/*312*/     /** Este método lee los controladores Or desde un archivo XML y los retorna en un vector
             *
             * @return Vector con los controladores Or
             */
/*316*/     public Vector lecturaControlesOr() {
/*317*/         Vector listControlesOr = new Vector();
/*318*/         NodeList listaControlesOr = document.getElementsByTagName("OrControl");
/*319*/         ControlOrDTO controlO;
/*320*/         if (listaControlesOr != null && listaControlesOr.getLength() > 0) {
/*321*/             for (int j = 0; j < listaControlesOr.getLength(); j++) {
/*322*/                 //obtengo el elemento control or
/*323*/                 Element lcO = (Element) listaControlesOr.item(j);
/*324*/                 controlO = new ControlOrDTO();
/*325*/                 controlO.setId(Integer.parseInt(lcO.getAttribute("id")));
/*326*/                 controlO.setIdNom(lcO.getAttribute("idNom"));
/*327*/                 controlO.setCondicion(lcO.getAttribute("Condicion"));
/*328*/                 listControlesOr.add(controlO);
/*329*/             }
/*330*/         }
/*331*/         return listControlesOr;
/*332*/     }
/*333*/ 
/*334*/     /** Este método lee las pertenencias desde un archivo XML y los retorna en un vector
             *
             * @return Vector con las pertenencias
             */
/*338*/     public Vector lecturaPertenencias() {
/*339*/         Vector pertenencias = new Vector();
/*340*/         NodeList listaPertenencias = document.getElementsByTagName("Pertenencia");
/*341*/         PertenenciaDTO pertenencia;
/*342*/         if (listaPertenencias != null && listaPertenencias.getLength() > 0) {
/*343*/             for (int j = 0; j < listaPertenencias.getLength(); j++) {
/*344*/                 //obtengo el elemento pertenencia
/*345*/                 Element p = (Element) listaPertenencias.item(j);
/*346*/                 pertenencia = new PertenenciaDTO();
/*347*/                 pertenencia.setOrigen(Integer.parseInt(p.getAttribute("Origen")));
/*348*/                 pertenencia.setDestino(Integer.parseInt(p.getAttribute("Destino")));
/*349*/                 pertenencia.setEtiqueta(p.getAttribute("Etiqueta"));
/*350*/                 pertenencias.add(pertenencia);
/*351*/             }
/*352*/         }
/*353*/         return pertenencias;
/*354*/     }
/*355*/ 
/*356*/     /** Este método lee las excepciones desde un archivo XML y los retorna en un vector
             *
             * @return Vector con las excepciones
             */
/*360*/     public Vector lecturaExcepciones() {
/*361*/         Vector excepciones = new Vector();
/*362*/         NodeList listaExcepciones = document.getElementsByTagName("Excepcion");
/*363*/         ExcepcionDTO excepcion;
/*364*/         if (listaExcepciones != null && listaExcepciones.getLength() > 0) {
/*365*/             for (int j = 0; j < listaExcepciones.getLength(); j++) {
/*366*/                 //obtengo el elemento excepcion
/*367*/                 Element e = (Element) listaExcepciones.item(j);
/*368*/                 excepcion = new ExcepcionDTO();
/*369*/                 excepcion.setOrigen(Integer.parseInt(e.getAttribute("Origen")));
/*370*/                 excepcion.setDestino(Integer.parseInt(e.getAttribute("Destino")));
/*371*/                 excepcion.setProbabilidad(Integer.parseInt(e.getAttribute("Probabilidad")));
/*372*/                 excepcion.setEtiqueta(e.getAttribute("Etiqueta"));
/*373*/                 excepciones.add(excepcion);
/*374*/             }
/*375*/         }
/*376*/         return excepciones;
/*377*/     }
/*378*/ 
/*379*/     /** Metodo para la busqueda y guardado de los workflows del mapa conversacional
             *
             * @return vector con los workflow
             */
/*383*/     public Vector getWorkflows() {
/*384*/         //funcion para la busqueda y guardado de los workflows del mapa conversacional
/*385*/         Vector link = new Vector();
/*386*/         Vector ciclosW;
/*387*/         Vector ciclosWCompleto;
/*388*/         int id;
/*389*/         Vector enlaces = this.mapaC.getPertenencias();
/*390*/         PertenenciaDTO p = new PertenenciaDTO(), ps = new PertenenciaDTO();
/*391*/         for (int i = 0; i < enlaces.size(); i++) {
/*392*/             p = (PertenenciaDTO) enlaces.get(i);
/*393*/             if (p.getOrigen() == 0) {
/*394*/                 id = p.getDestino();
/*395*/                 ciclosW = new Vector();
/*396*/                 ciclosWCompleto = new Vector();
/*397*/                 if (this.getCiclo(p.getDestino()) == null) {
/*398*/                     if (this.getControlAnd(p.getDestino()) == null) {
/*399*/                         if (this.getControlOr(p.getDestino()) == null) {
/*400*/                         } else {
/*401*/                             ciclosWCompleto.add(this.getControlOr(p.getDestino()));
/*402*/                             getPertenencias(p.getDestino(), ciclosW, ciclosWCompleto);
/*403*/                         }
/*404*/                     } else {
/*405*/                         ciclosWCompleto.add(this.getControlAnd(p.getDestino()));
/*406*/                         getPertenencias(p.getDestino(), ciclosW, ciclosWCompleto);
/*407*/                     }
/*408*/                 } else {
/*409*/                     ciclosWCompleto.add(this.getCiclo(p.getDestino()));
/*410*/                     ciclosW.add(this.getCiclo(p.getDestino()).getIdNom() + ": " + this.getCiclo(p.getDestino()).getEtiqueta());
/*411*/                     getPertenencias(p.getDestino(), ciclosW, ciclosWCompleto);
/*412*/                 }
/*413*/                 link.add(ciclosW);
/*414*/                 workflowObj.add(ciclosW);
/*415*/                 workflowCompleto.add(ciclosWCompleto);
/*416*/             }
/*417*/         }
/*418*/         return link;
/*419*/     }
/*420*/ 
/*421*/     /** método para la busqueda y guardado de los workflows del mapa conversacional por ciclos
             *
             * @return vector con los workflows por ciclo
             */
/*425*/     public Vector getWorkflowsSeparados() {
/*426*/         //funcion para la busqueda y guardado de los workflows del mapa conversacional por ciclos
/*427*/         Vector link = new Vector();
/*428*/         Vector ciclosW = new Vector();
/*429*/         Vector ciclosWCompleto = new Vector();
/*430*/         int id;
/*431*/         Vector enlaces = this.mapaC.getPertenencias();
/*432*/         PertenenciaDTO p = new PertenenciaDTO(), ps = new PertenenciaDTO();
/*433*/         for (int i = 0; i < enlaces.size(); i++) {
/*434*/             p = (PertenenciaDTO) enlaces.get(i);
/*435*/             if (p.getOrigen() == 0) {
/*436*/                 id = p.getDestino();
/*437*/                 //ciclosW=new Vector();
/*438*/                 //ciclosWCompleto=new Vector();
/*439*/                 if (this.getCiclo(p.getDestino()) == null) {
/*440*/                     if (this.getControlAnd(p.getDestino()) == null) {
/*441*/                         if (this.getControlOr(p.getDestino()) == null) {
/*442*/                         } else {
/*443*/                             ciclosWCompleto.add(this.getControlOr(p.getDestino()));
/*444*/                             getPertenencias(p.getDestino(), ciclosW, ciclosWCompleto);
/*445*/                         }
/*446*/                     } else {
/*447*/                         ciclosWCompleto.add(this.getControlAnd(p.getDestino()));
/*448*/                         getPertenencias(p.getDestino(), ciclosW, ciclosWCompleto);
/*449*/                     }
/*450*/                 } else {
/*451*/                     ciclosWCompleto.add(this.getCiclo(p.getDestino()));
/*452*/                     ciclosW.add(this.getCiclo(p.getDestino()).getIdNom() + ": " + this.getCiclo(p.getDestino()).getEtiqueta());
/*453*/                     getPertenencias(p.getDestino(), ciclosW, ciclosWCompleto);
/*454*/                 }
/*455*/             }
/*456*/         }
/*457*/ 
/*458*/         this.listaCiclosWCompleto = ciclosWCompleto;
/*459*/         link.add(ciclosW);
/*460*/         return ciclosW;
/*461*/     }
/*462*/ 
/*463*/     /** Método recursivo para la busqueda de enlaces entre ciclos
             *
             * @param id entero el cual contiene el id del respectivo destino
             * @param ciclos vector que contiene los datos de los ciclos
             * @param cicloCompleto vector que contiene los datos los ciclos completos
             */
/*469*/     public void getPertenencias(int id, Vector ciclos, Vector cicloCompleto) {
/*470*/         //funcion recursiva para la busqueda de enlaces entre ciclos
/*471*/         PertenenciaDTO p = new PertenenciaDTO();
/*472*/         int destino;
/*473*/         for (int i = 0; i < this.mapaC.getPertenencias().size(); i++) {
/*474*/             p = (PertenenciaDTO) this.mapaC.getPertenencias().get(i);
/*475*/             if (p.getOrigen() == id) {
/*476*/                 if (this.getCiclo(p.getDestino()) == null) {
/*477*/                     if (this.getControlAnd(p.getDestino()) == null) {
/*478*/                         if (this.getControlOr(p.getDestino()) == null) {
/*479*/                         } else {
/*480*/                             cicloCompleto.add(this.getControlOr(p.getDestino()));
/*481*/                             getPertenencias(p.getDestino(), ciclos, cicloCompleto);
/*482*/                         }
/*483*/                     } else {
/*484*/                         cicloCompleto.add(this.getControlAnd(p.getDestino()));
/*485*/                         getPertenencias(p.getDestino(), ciclos, cicloCompleto);
/*486*/                     }
/*487*/                 } else {
/*488*/                     cicloCompleto.add(this.getCiclo(p.getDestino()));
/*489*/                     ciclos.add(this.getCiclo(p.getDestino()).getIdNom() + ": " + this.getCiclo(p.getDestino()).getEtiqueta());
/*490*/                     getPertenencias(p.getDestino(), ciclos, cicloCompleto);
/*491*/                 }
/*492*/             }
/*493*/         }
/*494*/     }
/*495*/ 
/*496*/     /** Método que obtiene el DTO cliclo correspondiente al id pasandolo al DTO workflow
             *
             * @param id entero el cual contiene el id del respectivo destino
             * @return WorlowDTO correspodiente a la id ingresada como parametro
             */
/*501*/     public WorkflowDTO getCiclo(int id) {
/*502*/         //obtengo el DTO ciclo correspondiente al id pasandolo al DTO workflow
/*503*/         CicloDTO ciclo = null;
/*504*/         WorkflowDTO wf = null;
/*505*/         Vector ciclos = this.mapaC.getCiclos();
/*506*/         for (int i = 0; i < ciclos.size(); i++) {
/*507*/             ciclo = (CicloDTO) ciclos.get(i);
/*508*/             if (ciclo.getId() == id) {
/*509*/                 wf = new WorkflowDTO();
/*510*/                 wf.setId(ciclo.getId());
/*511*/                 wf.setIdNom(ciclo.getIdNom());
/*512*/                 wf.setEtiqueta(ciclo.getEtiqueta());
/*513*/                 wf.setTipo("ciclo");
/*514*/                 return wf;
/*515*/             }
/*516*/         }
/*517*/         return wf;
/*518*/     }
/*519*/ 
/*520*/     /** Método que obteniene el DTO controlAnd correspondiente al id pasandolo al DTO workflow
             *
             * @param id entero el cual contiene el id del respectivo destino
             * @return WorlowDTO correspodiente a la id ingresada como parametro
             */ 
/*525*/     public WorkflowDTO getControlAnd(int id) {
/*526*/         //obtengo el DTO controlAnd correspondiente al id pasandolo al DTO workflow
/*527*/         ControlAndDTO controlA = null;
/*528*/         WorkflowDTO wf = null;
/*529*/         Vector controlAnd = this.mapaC.getControlesAnd();
/*530*/         for (int i = 0; i < controlAnd.size(); i++) {
/*531*/             controlA = (ControlAndDTO) controlAnd.get(i);
/*532*/             if (controlA.getId() == id) {
/*533*/                 wf = new WorkflowDTO();
/*534*/                 wf.setId(controlA.getId());
/*535*/                 wf.setIdNom(controlA.getIdNom());
/*536*/                 wf.setTipo("controlAnd");
/*537*/                 return wf;
/*538*/             }
/*539*/         }
/*540*/         return wf;
/*541*/     }
/*542*/ 
/*543*/     /** Método que obteniene el DTO controlOR correspondiente al id pasandolo al DTO workflow
             *
             * @param id entero el cual contiene el id del respectivo destino
             * @return WorlowDTO correspodiente a la id ingresada como parametro
             */ 
/*548*/     public WorkflowDTO getControlOr(int id) {
/*549*/         //obtengo el DTO ControlOR correspondiente al id pasandolo al DTO workflow
/*550*/         ControlOrDTO controlO = null;
/*551*/         WorkflowDTO wf = null;
/*552*/         Vector controlOr = this.mapaC.getControlesOr();
/*553*/         for (int i = 0; i < controlOr.size(); i++) {
/*554*/             controlO = (ControlOrDTO) controlOr.get(i);
/*555*/             if (controlO.getId() == id) {
/*556*/                 wf = new WorkflowDTO();
/*557*/                 wf.setId(controlO.getId());
/*558*/                 wf.setIdNom(controlO.getIdNom());
/*559*/                 wf.setEtiqueta(controlO.getCondicion());
/*560*/                 wf.setTipo("controlOr");
/*561*/                 return wf;
/*562*/             }
/*563*/         }
/*564*/         return wf;
/*565*/     }
/*566*/ 
/*567*/     /** Método que obteniene el DTO ciclo correspondiente al id pasandolo al DTO workflow
             *
             * @param id entero el cual contiene el id del respectivo destino
             * @return WorlowDTO correspodiente a la id ingresada como parametro
             */ 
/*572*/     public WorkflowDTO getCicloExcepcion(int id) {
/*573*/         //obtengo el DTO ciclo correspondiente al id pasandolo al DTO workflow
/*574*/         CicloDTO ciclo = null;
/*575*/         WorkflowDTO wf = null;
/*576*/         Vector ciclos = this.mapaC.getCiclos();
/*577*/         for (int i = 0; i < ciclos.size(); i++) {
/*578*/             ciclo = (CicloDTO) ciclos.get(i);
/*579*/             if (ciclo.getId() == id) {
/*580*/                 wf = new WorkflowDTO();
/*581*/                 wf.setId(ciclo.getId());
/*582*/                 wf.setIdNom(ciclo.getIdNom());
/*583*/                 wf.setEtiqueta(ciclo.getEtiqueta());
/*584*/                 wf.setTipo("cicloExcepcion");
/*585*/                 return wf;
/*586*/             }
/*587*/         }
/*588*/         return wf;
/*589*/     }
/*590*/ 
/*591*/     /** Metodo que obtiene ciclos excepcionales
             *
             * @return Vector con los ciclos excepcionales
             */
/*595*/     public Vector getCiclosExcepciones() {
/*596*/         Vector exc = this.mapaC.getExcepciones();
/*597*/         Vector ciclosExc = new Vector();
/*598*/         Vector ciclos = new Vector();
/*599*/         for (int i = 0; i < exc.size(); i++) {
/*600*/             ExcepcionDTO excDTO = (ExcepcionDTO) exc.get(i);
/*601*/             if (this.estaE(excDTO.getOrigen(), ciclos) == 0) {
/*602*/                 ciclosExc = new Vector();
/*603*/                 if (this.getCicloExcepcion(excDTO.getOrigen()) == null) {
/*604*/                     if (this.getControlAnd(excDTO.getOrigen()) == null) {
/*605*/                         if (this.getControlOr(excDTO.getOrigen()) == null) {
/*606*/                         } else {
/*607*/                             ciclosExc.add(this.getControlOr(excDTO.getOrigen()));
/*608*/                         }
/*609*/                     } else {
/*610*/                         ciclosExc.add(this.getControlAnd(excDTO.getOrigen()));
/*611*/                     }
/*612*/                 } else {
/*613*/                     ciclosExc.add(this.getCicloExcepcion(excDTO.getOrigen()));
/*614*/                 }
/*615*/ 
/*616*/                 ciclosExc.add(this.getCicloExcepcion(excDTO.getDestino()));
/*617*/                 hayPertenencia(excDTO.getDestino(), ciclosExc, ciclos);
/*618*/                 ciclos.add(ciclosExc);
/*619*/             }
/*620*/         }
/*621*/         return ciclos;
/*622*/     }
/*623*/ 
/*624*/     /** 
             * Metodo el cual ve si es que existe pertenencia para el ciclo que entre como parametro 
             * @param id entero el cual contiene el id del respectivo destino
             * @param ciclosE vector el cual puede contener diversos tipos de control
             * @param ciclos vector el cual contiene los ciclos excepcionales
            */
/*630*/     public void hayPertenencia(int id, Vector ciclosE, Vector ciclos) {
/*631*/         Vector p = this.mapaC.getPertenencias();
/*632*/         for (int i = 0; i < p.size(); i++) {
/*633*/             PertenenciaDTO pt = (PertenenciaDTO) p.get(i);
/*634*/             if (pt.getOrigen() == id) {
/*635*/                 if (this.getCicloExcepcion(pt.getDestino()) == null) {
/*636*/                     if (this.getControlAnd(pt.getDestino()) == null) {
/*637*/                         if (this.getControlOr(pt.getDestino()) == null) {
/*638*/                         } else {
/*639*/                             ciclosE.add(this.getControlOr(pt.getDestino()));
/*640*/                             hayPertenencia(pt.getDestino(), ciclosE, ciclos);
/*641*/                         }
/*642*/                     } else {
/*643*/                         ciclosE.add(this.getControlAnd(pt.getDestino()));
/*644*/                         hayPertenencia(pt.getDestino(), ciclosE, ciclos);
/*645*/                     }
/*646*/                 } else {
/*647*/                     ciclosE.add(this.getCicloExcepcion(pt.getDestino()));
/*648*/                     hayPertenencia(pt.getDestino(), ciclosE, ciclos);
/*649*/                 }
/*650*/             }
/*651*/         }
/*652*/         hayExcepciones(id, ciclosE, ciclos);
/*653*/     }
/*654*/ 
/*655*/     /** 
             * Método el cual verifica si la id entrada como parametro pertenece al WorkflowDTO
             * @param id entero el cual se quiere comparar con WorkfloDTO
             * @param ciclos Vector el cual contiene ciclos
             * @return entero que indica si el entero se encuentra en el WorkflowDTO
             */
/*661*/     public int estaE(int id, Vector ciclos) {
/*662*/         for (int i = 0; i < ciclos.size(); i++) {
/*663*/             Vector v = (Vector) ciclos.get(i);
/*664*/             for (int j = 0; j < v.size(); j++) {
/*665*/                 WorkflowDTO w = (WorkflowDTO) v.get(j);
/*666*/                 if (w.getId() == id) {
/*667*/                     return 1;
/*668*/                 }
/*669*/             }
/*670*/         }
/*671*/         return 0;
/*672*/     }
/*673*/ 
/*674*/     /**
             * Método que comprueba si hay excepciones entre un vector de excepciones
             * dentro de un vector de workflows 
             * @param id
             * @param ciclosE
             * @param ciclos
             */
/*680*/     public void hayExcepciones(int id, Vector ciclosE, Vector ciclos) {
/*681*/         Vector e = this.mapaC.getExcepciones();
/*682*/         for (int i = 0; i < e.size(); i++) {
/*683*/             ExcepcionDTO exc = (ExcepcionDTO) e.get(i);
/*684*/             if (exc.getOrigen() == id) {
/*685*/                 if (this.getCicloExcepcion(exc.getDestino()) == null) {
/*686*/                     if (this.getControlAnd(exc.getDestino()) == null) {
/*687*/                         if (this.getControlOr(exc.getDestino()) == null) {
/*688*/                         } else {
/*689*/                             ciclosE.add(this.getControlOr(exc.getDestino()));
/*690*/                             hayPertenencia(exc.getDestino(), ciclosE, ciclos);
/*691*/                         }
/*692*/                     } else {
/*693*/                         ciclosE.add(this.getControlAnd(exc.getDestino()));
/*694*/                         hayPertenencia(exc.getDestino(), ciclosE, ciclos);
/*695*/                     }
/*696*/                 } else {
/*697*/                     ciclosE.add(this.getCicloExcepcion(exc.getDestino()));
/*698*/                     hayPertenencia(exc.getDestino(), ciclosE, ciclos);
/*699*/                 }
/*700*/             }
/*701*/         }
/*702*/     }
/*703*/ 
/*704*/     /**
 * 
             * Inicializando el seteo de objetos workflow en el vector listaObj
             * @param objWorkflow
             */
/*708*/     public void setObj(Vector objWorkflow) {
/*709*/         this.listaObj = objWorkflow;
/*710*/     }
/*711*/ 
/*712*/     /**
            * Seteo del vector lCicloW en listaObjWork
            * @param lCiclosW
             */
/*716*/     public void setListaCiclosW(Vector lCiclosW) {
/*717*/         this.listaObjWork = lCiclosW;
/*718*/     }
/*719*/ 
/*720*/     /**
             *
             * @return lista de workflow en listObjWork
             */
/*724*/     public Vector getListaCiclosW() {
/*725*/         return this.listaObjWork;
/*726*/     }
/*727*/ 
/*728*/     /**
             * 
             * @return todos los actores involucrados en la vistaObtenerActores de vistas de sistema
             */
/*732*/     public Vector getActores() {
/*733*/         return actores;
/*734*/     }
/*735*/ 
/*736*/     /**
             * Se setea el valor de cada actor (cliente/realizador) en vistaObtenerActores
             * @param actores
             */
/*740*/     public void setActores(Vector actores) {
/*741*/         this.actores = actores;
/*742*/     }
/*743*/ 
/*744*/     /**
             * Método que no recibe parametros, ocupa valores ya guardados
             * de clientes para generar una vector de ellos    
             * @return retorna la lista (vector) total de clientes en VistaDescripcion1 (vistas del sistema)
             */
/*748*/     public Vector getClientes() {
/*749*/         Vector clientesCiclos = new Vector();
/*750*/         Vector clientes = new Vector();
/*751*/         WorkflowDTO wf = new WorkflowDTO();
/*752*/         for (int i = 0; i < this.listaObj.size(); i++) {
/*753*/             clientesCiclos = new Vector();
/*754*/             Vector v = (Vector) this.workflowCompleto.get(this.getPosicion(i));
/*755*/             //ciclos
/*756*/             for (int j = 0; j < v.size(); j++) {
/*757*/                 //workflow
/*758*/                 wf = (WorkflowDTO) v.get(j);
/*759*/                 if (wf.getTipo().equals("ciclo")) {
/*760*/                     Vector c = this.getClientesCiclo(wf.getId());
/*761*/                     Vector r = this.getRealizadoresCiclo(wf.getId());
/*762*/                     for (int k = 0; k < c.size(); k++) {
/*763*/                         String cl = c.get(k).toString();
/*764*/                         if (this.estaLista(cl, clientesCiclos) == 0) {
/*765*/                             clientesCiclos.add(cl);
/*766*/                         }
/*767*/                     }
/*768*/                 }
/*769*/             }
/*770*/             clientes.add(clientesCiclos);
/*771*/         }
/*772*/         return clientes;
/*773*/     }
/*774*/ 
/*775*/     /**
             * Método que permite obtener, en el modelo de sistema "ModeloMapaConversacional", los clientes. 
             * @return Clientes
             */
/*779*/     public Vector getClientes2() {
/*780*/         Vector clientesCiclos = new Vector();
/*781*/         Vector clientes = new Vector();
/*782*/         Vector ciclos = new Vector();
/*783*/         WorkflowDTO wf = new WorkflowDTO();
/*784*/         for (int i = 0; i < this.listaObjWork.size(); i++) {
/*785*/             ciclos = (Vector) this.listaObjWork.get(i);
/*786*/             //System.out.println("ListaCiclos: "+ciclos);
/*787*/             clientesCiclos = new Vector();
/*788*/             for (int j = 0; j < ciclos.size(); j++) {
/*789*/                 String dato = ciclos.get(j).toString();
/*790*/                 Vector c = this.getClientesC(dato);
/*791*/                 //System.out.println("clientes: "+c);
/*792*/                 for (int k = 0; k < c.size(); k++) {
/*793*/                     String cliente = c.get(k).toString();
/*794*/                     if (this.estaLista(cliente, clientesCiclos) == 0) {
/*795*/                         clientesCiclos.add(cliente);
/*796*/                     }
/*797*/                 }
/*798*/             }
/*799*/             clientes.add(clientesCiclos);
/*800*/         }
/*801*/         return clientes;
/*802*/     }
/*803*/ 
/*804*/     /**
             * Método que permite obtener los actores (clientes o realizadores), de las tareas y/o casos de Uso 
             * en la vista de sistema "VistaDescripcion1"  
             * @return un vector con los actores realizadores
             */
/*808*/     public Vector getRealizadores() {
/*809*/         Vector realizadoresCiclos = new Vector();
/*810*/         Vector realizadores = new Vector();
/*811*/         WorkflowDTO wf = new WorkflowDTO();
/*812*/         for (int i = 0; i < this.listaObj.size(); i++) {
/*813*/             realizadoresCiclos = new Vector();
/*814*/             Vector v = (Vector) this.workflowCompleto.get(this.getPosicion(i));
/*815*/             //ciclos
/*816*/             for (int j = 0; j < v.size(); j++) {
/*817*/                 //workflow
/*818*/                 wf = (WorkflowDTO) v.get(j);
/*819*/                 if (wf.getTipo().equals("ciclo")) {
/*820*/                     Vector r = this.getRealizadoresCiclo(wf.getId());
/*821*/                     for (int m = 0; m < r.size(); m++) {
/*822*/                         String rl = r.get(m).toString();
/*823*/                         if (this.estaLista(rl, realizadoresCiclos) == 0) {
/*824*/                             realizadoresCiclos.add(rl);
/*825*/                         }
/*826*/                     }
/*827*/                 }
/*828*/             }
/*829*/             realizadores.add(realizadoresCiclos);
/*830*/         }
/*831*/         return realizadores;
/*832*/     }
/*833*/ 
/*834*/     /**
             * Método que permite obtener realizadores en el modelo ModeloMapaConversacional
             * @return todos los realizadores
             */
/*838*/     public Vector getRealizadores2() {
/*839*/         Vector realizadoresCiclos = new Vector();
/*840*/         Vector realizadores = new Vector();
/*841*/         Vector ciclos = new Vector();
/*842*/         WorkflowDTO wf = new WorkflowDTO();
/*843*/         for (int i = 0; i < this.listaObjWork.size(); i++) {
/*844*/             ciclos = (Vector) this.listaObjWork.get(i);
/*845*/             //System.out.println("ListaCiclos: "+ciclos);
/*846*/             realizadoresCiclos = new Vector();
/*847*/             for (int j = 0; j < ciclos.size(); j++) {
/*848*/                 String dato = ciclos.get(j).toString();
/*849*/                 Vector r = this.getRealizadoresC(dato);
/*850*/                 //System.out.println("clientes: "+c);
/*851*/                 for (int k = 0; k < r.size(); k++) {
/*852*/                     String realizador = r.get(k).toString();
/*853*/                     if (this.estaLista(realizador, realizadoresCiclos) == 0) {
/*854*/                         realizadoresCiclos.add(realizador);
/*855*/                     }
/*856*/                 }
/*857*/             }
/*858*/             realizadores.add(realizadoresCiclos);
/*859*/         }
/*860*/         return realizadores;
/*861*/     }
/*862*/ 
/*863*/     /**
             * Método que recibe como parametro un identificador de ciclo
             * @param id
             * @return devuelve como resultado un cliente(s) con un workflow en particular
             */
/*868*/     public Vector getClientesCiclo(int id) {
/*869*/         Vector clientes = new Vector();
/*870*/         CicloDTO ciclo = new CicloDTO();
/*871*/         for (int k = 0; k < this.mapaC.getCiclos().size(); k++) {
/*872*/             ciclo = (CicloDTO) this.mapaC.getCiclos().get(k);
/*873*/             if (ciclo.getId() == id) {
/*874*/                 clientes = ciclo.getListaClientes();
/*875*/             }
/*876*/         }
/*877*/         return clientes;
/*878*/     }
/*879*/ 
/*880*/     /**
             * Método que recibe como parametro un entero Id identificador de workflow
             * @param id
             * @return devuelve como resultado un realizador con un workflow en particular
             */
/*885*/     public Vector getRealizadoresCiclo(int id) {
/*886*/         Vector realizadores = new Vector();
/*887*/         CicloDTO ciclo = new CicloDTO();
/*888*/         for (int k = 0; k < this.mapaC.getCiclos().size(); k++) {
/*889*/             ciclo = (CicloDTO) this.mapaC.getCiclos().get(k);
/*890*/             if (ciclo.getId() == id) {
/*891*/                 realizadores = ciclo.getListaRealizadores();
/*892*/             }
/*893*/         }
/*894*/         return realizadores;
/*895*/     }
/*896*/ 
/*897*/     /**
             * Método que permite obtener la posicion de un workflow asociado a una posicion
             * dentro de una lista 
             * @param k
             * @return devuelve posicion del workflow
             */
/*902*/     public int getPosicion(int k) {
/*903*/         for (int j = 0; j < this.workflowObj.size(); j++) {
/*904*/             String uno = this.listaObj.get(k).toString();
/*905*/             String dos = this.workflowObj.get(j).toString();
/*906*/             if (uno.equals(dos)) {
/*907*/                 return j;
/*908*/             }
/*909*/         }
/*910*/         return 0;
/*911*/     }
/*912*/ 
/*913*/     /**
             * Método que recorre la lista completa de workflow
             * para obtener un cliente en particular
             * @param dato
             * @return devuelve el cliente con el dato ingresado como parametro del Método
             */
/*918*/     public Vector getClientesC(String dato) {
/*919*/         Vector clientes = new Vector();
/*920*/         WorkflowDTO wf;
/*921*/         for (int i = 0; i < this.listaCiclosWCompleto.size(); i++) {
/*922*/             wf = (WorkflowDTO) this.listaCiclosWCompleto.get(i);
/*923*/             String dato2 = wf.getIdNom() + ": " + wf.getEtiqueta();
/*924*/             if (dato.equals(dato2)) {
/*925*/                 return this.getClientesCiclo(wf.getId());
/*926*/             }
/*927*/         }
/*928*/         return clientes;
/*929*/     }
/*930*/ 
/*931*/     /**
             * Método que recorre la lista completa de workflow para obtener
             * un realizador con un dato en particular 
             * @param dato
             * @return devuelve los realizadores
             */
/*936*/     public Vector getRealizadoresC(String dato) {
/*937*/         Vector realizadores = new Vector();
/*938*/         WorkflowDTO wf;
/*939*/         for (int i = 0; i < this.listaCiclosWCompleto.size(); i++) {
/*940*/             wf = (WorkflowDTO) this.listaCiclosWCompleto.get(i);
/*941*/             String dato2 = wf.getIdNom() + ": " + wf.getEtiqueta();
/*942*/             if (dato.equals(dato2)) {
/*943*/                 return this.getRealizadoresCiclo(wf.getId());
/*944*/             }
/*945*/         }
/*946*/         return realizadores;
/*947*/     }
/*948*/ 
/*949*/     /**
             * Método que revisa si un string en particular se encuentra en una lista
             * @param nuevo
             * @param lista
             * @return un entero 1 para decir que se encuentra en la lista
             */
/*955*/     public int estaLista(String nuevo, Vector lista) {
/*956*/         int esta = 0;
/*957*/         //System.out.println("Lista esta: "+lista);
/*958*/         for (int i = 0; i < lista.size(); i++) {
/*959*/             String c = lista.get(i).toString();
/*960*/             if (c.equals(nuevo)) {
/*961*/                 esta = 1;
/*962*/             }
/*963*/         }
/*964*/         return esta;
/*965*/     }
/*966*/ 
/*967*/     //
/*968*/     /**
             * Método para obtener pre-condiciones del mapa conversacional
             * @return vector preCondiciones
             */
/*972*/     public Vector getPreCondiciones() {
/*973*/         Vector workflow = this.listaObjWork;
/*974*/         Vector preCondiciones = new Vector();
/*975*/         for (int i = 0; i < workflow.size(); i++) {
/*976*/             Vector v = (Vector) workflow.get(i);
/*977*/             //System.out.println("Ciclo: "+v);
/*978*/             Vector condiciones = new Vector();
/*979*/             for (int j = 0; j < v.size(); j++) {
/*980*/                 String ciclo = v.get(j).toString();
/*981*/                 //System.out.println(ciclo+this.idCiclo(ciclo));
/*982*/                 buscarPertenencia(this.idCiclo(ciclo), condiciones);
/*983*/             }
/*984*/             preCondiciones.add(condiciones);
/*985*/         }
/*986*/         //System.out.println(preCondiciones);
/*987*/         return preCondiciones;
/*988*/     }
/*989*/ 
/*990*/     //
/*991*/     /**
             * Método para buscar un identificador id Ciclo en las pertenencias asociadas a un ciclo
             * @param idCiclo
             * @param condiciones
             */
/*996*/     public void buscarPertenencia(int idCiclo, Vector condiciones) {
/*997*/         Vector enlaces = this.mapaC.getPertenencias();
/*998*/         WorkflowDTO wf;
/*999*/         for (int i = 0; i < enlaces.size(); i++) {
/*1000*/             PertenenciaDTO p = (PertenenciaDTO) enlaces.get(i);
/*1001*/             if (idCiclo == p.getOrigen()) {
/*1002*/                 wf = this.getWorkflow(p.getDestino());
/*1003*/                 if (wf.getTipo().equals("controlOr")) {
/*1004*/                     //System.out.println("controlOr: "+wf.getIdNom()+":"+wf.getEtiqueta());
/*1005*/                     //si no esta en el vector condiciones
/*1006*/ 
/*1007*/                     if (this.estaWorkflow(wf, condiciones) == 0) {
/*1008*/                         condiciones.add(wf);
/*1009*/                     }
/*1010*/ 
/*1011*/                 }
/*1012*/                 if (wf.getTipo().equals("controlAnd")) {
/*1013*/                     //En el caso de ser controlesAnd se debe buscar en los ciclos anteriores y posteriores a estos
/*1014*/                     buscarPertenencia(wf.getId(), condiciones);
/*1015*/                 }
/*1016*/             }
/*1017*/             if (idCiclo == p.getDestino()) {
/*1018*/                 wf = this.getWorkflow(p.getOrigen());
/*1019*/                 if (wf.getTipo().equals("controlOr")) {
/*1020*/                     //System.out.println("controlOr: "+wf.getIdNom()+":"+wf.getEtiqueta());
/*1021*/                     //si no esta en el vector condiciones
/*1022*/                     if (this.estaWorkflow(wf, condiciones) == 0) {
/*1023*/                         condiciones.add(wf);
/*1024*/                     }
/*1025*/                 }
/*1026*/                 if (wf.getTipo().endsWith("controlAnd")) {
/*1027*/                     buscarPertenencia(wf.getId(), condiciones);
/*1028*/                 }
/*1029*/             }
/*1030*/         }
/*1031*/     }
/*1032*/ 
/*1033*/     //
/*1034*/     /**
              * Método para revisar si un workflow ya esta en un vector de workflows
              * @param nuevo
              * @param lista
              * @return devuelve "1" si se encuentra
              */
/*1040*/     public int estaWorkflow(WorkflowDTO nuevo, Vector lista) {
/*1041*/         int esta = 0;
/*1042*/         for (int i = 0; i < lista.size(); i++) {
/*1043*/             if (lista.get(i) != null) {
/*1044*/                 WorkflowDTO wf = (WorkflowDTO) lista.get(i);
/*1045*/                 if (wf.equals(nuevo)) {
/*1046*/                     esta = 1;
/*1047*/                 }
/*1048*/             }
/*1049*/         }
/*1050*/         return esta;
/*1051*/     }
/*1052*/ 
/*1053*/     //
/*1054*/     /**
              * Método para obtener el workflow asociado a un id
              * @param idCiclo
              * @return
              */
/*1059*/     public WorkflowDTO getWorkflow(int idCiclo) {
/*1060*/         WorkflowDTO wf = null;
/*1061*/         for (int i = 0; i < this.listaCiclosWCompleto.size(); i++) {
/*1062*/             wf = (WorkflowDTO) this.listaCiclosWCompleto.get(i);
/*1063*/             if (idCiclo == wf.getId()) {
/*1064*/                 return wf;
/*1065*/             }
/*1066*/         }
/*1067*/         return wf;
/*1068*/     }
/*1069*/ 
/*1070*/     //
/*1071*/     /**
              * Método para obtener el id de un ciclo asociado a un String
              * @param ciclo
              * @return devuelve un identificador del ciclo
              */
/*1076*/     public int idCiclo(String ciclo) {
/*1077*/         WorkflowDTO wf;
/*1078*/         int idCiclo = 0;
/*1079*/         for (int i = 0; i < this.listaCiclosWCompleto.size(); i++) {
/*1080*/             wf = (WorkflowDTO) this.listaCiclosWCompleto.get(i);
/*1081*/             String ciclo2 = wf.getIdNom() + ": " + wf.getEtiqueta();
/*1082*/             if (ciclo.equals(ciclo2)) {
/*1083*/                 idCiclo = wf.getId();
/*1084*/             }
/*1085*/         }
/*1086*/         return idCiclo;
/*1087*/     }
/*1088*/ 
/*1089*/     /**
              * Método que permite guardar en un vector los datos de: Caso de Uso
              * y su excepcion con su acción alternativa 
              * @return devuelve vector "excepcionYAlternativa" con caso de uso y excepcion alternativa
              */
/*1093*/     public Vector workflowExcepcionAlternativa() {
/*1094*/         Vector excepcionYAlternativa = new Vector();
/*1095*/         Vector datos = new Vector();
/*1096*/         Vector excepciones = this.getCiclosExcepciones();
/*1097*/         for (int i = 0; i < excepciones.size(); i++) {
/*1098*/             Vector v = (Vector) excepciones.get(i);
/*1099*/             datos = new Vector();
/*1100*/             WorkflowDTO w = (WorkflowDTO) v.get(0);
/*1101*/             WorkflowDTO w2 = (WorkflowDTO) v.get(1);
/*1102*/             //System.out.println(obtenerCasoUso(w));
/*1103*/             datos.add(obtenerCasoUso(w));
/*1104*/             //System.out.println(this.obtenerExcepcion(w.getId(), w2.getId()));
/*1105*/             datos.add(this.obtenerExcepcion(w.getId(), w2.getId()));
/*1106*/             //System.out.println(w2.getIdNom()+": "+w2.getEtiqueta());
/*1107*/             datos.add(w2.getIdNom() + ": " + w2.getEtiqueta());
/*1108*/             excepcionYAlternativa.add(datos);
/*1109*/         }
/*1110*/ 
/*1111*/         return excepcionYAlternativa;
/*1112*/     }
/*1113*/ 
/*1114*/     /**
              * Método que permite obtener un caso de uso a partir de una estructura de workflow
              * @param w
              * @return devuelve el caso de uso
              */
/*1119*/     public int obtenerCasoUso(WorkflowDTO w) {
/*1120*/         if (this.getCiclo(w.getId()) == null) {
/*1121*/             if (this.getControlAnd(w.getId()) == null) {
/*1122*/                 if (this.getControlOr(w.getId()) == null) {
/*1123*/                 } else {
/*1124*/                     return buscarCiclo(w.getId());
/*1125*/                 }
/*1126*/ 
/*1127*/             } else {
/*1128*/                 return buscarCiclo(w.getId());
/*1129*/             }
/*1130*/         } else {
/*1131*/             //si es main buscar hacia adelante
/*1132*/             return obtenerPosicion(w.getId());
/*1133*/         }
/*1134*/         return -1;
/*1135*/     }
/*1136*/ 
/*1137*/     /**
              * Método que permite buscar caso de uso en particular (workflow)
              * asociado a un identificador id 
              * @param id
              * @return devuelve el caso de uso buscado
              */
/*1142*/     public int buscarCiclo(int id) {
/*1143*/         Vector p = this.mapaC.getPertenencias();
/*1144*/         for (int i = 0; i < p.size(); i++) {
/*1145*/             PertenenciaDTO per = (PertenenciaDTO) p.get(i);
/*1146*/             if (per.getDestino() == id) {
/*1147*/                 if (this.getCiclo(per.getOrigen()) == null) {
/*1148*/                     buscarCiclo(per.getOrigen());
/*1149*/                 } else {
/*1150*/                     //si es ciclo main buscar hacia adelante
/*1151*/                     if (this.getCiclo(per.getOrigen()).getIdNom().equals("MAIN")) {
/*1152*/                         return buscarCicloAdelante(per.getDestino());
/*1153*/                     } else {
/*1154*/                         return obtenerPosicion(per.getOrigen());
/*1155*/                     }
/*1156*/                 }
/*1157*/             }
/*1158*/         }
/*1159*/         return -1;
/*1160*/     }
/*1161*/ 
/*1162*/     //
/*1163*/     /**
              * Método que permite buscar caso de uso de acuerdo a un id en un vector de
              * pertenencias entre diferentes workflows 
              * @param id
              * @return devuelve Caso de uso buscado
              */
/*1168*/     public int buscarCicloAdelante(int id) {
/*1169*/         Vector p = this.mapaC.getPertenencias();
/*1170*/         for (int i = 0; i < p.size(); i++) {
/*1171*/             PertenenciaDTO per = (PertenenciaDTO) p.get(i);
/*1172*/             if (per.getOrigen() == id) {
/*1173*/                 if (this.getCiclo(per.getDestino()) == null) {
/*1174*/                     buscarCicloAdelante(per.getDestino());
/*1175*/                 } else {
/*1176*/                     return obtenerPosicion(per.getDestino());
/*1177*/                 }
/*1178*/             }
/*1179*/         }
/*1180*/         return -1;
/*1181*/     }
/*1182*/ 
/*1183*/     /**
              * Método que permite obtener la posicion de un caso de uso en un vector
              * @param id
              * @return retorna un entero con la posicion del Caso de uso
              */
/*1188*/     public int obtenerPosicion(int id) {
/*1189*/         Vector wf = this.listaObjWork;
/*1190*/         for (int x = 0; x < wf.size(); x++) {
/*1191*/             Vector v = (Vector) wf.get(x);
/*1192*/             for (int j = 0; j < v.size(); j++) {
/*1193*/                 String ciclo = v.get(j).toString();
/*1194*/                 if (this.idCiclo(ciclo) == id) {
/*1195*/                     System.out.println(ciclo + " " + x);
/*1196*/                     return x;
/*1197*/                 }
/*1198*/             }
/*1199*/         }
/*1200*/         return -1;
/*1201*/     }
/*1202*/ 
/*1203*/     /**
              * Método que busca una excepcion de acuerdo a 2 enteros de entrada de origen y destino
              * @param origen
              * @param destino
              * @return devuelve etiqueta de la excepcion
              */
/*1209*/     public String obtenerExcepcion(int origen, int destino) {
/*1210*/         Vector e = this.mapaC.getExcepciones();
/*1211*/         for (int i = 0; i < e.size(); i++) {
/*1212*/             ExcepcionDTO eDTO = (ExcepcionDTO) e.get(i);
/*1213*/             if (eDTO.getOrigen() == origen) {
/*1214*/                 if (eDTO.getDestino() == destino) {
/*1215*/                     return eDTO.getEtiqueta();
/*1216*/                 }
/*1217*/             }
/*1218*/         }
/*1219*/         return null;
/*1220*/     }
/*1221*/ 
/*1222*/     /**
              *
              * @return devuelve null para la accion alternativa
              */
/*1226*/     public String obtenerAccionAlternativa() {
/*1227*/         return null;
/*1228*/     }
/*1229*/ 
/*1230*/     /**
              * Método que permite verificar en un vector de pertenencias,
              * si las hay o no. 
              * @return devuelve "1" si se encuentra
              */
/*1234*/     public int verificarPertenencias() {
/*1235*/         int esta = 0;
/*1236*/         Vector enlaces = this.mapaC.getPertenencias();
/*1237*/         for (int i = 0; i < enlaces.size(); i++) {
/*1238*/             esta = 0;
/*1239*/             PertenenciaDTO p = (PertenenciaDTO) enlaces.get(i);
/*1240*/             //System.out.println(p);
/*1241*/             if (estaPenC(p.getOrigen()) == 0) {
/*1242*/                 if (estaPenAND(p.getOrigen()) == 0) {
/*1243*/                     if (estaPenOR(p.getOrigen()) == 0) {
/*1244*/                         esta = 1;
/*1245*/                         //System.out.println(esta);
/*1246*/                         break;
/*1247*/                     }
/*1248*/                     //System.out.println("paso AND"+esta);
/*1249*/                 }
/*1250*/                 //System.out.println("paso ciclo"+esta);
/*1251*/             }
/*1252*/ 
/*1253*/             if (estaPenC(p.getDestino()) == 0) {
/*1254*/                 if (estaPenAND(p.getDestino()) == 0) {
/*1255*/                     if (estaPenOR(p.getDestino()) == 0) {
/*1256*/                         esta = 1;
/*1257*/                         //System.out.println(esta);
/*1258*/                         break;
/*1259*/                     }
/*1260*/                     //System.out.println("paso AND"+esta);
/*1261*/                 }
/*1262*/                 //System.out.println("paso ciclo"+esta);
/*1263*/             }
/*1264*/         }
/*1265*/         //System.out.println(esta);
/*1266*/         return esta;
/*1267*/     }
/*1268*/ 
/*1269*/     /**
              * Método que permite buscar si una pertenencia está en un vector de workflows
              * asociada a un entero "p" 
              * @param p
              * @return devuelve "1" si se encuentra
              */
/*1274*/     public int estaPenC(int p) {
/*1275*/         int esta = 0;
/*1276*/         Vector ciclos = this.mapaC.getCiclos();
/*1277*/         for (int j = 0; j < ciclos.size(); j++) {
/*1278*/             CicloDTO c = (CicloDTO) ciclos.get(j);
/*1279*/             if (p == c.getId()) {
/*1280*/                 esta = 1;
/*1281*/                 break;
/*1282*/             }
/*1283*/         }
/*1284*/         return esta;
/*1285*/     }
/*1286*/ 
/*1287*/     /**
              * Método que permite verificar si se encuentra un controlador
              * en particular, asociado a un id=cAnd, en un workflow control And
              * @param cAnd
              * @return devuelve "1" si se encuentra
              */
/*1292*/     public int estaPenAND(int cAnd) {
/*1293*/         int esta = 0;
/*1294*/         Vector controlAND = this.mapaC.getControlesAnd();
/*1295*/         for (int j = 0; j < controlAND.size(); j++) {
/*1296*/             ControlAndDTO c = (ControlAndDTO) controlAND.get(j);
/*1297*/             if (cAnd == c.getId()) {
/*1298*/                 esta = 1;
/*1299*/                 break;
/*1300*/             }
/*1301*/         }
/*1302*/         return esta;
/*1303*/     }
/*1304*/ 
/*1305*/     /**
              * Método que permite verificar si se encuentra un controlador Or
              * en un workflow de controladores or, asociado a un id=cOr             
              * @param cOr
              * @return devuelve "1" si se encuentra
              */
/*1310*/     public int estaPenOR(int cOr) {
/*1311*/         int esta = 0;
/*1312*/         Vector controlOR = this.mapaC.getControlesOr();
/*1313*/         for (int j = 0; j < controlOR.size(); j++) {
/*1314*/             ControlOrDTO c = (ControlOrDTO) controlOR.get(j);
/*1315*/             if (cOr == c.getId()) {
/*1316*/                 esta = 1;
/*1317*/                 break;
/*1318*/             }
/*1319*/         }
/*1320*/         return esta;
/*1321*/     }
/*1322*/ 
/*1323*/     /**
              * Método que se encarga de verificar si las excepciones de los casos de uso,
              * excepciones de los workflow, están.
              * @return devuelve "1" si se encuentra
              */
/*1327*/     public int verificarExcepciones() {
/*1328*/         int esta = 0;
/*1329*/         Vector excepciones = this.mapaC.getExcepciones();
/*1330*/         for (int i = 0; i < excepciones.size(); i++) {
/*1331*/             esta = 0;
/*1332*/             ExcepcionDTO e = (ExcepcionDTO) excepciones.get(i);
/*1333*/             //System.out.println(p);
/*1334*/             if (estaPenC(e.getOrigen()) == 0) {
/*1335*/                 if (estaPenAND(e.getOrigen()) == 0) {
/*1336*/                     if (estaPenOR(e.getOrigen()) == 0) {
/*1337*/                         esta = 1;
/*1338*/                         //System.out.println(esta);
/*1339*/                         break;
/*1340*/                     }
/*1341*/                     //System.out.println("paso AND"+esta);
/*1342*/                 }
/*1343*/                 //System.out.println("paso ciclo"+esta);
/*1344*/             }
/*1345*/ 
/*1346*/             if (estaPenC(e.getDestino()) == 0) {
/*1347*/                 if (estaPenAND(e.getDestino()) == 0) {
/*1348*/                     if (estaPenOR(e.getDestino()) == 0) {
/*1349*/                         esta = 1;
/*1350*/                         //System.out.println(esta);
/*1351*/                         break;
/*1352*/                     }
/*1353*/                     //System.out.println("paso AND"+esta);
/*1354*/                 }
/*1355*/                 //System.out.println("paso ciclo"+esta);
/*1356*/             }
/*1357*/         }
/*1358*/         //System.out.println(esta);
/*1359*/         return esta;
/*1360*/     }
/*1361*/ }
