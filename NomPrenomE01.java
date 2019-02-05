// Votre entête ici

import java.io.*;

//============================================================== 12951 A16 ===
public class NomPrenomE01
//============================================================== 12951 A16 ===
{

	//VOUS NE DEVEZ PAS TOUCHER AU CODE DE CETTE MÉ‰THODE
	//---------------------------------------------------------- 12951 A16 ---
	public static void main(String[] args) 
	//---------------------------------------------------------- 12951 A16 ---
	{
		String input = lireFichier();
		String output = fabriquerRapport(input);
		ecrireFichier(output);
	}
	
	//VOUS NE DEVEZ PAS TOUCHER AU CODE DE CETTE MÉ‰THODE
	//---------------------------------------------------------- 12951 A16 ---
	private static String lireFichier() 
	//---------------------------------------------------------- 12951 A16 ---
	{
		String texte = "";
		try {
			BufferedReader br = new BufferedReader( new FileReader("input.txt" ) );
			String ligne;
			while( (ligne = br.readLine()) != null ) {
				texte += ligne + "\n";
			}
			br.close();
		}
		catch( IOException ioe ) {
		}
		return texte;
	}

	//VOUS NE DEVEZ PAS TOUCHER AU CODE DE CETTE MÉ‰THODE
	//---------------------------------------------------------- 12951 A16 ---
	private static void ecrireFichier(String output) 
	//---------------------------------------------------------- 12951 A16 ---
	{
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
			pw.print( output );
			pw.close();
		}
		catch( IOException ioe ) {		
		}
	}

	//CETTE MÉTHODE EST LA SEULE QUE VOUS DEVEZ MODIFIER
	//---------------------------------------------------------- 12951 A16 ---
	private static String fabriquerRapport(String input) 
	//---------------------------------------------------------- 12951 A16 ---
	{
		String output = "";
		
		//on etudie la chaine input et on construit la chaine output
		while(!input.isEmpty()) {
			//on va chercher la prochaine ligne
			String ligne;
			int indice = input.indexOf("\n");
			if( indice != -1) {
				ligne = input.substring(0,indice);
				input = input.substring(indice +1);
			}
			else{
				ligne = input;
				input = "";
			}
			//On extrait les infos de cette ligne
			indice = ligne.indexOf(":");
			String op = ligne.substring(0,indice);
			ligne = ligne.substring(indice+1);
			double valeur = 0.0;
			double min=0.0,max=0.0,somme=0.0,moyenne=0.0;
			int n = 0;
			String sTemp = "";
			while( !ligne.isEmpty()) {
				indice =  ligne.indexOf(":");
				if( indice != -1) {
					valeur = Double.parseDouble( ligne.substring(0, indice)); 
					ligne = ligne.substring(indice+1);
				}
				else{
					valeur = Double.parseDouble(ligne);
					ligne = "";
				}
				sTemp += String.format("%1$7.1f",valeur);
				n++;
				if(n==1){
					min = max = valeur;
				}
				else{
					if( valeur<min) min = valeur;
					if( valeur>max) max = valeur;
				}
				somme += valeur;
				
				
			}
			moyenne = somme/n;
			output += String.format("%1$7s = ", op);
			double resultat = 0.0;
			if( op.equals("min" )) resultat = min;
			else if(op.equals("max")) resultat = max;
			else if(op.equals("somme")) resultat = somme;
			else if(op.equals("moyenne")) resultat = moyenne;
			output += String.format("%1$7.1f", resultat);
			output += sTemp + "\n";
				
			}
			
		
		
		return output;
	}

}//Fin de la classe
