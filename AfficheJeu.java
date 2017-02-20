/**
 * Created by Lydia on 14-Feb-17.
 */
public class AfficheJeu extends Thread{

    //private int[][] etatCourant; //tableau d'entiers contenant le nombre de voisins de chaque cellule
    private Jeu j;
    public AfficheJeu(Jeu j){
        this.j = j;
    }

    public void run(){
        try {
            while (!interrupted()) {
                j.affiche();
                sleep(j.getAttente());
            }
        } catch (InterruptedException e){
            System.out.println("Affichage interrompu !");
        }
    }
}
