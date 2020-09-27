import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Interfaz extends JOptionPane
{
    private String TITULO;
    private ImageIcon IMAGEN;
    
    /**
     * Crea el objeto, el titulo y la imagen que seran usadas en ventanas
     * 
     * @param elTitulo El itulo de ventanas.
     * @param nombreArchivoImagen El nombre del archivo de imagen.
     */
    public Interfaz(String elTitulo, String nombreArchivoImagen)
    {
        TITULO = elTitulo;
        IMAGEN = new ImageIcon(this.getClass().getResource(nombreArchivoImagen));
    }
    
     /**
     * Muestra un mensaje
     * 
     * @param elMensaje El mensaje mostrado al usuario en la interaccion.
     */
    public void decirMensaje(String elMensaje)
    {
        this.showMessageDialog(null, elMensaje, TITULO, PLAIN_MESSAGE, IMAGEN);
    }
    
    public void pedirDato(){
    }
    public void confirmarDato(){
    }
    public void perdirOpcion(){
    }
 
}
