public class Deposito extends Transacao{

	public Deposito(double valor){
		super(valor);
		System.out.println("Novo dep�sito salvo no hist�rico");
		System.out.println(this.getData());
	}

}