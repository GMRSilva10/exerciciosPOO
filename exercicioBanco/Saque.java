
public class Saque extends Transacao{
	
	public Saque(double valor){
		super(valor);
		System.out.println("Novo saque salvo no histórico.");
		System.out.println(this.getData());
	}

}