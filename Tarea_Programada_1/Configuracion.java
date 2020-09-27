
public class Configuracion
{
    public final String[] colores;
    public final int cantColores;
    public final int tamanoTubo;
    public final int cantTubosVacios;
    public final int cantTubosVisibles;
    public final int cantTubos;
    
    public Configuracion(String[] colores, int tamanoTubo, int cantTubosVacios, int cantTubosVisibles)
    {
        this.colores = colores;
        this.cantColores = colores.length;
        this.tamanoTubo = tamanoTubo;
        this.cantTubosVacios = cantTubosVacios;
        this.cantTubos = cantTubosVacios + colores.length;
        if (cantTubosVisibles < colores.length+cantTubosVacios)
        {
            this.cantTubosVisibles = cantTubosVisibles;
        }else
        {
            this.cantTubosVisibles = colores.length+1;
        }
    }
}
