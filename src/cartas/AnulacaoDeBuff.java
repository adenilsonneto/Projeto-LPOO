package cartas;



public class AnulacaoDeBuff  extends Encantamentos{
    public AnulacaoDeBuff(){
        super();
        setNome("Anulação de Buff");
        setMana(3);
        setValidacao("Anulação Buff");
    }
    
    public void buffUm(int dano, Criatura destino){
        if(destino.getCuras()) {
        	destino.setCuras();
        }
    }

    

}
