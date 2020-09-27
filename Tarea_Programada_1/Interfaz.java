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
    
    public void decirMensaje(){
    }
    public void pedirDato(){
    }
    public void confirmarDato(){
    }
    public void perdirOpcion(){
    }
 
}
