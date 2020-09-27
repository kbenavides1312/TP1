import java.util.Arrays;

public class Tablero
{
    private int[][] tubos;
    private int tamanoTubo;
    private int[] niveles;
    private int[] nivelesCompletos;
    
    public Tablero(int cantColores, int tamanoTubo,int[] distribucion, int cantTubosVacios){
        int cantTubos = cantColores+cantTubosVacios;
        this.tubos = new int[cantTubos][tamanoTubo];
        this.tamanoTubo = tamanoTubo;
        niveles = new int[cantTubos];
        nivelesCompletos = new int[cantTubos];
        Arrays.fill(niveles, 0);
        Arrays.fill(nivelesCompletos, 0);
        int color;
        for (int i=0; i<cantColores; i++){
            for (int j=0; j<tamanoTubo; j++){ //distribuye las pelotas entre los tubos
                color=distribucion[i*tamanoTubo+j];
                this.agregarBola(i,color);
            }
        }
        for (int i=cantColores; i<tubos.length; i++){
            Arrays.fill(tubos[i], -1);
        }
    }
    
    public boolean agregarBola(int numeroTubo, int color){
        if (niveles[numeroTubo]<tamanoTubo){
            tubos[numeroTubo][niveles[numeroTubo]]= color;
            if (nivelesCompletos[numeroTubo]==niveles[numeroTubo] && color==tubos[numeroTubo][0]){
                nivelesCompletos[numeroTubo]++;
            }
            niveles[numeroTubo]++;
            return true;
        }else{
            return false;
        }
        
    }
    
    public int quitarBola(int numeroTubo){
        int bola;
        int ultimo = niveles[numeroTubo]-1;
        if (niveles[numeroTubo]>0){
            if (nivelesCompletos[numeroTubo]==niveles[numeroTubo]){
                nivelesCompletos[numeroTubo]--;
            }
            bola = tubos[numeroTubo][ultimo];
            tubos[numeroTubo][ultimo] = -1;
            niveles[numeroTubo]--;
        }else{
            bola = -1;
        }
        return bola;
    }
    
    public void obtenerNivel(){
    }
}
