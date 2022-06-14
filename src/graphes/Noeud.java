package graphes;

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
     * methode ajouterArc qui ajoute un graphes.Arc a la liste
     * @param destination nom du noeud de destination
     * @param cout cout de l arc
     */
    public void ajouterArc(String destination,double cout){
        this.adj.add(new Arc(destination,cout));
    }

    public String toString()
    {
        String res;
        res = this.nom + " -> ";
        for(int i =0; i<this.adj.size();i++)
        {
            res += this.adj.get(i).getDest()+ "(" + this.adj.get(i).getCout() + ") ";
        }
        res += "\n";
        return  res;
    }

    public boolean contientSuc(String dest){
        boolean res = false;
        for (int i = 0; i < this.adj.size() && !res; i++) {
            if(adj.get(i).getDest()==dest)
                res=true;
        }
        return res;
    }
}
