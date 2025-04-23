package cartas;

import java.util.ArrayList;

public class CampoDeFogo extends Encantamentos {
    
    public CampoDeFogo(){
        
        super();
        setNome("Campo de Fogo");
        setMana(4);
        danoEfeitoContinuo(1);
        setValidacao("Debuff todos");

    }
    public void buffTodos(int efeito, ArrayList<Carta> criaturas){
        for(int i = 0; i < criaturas.size(); i++) {
        	((Criatura) criaturas.get(i)).queimado(efeito);
        }
    }
    

}
