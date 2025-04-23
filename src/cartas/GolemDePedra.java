package cartas;

public class GolemDePedra extends Criatura {
	public GolemDePedra() {
		super();
		ataque(1);
		defesa(7);
		defesaMax(7);
		setNome("Golem de Pedra");
		setMana(4);
		setId("20");
		provocar();
	}
}
