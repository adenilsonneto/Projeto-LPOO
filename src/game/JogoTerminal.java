package game;

import java.util.Scanner;

import arenas.ArenaCombate;
import excecoes.CreatureCannotAttackException;
import excecoes.EmptyDeckException;
import excecoes.ManaInsuficienteException;
import menu.FimDaBatalha;
import menu.MontadorDeck;
import menu.NomearJogadores;

public class JogoTerminal {
	public static void main(String[] args) throws ManaInsuficienteException, CreatureCannotAttackException, EmptyDeckException {
		NomearJogadores nomeio = new NomearJogadores();
		MontadorDeck deck = new MontadorDeck();
		ArenaCombate arena = new ArenaCombate();
		FimDaBatalha batalhaFim = new FimDaBatalha();
		Scanner ler = new Scanner(System.in);
		nomeio.nomearJogadores(ler);
		nomeio.transferirJogadores(deck);
		deck.escolherCarta(ler);
		deck.transferirJogadores(arena);
		while(batalhaFim.getVerdade() == true) {
		arena.vezJogador(ler);
		arena.jogadoresResetDeck();
		arena.transferirJogadores(batalhaFim);
		arena.removerJogadores();
		batalhaFim.fimDeJogo(ler);
		batalhaFim.transferirJogadores(arena);
		batalhaFim.removerJogadores();
		arena.resetTurno();
		}
		ler.close();
	}
}
