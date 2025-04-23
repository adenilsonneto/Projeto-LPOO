package cartas;

public class CavaleiroTrevas extends Criatura{
	public CavaleiroTrevas() {
		super();
		ataque(2);
		defesa(6);
		defesaMax(6);
		setNome("Cavaleiro das Trevas");
		setMana(5);
		setId("5");
	}
	public void queimado(int vez) {
		setQueimado();
	}
}
