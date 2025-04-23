package cartas;



import interfaces.Atacavel;



public class Criatura extends Carta implements Atacavel{
	private String id;
	private int poder; 
	private int resistencia;
	private int maxResistencia;
	private int vezAtual;
	private int vezEfeito;
	private boolean estado;
	private boolean queimado;
	private boolean congelado;
	private boolean envenenado;
	private boolean curado;
	private boolean provocar;
	public Criatura() {
		setEstado();
		setQueimado();
		setCongelado();
		setEnvenenado();
		setProvocar();
		setCuras();
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return this.id;
	}
	public void setVez(int vez) {
		this.vezAtual = vez;
	}
	public int getVez() {
		return this.vezAtual;
	}
	public void setVezEfeito(int vez) {
		this.vezEfeito = vez;
	}
	public int getVezEfeito() {
		return this.vezEfeito;
	}
	public void ataque(int dano) {
		this.poder = dano;
	}
	public void defesa(int defesa) {
		this.resistencia = defesa;
	}
	public int getDefesaMax() {
		return this.maxResistencia;
	}
	public void defesaMax(int defesa) {
		this.maxResistencia = defesa;
	}
	
	public void receberDano(int dano) {
		this.resistencia = this.resistencia - dano;
		if(this.resistencia > this.maxResistencia) {
			this.resistencia = this.maxResistencia;
		}
	}
	
	public int getPoder() {
		return this.poder;
	}
	
	public int getDefesa() {
		return this.resistencia;
	}
	
	public void setEstado() {
		this.estado = true;
	}
	
	public boolean getEstado() {
		return this.estado;
	}
	
	public void mudarEstado() {
		this.estado = false;
	}

	public void atacar(Atacavel destino) {
		this.ataque(poder);
		destino.receberDano(poder);
	}

	public void setQueimado() {
		this.queimado = false;
	}
	public void queimado(int vez) {
		setVezEfeito(vez);
		this.queimado = true;
		this.congelado = false;
		
	}
	public boolean getQueimado() {
		return this.queimado;
	}
	public void queimaduras() {
		if(this.queimado == true) {
			if(this.vezAtual == this.vezEfeito + 1) {
				this.resistencia = this.resistencia - 1;
				this.queimado = false;
			}
		}
	}

	public void setCongelado() {
		this.congelado = false;
	}
	public boolean getCongelado() {
		return this.congelado;
	}
	public void congelado(int vez) {
		setVezEfeito(vez);
		this.congelado = true;
	}
	public void gelado() {
		if(this.congelado == true) {
			if(this.vezAtual == this.vezEfeito) {
				this.estado = true;
			}
			else if(this.vezAtual == this.vezEfeito + 1) {
				this.congelado = false;
				this.estado = false;
			}
		}		
	}
	public void setEnvenenado() {
		this.envenenado = false;
	}
	public boolean getEnvenenado() {
		return this.envenenado;
	}
	public void envenenado(int vez) {
		setVezEfeito(vez);
		this.envenenado = true;
	}
	public void envenenar() {
		if(this.envenenado == true) {
			if(this.vezAtual == this.vezEfeito + 1) {
				this.resistencia = this.resistencia - 1;
				this.vezEfeito = this.vezAtual;
			}
		}
	}
	public void setCuras() {
		this.curado = false;
	}
	public boolean getCuras() {
		return this.curado;
	}
	public void curas(int vez) {
		setVezEfeito(vez);
		this.curado = true;
	}
	public void curar() {
		if(this.curado == true) {
			if(this.vezAtual == this.vezEfeito + 1) {
				this.resistencia = this.resistencia + 1;
				if(this.resistencia > this.maxResistencia) {
					this.resistencia = this.maxResistencia;
				}
				this.vezEfeito = this.vezAtual;
			}
		}
	}
	public void setProvocar() {
		this.provocar = false;
	}
	public void provocar() {
		this.provocar = true;
	}
	public boolean getProvocar() {
		return this.provocar;
	}
}


