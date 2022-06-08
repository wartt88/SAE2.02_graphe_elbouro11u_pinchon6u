import java.util.ArrayList;
import java.util.List;

public class GraphListe implements Graphe
{
    /**
     * attribut qui permet de stocker les noms des nœuds dans une liste
     */
    private List<String> ensNom;

    /**
     * attribut qui permet de stocker les arcs des nœuds
     */
    private List<Noeud> ensNoeuds;


    public GraphListe() {
        this.ensNom = new ArrayList<String>();
        this.ensNoeuds = new ArrayList<Noeud>();
    }

    public void ajouterArc(String depart, String destination, double cout)
    {
       if(!this.ensNom.contains(depart))
       {
           this.ensNom.add(depart);
           this.ensNoeuds.add(new Noeud(depart));
       }
       if(!this.ensNom.contains(destination))
       {
           this.ensNom.add(destination);
           this.ensNoeuds.add(new Noeud(destination));
       }
       boolean trouve=false;
       int i=0;
       while(!trouve){
           if (this.ensNoeuds.get(i).getNom().equals(depart))
               trouve=true;
           else
               i++;
       }
       this.ensNoeuds.get(i).ajouterArc(destination, cout);
    }
    /**
     * méthode qui renvoie la liste des nœuds
     *
     * @return les noms en String
     */
    @Override
    public List<String> listeNoeuds()
    {
        return this.ensNom;
    }

    /**
     * méthode qui renvoie la liste des arcs suivants
     *
     * @param n nom du nœud N où l'on part
     * @return retourne la liste d'arc
     */
    @Override
    public List<Arc> suivants(String n)
    {
        int i=0;
        while(i<this.ensNoeuds.size()){
            if (this.ensNoeuds.get(i).getNom().equals(n))
                return this.ensNoeuds.get(i).getAdj();
            else
                i++;
        }
        return null;
    }

    /**
     * methode d'affichage d'un graphList
     * @return string
     */
    public String toString(){
        List<Noeud> actuel = this.ensNoeuds;
        String res = "";
        while(!actuel.isEmpty()){
            int i=0;
            for (int j = 0; j < actuel.size(); j++) {
                if (actuel.get(i).getNom().compareTo(actuel.get(j).getNom())>0)
                    i=j;
            }
            res+=actuel.get(i).toString();
            actuel.remove(i);
        }
        return res;
    }

}
