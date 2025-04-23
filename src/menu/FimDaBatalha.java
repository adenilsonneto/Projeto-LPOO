package menu;

import java.util.ArrayList;
import java.util.Scanner;

import arenas.ArenaCombate;
import jogadores.Jogador;

public class FimDaBatalha {
	private ArrayList<Jogador> jogadores;
	private boolean verdade;
	
	public FimDaBatalha() {
		this.jogadores = new ArrayList<>();
		this.verdade = true;
	}
	public void receberJogadores(Jogador jogador) {
		this.jogadores.add(jogador);
	}
	public void verificarJogador(Scanner ler) {
		for(int i = 0; i < jogadores.size(); i++) {
			if(jogadores.get(i).getVida() > 0) {
				jogadores.get(i).evoluirNivel();
				jogadores.get(i).venceu();
				System.out.println(jogadores.get(i).getNome() + " evoluiu de nível");
				mudarNomeCarta(ler, jogadores.get(i), jogadores.get(1-i));
			}
			else if(jogadores.get(i).getVida() <= 0) {
				jogadores.get(i).perdeu();
			}
		}
	}
	public void mudarNomeCarta(Scanner ler, Jogador jogador, Jogador oponente) {
		System.out.println(jogador.getNome() + " Você pode mudar o nome de uma carta (m) ou ignorar (i)");
		String input = ler.nextLine();
		if(input.equals("m")) {
			System.out.println(jogador.getNome() + " Você deseja mudar o nome de uma carta sua (c) ou uma carta do seu oponente (o)");
			String input2 = ler.nextLine();
			if(input2.equals("c")) {
				System.out.println("Escolha uma carta de seu deck para mudar o nome");
				jogador.printDeck();
				int i = Integer.parseInt(ler.nextLine());
				System.out.println("agora digite o novo nome dessa carta");
				String input3 = ler.nextLine();
				jogador.getCartaDeck(i-1).setNome(input3);
			}
			else if(input2.equals("o")) {
				System.out.println("Escolha uma carta do deck de seu oponente para mudar o nome");
				oponente.printDeck();
				int i = Integer.parseInt(ler.nextLine());
				System.out.println("agora digite o novo nome dessa carta");
				String input3 = ler.nextLine();
				oponente.getCartaDeck(i-1).setNome(input3);
			}
		}
	}
	public void telaParaRejogar(Scanner ler) {

		System.out.println(jogadores.get(0).getNome() + " (Nível " + jogadores.get(0).getNivel() + ")" + " Vitorias: " + jogadores.get(0).getVitorias() + " Derrotas: " + jogadores.get(0).getDerrotas());
		System.out.println(jogadores.get(1).getNome() + " (Nível " + jogadores.get(1).getNivel() + ")" + " Vitorias: " + jogadores.get(1).getVitorias() + " Derrotas: " + jogadores.get(1).getDerrotas());
		System.out.println("Deseja rejogar (r)");
		String input = ler.nextLine();
		if(input.equals("r")) {
			this.verdade = true;
		}
		else {
			this.verdade = false;
		}
	}
	public void fimDeJogo(Scanner ler) {
		verificarJogador(ler);
		telaParaRejogar(ler);
	}
	public void removerJogadores() {
	    for(int i = this.jogadores.size() - 1; i >= 0; i--) {
	        jogadores.remove(i);
	    }
	}
	public void transferirJogadores(ArenaCombate arena) {
		arena.receberJogadores(jogadores.get(0));
		arena.receberJogadores(jogadores.get(1));
	}
	public boolean getVerdade() {
		return this.verdade;
	}
}
