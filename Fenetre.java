import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Lydia on 15-Feb-17.
 */
public class Fenetre extends JFrame {

	
    public Fenetre(Jeu j){
        super();
        jeu = j;

        setTitle("Jeu de la vie");
        setSize(largeur+20,hauteur+80);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        dessin = new Panneau(jeu,hauteur,largeur);
        menu = new JPanel();
        start = new JButton("Start");
        stop = new JButton("Stop");
        clear = new JButton("Clear");
        liste = new JComboBox();
        setListe();
        slider = new JSlider(JSlider.HORIZONTAL,10,1000,500);

        dessin.setBackground(Color.white);
        menu.setBackground(Color.gray);
        menu.add(start);
        menu.add(stop);
        menu.add(clear);
        menu.add(liste);
        menu.add(slider);
		  
        JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, dessin, menu);
        split.setDividerLocation(hauteur+30);
        split.setDividerSize(0);
        split.setVisible(true);


        getContentPane().add(split);

        aff = new AfficheJeu(dessin);
        avc = new AvanceJeu(dessin);


        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    aff.start();
                    avc.start();
                }
                catch (IllegalThreadStateException exc){//Already clicked before
                    aff.resumed();
                    avc.resumed();
                }


            }
        });
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avc.stopped();
                aff.stopped();
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jeu.clear();
                dessin.repaint();
            }
        });

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                aff.setAttente(((JSlider)e.getSource()).getValue());
            }
        });

        liste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jeu.clear();
                int xm = jeu.getHauteur()/3;
                int ym = jeu.getLargeur()/3;
                switch ((((JComboBox)e.getSource()).getSelectedItem()).toString()){
                    case "Grille Vide" : break;
                    case "Bloc" : jeu.bloc(xm,ym);  break;
                    case "Tube" : jeu.tube(xm,ym);  break;
                    case "Bateau" : jeu.bateau(xm,ym); break;
                    case "Ruche" : jeu.ruche(xm,ym);  break;
                    case "Hamecon" : jeu.hamecon(xm,ym); break;
                    case "Clignotant" : jeu.clignotant(xm,ym); break;
                    case "Grenouille" : jeu.grenouille(xm,ym); break;
                    case "Horloge" : jeu.horloge(xm,ym); break;
                    case "Pentadecathlon" : jeu.pentadecathlon(xm,ym); break;
                    case "Galaxie" : jeu.galaxie(xm,ym); break;
                    case "Glisseur" : jeu.glisseur(2,0); break;
                    case "Vaisseau Leger" : jeu.vaisseauLeger(3,3); break;
                    case "Pentamino" : jeu.pentamino(xm,ym); break;
                    case "Canon" : jeu.canon(6,2); break;
                }
                dessin.repaint();
            }
        });
    }
    
    
    private JComboBox liste;
    private JSlider slider;
    private JButton start;
    private JButton stop;
    private JButton clear;
    private Panneau dessin;
    private JPanel menu;
    private Jeu jeu;
    private int largeur = 600;
    private int hauteur = 600;
    private AfficheJeu aff;
    private AvanceJeu avc;

    private void setListe(){
        liste.addItem("Grille Vide");
        liste.addItem("Bloc");
        liste.addItem("Tube");
        liste.addItem("Bateau");
        liste.addItem("Ruche");
        liste.addItem("Hamecon");
        liste.addItem("Clignotant");
        liste.addItem("Grenouille");
        liste.addItem("Horloge");
        liste.addItem("Pentadecathlon");
        liste.addItem("Galaxie");
        liste.addItem("Glisseur");
        liste.addItem("Vaisseau Leger");
        liste.addItem("Pentamino");
        liste.addItem("Canon");
    }
}
