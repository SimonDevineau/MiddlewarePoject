package fr.emn.examination.validation;

/**
 * 
 * @author M Herve Grall
 *	La classe Diff permet de calculer le taux de ressemblance de deux chaines de caracteres
 *	en se basant sur l'algorithme de la longueur de la plus longue sequence commune.
 *
 *	Pour obtenir le taux de ressemblance de deux chaines de caracteres appeler : 
 *		Diff.tauxRessemblance(chaine1, chaine2)
 *
 *	Pour savoir si une chaine de caracteres est egale a une chaine de reference a un
 *	pourcentage de ressemblance minimum près appeler :
 *		Diff.estValide(chaineATester, chaineDeReference, pourcentageMin)
 */
public class Diff {

    private static int[][] resultatMemorise;
    
    public static int longueurPlusGrandChaineCommune(String mot1, String mot2){
	int l1 = mot1.length();
	int l2 = mot2.length();
	char[] suite1 = new char[l1];
	char[] suite2 = new char[l2];
	mot1.getChars(0, l1, suite1, 0);
	mot2.getChars(0, l2, suite2, 0);              
	resultatMemorise = new int[l1][l2];
	for(int i = 0; i <l1; i++){
	    for(int j = 0; j < l2; j++){
		resultatMemorise[i][j] = -1;
	    }
	}
	return longueurPlusGrandChaineCommuneRec(suite1, 0, suite2, 0);
    }
    
    
    private static int longueurPlusGrandChaineCommuneRec(char[] suite1, int i1, char[] suite2, int i2){
	int resultat = 0;
	int l1 = suite1.length;
	int l2 = suite2.length;
	if(i1 == l1) return 0;
	if(i2 == l2) return 0;
	if(suite1[i1] == suite2[i2]){
	    int bas = 0;
	    int droite = 0;
	    int diagonale = 0;
	    if((i2 + 1) < l2){  
		if(resultatMemorise[i1][i2 + 1] != -1){
		    bas = resultatMemorise[i1][i2 + 1];
		}else{
		    bas = longueurPlusGrandChaineCommuneRec(suite1, i1, suite2, i2 + 1);
		    resultatMemorise[i1][i2 + 1] = bas;
		}
		resultat = bas;
	    }else{
		resultat = 0;
	    }
	    if((i1 + 1) < l1){  
		if(resultatMemorise[i1 + 1][i2] != -1){
		    droite = resultatMemorise[i1 + 1][i2];
		}else{
		    droite = longueurPlusGrandChaineCommuneRec(suite1, i1 + 1, suite2, i2);
		    resultatMemorise[i1 + 1][i2] = droite;
		}
		resultat = resultat < droite ? droite : resultat;
	    }else{
		resultat = resultat;
	    }
	    if(((i1 + 1) < l1) && ((i2 + 1) < l2)){  
		if(resultatMemorise[i1 + 1][i2 + 1] != -1){
		    diagonale = resultatMemorise[i1 + 1][i2 + 1];
		}else{
		    diagonale = longueurPlusGrandChaineCommuneRec(suite1, i1 + 1, suite2, i2 + 1);
		    resultatMemorise[i1 + 1][i2 + 1] = diagonale;
		}
		resultat = resultat < diagonale + 1 ? diagonale + 1 : resultat;
	    }else{
		resultat = 1;
	    }
	}else{
	    int bas = 0;
	    int droite = 0;
	    if((i2 + 1) < l2){  
		if(resultatMemorise[i1][i2 + 1] != -1){
		    bas = resultatMemorise[i1][i2 + 1];
		}else{
		    bas = longueurPlusGrandChaineCommuneRec(suite1, i1, suite2, i2 + 1);
		    resultatMemorise[i1][i2 + 1] = bas;
		}
		resultat = bas;
	    }
	    if((i1 + 1) < l1){  
		if(resultatMemorise[i1 + 1][i2] != -1){
		    droite = resultatMemorise[i1 + 1][i2];
		}else{
		    droite = longueurPlusGrandChaineCommuneRec(suite1, i1 + 1, suite2, i2);
		    resultatMemorise[i1 + 1][i2] = droite;
		}
		resultat = resultat < droite ? droite : resultat;
	    }
	}
	return resultat;
    }
    
    /**
     * Fonction retournant le taux de ressemblance entre essai et reponse.
     * @param essai : la chaine a tester
     * @param reponse : la chaine de référence
     * @return le taux de ressemblance
     */
    public static double tauxRessemblance(String essai, String reponse){
	int l1 = essai.length();
	int l2 = reponse.length();
	if(l1 == 0) return 0.0;
	if(l2 == 0) return 0.0;
	int n = longueurPlusGrandChaineCommune(essai, reponse);
	double p1 = (double)n/(double)l1 * 100;
	double p2 = (double)n/(double)l2 * 100; 
	return (p1 < p2)? p1 : p2;
    }

    /**
     * Fonction permettant de verifier si la chaine aTester a un taux de ressemblance 
     * superieur a pourcentageMin avec la chaine reponse.
     * @param aTester : la chaine a tester
     * @param reponse : la chaine de reference
     * @param pourcentageMin : le pourcentage de ressemblance minimum a verifier
     * @return true si le taux de ressemblance est superieur au pourcentage minimum
     */
    public static boolean estValide(String aTester, String reponse, double pourcentageMin) {
    	return tauxRessemblance(aTester, reponse) >= pourcentageMin;
    }
    
    /**
     * Fonction main pour les essais
     */
    public static void main(String[] args){
	System.out.println(tauxRessemblance(args[0], args[1]));
	System.out.println(estValide(args[0], args[1], 85));
	//test();
    }
    
    /**
     * Tests
     */
    private static void test(){
	System.out.println("0.0 : " + tauxRessemblance("", ""));			   
	System.out.println("0.0 : " + tauxRessemblance("", "a"));
	System.out.println("100.0 : " + tauxRessemblance("a", "a"));
	System.out.println((800.0/9.0) + " : " + tauxRessemblance("notredame", "notredaem"));			   
	System.out.println("80.0 : " + tauxRessemblance("notredame", "notredaems"));			   
	System.out.println("90.0 : " + tauxRessemblance("notredame", "notredames"));			   
    }
}