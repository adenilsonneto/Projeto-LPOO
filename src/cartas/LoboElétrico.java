package cartas;

public class LoboElétrico extends Criatura {
	public LoboElétrico() {
		super();
		ataque(4);
		defesa(2);
		defesaMax(2);
		setNome("Lobo Elétrico");
		setMana(3);
		setId("30");
		mudarEstado();
	}
}
