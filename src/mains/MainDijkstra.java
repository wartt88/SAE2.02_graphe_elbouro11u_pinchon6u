package mains;

import algorithme.Dijkstra;
import graphes.GraphListe;
import graphes.Valeur;

import java.io.IOException;

public class MainDijkstra
{
    public static void main(String[] args) throws IOException {
        //création du graphe :
        GraphListe graph = new GraphListe("Graphes/Graphe1.txt");
        Dijkstra dijkstra = new Dijkstra();

        System.out.println("graphes.Graphe: Graphe1.txt\n");

        //On calcule des chemins les plus courts pour des nœuds donnés :
        Valeur valeur  = dijkstra.resoudre(graph, "1");

        for(String current : args)
        {
            System.out.println("Chemin le plus court de : " + current);
            System.out.println(valeur.calculerChemin(current) + " de taille : "+ valeur.getValeur(current));
        }
    }
}
