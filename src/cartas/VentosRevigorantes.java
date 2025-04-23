package cartas;

public class VentosRevigorantes extends Encantamentos{

    public VentosRevigorantes(){
        super();
        setNome("Ventos Revigorantes");
        setMana(4);
        danoEfeitoContinuo(-1);   
        setValidacao("Buff"); 
    }
    public void buffUm(int turnoAtual, Criatura destino){
    	destino.curas(turnoAtual);
    	
    }
}