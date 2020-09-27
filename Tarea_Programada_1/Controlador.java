public class Controlador
{
    private final String TITULO_VENTANAS = "Ball Sort Puzzle";
    private final String MENSAJE = "Escoja una opción";
    private final String[] OPCIONES = {"Jugar", "Salir"}; 
    private final String[] COLORES = {"RO","AZ","VE","AM","MO"}; 
    private final int TAMANO_TUBO = 4;
    private final int CANT_TUBOS_VACIOS = 3;
    private final int TUBOS_VISIBLES_INICIAL = 7;
    private Interfaz interfaz;
    private Arbitro arbitro;
    private Configuracion configuracion;
    
    /**
     * Crea el objeto, la interfaz y al arbitro
     * 
     */
    public Controlador(){
        interfaz = new Interfaz(TITULO_VENTANAS);
        configuracion = new Configuracion(COLORES,
                                    TAMANO_TUBO,
                                    CANT_TUBOS_VACIOS,
                                    TUBOS_VISIBLES_INICIAL);
        arbitro = new Arbitro(interfaz, configuracion);
        
    }
    
    private void interfaz(){
    }
    private void tablero(){
    }
    public void iniciar(){
    }
    public void main(){
    }
    

}
