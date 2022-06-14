package mains;

import algorithme.Dijkstra;
import graphes.*;
import laby.Labyrinthe;

import java.io.IOException;

public class MainLabyGraphe {

    // execution simple qui creer un labyrinthe a partir d un fichier texte pour ensuite en faire un graphe
    // et retourner ici le chemin pour acceder au noeud "(1,1)" de la façon la plus courte

    public static void main(String[] args) throws IOException {
        Labyrinthe lb = new Labyrinthe("labySimple/laby1.txt");
        GraphListe g = lb.genererGraphe();
        //System.out.println(g.toGraphviz("labyrinthe"));

        Dijkstra dj = new Dijkstra();
        Valeur v = dj.resoudre(g,"\"(1,1)\"");
        //calcul du chemin le plus court pour atteindre le noeud "(5,5)"
        System.out.println(v.calculerChemin("\"(5,5)\""));
    }
}
