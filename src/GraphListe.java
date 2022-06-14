import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    /**
     * constructeur vide de graphe
     */
    public GraphListe() {
        this.ensNom = new ArrayList<String>();
        this.ensNoeuds = new ArrayList<Noeud>();
    }

    /**
     * constructeur qui creer un graphe selon un fichier texte donne
     * @param nomFichier nom du fichier a charger
     */
    public GraphListe(String nomFichier) throws IOException {
        //creation basique
        this.ensNom = new ArrayList<String>();
        this.ensNoeuds = new ArrayList<Noeud>();

        // ouvrir fichier
        FileReader fichier = new FileReader(nomFichier);
        BufferedReader bfRead = new BufferedReader(fichier);

        // lecture des cases
        String ligne = bfRead.readLine();

        while(ligne!=null){
            String dpt="faux";
            String dest="faux";
            int cout=0;
            String[] res = ligne.split("\t");
            if (res.length!=0 && res[0]!=null)
                dpt=res[0];
            if (res.length>1 && res[1]!=null)
                dest=res[1];
            if (res.length>2 && res[2]!=null)
                cout= Integer.parseInt(res[2]);

            ajouterArc(dpt,dest,cout);

            // lecture
            ligne = bfRead.readLine();
        }
        // ferme fichier
        bfRead.close();
    }

    /**
     * methode qui creer un arc entre deux noeuds
     * @param depart noeud de depart
     * @param destination noeud de destination
     * @param cout cout de l arc
     */
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
        List<Noeud> actuel = new ArrayList<>(this.ensNoeuds);
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

    public String toGraphviz(String nomGraph){
        List<Noeud> actuel = new ArrayList<>(this.ensNoeuds);
        String res = "";
        res += "digraph " + nomGraph + " {\n";
        while(!actuel.isEmpty()){
            int i=0;
            for (int j = 0; j < actuel.size(); j++) {
                if (actuel.get(i).getNom().compareTo(actuel.get(j).getNom())>0)
                    i=j;
            }
            for (int j = 0; j < actuel.get(i).getAdj().size(); j++) {
                Arc arc = actuel.get(i).getAdj().get(j);
                res += actuel.get(i).getNom() + " -> " + arc.getDest() + " [label = " +arc.getCout()+"]\n";
            }
            actuel.remove(i);
        }
        res += "}";
        return res;
    }

    /**
     * constructeur de graphe aleatoire
     * @param nombre nombre de noeuds souhaites dans le graphe
     */
    public GraphListe(int nombre){
        //creation basique
        this.ensNom = new ArrayList<String>();
        this.ensNoeuds = new ArrayList<Noeud>();

        // ajout de chaque noeuds
        for (int i = 1; i <= nombre; i++) {
            String nom = String.valueOf(i);
            ensNom.add(nom);
            Noeud current = new Noeud(nom);
            ensNoeuds.add(current);
            // ajout d un arc minimum pour chaque noeuds en etant depart
            if (i>1){
                Arc retour = hasardNomEtCout(current,"depart");
                ajouterArc(nom, retour.getDest(), retour.getCout());
            }
        }
        // ajout d un arc minimum pour chaque noeuds en etant destination
        for (Noeud current:ensNoeuds) {
            Arc retour = hasardNomEtCout(current,"destination");
            ajouterArc(retour.getDest(), current.getNom(), retour.getCout());
        }

        //ajout de quelques arcs aleatoires
        Random random = new Random();
        for (int i = 0; i < nombre/2; i++) {
            Noeud current = ensNoeuds.get(random.nextInt(ensNoeuds.size()));
            Arc retour = hasardNomEtCout(current,"depart");
            ajouterArc(current.getNom(), retour.getDest(), retour.getCout());
        }
    }

    private Arc hasardNomEtCout(Noeud depart,String etat){
        Random rand = new Random();
        String nom="";
        boolean valide=false;
        while(!valide) {
            nom = ensNom.get(rand.nextInt(ensNom.size()));
            Noeud actuel = getNoeud(nom);
            if (etat=="depart" && depart.getNom()!=nom && !depart.contientSuc(nom))
                valide = true;
            else if (etat=="destination" && depart.getNom()!=nom && !actuel.contientSuc(depart.getNom()))
                valide=true;
        }
        int cout = rand.nextInt(100);
        return new Arc(nom,cout);
    }

    private Noeud getNoeud(String nom){
        for (int i = 0; i < this.ensNoeuds.size(); i++) {
            if (ensNoeuds.get(i).getNom()==nom)
                return ensNoeuds.get(i);
        }
        return null;
    }

}
