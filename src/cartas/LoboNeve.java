package cartas;

public class LoboNeve extends Criatura {
	public LoboNeve() {
		super();
		ataque(2);
		defesa(3);
		defesaMax(3);
		setNome("Lobo da Neve");
		setMana(2);
		setId("31");
	}
	public void congelado(int vez) {
		setCongelado();
	}
}
