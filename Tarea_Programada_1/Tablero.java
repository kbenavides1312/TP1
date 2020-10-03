import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
        for (int tubo=0; tubo<configuracion.cantColores; tubo++){
            for (int nivelTubo=0; nivelTubo<configuracion.tamanoTubo; nivelTubo++){ //distribuye las pelotas entre los tubos
                color=distribucion[tubo*configuracion.tamanoTubo+nivelTubo];
                this.agregarBola(tubo,color);
            }
        }
        for (int vacio=configuracion.cantColores; vacio<tubos.length; vacio++){
            Arrays.fill(tubos[vacio], -1);
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
    
    public boolean agregarBolaIniciado(int numeroTubo, int color){
        int bolaAnterior;
        int ultimo;
        ultimo = niveles[numeroTubo]-1;
        if (niveles[numeroTubo]>0){
            bolaAnterior = tubos[numeroTubo][ultimo];
        }else{
            bolaAnterior = -1;
        }
        if(bolaAnterior == color || bolaAnterior == -1){
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
        for (int tubo=1; tubo<=cantTubosVisibles; tubo++)
        {
            result += tubo + "\t";
        }
        for (int nivelTubo=configuracion.tamanoTubo-1; nivelTubo>=0; nivelTubo--)
        {
            result += "\n";
            for (int tubo=0; tubo<cantTubosVisibles; tubo++)
            {
                if (tubos[tubo][nivelTubo] != -1)
                {
                    result += configuracion.colores[tubos[tubo][nivelTubo]] + "\t";
                }else{
                    result += "--\t";
                }
            }
        }
        return result;
    }
    public boolean ganar(){
        for (int tubo=0; tubo<8; tubo++){
            for (int nivelTubo=0; nivelTubo<3; nivelTubo++){
                if((tubos[tubo][nivelTubo]) != (tubos[tubo][nivelTubo+1])){
                    return false;
                }
            }
        }
        return true;
    }
    
    public void obtenerNivel(){
    }
}
