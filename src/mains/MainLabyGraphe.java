package mains;

import algorithme.Dijkstra;
import graphes.*;
import laby.GrapheLabyrinthe;
import laby.Labyrinthe;

import java.io.IOException;

public class MainLabyGraphe {

    // execution simple qui creer un labyrinthe a partir d un fichier texte pour ensuite en faire un graphe
    // et retourner ici le chemin pour acceder au noeud "(1,1)" de la façon la plus courte

    public static void main(String[] args) throws IOException {
        Labyrinthe lb = new Labyrinthe("labySimple/laby1.txt");
        Dijkstra dj = new Dijkstra();
        //System.out.println(g.toGraphviz("labyrinthe"));

        // affichage du chemin en utilisant la methode genererGraphe de la class Labyrinthe
        GraphListe g = lb.genererGraphe();
        Valeur v = dj.resoudre(g,"\"(1,1)\"");
        //calcul du chemin le plus court pour atteindre le noeud "(5,5)"
        System.out.println(v.calculerChemin("\"(5,5)\""));

        // affichage du chemin en utilisant la class d adaptateur GrapheLabyrinthe
        GrapheLabyrinthe gl = new GrapheLabyrinthe(lb);
        Valeur v2 = dj.resoudre(gl,"\"(1,1)\"");
        //calcul du chemin le plus court pour atteindre le noeud "(5,5)"
        System.out.println(v2.calculerChemin("\"(5,5)\""));
    }
}
