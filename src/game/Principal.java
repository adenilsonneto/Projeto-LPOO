package game;

import javax.swing.SwingUtilities;


import menu.TelaMenu;
import excecoes.CreatureCannotAttackException;
import excecoes.EmptyDeckException;
import excecoes.ManaInsuficienteException;
import menu.MontadorDeckTela;
import menu.NomearJogadoresTela;

public class Principal {
	public static void main(String[] args) throws ManaInsuficienteException, CreatureCannotAttackException, EmptyDeckException {
		   SwingUtilities.invokeLater(() -> {
	            TelaMenu telaMenu = new TelaMenu();
	            telaMenu.setVisible(true);
                   
	        });
	    
	}
}
		
		





