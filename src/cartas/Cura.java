package cartas;



public class Cura extends Feiticos {
	public Cura(){
        super();
        setNome("Cura");
        setMana(3);
        danoEfeito(-2);
        setValidação("cura um");
    }
	public void jogarFeitico(Criatura destino, int turnoAtual) {

	}
	
}
