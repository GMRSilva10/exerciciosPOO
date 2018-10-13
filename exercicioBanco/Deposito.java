public class Deposito extends Transacao{

	public Deposito(double valor){
		super(valor);
		System.out.println("Novo depósito salvo no histórico");
		System.out.println(this.getData());
	}

}