package arenas;

import java.util.ArrayList;
import java.util.Scanner;

import cartas.AtributosGeraisCriaturas;
import cartas.Criatura;
import cartas.Encantamentos;
import cartas.Feiticos;
import excecoes.CreatureCannotAttackException;
import excecoes.ManaInsuficienteException;
import excecoes.NoSpecialStatusException;
import jogadores.Jogador;
import menu.FimDaBatalha;


public class ArenaCombate {
	private ArrayList<Jogador> jogadores;
	private ArrayList<CartasCampo> secção;
	private ArrayList<AtributosGeraisCriaturas> tabela;
	private int numeroTurno;
	
	public ArenaCombate() {
		this.jogadores = new ArrayList<>();
		this.secção = new ArrayList<>();
		this.numeroTurno = 0;
		this.tabela = new ArrayList<>();
		this.tabela.add(new AtributosGeraisCriaturas());
	}
	public void resetTurno() {
		this.numeroTurno = 0;
	}
	public void setJogadores() {
		this.secção.add(new CartasCampo());
		this.secção.add(new CartasCampo());
	}
	public void receberJogadores(Jogador jogador) {
		this.jogadores.add(jogador);
	}
	public void printJogadores(int i) {
	    System.out.printf(jogadores.get(i).getNome());
	    System.out.printf(" Vida: " + jogadores.get(i).getVida());
	    System.out.println();
	}
	public void escolherOutraCarta(int i, Scanner ler) throws ManaInsuficienteException {
		int o = 1 - i;
		System.out.printf("Quantidade de mana: " + jogadores.get(i).getMana());
		System.out.println();
		System.out.println("Escolha uma carta para jogar no campo");
		this.jogadores.get(i).printMão();
		int input2 = Integer.parseInt(ler.nextLine());	
		jogadores.get(i).jogarCarta(input2, this.numeroTurno, jogadores.get(i).getCartaMão(input2), secção.get(i), secção.get(o));
		if(secção.get(i).verificarFeiticos() == true) {
			cartaFeiticos(i, ler);
		}
		if(secção.get(i).verificarEncantamentos() == true) {
			cartaEncantamento(i, ler);
		}
	}

	public void faseCombate(int i, Scanner ler) throws CreatureCannotAttackException {
	    int o = 1 - i;
	    System.out.println("Campo de " + jogadores.get(i).getNome());
		secção.get(i).verificarCartas(jogadores.get(i));
		secção.get(o).verificarCartas(jogadores.get(o));
		secção.get(i).printCartasCampo();
		System.out.println("ver o Campo do seu oponente (o) ou escolher uma carta para atacar (a)");
		String confirma2 = ler.nextLine();
		if(confirma2.equals("o")){
			printJogadores(o);
			secção.get(o).printCartasCampo();
		}
		if(confirma2.equals("a")) {
			combate(i, o, ler);
		}
	}
	public void combate(int i, int o, Scanner ler) throws CreatureCannotAttackException {
	    System.out.println("Escolha uma criatura do seu campo para atacar ");
		secção.get(i).printCartasCampo();
		int input3 = Integer.parseInt(ler.nextLine());
		if (secção.get(i).escolherCarta(input3) instanceof Criatura) {
			Criatura criatura = (Criatura) secção.get(i).escolherCarta(input3);
			try {
				if(criatura.getEstado() == true) {
					throw new CreatureCannotAttackException("A criatura não pode atacar!");
				}
				else {
				System.out.println("Agora escolha um alvo para ser atacado");
				System.out.print(0);
				System.out.print(" ");
				printJogadores(o);
				secção.get(o).printCartasCampo();
				int input4 = Integer.parseInt(ler.nextLine());
					if(input4 == 0) {
						if(secção.get(o).criaturaTemProvocar() == false) {
							criatura.atacar(jogadores.get(o));
							criatura.setEstado();
						}
						else {
							System.out.println("Você só pode atacar criaturas com provocar");
						}
					}
					else {
						Criatura criatura2 = (Criatura) secção.get(o).escolherCarta(input4);
						if(secção.get(o).criaturaTemProvocar() == false) {
							criatura.atacar(criatura2);
							criatura2.atacar(criatura);
							criatura.setEstado();
						}
						else {
							if(criatura2.getProvocar() == true) {
								criatura.atacar(criatura2);
								criatura2.atacar(criatura);
								criatura.setEstado();
							}
							else {
								System.out.println("Você só pode atacar criaturas com provocar");
							}
						}
					}	
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public void cartaFeiticos(int i, Scanner ler) {
		int o = 1 - i;
			Feiticos feitico = secção.get(i).feitico();
			if(feitico.getValidação().equals("ataque um")) {
				System.out.println("Escolha um alvo para infrigir dano");
				System.out.print(0);
				System.out.print(" ");
				printJogadores(o);
				secção.get(o).printCartasCampo();
				int input = Integer.parseInt(ler.nextLine());
				if(input == 0) {
					feitico.atacar(jogadores.get(o));
					jogadores.get(i).cemiterioReceberCartas(feitico);
					secção.get(i).remover(feitico);
				}
				else {
					Criatura criatura = (Criatura) secção.get(o).escolherCarta(input);
					feitico.atacar(criatura);
					feitico.jogarFeitico(criatura, jogadores.get(i).getVez());
					jogadores.get(i).cemiterioReceberCartas(feitico);
					secção.get(i).remover(feitico);
				}
			}
			else if(feitico.getValidação().equals("cura um")) {
				System.out.println("Escolha uma criatura para curar");
				secção.get(i).printCartasCampo();
				int input = Integer.parseInt(ler.nextLine());
				Criatura criatura = (Criatura) secção.get(i).escolherCarta(input);
				feitico.atacar(criatura);
				jogadores.get(i).cemiterioReceberCartas(feitico);
				secção.get(i).remover(feitico);
			}
			else if(feitico.getValidação().equals("ataque todos")) {
				feitico.atacarTodasCriaturas(secção.get(o).getArray());
				jogadores.get(i).cemiterioReceberCartas(feitico);
				secção.get(i).remover(feitico);
			}
			else if(feitico.getValidação().equals("ataque")) {
				System.out.println("Escolha uma criatura para aumentar o ataque");
				secção.get(i).printCartasCampo();
				int input = Integer.parseInt(ler.nextLine());
				Criatura criatura = (Criatura) secção.get(i).escolherCarta(input);
				int novoAtaque = criatura.getPoder() + feitico.getEfeito();
				criatura.ataque(novoAtaque);
				jogadores.get(i).cemiterioReceberCartas(feitico);
				secção.get(i).remover(feitico);
				
			}
			else if(feitico.getValidação().equals("defesa")) {
				System.out.println("Escolha uma criatura para aumentar a resistencia");
				secção.get(i).printCartasCampo();
				int input = Integer.parseInt(ler.nextLine());
				Criatura criatura = (Criatura) secção.get(i).escolherCarta(input);
				int novaDefesa = criatura.getDefesa() + feitico.getEfeito();
				int novaDefasaMax = criatura.getDefesaMax() + feitico.getEfeito();
				criatura.defesa(novaDefesa);
				criatura.defesaMax(novaDefasaMax);
				jogadores.get(i).cemiterioReceberCartas(feitico);
				secção.get(i).remover(feitico);
			}
			else {
				jogadores.get(i).cemiterioReceberCartas(feitico);
				secção.get(i).remover(feitico);
			}
		}
	public void cartaEncantamento(int i, Scanner ler) {
		int o = 1 - i;
		Encantamentos encantamento = secção.get(i).encantamento();
		if(encantamento.getValidacao().equals("Debuff")) {
			System.out.println("Escolha uma criatura para aplicar debuff");
			secção.get(o).printCartasCampo();
			int input = Integer.parseInt(ler.nextLine());
			Criatura criatura = (Criatura) secção.get(o).escolherCarta(input);
			encantamento.buffUm(jogadores.get(i).getVez(), criatura);
			jogadores.get(i).cemiterioReceberCartas(encantamento);
			secção.get(i).remover(encantamento);
		}
		else if(encantamento.getValidacao().equals("Buff")) {
			System.out.println("Escolha uma criatura para aplicar buff");
			secção.get(i).printCartasCampo();
			int input = Integer.parseInt(ler.nextLine());
			Criatura criatura = (Criatura) secção.get(i).escolherCarta(input);
			encantamento.buffUm(jogadores.get(i).getVez(), criatura);
			jogadores.get(i).cemiterioReceberCartas(encantamento);
			secção.get(i).remover(encantamento);
		}
		else if(encantamento.getValidacao().equals("Debuff todos")) {
			encantamento.buffTodos(jogadores.get(i).getVez(), secção.get(o).getArray());
			jogadores.get(i).cemiterioReceberCartas(encantamento);
			secção.get(i).remover(encantamento);
		}
		else if(encantamento.getValidacao().equals("Anulação Debuff")) {
			boolean criaturaDebuff = false;
			while(criaturaDebuff == false) {
				System.out.println("Escolha uma criatura para tirar o debuff");
				secção.get(i).printCartasCampo();;
				int input = Integer.parseInt(ler.nextLine());
				Criatura criatura = (Criatura) secção.get(i).escolherCarta(input);
				try {
					if(criatura.getCongelado() == true || criatura.getQueimado() == true || criatura.getEnvenenado() == true) {
						encantamento.buffUm(jogadores.get(i).getVez(), criatura);
						jogadores.get(i).cemiterioReceberCartas(encantamento);
						secção.get(i).remover(encantamento);
						criaturaDebuff = true;
					}
					else {
						throw new NoSpecialStatusException("Essa criatura não tem nenhum debuff");
					
					}
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
				
				
			}
			
		}
		else if(encantamento.getValidacao().equals("Anulação Buff")) {
			boolean criaturaDebuff = false;
			while(criaturaDebuff == false) {
				System.out.println("Escolha uma criatura para tirar o buff");
				secção.get(o).printCartasCampo();;
				int input = Integer.parseInt(ler.nextLine());
				Criatura criatura = (Criatura) secção.get(o).escolherCarta(input);
				try {
					if(criatura.getCuras() == true) {
						encantamento.buffUm(jogadores.get(i).getVez(), criatura);
						jogadores.get(i).cemiterioReceberCartas(encantamento);
						secção.get(i).remover(encantamento);
						criaturaDebuff = true;
					}
					else {
						throw new NoSpecialStatusException("Essa criatura não tem nenhum buff");
					
					}
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
	public void turno(int i, Scanner ler) throws ManaInsuficienteException, CreatureCannotAttackException {
		if(jogadores.get(i).getVida() > 0 && jogadores.get(1-i).getVida() > 0) {
			int o = 1 - i;
			System.out.printf("Vez de " + jogadores.get(i).getNome());
			System.out.println();
			System.out.printf("Quantidade de mana: " + jogadores.get(i).getMana());
			System.out.println();
			System.out.println("Escolha uma carta para jogar no campo");
			if(this.numeroTurno != 0) {
				jogadores.get(i).passarVez();
			}
			secção.get(i).passarVezCriatura(jogadores.get(1-i).getVez());
			this.jogadores.get(i).printMão();
			int input = Integer.parseInt(ler.nextLine());	
			jogadores.get(i).jogarCarta(input, this.numeroTurno ,jogadores.get(i).getCartaMão(input), secção.get(i), secção.get(o));
			boolean verdade = false;
			secção.get(i).verificarCartas(jogadores.get(i));
			while(verdade == false) {
				if(secção.get(i).verificarFeiticos() == true) {
					cartaFeiticos(i, ler);
				}
				if(secção.get(i).verificarEncantamentos() == true) {
					cartaEncantamento(i, ler);
				}
				if(jogadores.get(1-i).getVida() > 0) {
					System.out.println("Jogar outra carta(c), Deseja ver o campo de batalha(b) ou terminar o turno(t)");
					String confirma = ler.nextLine();
					verdade = confirma.equals("t") == true;
					if(confirma.equals("c")) {
						escolherOutraCarta(i, ler);
					}
					if(confirma.equals("b")) {
						faseCombate(i, ler);
					}
				}
				else {
					verdade = true;
				}
			}
		}			
    }
	public void primeiroTurno() {
		setJogadores();
		this.jogadores.get(0).setVida();
		this.jogadores.get(1).setVida();
		this.jogadores.get(0).setMana();
		this.jogadores.get(1).setMana();
		this.jogadores.get(0).setVez(numeroTurno);
		this.jogadores.get(1).setVez(numeroTurno);
		for(int i = 0; i < this.jogadores.size(); i++) {
			this.jogadores.get(i).embaralharDeck();
			this.jogadores.get(i).setMão();

		}
	}
	public void vezJogador(Scanner ler) throws ManaInsuficienteException, CreatureCannotAttackException {
		if(this.numeroTurno == 0) {
			primeiroTurno();
		}
		while(jogadores.get(0).getVida() > 0 && jogadores.get(1).getVida() > 0) {
			for(int i = 0; i < this.jogadores.size(); i++) {
				turno(i, ler);
			}
			this.numeroTurno++;
			for(int i = 0; i < jogadores.size(); i++) {
				jogadores.get(i).adicionarMana(this.numeroTurno);
				jogadores.get(i).adicionarMão();
				secção.get(i).acordarCriaturas();
			}		
		}
	}
	public void mudarTurno(int numeroTurno) {
		for(int i = 0; i < jogadores.size(); i++) {
			jogadores.get(i).adicionarMana(numeroTurno);
			jogadores.get(i).adicionarMão();
			secção.get(i).acordarCriaturas();
		}
	}
	public void jogadoresResetDeck() {
		jogadores.get(0).transferirCemiterioDeck();
		jogadores.get(0).transferirMaoDeck();
		secção.get(0).transferirCampoDeck(jogadores.get(0));
		jogadores.get(0).resetAtributosCriaturas(this.tabela.get(0));
		this.tabela.remove(0);
		this.tabela.add(new AtributosGeraisCriaturas());
		jogadores.get(1).transferirCemiterioDeck();
		jogadores.get(1).transferirMaoDeck();
		secção.get(1).transferirCampoDeck(jogadores.get(1));
		jogadores.get(1).resetAtributosCriaturas(this.tabela.get(0));
		this.tabela.remove(0);
		this.tabela.add(new AtributosGeraisCriaturas());
	}
	public void removerJogadores() {
	    for(int i = this.jogadores.size() - 1; i >= 0; i--) {
	        jogadores.remove(i);
	    }
	}
	public void transferirJogadores(FimDaBatalha fim) {
		for(int i = 0; i < jogadores.size(); i++) {
			fim.receberJogadores(jogadores.get(i));
		}
	}
	
	
	public ArrayList<Jogador> getArray(){
		return this.jogadores;
	}
}



		
	


