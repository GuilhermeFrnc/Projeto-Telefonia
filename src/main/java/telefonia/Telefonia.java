package telefonia;

import java.util.Scanner;

public class Telefonia {

    private int numPrePagos; // contador da quantidade de assinantes pre pagos. 
    private int numPosPagos;
    private Assinante[] prePagos;  // vetor para adicionar as informaçôes dos assinantes pre pagos.
    private Assinante[] posPagos;
    private Scanner scanner = new Scanner(System.in);

    public Telefonia() {

        this.numPrePagos = numPrePagos;
        this.numPosPagos = numPosPagos;
        this.posPagos = new PosPago[10];  // Cria uma lista com a capacidade de dez assinantes pós pagos.
        this.prePagos = new PrePago[10];
    }

    public void cadastrarAssinante() {

        System.out.println("Digite o tipo de assinante pre-pago(pre) ou pos-pago(pos):");
        String tipo = scanner.next();

        System.out.println("Digite o seu CPF:");
        long cpf = scanner.nextLong();

        System.out.println("digite seu nome:");
        String nome = scanner.next();

        System.out.println("Digite o seu número de telefone:");
        int numero = scanner.nextInt();

        Assinante assinante;    // cria um objeto do tipo Assinante. 

        switch (tipo) {
            case "pre":

                if (numPrePagos < 10) {
                    numPrePagos++;
                    assinante = new PrePago(cpf, nome, numero);
                    prePagos[numPrePagos] = assinante;
                } else {
                    System.out.println("Infelizmente o PrePago esta cheio.");
                }
                break;
            case "pos":
                if (numPosPagos < 10) {
                    numPosPagos++;
                    assinante = new PosPago(cpf, nome, numero);
                    posPagos[numPosPagos] = assinante;
                } else {
                    System.out.println("Infelizmente o PosPago esta cheio.");
                }
                break;
            default:
                System.out.println("Tipo de assinante inválido!");
                break;
        }
    }

    public void listarAssinante() {
        System.out.println("Assinantes PosPagos:");
        for (int i = 0; i < numPosPagos; i++) {
            System.out.println(i + " " + posPagos[i - 1]);
        }

        System.out.println("Assinantes PrePagos:");
        for (int i = 0; i < numPrePagos; i++) {
            System.out.println(i + " " + prePagos[i - 1]);
        }

    }

}
