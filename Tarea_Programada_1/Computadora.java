import java.util.Random;
import java.util.Arrays;

/**
 * Esta clase recibe lo necesario para crea la generacion de las bolas en 
 * los tubos.
 * 
 * @author Kenneth Benavides Rojas y Jeremy Calvo Fernández.
 * @version 4/10/2020
 */
public class Computadora 
{
    private Configuracion configuracion;
    private Random generadorDist;
    
    /**
     * Inicia lo necesario para generar la distribucion de las bolas en 
     * los tubos.
     * 
     * @param cantColores cantidad de colores diferentes
     * @param tamanoTubo cantidad de tubos
     */
    public Computadora(Configuracion configuracion){
        this.configuracion = configuracion;
        this.generadorDist = new Random();
        
    }
    
    /**
     * Genera la distribucion de las bolas en los tubos.
     */
    public int[] generarDistribucion(){
        int cantBolas = configuracion.cantColores * configuracion.tamanoTubo;
        int[] restantesColores = new int[configuracion.cantColores];
        Arrays.fill(restantesColores, configuracion.tamanoTubo);
        int[] distribucion = new int[cantBolas];
        int nuevaBola;
        int indice = 0;
        do{
            nuevaBola = generadorDist.nextInt(configuracion.cantColores);
            if (restantesColores[nuevaBola]>0){
                distribucion[indice] = nuevaBola;
                restantesColores[nuevaBola]--;
                indice++;
            }
        }while(indice<cantBolas);
        return distribucion;
    }
}
