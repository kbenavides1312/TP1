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
    private boolean tuboExtraActivo;
    
    public Arbitro(Interfaz interfaz, Configuracion configuracion){
        this.configuracion = configuracion;
        this.cantTubosVisibles = configuracion.cantTubosVisibles;
        this.computadora = new Computadora(configuracion);
        this.tablero = new Tablero(configuracion,
                                    computadora.generarDistribucion());
        this.cantMovimientos = 0;
        this.interfaz = interfaz;
        this.opciones = new String[cantTubosVisibles+1];
        for (int i=0; i<cantTubosVisibles; i++)
        {
            this.opciones[i] = Integer.toString(i+1);
        }
        this.opciones[cantTubosVisibles] = "tubo extra";
    }
    
    public boolean trasvasarBola(int tuboSalida, int tuboEntrada){
        int bola;
        bola = tablero.quitarBola(tuboSalida);
        if (tablero.agregarBolaIniciado(tuboEntrada, bola)){
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
            if (cantTubosVisibles<configuracion.cantTubos){
                this.opciones = new String[cantTubosVisibles+1];
                for (int i=0; i<cantTubosVisibles; i++)
                {
                    this.opciones[i] = Integer.toString(i+1);
                }
                this.opciones[cantTubosVisibles] = "tubo extra";
            }else{
                this.opciones = new String[cantTubosVisibles];
                for (int i=0; i<cantTubosVisibles; i++)
                {
                    this.opciones[i] = Integer.toString(i+1);
                }
            }
            return true;
        }else{
            return false;
        }
    }
    
    public boolean jugar(){
        int tuboSalida;
        int tuboEntrada;
        boolean tuboVacio;
        do{
            do{
               tuboSalida = this.interfaz.pedirOpcion(this.opciones,
                    ("Escoge el tubo del que vas a tomar una bola.\nMovimientos : "
                    + this.cantMovimientos),
                      this.tablero.toString(cantTubosVisibles), 
                           cantTubosVisibles);            
               tuboVacio = tablero.verificarVacio(tuboSalida,tuboExtraActivo);
               if (tuboVacio == true && tuboSalida != -1){
                   interfaz.decirMensaje("Tubo vacio!");
                }
            }while(tuboVacio == true && tuboSalida != -1);
            if (tuboSalida != -1)
            {
                if (tuboSalida == cantTubosVisibles)
                {
                    this.agregarTuboExtra();
                    tuboExtraActivo = true;
                }else{
                    do{
                        tuboEntrada = this.interfaz.pedirOpcion(this.opciones,
                            ("Escoge el tubo en el que la quieres meter.\nMovimientos : "
                            + this.cantMovimientos),
                              this.tablero.toString(cantTubosVisibles), 
                                   cantTubosVisibles);
                    }while(tuboEntrada!=-1 && tuboEntrada==tuboSalida);
                    if (tuboEntrada!=-1)
                    {
                        if (tuboEntrada == cantTubosVisibles)
                        {
                            interfaz.decirMensaje("Movimiento invalido!");
                        }
                        else if (!this.trasvasarBola(tuboSalida,tuboEntrada)){
                            interfaz.decirMensaje("Movimiento invalido!");
                        }
                    }else{
                        tuboSalida=-1;
                    }
                }
            }
            if (tablero.ganar()){
                this.interfaz.decirMensaje("Ha ganado en "
                        + cantMovimientos+" movimientos");
                tuboSalida = -1;
                return true;
            } 
        }while(tuboSalida!=-1);
        return false;
    }
}   
