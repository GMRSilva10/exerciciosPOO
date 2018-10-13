public class Explosao{
	
	Explosao prox;
	double [] carga = new double  [86666555];
	
	public static void main (String args[]){
		System.out.println("Estourando a Heap ");
		Explosao atual = new Explosao();
		Explosao ultimo = atual;
		Explosao temporario = new Explosao();
		ultimo.prox = temporario;
	
	}

}