public class Pagamento extends Transacao{
	
	private String boleto;

	public Pagamento(String boleto, double valor){
		super (valor);
		this.boleto = boleto;
		System.out.println("Novo pagamento salvo no histórico");
		System.out.println(this.getData());
	}
}