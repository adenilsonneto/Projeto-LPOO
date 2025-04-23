package cartas;

public class ZebraTroia extends Criatura {
	private boolean anular;
	public ZebraTroia() {
		super();
		ataque(1);
		defesa(5);
		defesaMax(5);
		setNome("Zebra de Troia");
		setMana(4);
		setId("35");
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
