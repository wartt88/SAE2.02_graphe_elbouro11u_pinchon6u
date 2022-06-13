public class BellmanFord
{
    /**
     * fonction BellmanFord(G,d)
     * //initialisation :
        pour n dans G faire:
            L(n)<-+∞
            parent(n) = null
        l(d)<-0
        //boucle principale :
        continuer <- vrai
        tant que continuer faire :
            continuer <- faux
            pour chaque arc(u,v,poids) de G faire :
                Si L(v) > L (u) + poids alors
                    l(v)<-l(u)+poids
                    parent(v)<-u
                    continuer <-vrai
                fsi
            fpour
        ftantque
     **/

}
