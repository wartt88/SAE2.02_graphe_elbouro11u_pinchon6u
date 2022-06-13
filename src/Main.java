import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        GraphListe graphe = new GraphListe("Graphes/GrapheBoucle");
        BellmanFord bm = new BellmanFord();
        Dijkstra dj = new Dijkstra();

        System.out.println("Avec la méthode de BellmanFord :");
        Valeur v = bm.resoudre(graphe,"A");
        System.out.println(v);


        System.out.println("Avec la méthode de Dijkstra :");
        Valeur v2 = dj.resoudre(graphe,"A");
        System.out.println(v2);

    }
}
