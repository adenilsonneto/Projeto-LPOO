package cartas;

import java.util.ArrayList;


import interfaces.Atacavel;

public class Feiticos extends Carta{
	    private int efeito;
	    private String validação;
	    
	    public void setValidação(String validação) {
	    	this.validação = validação;
	    }
	    
	    public void danoEfeito(int dano){
	        this.efeito = dano ;
	    }

	    public void atacar(Atacavel criatura) {
	    	this.danoEfeito(this.efeito);
            criatura.receberDano(this.efeito);
	    }
	    public void atacarTodasCriaturas(ArrayList<Carta> criaturas){
	        for(Carta criatura : criaturas){
	            if(criatura instanceof Criatura) {
	            	atacar((Criatura) criatura);
	            }
	        }

	    }
	    
	    public int getEfeito(){
	        return this.efeito;

	    }
	    public String getValidação() {
	    	return this.validação;
	    }
	    public  void jogarFeitico(Criatura destino, int turnoAtual) {
	    	
	    }
	   
}
