package cartas;

public class SerpenteGigante extends Criatura {
	public SerpenteGigante() {
		super();
		ataque(4);
		defesa(6);
		defesaMax(6);
		setNome("Serpente Gigante");
		setMana(5);
		setId("33");
		provocar();
	}
}
