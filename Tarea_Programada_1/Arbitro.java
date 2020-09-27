
public class Arbitro
{   
    private int cantColores;
    private int tamanoTubo;
    private Computadora computadora;
    private Tablero tablero;
    private int cantidadMovimientos;

    public Arbitro(int cantColores, int tamanoTubo, int cantTubosVacios){
        this.cantColores = cantColores;
        this.tamanoTubo = tamanoTubo;
        this.computadora = new Computadora(cantColores,tamanoTubo);
        this.tablero = new Tablero(cantColores, tamanoTubo, computadora.generarDistribucion(), cantTubosVacios);
    }
    
    public boolean trasvasarBola(int tuboSalida, int tuboEntrada){
        int bola;
        bola = tablero.quitarBola(tuboSalida);
        if (tablero.agregarBola(tuboEntrada, bola)){
            return true;
        }else{
            tablero.agregarBola(tuboSalida, bola);
            return false;
        }
    }
    
    public void agregarTercerTubo(){
    }
    
    public void revisarEstadoJuego(){
    }
}   
