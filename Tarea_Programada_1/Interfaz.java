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
    
    /**
     * Pide al usuario insertar un dato por medio del teclado
     * 
     * @param elMensaje El mensaje mostrado al usuario en la interaccion.
     * @return La hilera insertada por el usuario.
     */
    public String pedirDato(String elMensaje)
    {
        String resultado;
        resultado = this.showInputDialog(null, elMensaje, TITULO, PLAIN_MESSAGE);
        return resultado;
    }
    
    /**
     * Confirma con el usuario la opcion que ha tomado
     * 
     * @param elMensaje El mensaje mostrado al usuario en la interaccion.
     * @return La opcion seleccionada.
     */
    public int confirmarDato(String elMensaje)
    {
        int resultado;
        resultado = this.showConfirmDialog(null, elMensaje, TITULO, OK_CANCEL_OPTION);
        return resultado;
    }
    
    /**
     * Pide al usuario elegir entre un conjunto de opciones
     * 
     * @param lasOpciones Las opciones entre las cuales el usuario debe elegir.
     * @param elMensaje El mensaje mostrado al usuario en la interaccion.
     * @return La opcion seleccionada.
     */
    public int perdirOpcion(String[] lasOpciones, String elMensaje)
    {
        int resultado;
        resultado = this.showOptionDialog(null, elMensaje, TITULO, DEFAULT_OPTION, PLAIN_MESSAGE, IMAGEN, lasOpciones, null);
        return resultado;
    }
 
}
