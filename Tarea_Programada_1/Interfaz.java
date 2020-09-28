import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class Interfaz extends JOptionPane
{
    private String TITULO;
    private ImageIcon IMAGEN;
    
    
    /**
     * Crea el objeto, el titulo y la imagen que seran usadas en ventanas
     * 
     * @param elTitulo El itulo de ventanas.
     */
    public Interfaz(String elTitulo)
    {
        TITULO = elTitulo;
    }
    
    
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
    public void decirMensaje(String mensaje)
    {
        this.showMessageDialog(null, mensaje, TITULO, PLAIN_MESSAGE, IMAGEN);
    }
    
    /**
     * Pide al usuario insertar un dato por medio del teclado
     * 
     * @param mensaje El mensaje mostrado al usuario en la interaccion.
     * @return La hilera insertada por el usuario.
     */
    public String pedirDato(String mensaje)
    {
        String resultado;
        resultado = this.showInputDialog(null, mensaje, TITULO, PLAIN_MESSAGE);
        return resultado;
    }
    
    /**
     * Confirma con el usuario la opcion que ha tomado
     * 
     * @param mensaje El mensaje mostrado al usuario en la interaccion.
     * @return La opcion seleccionada.
     */
    public int confirmarDato(String mensaje)
    {
        int resultado;
        resultado = this.showConfirmDialog(null, mensaje, TITULO, OK_CANCEL_OPTION);
        return resultado;
    }
    
    /**
     * Pide al usuario elegir entre un conjunto de opciones
     * 
     * @param opciones Las opciones entre las cuales el usuario debe elegir.
     * @param mensaje El mensaje mostrado al usuario en la interaccion.
     * @return La opcion seleccionada.
     */
    public int pedirOpcion(String[] opciones, String mensaje)
    {
        int resultado;
        resultado = this.showOptionDialog(null, mensaje, TITULO, 
                                    DEFAULT_OPTION, PLAIN_MESSAGE, 
                                    IMAGEN, opciones, null);
        return resultado;
    }
    
    /**
     * Pide al usuario elegir entre un conjunto de opciones
     * 
     * @param opciones Las opciones entre las cuales el usuario debe elegir.
     * @param mensaje El mensaje mostrado al usuario en la interaccion.
     * @param datosTabla Datos en formato de tabla
     * @return La opcion seleccionada.
     */
    public int pedirOpcion(String[] opciones, String mensaje, String datosTabla, int cantColumnas)
    {
        int resultado;
        JTextArea tabla= new JTextArea(mensaje+"\n\n");
        tabla.setEditable(false);
        tabla.setOpaque(false);
        tabla.setColumns(cantColumnas);
        tabla.append(datosTabla);
        resultado = this.showOptionDialog(null, tabla,  TITULO, 
                                    DEFAULT_OPTION, PLAIN_MESSAGE, 
                                    IMAGEN, opciones, null);
        return resultado;
    }
 
}
