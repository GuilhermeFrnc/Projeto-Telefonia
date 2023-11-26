package telefonia;

import java.util.GregorianCalendar;

public class PrePago extends Assinante {

    private float credito;
    private int numRecargas;
    private float[] recargas;


    public PrePago(long cpf, String nome, int numero) {
        super(cpf, nome, numero);
    }

//Método para a recarga
	public void recarregar(GregorianCalendar data, float valor) {
		
		if (numRecargas < recargas.length) {     // IF para verificar se o número de recargas é menor que o tamanho do vetor Recargas.
			
			recargas[numRecargas] = valor;
			
			numRecargas++;
			credito += valor;
			
			System.out.println("Recarga acaba de ser registrada!");
		}
		else {
			System.out.println("Não foi possível efetuar a recarga. O limite foi atingido.");
		
	}
  }
}