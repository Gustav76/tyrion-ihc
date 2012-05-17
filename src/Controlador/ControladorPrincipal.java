package Controlador;

import Modelo.ModeloCasoDeUso;
import Modelo.ModeloMapaConversacional;
import Modelo.ModeloObjetivosDelNegocio;
import Vista.VistaPrincipal;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Controlador encargado de gestionar las acciones de las vistas y otros controladores
 * Define las operaciones básicas para el control de todos los otros controladores.
 */
public class ControladorPrincipal {

    private ControladorCargarArchivos controladorCA;
    private ControladorIdentificarCU2 controladorCU2;
    private ControladorObtenerActores controlOA;
    private ControladorPrecondiciones conroladorP;
    private ControladorResumen controladorR;
    private ControladorPostCondiciones controladorPC;
    private ControladorDescripcion1 controladorD1;
    private ControladorDescripcion2 controladorD2;
    private ControladorExcepciones controladorE;
    private ControladorDefinirCasosDeUso controladorDCU;
    private VistaPrincipal vista;
    private ControladorInicio inicio;
    private ControladorIdentificarCU1 controladorCU1;

    /**
     * Constructor de la clase ControladorPrincipal
     */
    public ControladorPrincipal() {
        vista = new VistaPrincipal(this);
        inicio = new ControladorInicio(this);
        vista.getPanel().add(inicio.getVista(), "VInicio");
        vista.setAnteriorEnabled(false);
    }

    public ControladorIdentificarCU1 getControladorCU1() {
        return controladorCU1;
    }

    public ControladorInicio getInicio() {
        return inicio;
    }

    /**
     * Retorna el controlador de carga de archivos
     * @return ControladorCargaArchivos 
     */
    public ControladorCargarArchivos getControladorCA() {
        return controladorCA;
    }

    /**
     * Asigna el valor de controladorCA con el parámetro ingresado
     * @param controladorCA: controlador de carga de archivos ingresado
     */
    public void setControladorCA(ControladorCargarArchivos controladorCA) {
        this.controladorCA = controladorCA;
    }

    /**
     * Retorna un controlador de identificación de caso de uso 1
     * @return controlador de identificación de caso de uso 1
     */
    public ControladorIdentificarCU1 getControladorE1A() {
        return controladorCU1;
    }

    /**
     * Asigna el controlador de casos de uso 1 al valor asignado
     * @param controladorE1A ControladorIdentificarCU1 a asignar
     */
    public void setControladorE1A(ControladorIdentificarCU1 controladorE1A) {
        this.controladorCU1 = controladorE1A;
    }

    /**
     * Retorna la vista principal
     * @return VistaHome actual
     */
    public VistaPrincipal getVista() {
        return vista;
    }

    /**
     * Asigna la vista inicial a la ingresada como parámentro
     * @param vistaH: vista inicial 
     */
    public void setVistaH(VistaPrincipal vistaH) {
        this.vista = vistaH;
    }

    /**
     * Retorna el ControladorIdentificarCU2 instanciado en el objeto actual
     * @return el ControladorIdentificarCU2 actual
     */
    public ControladorIdentificarCU2 getControladorCU2() {
        return controladorCU2;
    }

    /** 
     * Asigna el ControladorIdentificarCU2 al ingresado como parámetro
     * @param controladorCU2 a usar
     */
    public void setControladorCU2(ControladorIdentificarCU2 controladorCU2) {
        this.controladorCU2 = controladorCU2;
    }

    /**
     * Retorna un ControladorObtenerActores actual
     * @return ControladorObtenerActores asociado a la instancia actual
     */
    public ControladorObtenerActores getControlOA() {
        return controlOA;
    }

    /**
     * Asigna un valor de ControladorObtenerActores ingresado por parámetros
     * @param controlOA el valor a ingresar para ControladorObtenerActores
     */
    public void setControlOA(ControladorObtenerActores controlOA) {
        this.controlOA = controlOA;
    }

    /**
     * retorna un valor de ControladorPrecondiciones asociado a la instancia actual
     * @return ControladorPrecondiciones actual
     */
    public ControladorPrecondiciones getConroladorP() {
        return conroladorP;
    }

    /**
     * Asigna un valor de ControladorPrecondiciones ingresaso por parámetro
     * @param conroladorP valor a ingresar para ControladorPrecondiciones
     */
    public void setConroladorP(ControladorPrecondiciones conroladorP) {
        this.conroladorP = conroladorP;
    }

    /**
     * Retorna un ControladorResumen asociado a la instancia actual
     * @return ControladorResumen actual
     */
    public ControladorResumen getControladorR() {
        return controladorR;
    }

    /**
     * Asigna un valor de ControladorResumen ingresado por parámetro
     * @param controladorR el valor a ingresar para ControladorResumen
     */
    public void setControladorR(ControladorResumen controladorR) {
        this.controladorR = controladorR;
    }

    /**
     * Retorna un ControladorPostCondiciones asociado a la instancia actual
     * @return ControladorPostCondiciones actual
     */
    public ControladorPostCondiciones getControladorPC() {
        return controladorPC;
    }

    /**
     * Asigna un valor de ControladorPostCondiciones ingresado por parámetro
     * @param controladorPC ControladorPostCondiciones actual
     */
    public void setControladorPC(ControladorPostCondiciones controladorPC) {
        this.controladorPC = controladorPC;
    }

    /**
     * Retorna una instancia ControladorDescripcion1 asociada a la instancia actual 
     * @return ControladorDescripcion1 actual
     */
    public ControladorDescripcion1 getControladorD1() {
        return controladorD1;
    }

    /**
     * Asigna un valor para ControladorDescripcion1 asignado por parámetros
     * @param controladorD1 a usar
     */
    public void setControladorD1(ControladorDescripcion1 controladorD1) {
        this.controladorD1 = controladorD1;
    }

    /**
     * Retorna un valor para ControladorDescripcion2 asociado a la instancia actual
     * @return ControladorDescripcion2 actual
     */
    public ControladorDescripcion2 getControladorD2() {
        return controladorD2;
    }

    /**
     * Asigna un valor para ControladorDescripcion2 ingresado por parámetros
     * @param controladorD2 ControladorDescripcion2 a usar
     */
    public void setControladorD2(ControladorDescripcion2 controladorD2) {
        this.controladorD2 = controladorD2;
    }

    /**
     * Retorna un ControladorExcepciones asociado a la instancia actual
     * @return ControladorExcepciones actual
     */
    public ControladorExcepciones getControladorE() {
        return controladorE;
    }

    /**
     * Asigna un valor para ControladorExcepciones ingresado por parámetro
     * @param controladorE ControladorExcepciones a usar
     */
    public void setControladorE(ControladorExcepciones controladorE) {
        this.controladorE = controladorE;
    }

    /**
     * Retorna un ControladorDefinirCasosDeUso asociado a la instancia actual
     * @return ControladorDefinirCasosDeUso actual
     */
    public ControladorDefinirCasosDeUso getControladorDCU() {
        return controladorDCU;
    }

    /**
     * Asigna un valor de ControladorDefinirCasosDeUso ingresado por parámetro
     * @param controladorDCU ControladorDefinirCasosDeUso a usar
     */
    public void setControladorDCU(ControladorDefinirCasosDeUso controladorDCU) {
        this.controladorDCU = controladorDCU;
    }

    /**
     * Redirige hacia el controlador de cargar archivos
     */
    public void irControladorCargarArchivos() {
        this.controladorCA = new ControladorCargarArchivos(this);
        this.vista.setVisible(false);
    }

    /**
     * Redirige al controlador para identificar el caso de uso 1
     * @param modeloMC: modelo de mapa conversacional a usar
     * @param modeloON: modelo de objetivos del negocio a usar
     * @param modeloCU: modelo de casos de uso a usar
     */
    public void irControladorIdentificarCU1(ModeloMapaConversacional modeloMC, ModeloObjetivosDelNegocio modeloON, ModeloCasoDeUso modeloCU) {
        if (this.controladorCU1 == null) {
            this.controladorCU1 = new ControladorIdentificarCU1(this, modeloMC, modeloON, modeloCU);
            vista.getPanel().add(controladorCU1.getVista(), "VIdentificarCU1");
            this.controladorCU1.setRows();
            this.controladorCU1.setListWO();
            this.controladorCU1.setListadoSA();
            controladorCU1.activarVista();

        } else {
            this.controladorCU1.irVistaIdentificarCU1();
            vista.getPanel().add(controladorCU1.getVista(), "VIdentificarCU1");
            controladorCU1.activarVista();
        }
    }

    /**
     * Redirige a la vista de identificar caso de uso 1
     */
    public void irVistaIdentificarCU1() {
        this.controladorCU1.irVistaIdentificarCU1();
    }

    /**
     * Redirige al controlador para identificar el caso de uso 2
     * @param modeloMC: modelo de mapa conversacional a usar
     * @param modeloON: modelo de objetivos de negocio a usar
     * @param modeloCU: modelo de casos de uso a usar
     */
    public void irControladorIdentificarCU2(ModeloMapaConversacional modeloMC, ModeloObjetivosDelNegocio modeloON, ModeloCasoDeUso modeloCU) {
        if (this.controladorCU2 == null) {
            this.controladorCU2 = new ControladorIdentificarCU2(this, modeloMC, modeloON, modeloCU);
            vista.getPanel().add(controladorCU2.getVista(), "VIdentificarCU2");
            controladorCU2.setModeloCU(modeloCU);
            controladorCU2.setModeloMC(modeloMC);
            controladorCU2.setModeloON(modeloON);
            controladorCU2.activarVista();
        } else {
            this.controladorCU2.irVistaIdentificarCU2();
            vista.getPanel().add(controladorCU2.getVista(), "VIdentificarCU2");
            controladorCU2.activarVista();
        }
    }

    /**
     * Redirige al controlador de obtener actores
     * @param modeloMC: modelo de mapa conversacional a usar
     * @param modeloON: modelo de objetivos de negocio a usar
     * @param modeloCU: modelo de casos de uso a usar
     */
    public void irControladorObtenerActores(ModeloMapaConversacional modeloMC, ModeloObjetivosDelNegocio modeloON, ModeloCasoDeUso modeloCU) {
        if (this.controlOA == null) {
            //controladorCU2.setNombreCasosUso();
            this.controlOA = new ControladorObtenerActores(this, modeloMC, modeloON, modeloCU);
            vista.getPanel().add(controlOA.getVista(), "VObtenerActores");
            controlOA.activarVista();
        } else {
            this.controlOA.irVistaObtenerACtores();
            vista.getPanel().add(controlOA.getVista(), "VObtenerActores");
            controlOA.activarVista();
        }
    }

    /**
     * Redirige al controlador de precondiciones
     * @param modeloMC: modelo de mapa conversacional a usar
     * @param modeloON: modelo de objetivos de negocio a usar
     * @param modeloCU: modelo de casos de uso a usar
     */
    public void irControladorPrecondiciones(ModeloMapaConversacional modeloMC, ModeloObjetivosDelNegocio modeloON, ModeloCasoDeUso modeloCU) {
        if (this.conroladorP == null) {
            this.conroladorP = new ControladorPrecondiciones(this, modeloMC, modeloON, modeloCU);
            vista.getPanel().add(conroladorP.getVista(), "VPrecondiciones");
            conroladorP.activarVista();
        } else {
            this.conroladorP.irVistaPrecondiciones();
            vista.getPanel().add(conroladorP.getVista(), "VPrecondiciones");
            conroladorP.activarVista();
        }
    }

    /**
     * Redirige al controlador resumen
     * @param modeloMC: modelo de mapa conversacional a usar
     * @param modeloON: modelo de objetivos del negocio a usar
     * @param modeloCU: modelo de casos de uso a usar
     */
    public void irControladorResumen(ModeloMapaConversacional modeloMC, ModeloObjetivosDelNegocio modeloON, ModeloCasoDeUso modeloCU) {
        if (this.controladorR == null) {
            this.controladorR = new ControladorResumen(this, modeloMC, modeloON, modeloCU);
            vista.getPanel().add(controladorR.getVista(), "VResumen");
            controladorR.activarVista();
        } else {
            this.controladorR.irVistaResumen();
            vista.getPanel().add(controladorR.getVista(), "VResumen");
            controladorR.activarVista();
        }
    }

    /**
     * Redirige al controlador de postcondiciones
     * @param modeloMC: modelo de mapa conversacional a usar
     * @param modeloON: modelo de objetivos del negocio a usar
     * @param modeloCU: modelo de casos de uso a usar
     */
    public void irControladorPostCondiciones(ModeloMapaConversacional modeloMC, ModeloObjetivosDelNegocio modeloON, ModeloCasoDeUso modeloCU) {
        if (this.controladorPC == null) {

            this.controladorPC = new ControladorPostCondiciones(this, modeloMC, modeloON, modeloCU);
            vista.getPanel().add(controladorPC.getVista(), "VPostCondiciones");
            controladorPC.activarVista();
        } else {
            this.controladorPC.irVistaPostCondiciones();
            vista.getPanel().add(controladorPC.getVista(), "VPostCondiciones");
            controladorPC.activarVista();
        }
    }

    /**
     * Redirige al controlador de descripción 1
     * @param modeloMC: modelo de mapa conversacional a usar
     * @param modeloON: modelo de objetivos del negocio a usar
     * @param modeloCU: modelo de casos de uso a usar
     */
    public void irControladorDescripcion1(ModeloMapaConversacional modeloMC, ModeloObjetivosDelNegocio modeloON, ModeloCasoDeUso modeloCU) {
        if (this.controladorD1 == null) {
            this.controladorD1 = new ControladorDescripcion1(this, modeloMC, modeloON, modeloCU);
            vista.getPanel().add(controladorD1.getVista(), "VDescripcion1");
            controladorD1.activarVista();
        } else {
            this.controladorD1.irVistaDescripcion1();
            vista.getPanel().add(controladorD1.getVista(), "VDescripcion1");
            controladorD1.activarVista();
        }
    }

    /**
     * Redirige al controlador de descripcipon 2
     * @param modeloMC: modelo de mapa conversacional a usar
     * @param modeloON: modelo de objetivos del negocio a usar
     * @param modeloCU: modelo de casos de uso a usar
     */
    public void irControladorDescripcion2(ModeloMapaConversacional modeloMC, ModeloObjetivosDelNegocio modeloON, ModeloCasoDeUso modeloCU) {
        if (this.controladorD2 == null) {
            this.controladorD2 = new ControladorDescripcion2(this, modeloMC, modeloON, modeloCU);
            vista.getPanel().add(controladorD2.getVista(), "VDescripcion2");
            controladorD2.activarVista();
        } else {
            this.controladorD2.irVistaDescripcion2();
            vista.getPanel().add(controladorD2.getVista(), "VDescripcion2");
            controladorD2.activarVista();
        }
    }

    /**
     * Activa la vista de descripción 2
     */
    public void irVistaDescripcion2() {
        this.controladorD2.irVistaDescripcion22();
    }

    /**
     * Redirige al controlador de excepciones
     * @param modeloMC: modelo de mapa conversacional a usar
     * @param modeloON: modelo de objetivos del negocio a usar
     * @param modeloCU: modelo de casos de uso a usar
     */
    public void irControladorExcepciones(ModeloMapaConversacional modeloMC, ModeloObjetivosDelNegocio modeloON, ModeloCasoDeUso modeloCU) {
        if (this.controladorE == null) {
            this.controladorE = new ControladorExcepciones(this, modeloMC, modeloON, modeloCU);
            vista.getPanel().add(controladorE.getVista(), "VExcepciones");
            controladorE.activarVista();
        } else {
            this.controladorE.irVistaExcepciones();
            vista.getPanel().add(controladorE.getVista(), "VExcepciones");
            controladorE.activarVista();
        }
    }

    /**
     * Redirige al controlador de definir casos de uso
     * @param modeloMC: modelo de mapa conversacional a usar
     * @param modeloON: modelo de objetivos del negocio a usar
     * @param modeloCU: modelo de casos de uso a usar
     */
    public void irControladorDefinirCasosDeUso(ModeloMapaConversacional modeloMC, ModeloObjetivosDelNegocio modeloON, ModeloCasoDeUso modeloCU) {
        if (this.controladorDCU == null) {
            this.controladorDCU = new ControladorDefinirCasosDeUso(this, modeloMC, modeloON, modeloCU);
            vista.getPanel().add(controladorDCU.getVista(), "VDefinirCasosUso");
            controladorDCU.activarVista();
        } else {
            this.controladorDCU.irVistaDefinirCasosDeUso();
            vista.getPanel().add(controladorDCU.getVista(), "VDefinirCasosUso");
            controladorDCU.activarVista();
        }
    }

    public void guardar(int nvista, String ruta) {
        ruta = ruta + (ruta.endsWith(".xml") ? "" : ".xml");
        if (nvista == 3) {
            controladorCU1.archivoSesion(ruta);
        } else if (nvista == 4) {
            controladorCU2.archivoSesion(ruta);
        } else if (nvista == 5) {
            controlOA.archivoSesion(ruta);
        } else if (nvista == 6) {
            conroladorP.archivoSesion(ruta);
        } else if (nvista == 7) {
            controladorR.archivoSesion(ruta);
        } else if (nvista == 8) {
            controladorPC.archivoSesion(ruta);
        } else if (nvista == 9) {
            controladorD1.archivoSesion(ruta);
        } else if (nvista == 10) {
            controladorD2.archivoSesion(ruta);
        } else if (nvista == 11) {
            controladorE.archivoSesion(ruta);
        } else if (nvista == 12) {
            controladorDCU.archivoSesion(ruta);
        }
    }

    /**
     *
     * Redirige al controlador de ir a sesión anterior
     * @param modeloMC: modelo de mapa conversacional a usar
     * @param modeloON: modelo de objetivos del negocio a usar
     * @param modeloCU: modelo de casos de uso a usar
     * @param ventana: código de la ventana a redireccionar 
     */
    public void irSesionAnterior(ModeloMapaConversacional modeloMC, ModeloObjetivosDelNegocio modeloON, ModeloCasoDeUso modeloCU, int ventana) {
        if (ventana == 3) {
            this.getVista().setSA(1);
            this.getVista().setAnteriorEnabled(true);
            VistaPrincipal.setNvista(4);
            this.irControladorIdentificarCU1(modeloMC, modeloON, modeloCU);
        }
        if (ventana == 4) {
            this.getVista().setSA(1);
            this.getVista().setAnteriorEnabled(true);
            VistaPrincipal.setNvista(4);
            this.irControladorIdentificarCU2(modeloMC, modeloON, modeloCU);
        }
        if (ventana == 5) {
            this.getVista().setSA(1);
            this.getVista().setAnteriorEnabled(true);
            VistaPrincipal.setNvista(5);
            this.irControladorObtenerActores(modeloMC, modeloON, modeloCU);
        }
        if (ventana == 6) {
            this.getVista().setSA(1);
            this.getVista().setAnteriorEnabled(true);
            VistaPrincipal.setNvista(6);
            this.irControladorPrecondiciones(modeloMC, modeloON, modeloCU);
        }
        if (ventana == 7) {
            this.getVista().setSA(1);
            this.getVista().setAnteriorEnabled(true);
            VistaPrincipal.setNvista(7);
            this.irControladorResumen(modeloMC, modeloON, modeloCU);
        }
        if (ventana == 8) {
            this.getVista().setSA(1);
            this.getVista().setAnteriorEnabled(true);
            VistaPrincipal.setNvista(8);
            this.irControladorPostCondiciones(modeloMC, modeloON, modeloCU);
        }
        if (ventana == 9) {
            this.getVista().setSA(1);
            this.getVista().setAnteriorEnabled(true);
            VistaPrincipal.setNvista(9);
            this.irControladorDescripcion1(modeloMC, modeloON, modeloCU);
        }
        if (ventana == 10) {
            this.getVista().setSA(1);
            this.getVista().setAnteriorEnabled(true);
            VistaPrincipal.setNvista(10);
            this.irControladorDescripcion2(modeloMC, modeloON, modeloCU);
        }
        if (ventana == 11) {
            this.getVista().setSA(1);
            this.getVista().setAnteriorEnabled(true);
            VistaPrincipal.setNvista(11);
            this.irControladorExcepciones(modeloMC, modeloON, modeloCU);
        }
        if (ventana == 12) {
            this.getVista().setSA(1);
            this.getVista().setAnteriorEnabled(true);
            VistaPrincipal.setNvista(12);
            this.irControladorDefinirCasosDeUso(modeloMC, modeloON, modeloCU);
        }
    }

    public void activarV(int nvista, int nEstado) {
        this.getVista().setTitle("CO2U");
		
		// tag: svizcay problema4 boton siguiente en la ultima etapa
		if (nvista != 12) {
			vista.setSiguienteEnabled(true);
			//vista.setButtonSiguienteVisible(true);
		}
		
        if (nvista == 1) {
            this.vista.setNumeroEstado(2);
            VistaPrincipal.setNvista(2);
            controladorCA = new ControladorCargarArchivos(this);
            vista.getPanel().add(controladorCA.getVista(), "VCargarArchivo");
            this.controladorCA.activarVista();
        } else if (nvista == 2) {
            //Vista posicionado: Cargar archivo
            if (controladorCA.valido) {
                vista.setAnteriorEnabled(true);
                this.vista.setNumeroEstado(3);
                VistaPrincipal.setNvista(3);
                controladorCU1 = new ControladorIdentificarCU1(this, controladorCA.modeloMC, controladorCA.modeloON, controladorCA.modeloCU);
                vista.getPanel().add(controladorCU1.getVista(), "VIdentificarCU1");
                controladorCU1.activarVista();
            } else {
                controladorCA.Alerta("Aun no son cargados los modelos, favor de cargar los modelos antes de continuar");
            }
        } else if (nvista == 3) {
            if (this.getVista().getSA() == 0) {
                if (this.controladorCU1.validarCU1()) {
                    this.vista.setNumeroEstado(4);
                    VistaPrincipal.setNvista(4);
                    this.controladorCU1.setRows();
                    this.controladorCU1.setListWO();
                    this.controladorCU1.setListadoSA();
                    vista.setSiguienteEnabled(true);
                    controladorCU2 = new ControladorIdentificarCU2(this, controladorCU1.modeloMC, controladorCU1.modeloON, controladorCU1.modeloCU);
                    vista.getPanel().add(controladorCU2.getVista(), "VIdentificarCU2");
                    controladorCU2.activarVista();
                } else {
                    this.controladorCU1.Alerta("Todos los workflow deben ser asociados a los objetivos del negocio");
                }
            } else {
                if (this.controladorCU1.validarCU1()) {
                    this.vista.setNumeroEstado(4);
                    VistaPrincipal.setNvista(4);
                    controladorCU1 = new ControladorIdentificarCU1(this, controladorCU1.modeloMC, controladorCU1.modeloON, controladorCU1.modeloCU);
                    this.controladorCU1.setRows();
                    this.controladorCU1.setListWO();
                    this.controladorCU1.setListadoSA();
                    vista.setSiguienteEnabled(true);
                    controladorCU2 = new ControladorIdentificarCU2(this, controladorCU1.modeloMC, controladorCU1.modeloON, controladorCU1.modeloCU);
                    vista.getPanel().add(controladorCU2.getVista(), "VIdentificarCU2");
                    controladorCU2.activarVista();
                } else {
                    this.controladorCU1.Alerta("Debe asociar todos los workflows a objetivos del negocio");
                }
            }
        } else if (nvista == 4) {
            if (this.getVista().getSA() == 0) {
                controladorCU2.Validador();
                if (controladorCU2.valido) {
                    this.vista.setNumeroEstado(5);
                    VistaPrincipal.setNvista(5);
                    controladorCU2.setNombreCasosUso();
                    controlOA = new ControladorObtenerActores(this, controladorCU2.modeloMC, controladorCU2.modeloON, controladorCU2.modeloCU);
                    vista.getPanel().add(controlOA.getVista(), "VObtenerActores");
                    controlOA.activarVista();
                } else {
                    controladorCU2.Alerta("No deben haber celdas vacías. Por favor, rellene todas las celdas!!");
                }
            } else {
                controladorCU2.Validador();
                if (controladorCU2.valido) {
                    this.vista.setNumeroEstado(5);
                    VistaPrincipal.setNvista(5);
                    controladorCU2.setNombreCasosUso();
                    controlOA = new ControladorObtenerActores(this, controladorCU2.modeloMC, controladorCU2.modeloON, controladorCU2.modeloCU);
                    vista.getPanel().add(controlOA.getVista(), "VObtenerActores");
                    controlOA.activarVista();
                } else {
                    controladorCU2.Alerta("No deben haber celdas vacías. Por favor, rellene todas las celdas!!");
                }
            }
        } else if (nvista == 5) { //mostrar los clientes y realizadores de los workflows asociados en la atapa anterior
            if (this.getVista().getSA() == 0) {
                VistaPrincipal.setNvista(6);
                this.vista.setNumeroEstado(6);
                conroladorP = new ControladorPrecondiciones(this, controlOA.modeloMC, controlOA.modeloON, controlOA.modeloCU);
                vista.getPanel().add(conroladorP.getVista(), "VPrecondiciones");
                conroladorP.activarVista();
            } else {
                VistaPrincipal.setNvista(6);
                this.vista.setNumeroEstado(6);
                controladorCU1 = new ControladorIdentificarCU1(this, this.getVista().controlador.modeloMC, this.getVista().controlador.modeloON, this.getVista().controlador.modeloCU);
                this.controladorCU1.setRows();
                this.controladorCU1.setListWO();
                this.controladorCU1.setListadoSA();
                controladorCU2 = new ControladorIdentificarCU2(this, controladorCU1.modeloMC, controladorCU1.modeloON, controladorCU1.modeloCU);
                controladorCU2.setNombreCasosUso();
                controlOA = new ControladorObtenerActores(this, controladorCU2.modeloMC, controladorCU2.modeloON, controladorCU2.modeloCU);
                conroladorP = new ControladorPrecondiciones(this, controlOA.modeloMC, controlOA.modeloON, controlOA.modeloCU);
                vista.getPanel().add(conroladorP.getVista(), "VPrecondiciones");
                conroladorP.activarVista();
            }

        } else if (nvista == 6) {
            if (this.getVista().getSA() == 0) {
                conroladorP.checkValido();
                if (conroladorP.valido) {
                    this.vista.setNumeroEstado(7);
                    VistaPrincipal.setNvista(7);
                    conroladorP.setPrecondicionesCU();
                    controladorR = new ControladorResumen(this, conroladorP.modeloMC, conroladorP.modeloON, conroladorP.modeloCU);
                    vista.getPanel().add(controladorR.getVista(), "VResumen");
                    controladorR.activarVista();
                } else {
                    conroladorP.Alerta("Todas las precondiciones deben ser descritas");
                    vista.recuperarEstado6();
                }
            } else {
                conroladorP.checkValido();
                if (conroladorP.valido) {
                    this.vista.setNumeroEstado(7);
                    VistaPrincipal.setNvista(7);
                    controladorCU1 = new ControladorIdentificarCU1(this, this.getVista().controlador.modeloMC, this.getVista().controlador.modeloON, this.getVista().controlador.modeloCU);
                    this.controladorCU1.setRows();
                    this.controladorCU1.setListWO();
                    this.controladorCU1.setListadoSA();
                    controladorCU2 = new ControladorIdentificarCU2(this, controladorCU1.modeloMC, controladorCU1.modeloON, controladorCU1.modeloCU);
                    controladorCU2.setNombreCasosUso();
                    controlOA = new ControladorObtenerActores(this, controladorCU2.modeloMC, controladorCU2.modeloON, controladorCU2.modeloCU);
                    conroladorP = new ControladorPrecondiciones(this, controlOA.modeloMC, controlOA.modeloON, controlOA.modeloCU);
                    conroladorP.setPrecondicionesCU();
                    controladorR = new ControladorResumen(this, conroladorP.modeloMC, conroladorP.modeloON, conroladorP.modeloCU);
                    vista.getPanel().add(controladorR.getVista(), "VResumen");
                    controladorR.activarVista();
                } else {
                    conroladorP.Alerta("Todas las precondiciones deben ser descritas");
                    vista.recuperarEstado6();
                }
            }
        } else if (nvista == 7) {
            if (this.getVista().getSA() == 0) {
                controladorR.checkValido();
                if (controladorR.valido) {
                    this.vista.setNumeroEstado(8);
                    VistaPrincipal.setNvista(8);
                    controladorR.setResumenCU();
                    controladorPC = new ControladorPostCondiciones(this, controladorR.modeloMC, controladorR.modeloON, conroladorP.modeloCU);
                    vista.getPanel().add(controladorPC.getVista(), "VPostCondiciones");
                    controladorPC.activarVista();
                } else {
                    controladorR.Alerta("Todos los resumenes deben ser descritos");
                }
            } else {
                controladorR.checkValido();
                if (controladorR.valido) {
                    this.vista.setNumeroEstado(8);
                    VistaPrincipal.setNvista(8);
                    controladorCU1 = new ControladorIdentificarCU1(this, this.getVista().controlador.modeloMC, this.getVista().controlador.modeloON, this.getVista().controlador.modeloCU);
                    this.controladorCU1.setRows();
                    this.controladorCU1.setListWO();
                    this.controladorCU1.setListadoSA();
                    controladorCU2 = new ControladorIdentificarCU2(this, controladorCU1.modeloMC, controladorCU1.modeloON, controladorCU1.modeloCU);
                    controladorCU2.setNombreCasosUso();
                    controlOA = new ControladorObtenerActores(this, controladorCU2.modeloMC, controladorCU2.modeloON, controladorCU2.modeloCU);
                    conroladorP = new ControladorPrecondiciones(this, controlOA.modeloMC, controlOA.modeloON, controlOA.modeloCU);
                    conroladorP.setPrecondicionesCU();
                    controladorR = new ControladorResumen(this, controlOA.modeloMC, controlOA.modeloON, controlOA.modeloCU);
                    controladorR.setResumenCU();
                    controladorPC = new ControladorPostCondiciones(this, controladorR.modeloMC, controladorR.modeloON, controladorR.modeloCU);
                    vista.getPanel().add(controladorPC.getVista(), "VPostCondiciones");
                    controladorPC.activarVista();
                } else {
                    controladorR.Alerta("Todos los resumenes deben ser descritos");

                }
            }

        } else if (nvista == 8) {
            if (this.getVista().getSA() == 0) {
                if (this.controladorPC.validarPC()) {
                    //vista.setforwardDisable();
                    this.vista.setNumeroEstado(9);
                    VistaPrincipal.setNvista(9);
                    controladorPC.setPostCondicionesCU();
                    controladorD1 = new ControladorDescripcion1(this, controladorPC.modeloMC, controladorPC.modeloON, controladorPC.modeloCU);
                    vista.getPanel().add(controladorD1.getVista(), "VDescripcion1");
                    controladorD1.activarVista();
                } else {
                    this.controladorPC.Alerta("Todas las postcondiciones deben ser descritas");
                }
            } else {
                if (this.controladorPC.validarPC()) {
                    //vista.setforwardDisable();
                    this.vista.setNumeroEstado(9);
                    VistaPrincipal.setNvista(9);
                    controladorCU1 = new ControladorIdentificarCU1(this, this.getVista().controlador.modeloMC, this.getVista().controlador.modeloON, this.getVista().controlador.modeloCU);
                    this.controladorCU1.setRows();
                    this.controladorCU1.setListWO();
                    this.controladorCU1.setListadoSA();
                    controladorCU2 = new ControladorIdentificarCU2(this, controladorCU1.modeloMC, controladorCU1.modeloON, controladorCU1.modeloCU);
                    controladorCU2.setNombreCasosUso();
                    controlOA = new ControladorObtenerActores(this, controladorCU2.modeloMC, controladorCU2.modeloON, controladorCU2.modeloCU);
                    conroladorP = new ControladorPrecondiciones(this, controlOA.modeloMC, controlOA.modeloON, controlOA.modeloCU);
                    conroladorP.setPrecondicionesCU();
                    controladorR = new ControladorResumen(this, controlOA.modeloMC, controlOA.modeloON, controlOA.modeloCU);
                    controladorR.setResumenCU();
                    controladorPC = new ControladorPostCondiciones(this, controladorR.modeloMC, controladorR.modeloON, controladorR.modeloCU);
                    controladorPC.setPostCondicionesCU();
                    controladorD1 = new ControladorDescripcion1(this, controladorPC.modeloMC, controladorPC.modeloON, controladorPC.modeloCU);
                    vista.getPanel().add(controladorD1.getVista(), "VDescripcion1");
                    controladorD1.activarVista();
                } else {
                    this.controladorPC.Alerta("Todas las postcondiciones deben ser descritas");
                }
            }
        } else if (nvista == 9) {
            if (this.getVista().getSA() == 0) {
                if (controladorD1.getVista().nulos() == 0) {
                    controladorD1.validador();
                    if (controladorD1.valido) {
                        this.vista.setNumeroEstado(10);
                        VistaPrincipal.setNvista(10);
                        controladorD1.setActorCelda();
                        controladorD1.setDatosD2();
                        controladorD1.setActoresCU();
                        controladorD2 = new ControladorDescripcion2(this, controladorD1.modeloMC, controladorD1.modeloON, controladorD1.modeloCU);
                        vista.getPanel().add(controladorD2.getVista(), "VDescripcion2");
                        controladorD2.activarVista();
                    } else {
                        controladorD1.Alerta("Se debe especificar el cliente y realizador para cada tarea");
                    }
                } else {
                    controladorD1.Alerta("Se debe especificar el cliente y realizador para cada tarea");
                }
            } else {
                if (controladorD1.getVista().nulos() == 0) {
                    controladorD1.validador();
                    if (controladorD1.valido) {
                        this.vista.setNumeroEstado(10);
                        VistaPrincipal.setNvista(10);
                        controladorCU1 = new ControladorIdentificarCU1(this, this.getVista().controlador.modeloMC, this.getVista().controlador.modeloON, this.getVista().controlador.modeloCU);
                        this.controladorCU1.setRows();
                        this.controladorCU1.setListWO();
                        this.controladorCU1.setListadoSA();
                        controladorCU2 = new ControladorIdentificarCU2(this, controladorCU1.modeloMC, controladorCU1.modeloON, controladorCU1.modeloCU);
                        controladorCU2.setNombreCasosUso();
                        controlOA = new ControladorObtenerActores(this, controladorCU2.modeloMC, controladorCU2.modeloON, controladorCU2.modeloCU);
                        conroladorP = new ControladorPrecondiciones(this, controlOA.modeloMC, controlOA.modeloON, controlOA.modeloCU);
                        conroladorP.setPrecondicionesCU();
                        controladorR = new ControladorResumen(this, controlOA.modeloMC, controlOA.modeloON, controlOA.modeloCU);
                        controladorR.setResumenCU();
                        controladorPC = new ControladorPostCondiciones(this, controladorR.modeloMC, controladorR.modeloON, controladorR.modeloCU);
                        controladorD1 = new ControladorDescripcion1(this, controladorD1.modeloMC, controladorD1.modeloON, controladorD1.modeloCU);
                        controladorD1.setActorCelda();
                        controladorD1.setDatosD2();
                        controladorD1.setActoresCU();
                        controladorD2 = new ControladorDescripcion2(this, controladorD1.modeloMC, controladorD1.modeloON, controladorD1.modeloCU);
                        vista.getPanel().add(controladorD2.getVista(), "VDescripcion2");
                        controladorD2.activarVista();
                    } else {
                        controladorD1.Alerta("Se debe especificar el cliente y realizador para cada tarea");
                    }
                }
            }
        } else if (nvista == 10) {
            if (this.getVista().getSA() == 0) {
                this.vista.setNumeroEstado(11);
                VistaPrincipal.setNvista(11);
                controladorD2.setDescripcionCU();
                controladorE = new ControladorExcepciones(this, controladorD2.modeloMC, controladorD2.modeloON, controladorD2.modeloCU);
                vista.getPanel().add(controladorE.getVista(), "VExcepciones");
                controladorE.activarVista();
            } else {
                this.vista.setNumeroEstado(11);
                VistaPrincipal.setNvista(11);
                controladorCU1 = new ControladorIdentificarCU1(this, this.getVista().controlador.modeloMC, this.getVista().controlador.modeloON, this.getVista().controlador.modeloCU);
                this.controladorCU1.setRows();
                this.controladorCU1.setListWO();
                this.controladorCU1.setListadoSA();
                controladorCU2 = new ControladorIdentificarCU2(this, controladorCU1.modeloMC, controladorCU1.modeloON, controladorCU1.modeloCU);
                controladorCU2.setNombreCasosUso();
                controlOA = new ControladorObtenerActores(this, controladorCU2.modeloMC, controladorCU2.modeloON, controladorCU2.modeloCU);
                conroladorP = new ControladorPrecondiciones(this, controlOA.modeloMC, controlOA.modeloON, controlOA.modeloCU);
                conroladorP.setPrecondicionesCU();
                controladorR = new ControladorResumen(this, controlOA.modeloMC, controlOA.modeloON, controlOA.modeloCU);
                controladorR.setResumenCU();
                controladorPC = new ControladorPostCondiciones(this, controladorR.modeloMC, controladorR.modeloON, controladorR.modeloCU);
                controladorD1 = new ControladorDescripcion1(this, controladorPC.modeloMC, controladorPC.modeloON, controladorPC.modeloCU); //cambie aca PC por D1 en los parametros
                controladorD1.setActorCelda();
                controladorD1.setDatosD2();
                controladorD1.setActoresCU();
                controladorD2 = new ControladorDescripcion2(this, controladorD1.modeloMC, controladorD1.modeloON, controladorD1.modeloCU);
                controladorD2.setDescripcionCU();
                controladorE = new ControladorExcepciones(this, controladorD2.modeloMC, controladorD2.modeloON, controladorD2.modeloCU);
                vista.getPanel().add(controladorE.getVista(), "VExcepciones");
                controladorE.activarVista();
            }
        } else if (nvista == 11) {
            if (this.getVista().getSA() == 0) {
                this.vista.setNumeroEstado(12);
                VistaPrincipal.setNvista(12);
                controladorE.setExcepciones();
                controladorDCU = new ControladorDefinirCasosDeUso(this, controladorE.modeloMC, controladorD2.modeloON, controladorE.modeloCU);
                vista.getPanel().add(controladorDCU.getVista(), "VDefinirCasosUso");
                controladorDCU.activarVista();
				
				// tag: svizcay problema4 boton siguiente en la ultima etapa
				vista.setSiguienteEnabled(false);
				//vista.setButtonSiguienteVisible(false);
				
            } else {
                this.vista.setNumeroEstado(12);
                VistaPrincipal.setNvista(12);
                controladorCU1 = new ControladorIdentificarCU1(this, this.getVista().controlador.modeloMC, this.getVista().controlador.modeloON, this.getVista().controlador.modeloCU);
                this.controladorCU1.setRows();
                this.controladorCU1.setListWO();
                this.controladorCU1.setListadoSA();
                controladorCU2 = new ControladorIdentificarCU2(this, controladorCU1.modeloMC, controladorCU1.modeloON, controladorCU1.modeloCU);
                controladorCU2.setNombreCasosUso();
                controlOA = new ControladorObtenerActores(this, controladorCU2.modeloMC, controladorCU2.modeloON, controladorCU2.modeloCU);
                conroladorP = new ControladorPrecondiciones(this, controlOA.modeloMC, controlOA.modeloON, controlOA.modeloCU);
                conroladorP.setPrecondicionesCU();
                controladorR = new ControladorResumen(this, controlOA.modeloMC, controlOA.modeloON, controlOA.modeloCU);
                controladorR.setResumenCU();
                controladorPC = new ControladorPostCondiciones(this, controladorR.modeloMC, controladorR.modeloON, controladorR.modeloCU);
                controladorD1 = new ControladorDescripcion1(this, controladorPC.modeloMC, controladorPC.modeloON, controladorPC.modeloCU); //cambio D1 por PC
                controladorD1.setActorCelda();
                controladorD1.setDatosD2();
                controladorD1.setActoresCU();
                controladorD2 = new ControladorDescripcion2(this, controladorD1.modeloMC, controladorD1.modeloON, controladorD1.modeloCU);
                controladorD2.setDescripcionCU();
                controladorE = new ControladorExcepciones(this, controladorE.modeloMC, controladorD2.modeloON, controladorE.modeloCU);
                controladorE.setExcepciones();
                controladorDCU = new ControladorDefinirCasosDeUso(this, controladorE.modeloMC, controladorD2.modeloON, controladorE.modeloCU);
                vista.getPanel().add(controladorDCU.getVista(), "VDefinirCasosUso");
                controladorDCU.activarVista();
            }
        }
    }

    public void reiniciarEstado() {
        /* Inicio implementación botón Nuevo Proyecto */
        vista.setAnteriorEnabled(false);
		
		// tag: svizcay problema4 boton siguiente en la ultima etapa
		vista.setSiguienteEnabled(true);
		//vista.setButtonSiguienteVisible(true);
		
        this.vista.setNumeroEstado(1);
        VistaPrincipal.setNvista(1);
        inicio.activarVista();
        /* Fin implementación botón Nuevo Proyecto */
    }

    public void activarVatras(int nvista, int nEstado) {
		// tag: svizcay problema4 boton siguiente en la ultima etapa
		if (nvista != 12) {
			vista.setSiguienteEnabled(true);
			//vista.setButtonSiguienteVisible(true);
		}
		
        if (nvista == 3) {
            //antes de llamar a JPCargarArchivos se debe advertir que guarde o los pasos realizados en las siguientes vistas se perderan
            //si decide guardar o no guardar e ir atras se carga, si decide cancelar no se carga
            vista.setAnteriorEnabled(false);
            this.vista.setNumeroEstado(2);
            VistaPrincipal.setNvista(2);
            controladorCA = new ControladorCargarArchivos(this);
            vista.getPanel().add(controladorCA.getVista(), "VCargarArchivo");
            this.controladorCA.activarVista();
        } else if (nvista == 4) {
            if (this.getVista().getSA() == 0) {
                this.vista.setNumeroEstado(3);
                VistaPrincipal.setNvista(3);
                controladorCU1 = new ControladorIdentificarCU1(this, controladorCA.modeloMC, controladorCA.modeloON, controladorCA.modeloCU);
                vista.getPanel().add(controladorCU1.getVista(), "VIdentificarCU1");
                controladorCU1.activarVista();
            } else {
                this.vista.setNumeroEstado(3);
                VistaPrincipal.setNvista(3);
                controladorCU1 = new ControladorIdentificarCU1(this, this.getVista().controlador.modeloMC, this.getVista().controlador.modeloON, this.getVista().controlador.modeloCU);
                vista.getPanel().add(controladorCU1.getVista(), "VIdentificarCU1");
                controladorCU1.activarVista();
            }
        } else if (nvista == 5) {
            if (this.getVista().getSA() == 0) {
                this.vista.setNumeroEstado(4);
                VistaPrincipal.setNvista(4);
                this.controladorCU1.setRows();
                this.controladorCU1.setListWO();
                this.controladorCU1.setListadoSA();
                //paso al controlador identificar caso de uso paso 2
                controladorCU2 = new ControladorIdentificarCU2(this, controladorCU1.modeloMC, controladorCU1.modeloON, controladorCU1.modeloCU);
                vista.getPanel().add(controladorCU2.getVista(), "VIdentificarCU2");
                controladorCU2.activarVista();
            } else {
                this.vista.setNumeroEstado(4);
                VistaPrincipal.setNvista(4);
                controladorCU1 = new ControladorIdentificarCU1(this, this.getVista().controlador.modeloMC, this.getVista().controlador.modeloON, this.getVista().controlador.modeloCU);
                this.controladorCU1.setRows();
                this.controladorCU1.setListWO();
                this.controladorCU1.setListadoSA();
                controladorCU2 = new ControladorIdentificarCU2(this, controladorCU1.modeloMC, controladorCU1.modeloON, controladorCU1.modeloCU);
                vista.getPanel().add(controladorCU2.getVista(), "VIdentificarCU2");
                controladorCU2.activarVista();
            }
        } else if (nvista == 6) {
            if (this.getVista().getSA() == 0) {
                this.vista.setNumeroEstado(5);
                VistaPrincipal.setNvista(5);
                controladorCU2.setNombreCasosUso();
                controlOA = new ControladorObtenerActores(this, controladorCU2.modeloMC, controladorCU2.modeloON, controladorCU2.modeloCU);
                vista.getPanel().add(controlOA.getVista(), "VObtenerActores");
                controlOA.activarVista();
            } else {
                this.vista.setNumeroEstado(5);
                VistaPrincipal.setNvista(5);
                controladorCU1 = new ControladorIdentificarCU1(this, this.getVista().controlador.modeloMC, this.getVista().controlador.modeloON, this.getVista().controlador.modeloCU);
                this.controladorCU1.setRows();
                this.controladorCU1.setListWO();
                this.controladorCU1.setListadoSA();
                controladorCU2 = new ControladorIdentificarCU2(this, controladorCU1.modeloMC, controladorCU1.modeloON, controladorCU1.modeloCU);
                controladorCU2.setNombreCasosUso();
                controlOA = new ControladorObtenerActores(this, controladorCU2.modeloMC, controladorCU2.modeloON, controladorCU2.modeloCU);
                vista.getPanel().add(controlOA.getVista(), "VObtenerActores");
                controlOA.activarVista();
            }
        } else if (nvista == 7) {
            if (this.getVista().getSA() == 0) {
                this.vista.setNumeroEstado(6);
                VistaPrincipal.setNvista(6);
                conroladorP = new ControladorPrecondiciones(this, controlOA.modeloMC, controlOA.modeloON, controlOA.modeloCU);
                vista.getPanel().add(conroladorP.getVista(), "VPrecondiciones");
                conroladorP.activarVista();
            } else {
                this.vista.setNumeroEstado(6);
                VistaPrincipal.setNvista(6);
                controladorCU1 = new ControladorIdentificarCU1(this, this.getVista().controlador.modeloMC, this.getVista().controlador.modeloON, this.getVista().controlador.modeloCU);
                this.controladorCU1.setRows();
                this.controladorCU1.setListWO();
                this.controladorCU1.setListadoSA();
                controladorCU2 = new ControladorIdentificarCU2(this, controladorCU1.modeloMC, controladorCU1.modeloON, controladorCU1.modeloCU);
                controladorCU2.setNombreCasosUso();
                controlOA = new ControladorObtenerActores(this, controladorCU2.modeloMC, controladorCU2.modeloON, controladorCU2.modeloCU);
                conroladorP = new ControladorPrecondiciones(this, controlOA.modeloMC, controlOA.modeloON, controlOA.modeloCU);
                vista.getPanel().add(conroladorP.getVista(), "VPrecondiciones");
                conroladorP.activarVista();
            }
        } else if (nvista == 8) {
            if (this.getVista().getSA() == 0) {
                this.vista.setNumeroEstado(7);
                VistaPrincipal.setNvista(7);
                conroladorP.setPrecondicionesCU();
                controladorR = new ControladorResumen(this, conroladorP.modeloMC, conroladorP.modeloON, conroladorP.modeloCU);
                vista.getPanel().add(controladorR.getVista(), "VResumen");
                controladorR.activarVista();
            } else {
                this.vista.setNumeroEstado(7);
                VistaPrincipal.setNvista(7);
                controladorCU1 = new ControladorIdentificarCU1(this, this.getVista().controlador.modeloMC, this.getVista().controlador.modeloON, this.getVista().controlador.modeloCU);
                this.controladorCU1.setRows();
                this.controladorCU1.setListWO();
                this.controladorCU1.setListadoSA();
                controladorCU2 = new ControladorIdentificarCU2(this, controladorCU1.modeloMC, controladorCU1.modeloON, controladorCU1.modeloCU);
                controladorCU2.setNombreCasosUso();
                controlOA = new ControladorObtenerActores(this, controladorCU2.modeloMC, controladorCU2.modeloON, controladorCU2.modeloCU);
                conroladorP = new ControladorPrecondiciones(this, controlOA.modeloMC, controlOA.modeloON, controlOA.modeloCU);
                conroladorP.setPrecondicionesCU();
                controladorR = new ControladorResumen(this, conroladorP.modeloMC, conroladorP.modeloON, conroladorP.modeloCU);
                vista.getPanel().add(controladorR.getVista(), "VResumen");
                controladorR.activarVista();
            }
        } else if (nvista == 9) {
            if (this.getVista().getSA() == 0) {
                this.vista.setNumeroEstado(8);
                VistaPrincipal.setNvista(8);
                controladorR.setResumenCU();
                controladorPC = new ControladorPostCondiciones(this, controladorR.modeloMC, controladorR.modeloON, controladorR.modeloCU);
                vista.getPanel().add(controladorPC.getVista(), "VPostCondiciones");
                controladorPC.activarVista();
            } else {
                this.vista.setNumeroEstado(8);
                VistaPrincipal.setNvista(8);
                controladorCU1 = new ControladorIdentificarCU1(this, this.getVista().controlador.modeloMC, this.getVista().controlador.modeloON, this.getVista().controlador.modeloCU);
                this.controladorCU1.setRows();
                this.controladorCU1.setListWO();
                this.controladorCU1.setListadoSA();
                controladorCU2 = new ControladorIdentificarCU2(this, controladorCU1.modeloMC, controladorCU1.modeloON, controladorCU1.modeloCU);
                controladorCU2.setNombreCasosUso();
                controlOA = new ControladorObtenerActores(this, controladorCU2.modeloMC, controladorCU2.modeloON, controladorCU2.modeloCU);
                conroladorP = new ControladorPrecondiciones(this, controlOA.modeloMC, controlOA.modeloON, controlOA.modeloCU);
                conroladorP.setPrecondicionesCU();
                controladorR = new ControladorResumen(this, conroladorP.modeloMC, conroladorP.modeloON, conroladorP.modeloCU);
                controladorR.setResumenCU();
                controladorPC = new ControladorPostCondiciones(this, controladorR.modeloMC, controladorR.modeloON, controladorR.modeloCU);
                vista.getPanel().add(controladorPC.getVista(), "VPostCondiciones");
                controladorPC.activarVista();
            }
        } else if (nvista == 10) {
            if (this.getVista().getSA() == 0) {
                this.vista.setNumeroEstado(9);
                VistaPrincipal.setNvista(9);
                controladorPC.setPostCondicionesCU();
                controladorD1 = new ControladorDescripcion1(this, controladorPC.modeloMC, controladorPC.modeloON, controladorPC.modeloCU);
                vista.getPanel().add(controladorD1.getVista(), "VDescripcion1");
                controladorD1.activarVista();
            } else {
                this.vista.setNumeroEstado(9);
                VistaPrincipal.setNvista(9);
                controladorCU1 = new ControladorIdentificarCU1(this, this.getVista().controlador.modeloMC, this.getVista().controlador.modeloON, this.getVista().controlador.modeloCU);
                this.controladorCU1.setRows();
                this.controladorCU1.setListWO();
                this.controladorCU1.setListadoSA();
                controladorCU2 = new ControladorIdentificarCU2(this, controladorCU1.modeloMC, controladorCU1.modeloON, controladorCU1.modeloCU);
                controladorCU2.setNombreCasosUso();
                controlOA = new ControladorObtenerActores(this, controladorCU2.modeloMC, controladorCU2.modeloON, controladorCU2.modeloCU);
                conroladorP = new ControladorPrecondiciones(this, controlOA.modeloMC, controlOA.modeloON, controlOA.modeloCU);
                conroladorP.setPrecondicionesCU();
                controladorR = new ControladorResumen(this, conroladorP.modeloMC, conroladorP.modeloON, conroladorP.modeloCU);
                controladorR.setResumenCU();
                controladorPC = new ControladorPostCondiciones(this, controladorR.modeloMC, controladorR.modeloON, controladorR.modeloCU);
                controladorPC.setPostCondicionesCU();
                controladorD1 = new ControladorDescripcion1(this, controladorPC.modeloMC, controladorPC.modeloON, controladorPC.modeloCU);
                vista.getPanel().add(controladorD1.getVista(), "VDescripcion1");
                controladorD1.activarVista();
            }
        } else if (nvista == 11) {
            if (this.getVista().getSA() == 0) {
                this.vista.setNumeroEstado(10);
                VistaPrincipal.setNvista(10);
                controladorD1.setActorCelda();
                controladorD1.setDatosD2();
                controladorD1.setActoresCU();
                controladorD2 = new ControladorDescripcion2(this, controladorD1.modeloMC, controladorD1.modeloON, controladorD1.modeloCU);
                vista.getPanel().add(controladorD2.getVista(), "VDescripcion2");
                controladorD2.activarVista();
            } else {
                this.vista.setNumeroEstado(10);
                VistaPrincipal.setNvista(10);
                controladorCU1 = new ControladorIdentificarCU1(this, this.getVista().controlador.modeloMC, this.getVista().controlador.modeloON, this.getVista().controlador.modeloCU);
                this.controladorCU1.setRows();
                this.controladorCU1.setListWO();
                this.controladorCU1.setListadoSA();
                controladorCU2 = new ControladorIdentificarCU2(this, controladorCU1.modeloMC, controladorCU1.modeloON, controladorCU1.modeloCU);
                controladorCU2.setNombreCasosUso();
                controlOA = new ControladorObtenerActores(this, controladorCU2.modeloMC, controladorCU2.modeloON, controladorCU2.modeloCU);
                conroladorP = new ControladorPrecondiciones(this, controlOA.modeloMC, controlOA.modeloON, controlOA.modeloCU);
                conroladorP.setPrecondicionesCU();
                controladorR = new ControladorResumen(this, conroladorP.modeloMC, conroladorP.modeloON, conroladorP.modeloCU);
                controladorR.setResumenCU();
                controladorPC = new ControladorPostCondiciones(this, controladorR.modeloMC, controladorR.modeloON, controladorR.modeloCU);
                controladorPC.setPostCondicionesCU();
                controladorD1 = new ControladorDescripcion1(this, controladorPC.modeloMC, controladorPC.modeloON, controladorPC.modeloCU);
                controladorD1.setActorCelda();
                controladorD1.setDatosD2();
                controladorD1.setActoresCU();
                controladorD2 = new ControladorDescripcion2(this, controladorD1.modeloMC, controladorD1.modeloON, controladorD1.modeloCU);
                vista.getPanel().add(controladorD2.getVista(), "VDescripcion2");
                controladorD2.activarVista();
            }
        } else if (nvista == 12) {
            if (this.getVista().getSA() == 0) {
                this.vista.setNumeroEstado(11);
                VistaPrincipal.setNvista(11);
                controladorD2.setDescripcionCU();
                controladorE = new ControladorExcepciones(this, controladorD2.modeloMC, controladorD2.modeloON, controladorD2.modeloCU);
                vista.getPanel().add(controladorE.getVista(), "VExcepciones");
                controladorE.activarVista();
            } else {
                this.vista.setNumeroEstado(11);
                VistaPrincipal.setNvista(11);
                controladorCU1 = new ControladorIdentificarCU1(this, this.getVista().controlador.modeloMC, this.getVista().controlador.modeloON, this.getVista().controlador.modeloCU);
                this.controladorCU1.setRows();
                this.controladorCU1.setListWO();
                this.controladorCU1.setListadoSA();
                controladorCU2 = new ControladorIdentificarCU2(this, controladorCU1.modeloMC, controladorCU1.modeloON, controladorCU1.modeloCU);
                controladorCU2.setNombreCasosUso();
                controlOA = new ControladorObtenerActores(this, controladorCU2.modeloMC, controladorCU2.modeloON, controladorCU2.modeloCU);
                conroladorP = new ControladorPrecondiciones(this, controlOA.modeloMC, controlOA.modeloON, controlOA.modeloCU);
                conroladorP.setPrecondicionesCU();
                controladorR = new ControladorResumen(this, conroladorP.modeloMC, conroladorP.modeloON, conroladorP.modeloCU);
                controladorR.setResumenCU();
                controladorPC = new ControladorPostCondiciones(this, controladorR.modeloMC, controladorR.modeloON, controladorR.modeloCU);
                controladorPC.setPostCondicionesCU();
                controladorD1 = new ControladorDescripcion1(this, controladorPC.modeloMC, controladorPC.modeloON, controladorPC.modeloCU);
                controladorD1.setActorCelda();
                controladorD1.setDatosD2();
                controladorD1.setActoresCU();
                controladorD2 = new ControladorDescripcion2(this, controladorD1.modeloMC, controladorD1.modeloON, controladorD1.modeloCU);
                controladorD2.setDescripcionCU();
                controladorE = new ControladorExcepciones(this, controladorD2.modeloMC, controladorD2.modeloON, controladorD2.modeloCU);
                vista.getPanel().add(controladorE.getVista(), "VExcepciones");
                vista.setSiguienteEnabled(true);
                controladorE.activarVista();
            }
        }
    }

    /**
     * Método principal
     * @param args: argumentos de llamado de main
     */
    public static void main(String[] args) {
        final ControladorPrincipal control = new ControladorPrincipal();
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            java.awt.EventQueue.invokeLater(new Runnable() {

                public void run() {
                    VistaPrincipal.setDefaultLookAndFeelDecorated(true);
                    control.getVista().setExtendedState(JFrame.MAXIMIZED_BOTH);
                    control.getVista().setVisible(true);

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            control.getVista().setVisible(true);
        }
    }
}
