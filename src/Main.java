import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BellmanFord bm = new BellmanFord();
        Dijkstra dj = new Dijkstra();
        File f = new File("Graphes");
        File[] graphes = f.listFiles();

        for (File current: graphes) {
            GraphListe graphe = new GraphListe(current.getPath());

            //Bellman Ford
            Instant debutBellman = Instant.now();
            Valeur v = bm.resoudre(graphe,"1");
            Instant finBellman = Instant.now();
            Duration temps = Duration.between(debutBellman,finBellman);

            //Dijkstra
            Instant debutDijkstra = Instant.now();
            Valeur v2 = dj.resoudre(graphe,"1");
            Instant finDijkstra = Instant.now();
            Duration temps2 = Duration.between(debutDijkstra,finDijkstra);

            //affichage
            System.out.println(current.getName()+"\t"+temps.toNanos()+"\t"+temps2.toNanos()+"\t"+graphe.listeNoeuds().size());
        }
    }
}
