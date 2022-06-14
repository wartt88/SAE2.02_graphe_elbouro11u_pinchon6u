import graphes.GraphListe;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestGraphTest
{
    /**
     * méthode qui test la création d'un graphListe.
     */
    @Test
    public void test_GraphListe_creation()
    {
        //création:
        GraphListe graph = new GraphListe();
        List<String> test = new ArrayList<String>();

        //utilisation

        //test:
        assertEquals(graph.listeNoeuds(), test, "doit etre null");
    }

    @Test
    public void test_GraphList_Ajout()
    {
        //création:
        GraphListe graph = new GraphListe();

        //utilisation:
        graph.ajouterArc("A", "B", 12);
        graph.ajouterArc("B", "C", 15);

        //test:
        assertEquals(graph.listeNoeuds().get(0), "A", "doit être égal a A.");
        assertEquals(graph.listeNoeuds().get(1), "B", "doit être égal a B.");
    }

    /**
     * Méthode qui test la méthode suivant.
     */
    @Test
    public void test_GraphListe_Suivant()
    {
        //création:
        GraphListe graph = new GraphListe();

        //utilisation:
        graph.ajouterArc("A", "B", 10);
        graph.ajouterArc("A", "C", 15);

        //test:
        assertEquals(graph.suivants("A").get(0).getDest(), "B", "doit etre egal a B.");
        assertEquals(graph.suivants("A").get(1).getDest(), "C", "doit etre egal a C.");
    }

    @Test
    public void test_GraphList_AjoutNegatif()
    {
        //création:
        GraphListe graph = new GraphListe();

        //utilisation
        graph.ajouterArc("A", "B", -12);
        graph.ajouterArc("B", "D", 4);

        //test:
        assertEquals(graph.suivants("A").get(0).getCout(), 0, "doit être egal a 0");
        assertEquals(graph.suivants("B").get(0).getCout(), 4, "doit être egal a 4");
    }
}