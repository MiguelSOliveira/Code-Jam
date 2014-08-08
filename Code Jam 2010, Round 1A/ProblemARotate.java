import java.util.Scanner;


public class ProblemARotate {

	static boolean avaliar(String teste, String res, boolean cor){
		if(teste.contains(res))
			return true;
		return cor;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int nCasos = sc.nextInt();
		for(int c = 1; c <= nCasos; c++){
			int medidas = sc.nextInt();
			int k = sc.nextInt();
			char[][] tabuleiro = new char[medidas][medidas];
			int lixo = 0;
			// Construir o tabuleiro
			for(int linhas = medidas-1; linhas >= 0; linhas--){
				String linha = sc.next();
				lixo = 0;
				for(int colunasunas = 0; colunasunas < medidas; colunasunas++){
					tabuleiro[linhas][colunasunas] = linha.charAt(lixo);
					lixo++;
				}
			}
			// Empurrar para a direita
			for (int linhas = 0; linhas < medidas; linhas++) {
		        int x = medidas-1;
		        for (int colunas = medidas-1; colunas >= 0; colunas--)
		          if (tabuleiro[linhas][colunas] != '.') {
		            tabuleiro[linhas][x] = tabuleiro[linhas][colunas]; 
		            x--;
		          }
		        while(x >= 0) {
		        	tabuleiro[linhas][x]='.'; 
		        	x--;
		        }
		      }
			boolean azul = false;
			boolean vermelho = false;
			String azulRes = "";
			String vermelhoRes = "";
			// Solucao para depois comparar a cada linha/coluna/diagonal
			while(k-- > 0){
				azulRes += "B";
				vermelhoRes += "R";
			}
			// Verificar horizontal
			String teste = "";
			for(int i = 0; i < medidas; i++){
				for(int j = 0; j < medidas; j++){
					teste += tabuleiro[i][j];
				}
				azul = avaliar(teste, azulRes, azul);
				vermelho = avaliar(teste, vermelhoRes, vermelho);
				teste = "";
			}
			// Verificar vertical
			for(int j = 0; j < medidas; j++){
				for(int i = 0; i < medidas; i++){
					teste += tabuleiro[i][j];
				}
				azul = avaliar(teste, azulRes, azul);
				vermelho = avaliar(teste, vermelhoRes, vermelho);
				teste = "";
			}
			// Verificar diagonal decrescente e crescente direita e esquerda
			for(int i = 0; i < medidas; i++){
				int j = 0;
				// Diagonal decrescente esquerda
				for(int d = 0; d < medidas-i; d++){
					teste += tabuleiro[i+d][j+d];
				}
				azul = avaliar(teste, azulRes, azul);
				vermelho = avaliar(teste, vermelhoRes, vermelho);
				teste = "";
				// Diagonal decrescente direita
				for(int d = 0; d < medidas - i; d++){
					teste += tabuleiro[j+d][i+d];
				}
				azul = avaliar(teste, azulRes, azul);
				vermelho = avaliar(teste, vermelhoRes, vermelho);
				teste = "";
				// Diagonal crescente esquerda
				for(int d = 0; d < i+1; d++){
					teste += tabuleiro[i-d][j+d];
				}
				azul = avaliar(teste, azulRes, azul);
				vermelho = avaliar(teste, vermelhoRes, vermelho);
				teste = "";
				//Diagonal crescente direita
				for(int d = 0; d < medidas-i; d++){
					teste += tabuleiro[i+d][medidas-1-d];
				}
				azul = avaliar(teste, azulRes, azul);
				vermelho = avaliar(teste, vermelhoRes, vermelho);
				teste = "";
			}
			String caso = "Case #" + c + ": ";
			if(vermelho && azul) System.out.println(caso + "Both");
			else if(azul) System.out.println(caso + "Blue");
			else if(vermelho) System.out.println(caso + "Red");
			else System.out.println(caso + "Neither");
		}
		sc.close();	
	}
}