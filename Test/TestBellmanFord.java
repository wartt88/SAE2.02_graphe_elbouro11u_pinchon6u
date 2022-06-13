import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBellmanFord
{
    @Test
    public void test_BellmanFord_fonctionnel() throws IOException {
        //initialisation :
        GraphListe graph = new GraphListe("Graphes/Graphe000000.txt");
        BellmanFord bellmanFord = new BellmanFord();

        //utilisation :
        Valeur valeur = bellmanFord.resoudre(graph, "A");

        //test:
        assertEquals("A ->  V:0.0 p:null\n" + "B ->  V:12.0 p:A\n" + "C ->  V:76.0 p:D\n" + "D ->  V:66.0 p:E\n" + "E ->  V:23.0 p:B\n" + "", valeur.toString(), "doit être équivalent pour montrer que c'est bien créer.");
    }

    @Test
    public void test_BellmanFord_valeurDepart() throws IOException {
        //initialisation :
        GraphListe graph = new GraphListe("Graphes/Graphe000000.txt");
        BellmanFord bellmanFord = new BellmanFord();

        //utilisation :
        Valeur valeur = bellmanFord.resoudre(graph, "A");

        //test:
        assertEquals(0, valeur.getValeur("A"), "doit être egal a 0");
    }

    @Test
    public void test_BellmanFord_Calcule_Parent() throws IOException {
        //initialisation :
        GraphListe graph = new GraphListe("Graphes/Graphe000000.txt");
        BellmanFord bellmanFord = new BellmanFord();

        //utilisation :
        Valeur valeur = bellmanFord.resoudre(graph, "A");

        //test:

        assertEquals("A", valeur.getParent("B"), "doit être A");
        //on sait que A -> B = 12:
        assertEquals(valeur.getValeur("A")+12, valeur.getValeur("B"));

        //Pour  B -> E
        assertEquals("B", valeur.getParent("E"), "doit être B");
        assertEquals(valeur.getValeur("B")+11, valeur.getValeur("E"));

        // Pour E -> D
        assertEquals("E", valeur.getParent("D"), "doit être E");
        assertEquals(valeur.getValeur("E")+43, valeur.getValeur("D"));

        // Pour D -> C
        assertEquals("D", valeur.getParent("C"), "doit être D");
        assertEquals(valeur.getValeur("D")+10, valeur.getValeur("C"));
    }
}
