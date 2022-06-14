package algorithme;

import algorithme.Algorithme;
import graphes.Arc;
import graphes.Graphe;
import graphes.Valeur;

import java.util.List;

public class BellmanFord implements Algorithme
{
    /**
     * fonction algorithme.BellmanFord(G,d)
     * //initialisation :
        pour n dans G faire:
            L(n)<-+∞
            parent(n) = null
        l(d)<-0
        //boucle principale :
        continuer <- vrai
        tant que continuer, faire :
            continuer <- faux
            pour chaque arc(u,v,poids) de G faire :
                Si L(v) > L (u) + poids alors
                    l(v)<-l(u)+poids
                    parent(v)<-u
                    continuer <-vrai
                fsi
            fpour
        ftantque
     **/

    /**
     * méthode résoudre qui permet de lancer l'algorithme de algorithme.BellmanFord
     * @param g Graphlist
     * @param depart Le nœud de départ
     * @return retourne une valeur.
     */
    public Valeur resoudre(Graphe g, String depart)
    {
        Valeur valeur = new Valeur();
        //initialisation de l'algo :
        for(int i =0; i< g.listeNoeuds().size(); i++)
        {
            String nom = g.listeNoeuds().get(i);
            valeur.setValeur(nom,Double.MAX_VALUE);
            valeur.setParent(nom, null);
        }
        //on met la première valeur à 0 :
        valeur.setValeur(depart,0);
        // début de la méthode point fixe :
        boolean continuer = true;
        while(continuer)
        {
            continuer = false;
            for(int i = 0; i< g.listeNoeuds().size(); i++)
            {
                List<Arc> list = g.suivants(g.listeNoeuds().get(i));
                for(int j = 0; j<list.size(); j++)
                {
                    double somme = valeur.getValeur(g.listeNoeuds().get(i))+list.get(j).getCout();
                    if(valeur.getValeur(list.get(j).getDest())>somme)
                    {
                        valeur.setValeur(list.get(j).getDest(), somme);
                        valeur.setParent(list.get(j).getDest(), g.listeNoeuds().get(i));
                        continuer = true;
                    }
                }
            }
        }
        return valeur;
    }

}
