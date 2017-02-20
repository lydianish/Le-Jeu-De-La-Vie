public class Jeu{

    public Jeu(int l, int c) throws IllegalArgumentException{
		g = new Grille(l,c);
        attente = 1000;
        etatCourant = new int[l][c];
	}

    public Jeu(Grille g, int attente){
        this.g = g;
        this.attente = attente;
        etatCourant = new int[g.getHauteur()][g.getLargeur()];
        setEtatCourant();
    }

    private  void setEtatCourant(){
        for (int i=0; i<g.getHauteur(); i++){
            for (int j=0; j<g.getLargeur(); j++)
                etatCourant[i][j] = g.nbVoisins(i,j);
        }
    }



	public synchronized void avance(){
		
		if (!pret){
            //recensement du nombre de voisins de chaque cellule a l'etape precedent
            setEtatCourant();
            //mise a jour
            for (int i=0; i<g.getHauteur(); i++) {
                for (int j = 0; j < g.getLargeur(); j++) {
                    if (!g.estOccupee(i,j)) {
                        if (etatCourant[i][j]==3) //reproduction
                            g.ajouteCellule(i,j);
                    }
                    else{
                        if (etatCourant[i][j]<=1 || etatCourant[i][j]>=4)//isolement ou etouffement
                            g.supprimeCellule(i,j);
                        //sinon : la cellule de maintient en vie -> rien a faire
                    }
                }
            }
            notifyAll();
            pret = true;

		}
		else {
            try {
                wait();
            }
            catch (InterruptedException e){System.out.println("Avancement interrompu");}
        }
	}

    public synchronized void affiche(){
        if (pret){
            g.affiche();
            notifyAll();
            pret = false;
        }
		else {
            try {
                wait();
            }
            catch (InterruptedException e){System.out.println("Affichage interrompu");}
        }
    }

    private Grille g;
    private int[][] etatCourant;
    private int attente;
    private boolean pret = true;

    public Grille getGrille(){return g;}
    public int[][] getEtatCourant(){return etatCourant;}
    public int getAttente(){return attente;}
}
