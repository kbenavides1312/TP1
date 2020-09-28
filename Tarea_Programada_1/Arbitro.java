import java.util.Arrays;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
        
public class Arbitro
{   
    private Configuracion configuracion;
    private Interfaz interfaz;
    private Computadora computadora;
    private Tablero tablero;
    private int cantTubosVisibles;
    private int cantMovimientos;
    private String[] opciones;

    public Arbitro(Interfaz interfaz, Configuracion configuracion){
        this.configuracion = configuracion;
        this.cantTubosVisibles = configuracion.cantTubosVisibles;
        this.computadora = new Computadora(configuracion);
        this.tablero = new Tablero(configuracion,
                                    computadora.generarDistribucion());
        this.cantMovimientos = 0;
        this.interfaz = interfaz;
        this.opciones = new String[cantTubosVisibles];
        for (int i=0; i<cantTubosVisibles; i++)
        {
            this.opciones[i] = Integer.toString(i+1);
        }
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
    
    public void jugar(){
        int tuboSalida;
        int tuboEntrada;
        do{
            tuboSalida = this.interfaz.pedirOpcion(this.opciones,
                        "Escoge el tubo del que vas a tomar una bola",
                        this.tablero.toString(cantTubosVisibles), 
                        cantTubosVisibles);
            if (tuboSalida != -1)
            {
                do{
                    tuboEntrada = this.interfaz.pedirOpcion(this.opciones,
                            "Escoge el tubo en el que la quieres meter",
                            this.tablero.toString(cantTubosVisibles), 
                            cantTubosVisibles);
                }while(tuboEntrada!=-1 && tuboEntrada==tuboSalida);
                if (tuboEntrada!=-1)
                {
                    if (!this.trasvasarBola(tuboSalida,tuboEntrada)){
                        interfaz.decirMensaje("Movimiento invalido!");
                    }
                }else{
                    tuboSalida=-1;
                }
            }
        }while(tuboSalida!=-1);
    }
    
    public void revisarEstadoJuego(){
    }
}   
