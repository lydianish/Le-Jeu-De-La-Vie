/**
 * Created by Lydia on 14-Feb-17.
 */
public class AvanceJeu extends Thread {

    private Jeu j;

    public AvanceJeu(Jeu j){
        this.j = j;
    }

    public void run(){
        //try {
            while (!interrupted()) {
                j.avance();
                //sleep(j.getAttente());
            }
        //} catch (InterruptedException e){
        //    System.out.println("Affichage interrompu !");
        //}
    }
}
