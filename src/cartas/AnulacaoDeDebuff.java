package cartas;



public class AnulacaoDeDebuff extends Encantamentos{

    public AnulacaoDeDebuff(){

        super();
        setNome("Anulação de Debuff");
        setMana(3);
        setValidacao("Anulação Debuff");
    }
    
    public void buffUm(int dano, Criatura destino){
        if(destino.getCongelado() == true) {
        	destino.setCongelado();
        	destino.mudarEstado();
        }
        if(destino.getQueimado() == true) {
        	destino.setQueimado();
        }
        if(destino.getEnvenenado() == true) {
        	destino.setEnvenenado();
        }
    }

}
