package menu;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import arenas.ArenaCombate;
import cartas.AlmaDeMana;
import cartas.AnulacaoDeBuff;
import cartas.AnulacaoDeDebuff;
import cartas.AranhaGigante;
import cartas.AtiradorNoturno;
import cartas.BolaDeCanhao;
import cartas.BolaDeFogo;
import cartas.BolaDeNeve;
import cartas.CampoDeFogo;
import cartas.Carta;
import cartas.Cavaleiro;
import cartas.CavaleiroLuz;
import cartas.CavaleiroTrevas;
import cartas.CemiterioDeEspiritos;
import cartas.ChuvaDeFlechas;
import cartas.Cura;
import cartas.DragaoFogo;
import cartas.DragãoDaMontanha;
import cartas.DragãoDaTempestade;
import cartas.DragãoDasSombras;
import cartas.DragãoDeGelo;
import cartas.DragãoDoAbismo;
import cartas.DragãoSelva;
import cartas.Enfraquecimento;
import cartas.Envenenamento;
import cartas.Escudo;
import cartas.EspelhoMagico;
import cartas.EspiritoDeAgua;
import cartas.EspiritoDeFogo;
import cartas.Fortalecimento;
import cartas.FrancoAtirador;
import cartas.Furia;
import cartas.GambáGigante;
import cartas.GiganteFerro;
import cartas.GiganteOuro;
import cartas.GigantePlatina;
import cartas.GolemDePedra;
import cartas.GolemDiamante;
import cartas.GolemLava;
import cartas.Grifo;
import cartas.Javali;
import cartas.Leviatã;
import cartas.LeãoAreia;
import cartas.LeãoDaIlha;
import cartas.LeãoFogo;
import cartas.LeãoTrevas;
import cartas.LoboElétrico;
import cartas.LoboNeve;
import cartas.Quimera;
import cartas.SerpenteGigante;
import cartas.Trovao;
import cartas.VelocidadeDeAtaque;
import cartas.VentosRevigorantes;
import cartas.ZebraMistica;
import cartas.ZebraTroia;
import excecoes.EmptyDeckException;
import jogadores.Jogador;

public class MontadorDeck {
	private ArrayList<Jogador> jogadores;
	private ArrayList<Carta> cartas;
	private ArrayList<Carta> deck;
	private ArrayList<Carta> deck2;
	private Random random;
        private ArrayList<String> nomeDeck1;
        private ArrayList<String> nomeDeck2;
	public MontadorDeck() {
		this.jogadores = new ArrayList<>();
		this.cartas = new ArrayList<>();
		this.deck = new ArrayList<>();
		this.deck2 = new ArrayList<>();
		this.random = new Random();
                this.nomeDeck1 = new ArrayList<>();
                this.nomeDeck2 = new ArrayList<>();
	}
	public void receberJogadores(Jogador jogador) {
		this.jogadores.add(jogador);
	}
	public void resetCartas() {
		this.cartas.removeAll(cartas);
	}
	public void resetDeck(){
		 this.deck.removeAll(deck);
	}
	public void resetDeck2() {
		this.deck2.removeAll(deck2);
	}
	public void setDeck() {
		this.deck.add(new AnulacaoDeBuff());
		this.deck.add(new AlmaDeMana());
		this.deck.add(new AtiradorNoturno());
		this.deck.add(new Cavaleiro());
		this.deck.add(new DragãoSelva());
		this.deck.add(new GigantePlatina());
		this.deck.add(new EspiritoDeAgua());
		this.deck.add(new DragãoDeGelo());
		this.deck.add(new Quimera());
		this.deck.add(new GolemLava());
		this.deck.add(new Grifo());
		this.deck.add(new LeãoTrevas());
		this.deck.add(new FrancoAtirador());
		this.deck.add(new CavaleiroTrevas());
		this.deck.add(new Javali());
		this.deck.add(new BolaDeFogo());
		this.deck.add(new BolaDeCanhao());
		this.deck.add(new ChuvaDeFlechas());
		this.deck.add(new ZebraMistica());
		this.deck.add(new GiganteOuro());
		this.deck.add(new DragãoDaTempestade());
		this.deck.add(new BolaDeFogo());
		this.deck.add(new AlmaDeMana());
		this.deck.add(new AranhaGigante());
		this.deck.add(new Javali());
		this.deck.add(new Leviatã());
		this.deck.add(new BolaDeNeve());
		this.deck.add(new BolaDeNeve());
		this.deck.add(new Envenenamento());
		this.deck.add(new Cura());
		
	}
	public void setDeck2() {
		this.deck2.add(new AlmaDeMana());
		this.deck2.add(new AlmaDeMana());
		this.deck2.add(new AnulacaoDeDebuff());
		this.deck2.add(new CavaleiroLuz());
		this.deck2.add(new Cura());
		this.deck2.add(new BolaDeCanhao());
		this.deck2.add(new VentosRevigorantes());
		this.deck2.add(new BolaDeFogo());
		this.deck2.add(new DragaoFogo());
		this.deck2.add(new GolemDiamante());
		this.deck2.add(new ZebraTroia());
		this.deck2.add(new LeãoDaIlha());
		this.deck2.add(new LoboNeve());
		this.deck2.add(new SerpenteGigante());
		this.deck2.add(new DragãoDoAbismo());
		this.deck2.add(new ChuvaDeFlechas());
		this.deck2.add(new GambáGigante());
		this.deck2.add(new Trovao());
		this.deck2.add(new LeãoAreia());
		this.deck2.add(new LoboElétrico());
		this.deck2.add(new GiganteFerro());
		this.deck2.add(new DragãoDasSombras());
		this.deck2.add(new GolemDePedra());
		this.deck2.add(new DragãoDaMontanha());
		this.deck2.add(new LeãoFogo());
		this.deck2.add(new FrancoAtirador());
		this.deck2.add(new Javali());
		this.deck2.add(new Cavaleiro());
		this.deck2.add(new EspiritoDeFogo());
		this.deck2.add(new BolaDeNeve());
	}
	public void setCartas() {
		this.cartas.add(new Javali());
		this.cartas.add(new AlmaDeMana());
		this.cartas.add(new AranhaGigante());
		this.cartas.add(new AtiradorNoturno());
		this.cartas.add(new BolaDeFogo());
		this.cartas.add(new BolaDeNeve());
		this.cartas.add(new BolaDeCanhao());
		this.cartas.add(new CampoDeFogo());
		this.cartas.add(new Cavaleiro());
		this.cartas.add(new CavaleiroLuz());
		this.cartas.add(new CavaleiroTrevas());
		this.cartas.add(new CemiterioDeEspiritos());
		this.cartas.add(new ChuvaDeFlechas());
		this.cartas.add(new Cura());
		this.cartas.add(new DragãoDaMontanha());
		this.cartas.add(new DragãoDasSombras());
		this.cartas.add(new DragãoDaTempestade());
		this.cartas.add(new DragãoDeGelo());
		this.cartas.add(new DragãoDoAbismo());
		this.cartas.add(new DragaoFogo());
		this.cartas.add(new DragãoSelva());
		this.cartas.add(new Enfraquecimento());
		this.cartas.add(new Envenenamento());
		this.cartas.add(new Escudo());
		this.cartas.add(new EspelhoMagico());
		this.cartas.add(new EspiritoDeAgua());
		this.cartas.add(new EspiritoDeFogo());
		this.cartas.add(new Fortalecimento());
		this.cartas.add(new FrancoAtirador());
		this.cartas.add(new Furia());
		this.cartas.add(new GambáGigante());
		this.cartas.add(new GiganteFerro());
		this.cartas.add(new GiganteOuro());
		this.cartas.add(new GigantePlatina());
		this.cartas.add(new GolemDePedra());
		this.cartas.add(new GolemDiamante());
		this.cartas.add(new GolemLava());
		this.cartas.add(new Grifo());
		this.cartas.add(new LeãoAreia());
		this.cartas.add(new LeãoDaIlha());
		this.cartas.add(new LeãoFogo());
		this.cartas.add(new LeãoTrevas());
		this.cartas.add(new Leviatã());
		this.cartas.add(new LoboElétrico());
		this.cartas.add(new LoboNeve());
		this.cartas.add(new Quimera());
		this.cartas.add(new SerpenteGigante());
		this.cartas.add(new Trovao());
		this.cartas.add(new VelocidadeDeAtaque());
		this.cartas.add(new VentosRevigorantes());
		this.cartas.add(new ZebraMistica());
		this.cartas.add(new ZebraTroia());
		this.cartas.add(new AnulacaoDeBuff());
		this.cartas.add(new AnulacaoDeDebuff());
	}
	
	public void printCarta() {
		int n = 1;
		for(Carta carta : this.cartas) {
			System.out.print(n);
			System.out.print(" ");
			System.out.print(carta);
			System.out.print("  ");
			if(n % 5 == 0) {
				System.out.println();
			}
			n++;
		}
	}
	public void printDeck() {
		int n = 1;
		for(Carta carta : this.deck) {
			System.out.print(n);
			System.out.print(" ");
			System.out.print(carta);
			System.out.println();
			n++;
		}
	}
	public void printDeck2() {
		int n = 1;
		for(Carta carta : this.deck2) {
			System.out.print(n);
			System.out.print(" ");
			System.out.print(carta);
			System.out.println();
			n++;
		}
	}
	public static boolean isNumeric(String str) {
	    if (str == null) {
	        return false;
	    }
	    try {
	    	Integer.parseInt(str);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}

	public void escolherCarta(Scanner ler) throws EmptyDeckException {
		for(int i = 0; i < this.jogadores.size(); i++) {
			boolean escolha = true;
			while(escolha == true) {
				System.out.println(jogadores.get(i).getNome());
				System.out.println("Você deseja escolher dois decks pré-definidos (p) ou escolher cada carta (c) ");
				String input = ler.nextLine();
				if(input.equals("p")) {
					escolherPreDefinido(ler, i);
					escolha = false;
				}
				else if(input.equals("c")) {
					escolherCadaCarta(ler, i);
					escolha = false;
				}
			}
		}
	}

	public void transferirJogadores(ArenaCombate arena) {
		int indice = this.random.nextInt(30);
		if(indice % 2 == 0) {
			System.out.println(jogadores.get(0).getNome() + " vai começar jogando");
			arena.receberJogadores(this.jogadores.get(0));
			arena.receberJogadores(this.jogadores.get(1));
		}
		else {
			System.out.println(jogadores.get(1).getNome() + " vai começar jogando");
			arena.receberJogadores(this.jogadores.get(1));
			arena.receberJogadores(this.jogadores.get(0));
		}
	}
	public void escolherPreDefinido(Scanner ler, int i) {
		boolean escolha = true;
		while(escolha == true) {
			resetDeck();
			resetDeck2();
			setDeck();
			setDeck2();
			System.out.println("Você pode escolher entre o primeiro e segundo deck (e) ou olhar as cartas de algum desses decks (o)");
			String input1 = ler.nextLine();
			if(input1.equals("e")) {
				System.out.println("Você quer o primeiro (p) ou o segundo (s) deck");
				String input2 = ler.nextLine();
				if(input2.equals("p")) {
					for(int n = 0; n < this.deck.size(); n++) {
						jogadores.get(i).receberCarta(this.deck.get(n));
					}
					escolha = false;
				}
				else if(input2.equals("s")) {
					for(int n = 0; n < this.deck2.size(); n++) {
						jogadores.get(i).receberCarta(this.deck2.get(n));
					}
					escolha = false;
				}
			}
			else if(input1.equals("o")) {
				System.out.println("Você quer ver o primeiro (p) ou o segundo (s) deck");
				String input2 = ler.nextLine();
				if(input2.equals("p")) {
					printDeck();
				}
				else if(input2.equals("s")) {
					printDeck2();
				}
			}
		}
	}
	public void escolherCadaCarta(Scanner ler, int i) {
		boolean escolha = true;
		while(escolha == true) {
			if(jogadores.get(i).getDeckSize() < 30) {
				resetCartas();
				setCartas();
				System.out.println(jogadores.get(i).getNome());
				System.out.println("Escolha 30 cartas das opções abaixo, no máximo você pode escolher duas cartas iguais");
				printCarta();
				System.out.println("Deseja ver o seu deck (d)");
				String input1 = ler.nextLine();
				if(isNumeric(input1) == true) {
					int num = Integer.parseInt(input1);
					jogadores.get(i).receberCarta(this.cartas.get(num-1));
				}
				else if(input1.equals("d")) {
					try {
						if(jogadores.get(i).getDeckSize() == 0) {
						throw new EmptyDeckException("Seu deck está vazio!");
						}
						else {
						jogadores.get(i).printDeck();
						System.out.println("Deseja remover alguma carta (r)");
						String input2 = ler.nextLine();
						if(input2.equals("r")){
							jogadores.get(i).printDeck();
							System.out.println("digite o número da carta que você deseja remover");
							int num2 = Integer.parseInt(ler.nextLine());
							jogadores.get(i).removerCartaDeck(num2-1);
							}
						}
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
			else {
				System.out.println("Seu deck está cheio, deseja olhar seu deck (d) ou terminar a montagem do deck (t)");
				String input1 = ler.nextLine();
				if(input1.equals("d")) {
					jogadores.get(i).printDeck();
					System.out.println("Deseja remover alguma carta (r)");
					String input2 = ler.nextLine();
					if(input2.equals("r")){
						jogadores.get(i).printDeck();
						System.out.println("digite o número da carta que você deseja remover");
						int num2 = Integer.parseInt(ler.nextLine());
						jogadores.get(i).removerCartaDeck(num2-1);
					}
				}
				else if(input1.equals("t")) {
					escolha = false;
				}
			}
		}
	}

	public ArrayList<Jogador> getArray(){
		return this.jogadores;
	}

	public void setNomeDeck1(){
		for(int n = 0; n <this.deck.size(); n++){
			this.nomeDeck1.add(this.deck.get(n).toString());
		}
	}
	public void setNomeDeck2(){
		for(int n = 0; n <this.deck2.size(); n++){
			this.nomeDeck2.add(this.deck2.get(n).toString());
		}
	}
	public ArrayList<String> getNomeDeck1(){
		return this.nomeDeck1;
	}
	public ArrayList<String> getNomeDeck2(){
		return this.nomeDeck2;
	}

	public String[] converterArray(ArrayList<Carta> deck){
		String[] arrayConvertido = new String[deck.size()];
		for(int i = 0; i<deck.size(); i++){
			arrayConvertido[i] = deck.get(i).toString();
		}
		return arrayConvertido;
	}

	public ArrayList<Carta> getDeck() {
        return this.deck;
	}
	public ArrayList<Carta> getDeck2() {
        return this.deck2;
	}

}

