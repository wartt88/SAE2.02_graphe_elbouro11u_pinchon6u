package algorithme;

import graphes.Graphe;
import graphes.Valeur;

public interface Algorithme
{
    public Valeur resoudre(Graphe g, String depart);
}
