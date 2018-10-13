import java.util.Scanner;
public class GregoJuliana{
		
	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe o dia");
		int dia = sc.nextInt();
		System.out.println("Informe o mes");
		int mes = sc.nextInt();
		System.out.println("Informe o ano");
		int ano = sc.nextInt();
		
		System.out.println("\n" + converteData(dia, mes, ano));
	}

	public static int converteData(int dia, int mes, int ano){
		int data_juliana = ( 1461 * ( ano + 4800 + ( mes - 14)/12 )  ) / 4;
		 data_juliana = data_juliana + ( 367 * ( mes - 2- 12 * (  ( mes - 14)/12 )  ) ) /12 ;
		data_juliana = data_juliana - ( 3 * ( ( ano + 4900 + ( mes - 14 ) / 12 ) / 100 )  ) / 4 + dia - 32075;
		
		return data_juliana;
	}

}