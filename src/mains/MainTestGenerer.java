package mains;

import algorithme.BellmanFord;
import algorithme.Dijkstra;
import graphes.GraphListe;
import graphes.Valeur;

import java.time.Duration;
import java.time.Instant;

public class MainTestGenerer
{
    public static void main(String[] args) {
        //création des algorithmes:
        BellmanFord bm = new BellmanFord();
        Dijkstra dj = new Dijkstra();
        GraphListe graphe = new GraphListe(10000);

        //Bellman Ford
        Instant debutBellman = Instant.now();
        Valeur v = bm.resoudre(graphe,"1");
        Instant finBellman = Instant.now();
        Duration temps = Duration.between(debutBellman,finBellman);

        //algorithme.Dijkstra
        Instant debutDijkstra = Instant.now();
        Valeur v2 = dj.resoudre(graphe,"1");
        Instant finDijkstra = Instant.now();
        Duration temps2 = Duration.between(debutDijkstra,finDijkstra);

        //affichage
        System.out.println("graphe:"+ "\t"+temps.toNanos()+"\t"+temps2.toNanos()+"\t"+graphe.listeNoeuds().size());
    }
}
