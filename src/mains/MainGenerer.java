package mains;

import graphes.GraphListe;

public class MainGenerer {

    //execution avec un parametre qui est le nombre de noeud que doit comporter le graphe
    public static void main(String[] args) {
        int nb=10;
        if (args.length>0)
            nb = Integer.parseInt(args[0]);
        GraphListe graphe = new GraphListe(nb);
        System.out.println(graphe.toGraphviz("invention"));
    }
}
