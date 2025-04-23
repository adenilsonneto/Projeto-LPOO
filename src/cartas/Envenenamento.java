package cartas;



public class Envenenamento extends Encantamentos {
	public Envenenamento(){
        super();
        setNome("Envenenamento");
        setMana(3);
        danoEfeitoContinuo(1);
        setValidacao("Debuff");
    }
    public void buffUm(int turnoAtual, Criatura destino){
    	destino.envenenado(turnoAtual);
    	
    }
   
}