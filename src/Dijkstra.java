import java.util.ArrayList;
import java.util.List;

public class Dijkstra implements Algorithme{
    /**
     * Entrees :
     * G un graphe orient ́e avec une pond ́eration (poids) positive des arcs
     * A un sommet (d ́epart) de G
     * <p>
     * Debut
     * Q <- {} // utilisation d’une liste de noeuds `a traiter
     * Pour chaque sommet v de G faire
     * v.distance <- Infini
     * v.parent <- Ind efini
     * Q <- Q U {v} // ajouter le sommet v a la liste Q
     * Fin Pour
     * <p>
     * A.distance <- 0
     * Tant que Q est un ensemble non vide faire
     * u <- un sommet de Q telle que u.distance est minimale
     * Q <- Q \ {u} // enlever le sommet u de la liste Q
     * Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
     * D <- u.distance + poids(u,v)
     * Si D < v.distance
     * Alors v.distance <- D
     * v.parent <- u
     * Fin Si
     * Fin Pour
     * Fin Tant que
     * Fin
     */

    /**
     * méthode qui permet de résoudre l'algorithme de Dijkstra
     * @param g Graphlist
     * @param depart noeud de départ
     * @return renvoie la valeur
     */
    public Valeur resoudre(Graphe g, String depart) {
        Valeur valeur = new Valeur();
        List<String> aTraiter = new ArrayList<>();

        //initialisation de l'algo :
        for (int i = 0; i < g.listeNoeuds().size(); i++) {
            String nom = g.listeNoeuds().get(i);
            valeur.setValeur(nom, Double.MAX_VALUE);
            valeur.setParent(nom, null);
            aTraiter.add(nom);
        }

        //on met la première valeur à 0 :
        valeur.setValeur(depart, 0);

        // début de la méthode point fixe :
        while (!aTraiter.isEmpty()) {
            //recherche du chemin minimal
            String noeud = aTraiter.get(0);
            for (String current : aTraiter) {
                if (valeur.getValeur(current) < valeur.getValeur(noeud)) {
                    noeud = current;
                }
            }
            aTraiter.remove(noeud);

            List<Arc> list = g.suivants(noeud);
            for (int j = 0; j < list.size(); j++) {
                double somme = valeur.getValeur(noeud) + list.get(j).getCout();
                if (valeur.getValeur(list.get(j).getDest()) > somme) {
                    valeur.setValeur(list.get(j).getDest(), somme);
                    valeur.setParent(list.get(j).getDest(), noeud);
                }
            }
        }
        return valeur;
    }

}
