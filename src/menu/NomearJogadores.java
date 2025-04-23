package menu;

import java.util.ArrayList;
import java.util.Scanner;

import jogadores.Jogador;

public class NomearJogadores {
	private ArrayList<Jogador> jogadores;
	
	public NomearJogadores() {
		this.jogadores = new ArrayList<>();
		this.jogadores.add(new Jogador());
		this.jogadores.add(new Jogador());
	}
	
	public void nomearJogadores(Scanner ler) {
		for(int i = 0; i < this.jogadores.size(); i++) {
			System.out.println("digite o nome do Jogador " + (i+1));
			String input = ler.nextLine();
			jogadores.get(i).setNome(input);
		}
	}
	public void transferirJogadores(MontadorDeck montador) {
		montador.receberJogadores(jogadores.get(0));
		montador.receberJogadores(jogadores.get(1));
		
	}
	public ArrayList<Jogador> getJogadores(){
		return this.jogadores;
	}
}
