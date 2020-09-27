
public class Arbitro
{   
    private Configuracion configuracion;
    private Interfaz interfaz;
    private Computadora computadora;
    private Tablero tablero;
    private int cantTubosVisibles;
    private int cantMovimientos;

    public Arbitro(Configuracion configuracion){
        this.configuracion = configuracion;
        this.cantTubosVisibles = configuracion.cantTubosVisibles;
        this.computadora = new Computadora(configuracion.cantColores,configuracion.tamanoTubo);
        this.tablero = new Tablero(configuracion,
                                    computadora.generarDistribucion());
        this.cantMovimientos = 0;
        this.interfaz = new Interfaz("");
    }
    
    public boolean trasvasarBola(int tuboSalida, int tuboEntrada){
        int bola;
        bola = tablero.quitarBola(tuboSalida);
        if (tablero.agregarBola(tuboEntrada, bola)){
            this.cantMovimientos++;
            return true;
        }else{
            tablero.agregarBola(tuboSalida, bola);
            return false;
        }
    }
    
    public boolean agregarTuboExtra(){
        if (cantTubosVisibles<configuracion.cantTubos){
            this.cantMovimientos += 5;
            this.cantTubosVisibles++;
            return true;
        }else{
            return false;
        }
    }
    
    public void mostrarTablero(){
        
    }
    
    public void revisarEstadoJuego(){
    }
}   
