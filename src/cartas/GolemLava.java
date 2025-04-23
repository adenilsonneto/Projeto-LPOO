package cartas;

public class GolemLava extends Criatura {
	public GolemLava() {
		super();
		ataque(3);
		defesa(4);
		defesaMax(4);
		setNome("Golem de Lava");
		setMana(4);
		setId("22");
		mudarEstado();
	}
}
