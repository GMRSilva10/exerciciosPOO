import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class CaixaEletronico{

	public static ArrayList <Conta> contas = new ArrayList <Conta>();


	public static void main (String [] args){
	
		int opc;

		do{
		opc = Integer.parseInt(JOptionPane.showInputDialog("\n  Escolhe uma opção: " + "\n\nDigite 1 para acessar sua conta" + "\nDigite 2 para criar nova conta" + 		"\nDigite 0 para sair" + "\n"));

		switch(opc){
			case 1:
				CaixaEletronico cx = new CaixaEletronico();
				String validaConta = JOptionPane.showInputDialog("Número da conta: ");
				String validaSenha = JOptionPane.showInputDialog("Senha: ");
				Conta conta = cx.autentica(validaConta, validaSenha);
				if (conta != null){
					int menu;
					do{
					menu = Integer.parseInt(JOptionPane.showInputDialog("\n Escolha uma opção: " + "\n\n1 - Consultar Saldo" + "\n2 - Sacar" +
					 "\n3 - Depositar" + "\n4 - Efetuar Pagamento" + "\n5 - Extrato" + "\n0 - Sair"));

					switch(menu){
						case 1:
							JOptionPane.showMessageDialog(null, "Seu saldo atual é de " + conta.getSaldo() + " reais");
							break;
						case 2:
							double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do saque: "));
							conta.efetuarSaque(valor);
							break;
						case 3:
							valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor para depósito: "));
							conta.efetuarDeposito(valor);
							break;
						case 4:
							String boleto = JOptionPane.showInputDialog("Boleto:");
							valor =  Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do boleto: "));
							conta.efetuarPagamento(boleto, valor);
							break;
						case 5:
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
							Date inicio = new Date();
							Date fim = new Date();
		
							try{
								String data = JOptionPane.showInputDialog("Digite a data inicial no formato dd/MM/yyyy");
								inicio = sdf.parse(data);
								System.out.print("\nTransações realizadas entre " + sdf.format(inicio));
							}catch(ParseException e){
								JOptionPane.showMessageDialog(null, "Digite a data no formato correto: dd/MM/yyyy");
							}
		
							try{
								String data = JOptionPane.showInputDialog("Digite a data final no formato dd/MM/yyyy");
								fim = sdf.parse(data);
								System.out.println(" e " + sdf.format(fim) + ": \n\n");
							}catch(ParseException e){
								System.out.println("Digite a data no format correto: dd/MM/yyyy");
							}

							ArrayList <Transacao> lista = new ArrayList <Transacao> ();
							lista = conta.extrato(inicio, fim);
							JOptionPane.showMessageDialog(null, "Extrato exibido no prompt de comando");

							for (Transacao t:lista){
								if(t instanceof Deposito){
									System.out.println("Depósito: ");
									System.out.println(t.getValor());
									System.out.println(formatar.format(t.getData()) + "\n");
								}else if(t instanceof Saque){
									System.out.println("Saque: ");
									System.out.println(t.getValor());
									System.out.println(formatar.format(t.getData()) + "\n");
								}else{
									System.out.println("Pagamento: ");
									System.out.println(t.getValor());
									System.out.println(formatar.format(t.getData()) + "\n");
								}
			

		
							}
							break;
						case 0:
							break;
							
						default:
							JOptionPane.showMessageDialog(null, "Opção inválida!");
					}
					}
					while(menu!=0);
				}else{
					JOptionPane.showMessageDialog(null, "Conta inexistente ou dados incorretos");
				}
				break;
			case 0:
				System.exit(0);
			case 2:
				String numeroConta = JOptionPane.showInputDialog("Número da conta: ");
				String senha = JOptionPane.showInputDialog("Senha: ");
				contas.add(new Conta(numeroConta, senha));
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Inválida");

			}			
		}
		while(opc != 0);

	}
	
	public Conta autentica(String numeroConta, String numeroSenha){
		String numero = numeroConta;
		String senha = numeroSenha;
		Conta conta = null;
		for(Conta c: this.contas){
			if(c.getNumero().equals(numero) && c.getSenha().equals(senha)){
				JOptionPane.showMessageDialog(null, "Dados autenticados com sucesso");
				conta = c;
			}
							
		}
		return conta;
		
	}

}