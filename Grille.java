public class Grille {
	
	public Grille(int l, int c) throws IllegalArgumentException{
		if (l<0 || c<0) throw new IllegalArgumentException("taille de la grille non valide");
		nblig = l;
		nbcol = c;
		grille = new boolean [l][c];
		
	}
	
	public  void ajouteCellule(int i, int j) throws IllegalArgumentException{
		verifieIndices(i,j);
		grille[i][j] = true;	
	}
	
	public  void supprimeCellule(int i, int j) throws IllegalArgumentException{
		verifieIndices(i,j);
		grille[i][j] = false;	
	}
	
	public  boolean estOccupee(int i, int j)throws IllegalArgumentException{
		verifieIndices(i,j);
		 return grille[i][j];	
	}
	
	public  int nbVoisins(int i, int j)throws IllegalArgumentException{
		
		verifieIndices(i,j);
		
		int debutL, finL, debutC, finC; //indices de debut et fin de parcours de lignes/colonnes
		int v = 0; //nombre de voisins
		
		//indice de debut dde parcours sur une ligne
		if (i>0)
			debutL = i-1;
		else
			debutL = 0;
		//indice de debut dde parcours sur une colonne
		if (j>0)
			debutC = j-1;
		else
			debutC = 0;
		//indice de fin dde parcours sur une ligne
		if (i<nblig-1)
			finL = i+1;
		else
			finL = nblig-1;
		//indice de fin dde parcours sur une colonne
		if (j<nbcol-1)
			finC = j+1;
		else
			finC = nbcol-1;
		
		//parcours
		for (int l=debutL ; l<=finL; l++){
			for (int c=debutC; c<=finC; c++){
				if (grille[l][c])
					v++;
			}
		}
		
		if (estOccupee(i,j))//la cellule courant a ete comptee
			v--;
			
		return v;
	}
	
	public void affiche(){
		//barre horizontale sup
		System.out.print(" ");
		for (int k=0; k<nbcol;k++)
			{System.out.print("-");}
		System.out.println();
		
		for(int i=0; i<nblig;i++){
			System.out.print("|");//barre verticale gauche
			for (int j=0; j<nbcol;j++){
				if (estOccupee(i,j))
					System.out.print("0");//cellule
				else
					System.out.print(" ");//case vide
			}
			System.out.println("|");//barre verticale droite
		}
		
		//barre horizontale inf
		System.out.print(" ");
		for (int k=0; k<nbcol;k++)
			System.out.print("-");
		System.out.println();
	}


	private int nblig;
	private int nbcol;
	private  boolean[][] grille;

	private void verifieIndices(int i, int j) throws IllegalArgumentException{
		if (i<0 || j<0 || i>=nblig || j>=nbcol)
			throw new IllegalArgumentException("indice de la grille non valide");
	}

	public int getHauteur(){return nblig;}
	public int getLargeur(){return nbcol;}
}
