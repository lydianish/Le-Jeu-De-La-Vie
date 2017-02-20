import javax.swing.JPanel;
import java.awt.Graphics;

public class Panneau extends JPanel{

	public Panneau (){
		super();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawRect (5, 15, 50, 75);
   }
		
	
}
