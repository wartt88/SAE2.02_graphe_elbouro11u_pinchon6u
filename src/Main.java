import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        GraphListe graphe = new GraphListe("Graphes/Graphe000000.txt");
        BellmanFord bm = new BellmanFord();

        Valeur v = bm.resoudre(graphe,"A");

        List<String> retour =v.calculerChemin("C");
        for (String r: retour) {
            System.out.println(r);
        }

    }
}
