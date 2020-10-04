public class Controlador
{
    private final String TITULO_VENTANAS = "Ball Sort Puzzle";
    private final String MENSAJE = "Escoja una opción";
    private final String[] OPCIONES_INICIAL = {"Jugar", "Salir"}; 
    private final String[] OPCIONES_EN_JUEGO = {"Nuevo juego", "Volver al juego", "Salir"}; 
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
    
    /**
     * Interactua con el usuario usando el menu principal
     * 
     */
    public void iniciar(){
        int opcion;
        boolean juegoTerminado;
        String[] opciones;
        opciones = OPCIONES_INICIAL;
        do {
            opcion = interfaz.pedirOpcion(opciones, MENSAJE);
            if (opcion==0) {
                    juegoTerminado = arbitro.nuevoJuego();
                    if (!juegoTerminado){
                        opciones = OPCIONES_EN_JUEGO;
                    }
            }else if (opciones.length==3 && opcion==1){
                    juegoTerminado=arbitro.jugar();
                    if (juegoTerminado){
                        opciones = OPCIONES_INICIAL;
                    }
            }
            
        }while(opcion != opciones.length-1);
    }
    
    /**
     * Funcion main
     * 
     */
    public void main(String[] parametros){
        Controlador controlador;
        controlador = new Controlador();
        controlador.iniciar();
    }
    
    
    

}
