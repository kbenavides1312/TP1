import java.util.Random;
import java.util.Arrays;

public class Computadora
{
    private int cantColores;
    private int tamanoTubo;
    private Random generadorDist;
    
 
    /**
     * Crea el objeto
     * 
     * @param cantColores cantidad de colores diferentes
     * @param tamanoTubo cantidad de tubos
     */
    public Computadora(int cantColores, int tamanoTubo){
        this.cantColores = cantColores;
        this.tamanoTubo = tamanoTubo;
        this.generadorDist = new Random();
        
    }
    
    public int[] generarDistribucion(){
        int cantBolas = cantColores * tamanoTubo;
        int[] restantesColores = new int[cantColores];
        Arrays.fill(restantesColores, tamanoTubo);
        int[] distribucion = new int[cantBolas];
        int nuevaBola;
        int indice = 0;
        do{
            nuevaBola = generadorDist.nextInt(cantColores);
            if (restantesColores[nuevaBola]>0){
                distribucion[indice] = nuevaBola;
                restantesColores[nuevaBola]--;
                indice++;
            }
        }while(indice<cantBolas);
        return distribucion;
    }
}
