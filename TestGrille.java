public class TestGrille {

	public static void main(String[] args){
	
		Grille g = new Grille(3,3);
		
		g.ajouteCellule(0,1);
		g.ajouteCellule(1,1);
		g.ajouteCellule(2,1);

        Jeu j = new Jeu(g,1000);

        AfficheJeu aff = new AfficheJeu(j);
		AvanceJeu avc = new AvanceJeu(j);

        Fenetre f = new Fenetre(j);

       /*aff.start();
       avc.start();
        /*for (int i=1; i<=3; i++){
            try{
                Thread.sleep(j.getAttente());
            }
            catch (InterruptedException e){}
            j.avance();
            j.affiche();
		}*/
	}

}
