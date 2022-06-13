import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        GraphListe graphe = new GraphListe("Graphes/Graphe000000.txt");
        BellmanFord bm = new BellmanFord();
        Dijkstra dj = new Dijkstra();

        Valeur v = bm.resoudre(graphe,"A");
        Valeur v2 = dj.resoudre(graphe,"A");
        System.out.println(v);
        System.out.println(v2);
        /**
        List<String> retour =v.calculerChemin("C");
        for (String r: retour) {
            System.out.println(r);
        }
         */

    }
}
