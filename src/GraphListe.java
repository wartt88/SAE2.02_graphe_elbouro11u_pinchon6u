import java.util.List;

public class GraphListe implements Graphe
{
    /**
     * attribut qui permet de stocker les noms des nœuds dans une liste
     */
    private List<String> ensNom;

    /**
     * attribut qui permet de stocker les arcs des nœuds
     */
    private List<Arc> ensNoeuds;


    public void ajouterArc(String depart, String destination, double cout)
    {
        this.ensNom.add(depart);
        this.ensNoeuds.add(new Arc(destination,cout));
        this.ensNom.add(destination);
    }
    /**
     * méthode qui renvoie la liste des nœuds
     *
     * @return les noms en String
     */
    @Override
    public List<String> listeNoeuds() {
        return null;
    }

    /**
     * méthode qui renvoie la liste des arcs suivants
     *
     * @param n nom du nœud N où l'on part
     * @return retourne la liste d'arc
     */
    @Override
    public List<Arc> suivants(String n) {
        return null;
    }
}
