import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.*;


public class InterfaceGrafica2 {
		
	public static void main (String args []){
	

		JFrame janela = new JFrame("Exercicio2");
		JPanel jp = new JPanel();
		JPanel painelA = new JPanel();
		JLabel lblPhone = new JLabel("Enter your phone number: ");
		JTextField jtfTelefone = new JTextField();
		JLabel lblName = new JLabel("Enter your name: ");
		JTextField jtfName = new JTextField();
		JButton btnOK = new JButton("OK");
		JButton btnCancelar = new JButton("Cancelar");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
	
		jp.setLayout(new GridLayout(3,2));
		jp.add(lblPhone);
		jp.add(jtfTelefone);
		jp.add(lblName);
		jp.add(jtfName);
		jp.add(btnOK);
		jp.add(btnCancelar);
		
		painelA.add(jp);
		janela.setContentPane(painelA);
		janela.setVisible(true);
		janela.setSize(400, 300);
		janela.setLocation((screenSize.width-400)/2, (screenSize.height-300)/2);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
