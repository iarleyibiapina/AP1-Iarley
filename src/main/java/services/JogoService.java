package services;

import java.util.Random;

import entidades.Jogada;

public class JogoService {
	private static final String[] JOGO = {"pedra", "papel", "tesoura"};
    private static final Random RANDOM = new Random();
    
    public static Jogada atribuirJogadas(Jogada jogada)
	{
    	if(jogada == null) {
    		throw new IllegalArgumentException("Jogada nula");
    	}
    	int indice1 = RANDOM.nextInt(JOGO.length); 
        int indice2 = RANDOM.nextInt(JOGO.length);
        jogada.setJogada1(JOGO[indice1]); 
        jogada.setJogada2(JOGO[indice2]);
        return jogada;
	}
  
    public static Jogada definirVencedor(Jogada jogada)
    {
    	if (jogada == null || 
    		jogada.getJogada1() == null || 
    		jogada.getJogada2() == null) {
            throw new IllegalArgumentException("Jogada ou suas jogadas individuais não podem ser null");
        }
    	
    	String jogada1 = jogada.getJogada1().toLowerCase();
    	String jogada2 = jogada.getJogada2().toLowerCase();

    	if (jogada1.equals(jogada2)) {
            jogada.setResultado("Empate");
            return jogada;
        }
        if ((jogada1.equals("pedra") && jogada2.equals("tesoura")) ||
            (jogada1.equals("papel") && jogada2.equals("pedra")) ||
            (jogada1.equals("tesoura") && jogada2.equals("papel"))) {
            jogada.setResultado("Jogador 1 venceu");
        } else {
        	jogada.setResultado("Jogador 2 venceu");
        }
        return jogada;
    }
}	
