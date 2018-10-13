import java.util.Date;

public class Transacao{
	private double valor;
	private Date data;

	public Transacao(double valor){
		data = new Date();
		this.valor = valor;
	}

	public double getValor(){
		return this.valor;
	}

	public Date getData(){
		return this.data;
	}

}