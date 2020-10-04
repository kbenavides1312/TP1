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
        this.tuboExtraActivo = false;
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
    
    public String identificarBola( int bola){
        String[] COLORES = {"RO","AZ","VE","AM","MO"}; 
        String color;
        color = COLORES[bola];
        return color;
    }
    
    public boolean jugar(){ 
        int tuboSalida;
        int tuboEntrada;
        int bola;
        boolean tuboVacio;
        String color;
        do{
            do{
                tuboVacio=false;
               tuboSalida = this.interfaz.pedirOpcion(this.opciones,
                    ("Escoge el tubo del que vas a tomar una bola.\nMovimientos : "
                    + this.cantMovimientos),
                      this.tablero.toString(cantTubosVisibles), 
                           cantTubosVisibles);            
               if (!tuboExtraActivo && tuboSalida == cantTubosVisibles){
                    this.agregarTuboExtra();
                    tuboExtraActivo = true;
                    tuboVacio = true;
               }else if (tuboSalida != -1){
                   tuboVacio = tablero.verificarVacio(tuboSalida,tuboExtraActivo);
                   if (tuboVacio == true){
                       interfaz.decirMensaje("Tubo vacio!");
                    }
                }
            }while(tuboVacio && tuboSalida != -1);
            if (tuboSalida != -1)
            {
                do{
                    bola = tablero.verBola(tuboSalida);
                    tuboEntrada = this.interfaz.pedirOpcion(this.opciones,
                        ("Escoge el tubo en el que la quieres meter." +
                        "                                           " +
                        "Bola selecionada : "
                        + (color = this.identificarBola(bola))
                        + " del tubo " + (tuboSalida+1) 
                        +"\nMovimientos : "
                        + this.cantMovimientos),
                          this.tablero.toString(cantTubosVisibles), 
                               cantTubosVisibles);
                }while(tuboEntrada!=-1 && tuboEntrada==tuboSalida);
                if (!this.trasvasarBola(tuboSalida, tuboEntrada)){
                    interfaz.decirMensaje("Movimiento invalido!");
                }
            } 
        }while(tuboSalida!=-1 && !tablero.juegoTerminado());
        if (tablero.juegoTerminado()){
            this.interfaz.decirMensaje("Ha ganado en "
                    + cantMovimientos+" movimientos");
            tuboSalida = -1;
            return true;
        }
        return false;
    }
    
    public boolean nuevoJuego(){
        this.tablero = new Tablero(configuracion,
                                    computadora.generarDistribucion());
        this.cantMovimientos = 0;
        this.cantTubosVisibles = configuracion.cantTubosVisibles;
        this.opciones = new String[cantTubosVisibles+1];
        for (int i=0; i<cantTubosVisibles; i++)
        {
            this.opciones[i] = Integer.toString(i+1);
        }
        this.opciones[cantTubosVisibles] = "tubo extra";
        this.tuboExtraActivo = false;
        return this.jugar();
    }
}   
