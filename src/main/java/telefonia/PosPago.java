package telefonia;

import java.util.GregorianCalendar;

public class PosPago extends Assinante {

    private float assinatura = 0;

    public PosPago(long cpf, String nome, long numero) {
        super(cpf, nome, numero);
    }

    public void fazerChamada(GregorianCalendar data, int duracao) {
        for (int i = 0; i < chamadas.length; i++) {
            if (chamadas[i] == null) {
                Chamada novaChamada = new Chamada(this, data, duracao);
                chamadas[i] = novaChamada;
                numChamadas++;
                assinatura = assinatura + duracao * 1.04f;
                break;
            }
        }
    }

    public void imprimirFatura(int mes, int ano) {
        System.out.println("Relatório das Chamadas:");
        for (int i = 0; i < chamadas.length && chamadas[i] != null; i++) {
            GregorianCalendar data = chamadas[i].getData();
            int mesDaChamada = data.get(GregorianCalendar.MONTH) + 1; // essa linha esta pegando o mês da variavel data, e trasformado em int.
            int anoDaChamada = data.get(GregorianCalendar.YEAR);
            int duracao = chamadas[i].getDuracao();
            if (mesDaChamada == mes && anoDaChamada == ano) {
                System.out.println(chamadas[i] + ", valor=" + duracao * 1.04);
            }
        }
        System.out.println("Total da fatura : " + assinatura);
    }
}
