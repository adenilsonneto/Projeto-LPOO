package cartas;

public class Enfraquecimento extends Encantamentos{
    
    public Enfraquecimento(){
        super();
        setNome("Enfraquecimento");
        setMana(3);
        danoEfeitoContinuo(-1);
        setValidacao("Debuff");
    }
    public void buffUm(int dano, Criatura criatura){
    	int ataque = criatura.getPoder();
        ataque += super.getDanoEfeitoContinuo();
        criatura.ataque(ataque);
    }
}