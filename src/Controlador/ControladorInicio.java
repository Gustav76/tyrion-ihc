/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*1*/ package Controlador;
/*2*/  import Controlador.*;
/*3*/ import Modelo.ModeloCasoDeUso; //sadads
/*4*/ import Modelo.ModeloMapaConversacional;
/*5*/ import Modelo.ModeloObjetivosDelNegocio;
/*6*/ import Modelo.ModeloSesion;
import Vista.JPCargarArchivos;
import java.awt.CardLayout;
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
import Vista.JPInicio;
import Controlador.ControladorPrincipal;
import javax.swing.JOptionPane;
/**
 *
 * @author Rodrigo
 */
public class ControladorInicio {
    
    private JPInicio vista; 
    private ControladorPrincipal control;
    


public ControladorInicio(ControladorPrincipal control){
    this.control=control;
    this.control.getVista().setTitle("CO2U");  
    vista = new JPInicio(this);
}


public void activarVista() {
    ((CardLayout)control.getVista().getPanel().getLayout()).show(control.getVista().getPanel(),"VInicio");
}
public JPInicio getVista() {
    return vista;
}


            public void Alerta(String mensaje)
            {
                vista.alerta(mensaje);
            }
}
