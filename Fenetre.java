import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lydia on 15-Feb-17.
 */
public class Fenetre extends JFrame {

	
    public Fenetre(Jeu j){
        
        jeu = j;
        
        setTitle("Jeu de la vie");
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        start = new JButton("Start");
        stop = new JButton("Stop");
        clear = new JButton("Clear");
        dessin = new Panneau();
        menu =new JPanel();
        dessin.setBackground(Color.yellow);

		  contenu = getContentPane();
        //contenu.setLayout(new BoxLayout(contenu, BoxLayout.Y_AXIS));

        menu.setBackground(Color.green);;
        /*contenu.add(start);
        contenu.add(stop);
        contenu.add(clear);*/
		  
		  JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, dessin, menu);
		  split.setDividerLocation(0.5);
        contenu.add(split);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.out.println("start button clicked");
            }
        });
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("stop button clicked");
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clear button clicked");
            }
        });


    }
    
    

    private JButton start;
    private JButton stop;
    private JButton clear;
    private Panneau dessin;
    private JPanel menu;
    private Container contenu;
    private Jeu jeu;
}
