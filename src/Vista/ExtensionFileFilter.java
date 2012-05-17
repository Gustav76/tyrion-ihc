package Vista;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 * Clase que implementa el filtro para cargar los archivos sólo con la extensión deseada.
 * 
 * 
*/
class ExtensionFileFilter extends FileFilter {
  String description;

  String extensions[];

  /**
   * Constructor de la clase ExtensionFileFilter que agrega una descripción y una extensión al filtro.
   * 
   * @param description Descripción de la extensión que se agrega.
   * @param extension Extensión a agregar.
   */
  public ExtensionFileFilter(String description, String extension) {
    this(description, new String[] { extension });
  }
  
/**
   * Constructor de la clase ExtensionFileFilter que agrega una descripción y una lista de extensión al filtro.
   * 
   * @param description Descripción de las extensiones que se agrega.
   * @param extensions Lista de extensiones a agregar.
   */
  public ExtensionFileFilter(String description, String extensions[]) {
    if (description == null) {
      this.description = extensions[0] + "{ " + extensions.length + "} ";
    } else {
      this.description = description;
    }
    this.extensions = (String[]) extensions.clone();
    toLower(this.extensions);
  }
  
  /**
   * Transpaso a minúsculas:
   * Función que transforma un arreglo a minúsculas.
   * 
   * @param array Arreglo de String a modificar.
   */
  private void toLower(String array[]) {
    for (int i = 0, n = array.length; i < n; i++) {
      array[i] = array[i].toLowerCase();
    }
  }

  /**
   * Obtener Descripción:
   * Getter de la descripción del filtro.
   * 
   * @return String que representa la descripción del filtro.
   */
  public String getDescription() {
    return description;
  }
/**
   * Función que indica si un archivo es aceptado por el filtro o no.
   * 
   * @param file archivo a probar por el filtro.
   * @return boolean uq eindica si se acepta o no el archivo.
   */
  public boolean accept(File file) {
    if (file.isDirectory()) {
      return true;
    } else {
      String path = file.getAbsolutePath().toLowerCase();
      for (int i = 0, n = extensions.length; i < n; i++) {
        String extension = extensions[i];
        if ((path.endsWith(extension) && (path.charAt(path.length() - extension.length() - 1)) == '.')) {
          return true;
        }
      }
    }
    return false;
  }
}