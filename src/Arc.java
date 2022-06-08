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

    public Arc(String dest, double ct)
    {
        this.dest= dest;
        if(ct>0)
        {
            this.cout =ct;
        }
        else
        {
            this.cout = 0;
        }

    }
}
