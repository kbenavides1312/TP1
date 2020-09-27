import java.util.Arrays;

public class Tablero
{
    private int[][] tubos;
    private int tamanoTubo;
    private int[] niveles;
    private int[] nivelesCompletos;
    
    public Tablero(int cantColores, int tamanoTubo,int[] distribucion, int cantTubosVacios){
        this.tubos = new int[cantColores+cantTubosVacios][tamanoTubo];
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
        Arrays.fill(niveles, 0);
        Arrays.fill(nivelesCompletos, 0);
    }
    
    public boolean agregarBola(int numeroTubo, int color){
        if (niveles[numeroTubo]<tamanoTubo){
            tubos[numeroTubo][niveles[numeroTubo]]= color;
            niveles[numeroTubo]++;
            if (nivelesCompletos[numeroTubo]==niveles[numeroTubo] && color==tubos[numeroTubo][0]){
                nivelesCompletos[numeroTubo]++;
            }
            return true;
        }else{
            return false;
        }
        
    }
    
    public int quitarBola(int numeroTubo){
        int bola;
        if (niveles[numeroTubo]>0){
            if (nivelesCompletos[numeroTubo]==niveles[numeroTubo]){
                nivelesCompletos[numeroTubo]--;
            }
            bola = tubos[numeroTubo][niveles[numeroTubo]];
            tubos[numeroTubo][niveles[numeroTubo]] = -1;
            niveles[numeroTubo]--;
        }else{
            bola = -1;
        }
        return bola;
    }
    
    public void obtenerNivel(){
    }
}
