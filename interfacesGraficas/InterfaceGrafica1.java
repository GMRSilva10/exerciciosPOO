import javax.swing.*;

public class InterfaceGrafica1{

	public static void main(String [] args){

		JFrame janela = new JFrame("Minha primeira janela gr�fica");
		JPanel painel = new JPanel();
		JLabel lblHello = new JLabel("Minha primeira aplica��o gr�fica");

		painel.add(lblHello);
		janela.setContentPane(painel);

		janela.setSize(400, 200);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
}