
public class Jeu{

    public Jeu(int l, int c) throws IllegalArgumentException{
		g = new Grille(l,c);
        etatCourant = new int[l][c];
	}

    public Jeu(Grille g){
        this.g = g;
        etatCourant = new int[g.getHauteur()][g.getLargeur()];
        setEtatCourant();
    }

    private void setEtatCourant(){
        for (int i=0; i<g.getHauteur(); i++){
            for (int j=0; j<g.getLargeur(); j++)
                etatCourant[i][j] = g.nbVoisins(i,j);
        }
    }

    public void avance(){
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
        }


    public void clear(){
        g.clear();
        etatCourant = new int[g.getHauteur()][g.getLargeur()];

    }

    public void setCell(int i, int j){
        if (g.estOccupee(i,j))
            g.supprimeCellule(i,j);
        else
            g.ajouteCellule(i,j);
    }

    /*Structures stables*/

    public void bloc(int x, int y){
        ligneV(x,y,2);
        ligneV(x,y+1,2);
        setEtatCourant();
    }

    public void tube(int x, int y) {
        g.ajouteCellule(x, y);
        g.ajouteCellule(x, y + 2);
        g.ajouteCellule(x - 1, y + 1);
        g.ajouteCellule(x + 1, y + 1);
        setEtatCourant();
    }

    public void bateau(int x, int y){
        g.ajouteCellule(x,y);
        g.ajouteCellule(x,y+1);
        g.ajouteCellule(x+1,y);
        g.ajouteCellule(x+1,y+2);
        g.ajouteCellule(x+2,y+1);
        setEtatCourant();
    }

    public void ruche(int x, int y){
        ligneV(x,y,2);
        ligneV(x,y+2,2);
        g.ajouteCellule(x-1,y+1);
        g.ajouteCellule(x+2,y+1);
        setEtatCourant();
    }

    public void hamecon(int x, int y){
        g.ajouteCellule(x,y);
        ligneV(x,y+1,3);
        g.ajouteCellule(x+2,y+3);
        ligneH(x+3,y+2,2);
        setEtatCourant();
    }

    /*Structure Periodiques*/

    public void clignotant(int x, int y){
        ligneV(x,y,3);
        setEtatCourant();
    }

    public void grenouille(int x, int y){
        g.ajouteCellule(x,y);
        bloc(x-1,y+1);
        g.ajouteCellule(x-1,y+3);
        setEtatCourant();
    }
    public void horloge(int x, int y){
        //blocs :
        bloc(x,y);
        bloc(x-4,y+6);
        bloc(x+6,y+4);
        bloc(x+2,y+10);
        //carre du milieu :
        ligneV(x,y+3,4);
        ligneV(x,y+8,4);
        ligneH(x-1,y+4,4);
        ligneH(x+4,y+4,4);
        //interieur du carre :
        g.ajouteCellule(x+1,y+4);
        ligneH(x+2,y+5,2);
        setEtatCourant();
    }

    public void pentadecathlon(int x, int y){
        ligneV(x,y,3);
        ligneV(x,y+9,3);
        ligneH(x-3,y+4,2);
        ligneH(x+5,y+4,2);
        g.ajouteCellule(x-1,y+1);
        g.ajouteCellule(x-2,y+2);
        g.ajouteCellule(x+3,y+1);
        g.ajouteCellule(x+4,y+2);
        g.ajouteCellule(x-2,y+7);
        g.ajouteCellule(x-1,y+8);
        g.ajouteCellule(x+4,y+7);
        g.ajouteCellule(x+3,y+8);
        setEtatCourant();
    }

    public void galaxie(int x, int y){
        ligneV(x,y,6);
        ligneV(x,y+1,6);
        ligneH(x,y+3,6);
        ligneH(x+1,y+3,6);
        ligneH(x+7,y,6);
        ligneH(x+8,y,6);
        ligneV(x+3,y+7,6);
        ligneV(x+3,y+8,6);
        setEtatCourant();
    }

    /*Structures vaisseau*/

    public void glisseur(int x, int y){
        ligneH(x,y,3);
        g.ajouteCellule(x-2,y+1);
        g.ajouteCellule(x-1,y+2);
        setEtatCourant();
    }

    public void vaisseauLeger(int x, int y){
        g.ajouteCellule(x,y);
        g.ajouteCellule(x+2,y);
        g.ajouteCellule(x,y+3);
        ligneH(x+3,y+1,4);
        ligneV(x+1,y+4,2);
        setEtatCourant();
    }

    /*Autres structures*/

    public void pentamino(int x, int y){
        g.ajouteCellule(x,y);
        ligneV(x-2,y+1,3);
        g.ajouteCellule(x-1,y+2);
        setEtatCourant();
    }

    public void canon(int x, int y){
        bloc(x,y);
        ligneV(x,y+10,3);
        g.ajouteCellule(x-1,y+11);
        g.ajouteCellule(x+3,y+11);
        ligneH(x-2,y+12,2);
        ligneH(x+4,y+12,2);
        g.ajouteCellule(x+1,y+14);
        g.ajouteCellule(x-1,y+15);
        g.ajouteCellule(x+3,y+15);
        ligneV(x,y+16,3);
        g.ajouteCellule(x+1,y+17);
        ligneV(x-2,y+20,3);
        ligneV(x-2,y+21,3);
        g.ajouteCellule(x-3,y+22);
        g.ajouteCellule(x+1,y+22);
        ligneV(x-4,y+24,2);
        ligneV(x+1,y+24,2);
        bloc(x-2,y+34);
        setEtatCourant();
    }


    /*Selecteurs*/

    public Grille getGrille(){return g;}

    public int getHauteur(){return g.getHauteur();}

    public int getLargeur(){return g.getLargeur();}

    /*Champs et methodes privees*/

    private void ligneV(int x, int y, int l){
        for (int i = 0; i<l; i++)
            g.ajouteCellule(x+i,y);
    }

    private void ligneH(int x, int y, int l){
        for (int i = 0; i<l; i++)
            g.ajouteCellule(x,y+i);
    }

    private Grille g;
    private int[][] etatCourant;


}
