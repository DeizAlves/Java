	package projeto;
	
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import java.io.IOException;
	import java.io.LineNumberReader;
	import java.util.Random;
	import java.util.Scanner;
	
	public class JogoDaForca {
		
		public static void main (String [] srgs) throws Exception {
			
			//Sorteador
			Random random = new Random();
			
			//Scanner
			Scanner in = new Scanner (System.in);
		
			// CARREGAR PALAVRAS DE UM ARQUIVO
			LineNumberReader leitorLinhas = new LineNumberReader(new FileReader("BancoPalavras.txt"));
			leitorLinhas.skip(Long.MAX_VALUE);
			int quantPalavras = leitorLinhas.getLineNumber() + 1; 
			System.out.println("\nJogo da forca, temos " + quantPalavras + " palavras. \nBoa sorte.");
			leitorLinhas.close();
			
			String[] palavras = new String[quantPalavras];
			
			BufferedReader leitorArquivo = new BufferedReader(new FileReader ("BancoPalavras.txt"));
			String linhaLida;
			int linha = 0;
			while ((linhaLida = leitorArquivo.readLine()) != null) {
				palavras[linha] = linhaLida;
				linha++;
			}
			leitorArquivo.close();
			
			//Quantidade de palavras
			int indiceSorteado = random.nextInt(quantPalavras);
			String sorteada = palavras [indiceSorteado]; 
				
			char[] acertos = new char[sorteada.length()];
			for (int i = 0; i < acertos.length; i++) {
				acertos[i] = 0;
				
			}
			String letrasUtilizadas = "";
			
			char letra;
			boolean ganhou = false;
			int vidas = sorteada.length();
	
			
			do {
				
				System.out.print(" \n"
						+ "Você tem " + vidas +" vidas "
						+"\nLetras utilizadas: " + letrasUtilizadas
						+"\nQual letra você deseja tentar? Vocês pode tentar a palavra: ");
				
				String digitado = in.next().toUpperCase();
				
				if (digitado.length() > 1) {
					if (digitado.equals(sorteada)){
						ganhou = true;
						break;
					} else {
						vidas = 0;
						break;
					}
				} else {
					letra = digitado.charAt(0);
					letrasUtilizadas += " " + letra;
				
					boolean perdeVida = true;
					for (int i = 0; i < sorteada.length(); i++) {
					
						if (letra == sorteada.charAt(i)) {
						acertos[i] = 1;
						perdeVida = false; 
					}
				
				}
			
			if (perdeVida) {
					vidas --;
					
				}
			}
			System.out.println("\n");
			ganhou = true;
			for (int i = 0; i < sorteada.length(); i++) {
				
				if (acertos[i]==0) {
					System.out.print(" _ ");
					ganhou = false;
				}	else {
					System.out.print(" " + sorteada.charAt(i) + " ");
				
					}
				}
				System.out.println("\n");
	
		} while (!ganhou && vidas > 0); //se não ganhou e se ainda tem vidas ... repete
			
		if (vidas != 0) {
			System.out.println("\n\t *** Você ganhou !!!***");
		} else {
			System.out.println("\n\t Fim do jogo :( ...");
			System.out.println("\tA palavra era " + sorteada );
		}
		
		
		}
	}

