package cartas;

import java.util.ArrayList;

import interfaces.Atacavel;

public class Encantamentos extends Carta {
	 private int efeitoContinuo;
	 private String validacao;
	   
	    public void setValidacao(String validacao){
			this.validacao = validacao;
		}
		
		public String getValidacao(){
			return this.validacao;
		}
	    public void danoEfeitoContinuo(int dano){
	        this.efeitoContinuo = dano ;
	    }
	    public int getDanoEfeitoContinuo() {
	    	return this.efeitoContinuo;
	    }
	    
	    public void atacar(Atacavel destino) {
			this.danoEfeitoContinuo(this.efeitoContinuo);
			destino.receberDano(this.efeitoContinuo);
	    }
	    
	    public void buffTodos(int efeito, ArrayList<Carta> arrayList){
	        for(int i = 0; i < arrayList.size(); i++) {
	        	int ataque = ((Criatura) arrayList.get(i)).getPoder();
	        	ataque += efeito;
	        	((Criatura) arrayList.get(i)).ataque(ataque);
	        }
	    }
	    
	    public void buffUm(int dano, Criatura destino){
	        int ataque = destino.getPoder();
	        ataque += dano;
	        destino.ataque(ataque);
	    }
	   
}
	    
	

