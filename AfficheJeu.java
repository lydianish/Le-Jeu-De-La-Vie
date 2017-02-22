/**
 * Created by Lydia on 14-Feb-17.
 */
public class AfficheJeu extends ThreadJeu{

    //private int[][] etatCourant; //tableau d'entiers contenant le nombre de voisins de chaque cellule
    private int attente;
    private Panneau p;

    public AfficheJeu(Panneau p) {
        this.p = p;
        attente = 1000;
    }

    public void run(){
        try {
            while (!interrupted()) {
                if(!stopped){
                    p.affiche();
                    sleep(attente);
                }
            }
        } catch (InterruptedException e){
            System.out.println("Affichage interrompu !");
        }
    }

    public int getAttente(){return attente;}
    public void setAttente(int t){attente = t;}


}
