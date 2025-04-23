package cartas;



public class BolaDeNeve extends Feiticos {
	public BolaDeNeve(){
		super();
	    setMana(2);
	    setNome("Bola de Neve");
	    danoEfeito(1);
	    setValidação("ataque um");
	    }
	public void jogarFeitico(Criatura destino, int turnoAtual) {
		destino.congelado(turnoAtual);
	}
	
}
