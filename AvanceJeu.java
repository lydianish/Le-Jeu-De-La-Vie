/**
 * Created by Lydia on 14-Feb-17.
 */
public class AvanceJeu extends ThreadJeu {

    private Panneau p;

    public AvanceJeu(Panneau p){
        this.p = p;
    }
    public void run() {
        while (!interrupted()) {
            if (!stopped)
                p.avance();
        }
    }

}
