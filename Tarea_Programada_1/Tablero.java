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
            result += i + "\t";
        }
        for (int j=configuracion.tamanoTubo-1; j>=0; j--)
        {
            result += "\n";
            for (int i=0; i<cantTubosVisibles; i++)
            {
                if (tubos[i][j] != -1)
                {
                    result += configuracion.colores[tubos[i][j]] + "\t";
                }else{
                    result += "--\t";
                }
            }
        }
        return result;
    }
    
    public void toString2(){
        String Boundary1 = JOptionPane.showInputDialog(null, "Please enter the first boundary of the multiplication table.");
        String Boundary2 = JOptionPane.showInputDialog(null, "Please enter the second boundary of the multiplication table.");

        int X = Integer.parseInt(Boundary1);
        int Y = Integer.parseInt(Boundary2);
        int j = 1;
        String Result = "";
        int x = 1;

        while (x <= X) {
            for (int i = 1; i <= Y; i++) {
                j = i * x;
                Result = Result + j + "\t";
            }
            x++;
            Result = Result + "\n";
            }
            JTextArea jt=new JTextArea(Result);
            jt.setEditable(false);
            jt.setOpaque(false);
            jt.setTabSize(3);
            JOptionPane.showMessageDialog(null, jt);

    }
    
    public void obtenerNivel(){
    }
}
