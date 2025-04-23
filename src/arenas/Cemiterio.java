package arenas;

import java.util.ArrayList;

import cartas.Carta;
import jogadores.Jogador;





public class Cemiterio {
	private ArrayList<Carta> cartas;
	public Cemiterio() {
		this.cartas = new ArrayList<>();
	}
	public void receberCartas(Carta criatura) {
		this.cartas.add(criatura);
	}
	public int getQuantidadeCartas() {
		return this.cartas.size();
	}
	public void transferirCartasDeck(Jogador jogador) {
		for(int i = this.cartas.size() - 1; i >= 0; i--) {
			jogador.receberCarta(this.cartas.get(i));
			this.cartas.remove(i);
		}
	}
}



