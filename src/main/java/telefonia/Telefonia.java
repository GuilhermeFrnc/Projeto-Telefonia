package telefonia;

import java.util.GregorianCalendar;
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
        long numero = scanner.nextLong();

        Assinante assinante;    // cria um objeto do tipo Assinante. 

        switch (tipo) {
            case "pre":

                if (numPrePagos < 10) {
                    assinante = new PrePago(cpf, nome, numero);
                    prePagos[numPrePagos] = assinante;
                    numPrePagos++;
                } else {
                    System.out.println("Infelizmente o PrePago esta cheio.");
                }
                break;
            case "pos":
                if (numPosPagos < 10) {
                    assinante = new PosPago(cpf, nome, numero);
                    posPagos[numPosPagos] = assinante;
                    numPosPagos++;
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
            System.out.println(i + " " + posPagos[i]);
        }

        System.out.println("Assinantes PrePagos:");
        for (int i = 0; i < numPrePagos; i++) {
            System.out.println(i + " " + prePagos[i]);
        }

    }

    public PosPago localizarPosPago(long cpf) {

        for (int i = 0; i < numPosPagos; i++) {
            if (cpf == posPagos[i].getCpf()) {
                return (PosPago) posPagos[i];
            }
        }
        return null; // retorna null se nenhum assinante com o CPF fornecido foi encontrado
    }

    public PrePago localizarPrePago(long cpf) {
        for (int i = 0; i < numPrePagos; i++) {
            if (cpf == prePagos[i].getCpf()) {
                return (PrePago) prePagos[i]; // retorna o assinante se o CPF corresponder
            }
        }
        return null; // retorna null se nenhum assinante com o CPF fornecido for encontrado
    }

    public void fazerChamada() {
        System.out.println("Digite o tipo de assinante pre-pago(pre) ou pos-pago(pos):");
        String tipo = scanner.next();

        System.out.println("Digite o seu cpf:");
        long cpf = scanner.nextLong();

        if ("pre".equals(tipo)) {
            PrePago acharAssinante = localizarPrePago(cpf);
            if (acharAssinante == null) {
                System.out.println("Esse assinate nao foi encontrado.");
            } else {
                GregorianCalendar data = new GregorianCalendar();

                System.out.println("Digite a duração (em minutos) da chamada:");
                int duracao = scanner.nextInt();

                float retorno = acharAssinante.fazerChamada(data, duracao); // manda o assinate encontrado para o método fazerChamada da class PrePago.

                if (retorno == 0) {
                    System.out.println("Chamada efetuada com sucesso!");
                } else if (retorno == 1) {
                    System.out.println("O assinante não possui créditos suficientes.");
                } else {
                    System.out.println("O vetor de chamadas já está cheio.");
                }
            }

        } else if ("pos".equals(tipo)) {
            PosPago acharAssinante = localizarPosPago(cpf);
            if (acharAssinante == null) {
                System.out.println("Esse assinate nao foi encontrado.");
            } else {
                GregorianCalendar data = new GregorianCalendar();

                System.out.println("Digite a duração (em minutos) da chamada:");
                int duracao = scanner.nextInt();

                acharAssinante.fazerChamada(data, duracao);
            }
        } else {
            System.out.println("O tipo de assinate inserido nao existe!");
        }
    }

    public void imprimirFatura() {
        System.out.println("Digite o ano(yyyy) que você deseja imprimir a fatura:");
        int ano = scanner.nextInt();
        System.out.println("Digite o mês(MM) que você deseja imprimir a fatura:");
        int mes = scanner.nextInt();

        for (int i = 0; i < numPrePagos; i++) {
            System.out.println("PRE PAGOS:");
            if (prePagos[i] != null) {
                long cpf = prePagos[i].getCpf();
                PrePago assinante = localizarPrePago(cpf);
                System.out.println(prePagos[i].toString());
                assinante.imprimirFatura(mes, ano);
            }
        }

        for (int i = 0; i < numPosPagos; i++) {
            System.out.println("POS PAGOS:");
            if (posPagos[i] != null) {
                long cpf = posPagos[i].getCpf();
                PosPago assinante = localizarPosPago(cpf);
                System.out.println(posPagos[i].toString());
                assinante.imprimirFatura(mes, ano);
            }
        }
    }
    
    public void fazerRecarga() {
        System.out.println("Digite o CPF do assinante pré-pago:"); // CPF deverá ser digitado e o Scanner irá buscar
        long cpf = scanner.nextLong();
        PrePago assinantePrePago = localizarPrePago(cpf);

        if (assinantePrePago != null) { //Caso encontre o CPF, irá exibir a mensagem pedindo o valor da recarga
            System.out.println("Foi encontrado o assinante, digite o valor da recarga: ");
            float valor = scanner.nextFloat();

            GregorianCalendar data = new GregorianCalendar();

            assinantePrePago.recargas(data, valor);
        } else {
            System.out.println("Não foi possível encontrar o assinante. Recarga não realizada.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Boolean check = true;
        Telefonia telefonia = new Telefonia();

        while (check) {
            System.out.println("""
                                Menu Telefonia  
                           -------------------------
                           1- Cadastrar Assinante.
                           2- Listar Assinantes.
                           3- Fazer Chamada.
                           4- Fazer Recarga.
                           5- Imprimir Faturas.
                           6- Sair do Programa.""");
            int num = scanner.nextInt();

            switch (num) {
                case 1:
                    telefonia.cadastrarAssinante();
                    break;

                case 2:
                    telefonia.listarAssinante();
                    break;
                case 3:
                    telefonia.fazerChamada();
                    break;
                case 4:
                    telefonia.fazerRecarga();
                    break;
                case 5:
                    telefonia.imprimirFatura();
                    break;
                case 6:
                    check = false;
                    break;
            }
        }
    }

}
