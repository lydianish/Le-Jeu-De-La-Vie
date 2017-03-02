import javafx.scene.layout.Border;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Panneau extends JPanel implements MouseListener{

	public Panneau (Jeu j, int hauteur, int largeur){
		super();
		this.j = j;
		this.hauteur = hauteur;
		this.largeur = largeur;
        addMouseListener(this);
        //setBorder(BorderFactory.createLineBorder(Color.black));
        //setPreferredSize(new Dimension(largeur,hauteur));
	}

	public synchronized void avance(){

		if (!pret){
			j.avance();
			notifyAll();
			pret = true;
		}
		else {
			try {
				wait();
			}
			catch (InterruptedException e){System.out.println("Avancement interrompu !");}
		}
	}


	public synchronized void affiche(){
		if (pret){
			repaint();
			notifyAll();
			pret = false;
		}
		else {
			try {
				wait();
			}
			catch (InterruptedException e){System.out.println("Affichage interrompu !");}
		}
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//g.drawRect(0,0,largeur,hauteur);
        j.getGrille().affiche(g,hauteur, largeur);
   }

    public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {
        int hc = hauteur/j.getGrille().getHauteur(); //hauteur cellule
        int lc = largeur/j.getGrille().getLargeur(); //largeur cellule
        x = e.getY()/hc;
        y = e.getX()/lc;
        try {
            j.setCell(x, y);
            repaint();
        }
        catch (IllegalArgumentException exc){}
    }

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    private Jeu j;
	private int hauteur, largeur, x, y;
	private boolean pret = true;
	
}
