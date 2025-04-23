package cartas;

import java.util.ArrayList;

public class Cemiterio {
	private ArrayList<Carta> cartas;
	public Cemiterio() {
		this.cartas = new ArrayList<>();
	}
	public void receberCartas(Criatura criatura) {
		this.cartas.add(criatura);
	}
	public int getQuantidadeCartas() {
		return this.cartas.size();
	}
	public void printCemiterio() {
		if(this.cartas != null) {
			for(Carta carta : cartas) {
				if(carta instanceof Criatura) {
					Criatura criatura = (Criatura) carta;
					System.out.println(criatura);
				}
			}
		}
	}
}


