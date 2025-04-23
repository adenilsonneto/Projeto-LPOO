package cartas;



public class BolaDeFogo extends Feiticos{

    private int turnoJogada;

    public BolaDeFogo(){
        super();
        setNome("Bola de Fogo");
        setMana(2);
        danoEfeito(1);
        setValidação("ataque um");
    }
    
    public void jogarFeitico(Criatura destino, int trunoAtual){
        this.turnoJogada = trunoAtual;
        queimaduras(destino);

    }
   
    public void queimaduras(Criatura destino){
            destino.queimado(this.turnoJogada);        
    }
    
}