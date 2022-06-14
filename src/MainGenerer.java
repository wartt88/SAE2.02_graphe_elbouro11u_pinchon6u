public class MainGenerer {
    public static void main(String[] args) {
        GraphListe graphe = new GraphListe(50);
        System.out.println(graphe.toGraphviz("invention"));
    }
}
