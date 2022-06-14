package graphes;

import java.util.List;

public interface Graphe
{
    /**
     * méthode qui renvoie la liste des nœuds
     * @return les noms en String
     */
    public List<String> listeNoeuds();

    /**
     * méthode qui renvoie la liste des arcs suivants
     * @param n nom du nœud N où l'on part
     * @return retourne la liste d'arc
     */
    public List<Arc> suivants(String n);
}
