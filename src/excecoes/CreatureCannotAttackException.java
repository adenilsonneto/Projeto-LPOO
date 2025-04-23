package excecoes;

public class CreatureCannotAttackException extends Exception {
	public CreatureCannotAttackException(String mensagem){
		super(mensagem);
	}
}
