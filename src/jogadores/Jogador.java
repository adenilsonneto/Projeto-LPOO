package jogadores;

import java.util.ArrayList;
import java.util.Random;

import arenas.CartasCampo;
import arenas.Cemiterio;
import cartas.AtributosGeraisCriaturas;
import cartas.Carta;

import cartas.Criatura;
import cartas.Encantamentos;
import cartas.Feiticos;
import excecoes.ManaInsuficienteException;
import interfaces.Atacavel;

public class Jogador implements Atacavel {
	private String nome;
	private int vida;
	private int mana;
	private int vez;
	private int nivel;
	private int vitorias;
	private int derrotas;
	private ArrayList<Carta> mao;
	private ArrayList<Carta> deck;
	private Cemiterio cemiterio;
	private Random random;
	
	public Jogador() {
		this.mao = new ArrayList<>();
		this.deck = new ArrayList<>();
		 this.random = new Random();
		 this.cemiterio = new Cemiterio();
		 this.nivel = 1;
		 this.vitorias = 0;
		 this.derrotas = 0;
	}
	public void setVez(int vez) {
		this.vez = vez;
	}
	public int getVez() {
		return this.vez;
	}
	public void passarVez() {
		this.vez = this.vez + 1;
	}
	public int getNivel() {
		return this.nivel;
	}
	public void evoluirNivel() {
		this.nivel = this.nivel + 1;
	}
	public int getVitorias() {
		return this.vitorias;
	}
	public void venceu() {
		this.vitorias = this.vitorias + 1;
	}
	public int getDerrotas() {
		return this.derrotas;
	}
	public void perdeu() {
		this.derrotas = this.derrotas + 1;
	}
	public int getVida(){
		return this.vida;
	}
	public void setVida(){
		this.vida = 20;
	}
	public int getMana() {
		return this.mana;
	}
	public void setMana() {
		this.mana = 1;
	}

	public void adicionarMana(int input) {
		setMana();
		for(int i = 0; i < input; i++) {
			this.mana = this.mana + 1;
			if(this.mana == 10) {
				break;
			}
		}
	}
	public void receberDano(int poder) {
		this.vida = this.vida - poder;
		
	}
	public void setMão() {
		for(int i = 0; i < 5; i++) {
			adicionarMão();
		}
		
	}
	
	public Carta getCartaMão(int input){
		if(input > this.mao.size()) {
			return null;
		}
		if(input <= 0 ) {
			return null;
		}
		else {
			return mao.get(input-1);
		}
	}
	
	public int getMãoSize() {
		return this.mao.size();
	}

	
	
	public void printMão() {
		int i = 1;
		for(Carta carta : this.mao) {
			System.out.print(i);
			System.out.print(" ");
			System.out.print(carta);
			System.out.printf(" custo de mana: " + carta.getMana());
			System.out.println();
			i++;
		}
	}
	
	
	public int getDeckSize() {
		return this.deck.size();
	}
	
	
	public void adicionarMão() {
		if(this.deck.size() > 0) {
			Carta carta = this.deck.get(0);
			this.mao.add(carta);
			this.deck.remove(0);
		}
	}
	
	public void embaralharDeck() {
		for(int i = 0; i < this.deck.size(); i++) {
			int indice = random.nextInt(this.deck.size());
			Carta carta = this.deck.get(i);
			carta = this.deck.set(indice, carta);
			carta = this.deck.set(i, carta);
			
		}
	}

	
	public void printDeck() {
		int i = 1;
		for(Carta carta: this.deck) {
			System.out.print(i);
			System.out.print(" ");
			System.out.print(carta);
			System.out.println();
			i++;
		}
	}
		
	public void removerCartaDeck(int input) {
		this.deck.remove(input);
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void jogarCarta(int input, int vez, Carta carta, CartasCampo campo, CartasCampo campoOponente) throws ManaInsuficienteException{
		try {
			if(input > this.mao.size()) {
			
			}
			else if(input == 0) {
				
			}
			else if (getCartaMão(input).getMana() > this.mana) {
				
				throw new ManaInsuficienteException("Mana insuficiente");
			
			}
			else if(verificarFeitico(input, campo) == true) {
				
			}
			else if(verificarEncantamento(input,campo,campoOponente)) {
				
			}
			else{	
				this.mana = this.mana - getCartaMão(input).getMana();
				carta = getCartaMão(input);
				this.mao.remove(input-1);
				if(carta instanceof Criatura) {
					campo.adicionarCriatura((Criatura) carta);
					((Criatura) carta).setVez(vez);
					verificarCriatura((Criatura) carta, campo, campoOponente);
					
				}

				else{
					campo.adicionarCriatura(carta);
				}

			}

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public boolean verificarFeitico(int input, CartasCampo campo) {
		boolean verificar = false;
		if(getCartaMão(input) instanceof Feiticos) {
			Feiticos feitico = (Feiticos) getCartaMão(input);
			if(feitico.getValidação().equals("cura um")){
				if(campo.criaturaPrecisaCura() == false) {
					System.out.println("nenhuma criatura precisa de cura");
					verificar = true;
				}
				else if(campo.isEmpty() == true) {
					System.out.println("Você não tem nenhuma criatura");
					verificar = true;
				}
			}
		}
		return verificar;
	}
	public boolean verificarEncantamento(int input, CartasCampo campo, CartasCampo campoOponente) {
		boolean verificar = false;
		if(getCartaMão(input) instanceof Encantamentos) {
			Encantamentos encantamento = (Encantamentos) getCartaMão(input);
			if(encantamento.getValidacao().equals("Anulação Debuff")) {
				if(campo.criaturaTemDebuff() == false) {
					System.out.println("nenhuma criatura está com debuff");
					verificar = true;
				}
				else if(campo.isEmpty() == true) {
					System.out.println("Você não tem nenhuma criatura");
					verificar = true;
				}
			}
			else if(encantamento.getValidacao().equals("Anulação Buff")) {
				if(campoOponente.criaturaTemBuff() == false) {
					System.out.println("nenhuma criatura do oponente está com buff");
					verificar = true;
				}
				else if(campoOponente.isEmpty() == true) {
					System.out.println("O oponente não tem nenhuma criatura");
					verificar = true;
				}
			}
		}
		return verificar;
	}
	public void verificarCriatura(Criatura criatura,CartasCampo campo, CartasCampo campoOponente) {
		if(criatura.getId().equals("4")|| criatura.getId().equals("26") || criatura.getId().equals("18")) {
			if(this.deck.size() > 0) {
				int indice = random.nextInt(this.deck.size());
				Carta carta = this.deck.get(indice);
				this.mao.add(carta);
				this.deck.remove(indice);
			}
			else {
				this.mana = this.mana + 1;
			}
		}
		else if(criatura.getId().equals("9") || criatura.getId().equals("1")) {
			if(campoOponente.isEmpty() == false) {
				int indice = random.nextInt(campoOponente.getCartasCampoSize());
				Criatura oponente = (Criatura) campoOponente.getCarta(indice);
				oponente.congelado(vez);
			}
		}
		else if(criatura.getId().equals("11")|| criatura.getId().equals("14") || criatura.getId().equals("27") || criatura.getId().equals("32")) {
			if(campoOponente.isEmpty() == false) {
				int indice = random.nextInt(campoOponente.getCartasCampoSize());
				Criatura oponente = (Criatura) campoOponente.getCarta(indice);
				oponente.queimado(vez);
			}
		}
		else if(criatura.getId().equals("13") || criatura.getId().equals("12") ) {
			if(campo.isEmpty() == false) {
				int indice = random.nextInt(campo.getCartasCampoSize());
				Criatura aliado = (Criatura) campo.getCarta(indice);
				aliado.receberDano(-1);
			}
		}
	}
	public void receberCarta(Carta carta){
		this.deck.add(carta);
	}

	public void cemiterioReceberCartas(Carta criatura) {
		this.cemiterio.receberCartas(criatura);
	}

	public Carta getCartaDeck(int input) {
		return this.deck.get(input);
	}

	public void transferirCemiterioDeck() {
		this.cemiterio.transferirCartasDeck(this);
	}
	public void resetAtributosCriaturas(AtributosGeraisCriaturas tabela) {
		for(Carta carta : this.deck) {
			if(carta instanceof Criatura) {
				tabela.tabelaDeAtributos((Criatura) carta);
			}
		}
	}
	public void transferirMaoDeck() {
	    for (int i = this.mao.size() - 1; i >= 0; i--) {
	        this.deck.add(this.mao.get(i));
	        this.mao.remove(i);
	    }
	}
	public int getCemiterioSize() {
		return this.cemiterio.getQuantidadeCartas();
	}
}


