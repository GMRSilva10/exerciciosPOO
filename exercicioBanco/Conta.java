import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class Conta{
	private double saldo;
	private String numero;
	private String senha;
	private ArrayList <Transacao> historico;

	public Conta(String numeroConta, String senha){
		this.numero = numeroConta;
		this.senha = senha;
		historico = new ArrayList <Transacao>();
		JOptionPane.showMessageDialog(null, "Parabéns, você acaba de criar uma nova conta");
	}

	public boolean efetuarSaque(double valor){
		if (this.saldo >= valor){
			this.saldo -= valor;
			historico.add(new Saque(valor));
			return true;
		}else{
			JOptionPane.showMessageDialog(null, "Saldo insuficiente");
			return false;
		}
	}
	
	public boolean efetuarDeposito(double valor){
		if (valor > 0){
			this.saldo += valor;
			System.out.println("Novo saldo: " + this.saldo);
			historico.add(new Deposito(valor));
			return true;
		}
		else{
			System.out.println("Insira um valor para depositar");
			return false;
		}
	}
	
	public boolean efetuarPagamento(String boleto, double valor){
		if (this.saldo >= valor){
			this.saldo -= valor;
			JOptionPane.showMessageDialog(null, "Pagamento realizado com sucesso!");
			historico.add(new Pagamento(boleto, valor));
			return true;
		}else{
			JOptionPane.showMessageDialog(null, "Saldo insuficiente");
			return false;
		}
	}
	
	public ArrayList <Transacao> extrato(Date inicio, Date fim){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		ArrayList transacoes = new ArrayList <Transacao>();
		for (Transacao transacao:historico){
			Date data = transacao.getData();
			if ((data.after(inicio) || data.equals(inicio)) && (data.before(fim) || data.equals(fim))){
				transacoes.add(transacao);
			}

		}
		return transacoes;

	}

	public String getNumero(){
		return this.numero;
	}

	public String getSenha(){
		return this.senha;
	}
	
	public double getSaldo(){
		return this.saldo;
	}
}