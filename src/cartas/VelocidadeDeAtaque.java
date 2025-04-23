package cartas;

public class VelocidadeDeAtaque extends Encantamentos {
    public VelocidadeDeAtaque(){
        super();
        setNome("Velocidade de Ataque");
        setMana(3);
        setValidacao("Buff");

    }

    public void velocidadeAtaque(Criatura destino){
        destino.ataque(destino.getPoder()*2); ;
    }
}