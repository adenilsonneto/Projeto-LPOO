package cartas;

public class DragãoDoAbismo extends Criatura {
	private boolean anular;
	public DragãoDoAbismo() {
		super();
		ataque(2);
		defesa(5);
		defesaMax(5);
		setNome("Dragão do Abismo");
		setMana(6);
		setId("10");
		setAnular();
	}
	public void setAnular() {
		this.anular = true;
	}
	public void receberDano(int dano) {
		if(this.anular == true) {
			this.anular = false;
		}
		else {
			super.receberDano(dano);
		}
	}
}
