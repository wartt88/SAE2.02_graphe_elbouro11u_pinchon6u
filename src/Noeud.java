import java.util.ArrayList;
import java.util.List;

public class Noeud {

    /**
     * un attribut String correspondant au nom du noeud
     */
    private String nom;

    /**
     * un attribut Liste d arc reliant ce noeud aux noeuds adjcents
     */
    private List<Arc> adj;

    /**
     * contructeur avec un parametre nom
     * @param nom
     */
    public Noeud(String nom) {
        this.nom = nom;
        this.adj = new ArrayList<Arc>();
    }

    /**
     * redefinition de la méthode equals
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        return this.nom.equals(((Noeud) o).getNom());
    }

    /**
     * getter du nom
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * getter des arcs adjcents
     * @return adj
     */
    public List<Arc> getAdj() {
        return adj;
    }

    /**
     * methode ajouterArc qui ajoute un Arc a la liste
     * @param destination nom du noeud de destination
     * @param cout cout de l arc
     */
    public void ajouterArc(String destination,double cout){
        this.adj.add(new Arc(destination,cout));
    }
}
