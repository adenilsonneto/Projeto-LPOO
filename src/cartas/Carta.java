package cartas;

import interfaces.Atacavel;

public abstract class Carta {
	private String nome;
	private int custoMana;
	
	
	public String toString() {
		return nome;
    }
	public int getMana() {
		return this.custoMana;
	}
	public void setMana(int mana) {
		this.custoMana = mana;
	}
	public void setNome(String nome) {
		this.nome = nome;	
	}
	public abstract void atacar(Atacavel destino);
}
