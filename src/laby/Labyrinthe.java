package laby;

import graphes.GraphListe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * classe labyrinthe. represente un labyrinthe avec
 * <ul> des murs </ul>
 * <ul> un personnage (x,y) </ul>
 */
public class Labyrinthe {

    /**
     * Constantes char
     */
    public static final char MUR = 'X';
    public static final char PJ = 'P';
    public static final char VIDE = '.';

    /**
     * constantes actions possibles
     */
    public static final String HAUT = "Haut";
    public static final String BAS = "Bas";
    public static final String GAUCHE = "Gauche";
    public static final String DROITE = "Droite";


    /**
     * les murs du labyrinthe
     */
    public boolean[][] murs;

    /**
     * retourne la case suivante selon une actions
     *
     * @param x      case depart
     * @param y      case depart
     * @param action action effectuee
     * @return case suivante
     */
    static int[] getSuivant(int x, int y, String action) {
        switch (action) {
            case HAUT:
                // on monte une ligne
                y--;
                break;
            case BAS:
                // on descend une ligne
                y++;
                break;
            case DROITE:
                // on augmente colonne
                x++;
                break;
            case GAUCHE:
                // on augmente colonne
                x--;
                break;
            default:
                throw new Error("action inconnue");
        }
        int[] res = {x, y};
        return res;
    }

    /**
     * charge le labyrinthe
     *
     * @param nom nom du fichier de labyrinthe
     * @return labyrinthe cree
     * @throws IOException probleme a la lecture / ouverture
     */
    public Labyrinthe(String nom) throws IOException {
        // ouvrir fichier
        FileReader fichier = new FileReader(nom);
        BufferedReader bfRead = new BufferedReader(fichier);

        int nbLignes, nbColonnes;
        // lecture nblignes
        nbLignes = Integer.parseInt(bfRead.readLine());
        // lecture nbcolonnes
        nbColonnes = Integer.parseInt(bfRead.readLine());

        // creation labyrinthe vide
        this.murs = new boolean[nbColonnes][nbLignes];

        // lecture des cases
        String ligne = bfRead.readLine();

        // stocke les indices courants
        int numeroLigne = 0;

        // parcours le fichier
        while (ligne != null) {

            // parcours de la ligne
            for (int colonne = 0; colonne < ligne.length(); colonne++) {
                char c = ligne.charAt(colonne);
                switch (c) {
                    case MUR:
                        this.murs[colonne][numeroLigne] = true;
                        break;
                    case VIDE:
                        this.murs[colonne][numeroLigne] = false;
                        break;

                    default:
                        throw new Error("caractere inconnu " + c);
                }
            }

            // lecture
            ligne = bfRead.readLine();
            numeroLigne++;
        }

        // ferme fichier
        bfRead.close();
    }


    /**
     * deplace le personnage en fonction de l'action.
     * gere la collision avec les murs
     *
     * @param action une des actions possibles
     */
    public int[] deplacerPerso(int i, int j,String action) {
        // case courante
        int[] courante = {i,j};

        // calcule case suivante
        int[] suivante = getSuivant(courante[0], courante[1], action);

        // si c'est pas un mur, on effectue le deplacement
        if (!this.murs[suivante[0]][suivante[1]]) {
            // on met a jour personnage
            return suivante;
        }
        return courante;
    }


    /**
     * jamais fini
     *
     * @return fin du jeu
     */
    public boolean etreFini() {
        return false;
    }

    // ##################################
    // GETTER
    // ##################################

    /**
     * return taille selon Y
     *
     * @return
     */
    public int getLengthY() {
        return murs[0].length;
    }

    /**
     * return taille selon X
     *
     * @return
     */
    public int getLength() {
        return murs.length;
    }

    /**
     * return mur en (i,j)
     * @param x
     * @param y
     * @return
     */
    public boolean getMur(int x, int y) {
        // utilise le tableau de boolean
        return this.murs[x][y];
    }

    /**
     * return un graphe cprrespondant au labyrinthe
     * @return
     */
    public GraphListe genererGraphe(){
        GraphListe g = new GraphListe();
        int cout = 1;
        for (int i = 0; i < this.murs.length; i++) {
            for (int j = 0; j < this.murs[i].length; j++) {
                if (!getMur(i,j)){
                    // verifier la case à droite
                    if (i>0 && !getMur(i-1,j))
                        g.ajouterArc("\"("+i+","+j+")\"","\"("+(i-1)+","+j+")\"",cout);
                    // verifier la case à gauche
                    if (i<murs.length-1 && !getMur(i+1,j))
                        g.ajouterArc("\"("+i+","+j+")\"","\"("+(i+1)+","+j+")\"",cout);
                    // verifier la case en haut
                    if (j>0 && !getMur(i,j-1))
                        g.ajouterArc("\"("+i+","+j+")\"","\"("+i+","+(j-1)+")\"",cout);
                    // verifier la case en bas
                    if (j<murs[0].length-1 && !getMur(i,j+1))
                        g.ajouterArc("\"("+i+","+j+")\"","\"("+i+","+(j+1)+")\"",cout);
                }
                // les \" sont nécessaires pour la visualisation du graphe sur Graphviz
            }
        }
        return g;
    }
}
