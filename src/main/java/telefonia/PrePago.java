package telefonia;

import java.util.GregorianCalendar;

public class PrePago extends Assinante {

    private float creditos;
    private int numRecargas;
    private Recarga[] recargas;  //Uma lista para armazenar as informações da recarga.

    public PrePago(long cpf, String nome, long numero) {
        super(cpf, nome, numero);
        this.recargas = new Recarga[10];  // Cria uma lista para cada assinante que for iniciado na classe PrePago.
    }

    public float fazerChamada(GregorianCalendar data, int duracao) {
        for (int i = 0; i < chamadas.length; i++) {
            if (chamadas[i] == null) {
                if (creditos - (duracao * 1.45) > 0) {
                    creditos = creditos - (duracao * 1.45f);
                    Chamada novaChamada = new Chamada(this, data, duracao);
                    chamadas[i] = novaChamada;
                    numChamadas++;
                    return 0;   // tem chamadas disponiveis no vetor chamadas e tem creditos sufucientes.
                } else {
                    return 1;// nao tem creditos sufuciente.
                }
            }
        }
        return 2; // nao tem espaço disponivel no vetor chamadas.
    }

    public void imprimirFatura(int mes, int ano) {
        float totalDuracao = 0.0f;
        float totalRecargas = 0.0f;

        System.out.println("Relatório das Chamadas:");
        for (int i = 0; i < chamadas.length && chamadas[i] != null; i++) {
            GregorianCalendar data = chamadas[i].getData();
            int mesDaChamada = data.get(GregorianCalendar.MONTH) + 1; // essa linha esta pegando o mês da variavel data, e trasformado em int.
            int anoDaChamada = data.get(GregorianCalendar.YEAR);
            int duracao = chamadas[i].getDuracao();
            if (mesDaChamada == mes && anoDaChamada == ano) {
                System.out.println(chamadas[i] + ", valor=" + duracao * 1.45);
                totalDuracao += duracao;
            }
        }

        System.out.println("Relatório das Recargas:");
        for (int i = 0; i < recargas.length && recargas[i] != null; i++) {
            GregorianCalendar dataRecarga = recargas[i].getData();
            int mesDaRecarga = dataRecarga.get(GregorianCalendar.MONTH) + 1;
            int anoDaRecarga = dataRecarga.get(GregorianCalendar.YEAR);
            float valorRecarga = recargas[i].getValor();

            if (mesDaRecarga == mes && anoDaRecarga == ano) {
                System.out.println(recargas[i] + ", valor=" + valorRecarga);
                totalRecargas += valorRecarga;
            }
        }
        System.out.println("TOTAL DAS CHAMADAS: " + String.format("%.2f", totalDuracao * 1.45f));
        System.out.println("TOTAL DAS RECARGAS: " + String.format("%.2f", totalRecargas));
    }

    public void recargas(GregorianCalendar data, float valor) {
        for (int i = 0; i < recargas.length; i++) {
            if (recargas[i] == null) {
                recargas[i] = new Recarga(data, valor);
                creditos += valor;
                numRecargas++;
                break;
            }
        }
    }
}
