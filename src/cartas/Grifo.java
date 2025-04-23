package cartas;

public class Grifo extends Criatura {
	public Grifo() {
		super();
		ataque(3);
		defesa(6);
		defesaMax(6);
		setNome("Grifo");
		setMana(5);
		setId("23");
		mudarEstado();
	}
}
