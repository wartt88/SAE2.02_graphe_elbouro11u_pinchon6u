import java.io.IOException;

public class MainLabyGraphe {
    public static void main(String[] args) throws IOException {
        Labyrinthe lb = new Labyrinthe("labySimple/laby1.txt");
        GraphListe g = lb.genererGraphe();
        //System.out.println(g.toGraphviz("labyrinthe"));

        Dijkstra dj = new Dijkstra();
        Valeur v = dj.resoudre(g,"\"(1,1)\"");
        System.out.println(v.calculerChemin("\"(5,5)\""));
    }
}
