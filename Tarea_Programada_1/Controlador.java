/**
 * Esta clase contiene toda los parametros necesarios para que las otras 
 * clases funcionen de la manera deseada, asi como el metodo para iniciar el
 * progrma.
 * 
 * @author Kenneth Benavides Rojas y Jeremy Calvo Fernández.
 * @version 4/10/2020
 */
public class Controlador
{
    private final String TITULO_VENTANAS = "Ball Sort Puzzle";
    private final String MENSAJE = "Escoja una opción";
    private final String Creditos = "Programa: Ball Sort Puzzle"
    +"\nAutores: Kenneth Benavides Rojas y Jeremy Calvo Fernández."
    + "\nVersion: 4/10/20";
    private final String Ayuda = "Las reglas del juego son simples:"
    + "\n1. Para ganar se ocupa tener todas bolas de un mismo color en un solo tubo."
    + "\n2. Solo se puede poner una bola en un tubo que este vacio o si la bola "
    + "superior del tubo es del mismo color a la que se quiere insertar."
    + "\n3. Si se quiere un tubo extra puede precionar el boton 'Tubo extra' "
    + "pero esto le costara 5 movimientos.";
    private final String[] OPCIONES_INICIAL = {"Jugar", "Creditos", "Ayuda","Salir"}; 
    private final String[] OPCIONES_EN_JUEGO = {"Nuevo juego", "Volver al juego", "Creditos", "Ayuda","Salir"}; 
    private final String[] COLORES = {"RO","AZ","VE","AM","MO"}; 
    private final int TAMANO_TUBO = 4;
    private final int CANT_TUBOS_VACIOS = 3;
    private final int TUBOS_VISIBLES_INICIAL = 7;
    private Interfaz interfaz;
    private Arbitro arbitro;
    private Configuracion configuracion;
    
    /**
     * Crea el objeto, la interfaz y al arbitro.
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
     * Inicia el juego mostrando el menu principal.
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
            }else{
                if (opciones.length==5){
                    opcion--;
                }{
                    switch(opcion){
                        case 0:
                            juegoTerminado=arbitro.jugar();
                            if (juegoTerminado){
                                opciones = OPCIONES_INICIAL;
                            }
                            break;
                            
                        case 1:
                            interfaz.decirMensaje(Creditos);
                            break;
                            
                        case 2:
                            interfaz.decirMensaje(Ayuda);
                            break;
                            
                        
                    }
                    
                }
            }
        }while(opcion != 3);
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
