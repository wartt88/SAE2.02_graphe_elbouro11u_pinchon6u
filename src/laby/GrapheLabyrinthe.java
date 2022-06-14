package laby;

import graphes.Arc;
import graphes.Graphe;

import java.util.ArrayList;
import java.util.List;

public class GrapheLabyrinthe implements Graphe {

    /**
     * attribut Labyrinthe
     */
    private Labyrinthe laby;

    /**
     * constructeur de l adaptateur qui prend en parametre un objet labyrinthe
     */
    public GrapheLabyrinthe(Labyrinthe lb){
        this.laby=lb;
    }


    @Override
    public List<String> listeNoeuds() {
        List retour = new ArrayList<>();
        for (int i = 0; i < laby.getLength(); i++) {
            for (int j = 0; j < laby.getLengthY(); j++) {
                if (!laby.getMur(i,j))
                    retour.add("\"("+i+","+j+")\"");
            }
        }
        return retour;
    }

    @Override
    public List<Arc> suivants(String n) {
        List retour = new ArrayList<>();
        int x,y;
        String[] position = n.split(",");
        x=Integer.parseInt(position[0].substring(2));
        y=Integer.parseInt(position[1].substring(0,position[1].indexOf(")")));
        if (!laby.getMur(x-1,y))
            retour.add(new Arc("\"("+(x-1)+","+y+")\"",1));
        if (!laby.getMur(x+1,y))
            retour.add(new Arc("\"("+(x+1)+","+y+")\"",1));
        if (!laby.getMur(x,y-1))
            retour.add(new Arc("\"("+x+","+(y-1)+")\"",1));
        if (!laby.getMur(x,y+1))
            retour.add(new Arc("\"("+x+","+(y+1)+")\"",1));
        return retour;
    }
}
