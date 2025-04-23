package cartas;



public class EspelhoMagico extends Feiticos{
    public EspelhoMagico(){
        super();
        setNome("EspelhoMagico");
        setMana(6);
        danoEfeito(0);
        setValidação("ataque");

    }
    public void refletirDano(Criatura destino, int danoRecebido){
    	destino.atacar(destino);
    }
    public void jogarFeitico(Criatura destino, int turnoAtual) {
    	
    }
    
}
