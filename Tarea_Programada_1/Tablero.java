import java.util.Arrays;

public class Tablero
{
    private int[][] tubos;
    private Configuracion configuracion;
    private int[] niveles;
    private int[] nivelesCompletos;
    
    public Tablero(Configuracion configuracion ,int[] distribucion){
        this.configuracion = configuracion;
        this.tubos = new int[configuracion.cantTubos][configuracion.tamanoTubo];
        niveles = new int[configuracion.cantTubos];
        nivelesCompletos = new int[configuracion.cantTubos];
        Arrays.fill(niveles, 0);
        Arrays.fill(nivelesCompletos, 0);
        int color;
        for (int i=0; i<configuracion.cantColores; i++){
            for (int j=0; j<configuracion.tamanoTubo; j++){ //distribuye las pelotas entre los tubos
                color=distribucion[i*configuracion.tamanoTubo+j];
                this.agregarBola(i,color);
            }
        }
        for (int i=configuracion.cantColores; i<tubos.length; i++){
            Arrays.fill(tubos[i], -1);
        }
    }
    
    public boolean agregarBola(int numeroTubo, int color){
        if (niveles[numeroTubo]<configuracion.tamanoTubo){
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
    
    public String toString(int cantTubosVisibles){
        String result = "";
        for (int i=1; i<=cantTubosVisibles; i++)
        {
            result += "   " + i + "   ";
        }
        for (int j=configuracion.tamanoTubo-1; j>=0; j--)
        {
            result += "\n";
            for (int i=0; i<cantTubosVisibles; i++)
            {
                if (tubos[i][j] != -1)
                {
                    result += "   " + configuracion.colores[tubos[i][j]] + "   ";
                }else{
                    result += "   --   ";
                }
            }
        }
        return result;
    }
    
    public void obtenerNivel(){
    }
}
