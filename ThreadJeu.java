/**
 * Created by Lydia on 21-Feb-17.
 */
public class ThreadJeu extends Thread {

    public ThreadJeu(){super();}

    protected boolean stopped;

    public void stopped(){stopped = true;}
    public void resumed(){stopped = false;}
    public boolean isStopped() {return stopped;}
}
