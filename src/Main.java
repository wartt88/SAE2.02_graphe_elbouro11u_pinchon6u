import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        GraphListe graphe = new GraphListe("Graphes/Graphe1.txt");
        System.out.println(graphe.toString());
        System.out.println(graphe.toGraphviz("G"));
    }

}
