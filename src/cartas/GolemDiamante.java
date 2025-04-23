package cartas;

public class GolemDiamante extends Criatura {
	public GolemDiamante() {
		super();
		ataque(1);
		defesa(9);
		defesaMax(9);
		setNome("Golem de Diamante");
		setMana(7);
		setId("21");
		provocar();
	}
}
