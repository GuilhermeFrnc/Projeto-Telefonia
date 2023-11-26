package telefonia;

import java.util.GregorianCalendar;

public class PosPago extends Assinante {

private double assinatura;
private int numChamadas;
private Chamada[] chamadas;
    private float creditos;
    private int numRecargas;
    private double totalCustoChamada = 0;
private double totalCustoChamadas;
   
   
    public PosPago(long cpf, String nome, int numero, double assinatura, int maxChamadas) {
        super(cpf, nome, numero);
      this.assinatura = assinatura;
      this.chamadas = new Chamada[maxChamadas];
      this.numChamadas = 0;
    }
    public void fazerChamada(GregorianCalendar data, int duracao) {
    if (numChamadas < chamadas.length) {
    double custoChamada = 1.04 * duracao;
    chamadas[numChamadas] = new Chamada (data, duracao, custoChamada);
    numChamadas++;
    System.out.println("Chamada foi registrada em" + data.getTime() + " com duração de " + duracao + " minutos.");
    } else {
    System.out.println("Não há espaço suficiente para armazenar chamadas.");
    }
    }
    public void imprimirFatura(int mes) {
    System.out.println("Assinante Pós-Pago:");
    System.out.println("Assinatura: R$" + assinatura);
   
    totalCustoChamadas = 0;
    for (int i = 0; i < numChamadas; i++) {
    Chamada chamada = chamadas[i];
    if (chamada.getData().get(GregorianCalendar.MONTH) == mes) {
    System.out.println("Data: " + chamada.getData().getTime() + " Duração: " + chamada.getDuracao() + " minutos, Valor R$" + chamada.getCustoChamada());
    Object totalcustoChamada = chamada.getCustoChamada();
    }
    }
   
double totalFatura = assinatura + totalCustoChamada;
    System.out.println("Total da fatura: R$" + totalFatura);
    }
}