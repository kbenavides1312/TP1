import java.util.Random;
import java.util.Arrays;

public class Computadora
{
    private Configuracion configuracion;
    private Random generadorDist;
    
 
    /**
     * Crea el objeto
     * 
     * @param cantColores cantidad de colores diferentes
     * @param tamanoTubo cantidad de tubos
     */
    public Computadora(Configuracion configuracion){
        this.configuracion = configuracion;
        this.generadorDist = new Random();
        
    }
    
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
