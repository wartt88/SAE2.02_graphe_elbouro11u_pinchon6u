public class Arc
{
    /**
     * String qui représente le nom de destination de l'arc
     */
    private String dest;
    /**
     * double qui représente le coût de l'arc
     */
    private double cout;

    public Arc(Noeud dest, double ct)
    {
        this.dest= dest.getNom();
        this.cout = ct;
    }
}
