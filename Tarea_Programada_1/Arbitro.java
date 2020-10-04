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
        for (int tubo=0; tubo<cantTubosVisibles; tubo++)
        {
            this.opciones[tubo] = Integer.toString(tubo+1);
        }
        this.opciones[cantTubosVisibles] = "tubo extra";
    }
    
    //Este metodo mueve las bolas de un tubo a otro, si es posible
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
    
    //Este metodo agrega el tubo extra, si a si lo quiere el jugador
    public boolean agregarTuboExtra(){
        if (cantTubosVisibles<configuracion.cantTubos){
            this.cantMovimientos += 5;
            this.cantTubosVisibles++;
            if (cantTubosVisibles<configuracion.cantTubos){
                this.opciones = new String[cantTubosVisibles+1];
                for (int tubo=0; tubo<cantTubosVisibles; tubo++)
                {
                    this.opciones[tubo] = Integer.toString(tubo+1);
                }
                this.opciones[cantTubosVisibles] = "tubo extra";
            }else{
                this.opciones = new String[cantTubosVisibles];
                for (int tubo=0; tubo<cantTubosVisibles; tubo++)
                {
                    this.opciones[tubo] = Integer.toString(tubo+1);
                }
            }
            return true;
        }else{
            return false;
        }
    }
    
    //Este metodo identifica la bola que se quiere mover para prensetarlo en
    //la interfaz
    public String identificarBola( int bola){
        String[] COLORES = {"RO","AZ","VE","AM","MO"}; 
        String color;
        color = COLORES[bola];
        return color;
    }
    
    //Este metodo empieza el juego
    public boolean jugar(){ 
        int tuboSalida;
        int tuboEntrada;
        int bola;
        boolean tuboVacio;
        String color;
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
