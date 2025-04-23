package cartas;

import arenas.CartasCampo;
import arenas.Cemiterio;


public class CemiterioDeEspiritos extends Encantamentos{

    public CemiterioDeEspiritos(){
        super();
        setNome("Cemitério de Espíritos");
        setMana(5);
        setValidacao("Buff");
    }

    
    public void invocarEspirito(Criatura criatura, Cemiterio cemiterio, CartasCampo campo) {
        
        int quantidadeCartasCemiterio = cemiterio.getQuantidadeCartas();

        for (int i = 0; i < quantidadeCartasCemiterio; i++) {
            Criatura criatura1 = new Criatura();
            criatura1.setNome("Espírito");
            criatura1.defesa(1); 
            criatura1.ataque(0);
            campo.adicionarCriatura(criatura1);
            System.out.println("Espirito invocado!");
        }


    }
}