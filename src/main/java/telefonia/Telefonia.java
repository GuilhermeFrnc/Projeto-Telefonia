package telefonia;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class Telefonia {

    private int numPrePagos; // contador da quantidade de assinantes pre pagos. 
    private int numPosPagos;
    private Assinante[] prePagos;  // vetor para adicionar as informaçôes dos assinantes pre pagos.
    private Assinante[] posPagos;
    private Scanner scanner = new Scanner(System.in);
	private static Scanner scanner2;

    public Telefonia(int numPosPagos, int numPrePagos) {

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
                    assinante = new PrePago(cpf, nome, numero);
                    prePagos[numPrePagos] = assinante;
                    numPrePagos++;
                } else {
                    System.out.println("Infelizmente o PrePago esta cheio.");
                }
                break;
            case "pos":
                if (numPosPagos < 10) {
                    assinante = new PosPago(cpf, nome, numero, cpf, numero);
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
            if (cpf == posPagos[i - 1].getCpf()) {
                System.out.println(posPagos[i]);
                return (PosPago) posPagos[i];
            }
        }
        return null; // retorna null se nenhum assinante com o CPF fornecido for encontrado
    }

    public PrePago localizarPrePago(long cpf) {
        for (int i = 0; i < numPrePagos; i++) {
            if (cpf == prePagos[i].getCpf()) {
                System.out.println(prePagos[i]);
                return (PrePago) prePagos[i]; // retorna o assinante se o CPF corresponder
            }
        }
        return null; // retorna null se nenhum assinante com o CPF fornecido for encontrado
    }
    
    public void fazerRecarga() { // Scanner para verificar o assinante
        scanner = new Scanner(System.in);
       
        System.out.println("Digite o CPF do assinante pré-pago:"); // CPF deverá ser digitado e o Scanner irá buscar
        long cpf = scanner.nextLong();
        PrePago assinantePrePago = localizarPrePago(cpf);
       
        if (assinantePrePago != null) { //Caso encontre o CPF, irá exibir a mensagem pedindo o valor da recarga
        System.out.println("Foi encontrado o assinante, digite o valor da recarga: ");
        float valorRecarga = scanner.nextFloat();
       
        GregorianCalendar dataRecarga = new GregorianCalendar();
        Recarga recarga = new Recarga (dataRecarga, valorRecarga);
        assinantePrePago.recarregar(recarga); // Salva a data da recarga e efetua a recarga logo após
       
        System.out.println("Recarga realizada!");
        }
        else {
        System.out.println("Não foi possível encontrar o assinante. Recarga não realizada.");
        }
         }

    public static void main(String[] args) {
        scanner2 = new Scanner(System.in);
        Boolean check = true;
        Telefonia telefonia = new Telefonia(0, 0);

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
            int num = scanner2.nextInt();

            switch (num) {
                case 1:
                    telefonia.cadastrarAssinante();
                    break;

                case 2:
                    telefonia.listarAssinante();
                    break;
                case 3:
                    System.out.println("em preparo.");
                    break;
                case 4:
                    System.out.println("em preparo.");
                    break;
                case 5:
                    System.out.println("em preparo.");
                    break;
                case 6:
                    check = false;
                    break;
            }
        }
    }

}
