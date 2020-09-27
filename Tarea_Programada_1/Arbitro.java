
public class Arbitro
{   
    private int cantColores;
    private int cantTubos;
    private int tamanoTubo;
    private int movimientos;
    private int tubosVisibles;
    private Computadora computadora;
    private Tablero tablero;
    private int cantidadMovimientos;

    public Arbitro(int cantColores, int tamanoTubo, int cantTubosVacios, int tubosVisibles){
        this.cantTubos = cantColores+cantTubosVacios;
        this.cantColores = cantColores;
        this.tamanoTubo = tamanoTubo;
        this.computadora = new Computadora(cantColores,tamanoTubo);
        this.tablero = new Tablero(cantColores, tamanoTubo, computadora.generarDistribucion(), cantTubosVacios);
        this.movimientos = 0;
        this.tubosVisibles = tubosVisibles;
    }
    
    public boolean trasvasarBola(int tuboSalida, int tuboEntrada){
        int bola;
        bola = tablero.quitarBola(tuboSalida);
        if (tablero.agregarBola(tuboEntrada, bola)){
            this.movimientos++;
            return true;
        }else{
            tablero.agregarBola(tuboSalida, bola);
            return false;
        }
    }
    
    public boolean agregarTuboExtra(){
        if (tubosVisibles<cantTubos){
            this.movimientos += 5;
            this.tubosVisibles++;
            return true;
        }else{
            return false;
        }
    }
    
    public void revisarEstadoJuego(){
    }
}   
