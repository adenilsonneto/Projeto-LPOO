package cartas;

public class FrancoAtirador extends Criatura {
	public FrancoAtirador() {
		super();
		ataque(4);
		defesa(3);
		defesaMax(3);
		setNome("Franco Atirador");
		setMana(4);
		setId("15");
		mudarEstado();
	}
}
