import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        GraphListe graphe = new GraphListe("Graphes/Graphe000000.txt");
        BellmanFord bm = new BellmanFord();

        System.out.println(bm.resoudre(graphe,"A").toString());
    }
}
